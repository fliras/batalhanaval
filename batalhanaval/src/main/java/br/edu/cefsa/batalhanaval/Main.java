package br.edu.cefsa.batalhanaval;

import br.edu.cefsa.batalhanaval.main.factories.FactoryMaquinaDeJogo;

public class Main {
    public static void main(String[] args) {
        FactoryMaquinaDeJogo.cria().inicia();
    }
}
