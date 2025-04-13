package com.metas.enem.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.metas.enem.domain.Meta} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MetaDTO implements Serializable {

    private Long id;

    @NotNull
    @Max(value = 1000)
    private Integer linguagem;

    @NotNull
    @Max(value = 1000)
    private Integer humanas;

    @NotNull
    @Max(value = 1000)
    private Integer natureza;

    @NotNull
    @Max(value = 1000)
    private Integer matematica;

    private AlunoDTO aluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(Integer linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getHumanas() {
        return humanas;
    }

    public void setHumanas(Integer humanas) {
        this.humanas = humanas;
    }

    public Integer getNatureza() {
        return natureza;
    }

    public void setNatureza(Integer natureza) {
        this.natureza = natureza;
    }

    public Integer getMatematica() {
        return matematica;
    }

    public void setMatematica(Integer matematica) {
        this.matematica = matematica;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MetaDTO)) {
            return false;
        }

        MetaDTO metaDTO = (MetaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, metaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MetaDTO{" +
            "id=" + getId() +
            ", linguagem=" + getLinguagem() +
            ", humanas=" + getHumanas() +
            ", natureza=" + getNatureza() +
            ", matematica=" + getMatematica() +
            ", aluno=" + getAluno() +
            "}";
    }
}
