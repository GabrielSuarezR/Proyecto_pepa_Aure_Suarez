/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class AAInterfaz extends javax.swing.JFrame {
    public static int revisados = 0;
    public static int cuenta1=0;
    public static int cuenta2=0;
    public static Semaphore mutex = new Semaphore(1);
    public static boolean EnProceso = false;
    public static int numeroID = 00000;
    public static Cola Prioridad1 = new Cola();
    public static Cola Prioridad2 = new Cola();
    public static Cola Prioridad3 = new Cola();
    public static Cola Refuerzo1 = new Cola();
    public static Semaphore tlfenfabrica = new Semaphore(20);
    public static Cola Prioridad12 = new Cola();
    public static Cola Prioridad22 = new Cola();
    public static Cola Prioridad32 = new Cola();
     public static Cola Refuerzo2 = new Cola();
    public static Semaphore tlfenfabrica2 = new Semaphore(20);
    /**
     * Creates new form AAInterfaz
     */
    public static void definirPrioridad(Telefono nuevo){
        try{
        if (nuevo.Copas>=3000) {
                AAInterfaz.Prioridad1.Encolar(nuevo);
                AAInterfaz.tlfenfabrica.acquire(1);
                AAInterfaz.Cantidadcola1.setText(Integer.toString(AAInterfaz.Prioridad1.size));
        }if (nuevo.Copas<3000 && nuevo.Copas>=2000) {
            AAInterfaz.Prioridad2.Encolar(nuevo);
            AAInterfaz.tlfenfabrica.acquire(1);
            AAInterfaz.Cantidadcola2.setText(Integer.toString(AAInterfaz.Prioridad2.size));
        }if (nuevo.Copas<2000) {
            AAInterfaz.Prioridad3.Encolar(nuevo);
            AAInterfaz.tlfenfabrica.acquire(1);
            AAInterfaz.Cantidadcola3.setText(Integer.toString(AAInterfaz.Prioridad3.size));
        }
        revisados=0;
            if (cuenta1!=20) {
                cuenta1+=1;   
            }
        }
            catch (InterruptedException ex) {
                Logger.getLogger(CreadorTlf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void definirPrioridad2(Telefono nuevo) {
        try{
        if (nuevo.Copas>=3000) {
            AAInterfaz.Prioridad12.Encolar(nuevo);
            AAInterfaz.tlfenfabrica2.acquire(1);
            AAInterfaz.Cantidad2cola1.setText(Integer.toString(AAInterfaz.Prioridad12.size));
        }if (nuevo.Copas<3000 && nuevo.Copas>=2000) {
            AAInterfaz.Prioridad22.Encolar(nuevo);
            AAInterfaz.tlfenfabrica2.acquire(1);
            AAInterfaz.Cantidad2cola2.setText(Integer.toString(AAInterfaz.Prioridad22.size));
        }if (nuevo.Copas<2000) {
            AAInterfaz.Prioridad32.Encolar(nuevo);
            AAInterfaz.tlfenfabrica2.acquire(1);
            AAInterfaz.Cantidad2cola3.setText(Integer.toString(AAInterfaz.Prioridad32.size));
        }
        revisados=0;
            if (cuenta2!=20) {
                cuenta2+=1;   
            }
        }
        catch (InterruptedException ex) {
                Logger.getLogger(CreadorTlf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void definirprioridadgeneral1(Telefono comp1){
        if (comp1.Copas>=3000) {
            AAInterfaz.Prioridad1.Encolar(comp1);
            AAInterfaz.Cantidadcola1.setText(Integer.toString(AAInterfaz.Prioridad1.size));
            }if (comp1.Copas<3000 && comp1.Copas>=2000) {
                AAInterfaz.Prioridad2.Encolar(comp1);
                AAInterfaz.Cantidadcola2.setText(Integer.toString(AAInterfaz.Prioridad2.size));
            }if (comp1.Copas<2000) {
                AAInterfaz.Prioridad3.Encolar(comp1);
                AAInterfaz.Cantidadcola3.setText(Integer.toString(AAInterfaz.Prioridad3.size));
            }
    }
    public static void definirprioridadgeneral2(Telefono comp2){
        if (comp2.Copas>=3000) {
            AAInterfaz.Prioridad12.Encolar(comp2);
            AAInterfaz.Cantidad2cola1.setText(Integer.toString(AAInterfaz.Prioridad12.size));
            }if (comp2.Copas<3000 && comp2.Copas>=2000) {
                AAInterfaz.Prioridad22.Encolar(comp2);
                AAInterfaz.Cantidad2cola2.setText(Integer.toString(AAInterfaz.Prioridad22.size));
            }if (comp2.Copas<2000) {
                AAInterfaz.Prioridad32.Encolar(comp2);
                AAInterfaz.Cantidad2cola3.setText(Integer.toString(AAInterfaz.Prioridad32.size));
            }
    }
    public static void escribirCsv(String telf){
        String historicoDespachos = "";
        String line;
        try {
            FileReader pw1 =new FileReader("test\\telefonos-mercado.csv");
            BufferedReader br = new BufferedReader(pw1);
                while ((line = br.readLine()) != null){
                    if (!line.isEmpty()){
                        historicoDespachos += line + "\n";
                    }
                }

        
            FileWriter pw = new FileWriter("test\\telefonos-mercado.csv");
            pw.append(historicoDespachos + telf);
            pw.close();
        } catch (Exception e) {
        }
    }
    
    public AAInterfaz() {
        initComponents();
        Progreso.setMaximum(1000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventana = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Cola3fab1 = new javax.swing.JLabel();
        Cola2fab1 = new javax.swing.JLabel();
        Cola1fab1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Comenzar = new javax.swing.JToggleButton();
        Cantidadcola1 = new javax.swing.JLabel();
        Cantidadcola3 = new javax.swing.JLabel();
        Cantidadcola2 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        Cola1fab2 = new javax.swing.JLabel();
        cola2fab2 = new javax.swing.JLabel();
        cola3fab2 = new javax.swing.JLabel();
        Cantidad2cola3 = new javax.swing.JLabel();
        Cantidad2cola1 = new javax.swing.JLabel();
        Cantidad2cola2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        desicion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Competidor2 = new javax.swing.JLabel();
        competidor1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Contadorfab13 = new javax.swing.JLabel();
        contadorfab12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Contadorfab22 = new javax.swing.JLabel();
        contadorfab23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mercado = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        IDfab13 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        IDfab23 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        IDfab12 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        IDfab11 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        IDfab21 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        IDfab22 = new javax.swing.JTextArea();
        Progreso = new javax.swing.JProgressBar();
        copascomp1 = new javax.swing.JLabel();
        copascomp2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Refuerzofab2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Refuerzofab1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ventana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Colas");
        ventana.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 32, 24));

        Cola3fab1.setText("#3");
        ventana.add(Cola3fab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 32, 24));

        Cola2fab1.setText("#2");
        ventana.add(Cola2fab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 32, 24));

        Cola1fab1.setText("#1");
        ventana.add(Cola1fab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 32, 24));

        jLabel1.setText("Fabrica2");
        ventana.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, -1, 37));

        Comenzar.setText("Comenzar proceso");
        Comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComenzarActionPerformed(evt);
            }
        });
        ventana.add(Comenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        Cantidadcola1.setText("0");
        ventana.add(Cantidadcola1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 30, 20));

        Cantidadcola3.setText("0");
        ventana.add(Cantidadcola3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 30, 20));

        Cantidadcola2.setText("0");
        ventana.add(Cantidadcola2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 30, 20));

        jToggleButton2.setText("Guardar CSV");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        ventana.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, -1));

        jLabel3.setText("Colas");
        ventana.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 32, 24));

        Cola1fab2.setText("#1");
        ventana.add(Cola1fab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 32, 24));

        cola2fab2.setText("#2");
        ventana.add(cola2fab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 32, 24));

        cola3fab2.setText("#3");
        ventana.add(cola3fab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 32, 24));

        Cantidad2cola3.setText("0");
        ventana.add(Cantidad2cola3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 30, 20));

        Cantidad2cola1.setText("0");
        ventana.add(Cantidad2cola1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 30, 20));

        Cantidad2cola2.setText("0");
        ventana.add(Cantidad2cola2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 30, 20));

        jLabel5.setText("AI");
        ventana.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 30, 20));

        jLabel6.setText("Desicion:");
        ventana.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        desicion.setText("...");
        ventana.add(desicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 110, 20));

        jLabel7.setText("IDTelefonos:");
        ventana.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        Competidor2.setText("TLF2");
        ventana.add(Competidor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 40, 20));

        competidor1.setText("TLF1");
        ventana.add(competidor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 50, 20));

        jLabel10.setText("VS");
        ventana.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 143, 20, 20));

        jLabel8.setText("Contador:");
        ventana.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        Contadorfab13.setText("0");
        ventana.add(Contadorfab13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 40, 20));

        contadorfab12.setText("0");
        ventana.add(contadorfab12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 40, 20));

        jLabel9.setText("Contador:");
        ventana.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        Contadorfab22.setText("0");
        ventana.add(Contadorfab22, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 40, 20));

        contadorfab23.setText("0");
        ventana.add(contadorfab23, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 40, 20));

        Mercado.setColumns(20);
        Mercado.setRows(5);
        jScrollPane1.setViewportView(Mercado);

        ventana.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 200, 200));

        IDfab13.setColumns(20);
        IDfab13.setRows(5);
        jScrollPane4.setViewportView(IDfab13);

        ventana.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 60, 440));

        IDfab23.setColumns(20);
        IDfab23.setRows(5);
        jScrollPane5.setViewportView(IDfab23);

        ventana.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 60, 440));

        IDfab12.setColumns(20);
        IDfab12.setRows(5);
        jScrollPane6.setViewportView(IDfab12);

        ventana.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 60, 440));

        jLabel4.setText("Fabrica1");
        ventana.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, 37));

        IDfab11.setColumns(20);
        IDfab11.setRows(5);
        jScrollPane7.setViewportView(IDfab11);

        ventana.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 60, 440));

        IDfab21.setColumns(20);
        IDfab21.setRows(5);
        jScrollPane8.setViewportView(IDfab21);

        ventana.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 60, 440));

        IDfab22.setColumns(20);
        IDfab22.setRows(5);
        jScrollPane9.setViewportView(IDfab22);

        ventana.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 60, 440));
        ventana.add(Progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, 20));

        copascomp1.setText("0");
        ventana.add(copascomp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 50, 20));

        copascomp2.setText("0");
        ventana.add(copascomp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 50, 20));

        jLabel12.setText("Cola Refuerzo 2");
        ventana.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, -1, -1));

        jLabel13.setText("Cola Refuerzo 1");
        ventana.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, -1));

        Refuerzofab2.setColumns(20);
        Refuerzofab2.setRows(5);
        jScrollPane2.setViewportView(Refuerzofab2);

        ventana.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 110, 150));

        Refuerzofab1.setColumns(20);
        Refuerzofab1.setRows(5);
        jScrollPane3.setViewportView(Refuerzofab1);

        ventana.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 110, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ventana, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ventana, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComenzarActionPerformed
        CreadorTlf hilotlfs = new CreadorTlf();
        hilotlfs.start();
        Creadortlf2 hilotlfs2 = new Creadortlf2();
        hilotlfs2.start();
        Admin administrador = new Admin();
        administrador.start();
        AI ai = new AI();
        ai.start();

    }//GEN-LAST:event_ComenzarActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed

    }//GEN-LAST:event_jToggleButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AAInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AAInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AAInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AAInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AAInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Cantidad2cola1;
    public static javax.swing.JLabel Cantidad2cola2;
    public static javax.swing.JLabel Cantidad2cola3;
    public static javax.swing.JLabel Cantidadcola1;
    public static javax.swing.JLabel Cantidadcola2;
    public static javax.swing.JLabel Cantidadcola3;
    private javax.swing.JLabel Cola1fab1;
    private javax.swing.JLabel Cola1fab2;
    private javax.swing.JLabel Cola2fab1;
    private javax.swing.JLabel Cola3fab1;
    private javax.swing.JToggleButton Comenzar;
    public static javax.swing.JLabel Competidor2;
    public static javax.swing.JLabel Contadorfab13;
    public static javax.swing.JLabel Contadorfab22;
    public static javax.swing.JTextArea IDfab11;
    public static javax.swing.JTextArea IDfab12;
    public static javax.swing.JTextArea IDfab13;
    public static javax.swing.JTextArea IDfab21;
    public static javax.swing.JTextArea IDfab22;
    public static javax.swing.JTextArea IDfab23;
    public static javax.swing.JTextArea Mercado;
    public static javax.swing.JProgressBar Progreso;
    public static javax.swing.JTextArea Refuerzofab1;
    public static javax.swing.JTextArea Refuerzofab2;
    private javax.swing.JLabel cola2fab2;
    private javax.swing.JLabel cola3fab2;
    public static javax.swing.JLabel competidor1;
    public static javax.swing.JLabel contadorfab12;
    public static javax.swing.JLabel contadorfab23;
    public static javax.swing.JLabel copascomp1;
    public static javax.swing.JLabel copascomp2;
    public static javax.swing.JLabel desicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JPanel ventana;
    // End of variables declaration//GEN-END:variables
}
