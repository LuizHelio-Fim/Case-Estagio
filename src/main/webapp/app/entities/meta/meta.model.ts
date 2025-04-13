import { IAluno } from 'app/entities/aluno/aluno.model';

export interface IMeta {
  id: number;
  linguagem?: number | null;
  humanas?: number | null;
  natureza?: number | null;
  matematica?: number | null;
  aluno?: Pick<IAluno, 'id' | 'nome'> | null;
}

export type NewMeta = Omit<IMeta, 'id'> & { id: null };
