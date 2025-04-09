package br.com.sistemalima.app.modelo.infra.delivery.modelo.converter;

import br.com.sistemalima.app.modelo.core.Modelo;
import br.com.sistemalima.app.modelo.core.ModeloRequest;
import br.com.sistemalima.app.modelo.core.ModeloResponse;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloRequestDTO;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloResponseDTO;

public class ModeloConverter {

    public static ModeloRequest toRequest(ModeloRequestDTO modeloRequestDTO) {
        return ModeloRequest.create(modeloRequestDTO.name());
    }

    public static Modelo toDomain(ModeloRequest modeloRequest) {
        return Modelo.create(modeloRequest.getName());
    }

    public static ModeloResponse toResponse(Modelo modelo) {
        return ModeloResponse.create(modelo);
    }

    public static ModeloResponseDTO toResponseDTO(ModeloResponse modeloResponse) {
        return ModeloResponseDTO.create(modeloResponse);
    }
}
