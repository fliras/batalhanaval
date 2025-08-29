package br.edu.cefsa.batalhanaval;

public class Arma {
    private String nome;
    private TipoDeTiro tipoDeTiro;
    private int quantidadeDeTiros;
    
    public Arma(String nome, TipoDeTiro tipoDeTiro, int quantidadeDeTiros) {
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
