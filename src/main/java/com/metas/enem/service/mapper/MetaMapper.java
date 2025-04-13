package com.metas.enem.service.mapper;

import com.metas.enem.domain.Aluno;
import com.metas.enem.domain.Meta;
import com.metas.enem.service.dto.AlunoDTO;
import com.metas.enem.service.dto.MetaDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Meta} and its DTO {@link MetaDTO}.
 */
@Mapper(componentModel = "spring")
public interface MetaMapper extends EntityMapper<MetaDTO, Meta> {
    @Mapping(target = "aluno", source = "aluno", qualifiedByName = "alunoNome")
    MetaDTO toDto(Meta s);

    @Named("alunoNome")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    AlunoDTO toDtoAlunoNome(Aluno aluno);
}
