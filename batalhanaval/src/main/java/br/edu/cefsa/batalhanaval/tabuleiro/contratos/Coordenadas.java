package br.edu.cefsa.batalhanaval.tabuleiro.contratos;

public class Coordenadas {
    private final int linha;
    private final int coluna;
    
    public Coordenadas(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public Coordenadas(String coordenadasEmTexto) {
        String[] coordenadas = coordenadasEmTexto.split(":");
        this.linha = Integer.parseInt(coordenadas[0]);
        this.coluna = Integer.parseInt(coordenadas[1]);
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
