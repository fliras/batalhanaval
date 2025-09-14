package br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes;

import br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes.AlgoritmoPosicionamentoEmbarcacao;
import br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes.PosicionadorDeEmbarcacoes;
import br.edu.cefsa.batalhanaval.tabuleiro.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.HelpersTabuleiro;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;
import br.edu.cefsa.batalhanaval.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PosicionadorDeEmbarcacoesPadrao implements PosicionadorDeEmbarcacoes {
    private final HashMap<PosicionamentosDeEmbarcacao, AlgoritmoPosicionamentoEmbarcacao> algoritmosPosicionamento;
    
    public PosicionadorDeEmbarcacoesPadrao(HashMap<PosicionamentosDeEmbarcacao, AlgoritmoPosicionamentoEmbarcacao> algoritmosPosicionamento) {
        this.algoritmosPosicionamento = algoritmosPosicionamento;
    }
    
    @Override
    public void posiciona(Tabuleiro tabuleiro, EmbarcacaoPadrao[] embarcacoes) {
        for (EmbarcacaoPadrao e : embarcacoes) {
            posicionaEmbarcacao(tabuleiro, e);
        }
    }
    
    private void posicionaEmbarcacao(Tabuleiro tabuleiro, EmbarcacaoPadrao embarcacao) {
        Coordenadas posicaoRaizAleatoria = HelpersTabuleiro.sorteiaCoordenadas(tabuleiro);
        PosicionamentosDeEmbarcacao[] posicionamentos = mapeiaPosicionamentosPossiveis(embarcacao.obtemTamanho(), tabuleiro, posicaoRaizAleatoria);
        if (posicionamentos.length > 0) {
            PosicionamentosDeEmbarcacao posicionamentoEscolhido = sorteiaPosicionamento(posicionamentos);
            AlgoritmoPosicionamentoEmbarcacao algoritmo = algoritmosPosicionamento.get(posicionamentoEscolhido);
            algoritmo.posiciona(embarcacao, tabuleiro, posicaoRaizAleatoria);
        } else {
            posicionaEmbarcacao(tabuleiro, embarcacao); // para procurar outra posição raiz, já que esta não aloca a embarcação de forma alguma.
        }
    }
    
    private PosicionamentosDeEmbarcacao[] mapeiaPosicionamentosPossiveis(int qtdePartesEmbarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz) {
        List<PosicionamentosDeEmbarcacao> posicionamentosPossiveis = new ArrayList<>();
        for (PosicionamentosDeEmbarcacao posicionamento : algoritmosPosicionamento.keySet()) {
            AlgoritmoPosicionamentoEmbarcacao algoritmo = algoritmosPosicionamento.get(posicionamento);
            if (algoritmo.validaSeAplicavel(qtdePartesEmbarcacao, tabuleiro, posicaoRaiz))
                posicionamentosPossiveis.add(posicionamento);
        }
        return posicionamentosPossiveis.toArray(PosicionamentosDeEmbarcacao[]::new);
    }
    
    private PosicionamentosDeEmbarcacao sorteiaPosicionamento(PosicionamentosDeEmbarcacao[] posicionamentos) {
        int qtdePosicionamentos = posicionamentos.length;
        int indexPosicionamentoEscolhido = Utils.geraNumeroRandomicoDeXaY(0, qtdePosicionamentos - 1);
        return posicionamentos[indexPosicionamentoEscolhido];
    }
}
