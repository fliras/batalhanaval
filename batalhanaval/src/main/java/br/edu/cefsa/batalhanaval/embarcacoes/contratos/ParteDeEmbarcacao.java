package br.edu.cefsa.batalhanaval.embarcacoes.contratos;

public interface ParteDeEmbarcacao {
    public void associaEmbarcacao(Embarcacao embarcacaoAssociada);
    public void recebeDisparo();
    public boolean verificaSeEstaOperante();
}
