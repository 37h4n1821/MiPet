/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mipet.Vista;

import java.io.IOException;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mipet.Modelo.Cliente;
import mipet.Modelo.Mascota;
import mipet.Controlador.MiPetAPI;
import mipet.Modelo.Tipo_Mascota;

/**
 *
 * @author Ethan Leiva 004D 07/09/2023
 */
public class MascotaDatos extends javax.swing.JFrame {

    /**
     * Creates new form MascotaDatos
     */
    private Mascota mascota;
    
    public MascotaDatos() throws IOException {
        initComponents();
        obtener_tipos();
        obtener_due�os();
        establecerDatos();
        mascota=null;
        setDefaultCloseOperation(MascotaDatos.DISPOSE_ON_CLOSE);
        ComboDue�os.setEnabled(true);
        Actualizar.setText("Agregar Mascota");
    }
    public MascotaDatos(Mascota mascota) throws IOException {
        initComponents();
        obtener_tipos();
        obtener_due�os();
        establecerDatos(mascota);
        setDefaultCloseOperation(MascotaDatos.DISPOSE_ON_CLOSE);
        this.mascota=mascota;
        ComboDue�os.setEnabled(false);
        Actualizar.setText("Actualizar Datos");
    }
    
    
    public MiPetAPI api;
    
    
    
    public void establecerDatos(){
        InformacionMenu.setText("Men� para agregar Mascota");
        Field_Nombre.setText("");
        Combo_Sexo.setSelectedItem(null);
        Check_Estado.setSelected(false);
        ComboDue�os.setSelectedItem(null);
        Fecha_Nacimiento.setDateToToday();
        Lista_Tipos.setSelectedItem(null);
        TxtDue�o.setText("Seleccione rut cliente a enlazar:");
        
    }
    
    public void establecerDatos(Mascota mascota){
        Lista_Tipos.setSelectedItem(mascota.getTipo().getDescripcion());
        InformacionMenu.setText("Informaci�n de: "+mascota.getNombre());
        Field_Nombre.setText(mascota.getNombre());
        Combo_Sexo.setSelectedItem(mascota.getSexo()=='M'?"Masculino":"Femenino");
        Check_Estado.setSelected(mascota.isVigente());
        ComboDue�os.setSelectedItem(mascota.getCliente().getRut()+"-"+mascota.getCliente().getDv());
        Fecha_Nacimiento.setDate(mascota.getFec_nac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        TxtDue�o.setText("Rut Cliente Asociado:");
        
    }
    
     public void obtener_tipos() throws IOException{
        
        api=new MiPetAPI("http://127.0.0.1","/API/Tipo_Mascota");
        Lista_Tipos.removeAllItems();
        for (Tipo_Mascota tipo:api.ObtenerTipos()){
            Lista_Tipos.addItem(tipo.getDescripcion());
        }

        
    }
     
     public void obtener_due�os() throws IOException{
        
        api=new MiPetAPI("http://127.0.0.1","/API/Cliente");
        ComboDue�os.removeAllItems();
        for (Cliente cliente:api.ObtenerClientes()){
            ComboDue�os.addItem(cliente.getRut()+"-"+cliente.getDv());
        }
        ComboDue�os.addItem("Agregar cliente");

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        InformacionMenu = new javax.swing.JLabel();
        Label_Sexo = new javax.swing.JLabel();
        Label_FecNac = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        Label_Vigente1 = new javax.swing.JLabel();
        Label_Tipo = new javax.swing.JLabel();
        Field_Nombre = new javax.swing.JTextField();
        Check_Estado = new javax.swing.JCheckBox();
        Combo_Sexo = new javax.swing.JComboBox<>();
        Lista_Tipos = new javax.swing.JComboBox<>();
        Actualizar = new javax.swing.JButton();
        Resetear = new javax.swing.JButton();
        Fecha_Nacimiento = new com.github.lgooddatepicker.components.DatePicker();
        ComboDue�os = new javax.swing.JComboBox<>();
        TxtDue�o = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InformacionMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InformacionMenu.setText("Informaci�n de: ");
        InformacionMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Label_Sexo.setText("Sexo:");

        Label_FecNac.setText("Fecha de nacimiento:");

        LabelNombre.setText("Nombre:");

        Label_Vigente1.setText("Estado:");

        Label_Tipo.setText("Tipo:");

        Check_Estado.setText("No vigente");
        Check_Estado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Check_EstadoItemStateChanged(evt);
            }
        });

        Combo_Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        Combo_Sexo.setSelectedIndex(-1);

        Actualizar.setText("Actualizar Datos");
        Actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActualizarMouseClicked(evt);
            }
        });
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Resetear.setText("Resetear");
        Resetear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetearMouseClicked(evt);
            }
        });

        ComboDue�os.setEnabled(false);

        TxtDue�o.setText("Rut cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InformacionMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Label_FecNac, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(LabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_Sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_Vigente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_Tipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Actualizar)
                    .addComponent(TxtDue�o, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboDue�os, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Combo_Sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lista_Tipos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Check_Estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Resetear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Field_Nombre)
                    .addComponent(Fecha_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InformacionMenu)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(LabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Field_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_FecNac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fecha_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Combo_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Check_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Vigente1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lista_Tipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDue�o)
                    .addComponent(ComboDue�os, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Actualizar)
                    .addComponent(Resetear))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Check_EstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Check_EstadoItemStateChanged
        // TODO add your handling code here:
        Check_Estado.setText((evt.getStateChange()==1?"Vigente":"No vigente"));
    }//GEN-LAST:event_Check_EstadoItemStateChanged

    private void ActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ActualizarMouseClicked

    private void ResetearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetearMouseClicked
        // TODO add your handling code here:
        if (this.mascota!=null){
            establecerDatos(this.mascota);
        }else{
            establecerDatos();
        }
        
    }//GEN-LAST:event_ResetearMouseClicked

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        if (Field_Nombre.getText().isEmpty() || Fecha_Nacimiento.getText().isEmpty() || Combo_Sexo.getSelectedItem() == "" || Lista_Tipos.getSelectedItem() == "" || ComboDue�os.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(null, "           [Ingreso inv�lido]\nNing�n puede estar en blanco", "Error al ingresar", JOptionPane.ERROR_MESSAGE);
        } else {
            // Subir/actualizar datos
            System.out.println(Field_Nombre.getText());
            System.out.println(Fecha_Nacimiento.getText());
            System.out.println(Check_Estado.isSelected());
            System.out.println(Lista_Tipos.getSelectedItem());
            System.out.println(ComboDue�os.getSelectedItem());
        }
    }//GEN-LAST:event_ActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(MascotaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MascotaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MascotaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MascotaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MascotaDatos().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MascotaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JCheckBox Check_Estado;
    private javax.swing.JComboBox<String> ComboDue�os;
    private javax.swing.JComboBox<String> Combo_Sexo;
    private com.github.lgooddatepicker.components.DatePicker Fecha_Nacimiento;
    private javax.swing.JTextField Field_Nombre;
    private javax.swing.JLabel InformacionMenu;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel Label_FecNac;
    private javax.swing.JLabel Label_Sexo;
    private javax.swing.JLabel Label_Tipo;
    private javax.swing.JLabel Label_Vigente1;
    private javax.swing.JComboBox<String> Lista_Tipos;
    private javax.swing.JButton Resetear;
    private javax.swing.JLabel TxtDue�o;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
