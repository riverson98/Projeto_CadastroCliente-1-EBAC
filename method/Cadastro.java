package method;

import entities.Cliente;
import repository.IClientRepository;
import repository.impl.ClienteRepositoryImplMap;

import javax.swing.*;
import java.util.Arrays;
import java.util.Optional;

public class Cadastro {

    public static boolean isOpcaoCadastrar(String opcao) {
        return "1".equals(opcao);
    }

    public static void cadastrarCliente(String dados) {
        var clientRepository = new ClienteRepositoryImplMap();
        String[] split = dados.split(",");

       var tamanhoDoArray = split.length;
        var cliente = new Cliente(null, null, null, null, null, null);

            if (split[0] != null) {
                cliente.setNome(split[0]);
            }
            if (!split[1].equals("")) {
                cliente.setCpf(split[1]);
            }
            if (!split[2].equals("")) {
                cliente.setTelefone(split[2]);
            }
            if (split[3] != null) {
                cliente.setEndereço(split[3]);
            }
            if (split[4] != null) {
                cliente.setNumero(split[4]);
            }
            if (split[5] != null) {
                cliente.setEstado(split[5]);
            }

            Boolean cadastrou = clientRepository.cadastrar(cliente);
            if (cadastrou.equals(true)) {
                JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar esse cliente" +
                                " ele ja se encontra no nosso banco de dados",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
