package br.com.sistemalima.app.modelo.core.usercase;

import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.core.errors.SummerException;

public interface PostModeloUserCase extends UserCase<ModeloResponse, ModeloRequest> {

    @Override
    ModeloResponse execute(final ModeloRequest entity) throws SummerException;
}
