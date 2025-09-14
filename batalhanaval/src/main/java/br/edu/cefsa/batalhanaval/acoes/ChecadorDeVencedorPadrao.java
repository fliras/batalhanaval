package br.edu.cefsa.batalhanaval.acoes;

import br.edu.cefsa.batalhanaval.embarcacoes.Embarcacao;
import br.edu.cefsa.batalhanaval.main.Jogador;

public class ChecagemDeVencedor {
    public Jogador checa(Jogador jogador1, Jogador jogador2) {
        boolean jogador1EstaNoJogo = validaSeHaEmbarcacaoOperante(jogador1.obtemEmbarcacoes());
        boolean jogador2EstaNoJogo = validaSeHaEmbarcacaoOperante(jogador2.obtemEmbarcacoes());
        if (jogador1EstaNoJogo && jogador2EstaNoJogo)
            return null; // não há vencedores no momento
        if (jogador1EstaNoJogo)
            return jogador1;
        return jogador2;
    }
    
    private boolean validaSeHaEmbarcacaoOperante(Embarcacao[] embarcacoes) {
        for (Embarcacao embarcacao : embarcacoes)
            if (embarcacao.verificaSeEstaOperante())
                return true;
        return false;
    }
}
