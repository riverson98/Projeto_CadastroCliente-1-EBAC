package method;

import entities.Cliente;
import repository.IClientRepository;
import repository.impl.ClienteRepositoryImplMap;

import javax.swing.*;

public class Consultar {

    public static boolean isOpcaoConsultar(String opcao) {
        return "2".equals(opcao);
    }
}
