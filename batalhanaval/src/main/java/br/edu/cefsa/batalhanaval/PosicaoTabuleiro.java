package br.edu.cefsa.batalhanaval;

public class PosicaoTabuleiro {
    private boolean atingida;
    private ParteDeEmbarcacao parteDeEmbarcacao;
    
    public PosicaoTabuleiro() {
        this.atingida = false;
    }
    
    public PosicaoTabuleiro(ParteDeEmbarcacao parteDeEmbarcacao) {
        this.atingida = false;
        this.parteDeEmbarcacao = parteDeEmbarcacao;
    }
    
    public void registraDisparo() {
        if (!atingida) {
            this.atingida = true;
            if (parteDeEmbarcacao != null) {
                this.parteDeEmbarcacao.recebeDisparo();
            }
        }
    }
    
    public boolean verificaSeFoiAtingida() {
        return this.atingida;
    }
}
