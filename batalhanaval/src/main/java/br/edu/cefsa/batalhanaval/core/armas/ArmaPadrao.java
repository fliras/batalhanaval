package br.edu.cefsa.batalhanaval.core.armas;

import br.edu.cefsa.batalhanaval.core.armas.contratos.Arma;
import br.edu.cefsa.batalhanaval.core.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.utils.Constantes;

public class ArmaPadrao implements Arma {
    private String nome;
    private TiposDeTiro tipoDeTiro;
    private int quantidadeDeTiros;
    
    public ArmaPadrao(String nome, TiposDeTiro tipoDeTiro, int quantidadeDeTiros) {
        this.nome = nome;
        this.tipoDeTiro = tipoDeTiro;
        this.quantidadeDeTiros = quantidadeDeTiros;
    }
    
    @Override
    public boolean dispara() {
        if (quantidadeDeTiros == Constantes.QTDE_ILIMITADA) {
            return true;
        }
        if (quantidadeDeTiros == 0)
        {
            return false;
        }
        quantidadeDeTiros--;
        return true;
    }
    
    @Override
    public int contaTirosRestantes() {
        return this.quantidadeDeTiros;
    }
    
    @Override
    public boolean possuiTiros() {
        return quantidadeDeTiros > 0 || quantidadeDeTiros == Constantes.QTDE_ILIMITADA;
    }
}
