package br.edu.cefsa.batalhanaval.embarcacoes.contratos;

import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;

public interface ParteDeEmbarcacao {
    public void associaEmbarcacao(EmbarcacaoPadrao embarcacaoAssociada);
    public void recebeDisparo();
    public boolean verificaSeEstaOperante();
}
