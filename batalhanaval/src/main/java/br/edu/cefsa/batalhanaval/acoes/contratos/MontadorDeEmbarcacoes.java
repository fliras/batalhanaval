package br.edu.cefsa.batalhanaval.acoes.contratos;

import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.contratos.DificuldadeDeJogo;
import br.edu.cefsa.batalhanaval.embarcacoes.contratos.Embarcacao;
import java.util.List;

public interface MontadorDeEmbarcacoes {
    public List<Embarcacao> monta(DificuldadeDeJogo dificuldade);
}
