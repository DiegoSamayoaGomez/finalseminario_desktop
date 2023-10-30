/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author juanl
 */
@ManagedBean
@ViewScoped
public class BeanCliente {
    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String nit;
    private String telefono;
    private String direccion;
    private List listaClientes;

    @PostConstruct
    public void mostrar(){
        
        setListaClientes(CRUDs.CRUDCliente.universo());
    }
    
    public void prueba() {
        System.out.println("Prueba usuario: " + getNombre() + getApellido() + " dirección:" + getDireccion() + " nit: " + getNit()+" telefono: "+ getTelefono());
    }

    public void limpiar(){
        setNombre("");
        setApellido("");
        setDireccion("");
        setNit("");
        setTelefono("");
    }
    
    public void insertar2(){
        FacesContext context=FacesContext.getCurrentInstance();
        try{
            boolean flag=CRUDs.CRUDCliente.insert(nombre, apellido, direccion, nit, telefono, 1);
            if(flag){
                mostrar();
                limpiar();
                context.addMessage(null, new FacesMessage("Exito","Cliente ingresado"));
            }else{
                context.addMessage(null, new FacesMessage("Error","Revise que no haya sido ingresado antes"));
            }
        }catch(Exception e){
            context.addMessage(null, new FacesMessage("Error","Error"+e));
            System.out.println("error ="+e);
        }
    }
    
    public void modificar(){
        FacesContext context=FacesContext.getCurrentInstance();
        try{
            boolean flag=CRUDs.CRUDCliente.update(getIdCliente(),getNombre(),getApellido(), getNit(), getDireccion(), getTelefono(),1);
            if(flag){
                mostrar();
                limpiar();
                context.addMessage(null, new FacesMessage("Exito","Reguistro modificado"));
            }else{
                context.addMessage(null, new FacesMessage("Error","Revise que no los datos ingresados sean correctos"));
            }
        }catch(Exception e){
            context.addMessage(null, new FacesMessage("Error","Error"+e));
            System.out.println("error ="+e);
        }
    }
    
    public void anular(){
        FacesContext context=FacesContext.getCurrentInstance();
        try{
            boolean flag=CRUDs.CRUDCliente.anular(getIdCliente(),1);
            if(flag){
                mostrar();
                limpiar(); 
                context.addMessage(null, new FacesMessage("Exito","Reguistro anulado"));
            }else{
                context.addMessage(null, new FacesMessage("Error","Revise que no los datos ingresados sean correctos"));
            }
        }catch(Exception e){
            context.addMessage(null, new FacesMessage("Error","Error"+e));
            System.out.println("error ="+e);
        }
    }
    
//    Se extrae lo de la tabla y llena la informacion de cada insert en la tabla
    public void selecionarDatos(POJOs.Cliente cliente){
        setIdCliente(cliente.getIdCliente());
        setNombre(cliente.getNombre());
        setApellido(cliente.getApellido());
        setDireccion(cliente.getDireccion());
        setNit(cliente.getNit());
        setTelefono(cliente.getTelefono());
    }

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the listaClientes
     */
    public List getListaClientes() {
        return listaClientes;
    }

    /**
     * @param listaClientes the listaClientes to set
     */
    public void setListaClientes(List listaClientes) {
        this.listaClientes = listaClientes;
    }

}
