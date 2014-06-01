/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.crud.model.daos;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Claudivan Moreira
 */
public class JpaUtil {

    public static EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory("CRUDJPA-PU").createEntityManager();
    }

}
