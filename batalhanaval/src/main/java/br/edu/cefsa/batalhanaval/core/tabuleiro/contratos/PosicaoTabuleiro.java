package br.edu.cefsa.batalhanaval.core.tabuleiro.contratos;

import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.ParteDeEmbarcacao;

public interface PosicaoTabuleiro {
    public void atribuiParteDeEmbarcacao(ParteDeEmbarcacao parteDeEmbarcacao);
    public void registraDisparo();
    public boolean verificaSeFoiAtingida();
    public boolean verificaSeEstaVazia();
    public Coordenadas obtemCoordenadas();
}
