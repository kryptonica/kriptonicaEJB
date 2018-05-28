/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptonica.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kriptonica.dao.UsuarioDAO;
import kriptonica.models.Usuario;

/**
 *
 * @author Mathe
 */
@Stateless
public class UsuarioBean implements UsuarioRemote {
    
    @PersistenceContext(unitName = "KriptonicaEJBPU")
    EntityManager em;

    @Override
    public Usuario salvar(Usuario u) throws Exception {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.salvar(u);
    }

    @Override
    public Usuario consultarPorID(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarPorId(id);
        
    }

    @Override
    public void remover(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        dao.remover(id);
    }
    
}
