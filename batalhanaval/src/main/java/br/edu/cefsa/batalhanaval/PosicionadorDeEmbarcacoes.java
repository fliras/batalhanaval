package br.edu.cefsa.batalhanaval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PosicionadorDeEmbarcacoes {
    private final HashMap<PosicionamentosDeEmbarcacao, AlgoritmoPosicionamentoEmbarcacao> algoritmosPosicionamento;
    
    public PosicionadorDeEmbarcacoes(HashMap<PosicionamentosDeEmbarcacao, AlgoritmoPosicionamentoEmbarcacao> algoritmosPosicionamento) {
        this.algoritmosPosicionamento = algoritmosPosicionamento;
    }
    
    public void posiciona(Tabuleiro tabuleiro, Embarcacao[] embarcacoes) {
        for (Embarcacao e : embarcacoes) {
            posicionaEmbarcacao(tabuleiro, e);
        }
    }
    
    private void posicionaEmbarcacao(Tabuleiro tabuleiro, Embarcacao embarcacao) {
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
