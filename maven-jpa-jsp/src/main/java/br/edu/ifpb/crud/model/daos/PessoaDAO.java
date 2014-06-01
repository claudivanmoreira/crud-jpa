/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.crud.model.daos;

import br.edu.ifpb.crud.model.entidades.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author Claudivan Moreira
 */
public class PessoaDAO {

    private EntityManager manager;

    public PessoaDAO() {
        manager = JpaUtil.createEntityManager();
    }

    public void salvaPessoa(Pessoa pessoa) {
        manager.persist(pessoa);
    }

    public void atualizaPessoa(Pessoa pessoa) {
        manager.merge(pessoa);
    }

    public void removePessoa(Pessoa pessoa) {
        manager.remove(pessoa);
    }

    public Pessoa get(Long id) {
        Pessoa pessoa = null;
        try {
            pessoa = manager.find(Pessoa.class, id);
        } catch (IllegalArgumentException ex) {
        }
        return pessoa;
    }

    public List<Pessoa> getAllPessoa() {
        String query = "SELECT p FROM Pessoa p";
        return manager.createQuery(query).getResultList();
    }

    public void startTransaction() {
        manager.getTransaction().begin();
    }

    public void commitTransaction() {
        try {
            manager.getTransaction().commit();
            manager.close();
        } catch (PersistenceException ex) {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }
    }
}
