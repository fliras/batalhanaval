package br.edu.cefsa.batalhanaval.acoes.contratos;

import br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos.DadosExecucaoDisparo;
import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.TabuleiroPadrao;

public interface GeradorDeJogadas {
    public DadosExecucaoDisparo gera(EmbarcacaoPadrao[] embarcacoesAtacantes, TabuleiroPadrao tabuleiroAlvo);
}
