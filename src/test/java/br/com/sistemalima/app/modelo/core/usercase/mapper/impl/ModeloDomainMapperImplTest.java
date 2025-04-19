package br.com.sistemalima.app.modelo.core.usercase.mapper.impl;

import br.com.sistemalima.app.modelo.core.domain.Modelo;
import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.core.errors.SummerParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ModeloDomainMapperImplTest {

    @InjectMocks
    private ModeloDomainMapperImpl mapper;


    @Test
    void testToResponse() throws SummerParseException {
        // Arrange
        Modelo modelo = Modelo.create("Teste");

        // Act
        ModeloResponse response = mapper.toResponse(modelo);

        // Assert
        assertNotNull(response);
        assertEquals("Teste", response.getName());
    }

    @Test
    void testToDomain() throws SummerParseException {
        // Arrange
        ModeloRequest request = ModeloRequest.create("Teste");

        // Act
        Modelo result = mapper.toDomain(request);

        // Assert
        assertNotNull(result);
        assertEquals("Teste", result.getName());
    }

}