package br.edu.cefsa.batalhanaval.tabuleiro;

import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Coordenadas;
import br.edu.cefsa.batalhanaval.utils.Utils;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Tabuleiro;

public final class HelpersTabuleiro {
    public static Coordenadas sorteiaCoordenadas(Tabuleiro tabuleiro) {
        int qtdeLinhasColunas = tabuleiro.obtemQuantidadeDeLinhasEColunas();
        int linha = Utils.geraNumeroRandomicoDeXaY(1, qtdeLinhasColunas);
        int coluna = Utils.geraNumeroRandomicoDeXaY(1, qtdeLinhasColunas);
        return new Coordenadas(linha, coluna);
    }
}   
