/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptonica.dao;

import javax.persistence.EntityManager;
import kriptonica.models.Usuario;

/**
 *
 * @author Mathe
 */
public class UsuarioDAO {

    private final EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public Usuario salvar(Usuario p) throws Exception {
        if (p.getId() == null) {
            em.persist(p);
        } else {
            if (!em.contains(p)) {
                if (em.find(Usuario.class, p.getId()) == null) {
                    throw new Exception("Erro ao atualizar os dados da Pessoa!");
                }
            }
            p = em.merge(p);
        }
        return p;
    }

    public Usuario consultarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    public void remover(Long id) {
        Usuario p = consultarPorId(id);
        em.remove(p);
    }

}
