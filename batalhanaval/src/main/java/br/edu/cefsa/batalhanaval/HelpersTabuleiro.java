package br.edu.cefsa.batalhanaval;

import java.util.List;

public final class HelpersTabuleiro {
    public static boolean verificaSePosicoesSaoValidas(List<Coordenadas> posicoes, Tabuleiro tabuleiro) {
        for (Coordenadas posicao : posicoes)
            if (!tabuleiro.verificaSeCoordenadasSaoValidas(posicao))
                return false;
        return true;
    }
}
