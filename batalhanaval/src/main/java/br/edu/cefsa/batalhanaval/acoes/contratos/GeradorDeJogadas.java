package br.edu.cefsa.batalhanaval.acoes.contratos;

import br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos.DadosExecucaoDisparo;
import br.edu.cefsa.batalhanaval.embarcacoes.Embarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;

public interface GeradorDeJogadas {
    public DadosExecucaoDisparo gera(Embarcacao[] embarcacoesAtacantes, Tabuleiro tabuleiroAlvo);
}
