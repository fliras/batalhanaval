package br.edu.cefsa.batalhanaval.tabuleiro;

import br.edu.cefsa.batalhanaval.embarcacoes.ParteDeEmbarcacao;

public class PosicaoTabuleiro {
    private Coordenadas coordenadas;
    private boolean atingida = false;
    private ParteDeEmbarcacao parteDeEmbarcacao;
    
    public PosicaoTabuleiro(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public void atribuiParteDeEmbarcacao(ParteDeEmbarcacao parteDeEmbarcacao) {
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
