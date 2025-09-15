package br.edu.cefsa.batalhanaval.core.tabuleiro;

import br.edu.cefsa.batalhanaval.core.tabuleiro.contratos.Coordenadas;
import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.ParteDeEmbarcacao;
import br.edu.cefsa.batalhanaval.core.tabuleiro.contratos.PosicaoTabuleiro;

public class PosicaoTabuleiroPadrao implements PosicaoTabuleiro {
    private Coordenadas coordenadas;
    private boolean atingida = false;
    private ParteDeEmbarcacao parteDeEmbarcacao;
    
    public PosicaoTabuleiroPadrao(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    @Override
    public void atribuiParteDeEmbarcacao(ParteDeEmbarcacao parteDeEmbarcacao) {
        this.parteDeEmbarcacao = parteDeEmbarcacao;
    }
    
    @Override
    public void registraDisparo() {
        if (!atingida) {
            this.atingida = true;
            if (!verificaSeEstaVazia()) {
                this.parteDeEmbarcacao.recebeDisparo();
            }
        }
    }
    
    @Override
    public boolean verificaSeFoiAtingida() {
        return this.atingida;
    }
    
    @Override
    public boolean verificaSeEstaVazia() {
        return parteDeEmbarcacao == null;
    }
    
    @Override
    public Coordenadas obtemCoordenadas() {
        return coordenadas;
    }
}
