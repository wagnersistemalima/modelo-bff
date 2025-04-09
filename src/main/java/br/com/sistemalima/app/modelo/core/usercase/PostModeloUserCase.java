package br.com.sistemalima.app.modelo.core.usercase;

import br.com.sistemalima.app.modelo.core.ModeloRequest;
import br.com.sistemalima.app.modelo.core.ModeloResponse;
import br.com.sistemalima.app.modelo.core.errors.SummerException;

public interface PostModeloUserCase extends UserCase<ModeloResponse, ModeloRequest> {

    @Override
    ModeloResponse execute(final ModeloRequest entity) throws SummerException;
}
