package br.com.sistemalima.app.modelo.core;

import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloRequestDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ModeloRequest {

    private final String name;

    public static ModeloRequest create(String name) {
        return new ModeloRequest(name);
    }
}
