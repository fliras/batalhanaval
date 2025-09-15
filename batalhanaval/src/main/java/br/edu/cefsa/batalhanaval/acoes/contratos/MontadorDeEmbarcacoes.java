package br.edu.cefsa.batalhanaval.acoes.contratos;

import br.edu.cefsa.batalhanaval.core.dificuldadesDeJogo.contratos.DificuldadeDeJogo;
import br.edu.cefsa.batalhanaval.core.embarcacoes.contratos.Embarcacao;
import java.util.List;

public interface MontadorDeEmbarcacoes {
    public List<Embarcacao> monta(DificuldadeDeJogo dificuldade);
}
