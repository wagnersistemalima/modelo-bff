package br.com.sistemalima.app.modelo.infra.delivery.modelo.dto;

import br.com.sistemalima.app.modelo.core.ModeloResponse;

public record ModeloResponseDTO(
        Long id,
        String name
) {
    public static ModeloResponseDTO create(ModeloResponse modeloResponse) {
        return new ModeloResponseDTO(modeloResponse.getId(), modeloResponse.getName());
    }
}
