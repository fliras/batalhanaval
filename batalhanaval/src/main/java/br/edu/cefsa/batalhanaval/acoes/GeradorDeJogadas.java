package br.edu.cefsa.batalhanaval.acoes;

import br.edu.cefsa.batalhanaval.acoes.execucaoDeDisparos.DadosExecucaoDisparo;
import br.edu.cefsa.batalhanaval.tabuleiro.Coordenadas;
import br.edu.cefsa.batalhanaval.embarcacoes.Embarcacao;
import br.edu.cefsa.batalhanaval.embarcacoes.HelpersEmbarcacao;
import br.edu.cefsa.batalhanaval.tabuleiro.HelpersTabuleiro;
import br.edu.cefsa.batalhanaval.tabuleiro.Tabuleiro;
import br.edu.cefsa.batalhanaval.armas.TiposDeTiro;
import br.edu.cefsa.batalhanaval.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeradorDeJogadas {
    public DadosExecucaoDisparo gera(Embarcacao[] embarcacoesAtacantes, Tabuleiro tabuleiroAlvo) {
        Embarcacao embarcacaoSorteada = sorteiaEmbarcacao(embarcacoesAtacantes);
        TiposDeTiro tipoTiroSorteado = sorteiaTipoDeTiro(embarcacaoSorteada);
        Coordenadas coordenadasAleatorias = HelpersTabuleiro.sorteiaCoordenadas(tabuleiroAlvo);
        return new DadosExecucaoDisparo(embarcacaoSorteada, tipoTiroSorteado, coordenadasAleatorias, tabuleiroAlvo);
    }
    
    private Embarcacao sorteiaEmbarcacao(Embarcacao[] embarcacoes) {
        List<Embarcacao> embarcacoesOperantes = HelpersEmbarcacao.filtraEmbarcacoesOperantes(embarcacoes);
        int qtdeEmbarcacoes = embarcacoesOperantes.size();
        int indexSorteado = Utils.geraNumeroRandomicoDeXaY(0, qtdeEmbarcacoes - 1);
        return embarcacoesOperantes.get(indexSorteado);
    }
    
    private TiposDeTiro sorteiaTipoDeTiro(Embarcacao embarcacao) {
        List<TiposDeTiro> tiposDisponiveis = filtraTiposDeTiroDisponiveis(embarcacao);
        int qtdeTiros = tiposDisponiveis.size();
        int indexSorteado = Utils.geraNumeroRandomicoDeXaY(0, qtdeTiros - 1);
        return tiposDisponiveis.get(indexSorteado);
    }
    
    private List<TiposDeTiro> filtraTiposDeTiroDisponiveis(Embarcacao embarcacao) {
        List<TiposDeTiro> tiposDisponiveis = new ArrayList<>();
        for (TiposDeTiro tipo: TiposDeTiro.values()) {
            if (embarcacao.verificaSePossuiArmaNoArsenal(tipo) && embarcacao.verificaSeArmaPossuiMunicao(tipo))
                tiposDisponiveis.add(tipo);
        }
        return tiposDisponiveis;
    }
}
