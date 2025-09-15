package br.edu.cefsa.batalhanaval.acoes.contratos;

import br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos.DadosExecucaoDisparo;
import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.Embarcacao;
import br.edu.cefsa.batalhanaval.core.tabuleiro.contratos.Tabuleiro;

public interface GeradorDeJogadas {
    public DadosExecucaoDisparo gera(Embarcacao[] embarcacoesAtacantes, Tabuleiro tabuleiroAlvo);
}
