package br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes;

import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.TabuleiroPadrao;

public interface AlgoritmoPosicionamentoEmbarcacao {
    public boolean validaSeAplicavel(int qtdePartesEmbarcacao, TabuleiroPadrao tabuleiro, Coordenadas posicaoRaiz);
    public void posiciona(EmbarcacaoPadrao embarcacao, TabuleiroPadrao tabuleiro, Coordenadas posicaoRaiz);
}
