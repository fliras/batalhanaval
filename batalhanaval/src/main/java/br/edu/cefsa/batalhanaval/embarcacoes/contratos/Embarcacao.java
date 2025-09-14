package br.edu.cefsa.batalhanaval.embarcacoes.contratos;

import br.edu.cefsa.batalhanaval.armas.contratos.Arma;
import br.edu.cefsa.batalhanaval.armas.contratos.TiposDeTiro;
import java.util.HashMap;
import java.util.List;

public interface Embarcacao {
    public void atribuiArsenal(HashMap<TiposDeTiro, Arma> arsenal);
    public void atribuiPartesDeEmbarcacao(List<ParteDeEmbarcacao> partesDaEmbarcacao);
    public boolean atira(TiposDeTiro tipoDeTiro);
    public boolean verificaSeEstaOperante();
    public boolean verificaSePossuiArmaNoArsenal(TiposDeTiro tipoDeTiro);
    public boolean verificaSeArmaPossuiMunicao(TiposDeTiro tipoDeTiro);
    public void atualizaEstado();
    public ParteDeEmbarcacao[] obtemPartes();
    public int obtemTamanho();
    public String obtemNome();
    public TiposDeTiro[] listaTiposDeTiroDisponiveis();
}
