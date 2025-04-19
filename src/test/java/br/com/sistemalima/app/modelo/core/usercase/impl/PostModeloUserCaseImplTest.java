package br.com.sistemalima.app.modelo.core.usercase.impl;

import br.com.sistemalima.app.modelo.core.domain.Modelo;
import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.core.errors.SummerException;
import br.com.sistemalima.app.modelo.core.usercase.mapper.ModeloDomainMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostModeloUserCaseImplTest {

    @InjectMocks
    private PostModeloUserCaseImpl postModeloUserCase;

    @Mock
    private ModeloDomainMapper modeloDomainMapper;

    @Test
    void testExecuteWithValidId() throws SummerException {
        // Arrange
        ModeloRequest request = ModeloRequest.create("Modelo Teste");

        var domainModel = Modelo.create("Modelo Teste");

        var domainModelResponse = ModeloResponse.create(domainModel);
        when(modeloDomainMapper.toDomain(request)).thenReturn(domainModel);
        when(modeloDomainMapper.toResponse(domainModel)).thenReturn(domainModelResponse);

        // Act
        ModeloResponse response = postModeloUserCase.execute(request);

        // Assert
        assertNotNull(response);
        assertEquals(null, response.getId());
        verify(modeloDomainMapper).toDomain(request);
        verify(modeloDomainMapper).toResponse(domainModel);
    }
}