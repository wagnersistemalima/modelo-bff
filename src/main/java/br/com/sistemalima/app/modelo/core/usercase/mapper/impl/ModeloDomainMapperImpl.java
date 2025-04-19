package br.com.sistemalima.app.modelo.core.usercase.mapper.impl;

import br.com.sistemalima.app.modelo.core.domain.Modelo;
import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.core.errors.SummerParseException;
import br.com.sistemalima.app.modelo.core.usercase.mapper.ModeloDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class ModeloDomainMapperImpl implements ModeloDomainMapper {
    @Override
    public ModeloResponse toResponse(Modelo modelo) throws SummerParseException {
        return ModeloResponse.create(modelo);
    }

    @Override
    public Modelo toDomain(ModeloRequest modeloRequest) throws SummerParseException {
        return Modelo.create(modeloRequest.getName());
    }
}
