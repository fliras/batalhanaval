package br.edu.cefsa.batalhanaval.dificuldadesDeJogo;

public abstract class DificuldadeDeJogo {
    protected TiposDeDificuldadeDeJogo tipoDificuldade;
    protected int limiteTirosEspeciais;
    protected int qtdePortaAvioes;
    protected int qtdeCruzadores;
    protected int qtdeFragatas;
    protected int qtdeDestroieres;
    protected int qtdeSubmarinos;
    
    public int obtemLimiteTirosEspeciais() {
        return limiteTirosEspeciais;
    }
    
    public int obtemQtdePortaAvioes() {
        return qtdePortaAvioes;
    }

    public int obtemQtdeCruzadores() {
        return qtdeCruzadores;
    }

    public int obtemQtdeFragatas() {
        return qtdeFragatas;
    }

    public int obtemQtdeDestroieres() {
        return qtdeDestroieres;
    }

    public int obtemQtdeSubmarinos() {
        return qtdeSubmarinos;
    }
    
    public TiposDeDificuldadeDeJogo obtemTipoDificuldade() {
        return tipoDificuldade;
    }
}
