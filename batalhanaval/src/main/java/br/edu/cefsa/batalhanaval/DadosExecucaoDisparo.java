package br.edu.cefsa.batalhanaval;

public class DadosExecucaoDisparo {
    private final Embarcacao embarcacao;
    private final TiposDeTiro tipoTiro;
    private final Coordenadas posicaoAlvo;
    private final Tabuleiro tabuleiroAlvo;
    
    public DadosExecucaoDisparo(Embarcacao embarcacao, TiposDeTiro tipoTiro, Coordenadas posicaoAlvo, Tabuleiro tabuleiroAlvo) {
        this.embarcacao = embarcacao;
        this.tipoTiro = tipoTiro;
        this.posicaoAlvo = posicaoAlvo;
        this.tabuleiroAlvo = tabuleiroAlvo;
    }
    
    public Embarcacao obtemEmbarcacao() {
        return embarcacao;
    }
    
    public TiposDeTiro obtemTipoTiro() {
        return tipoTiro;
    }
    
    public Coordenadas obtemPosicaoAlvo() {
        return posicaoAlvo;
    }
    
    public Tabuleiro obtemTabuleiroAlvo() {
        return tabuleiroAlvo;
    }
}
