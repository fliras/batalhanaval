package br.edu.cefsa.batalhanaval;

import java.util.HashMap;

public class Tabuleiro {
    private final DificuldadeDeJogo dificuldade;
    private final HashMap<String, PosicaoTabuleiro> posicoes;
    private int quantidadeDeLinhasEColunas;
    
    public Tabuleiro(DificuldadeDeJogo dificuldade) {
        this.dificuldade = dificuldade;
        this.posicoes = new HashMap();
        this.delimitaPosicoes();
    }
    
    private void delimitaPosicoes() {
        switch(dificuldade.obtemTipoDificuldade()) {
            case FACIL -> {
                quantidadeDeLinhasEColunas = 10;
                break;
            }
            case MEDIO -> {
                quantidadeDeLinhasEColunas = 15;
                break;
            }
            case DIFICIL -> {
                quantidadeDeLinhasEColunas = 30;
                break;
            }
        }
    }
    
    public PosicaoTabuleiro obtemPosicao(int linha, int coluna) {
        if (!verificaSeCoordenadasSaoValidas(linha, coluna))
            return null; // futuramente, lançar uma exception
        
        String coordenadas = String.format("%d:%d", linha, coluna);
        if (posicoes.containsKey(coordenadas)) {
            return posicoes.get(coordenadas);
        }
        
        alocaNovaPosicao(coordenadas);
        return posicoes.get(coordenadas);
    }
    
    private boolean verificaSeCoordenadasSaoValidas(int linha, int coluna) {
        return linha <= quantidadeDeLinhasEColunas && coluna <= quantidadeDeLinhasEColunas;
    }
    
    private void alocaNovaPosicao(String coordenadas) {
        posicoes.put(coordenadas, new PosicaoTabuleiro());
    }
}
