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
    
    public static int[] generarMazo(){
        int[] mazo = new int[8];
        int min = 1;
        int max = 16;
        int generadorCarta = 0; 
        int counter = 0;
        while (counter != 8){
            for (int i = 0; i < 8; i++) {
                generadorCarta = (int)(Math.random()*max + min);
                mazo[i] = generadorCarta;
                counter+=1;
            }
        }
        return mazo;
    }
    
    public static void batalla(Telefono comp1, Telefono comp2){
        
        // Calculo de calidad mazo Competidor 1
        
        int calidadMazo1 = 0;
        for (int i = 0; i < 8; i++) {
            calidadMazo1+=comp1.mazo[i];
        }
        
        // Calculo de calidad mazo Competidor 2
        
        int calidadMazo2 = 0;
        for (int i = 0; i < 8; i++) {
            calidadMazo1+=comp2.mazo[i];
        }
        //Decision ganador
        
        if (calidadMazo1 > calidadMazo2){
            //Gana Comp1
            
            Mercado.append(comp1.Tipo+"  "+"ID:"+Integer.toString(comp1.ID)+"\n");
            escribirCsv(comp1.Tipo+"  "+"ID:"+Integer.toString(comp1.ID)+"\n"); 
        }
        else if (calidadMazo1 < calidadMazo2){
            //Gana Comp2
            
            Mercado.append(comp2.Tipo+"  "+"ID:"+Integer.toString(comp2.ID)+"\n"); 
            escribirCsv(comp2.Tipo+"  "+"ID:"+Integer.toString(comp2.ID)+"\n");
        }
        else{
            // Se define por copas
            
            if (comp1.Copas>comp2.Copas) {
                //Gana Comp1
                
                Mercado.append(comp1.Tipo+"  "+"ID:"+Integer.toString(comp1.ID)+"\n");
                escribirCsv(comp1.Tipo+"  "+"ID:"+Integer.toString(comp1.ID)+"\n");
            }
            else{
                //Gana Comp2
                
                Mercado.append(comp2.Tipo+"  "+"ID:"+Integer.toString(comp2.ID)+"\n"); 
                escribirCsv(comp2.Tipo+"  "+"ID:"+Integer.toString(comp2.ID)+"\n");
            }
        }
        
    }
    
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
        this.setLocationRelativeTo(null);
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
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ventana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Colas");
        ventana.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 40, 24));

        Cola3fab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cola3fab1.setText("#3");
        ventana.add(Cola3fab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 60, 24));

        Cola2fab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cola2fab1.setText("#2");
        ventana.add(Cola2fab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 60, 24));

        Cola1fab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cola1fab1.setText("#1");
        ventana.add(Cola1fab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 60, 24));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fabrica2");
        ventana.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 200, 37));

        Comenzar.setText("BATALLA");
        Comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComenzarActionPerformed(evt);
            }
        });
        ventana.add(Comenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 200, 60));

        Cantidadcola1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cantidadcola1.setText("0");
        ventana.add(Cantidadcola1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 60, 20));

        Cantidadcola3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cantidadcola3.setText("0");
        ventana.add(Cantidadcola3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 60, 20));

        Cantidadcola2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cantidadcola2.setText("0");
        ventana.add(Cantidadcola2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 60, 20));

        jToggleButton2.setText("Guardar CSV");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        ventana.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Cola1fab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cola1fab2.setText("#1");
        ventana.add(Cola1fab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 60, 24));

        cola2fab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cola2fab2.setText("#2");
        ventana.add(cola2fab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 60, 24));

        cola3fab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cola3fab2.setText("#3");
        ventana.add(cola3fab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, 60, 24));

        Cantidad2cola3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cantidad2cola3.setText("0");
        ventana.add(Cantidad2cola3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, 60, 20));

        Cantidad2cola1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cantidad2cola1.setText("0");
        ventana.add(Cantidad2cola1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 60, 20));

        Cantidad2cola2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cantidad2cola2.setText("0");
        ventana.add(Cantidad2cola2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 60, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("AI");
        ventana.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 160, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DECISION");
        ventana.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 200, -1));

        desicion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desicion.setText("...");
        ventana.add(desicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 200, 20));

        jLabel7.setText("IDTelefonos");
        ventana.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        Competidor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Competidor2.setText("TLF2");
        ventana.add(Competidor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 200, 20));

        competidor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        competidor1.setText("TLF1");
        ventana.add(competidor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, 20));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("VS");
        ventana.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 200, 170));

        jLabel8.setText("Contador");
        ventana.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        Contadorfab13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Contadorfab13.setText("0");
        ventana.add(Contadorfab13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 60, 20));

        contadorfab12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contadorfab12.setText("0");
        ventana.add(contadorfab12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 60, 20));

        Contadorfab22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Contadorfab22.setText("0");
        ventana.add(Contadorfab22, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 60, 20));

        contadorfab23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contadorfab23.setText("0");
        ventana.add(contadorfab23, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 60, 20));

        Mercado.setEditable(false);
        Mercado.setColumns(20);
        Mercado.setRows(5);
        jScrollPane1.setViewportView(Mercado);

        ventana.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 200, 190));

        IDfab13.setEditable(false);
        IDfab13.setColumns(20);
        IDfab13.setRows(5);
        jScrollPane4.setViewportView(IDfab13);

        ventana.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 60, 240));

        IDfab23.setEditable(false);
        IDfab23.setColumns(20);
        IDfab23.setRows(5);
        jScrollPane5.setViewportView(IDfab23);

        ventana.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, 60, 240));

        IDfab12.setEditable(false);
        IDfab12.setColumns(20);
        IDfab12.setRows(5);
        jScrollPane6.setViewportView(IDfab12);

        ventana.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 60, 240));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Fabrica1");
        ventana.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 200, 37));

        IDfab11.setEditable(false);
        IDfab11.setColumns(20);
        IDfab11.setRows(5);
        jScrollPane7.setViewportView(IDfab11);

        ventana.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 60, 240));

        IDfab21.setEditable(false);
        IDfab21.setColumns(20);
        IDfab21.setRows(5);
        jScrollPane8.setViewportView(IDfab21);

        ventana.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 60, 240));

        IDfab22.setEditable(false);
        IDfab22.setColumns(20);
        IDfab22.setRows(5);
        jScrollPane9.setViewportView(IDfab22);

        ventana.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 60, 240));
        ventana.add(Progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 160, 20));

        copascomp1.setText("0");
        ventana.add(copascomp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 50, 20));

        copascomp2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copascomp2.setText("0");
        ventana.add(copascomp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 50, 20));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Cola Refuerzo 2");
        ventana.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 60, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cola Refuerzo 1");
        ventana.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 60, -1));

        Refuerzofab2.setEditable(false);
        Refuerzofab2.setColumns(20);
        Refuerzofab2.setRows(5);
        jScrollPane2.setViewportView(Refuerzofab2);

        ventana.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 60, 150));

        Refuerzofab1.setEditable(false);
        Refuerzofab1.setColumns(20);
        Refuerzofab1.setRows(5);
        jScrollPane3.setViewportView(Refuerzofab1);

        ventana.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 60, 150));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Historial de Ganadores");
        ventana.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 200, -1));

        jLabel14.setText("FC");
        ventana.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 30, 30));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("FC");
        ventana.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 30, 30));

        jTextField1.setEditable(false);
        ventana.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 130, 200));

        jTextField2.setEditable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        ventana.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 130, 200));

        getContentPane().add(ventana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 653));

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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JPanel ventana;
    // End of variables declaration//GEN-END:variables
}
