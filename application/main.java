package application;

import repository.IClientRepository;
import repository.impl.ClienteRepositoryImplMap;

import javax.swing.*;

import static method.Alterar.isOpcaoAlterar;
import static method.Cadastro.cadastrarCliente;
import static method.Cadastro.isOpcaoCadastrar;
import static method.Consultar.isOpcaoConsultar;
import static method.Excluir.isOpcaoExclusao;
import static method.MethodUtil.*;
import static method.Sair.isOpcaoSair;

public class main {


        public static void main(String[] args) {

            IClientRepository clientRepository = new ClienteRepositoryImplMap();

            String opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para fazer uma consulta, 3 para exclusão, " +
                            "4 para alteração, 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);

            while (!isOpcaoValida(opcao)){
                 opcao = JOptionPane.showInputDialog(null,
                        "Opção inválida digite 1 para cadastro, 2 para fazer uma consulta, 3 para exclusão, " +
                                "4 para alteração, 5 para sair",
                        "Green dinner", JOptionPane.INFORMATION_MESSAGE);
            }

            while (isOpcaoValida(opcao)){
                   if(isOpcaoCadastrar(opcao)){
                   String dados =JOptionPane.showInputDialog(null,
                           "Digite o nome, cpf, telefone, endereço, numero da casa, e o estado separados" +
                                   " por virgula", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    cadastrarCliente(dados);
                   }
               else if (isOpcaoConsultar(opcao)){
                   String cpf =JOptionPane.showInputDialog(null,
                           "Digite o cpf que você deseja consultar"
                           , "Consulta", JOptionPane.INFORMATION_MESSAGE);
                   clientRepository.consultar(cpf);
               }
               else if (isOpcaoExclusao(opcao)){
                   String cpf =JOptionPane.showInputDialog(null,
                           "Digite o cpf que você deseja excluir"
                           , "Excluir", JOptionPane.INFORMATION_MESSAGE);
                   clientRepository.excluir(cpf);
                   JOptionPane.showMessageDialog(null,
                           "Cliente excluido com sucesso",
                           "Exclusão", JOptionPane.INFORMATION_MESSAGE);
               }
               else if(isOpcaoAlterar(opcao)){
                   String cpf =JOptionPane.showInputDialog(null,
                           "Digite o cpf que você deseja alterar"
                           , "Excluir", JOptionPane.INFORMATION_MESSAGE);
                   var cliente=clientRepository.consultar(cpf);
                   String dados = JOptionPane.showInputDialog(null,
                           "Digite os dados que voce deseja alterar separdos por virgula"
                           , "Excluir", JOptionPane.INFORMATION_MESSAGE);
                   clientRepository.alterar(cliente);
                JOptionPane.showMessageDialog(null,
                        "Cliente Alterado com sucesso",
                        "Alteração", JOptionPane.INFORMATION_MESSAGE);
            }
               else if(isOpcaoSair(opcao)) {
                   sair();
               }

            }
    }



}
