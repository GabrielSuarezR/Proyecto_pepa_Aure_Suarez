/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepa;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;


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
    Telefono comp1;
    Telefono comp2;
    int progreso=0;
    int tiempo = 3500;
    boolean revisados = true;
    public static boolean termino = false;
    boolean actualizo = false;
    
    
    public void StopToggle(){
        this.stop=!this.stop;
    }
    private void animation(JProgressBar p) {
        for (int i = 0; i < 1000; i++) {
            p.setValue(i);
            try {
                sleep(tiempo/1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}

    @Override
    public void run(){
        try {
            while (stop) { 
                sleep(500);
            //Para prioridad 1
                if (revisados ==true) {
            if (AAInterfaz.Prioridad1.size!=0) {
                Nodo temporal = AAInterfaz.Prioridad1.getPfirst();
                comp1=temporal.telefono;
                AAInterfaz.Prioridad1.Desencolar();
//                AAInterfaz.tlfenfabrica.release();
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
                revisados = false;
                //Para prioridad 2
            }else{
                if (AAInterfaz.Prioridad2.size!=0) {
                    contadorcola2=0;
                    AAInterfaz.contadorfab12.setText(Integer.toString(contadorcola2));
                    Nodo temporal = AAInterfaz.Prioridad2.getPfirst();
                    comp1=temporal.telefono;
                    AAInterfaz.competidor1.setText(Integer.toString(temporal.telefono.ID));
                    AAInterfaz.Prioridad2.Desencolar();
//                    AAInterfaz.tlfenfabrica.release();
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
                    revisados = false;
                    //Para prioridad 3
                }else{
                     if (AAInterfaz.Prioridad3.size!=0) {
                         contadorcola3=0;
                         AAInterfaz.Contadorfab13.setText(Integer.toString(contadorcola3));
                        Nodo temporal = AAInterfaz.Prioridad3.getPfirst();
                        comp1=temporal.telefono;
                        AAInterfaz.competidor1.setText(Integer.toString(temporal.telefono.ID));
                        AAInterfaz.Prioridad3.Desencolar();
//                        AAInterfaz.tlfenfabrica.release();
                        AAInterfaz.Cantidadcola3.setText(Integer.toString(AAInterfaz.Prioridad3.size));
                     }
                     revisados = false;
                }
            }
                }
            //fab2
            //prioridad 1 
                if (revisados ==false) {
            if (AAInterfaz.Prioridad12.size!=0) {
                Nodo temporal = AAInterfaz.Prioridad12.getPfirst();
                comp2=temporal.telefono;
                AAInterfaz.Prioridad12.Desencolar();
//                AAInterfaz.tlfenfabrica2.release(1);
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
                actualizo = true;
                //Para prioridad 2
            }else{
                if (AAInterfaz.Prioridad22.size!=0) {
                    contadorcola22=0;
                    AAInterfaz.Contadorfab22.setText(Integer.toString(contadorcola22));
                    Nodo temporal = AAInterfaz.Prioridad22.getPfirst();
                    comp2=temporal.telefono;
                    AAInterfaz.Competidor2.setText(Integer.toString(temporal.telefono.ID));
                    AAInterfaz.Prioridad22.Desencolar();
//                    AAInterfaz.tlfenfabrica2.release(1);
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
                    actualizo = true;
                    //Para prioridad 3
                }else{
                     if (AAInterfaz.Prioridad32.size!=0) {
                         contadorcola23=0;
                         AAInterfaz.contadorfab23.setText(Integer.toString(contadorcola23));
                        Nodo temporal = AAInterfaz.Prioridad32.getPfirst();
                        comp2=temporal.telefono;
                        AAInterfaz.Competidor2.setText(Integer.toString(temporal.telefono.ID));
                        AAInterfaz.Prioridad32.Desencolar();
//                        AAInterfaz.tlfenfabrica2.release(1);
                        AAInterfaz.Cantidad2cola3.setText(Integer.toString(AAInterfaz.Prioridad32.size));
                     }
                     actualizo = true;
                }
            }
                }
            //combate
                if (actualizo == true) {
            AAInterfaz.copascomp1.setText(Integer.toString(comp1.Copas));
            AAInterfaz.copascomp2.setText(Integer.toString(comp2.Copas));
            animation(AAInterfaz.Progreso);
                sleep(10);
            int accion;
            int max=100;
            int min=0;
            accion = (int)(Math.random()*(max-min+1)+min);
            //Salida al marcado
                if (accion<=40) {
                    AAInterfaz.desicion.setText("Sale al mercado");
                    AAInterfaz.tlfenfabrica2.release(1);
                    AAInterfaz.tlfenfabrica.release();
                    AAInterfaz.batalla(comp1, comp2);
//                    if (comp1.Copas>comp2.Copas) {
//                        AAInterfaz.Mercado.append(comp1.Tipo+"  "+"ID:"+Integer.toString(comp1.ID)+"\n");
//                        AAInterfaz.escribirCsv(comp1.Tipo+"  "+"ID:"+Integer.toString(comp1.ID)+"\n");
//                    }if (comp2.Copas>comp1.Copas) {
//                        AAInterfaz.Mercado.append(comp2.Tipo+"  "+"ID:"+Integer.toString(comp2.ID)+"\n"); 
//                        AAInterfaz.escribirCsv(comp2.Tipo+"  "+"ID:"+Integer.toString(comp2.ID)+"\n");
//                    }
                    //empate
                }if (accion>=41 && accion<=67) {
                    AAInterfaz.desicion.setText("Empate");
                    AAInterfaz.Mazo1.setText("");
                    AAInterfaz.Mazo2.setText("");
                    AAInterfaz.definirprioridadgeneral1(comp1);
                    AAInterfaz.definirprioridadgeneral2(comp2);
                    // Refuerzo
                }if (accion>=68) {
                    AAInterfaz.desicion.setText("Requiere refuerzo");
                    AAInterfaz.Mazo1.setText("");
                    AAInterfaz.Mazo2.setText("");
                    AAInterfaz.Refuerzo1.Encolar(comp1);
                    AAInterfaz.Refuerzo2.Encolar(comp2);
                }
                if (AAInterfaz.revisados!=4) {
                    AAInterfaz.revisados +=2;
                }
                revisados = true;
                termino = true;
                actualizo=false;
                }
            
            } 
            
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
