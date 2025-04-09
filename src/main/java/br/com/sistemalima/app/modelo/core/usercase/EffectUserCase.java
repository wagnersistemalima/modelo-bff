package br.com.sistemalima.app.modelo.core.usercase;

import br.com.sistemalima.app.modelo.core.errors.SummerException;

public interface EffectUserCase<R> {

    R execute() throws SummerException;

}
