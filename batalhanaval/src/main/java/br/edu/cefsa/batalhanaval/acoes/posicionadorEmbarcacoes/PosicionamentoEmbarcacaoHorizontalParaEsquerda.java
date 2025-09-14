package br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes;

import br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes.AlgoritmoPosicionamentoEmbarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.embarcacoes.ParteDeEmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.TabuleiroPadrao;

public class PosicionamentoEmbarcacaoHorizontalParaEsquerda implements AlgoritmoPosicionamentoEmbarcacao {
    @Override
    public boolean validaSeAplicavel(int qtdePartesEmbarcacao, TabuleiroPadrao tabuleiro, Coordenadas posicaoRaiz) {
        int colunaInicial = posicaoRaiz.obtemColuna();
        for (int coluna = colunaInicial; coluna > (colunaInicial - qtdePartesEmbarcacao); coluna--) {
            Coordenadas posicaoEmAnalise = new Coordenadas(posicaoRaiz.obtemLinha(), coluna);
            if (!tabuleiro.verificaSeCoordenadasSaoValidas(posicaoEmAnalise))
                return false;
            if (!tabuleiro.obtemPosicao(posicaoEmAnalise).verificaSeEstaVazia())
                return false;
        }
        return true;
    }

    @Override
    public void posiciona(EmbarcacaoPadrao embarcacao, TabuleiroPadrao tabuleiro, Coordenadas posicaoRaiz) {
        ParteDeEmbarcacaoPadrao[] partesEmbarcacao = embarcacao.obtemPartes();
        int tamanhoEmbarcacao = embarcacao.obtemTamanho();
        int colunaInicial = posicaoRaiz.obtemColuna();
        for (int coluna = colunaInicial, iParte = 0; coluna > (colunaInicial - tamanhoEmbarcacao); coluna--) {
            Coordenadas coordenadasAtuais = new Coordenadas(posicaoRaiz.obtemLinha(), coluna);
            tabuleiro.obtemPosicao(coordenadasAtuais).atribuiParteDeEmbarcacao(partesEmbarcacao[iParte++]);
        }
    }
}
