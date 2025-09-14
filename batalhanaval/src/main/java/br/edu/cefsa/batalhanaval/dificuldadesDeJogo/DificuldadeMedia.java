package br.edu.cefsa.batalhanaval.dificuldadesDeJogo;

public class DificuldadeMedia extends DificuldadeDeJogo {
    private static DificuldadeMedia instancia;
    
    private DificuldadeMedia() {
        this.tipoDificuldade = TiposDeDificuldadeDeJogo.MEDIO;
        this.limiteTirosEspeciais = 3;
        this.qtdePortaAvioes = 1;
        this.qtdeCruzadores = 2;
        this.qtdeFragatas = 3;
        this.qtdeDestroieres = 2;
        this.qtdeSubmarinos = 3;
    }
    
    public static DificuldadeMedia obtem() {
        if (instancia == null) {
            instancia = new DificuldadeMedia();
        }
        return instancia;
    }    
}
