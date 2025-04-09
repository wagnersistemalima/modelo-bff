package br.com.sistemalima.app.modelo.core.usercase;

import br.com.sistemalima.app.modelo.core.errors.SummerException;

public interface UserCase<R, A> {

    R execute(final A entity) throws SummerException;
}
