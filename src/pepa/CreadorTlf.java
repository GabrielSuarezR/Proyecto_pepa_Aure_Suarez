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
public class CreadorTlf extends Thread{
    public boolean stop = true;
    
    
    public void StopToggle(){
        this.stop=!this.stop;
    }
    @Override
    public void run(){
        while (stop) {  
            try{
            AAInterfaz.Cantidadcola1.setText(Integer.toString(AAInterfaz.Prioridad1.size));
            AAInterfaz.Cantidadcola2.setText(Integer.toString(AAInterfaz.Prioridad2.size));
            AAInterfaz.Cantidadcola3.setText(Integer.toString(AAInterfaz.Prioridad3.size));
            sleep(100);
                System.out.println("b");
            if (AAInterfaz.tlfenfabrica.availablePermits()!=0) {
                if (AAInterfaz.EnProceso==false) {
                    for (int i = 0; i < 10; i++) {
                        int max=100;
                        int min=0;
                        int calidad=0;
                        int copastelefono = 0;
                        //copas por camara
                        for (int j = 0; j < 3; j++) {
                            calidad = (int)(Math.random()*(max-min+1)+min);
                            if (calidad<=80) {
                                copastelefono+=334;
                            }
                        }
                        //copas por botones
                        for (int k = 0; k < 4; k++) {
                            calidad = (int)(Math.random()*(max-min+1)+min);
                            if (calidad<=85) {
                                copastelefono+=334;
                            }
                        }
                        //copas por pantallas y pines de carga
                        calidad = (int)(Math.random()*(max-min+1)+min);
                        if (calidad<=75) {
                            copastelefono+=334;
                        }
                        calidad = (int)(Math.random()*(max-min+1)+min);
                        if (calidad<=84) {
                            copastelefono+=334;
                        }
                        Telefono nuevo = new Telefono(AAInterfaz.numeroID+1, copastelefono, "Xperia 10 IV");
                        AAInterfaz.numeroID+=1;
                        AAInterfaz.definirPrioridad(nuevo);
//                    System.out.println(nuevo.Copas+" "+nuevo.ID);
                    }
                }
            }

        }catch (InterruptedException ex) {
                Logger.getLogger(CreadorTlf.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
}
