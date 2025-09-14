package br.edu.cefsa.batalhanaval.tabuleiro.contratos;

import br.edu.cefsa.batalhanaval.embarcacoes.contratos.ParteDeEmbarcacao;

public interface PosicaoTabuleiro {
    public void atribuiParteDeEmbarcacao(ParteDeEmbarcacao parteDeEmbarcacao);
    public void registraDisparo();
    public boolean verificaSeFoiAtingida();
    public boolean verificaSeEstaVazia();
    public Coordenadas obtemCoordenadas();
}
