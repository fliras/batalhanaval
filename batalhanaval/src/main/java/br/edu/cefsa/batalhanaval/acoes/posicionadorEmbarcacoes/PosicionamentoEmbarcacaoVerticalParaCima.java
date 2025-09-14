package br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes;

import br.edu.cefsa.batalhanaval.acoes.contratos.posicionadorDeEmbarcacoes.AlgoritmoPosicionamentoEmbarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.contratos.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.embarcacoes.ParteDeEmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.tabuleiro.TabuleiroPadrao;

public class PosicionamentoEmbarcacaoVerticalParaCima implements AlgoritmoPosicionamentoEmbarcacao {
    @Override
    public boolean validaSeAplicavel(int qtdePartesEmbarcacao, TabuleiroPadrao tabuleiro, Coordenadas posicaoRaiz) {
        int linhaInicial = posicaoRaiz.obtemLinha();
        for (int linha = linhaInicial; linha > (linhaInicial - qtdePartesEmbarcacao); linha--) {
            Coordenadas posicaoEmAnalise = new Coordenadas(linha, posicaoRaiz.obtemColuna());
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
        int linhaInicial = posicaoRaiz.obtemLinha();
        for (int linha = linhaInicial, iParte = 0; linha > (linhaInicial - tamanhoEmbarcacao); linha--) {
            Coordenadas coordenadasAtuais = new Coordenadas(linha, posicaoRaiz.obtemColuna());
            tabuleiro.obtemPosicao(coordenadasAtuais).atribuiParteDeEmbarcacao(partesEmbarcacao[iParte++]);
        }
    }
}
