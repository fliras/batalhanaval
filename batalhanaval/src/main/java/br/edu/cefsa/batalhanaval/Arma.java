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
        if (quantidadeDeTiros == Constantes.QTDE_ILIMITADA) {
            return true;
        }
        if (quantidadeDeTiros == 0)
        {
            return false;
        }
        quantidadeDeTiros--;
        return true;
    }
    
    public int contaTirosRestantes() {
        return this.quantidadeDeTiros;
    }
    
    public boolean possuiTiros() {
        return quantidadeDeTiros > 0 || quantidadeDeTiros == Constantes.QTDE_ILIMITADA;
    }
}
