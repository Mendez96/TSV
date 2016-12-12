/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import modelo.dao.SitiosDao;
import modelo.entidad.Sitios;



/**
 *
 * @author User
 */
@ManagedBean
@ViewScoped
public class SitiosControl implements Serializable {

    private List<Sitios> listaSitios;
    private Sitios sitios;
    
    @ManagedProperty("#{loginControl}")
    private LoginControl loginControl;

    public SitiosControl() {
    }

    public List<Sitios> getListaSitios() {
        SitiosDao sd = new SitiosDao();
        listaSitios = sd.listarSitios();
        return listaSitios;
    }

    public void setListaSitios(List<Sitios> listaSitios) {
        this.listaSitios = listaSitios;
    }

    public Sitios getSitios() {
        return sitios;
    }

    public void setSitios(Sitios sitios) {
        this.sitios = sitios;
    }

    public void limpiarSitios() {
        sitios = new Sitios();
       
    }

    public void agregarSitios() {
        SitiosDao sd = new SitiosDao();
        sitios.setUsuario(loginControl.getUsuario());
        sd.agregar(sitios);
    }

    public void modificarSitios() {
        SitiosDao sd = new SitiosDao();
        sd.modificar(sitios);
        limpiarSitios();
    }

    public void eliminarSitios() {
        SitiosDao sd = new SitiosDao();
        sd.eliminar(sitios);
        limpiarSitios();
    }

    public LoginControl getLoginControl() {
        return loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }   
}
