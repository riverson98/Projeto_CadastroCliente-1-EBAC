package application;

import repository.IClientRepository;
import repository.impl.ClienteRepositoryImplMap;

import javax.swing.*;

import static method.Alterar.isOpcaoAlterar;
import static method.Cadastro.*;
import static method.Consultar.isOpcaoConsultar;
import static method.Excluir.isOpcaoExclusao;
import static method.MethodUtil.isOpcaoValida;
import static method.MethodUtil.sair;
import static method.Sair.isOpcaoSair;

public class App {


    public static void main(String[] args) {

        IClientRepository clientRepository = new ClienteRepositoryImplMap();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para fazer uma consulta, 3 para exclusão, " +
                        "4 para alteração, 5 para sair",
                "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida digite 1 para cadastro, 2 para consulta, 3 para cadastro, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        }
        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            }
            else if (isOpcaoCadastrar(opcao)) {
                var dados = JOptionPane.showInputDialog(null, "Digite o nome, cpf, telefone," +
                                " endereço, numero da casa, e o estado separados por virgula", "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
                cadastrarCliente(dados);
            }
            else if (isOpcaoConsultar(opcao)) {
                var cpf = JOptionPane.showInputDialog(null,
                        "Digite o cpf que você deseja consultar"
                        , "Consulta", JOptionPane.INFORMATION_MESSAGE);
                consultar(cpf);
            }
            else if (isOpcaoExclusao(opcao)) {
                var cpf = JOptionPane.showInputDialog(null,
                        "Digite o cpf que você deseja excluir"
                        , "Excluir", JOptionPane.INFORMATION_MESSAGE);
                excluir(cpf);
            }
            else if (isOpcaoAlterar(opcao)) {
                var cpf = JOptionPane.showInputDialog(null,
                        "Digite o cpf que você deseja alterar"
                        , "Alterar", JOptionPane.INFORMATION_MESSAGE);
                var dados = JOptionPane.showInputDialog(null,
                        "Digite os dados que voce deseja alterar separdos por virgula"
                        , "Alterar", JOptionPane.INFORMATION_MESSAGE);
                alterar(cpf,dados);
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para fazer uma consulta, 3 para exclusão, " +
                            "4 para alteração, 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
