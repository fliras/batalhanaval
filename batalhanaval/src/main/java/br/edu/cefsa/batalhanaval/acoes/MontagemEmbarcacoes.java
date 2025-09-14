package br.edu.cefsa.batalhanaval.acoes;

import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.DificuldadeDeJogo;
import br.edu.cefsa.batalhanaval.embarcacoes.Embarcacao;
import br.edu.cefsa.batalhanaval.embarcacoes.HelpersEmbarcacao;
import br.edu.cefsa.batalhanaval.embarcacoes.TiposDeEmbarcacao;
import java.util.ArrayList;
import java.util.List;

public class MontagemEmbarcacoes {
    private final DificuldadeDeJogo dificuldadeJogo;
    
    public MontagemEmbarcacoes(DificuldadeDeJogo dificuldadeJogo) {
        this.dificuldadeJogo = dificuldadeJogo;
    }
    
    public List<Embarcacao> monta() {
        List<Embarcacao> embarcacoes = new ArrayList<>();
        for (int i = 0; i < dificuldadeJogo.obtemQtdePortaAvioes(); i++) {
            embarcacoes.add(HelpersEmbarcacao.criaEmbarcacao(TiposDeEmbarcacao.PORTA_AVIOES, dificuldadeJogo));
        }
        for (int i = 0; i < dificuldadeJogo.obtemQtdeCruzadores(); i++) {
            embarcacoes.add(HelpersEmbarcacao.criaEmbarcacao(TiposDeEmbarcacao.CRUZADOR, dificuldadeJogo));
        }
        for (int i = 0; i < dificuldadeJogo.obtemQtdeFragatas(); i++) {
            embarcacoes.add(HelpersEmbarcacao.criaEmbarcacao(TiposDeEmbarcacao.FRAGATA, dificuldadeJogo));
        }
        for (int i = 0; i < dificuldadeJogo.obtemQtdeDestroieres(); i++) {
            embarcacoes.add(HelpersEmbarcacao.criaEmbarcacao(TiposDeEmbarcacao.DESTROIER, dificuldadeJogo));
        }
        for (int i = 0; i < dificuldadeJogo.obtemQtdeSubmarinos(); i++) {
            embarcacoes.add(HelpersEmbarcacao.criaEmbarcacao(TiposDeEmbarcacao.SUBMARINO, dificuldadeJogo));
        }
        return embarcacoes;
    }
}
