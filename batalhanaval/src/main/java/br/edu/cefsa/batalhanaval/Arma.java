package br.edu.cefsa.batalhanaval;

public class Arma {
    private String nome;
    private TiposDeTiro tipoDeTiro;
    private int quantidadeDeTiros;
    
    public Arma(String nome, TiposDeTiro tipoDeTiro, int quantidadeDeTiros) {
        this.nome = nome;
        this.tipoDeTiro = tipoDeTiro;
        this.quantidadeDeTiros = quantidadeDeTiros;
    }
    
    public boolean dispara() {
        return true;
    }
    
    public int contaTirosRestantes() {
        return this.quantidadeDeTiros;
    }
}
