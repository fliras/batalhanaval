package br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes;

import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.TabuleiroPadrao;

public interface PosicionadorDeEmbarcacoes {
    public void posiciona(TabuleiroPadrao tabuleiro, EmbarcacaoPadrao[] embarcacoes);
}
