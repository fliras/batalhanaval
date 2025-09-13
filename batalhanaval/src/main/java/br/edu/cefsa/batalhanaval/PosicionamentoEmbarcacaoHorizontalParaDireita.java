package br.edu.cefsa.batalhanaval;

public class PosicionamentoEmbarcacaoHorizontalParaDireita implements AlgoritmoPosicionamentoEmbarcacao {
    @Override
    public boolean validaSeAplicavel(int qtdePartesEmbarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz) {
        int colunaInicial = posicaoRaiz.obtemColuna();
        for (int coluna = colunaInicial; coluna <= (colunaInicial + qtdePartesEmbarcacao); coluna++) {
            Coordenadas posicaoEmAnalise = new Coordenadas(posicaoRaiz.obtemLinha(), coluna);
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
        int colunaInicial = posicaoRaiz.obtemColuna();
        for (int coluna = colunaInicial, iParte = 0; coluna <= (colunaInicial + tamanhoEmbarcacao); coluna++) {
            Coordenadas coordenadasAtuais = new Coordenadas(posicaoRaiz.obtemLinha(), coluna);
            tabuleiro.obtemPosicao(coordenadasAtuais).atribuiParteDeEmbarcacao(partesEmbarcacao[iParte++]);
        }
    }
}
