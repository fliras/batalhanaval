package br.edu.cefsa.batalhanaval;

public class PosicaoTabuleiro {
    private boolean atingida = false;
    private ParteDeEmbarcacao parteDeEmbarcacao;
    
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
}
