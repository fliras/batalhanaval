package br.edu.cefsa.batalhanaval.main;

import br.edu.cefsa.batalhanaval.embarcacoes.contratos.Embarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Tabuleiro;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Embarcacao> embarcacoes;
    private Tabuleiro tabuleiro;
    
    public Jogador(String nome, List<Embarcacao> embarcacoes, Tabuleiro tabuleiro) {
        this.nome = nome;
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
        return embarcacoes.toArray(Embarcacao[]::new); // retorna um array para não adicionar embarcações à List<> original.
    }
    
    public String obtemNome() {
        return nome;
    }
}
