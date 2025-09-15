package br.edu.cefsa.batalhanaval.core.embarcacoes;

import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.ParteDeEmbarcacao;
import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.Embarcacao;

public class ParteDeEmbarcacaoPadrao implements ParteDeEmbarcacao {
    private Embarcacao embarcacaoAssociada;
    private boolean estaOperante;
    
    public ParteDeEmbarcacaoPadrao() {
        this.estaOperante = true;
    }
    
    @Override
    public void associaEmbarcacao(Embarcacao embarcacaoAssociada) {
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
