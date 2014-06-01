/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.crud.model.servicos;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Claudivan Moreira
 */
public interface BaseService {
    
    public String execute(HttpServletRequest request);
    
}
