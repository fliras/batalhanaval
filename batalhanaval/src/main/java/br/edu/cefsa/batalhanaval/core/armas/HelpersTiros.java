package br.edu.cefsa.batalhanaval.core.armas;

import br.edu.cefsa.batalhanaval.core.armas.contratos.TiposDeTiro;
import br.edu.cefsa.batalhanaval.utils.Utils;
import br.edu.cefsa.batalhanaval.core.tabuleiro.contratos.Coordenadas;
import java.util.ArrayList;
import java.util.List;

public final class HelpersTiros {
    public static List<Coordenadas> projetaTiroPorTipo(TiposDeTiro tipoTiro, Coordenadas origem) {
        return switch(tipoTiro) {
            case SIMPLES -> projetaTiroSimples(origem);
            case DUPLO -> projetaTiroDuplo(origem);
            case EXPLOSIVO -> projetaTiroExplosivo(origem);
            default -> null;
        };
    }
    
    private static List<Coordenadas> projetaTiroSimples(Coordenadas origem) {
        return new ArrayList<>() {{
            add(origem);
        }};
    }
    
    private static List<Coordenadas> projetaTiroDuplo(Coordenadas origem) {
        boolean tiroSeraVertical = Utils.geraNumeroRandomicoDeXaY(0, 10) % 2 == 0;
        Coordenadas novaCoordenada = tiroSeraVertical
            ? new Coordenadas((origem.obtemLinha() + 1), origem.obtemColuna())
            : new Coordenadas(origem.obtemLinha(), (origem.obtemColuna() + 1));
        return new ArrayList<>() {{
            add(origem);
            add(novaCoordenada);
        }};
    }
    
    private static List<Coordenadas> projetaTiroExplosivo(Coordenadas origem) {
        return new ArrayList<>() {{
            add(new Coordenadas(origem.obtemLinha() - 1, origem.obtemColuna() - 1));
            add(new Coordenadas(origem.obtemLinha() - 1, origem.obtemColuna()));
            add(new Coordenadas(origem.obtemLinha() - 1, origem.obtemColuna() + 1));
            add(new Coordenadas(origem.obtemLinha(), origem.obtemColuna() - 1));
            add(origem);
            add(new Coordenadas(origem.obtemLinha(), origem.obtemColuna() + 1));
            add(new Coordenadas(origem.obtemLinha() + 1, origem.obtemColuna() - 1));
            add(new Coordenadas(origem.obtemLinha() + 1, origem.obtemColuna()));
            add(new Coordenadas(origem.obtemLinha() + 1, origem.obtemColuna() + 1));
        }};
    }
}
