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
    
    public PosicaoTabuleiro obtemPosicao(Coordenada posicao) {
        if (!verificaSeCoordenadasSaoValidas(posicao.obtemLinha(), posicao.obtemColuna())) {
            return null; // futuramente, lançar uma exception
        }
        String posicaoEmString = posicao.toString();
        if (posicoes.containsKey(posicaoEmString)) {
            return posicoes.get(posicaoEmString);
        }
        alocaNovaPosicao(posicaoEmString);
        return posicoes.get(posicaoEmString);
    }
    
    private boolean verificaSeCoordenadasSaoValidas(int linha, int coluna) {
        return linha <= quantidadeDeLinhasEColunas && coluna <= quantidadeDeLinhasEColunas;
    }
    
    private void alocaNovaPosicao(String coordenadas) {
        posicoes.put(coordenadas, new PosicaoTabuleiro());
    }
}
