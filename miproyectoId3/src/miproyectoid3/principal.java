/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miproyectoid3;

import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.DefaultCellEditor;
import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public class principal extends javax.swing.JFrame {
    Object[] []datos = {};
    String [] ColumNames  = {};
    DefaultTableModel dtm= new DefaultTableModel(datos,ColumNames);
    int filas = 0;
    int columnas= 0;
   
    public principal() {
        initComponents();
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, false);
        jButton3.setEnabled(false);
        jButtonCompletado.setEnabled(false);
        jButton1.setEnabled(false);
        jButton4.setEnabled(false);
    }
   
    public static void reiniciarJTable(JTable table){
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
 
        TableColumnModel modCol = table.getColumnModel();
        while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
    }
   
    public void agregar_fila_ejemplos(){
        DefaultTableModel temp = (DefaultTableModel) jTableEjemplos.getModel();
        Object nuevo[]= {temp.getRowCount()+1,"",""};
        temp.addRow(nuevo);
    }
   
    public void agregar_fila(){
        DefaultTableModel temp = (DefaultTableModel) jTablefACTORES.getModel();
        Object nuevo[]= {"","",""};
        temp.addRow(nuevo);
    }

    //Para cualquier tabla
  /*  public void agregar_fila(DefaultTableModel tabla){
        DefaultTableModel temp = tabla;
        Object nuevo[]= {temp.getRowCount()+1,"",""};
        temp.addRow(nuevo);
    }*/
    
    //Para la tabla factores
    public void quitar_fila(){
        try
        {
            DefaultTableModel temp = (DefaultTableModel) jTablefACTORES.getModel();
            temp.removeRow(temp.getRowCount()-1);
        }
        catch(ArrayIndexOutOfBoundsException e){ }
    }
  
    //Para la tabla ejemplos
    public void quitar_fila(int fila){
        try{
            DefaultTableModel temp = (DefaultTableModel) jTableEjemplos.getModel();
            temp.removeRow(fila);
        }
        catch(ArrayIndexOutOfBoundsException e){ }
    }
    
    public void AgregarFactor(){
        try {
            dtm.addColumn(txtFactor.getText().toUpperCase());
            jTablefACTORES.setModel(dtm);
            if(dtm.getColumnCount()==1)
                agregar_fila();
        } catch (Exception e) {
            System.out.println("El error dice: \n" + e);
        }
        
        filas++;  
    }
 
    
    public void combo(int num, Object[] DATA){
        //String[] DATA = { "Dato 1", "Dato 2", "Dato 3", "Dato 4" };
        JComboBox comboBox = new JComboBox(DATA);
        DefaultCellEditor defaultCellEditor=new DefaultCellEditor(comboBox);
        jTableEjemplos.getColumnModel().getColumn(num).setCellEditor(defaultCellEditor);
    }
    
    public void pasarDatos(){
        String [] ColumnEjemplos= new String[]{ } ;
        Object datosEjemplos [][] = { };
        DefaultTableModel ejemplosModel = new DefaultTableModel(datosEjemplos,ColumnEjemplos);
        ejemplosModel.addColumn("numero", ColumnEjemplos);
        for (int i = 0; i <= jTablefACTORES.getColumnCount()-1 ; i++) {
            ejemplosModel.addColumn(jTablefACTORES.getColumnName(i), ColumnEjemplos);
            //ColumnEjemplos  [i]= jTablefACTORES.getColumnName(i);
        }
        ejemplosModel.addColumn("resultados", ColumnEjemplos);
        jTableEjemplos.setModel(ejemplosModel);
        agregar_fila_ejemplos();
       // String[] Datos=new String[jTablefACTORES.getRowCount()];
        ArrayList Datos=new ArrayList();
        try{
            for(int i=0; i<jTablefACTORES.getColumnCount(); i++){
                System.out.println("En la columna "+jTablefACTORES.getColumnName(i));
                for(int j=0;j<jTablefACTORES.getRowCount();j++){
                    System.out.println("  Valor: "+jTablefACTORES.getValueAt(j, i));
                    if(!jTablefACTORES.getValueAt(j, i).toString().equals(""))
                        Datos.add(jTablefACTORES.getValueAt(j, i));
                }
                System.out.println(Datos);
                combo(i+1, Datos.toArray());
                Datos.removeAll(Datos);    
            }
            Datos.add(jTableResultados.getValueAt(0, 0));
            Datos.add(jTableResultados.getValueAt(1, 0));
            combo(jTableEjemplos.getColumnCount()-1, Datos.toArray());
        } catch(Exception e){
            System.out.println(e);
        };
    }
        
  
    /**
     * Creates new form principal
     */
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablefACTORES = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonCompletado = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFactor = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEjemplos = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnElimEjem = new javax.swing.JButton();
        btnNuevoEjem = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel7 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ID3");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTablefACTORES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jTablefACTORES.setAutoscrolls(false);
        jTablefACTORES.setColumnSelectionAllowed(true);
        jTablefACTORES.setSelectionBackground(new java.awt.Color(137, 171, 255));
        jTablefACTORES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTablefACTORESKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTablefACTORES);

        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"SI"},
                {"NO"}
            },
            new String [] {
                "RESULTADOS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableResultados);

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("-");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonCompletado.setText("Guardar");
        jButtonCompletado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompletadoActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Factor:");

        txtFactor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFactorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCompletado))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCompletado)
                            .addComponent(jButton3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Definiciones", jPanel2);

        jTableEjemplos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableEjemplos.setSelectionBackground(new java.awt.Color(137, 171, 255));
        jScrollPane3.setViewportView(jTableEjemplos);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnElimEjem.setText("Eliminar");
        btnElimEjem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimEjemActionPerformed(evt);
            }
        });

        btnNuevoEjem.setText("Nuevo");
        btnNuevoEjem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEjemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnNuevoEjem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnElimEjem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnElimEjem)
                    .addComponent(btnNuevoEjem))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ejemplos", jPanel5);

        jScrollPane4.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Regla", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Prueba", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AgregarFactor();
        if(jTablefACTORES.getColumnCount()==1){
            jButtonCompletado.setEnabled(true);
            jButton3.setEnabled(true);
            jButton1.setEnabled(true);
            jButton4.setEnabled(true);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        for (int i = 0; i < ColumNames.length; i++) {
            System.out.println("columna ! ="+ i +" nombre: "+ColumNames[i]);
        }
        try {
            
            JComboBox<String> combo = new JComboBox<>(ColumNames);
            String[] options = { "OK", "Cancel" };

            String title = "Title";
            int selection = JOptionPane.showOptionDialog(null, combo, title,
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
            options, options[0]);

            if (selection > 0) {
                System.out.println("selection is: " + options[selection]);
            }

            Object weekday = combo.getSelectedItem();
            jTablefACTORES.getColumnModel().removeColumn(jTablefACTORES.getColumnModel().getColumn((int) weekday));
        } catch (Exception e) {
        }        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregar_fila();  
        if(!jButtonCompletado.isEnabled())
            jButtonCompletado.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        quitar_fila();        // TODO add your handling code here:    
        if(jTablefACTORES.getRowCount()==0){
            jButtonCompletado.setEnabled(false);
        };
    }//GEN-LAST:event_jButton4ActionPerformed

    
    private void jButtonCompletadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompletadoActionPerformed
        pasarDatos();        // TODO add your handling code here:
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);
        
        
    }//GEN-LAST:event_jButtonCompletadoActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jTablefACTORESKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablefACTORESKeyTyped
       /* if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            agregar_fila();
        } */       // TODO add your handling code here:
    }//GEN-LAST:event_jTablefACTORESKeyTyped

    private void btnNuevoEjemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEjemActionPerformed
        agregar_fila_ejemplos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoEjemActionPerformed

    private void btnElimEjemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimEjemActionPerformed
        System.out.println("La fila es: " + jTableEjemplos.getSelectedRow());
        quitar_fila(jTableEjemplos.getSelectedRow());
        
    }//GEN-LAST:event_btnElimEjemActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        jTabbedPane1.setEnabledAt(2, true);
        jTabbedPane1.setEnabledAt(3, true);
        jTabbedPane1.setSelectedIndex(2);        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtFactorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFactorKeyTyped
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            AgregarFactor();
            if(jTablefACTORES.getColumnCount()==1){
                jButtonCompletado.setEnabled(true);
                jButton3.setEnabled(true);
                jButton1.setEnabled(true);
                jButton4.setEnabled(true);
            }
            txtFactor.setText("");
        }
    }//GEN-LAST:event_txtFactorKeyTyped

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnElimEjem;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevoEjem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonCompletado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableEjemplos;
    private javax.swing.JTable jTableResultados;
    private javax.swing.JTable jTablefACTORES;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField txtFactor;
    // End of variables declaration//GEN-END:variables
}
