package br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos;

import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;
import br.edu.cefsa.batalhanaval.tabuleiro.Coordenadas;

public class DadosExecucaoDisparo {
    private final EmbarcacaoPadrao embarcacao;
    private final TiposDeTiro tipoTiro;
    private final Coordenadas posicaoAlvo;
    private final Tabuleiro tabuleiroAlvo;
    
    public DadosExecucaoDisparo(EmbarcacaoPadrao embarcacao, TiposDeTiro tipoTiro, Coordenadas posicaoAlvo, Tabuleiro tabuleiroAlvo) {
        this.embarcacao = embarcacao;
        this.tipoTiro = tipoTiro;
        this.posicaoAlvo = posicaoAlvo;
        this.tabuleiroAlvo = tabuleiroAlvo;
    }
    
    public EmbarcacaoPadrao obtemEmbarcacao() {
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
