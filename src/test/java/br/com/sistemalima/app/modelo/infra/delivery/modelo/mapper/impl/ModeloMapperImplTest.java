package br.com.sistemalima.app.modelo.infra.delivery.modelo.mapper.impl;

import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloRequestDTO;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ModeloMapperImplTest {

    @InjectMocks
    private ModeloMapperImpl mapper;

    @Test
    void testToRequest() {
        // Arrange
        ModeloRequestDTO requestDTO = new ModeloRequestDTO("Teste");

        // Act
        ModeloRequest result = mapper.toRequest(requestDTO);

        // Assert
        assertEquals("Teste", result.getName());
    }

    @Test
    void testToResponseDTO() {
        // Arrange
        ModeloResponse response = ModeloResponse.create(1L, "Teste");

        // Act
        ModeloResponseDTO result = mapper.toResponseDTO(response);

        // Assert
        assertEquals(1L, result.id());
        assertEquals("Teste", result.name());
    }

}