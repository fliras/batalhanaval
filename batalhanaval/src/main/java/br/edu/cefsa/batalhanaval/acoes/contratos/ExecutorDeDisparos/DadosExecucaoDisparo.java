package br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos;

import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.tabuleiro.TabuleiroPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Coordenadas;

public class DadosExecucaoDisparo {
    private final EmbarcacaoPadrao embarcacao;
    private final TiposDeTiro tipoTiro;
    private final Coordenadas posicaoAlvo;
    private final TabuleiroPadrao tabuleiroAlvo;
    
    public DadosExecucaoDisparo(EmbarcacaoPadrao embarcacao, TiposDeTiro tipoTiro, Coordenadas posicaoAlvo, TabuleiroPadrao tabuleiroAlvo) {
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
    
    public TabuleiroPadrao obtemTabuleiroAlvo() {
        return tabuleiroAlvo;
    }
}
