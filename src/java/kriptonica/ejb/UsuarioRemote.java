/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptonica.ejb;

import javax.ejb.Remote;
import kriptonica.models.Usuario;

/**
 *
 * @author Mathe
 */
@Remote
public interface UsuarioRemote {

    public Usuario salvar(Usuario u) throws Exception;

    public Usuario consultarPorID(Long id);

    public void remover(Long id);
}
