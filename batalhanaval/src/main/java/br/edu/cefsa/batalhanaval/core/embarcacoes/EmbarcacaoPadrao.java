package br.edu.cefsa.batalhanaval.core.embarcacoes;

import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.TiposDeEmbarcacao;
import br.edu.cefsa.batalhanaval.utils.Constantes;
import br.edu.cefsa.batalhanaval.core.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.core.armas.contratos.Arma;
import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.Embarcacao;
import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.ParteDeEmbarcacao;
import java.util.HashMap;
import java.util.List;

public class EmbarcacaoPadrao implements Embarcacao {
    private TiposDeEmbarcacao tipoEmbarcacao;
    private boolean emOperacao;
    private HashMap<TiposDeTiro, Arma> arsenal;
    private List<ParteDeEmbarcacao> partesDaEmbarcacao;
    
    public EmbarcacaoPadrao(TiposDeEmbarcacao tipoEmbarcacao) {
        this.tipoEmbarcacao = tipoEmbarcacao;
        this.emOperacao = true;
    }
    
    @Override
    public void atribuiArsenal(HashMap<TiposDeTiro, Arma> arsenal) {
        this.arsenal = arsenal;
    }
    
    @Override
    public void atribuiPartesDeEmbarcacao(List<ParteDeEmbarcacao> partesDaEmbarcacao) {
        this.partesDaEmbarcacao = partesDaEmbarcacao;
        for (ParteDeEmbarcacao parte : partesDaEmbarcacao)
            parte.associaEmbarcacao(this);
        this.atualizaEstado();
    }
    
    @Override
    public boolean atira(TiposDeTiro tipoDeTiro) {
        if (!verificaSePossuiArmaNoArsenal(tipoDeTiro))
            return false;
        return arsenal.get(tipoDeTiro).dispara();
    }
    
    @Override
    public boolean verificaSeEstaOperante() {
        return emOperacao;
    }
    
    @Override
    public boolean verificaSePossuiArmaNoArsenal(TiposDeTiro tipoDeTiro) {
        return arsenal.containsKey(tipoDeTiro);
    }
    
    @Override
    public boolean verificaSeArmaPossuiMunicao(TiposDeTiro tipoDeTiro) {
        if (!arsenal.containsKey(tipoDeTiro)) return false;
        int qtdeTirosRestantes = arsenal.get(tipoDeTiro).contaTirosRestantes();
        return qtdeTirosRestantes > 0 || qtdeTirosRestantes == Constantes.QTDE_ILIMITADA;
    }
    
    @Override
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
    
    @Override
    public ParteDeEmbarcacao[] obtemPartes() {
        return partesDaEmbarcacao.toArray(ParteDeEmbarcacao[]::new);
    }
    
    @Override
    public int obtemTamanho() {
        return partesDaEmbarcacao.size();
    }
    
    @Override
    public String obtemNome() {
        return tipoEmbarcacao.obtemNome();
    }
    
    @Override
    public TiposDeTiro[] listaTiposDeTiroDisponiveis() {
        return arsenal.keySet()
            .stream()
            .filter(t -> arsenal.get(t).possuiTiros())
            .toArray(TiposDeTiro[]::new);
    }
}
