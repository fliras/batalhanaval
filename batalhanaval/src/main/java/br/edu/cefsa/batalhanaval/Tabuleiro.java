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
    
    public PosicaoTabuleiro obtemPosicao(Coordenadas posicao) {
        if (!verificaSeCoordenadasSaoValidas(posicao)) {
            return null; // futuramente, lançar uma exception
        }
        String posicaoEmString = posicao.toString();
        if (posicoes.containsKey(posicaoEmString)) {
            return posicoes.get(posicaoEmString);
        }
        alocaNovaPosicao(posicao);
        return posicoes.get(posicaoEmString);
    }
    
    public boolean verificaSeCoordenadasSaoValidas(Coordenadas posicao) {
        return posicao.obtemLinha() <= quantidadeDeLinhasEColunas && posicao.obtemColuna() <= quantidadeDeLinhasEColunas;
    }
    
    private void alocaNovaPosicao(Coordenadas posicao) {
        posicoes.put(posicao.toString(), new PosicaoTabuleiro());
    }
}
