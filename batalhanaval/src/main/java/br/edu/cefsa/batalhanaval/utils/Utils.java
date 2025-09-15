package br.edu.cefsa.batalhanaval.utils;

import javax.swing.JOptionPane;

public final class Utils {
    public static int geraNumeroRandomicoDeXaY(int x, int y) {
        return (int)(Math.random() * (y - x + 1)) + x;
    }
    
    public static int obtemInputNumerico(String prompt) {
        return Integer.parseInt(obtemInput(prompt));
    }
    
    public static String obtemInput(String prompt) {
        return JOptionPane.showInputDialog(null, prompt, "Batalha Naval", JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
