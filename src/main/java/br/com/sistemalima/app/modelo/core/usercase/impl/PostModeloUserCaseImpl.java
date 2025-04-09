package br.com.sistemalima.app.modelo.core.usercase.impl;

import br.com.sistemalima.app.modelo.core.ModeloRequest;
import br.com.sistemalima.app.modelo.core.ModeloResponse;
import br.com.sistemalima.app.modelo.core.errors.SummerException;
import br.com.sistemalima.app.modelo.core.usercase.PostModeloUserCase;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.converter.ModeloConverter;
import org.springframework.stereotype.Service;

@Service
public class PostModeloUserCaseImpl implements PostModeloUserCase {

    // Ainda esta devolvendo o mesmo objeto, mas o correto seria persistir no banco de dados

    @Override
    public ModeloResponse execute(ModeloRequest entity) throws SummerException {
        final var modelo = ModeloConverter.toDomain(entity);
        if (modelo.getId() == null) {
            throw new SummerException("Modelo não pode ser nulo. ID fornecido: " + modelo.getId());
        }
        return ModeloConverter.toResponse(modelo);
    }
}
