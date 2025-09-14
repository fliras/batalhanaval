package br.edu.cefsa.batalhanaval.acoes;

import br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos.DadosExecucaoDisparo;
import br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos.ExecutorDeDisparos;
import br.edu.cefsa.batalhanaval.tabuleiro.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.armas.HelpersTiros;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;
import br.edu.cefsa.batalhanaval.armas.contratos.TiposDeTiro;
import java.util.List;

public class ExecutorDeDisparosPadrao implements ExecutorDeDisparos {
    @Override
    public boolean executa(DadosExecucaoDisparo dadosDisparo) {
        EmbarcacaoPadrao embarcacao = dadosDisparo.obtemEmbarcacao();
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
