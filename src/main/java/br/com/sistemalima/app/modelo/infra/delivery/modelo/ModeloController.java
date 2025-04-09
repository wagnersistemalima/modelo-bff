package br.com.sistemalima.app.modelo.infra.delivery.modelo;

import br.com.sistemalima.app.modelo.core.usercase.PostModeloUserCase;
import br.com.sistemalima.app.modelo.infra.delivery.dto.BffResponse;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.converter.ModeloConverter;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloRequestDTO;
import br.com.sistemalima.app.modelo.infra.delivery.modelo.dto.ModeloResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@RestController
@RequestMapping("/modelos")
@RequiredArgsConstructor
public class ModeloController {

    private final PostModeloUserCase postModeloUserCase;

    @PostMapping
    public ResponseEntity<BffResponse<ModeloResponseDTO>> postModelo(@RequestBody ModeloRequestDTO modeloRequestDTO, UriComponentsBuilder uriBuilder) {

        final var modeloRequest = ModeloConverter.toRequest(modeloRequestDTO);

        final var modeloResponse = postModeloUserCase.execute(modeloRequest);

        final var modeloResponseDTO = ModeloConverter.toResponseDTO(modeloResponse);

        URI uri = uriBuilder.path("/modelos/{id}").buildAndExpand(modeloResponse.getId()).toUri();

        return ResponseEntity.created(uri)
                .body(new BffResponse<>(modeloResponseDTO));
    }
}
