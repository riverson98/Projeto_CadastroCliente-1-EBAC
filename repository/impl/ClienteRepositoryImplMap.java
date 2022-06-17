package repository.impl;

import entities.Cliente;
import repository.IClientRepository;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ClienteRepositoryImplMap implements IClientRepository {

    Map<String, Cliente> map;

    public ClienteRepositoryImplMap() {
        map = new TreeMap<>();
    }


    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(map.containsKey(cliente.getCpf())){
            return false;
        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Cliente consultar(String cpf) {
           return this.map.get(cpf);
    }

    @Override
    public void alterar(Cliente cliente) {

        Cliente clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setCpf(cliente.getCpf());
        clienteCadastrado.setTelefone(cliente.getTelefone());
        clienteCadastrado.setEndereço(cliente.getEndereço());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setEstado(cliente.getEstado());
    }

    @Override
    public void excluir(String cpf) {
        Cliente clienteCadastrado = map.get(cpf);
        map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
