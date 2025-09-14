package br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes;

import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.contratos.Embarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Tabuleiro;

public interface AlgoritmoPosicionamentoEmbarcacao {
    public boolean validaSeAplicavel(int qtdePartesEmbarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz);
    public void posiciona(Embarcacao embarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz);
}
