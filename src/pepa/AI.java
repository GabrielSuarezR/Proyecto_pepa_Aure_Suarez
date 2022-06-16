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
    
    
    public void StopToggle(){
        this.stop=!this.stop;
    }
    @Override
    public void run(){
        try {
            while (stop) {                    
            sleep(140);
            if (AAInterfaz.Prioridad1.size!=0) {
                System.out.println(AAInterfaz.Prioridad1.size);
                Nodo temporal = AAInterfaz.Prioridad1.getPfirst();
                AAInterfaz.competidor1.setText(Integer.toString(temporal.telefono.ID));
                AAInterfaz.Prioridad1.Desencolar();
                AAInterfaz.tlfenfabrica.release();
                AAInterfaz.Cantidadcola1.setText(Integer.toString(AAInterfaz.Prioridad1.size));
            }else{
                if (AAInterfaz.Prioridad2.size!=0) {
                    System.out.println(AAInterfaz.Prioridad2.size);
                    Nodo temporal = AAInterfaz.Prioridad2.getPfirst();
                    AAInterfaz.competidor1.setText(Integer.toString(temporal.telefono.ID));
                    AAInterfaz.Prioridad2.Desencolar();
                    AAInterfaz.tlfenfabrica.release();
                    AAInterfaz.Cantidadcola2.setText(Integer.toString(AAInterfaz.Prioridad2.size));
                }else{
                     if (AAInterfaz.Prioridad2.size!=0) {
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
