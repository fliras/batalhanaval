package br.edu.cefsa.batalhanaval.main;

import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.TabuleiroPadrao;
import java.util.List;

public class Jogador {
    private List<EmbarcacaoPadrao> embarcacoes;
    private TabuleiroPadrao tabuleiro;
    
    public Jogador(List<EmbarcacaoPadrao> embarcacoes, TabuleiroPadrao tabuleiro) {
        this.embarcacoes = embarcacoes;
        this.tabuleiro = tabuleiro;
    }
    
    protected void atribuiTabuleiro(TabuleiroPadrao tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    protected void atribuiEmbarcacoes(List<EmbarcacaoPadrao> embarcacoes) {
        this.embarcacoes = embarcacoes;
    }
    
    public TabuleiroPadrao obtemTabuleiro() {
        return tabuleiro;
    }
    
    public EmbarcacaoPadrao[] obtemEmbarcacoes() {
        return embarcacoes.toArray(EmbarcacaoPadrao[]::new); // retorna um array para não adicionar embarcações à List<> original.
    }
}
