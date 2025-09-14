package br.edu.cefsa.batalhanaval;

import java.util.List;

public class ExecucaoDeDisparo {
    public boolean executa(DadosExecucaoDisparo dadosDisparo) {
        Embarcacao embarcacao = dadosDisparo.obtemEmbarcacao();
        TiposDeTiro tipoTiro = dadosDisparo.obtemTipoTiro();
        Coordenadas posicaoAlvo = dadosDisparo.obtemPosicaoAlvo();
        Tabuleiro tabuleiroAlvo = dadosDisparo.obtemTabuleiroAlvo();
        
        if (!embarcacao.verificaSePossuiArmaNoArsenal(tipoTiro))
            return false;
        
        List<Coordenadas> posicoesQueSeraoAtingidas = HelpersTiros.projetaTiroPorTipo(tipoTiro, posicaoAlvo);
        if (!tabuleiroAlvo.verificaSeListaDeCoordenadasSaoValidas(posicoesQueSeraoAtingidas))
            return false;
        
        if (!embarcacao.atira(tipoTiro))
            return false;
        
        for (Coordenadas posicao : posicoesQueSeraoAtingidas)
            tabuleiroAlvo.obtemPosicao(posicao).registraDisparo();
        
        return true;
    }
    

}
