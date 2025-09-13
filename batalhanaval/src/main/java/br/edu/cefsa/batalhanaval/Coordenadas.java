package br.edu.cefsa.batalhanaval;

public class Coordenadas {
    private final int linha;
    private final int coluna;
    
    public Coordenadas(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public int obtemLinha() {
        return linha;
    }
    
    public int obtemColuna() {
        return coluna;
    }
    
    @Override
    public String toString() {
        return String.format("%d:%d", linha, coluna);
    }
}
