package br.com.sistemalima.app.modelo.core.usercase.mapper;

import br.com.sistemalima.app.modelo.core.domain.Modelo;
import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.core.errors.SummerParseException;

public interface ModeloDomainMapper {

    ModeloResponse toResponse(Modelo modelo) throws SummerParseException;

    Modelo toDomain(ModeloRequest modelo) throws SummerParseException;
}
