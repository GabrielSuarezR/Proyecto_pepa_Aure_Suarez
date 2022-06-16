/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepa;

/**
 *
 * @author gabriel
 */
public class Nodo<T> {
    Telefono telefono;
    int Prioridad;
    Nodo<T> siguiente;

    public Nodo() {
        this.telefono = telefono;
        this.siguiente = siguiente;
        this.Prioridad=Prioridad;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setproceso(Telefono telefono) {
        this.telefono = telefono;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    
    
    
    
}