package br.com.sistemalima.app.modelo.infra.delivery.modelo.mapper;

import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloRequestDTO;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloResponseDTO;

public interface ModeloMapper {
    ModeloRequest toRequest(ModeloRequestDTO modeloRequestDTO);
    ModeloResponseDTO toResponseDTO(ModeloResponse modeloResponse);
}
