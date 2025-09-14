package br.edu.cefsa.batalhanaval.utils;

public final class Utils {
    public static int geraNumeroRandomicoDeXaY(int x, int y) {
        return (int)(Math.random() * (y - x + 1)) + x;
    }
}
