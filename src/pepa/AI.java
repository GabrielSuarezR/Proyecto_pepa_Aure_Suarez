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
public class AI extends Thread{
    public boolean stop = true;
    int contadorcola2=0;
    int contadorcola3=0;
    
    
    public void StopToggle(){
        this.stop=!this.stop;
    }
    @Override
    public void run(){
        try {
            while (stop) {                    
            sleep(3400);
            //Para prioridad 1
            if (AAInterfaz.Prioridad1.size!=0) {
                Nodo temporal = AAInterfaz.Prioridad1.getPfirst();
                AAInterfaz.Prioridad1.Desencolar();
                AAInterfaz.tlfenfabrica.release();
                AAInterfaz.Cantidadcola1.setText(Integer.toString(AAInterfaz.Prioridad1.size));
                AAInterfaz.competidor1.setText(Integer.toString(temporal.telefono.ID));
                if (!AAInterfaz.Prioridad2.esta_vacia()) {
                    contadorcola2+=1;
                    AAInterfaz.contadorfab12.setText(Integer.toString(contadorcola2));
                    if (contadorcola2==8) {
                        Nodo ascender = AAInterfaz.Prioridad2.pfirst;
                        AAInterfaz.Prioridad2.Desencolar();
                        int copas= 3000-ascender.telefono.Copas;
                        ascender.telefono.Copas = ascender.telefono.Copas+copas;
                        AAInterfaz.Prioridad1.Encolar(ascender.telefono);
                        AAInterfaz.Cantidadcola2.setText(Integer.toString(AAInterfaz.Prioridad2.size));
                        AAInterfaz.Cantidadcola1.setText(Integer.toString(AAInterfaz.Prioridad1.size));
                        AAInterfaz.contadorfab12.setText(Integer.toString(contadorcola2));
                        contadorcola2=0;
                    }
                }
                if (!AAInterfaz.Prioridad3.esta_vacia()) {
                    contadorcola3+=1;
                    AAInterfaz.Contadorfab13.setText(Integer.toString(contadorcola3));
                    if (contadorcola3==8) {
                    Nodo ascender = AAInterfaz.Prioridad3.pfirst;
                        AAInterfaz.Prioridad3.Desencolar();
                        int copas= 3000-ascender.telefono.Copas;
                        ascender.telefono.Copas = ascender.telefono.Copas+copas;
                        AAInterfaz.Prioridad2.Encolar(ascender.telefono);
                        AAInterfaz.Cantidadcola2.setText(Integer.toString(AAInterfaz.Prioridad2.size));
                        AAInterfaz.Cantidadcola3.setText(Integer.toString(AAInterfaz.Prioridad3.size));
                        AAInterfaz.Contadorfab13.setText(Integer.toString(contadorcola3));
                        contadorcola3=0;
                    }
                }   
                //Para prioridad 2
            }else{
                if (AAInterfaz.Prioridad2.size!=0) {
                    contadorcola2=0;
                    AAInterfaz.contadorfab12.setText(Integer.toString(contadorcola2));
                    Nodo temporal = AAInterfaz.Prioridad2.getPfirst();
                    AAInterfaz.competidor1.setText(Integer.toString(temporal.telefono.ID));
                    AAInterfaz.Prioridad2.Desencolar();
                    AAInterfaz.tlfenfabrica.release();
                    AAInterfaz.Cantidadcola2.setText(Integer.toString(AAInterfaz.Prioridad2.size));
                    if (!AAInterfaz.Prioridad3.esta_vacia()) {
                    contadorcola3+=1;
                    AAInterfaz.Contadorfab13.setText(Integer.toString(contadorcola3));
                    if (contadorcola3==8) {
                    Nodo ascender = AAInterfaz.Prioridad3.pfirst;
                        AAInterfaz.Prioridad3.Desencolar();
                        int copas= 3000-ascender.telefono.Copas;
                        ascender.telefono.Copas = ascender.telefono.Copas+copas;
                        AAInterfaz.Prioridad2.Encolar(ascender.telefono);
                        AAInterfaz.Cantidadcola2.setText(Integer.toString(AAInterfaz.Prioridad2.size));
                        AAInterfaz.Cantidadcola3.setText(Integer.toString(AAInterfaz.Prioridad3.size));
                        AAInterfaz.Contadorfab13.setText(Integer.toString(contadorcola3));
                        contadorcola3=0;
                    }   
                }    
                    //Para prioridad 3
                }else{
                     if (AAInterfaz.Prioridad3.size!=0) {
                         contadorcola3=0;
                         AAInterfaz.Contadorfab13.setText(Integer.toString(contadorcola3));
                        Nodo temporal = AAInterfaz.Prioridad3.getPfirst();
                        AAInterfaz.competidor1.setText(Integer.toString(temporal.telefono.ID));
                        AAInterfaz.Prioridad3.Desencolar();
                        AAInterfaz.tlfenfabrica.release();
                        AAInterfaz.Cantidadcola3.setText(Integer.toString(AAInterfaz.Prioridad3.size));
                     }
                }
            }
            } 
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
