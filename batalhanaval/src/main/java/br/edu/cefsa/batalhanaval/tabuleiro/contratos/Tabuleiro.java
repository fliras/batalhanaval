package br.edu.cefsa.batalhanaval.tabuleiro.contratos;

import br.edu.cefsa.batalhanaval.tabuleiro.PosicaoTabuleiroPadrao;
import java.util.List;

public interface Tabuleiro {
    public PosicaoTabuleiro obtemPosicao(Coordenadas posicao);
    public boolean verificaSeListaDeCoordenadasSaoValidas(List<Coordenadas> posicoes);
    public boolean verificaSeCoordenadasSaoValidas(Coordenadas posicao);
    public int obtemQuantidadeDeLinhasEColunas();
    public PosicaoTabuleiroPadrao[] obtemPosicoesAcessadas();
}
