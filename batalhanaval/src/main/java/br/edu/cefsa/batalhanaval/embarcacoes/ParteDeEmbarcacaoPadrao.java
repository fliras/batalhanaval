package br.edu.cefsa.batalhanaval.embarcacoes;

import br.edu.cefsa.batalhanaval.embarcacoes.contratos.ParteDeEmbarcacao;

public class ParteDeEmbarcacaoPadrao implements ParteDeEmbarcacao {
    private EmbarcacaoPadrao embarcacaoAssociada;
    private boolean estaOperante;
    
    public ParteDeEmbarcacaoPadrao() {
        this.estaOperante = true;
    }
    
    @Override
    public void associaEmbarcacao(EmbarcacaoPadrao embarcacaoAssociada) {
        this.embarcacaoAssociada = embarcacaoAssociada;
    }
    
    @Override
    public void recebeDisparo() {
        this.estaOperante = false;
        this.embarcacaoAssociada.atualizaEstado();
    }
    
    @Override
    public boolean verificaSeEstaOperante() {
        return this.estaOperante;
    }
}
