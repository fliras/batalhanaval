package br.edu.cefsa.batalhanaval;

import java.util.List;

public class Jogador {
    private List<Embarcacao> embarcacoes;
    private Tabuleiro tabuleiro;
    
    public Jogador(List<Embarcacao> embarcacoes, Tabuleiro tabuleiro) {
        this.embarcacoes = embarcacoes;
        this.tabuleiro = tabuleiro;
    }
    
    protected void atribuiTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    protected void atribuiEmbarcacoes(List<Embarcacao> embarcacoes) {
        this.embarcacoes = embarcacoes;
    }
    
    public Tabuleiro obtemTabuleiro() {
        return tabuleiro;
    }
    
    public Embarcacao[] obtemEmbarcacoes() {
        return (Embarcacao[])embarcacoes.toArray();
    }
}
