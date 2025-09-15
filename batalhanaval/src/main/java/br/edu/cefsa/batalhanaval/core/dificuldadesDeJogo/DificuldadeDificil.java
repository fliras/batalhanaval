package br.edu.cefsa.batalhanaval.core.dificuldadesDeJogo;

import br.edu.cefsa.batalhanaval.core.dificuldadesDeJogo.contratos.TiposDeDificuldadeDeJogo;
import br.edu.cefsa.batalhanaval.core.dificuldadesDeJogo.contratos.DificuldadeDeJogo;

public class DificuldadeDificil extends DificuldadeDeJogo {
    private static DificuldadeDificil instancia;
    
    private DificuldadeDificil() {
        this.tipoDificuldade = TiposDeDificuldadeDeJogo.DIFICIL;
        this.limiteTirosEspeciais = 1;
        this.qtdePortaAvioes = 2;
        this.qtdeCruzadores = 3;
        this.qtdeFragatas = 4;
        this.qtdeDestroieres = 4;
        this.qtdeSubmarinos = 5;
    }
    
    public static DificuldadeDificil obtem() {
        if (instancia == null) {
            instancia = new DificuldadeDificil();
        }
        return instancia;
    }    
}
