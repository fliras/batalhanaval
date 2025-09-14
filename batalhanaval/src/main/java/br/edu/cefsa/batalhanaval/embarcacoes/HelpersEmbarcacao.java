package br.edu.cefsa.batalhanaval.embarcacoes;

import br.edu.cefsa.batalhanaval.utils.Constantes;
import br.edu.cefsa.batalhanaval.dificuldadesDeJogo.DificuldadeDeJogo;
import br.edu.cefsa.batalhanaval.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.armas.ArmaPadrao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class HelpersEmbarcacao {
    public static Embarcacao criaEmbarcacao(TiposDeEmbarcacao tipo, DificuldadeDeJogo dificuldade) {
        return switch (tipo) {
            case PORTA_AVIOES -> criaPortaAvioes(dificuldade);
            case CRUZADOR -> criaCruzador(dificuldade);
            case FRAGATA -> criaFragata(dificuldade);
            case DESTROIER -> criaDestroier(dificuldade);
            case SUBMARINO -> criaSubmarino(dificuldade);
            default -> null;
        };
    }
    
    private static Embarcacao criaPortaAvioes(DificuldadeDeJogo dificuldade) {
        Embarcacao portaAvioes = new Embarcacao(TiposDeEmbarcacao.PORTA_AVIOES);
        portaAvioes.atribuiArsenal(criaArsenalPorTipoDeEmbarcacao(TiposDeEmbarcacao.PORTA_AVIOES, dificuldade));
        portaAvioes.atribuiPartesDeEmbarcacao(criaPartesPorTipoDeEmbarcacao(TiposDeEmbarcacao.PORTA_AVIOES));
        return portaAvioes;
    }
    
    private static Embarcacao criaCruzador(DificuldadeDeJogo dificuldade) {
        Embarcacao cruzador = new Embarcacao(TiposDeEmbarcacao.CRUZADOR);
        cruzador.atribuiArsenal(criaArsenalPorTipoDeEmbarcacao(TiposDeEmbarcacao.CRUZADOR, dificuldade));
        cruzador.atribuiPartesDeEmbarcacao(criaPartesPorTipoDeEmbarcacao(TiposDeEmbarcacao.CRUZADOR));
        return cruzador;
    }
    
    private static Embarcacao criaFragata(DificuldadeDeJogo dificuldade) {
        Embarcacao fragata = new Embarcacao(TiposDeEmbarcacao.FRAGATA);
        fragata.atribuiArsenal(criaArsenalPorTipoDeEmbarcacao(TiposDeEmbarcacao.FRAGATA, dificuldade));
        fragata.atribuiPartesDeEmbarcacao(criaPartesPorTipoDeEmbarcacao(TiposDeEmbarcacao.FRAGATA));
        return fragata;
    }
    
    private static Embarcacao criaDestroier(DificuldadeDeJogo dificuldade) {
        Embarcacao destroier = new Embarcacao(TiposDeEmbarcacao.DESTROIER);
        destroier.atribuiArsenal(criaArsenalPorTipoDeEmbarcacao(TiposDeEmbarcacao.DESTROIER, dificuldade));
        destroier.atribuiPartesDeEmbarcacao(criaPartesPorTipoDeEmbarcacao(TiposDeEmbarcacao.DESTROIER));
        return destroier;
    }
    
    private static Embarcacao criaSubmarino(DificuldadeDeJogo dificuldade) {
        Embarcacao submarino = new Embarcacao(TiposDeEmbarcacao.SUBMARINO);
        submarino.atribuiArsenal(criaArsenalPorTipoDeEmbarcacao(TiposDeEmbarcacao.SUBMARINO, dificuldade));
        submarino.atribuiPartesDeEmbarcacao(criaPartesPorTipoDeEmbarcacao(TiposDeEmbarcacao.SUBMARINO));
        return submarino;
    }
    
    private static List<ParteDeEmbarcacao> criaPartesPorTipoDeEmbarcacao(TiposDeEmbarcacao tipo) {
        List<ParteDeEmbarcacao> partes = new ArrayList<>();
        int totalDePartes = tipo.obtemQtdeDePartes();
        for (int i = 0; i < totalDePartes; i++)
            partes.add(new ParteDeEmbarcacao());
        return partes;
    }
    
    private static HashMap<TiposDeTiro, ArmaPadrao> criaArsenalPorTipoDeEmbarcacao(TiposDeEmbarcacao tipoEmbarcacao, DificuldadeDeJogo dificuldade) {
        HashMap<TiposDeTiro, ArmaPadrao> arsenal = new HashMap();
        arsenal.put(TiposDeTiro.SIMPLES, new ArmaPadrao("Arma Simples", TiposDeTiro.SIMPLES, Constantes.QTDE_ILIMITADA));
        if (tipoEmbarcacao != TiposDeEmbarcacao.DESTROIER && tipoEmbarcacao != TiposDeEmbarcacao.SUBMARINO) {
            arsenal.put(TiposDeTiro.DUPLO, new ArmaPadrao("Arma Dupla", TiposDeTiro.DUPLO, dificuldade.obtemLimiteTirosEspeciais()));
            if (tipoEmbarcacao == TiposDeEmbarcacao.PORTA_AVIOES) {
                arsenal.put(TiposDeTiro.EXPLOSIVO, new ArmaPadrao("Arma Explosiva", TiposDeTiro.EXPLOSIVO, dificuldade.obtemLimiteTirosEspeciais()));
            }
        }
        return arsenal;
    }
    
    public static List<Embarcacao> filtraEmbarcacoesOperantes(Embarcacao[] embarcacoes) {
        return Arrays.stream(embarcacoes)
            .filter(e -> e.verificaSeEstaOperante())
            .toList();
    }
}
