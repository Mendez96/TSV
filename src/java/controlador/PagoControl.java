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
import modelo.dao.PagoDao;
import modelo.entidad.Pago;
import modelo.entidad.Viaje;

/**
 *
 * @author User
 */
@ManagedBean
@ViewScoped
public class PagoControl implements Serializable {

    private List<Pago> listaPagos;
    private Pago pago;
    private List<SelectItem> listaViaje;

    @ManagedProperty("#{loginControl}")
    private LoginControl loginControl;

    public PagoControl() {
        pago = new Pago();
    }

    public List<Pago> getListaPagos() {
        PagoDao pd = new PagoDao();
        listaPagos = pd.listarPagos();
        return listaPagos;
    }

    public void setListaPagos(List<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public void limpiarPago() {
        pago = new Pago();
       
    }

    public void agregarPago() {
        PagoDao pd = new PagoDao();
        pago.setUsuario(loginControl.getUsuario());
        pd.agregar(pago);
    }

    public void modificarPago() {
        PagoDao pd = new PagoDao();
        pd.modificar(pago);
        limpiarPago();
    }

    public void eliminarPago() {
        PagoDao pd = new PagoDao();
        pd.eliminar(pago);
        limpiarPago();
    }

    public LoginControl getLoginControl() {
        return loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }

    public List<SelectItem> getListaViaje() {
        this.listaViaje = new ArrayList<SelectItem>();
        PagoDao pd = new PagoDao();
        List<Viaje> via = pd.listarViajes();
        listaViaje.clear();
        for (Viaje viaje : via) {
            SelectItem viajeItem = new SelectItem(viaje.getIdviaje(), viaje.getNombre());
            listaViaje.add(viajeItem);
        }
        return listaViaje;
    }

}
