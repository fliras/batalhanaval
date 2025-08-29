package br.edu.cefsa.batalhanaval;

import java.util.HashMap;
import java.util.List;

public class Embarcacao {
    private TipoDeEmbarcacao tipoEmbarcacao;
    private HashMap<TipoDeTiro, Arma> arsenal;
    private List<ParteDeEmbarcacao> partesDaEmbarcacao;
    
    public Embarcacao(TipoDeEmbarcacao tipoEmbarcacao) {
        this.tipoEmbarcacao = tipoEmbarcacao;
    }
    
    protected void atribuiArsenal(HashMap<TipoDeTiro, Arma> arsenal) {
        this.arsenal = arsenal;
    }
    
    protected void atribuiPartesDeEmbarcacao(List<ParteDeEmbarcacao> partesDaEmbarcacao) {
        this.partesDaEmbarcacao = partesDaEmbarcacao;
    }
    
    public void atira(TipoDeTiro tipoDeTiro) {
        
    }
    
    public boolean verificaSeEstaOperante() {
        return true;
    }
}
