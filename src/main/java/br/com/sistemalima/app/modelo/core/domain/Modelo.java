package br.com.sistemalima.app.modelo.core.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Modelo {

    private Long id = null;

    private final String name;

    public static Modelo create(String nome) {
        return new Modelo(nome);
    }
}
