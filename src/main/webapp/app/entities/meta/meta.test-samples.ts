import { IMeta, NewMeta } from './meta.model';

export const sampleWithRequiredData: IMeta = {
  id: 17187,
  linguagem: 350,
  humanas: 252,
  natureza: 384,
  matematica: 136,
};

export const sampleWithPartialData: IMeta = {
  id: 15622,
  linguagem: 741,
  humanas: 443,
  natureza: 545,
  matematica: 648,
};

export const sampleWithFullData: IMeta = {
  id: 32703,
  linguagem: 176,
  humanas: 12,
  natureza: 904,
  matematica: 348,
};

export const sampleWithNewData: NewMeta = {
  linguagem: 497,
  humanas: 850,
  natureza: 991,
  matematica: 385,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
