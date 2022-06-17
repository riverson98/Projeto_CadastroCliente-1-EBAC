package repository.impl;

import entities.Cliente;
import repository.IClientRepository;

import java.util.*;

public class ClientRepositoryImplSet implements IClientRepository {

    Set<Cliente> set;

    public ClientRepositoryImplSet() {
        this.set = new HashSet<>();
    }


    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.set.add(cliente);
    }

    @Override
    public Cliente consultar(String cpf) {
        for (Cliente clienteCadastrado : this.set) {
            if (clienteCadastrado.getCpf().equals(cpf)) {
                return clienteCadastrado;
            }
        }
        return null;
    }

    @Override
    public void alterar(Cliente cliente) {

        if (this.set.contains(cliente)) {
            for (Cliente clienteCadastrado : this.set) {
                if (clienteCadastrado.equals(cliente)) {
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setCpf(cliente.getCpf());
                    clienteCadastrado.setTelefone(cliente.getTelefone());
                    clienteCadastrado.setEndereço(cliente.getEndereço());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public void excluir(String cpf) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : this.set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrado = cliente;
                break;
            }
            if (clienteEncontrado != null) {
                this.set.remove(clienteEncontrado);
            }
        }
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }

}
