package br.edu.cefsa.batalhanaval.acoes;

import br.edu.cefsa.batalhanaval.acoes.contratos.executorDeDisparos.DadosExecucaoDisparo;
import br.edu.cefsa.batalhanaval.acoes.contratos.GeradorDeJogadas;
import br.edu.cefsa.batalhanaval.tabuleiro.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.EmbarcacaoPadrao;
import br.edu.cefsa.batalhanaval.embarcacoes.HelpersEmbarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.HelpersTabuleiro;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;
import br.edu.cefsa.batalhanaval.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeJogadasPadrao implements GeradorDeJogadas {
    @Override
    public DadosExecucaoDisparo gera(EmbarcacaoPadrao[] embarcacoesAtacantes, Tabuleiro tabuleiroAlvo) {
        EmbarcacaoPadrao embarcacaoSorteada = sorteiaEmbarcacao(embarcacoesAtacantes);
        TiposDeTiro tipoTiroSorteado = sorteiaTipoDeTiro(embarcacaoSorteada);
        Coordenadas coordenadasAleatorias = HelpersTabuleiro.sorteiaCoordenadas(tabuleiroAlvo);
        return new DadosExecucaoDisparo(embarcacaoSorteada, tipoTiroSorteado, coordenadasAleatorias, tabuleiroAlvo);
    }
    
    private EmbarcacaoPadrao sorteiaEmbarcacao(EmbarcacaoPadrao[] embarcacoes) {
        List<EmbarcacaoPadrao> embarcacoesOperantes = HelpersEmbarcacao.filtraEmbarcacoesOperantes(embarcacoes);
        int qtdeEmbarcacoes = embarcacoesOperantes.size();
        int indexSorteado = Utils.geraNumeroRandomicoDeXaY(0, qtdeEmbarcacoes - 1);
        return embarcacoesOperantes.get(indexSorteado);
    }
    
    private TiposDeTiro sorteiaTipoDeTiro(EmbarcacaoPadrao embarcacao) {
        List<TiposDeTiro> tiposDisponiveis = filtraTiposDeTiroDisponiveis(embarcacao);
        int qtdeTiros = tiposDisponiveis.size();
        int indexSorteado = Utils.geraNumeroRandomicoDeXaY(0, qtdeTiros - 1);
        return tiposDisponiveis.get(indexSorteado);
    }
    
    private List<TiposDeTiro> filtraTiposDeTiroDisponiveis(EmbarcacaoPadrao embarcacao) {
        List<TiposDeTiro> tiposDisponiveis = new ArrayList<>();
        for (TiposDeTiro tipo: TiposDeTiro.values()) {
            if (embarcacao.verificaSePossuiArmaNoArsenal(tipo) && embarcacao.verificaSeArmaPossuiMunicao(tipo))
                tiposDisponiveis.add(tipo);
        }
        return tiposDisponiveis;
    }
}
