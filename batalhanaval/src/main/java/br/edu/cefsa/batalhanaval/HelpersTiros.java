package br.edu.cefsa.batalhanaval;

import java.util.ArrayList;
import java.util.List;

public final class HelpersTiros {
    public static List<Coordenada> projetaTiroPorTipo(TiposDeTiro tipoTiro, Coordenada origem) {
        return switch(tipoTiro) {
            case SIMPLES -> projetaTiroSimples(origem);
            case DUPLO -> projetaTiroDuplo(origem);
            case EXPLOSIVO -> projetaTiroExplosivo(origem);
            default -> null;
        };
    }
    
    private static List<Coordenada> projetaTiroSimples(Coordenada origem) {
        return new ArrayList<>() {{
            add(origem);
        }};
    }
    
    private static List<Coordenada> projetaTiroDuplo(Coordenada origem) {
        boolean tiroSeraVertical = Utils.geraNumeroRandomicoDeXaY(0, 10) % 2 == 0;
        Coordenada novaCoordenada = tiroSeraVertical
            ? new Coordenada((origem.obtemLinha() + 1), origem.obtemColuna())
            : new Coordenada(origem.obtemLinha(), (origem.obtemColuna() + 1));
        return new ArrayList<>() {{
            add(origem);
            add(novaCoordenada);
        }};
    }
    
    private static List<Coordenada> projetaTiroExplosivo(Coordenada origem) {
        return new ArrayList<>() {{
            add(new Coordenada(origem.obtemLinha() - 1, origem.obtemColuna() - 1));
            add(new Coordenada(origem.obtemLinha() - 1, origem.obtemColuna()));
            add(new Coordenada(origem.obtemLinha() - 1, origem.obtemColuna() + 1));
            add(new Coordenada(origem.obtemLinha(), origem.obtemColuna() - 1));
            add(origem);
            add(new Coordenada(origem.obtemLinha(), origem.obtemColuna() + 1));
            add(new Coordenada(origem.obtemLinha() + 1, origem.obtemColuna() - 1));
            add(new Coordenada(origem.obtemLinha() + 1, origem.obtemColuna()));
            add(new Coordenada(origem.obtemLinha() + 1, origem.obtemColuna() + 1));
        }};
    }
}
