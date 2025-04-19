package br.com.sistemalima.app.modelo.core.usercase.impl;

import br.com.sistemalima.app.modelo.core.domain.ModeloRequest;
import br.com.sistemalima.app.modelo.core.domain.ModeloResponse;
import br.com.sistemalima.app.modelo.core.errors.SummerException;
import br.com.sistemalima.app.modelo.core.usercase.PostModeloUserCase;
import br.com.sistemalima.app.modelo.core.usercase.mapper.ModeloDomainMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostModeloUserCaseImpl implements PostModeloUserCase {

    private final ModeloDomainMapper modeloDomainMapper; // Depende da abstração, não da implementação

    // Ainda esta devolvendo o mesmo objeto, mas o correto seria persistir no banco de dados

    @Override
    public ModeloResponse execute(ModeloRequest entity) throws SummerException {
        final var modelo = modeloDomainMapper.toDomain(entity);
        return modeloDomainMapper.toResponse(modelo);
    }
}
