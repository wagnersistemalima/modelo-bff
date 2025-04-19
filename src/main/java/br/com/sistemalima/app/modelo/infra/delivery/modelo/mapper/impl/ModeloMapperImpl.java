package br.com.sistemalima.app.modelo.infra.delivery.modelo.mapper.impl;

import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloRequestDTO;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloResponseDTO;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.mapper.ModeloMapper;
import org.springframework.stereotype.Component;

@Component
public class ModeloMapperImpl implements ModeloMapper {

    @Override
    public ModeloRequest toRequest(ModeloRequestDTO modeloRequestDTO) {
        return ModeloRequest.create(modeloRequestDTO.name());
    }

    @Override
    public ModeloResponseDTO toResponseDTO(ModeloResponse modeloResponse) {
        return ModeloResponseDTO.create(modeloResponse);
    }
}
