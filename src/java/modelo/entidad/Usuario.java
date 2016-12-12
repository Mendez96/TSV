package modelo.entidad;
// Generated 10-Dec-2016 08:34:20 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idusuario;
     private String nombre;
     private String clave;
     private String nombreCompleto;
     private Date fechaCreacion;
     private String direccion;
     private Boolean activo;
     private Set<Pago> pagos = new HashSet<Pago>(0);
     private Set<Viaje> viajes = new HashSet<Viaje>(0);

    public Usuario() {
    }

    public Usuario(String nombre, String clave, String nombreCompleto, Date fechaCreacion, String direccion, Boolean activo, Set<Pago> pagos, Set<Viaje> viajes) {
       this.nombre = nombre;
       this.clave = clave;
       this.nombreCompleto = nombreCompleto;
       this.fechaCreacion = fechaCreacion;
       this.direccion = direccion;
       this.activo = activo;
       this.pagos = pagos;
       this.viajes = viajes;
    }
   
    public Integer getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNombreCompleto() {
        return this.nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Boolean getActivo() {
        return this.activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    public Set<Pago> getPagos() {
        return this.pagos;
    }
    
    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }
    public Set<Viaje> getViajes() {
        return this.viajes;
    }
    
    public void setViajes(Set<Viaje> viajes) {
        this.viajes = viajes;
    }




}


