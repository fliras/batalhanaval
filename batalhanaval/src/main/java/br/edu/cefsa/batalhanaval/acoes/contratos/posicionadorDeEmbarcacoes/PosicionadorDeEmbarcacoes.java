package br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes;

import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;

public interface PosicionadorDeEmbarcacoes {
    public void posiciona(Tabuleiro tabuleiro, EmbarcacaoPadrao[] embarcacoes);
}
