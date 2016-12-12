/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;

import modelo.entidad.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.UsuarioDao;

@ManagedBean
@ViewScoped
public class UsuarioControl {

    private List<Usuario> listaUsuarios;
    private Usuario usuario;

    public UsuarioControl() {
    }

    public List<Usuario> getListaUsuarios() {
        UsuarioDao ud = new UsuarioDao();
        listaUsuarios = ud.listarUsuarios();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void limpiarUsuario() {
        usuario = new Usuario();
        usuario.setFechaCreacion(new Date());
    }

    public void agregarUsuario() {
        UsuarioDao ud = new UsuarioDao();
        ud.agregar(usuario);
    }

    public void modificarUsuario() {
        UsuarioDao ud = new UsuarioDao();
        ud.modificar(usuario);
        limpiarUsuario();
    }

    public void eliminarUsuario() {
        UsuarioDao ud = new UsuarioDao();
        ud.eliminar(usuario);
        limpiarUsuario();
    }

}
