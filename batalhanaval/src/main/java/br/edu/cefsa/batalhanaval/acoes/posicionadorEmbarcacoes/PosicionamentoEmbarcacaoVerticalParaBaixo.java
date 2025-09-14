package br.edu.cefsa.batalhanaval.acoes.posicionadorEmbarcacoes;

import br.edu.cefsa.batalhanaval.tabuleiro.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.Embarcacao;
import br.edu.cefsa.batalhanaval.embarcacoes.ParteDeEmbarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;

public class PosicionamentoEmbarcacaoVerticalParaBaixo implements AlgoritmoPosicionamentoEmbarcacao {
    @Override
    public boolean validaSeAplicavel(int qtdePartesEmbarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz) {
        int linhaInicial = posicaoRaiz.obtemLinha();
        for (int linha = linhaInicial; linha < (linhaInicial + qtdePartesEmbarcacao); linha++) {
            Coordenadas posicaoEmAnalise = new Coordenadas(linha, posicaoRaiz.obtemColuna());
            if (!tabuleiro.verificaSeCoordenadasSaoValidas(posicaoEmAnalise))
                return false;
            if (!tabuleiro.obtemPosicao(posicaoEmAnalise).verificaSeEstaVazia())
                return false;
        }
        return true;
    }

    @Override
    public void posiciona(Embarcacao embarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz) {
        ParteDeEmbarcacao[] partesEmbarcacao = embarcacao.obtemPartes();
        int tamanhoEmbarcacao = embarcacao.obtemTamanho();
        int linhaInicial = posicaoRaiz.obtemLinha();
        for (int linha = linhaInicial, iParte = 0; linha < (linhaInicial + tamanhoEmbarcacao); linha++) {
            Coordenadas coordenadasAtuais = new Coordenadas(linha, posicaoRaiz.obtemColuna());
            tabuleiro.obtemPosicao(coordenadasAtuais).atribuiParteDeEmbarcacao(partesEmbarcacao[iParte++]);
        }
    }
}
