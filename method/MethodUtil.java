package method;

import javax.swing.*;

public class MethodUtil {

    public static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao)
                || "4".equals(opcao) || "5".equals(opcao);
    }

    public static void sair() {
        JOptionPane.showMessageDialog(null,
                "Obrigado por utilizar nosso programa até logo",
                "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }



}
