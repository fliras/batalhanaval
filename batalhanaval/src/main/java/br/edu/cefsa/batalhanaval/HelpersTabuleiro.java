package br.edu.cefsa.batalhanaval;

import java.util.List;

public final class HelpersTabuleiro {
    public static Coordenadas sorteiaCoordenadas(Tabuleiro tabuleiro) {
        int qtdeLinhasColunas = tabuleiro.obtemQuantidadeDeLinhasEColunas();
        int linha = Utils.geraNumeroRandomicoDeXaY(1, qtdeLinhasColunas);
        int coluna = Utils.geraNumeroRandomicoDeXaY(1, qtdeLinhasColunas);
        return new Coordenadas(linha, coluna);
    }
}   
