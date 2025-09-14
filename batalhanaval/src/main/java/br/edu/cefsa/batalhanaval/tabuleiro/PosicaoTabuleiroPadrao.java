package br.edu.cefsa.batalhanaval.tabuleiro;

import br.edu.cefsa.batalhanaval.embarcacoes.ParteDeEmbarcacaoPadrao;

public class PosicaoTabuleiro {
    private Coordenadas coordenadas;
    private boolean atingida = false;
    private ParteDeEmbarcacaoPadrao parteDeEmbarcacao;
    
    public PosicaoTabuleiro(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public void atribuiParteDeEmbarcacao(ParteDeEmbarcacaoPadrao parteDeEmbarcacao) {
        this.parteDeEmbarcacao = parteDeEmbarcacao;
    }
    
    public void registraDisparo() {
        if (!atingida) {
            this.atingida = true;
            if (!verificaSeEstaVazia()) {
                this.parteDeEmbarcacao.recebeDisparo();
            }
        }
    }
    
    public boolean verificaSeFoiAtingida() {
        return this.atingida;
    }
    
    public boolean verificaSeEstaVazia() {
        return parteDeEmbarcacao == null;
    }
    
    public Coordenadas obtemCoordenadas() {
        return coordenadas;
    }
}
