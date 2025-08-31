package br.edu.cefsa.batalhanaval;

public class DificuldadeFacil extends DificuldadeDeJogo {
    private static DificuldadeFacil instancia;
    
    private DificuldadeFacil() {
        this.tipoDificuldade = TiposDeDificuldadeDeJogo.FACIL;
        this.limiteTirosEspeciais = Constantes.QTDE_ILIMITADA;
        this.qtdePortaAvioes = 1;
        this.qtdeCruzadores = 1;
        this.qtdeFragatas = 2;
        this.qtdeDestroieres = 2;
        this.qtdeSubmarinos = 2;
    }
    
    public static DificuldadeFacil obtem() {
        if (instancia == null) {
            instancia = new DificuldadeFacil();
        }
        return instancia;
    }
}
