package br.edu.cefsa.batalhanaval;

public enum TiposDeEmbarcacao {
    PORTA_AVIOES(6),
    CRUZADOR(5),
    FRAGATA(4),
    DESTROIER(3),
    SUBMARINO(2);
    
    private int qtdeDePartes;
    
    TiposDeEmbarcacao(int qtdeDePartes) {
        this.qtdeDePartes = qtdeDePartes;
    }
    
    public int obtemQtdeDePartes() {
        return qtdeDePartes;
    }
}
