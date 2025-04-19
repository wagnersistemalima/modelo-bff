package br.com.sistemalima.app.modelo.infra.delivery.modelo;

import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.core.usercase.PostModeloUserCase;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloRequestDTO;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.mapper.ModeloMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.IntegrationTestUtil.fromJsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ModeloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Mock
    ModeloMapper modeloMapper;

    @Mock
    PostModeloUserCase postModeloUserCase;

    @Test
    void testPostModeloIntegration() throws Exception {
        // Arrange
        ModeloRequestDTO requestDTO = new ModeloRequestDTO("Teste");

        ModeloRequest  modeloRequest = ModeloRequest.create("Teste");

        var modeloResponse = ModeloResponse.create(null, "Teste");

        Mockito.when(modeloMapper.toRequest(requestDTO)).thenReturn(modeloRequest);

        Mockito.when(postModeloUserCase.execute(Mockito.any())).thenReturn(modeloResponse);

        // Act & Assert
        mockMvc.perform(post("/modelos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().json(fromJsonPath("json/modelo_response.json")));
    }
}