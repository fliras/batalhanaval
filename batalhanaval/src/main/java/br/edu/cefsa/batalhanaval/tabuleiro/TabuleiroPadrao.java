package br.edu.cefsa.batalhanaval.tabuleiro;

import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.contratos.DificuldadeDeJogo;
import java.util.HashMap;
import java.util.List;

public class Tabuleiro {
    private final DificuldadeDeJogo dificuldade;
    private final HashMap<String, PosicaoTabuleiro> posicoesAcessadas;
    private int quantidadeDeLinhasEColunas;
    
    public Tabuleiro(DificuldadeDeJogo dificuldade) {
        this.dificuldade = dificuldade;
        this.posicoesAcessadas = new HashMap();
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
        if (posicoesAcessadas.containsKey(posicaoEmString)) {
            return posicoesAcessadas.get(posicaoEmString);
        }
        alocaNovaPosicao(posicao);
        return posicoesAcessadas.get(posicaoEmString);
    }
    
    public boolean verificaSeListaDeCoordenadasSaoValidas(List<Coordenadas> posicoes) {
        for (Coordenadas posicao : posicoes)
            if (!verificaSeCoordenadasSaoValidas(posicao))
                return false;
        return true;
    }
    
    public boolean verificaSeCoordenadasSaoValidas(Coordenadas posicao) {
        boolean linhaValida = posicao.obtemLinha() > 0 && posicao.obtemLinha() <= quantidadeDeLinhasEColunas;
        boolean colunaValida = posicao.obtemColuna() > 0 && posicao.obtemColuna() <= quantidadeDeLinhasEColunas;
        return linhaValida && colunaValida;
    }
    
    private void alocaNovaPosicao(Coordenadas coordenadas) {
        posicoesAcessadas.put(coordenadas.toString(), new PosicaoTabuleiro(coordenadas));
    }
    
    public int obtemQuantidadeDeLinhasEColunas() {
        return quantidadeDeLinhasEColunas;
    }
    
    public PosicaoTabuleiro[] obtemPosicoesAcessadas() {
        return posicoesAcessadas.values().toArray(PosicaoTabuleiro[]::new);
    }
}
