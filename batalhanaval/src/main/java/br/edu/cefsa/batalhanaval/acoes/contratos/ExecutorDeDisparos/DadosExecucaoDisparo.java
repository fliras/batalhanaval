package br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos;

import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.Embarcacao;
import br.edu.cefsa.batalhanaval.core.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.core.tabuleiro.contratos.Tabuleiro;
import br.edu.cefsa.batalhanaval.core.tabuleiro.contratos.Coordenadas;

public class DadosExecucaoDisparo {
    private Embarcacao embarcacao;
    private TiposDeTiro tipoTiro;
    private Coordenadas posicaoAlvo;
    private Tabuleiro tabuleiroAlvo;
    
    public DadosExecucaoDisparo(Embarcacao embarcacao, TiposDeTiro tipoTiro, Coordenadas posicaoAlvo, Tabuleiro tabuleiroAlvo) {
        this.embarcacao = embarcacao;
        this.tipoTiro = tipoTiro;
        this.posicaoAlvo = posicaoAlvo;
        this.tabuleiroAlvo = tabuleiroAlvo;
    }
    
    public DadosExecucaoDisparo() {
        
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
    
    public void atribuiEmbarcacao(Embarcacao embarcacao) {
        this.embarcacao = embarcacao;
    }

    public void atribuiTipoTiro(TiposDeTiro tipoTiro) {
        this.tipoTiro = tipoTiro;
    }

    public void atribuiPosicaoAlvo(Coordenadas posicaoAlvo) {
        this.posicaoAlvo = posicaoAlvo;
    }

    public void atribuiTabuleiroAlvo(Tabuleiro tabuleiroAlvo) {
        this.tabuleiroAlvo = tabuleiroAlvo;
    }
    
}
