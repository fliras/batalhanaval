package br.edu.cefsa.batalhanaval;

public interface AlgoritmoPosicionamentoEmbarcacao {
    public boolean validaSeAplicavel(int qtdePartesEmbarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz);
    public void posiciona(Embarcacao embarcacao, Tabuleiro tabuleiro, Coordenadas posicaoRaiz);
}
