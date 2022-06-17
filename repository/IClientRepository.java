package repository;

import entities.Cliente;

import java.util.Collection;
import java.util.List;

public interface IClientRepository {

    public Boolean cadastrar(Cliente cliente);

    public Cliente consultar(String cpf);

    public void alterar(Cliente cliente);

    public void excluir(String cpf);

    public Collection<Cliente> buscarTodos();
}
