package com.metas.enem.domain;

import static com.metas.enem.domain.AlunoTestSamples.*;
import static com.metas.enem.domain.MetaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.metas.enem.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AlunoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Aluno.class);
        Aluno aluno1 = getAlunoSample1();
        Aluno aluno2 = new Aluno();
        assertThat(aluno1).isNotEqualTo(aluno2);

        aluno2.setId(aluno1.getId());
        assertThat(aluno1).isEqualTo(aluno2);

        aluno2 = getAlunoSample2();
        assertThat(aluno1).isNotEqualTo(aluno2);
    }

    @Test
    void metaTest() {
        Aluno aluno = getAlunoRandomSampleGenerator();
        Meta metaBack = getMetaRandomSampleGenerator();

        aluno.setMeta(metaBack);
        assertThat(aluno.getMeta()).isEqualTo(metaBack);
        assertThat(metaBack.getAluno()).isEqualTo(aluno);

        aluno.meta(null);
        assertThat(aluno.getMeta()).isNull();
        assertThat(metaBack.getAluno()).isNull();
    }
}
