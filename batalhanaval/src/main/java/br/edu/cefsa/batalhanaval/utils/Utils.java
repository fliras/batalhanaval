package br.edu.cefsa.batalhanaval.utils;

import javax.swing.JOptionPane;

public final class Utils {
    public static int geraNumeroRandomicoDeXaY(int x, int y) {
        return (int)(Math.random() * (y - x + 1)) + x;
    }
    
    public static int obtemOpcaoNumerica(String prompt) {
        try {
            int opcao = Integer.parseInt(obtemInput(prompt));
            if (opcao <= 0) return -1;
            return opcao;
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }
    
    public static String obtemInput(String prompt) {
        return JOptionPane.showInputDialog(null, prompt, "Batalha Naval", JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
