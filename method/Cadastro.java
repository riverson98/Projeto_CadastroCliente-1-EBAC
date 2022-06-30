package method;

import entities.Cliente;
import repository.IClientRepository;
import repository.impl.ClienteRepositoryImplMap;

import javax.swing.*;

public class Cadastro {
    static IClientRepository clientRepository = new ClienteRepositoryImplMap();

    public static boolean isOpcaoCadastrar(String opcao) {
        return "1".equals(opcao);
    }


    public static void cadastrarCliente(String dados) {

        String[] split = dados.split(",");

        String nomeCliente = split.length > 0 ? split[0] : null;
        String cpfCliente = split.length > 1 ? split[1] : null;
        String telCliente = split.length > 2 ? split[2] : null;
        String enderecoCliente = split.length > 3 ? split[3] : null;
        String numeroDaCasaCliente = split.length > 4 ? split[4] : null;
        String estadoDeMoradia = split.length > 5 ? split[5] : null;

        var cliente = new Cliente(nomeCliente, cpfCliente, telCliente, enderecoCliente,
                numeroDaCasaCliente, estadoDeMoradia);


        Boolean cadastrou = clientRepository.cadastrar(cliente);
        if (cadastrou.equals(true)) {
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar esse cliente" +
                            " ele ja se encontra no nosso banco de dados",
                    "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void consultar(String cpf) {

        var cliente = clientRepository.consultar(cpf);

        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: "
                    + cliente, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado: ",
                    "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void excluir(String cpf) {
        var cliente = clientRepository.consultar(cpf);
        if (cliente != null) {
            clientRepository.excluir(cpf);
            JOptionPane.showMessageDialog(null, "Cliente excluido",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar este cliente ",
                    "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void alterar(String cpf,String dados){
        var cliente = clientRepository.consultar(cpf);

        if (cliente != null) {
            String[] split = dados.split(",");
            String nomeCliente = split.length > 0 ? split[0] : null;
            String cpfCliente = split.length > 1 ? split[1] : null;
            String telCliente = split.length > 2 ? split[2] : null;
            String enderecoCliente = split.length > 3 ? split[3] : null;
            String numeroDaCasaCliente = split.length > 4 ? split[4] : null;
            String estadoDeMoradia = split.length > 5 ? split[5] : null;

            cliente.setNome(nomeCliente);
            cliente.setCpf(cpfCliente);
            cliente.setTelefone(telCliente);
            cliente.setEndereço(enderecoCliente);
            cliente.setNumero(numeroDaCasaCliente);
            cliente.setEstado(estadoDeMoradia);

            JOptionPane.showMessageDialog(null, "Cliente alterado: "
                    + cliente, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nao foi possivel alterar o cliente ",
                    "Erro", JOptionPane.INFORMATION_MESSAGE);
        }

    }


}

