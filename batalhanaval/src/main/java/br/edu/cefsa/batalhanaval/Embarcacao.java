package br.edu.cefsa.batalhanaval;

import java.util.HashMap;
import java.util.List;

public class Embarcacao {
    private TiposDeEmbarcacao tipoEmbarcacao;
    private boolean emOperacao;
    private HashMap<TiposDeTiro, Arma> arsenal;
    private List<ParteDeEmbarcacao> partesDaEmbarcacao;
    
    public Embarcacao(TiposDeEmbarcacao tipoEmbarcacao) {
        this.tipoEmbarcacao = tipoEmbarcacao;
        this.emOperacao = true;
    }
    
    protected void atribuiArsenal(HashMap<TiposDeTiro, Arma> arsenal) {
        this.arsenal = arsenal;
    }
    
    protected void atribuiPartesDeEmbarcacao(List<ParteDeEmbarcacao> partesDaEmbarcacao) {
        this.partesDaEmbarcacao = partesDaEmbarcacao;
        for (ParteDeEmbarcacao parte : partesDaEmbarcacao)
            parte.associaEmbarcacao(this);
        this.atualizaEstado();
    }
    
    public void atira(TiposDeTiro tipoDeTiro) {
        
    }
    
    public boolean verificaSeEstaOperante() {
        return emOperacao;
    }
    
    public void atualizaEstado() {
        boolean estaDestruida = true;
        for (ParteDeEmbarcacao parte : partesDaEmbarcacao) {
            if (parte.verificaSeEstaOperante()) {
                estaDestruida = false;
                break;
            }
        }
        this.emOperacao = !estaDestruida;
    }
}
