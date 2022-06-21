/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepa;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Creadortlf2 extends  Thread{
    public boolean stop = true;
            int probabilidad = 0;
    
    
    public void StopToggle(){
        this.stop=!this.stop;
    }
    @Override
    public void run(){
        while (stop) {  
            try{
                sleep(100);
                int max=100;
                int min=0;
                 if (AAInterfaz.cuenta1!=20) {
                    probabilidad = (int)(Math.random()*(max-min+1)+min);
                }
                probabilidad = (int)(Math.random()*(max-min+1)+min);
                if (probabilidad<=70) {
                if (AAInterfaz.revisados == 4| AAInterfaz.cuenta1 != 20) {
                if (AAInterfaz.tlfenfabrica2.availablePermits()!=0) {
                if (AAInterfaz.EnProceso==false) {
//                    for (int i = 0; i < 10; i++) {
                        max=100;
                        min=0;
                        int calidad=0;
                        int copastelefono = 0;
                        //copas por camara
                        for (int j = 0; j < 4; j++) {
                            calidad = (int)(Math.random()*(max-min+1)+min);
                            if (calidad<=80) {
                                copastelefono+=330;
                            }
                        }
                        //copas por botones
                        for (int k = 0; k < 3; k++) {
                            calidad = (int)(Math.random()*(max-min+1)+min);
                            if (calidad<=85) {
                                copastelefono+=320;
                            }
                        }
                        //copas por pantallas y pines de carga
                        calidad = (int)(Math.random()*(max-min+1)+min);
                        if (calidad<=75) {
                            copastelefono+=400;
                        }
                        calidad = (int)(Math.random()*(max-min+1)+min);
                        if (calidad<=84) {
                            copastelefono+=400;
                        }
                        AAInterfaz.mutex.acquire();
                        Telefono nuevo = new Telefono(AAInterfaz.numeroID+1, copastelefono, "Xperia 1 IV");
                        AAInterfaz.numeroID+=1;
                        AAInterfaz.mutex.release();
                        AAInterfaz.definirPrioridad2(nuevo);
//                    System.out.println(nuevo.Copas+" "+nuevo.ID);
//                    }
                }
            }
                }
                }
        }catch (InterruptedException ex) {
                Logger.getLogger(CreadorTlf.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
}
            

