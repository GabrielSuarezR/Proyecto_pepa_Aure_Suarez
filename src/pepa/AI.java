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
    int contadorcola22=0;
    int contadorcola23=0;
    
    
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
                        int copas= 2000-ascender.telefono.Copas;
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
                        int copas= 2000-ascender.telefono.Copas;
                        ascender.telefono.Copas = ascender.telefono.Copas+copas;
                        System.out.println(ascender.telefono.Copas);
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
            //fab2
            //prioridad 1 
            if (AAInterfaz.Prioridad12.size!=0) {
                Nodo temporal = AAInterfaz.Prioridad12.getPfirst();
                AAInterfaz.Prioridad12.Desencolar();
                System.out.println("hola");
                AAInterfaz.tlfenfabrica2.release(1);
                System.out.println(AAInterfaz.tlfenfabrica2.availablePermits());
                AAInterfaz.Cantidad2cola1.setText(Integer.toString(AAInterfaz.Prioridad12.size));
                AAInterfaz.Competidor2.setText(Integer.toString(temporal.telefono.ID));
                if (!AAInterfaz.Prioridad22.esta_vacia()) {
                    contadorcola22+=1;
                    AAInterfaz.Contadorfab22.setText(Integer.toString(contadorcola22));
                    if (contadorcola22==8) {
                        Nodo ascender = AAInterfaz.Prioridad22.pfirst;
                        AAInterfaz.Prioridad22.Desencolar();
                        int copas= 3000-ascender.telefono.Copas;
                        ascender.telefono.Copas = ascender.telefono.Copas+copas;
                        AAInterfaz.Prioridad12.Encolar(ascender.telefono);
                        AAInterfaz.Cantidad2cola2.setText(Integer.toString(AAInterfaz.Prioridad22.size));
                        AAInterfaz.Cantidad2cola1.setText(Integer.toString(AAInterfaz.Prioridad12.size));
                        AAInterfaz.Contadorfab22.setText(Integer.toString(contadorcola22));
                        contadorcola22=0;
                    }
                }
                if (!AAInterfaz.Prioridad32.esta_vacia()) {
                    contadorcola23+=1;
                    AAInterfaz.contadorfab23.setText(Integer.toString(contadorcola23));
                    if (contadorcola23==8) {
                    Nodo ascender = AAInterfaz.Prioridad32.pfirst;
                        AAInterfaz.Prioridad32.Desencolar();
                        int copas= 2000-ascender.telefono.Copas;
                        ascender.telefono.Copas = ascender.telefono.Copas+copas;
                        AAInterfaz.Prioridad22.Encolar(ascender.telefono);
                        AAInterfaz.Cantidad2cola2.setText(Integer.toString(AAInterfaz.Prioridad22.size));
                        AAInterfaz.Cantidad2cola3.setText(Integer.toString(AAInterfaz.Prioridad32.size));
                        AAInterfaz.contadorfab23.setText(Integer.toString(contadorcola23));
                        contadorcola23=0;
                    }
                }   
                //Para prioridad 2
            }else{
                if (AAInterfaz.Prioridad22.size!=0) {
                    contadorcola22=0;
                    AAInterfaz.Contadorfab22.setText(Integer.toString(contadorcola22));
                    Nodo temporal = AAInterfaz.Prioridad22.getPfirst();
                    AAInterfaz.Competidor2.setText(Integer.toString(temporal.telefono.ID));
                    AAInterfaz.Prioridad22.Desencolar();
                    AAInterfaz.tlfenfabrica2.release(1);
                    AAInterfaz.Cantidad2cola2.setText(Integer.toString(AAInterfaz.Prioridad22.size));
                    if (!AAInterfaz.Prioridad32.esta_vacia()) {
                    contadorcola23+=1;
                    AAInterfaz.contadorfab23.setText(Integer.toString(contadorcola23));
                    if (contadorcola23==8) {
                    Nodo ascender = AAInterfaz.Prioridad32.pfirst;
                        AAInterfaz.Prioridad32.Desencolar();
                        int copas= 2000-ascender.telefono.Copas;
                        ascender.telefono.Copas = ascender.telefono.Copas+copas;
                        AAInterfaz.Prioridad22.Encolar(ascender.telefono);
                        AAInterfaz.Cantidad2cola2.setText(Integer.toString(AAInterfaz.Prioridad22.size));
                        AAInterfaz.Cantidad2cola3.setText(Integer.toString(AAInterfaz.Prioridad32.size));
                        AAInterfaz.contadorfab23.setText(Integer.toString(contadorcola23));
                        contadorcola23=0;
                    }   
                }    
                    //Para prioridad 3
                }else{
                     if (AAInterfaz.Prioridad32.size!=0) {
                         contadorcola23=0;
                         AAInterfaz.contadorfab23.setText(Integer.toString(contadorcola23));
                        Nodo temporal = AAInterfaz.Prioridad32.getPfirst();
                        AAInterfaz.Competidor2.setText(Integer.toString(temporal.telefono.ID));
                        AAInterfaz.Prioridad32.Desencolar();
                        AAInterfaz.tlfenfabrica2.release(1);
                        AAInterfaz.Cantidad2cola3.setText(Integer.toString(AAInterfaz.Prioridad32.size));
                     }
                }
            }
            } 
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
