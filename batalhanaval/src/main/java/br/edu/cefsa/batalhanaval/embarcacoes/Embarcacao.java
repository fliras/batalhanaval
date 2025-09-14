package br.edu.cefsa.batalhanaval.embarcacoes;

import br.edu.cefsa.batalhanaval.utils.Constantes;
import br.edu.cefsa.batalhanaval.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.armas.ArmaPadrao;
import java.util.HashMap;
import java.util.List;

public class Embarcacao {
    private TiposDeEmbarcacao tipoEmbarcacao;
    private boolean emOperacao;
    private HashMap<TiposDeTiro, ArmaPadrao> arsenal;
    private List<ParteDeEmbarcacao> partesDaEmbarcacao;
    
    public Embarcacao(TiposDeEmbarcacao tipoEmbarcacao) {
        this.tipoEmbarcacao = tipoEmbarcacao;
        this.emOperacao = true;
    }
    
    protected void atribuiArsenal(HashMap<TiposDeTiro, ArmaPadrao> arsenal) {
        this.arsenal = arsenal;
    }
    
    protected void atribuiPartesDeEmbarcacao(List<ParteDeEmbarcacao> partesDaEmbarcacao) {
        this.partesDaEmbarcacao = partesDaEmbarcacao;
        for (ParteDeEmbarcacao parte : partesDaEmbarcacao)
            parte.associaEmbarcacao(this);
        this.atualizaEstado();
    }
    
    public boolean atira(TiposDeTiro tipoDeTiro) {
        if (!verificaSePossuiArmaNoArsenal(tipoDeTiro))
            return false;
        return arsenal.get(tipoDeTiro).dispara();
    }
    
    public boolean verificaSeEstaOperante() {
        return emOperacao;
    }
    
    public boolean verificaSePossuiArmaNoArsenal(TiposDeTiro tipoDeTiro) {
        return arsenal.containsKey(tipoDeTiro);
    }
    
    public boolean verificaSeArmaPossuiMunicao(TiposDeTiro tipoDeTiro) {
        if (!arsenal.containsKey(tipoDeTiro)) return false;
        int qtdeTirosRestantes = arsenal.get(tipoDeTiro).contaTirosRestantes();
        return qtdeTirosRestantes > 0 || qtdeTirosRestantes == Constantes.QTDE_ILIMITADA;
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
    
    public ParteDeEmbarcacao[] obtemPartes() {
        return partesDaEmbarcacao.toArray(ParteDeEmbarcacao[]::new);
    }
    
    public int obtemTamanho() {
        return partesDaEmbarcacao.size();
    }
    
    public String obtemNome() {
        return tipoEmbarcacao.obtemNome();
    }
    
    public TiposDeTiro[] listaTiposDeTiroDisponiveis() {
        return arsenal.keySet()
            .stream()
            .filter(t -> arsenal.get(t).possuiTiros())
            .toArray(TiposDeTiro[]::new);
    }
}
