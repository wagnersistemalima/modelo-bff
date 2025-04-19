package br.com.sistemalima.app.modelo.core.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ModeloResponse {

    private final Long id;

    private final String name;

    public static ModeloResponse create(Modelo modelo) {
        return new ModeloResponse(modelo.getId(), modelo.getName());
    }

    public static ModeloResponse create(Long id, String name) {
        return new ModeloResponse(id, name);
    }
}
