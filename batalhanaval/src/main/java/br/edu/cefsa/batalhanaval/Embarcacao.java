package br.edu.cefsa.batalhanaval;

import java.util.HashMap;
import java.util.List;

public class Embarcacao {
    private TiposDeEmbarcacao tipoEmbarcacao;
    private HashMap<TiposDeTiro, Arma> arsenal;
    private List<ParteDeEmbarcacao> partesDaEmbarcacao;
    
    public Embarcacao(TiposDeEmbarcacao tipoEmbarcacao) {
        this.tipoEmbarcacao = tipoEmbarcacao;
    }
    
    protected void atribuiArsenal(HashMap<TiposDeTiro, Arma> arsenal) {
        this.arsenal = arsenal;
    }
    
    protected void atribuiPartesDeEmbarcacao(List<ParteDeEmbarcacao> partesDaEmbarcacao) {
        this.partesDaEmbarcacao = partesDaEmbarcacao;
    }
    
    public void atira(TiposDeTiro tipoDeTiro) {
        
    }
    
    public boolean verificaSeEstaOperante() {
        return true;
    }
}
