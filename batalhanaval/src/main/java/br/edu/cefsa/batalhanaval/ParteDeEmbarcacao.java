package br.edu.cefsa.batalhanaval;

public class ParteDeEmbarcacao {
    private Embarcacao embarcacaoAssociada;
    private boolean estaOperante;
    
    public ParteDeEmbarcacao() {
        this.estaOperante = true;
    }
    
    protected void associaEmbarcacao(Embarcacao embarcacaoAssociada) {
        this.embarcacaoAssociada = embarcacaoAssociada;
    }
    
    public void recebeDisparo() {
        this.estaOperante = false;
        this.embarcacaoAssociada.atualizaEstado();
    }
    
    public boolean verificaSeEstaOperante() {
        return this.estaOperante;
    }
}
