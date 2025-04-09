package br.com.sistemalima.app.modelo.core.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ErroView {

    private final LocalDateTime timestamp;

    private final Integer status;

    private final String error;

    private final String message;

    private final String path;
}
