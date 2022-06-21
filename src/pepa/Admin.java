/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepa;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Admin extends Thread{
    public boolean stop = true;
    
    
    public void StopToggle(){
        this.stop=!this.stop;
    }
    @Override
    public void run(){
        try {
            while (stop) {
                sleep(10);
                String texto="";
                Nodo temp= AAInterfaz.Prioridad1.pfirst;
                for (int i = 0; i < AAInterfaz.Prioridad1.size; i++) {
                    texto += temp.telefono.ID+"\n";
                    temp = temp.siguiente;
                }
                AAInterfaz.IDfab11.setText(texto);
                texto="";
                temp= AAInterfaz.Prioridad2.pfirst;
                for (int i = 0; i < AAInterfaz.Prioridad2.size; i++) {
                    texto += temp.telefono.ID+"\n";
                    temp = temp.siguiente;
                }
                AAInterfaz.IDfab12.setText(texto);
                texto="";
                temp= AAInterfaz.Prioridad3.pfirst;
                for (int i = 0; i < AAInterfaz.Prioridad3.size; i++) {
                    texto += temp.telefono.ID+"\n";
                    temp = temp.siguiente;
                }
                AAInterfaz.IDfab13.setText(texto);
                texto="";
                temp= AAInterfaz.Prioridad12.pfirst;
                for (int i = 0; i < AAInterfaz.Prioridad12.size; i++) {
                    texto += temp.telefono.ID+"\n";
                    temp = temp.siguiente;
                }
                AAInterfaz.IDfab21.setText(texto);
                texto="";
                temp= AAInterfaz.Prioridad22.pfirst;
                for (int i = 0; i < AAInterfaz.Prioridad22.size; i++) {
                    texto += temp.telefono.ID+"\n";
                    temp = temp.siguiente;
                }
                AAInterfaz.IDfab22.setText(texto);
                texto="";
                temp= AAInterfaz.Prioridad32.pfirst;
                for (int i = 0; i < AAInterfaz.Prioridad32.size; i++) {
                    texto += temp.telefono.ID+"\n";
                    temp = temp.siguiente;
                }
                AAInterfaz.IDfab23.setText(texto);
                if (!AAInterfaz.Refuerzo1.esta_vacia()) {
                    texto="";
                    temp= AAInterfaz.Refuerzo1.pfirst;
                    for (int i = 0; i < AAInterfaz.Refuerzo1.size; i++) {
                        texto += temp.telefono.ID+"\n";
                        temp = temp.siguiente;
                }
                }else{
                    texto="";
                }
                AAInterfaz.Refuerzofab1.setText(texto);
                if (!AAInterfaz.Refuerzo2.esta_vacia()) {
                    texto="";
                    temp= AAInterfaz.Refuerzo2.pfirst;
                    for (int i = 0; i < AAInterfaz.Refuerzo2.size; i++) {
                        texto += temp.telefono.ID+"\n";
                        temp = temp.siguiente;
                }
                }else{
                    texto="";
                }
                AAInterfaz.Refuerzofab2.setText(texto);
                if (AI.termino == true) {
                    int accion;
                    int max=100;
                    int min=0;
                    accion = (int)(Math.random()*(max-min+1)+min);
                    if (accion <= 70) {
                        Nodo temporal = new Nodo();
                        temporal=AAInterfaz.Refuerzo1.pfirst;
                        AAInterfaz.Refuerzo1.Desencolar();
                        AI.termino = false;
                    }if (accion>=70) {
                        AI.termino = false;
                    }
                }
            }
                } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
            

