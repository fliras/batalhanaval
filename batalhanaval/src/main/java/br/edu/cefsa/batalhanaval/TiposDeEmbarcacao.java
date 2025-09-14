package br.edu.cefsa.batalhanaval;

public enum TiposDeEmbarcacao {
    PORTA_AVIOES("Porta Aviões", 6),
    CRUZADOR("Cruzador", 5),
    FRAGATA("Fragata", 4),
    DESTROIER("Destróier", 3),
    SUBMARINO("Submarino", 2);
    
    private int qtdeDePartes;
    private String nome;
    
    TiposDeEmbarcacao(String nome, int qtdeDePartes) {
        this.nome = nome;
        this.qtdeDePartes = qtdeDePartes;
    }
    
    public int obtemQtdeDePartes() {
        return qtdeDePartes;
    }
    
    public String obtemNome() {
        return nome;
    }
}
