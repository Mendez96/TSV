/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.dao.SitiosDao;
import modelo.dao.ViajeDao;
import modelo.entidad.Viaje;
import modelo.entidad.Sitios;

/**
 *
 * @author User
 */
@ManagedBean
@ViewScoped
public class ViajeControl implements Serializable {

    private List<Viaje> listaViaje;
    private Viaje viaje;
    private List<SelectItem> listaSitios;

    @ManagedProperty("#{loginControl}")
    private LoginControl loginControl;

    public ViajeControl() {
        viaje = new Viaje();
    }

    public List<Viaje> getListaViaje() {
        ViajeDao pd = new ViajeDao();
        listaViaje = pd.listarViaje();
        return listaViaje;
    }

    public void setListaViaje(List<Viaje> listaViaje) {
        this.listaViaje = listaViaje;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public void limpiarViaje() {
        viaje = new Viaje();
        viaje.setFechaViaje(new Date());
    }

    public void agregarViaje() {
        ViajeDao pd = new ViajeDao();
        viaje.setUsuario(loginControl.getUsuario());
        pd.agregar(viaje);
    }

    public void modificarViaje() {
        ViajeDao pd = new ViajeDao();
        pd.modificar(viaje);
        limpiarViaje();
    }

    public void eliminarViaje() {
        ViajeDao pd = new ViajeDao();
        pd.eliminar(viaje);
        limpiarViaje();
    }

    public LoginControl getLoginControl() {
        return loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }

    public List<SelectItem> getListaSitios() {
        this.listaSitios = new ArrayList<SelectItem>();
        SitiosDao pd = new SitiosDao();
        List<Sitios> serv = pd.listarSitios();
        listaSitios.clear();
        for (Sitios sitios : serv) {
            SelectItem servicioItem = new SelectItem(sitios.getIdsitios(), sitios.getNombre());
            listaSitios.add(servicioItem);
        }
        return listaSitios;
    }

}
