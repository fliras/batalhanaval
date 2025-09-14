package br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos;

import br.edu.cefsa.batalhanaval.embarcacoes.contratos.Embarcacao;
import br.edu.cefsa.batalhanaval.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Tabuleiro;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Coordenadas;

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
