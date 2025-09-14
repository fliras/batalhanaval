package br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes;

import br.edu.cefsa.batalhanaval.tabuleiro.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.Embarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;

public interface AlgoritmoPosicionamentoEmbarcacao {
    public boolean validaSeAplicavel(int qtdePartesEmbarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz);
    public void posiciona(Embarcacao embarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz);
}
