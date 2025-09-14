package br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes;

import br.edu.cefsa.batalhanaval.embarcacoes.contratos.Embarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Tabuleiro;

public interface PosicionadorDeEmbarcacoes {
    public void posiciona(Tabuleiro tabuleiro, Embarcacao[] embarcacoes);
}
