/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mipet.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;
import net.coderazzi.filters.gui.TableFilterHeader.Position;
import java.lang.Object;
import javax.swing.JTable;
import mipet.Controlador.ButtonColumn;
import mipet.Modelo.Cliente;
import mipet.Modelo.Mascota;
import mipet.Controlador.MiPetAPI;
import mipet.Modelo.Tipo_Mascota;



/**
 *
 * @author Ethan Leiva 004D 07/09/2023
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    private MiPetAPI api;
    private TableFilterHeader filterHeader;
    private DefaultTableModel DT;
    
    public Inicio() throws IOException {
        initComponents();
        try {
            actualizar_datos();
            filterHeader = new TableFilterHeader(jTable1,AutoChoices.ENABLED);
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    class NoEditableTableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        return column==4 || column==5;
    }
}
    
    public void actualizar_datos() throws IOException{
        
        JTable jTabletmp=new JTable();
        
        
        if (DatosCombo.getSelectedItem()=="Mascotas"){
            api=new MiPetAPI("http://127.0.0.1","/API/Mascota");
            DT=new NoEditableTableModel();
            DT.addColumn("Nombre Mascota");
            DT.addColumn("Tipo Mascota");
            DT.addColumn("Rut Cliente");
            DT.addColumn("Estado");
            DT.addColumn("Editar");
            DT.addColumn("Eliminar");

            Object[] fila=new Object[6];
            for (Mascota mascota:api.ObtenerMascotas()) { 
                fila[0]=mascota.getNombre();
                fila[1]=mascota.getTipo().getDescripcion();
                fila[2]=mascota.getCliente().getRut()+"-"+mascota.getCliente().getDv();
                fila[3]=((mascota.isVigente())? "Vigente":"No vigente");
                fila[4]=("Editar");
                fila[5]=("Eliminar");

                DT.addRow(fila);
            }
        }else if (DatosCombo.getSelectedItem()=="Clientes"){
            api=new MiPetAPI("http://127.0.0.1","/API/Cliente");
            DT=new NoEditableTableModel();
            DT.addColumn("Nombre");
            DT.addColumn("Apellidos");
            DT.addColumn("Rut");
            DT.addColumn("Cantidad Mascotas Asociadas");
            DT.addColumn("Eliminar");

            Object[] fila=new Object[5];
            for (Cliente cliente:api.ObtenerClientes()) { 
                fila[0]=cliente.getNombre();
                fila[1]=cliente.getApe1()!=null?cliente.getApe1():""+" "+cliente.getApe2()!=null?cliente.getApe2():"";
                fila[2]=cliente.getRut()+"-"+cliente.getDv();
                fila[3]=api.CantidadMascotas(cliente);
                fila[4]=("Eliminar");

                DT.addRow(fila);
            }
        }else{
            api=new MiPetAPI("http://127.0.0.1","/API/Tipo_Mascota");
            DT=new NoEditableTableModel();
            DT.addColumn("Descripción");
            DT.addColumn("Editar");
            DT.addColumn("Eliminar");

            Object[] fila=new Object[3];
            for (Tipo_Mascota mascotatipo:api.ObtenerTipos()) { 
                fila[0]=mascotatipo.getDescripcion();
                fila[1]=("Editar");
                fila[2]=("Eliminar");
                DT.addRow(fila);
            }
        }
        
        
        jTable1.setModel(DT);
        jTable1.setAutoCreateRowSorter(true);
        if (DatosCombo.getSelectedItem()=="Mascotas"){
            ButtonColumn buttonColumn = new ButtonColumn(jTable1, Editar, 4);
            ButtonColumn buttonColumn2 = new ButtonColumn(jTable1, Eliminar, 5);
        }else if (DatosCombo.getSelectedItem()=="Clientes"){
            ButtonColumn buttonColumn2 = new ButtonColumn(jTable1, Eliminar, 4);
        }


    }
    
    Action Editar = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        JTable table = (JTable)e.getSource();
        int modelRow = Integer.valueOf( e.getActionCommand() );
        
        try {
            Mascota mascota=new MiPetAPI("http://127.0.0.1","/API/Mascota").ObtenerMascotas().get(modelRow);
            
            MascotaDatos formulario2 = new MascotaDatos(mascota);
            formulario2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    cerrarsubFormulario();
                }
            });
            
            formulario2.setVisible(true);
            blockthis();
            
        } catch (IOException ex) {
            try {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al obtener la información de la Base de Datos");
                actualizar_datos();
            } catch (IOException ex1) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        
    }
};
    
    Action Eliminar = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        JTable table = (JTable)e.getSource();
        int modelRow = Integer.valueOf( e.getActionCommand() );
        
        try {
            if (DatosCombo.getSelectedItem()=="Mascotas"){
                Mascota mascota=new MiPetAPI("http://127.0.0.1","/API/Mascota").ObtenerMascotas().get(modelRow);
                int result = JOptionPane.showConfirmDialog(null,"Deseas Eliminar toda información de: "+mascota.getNombre(), "Eliminación Mascota",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                   JOptionPane.showMessageDialog(null, "Eliminado información");
                }else if (result == JOptionPane.NO_OPTION){
                   JOptionPane.showMessageDialog(null, "Entendido no se eliminara información");
                }
            }else{
                Cliente cliente=new MiPetAPI("http://127.0.0.1","/API/Cliente").ObtenerClientes().get(modelRow);
                int result = JOptionPane.showConfirmDialog(null,"Deseas Eliminar toda información de: "+cliente.getNombre()+"\nAdemás se eliminaran todas las mascotas asociadas", "Eliminación Mascota",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                   JOptionPane.showMessageDialog(null, "Eliminado información");
                }else if (result == JOptionPane.NO_OPTION){
                   JOptionPane.showMessageDialog(null, "Entendido no se eliminara información");
                }
            }
            
        } catch (IOException ex) {
            try {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al obtener la información de la Base de Datos");
                actualizar_datos();
            } catch (IOException ex1) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        
    }
};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        AddBoton = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        DatosCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido a MiPet");
        jLabel1.setToolTipText("");

        AddBoton.setText("Agregar Mascota");
        AddBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBotonMouseClicked(evt);
            }
        });

        Actualizar.setText("Actualizar Lista");
        Actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActualizarMouseClicked(evt);
            }
        });

        DatosCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mascotas", "Clientes", "Tipos Mascota" }));
        DatosCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DatosComboItemStateChanged(evt);
            }
        });

        jLabel2.setText("Datos a revisar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AddBoton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Actualizar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DatosCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DatosCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBoton)
                    .addComponent(Actualizar))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarMouseClicked
        try {
            actualizar_datos();
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualizarMouseClicked

    private void DatosComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DatosComboItemStateChanged
        try {
            // TODO add your handling code here:
            actualizar_datos();
            
            if (DatosCombo.getSelectedItem()=="Mascotas"){
                AddBoton.setText("Agregar Mascota");
            }else if (DatosCombo.getSelectedItem()=="Clientes"){
                AddBoton.setText("Agregar Cliente");
            }else{
                AddBoton.setText("Agregar tipo de mascota");
            }
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DatosComboItemStateChanged

   
    private void cerrarsubFormulario(){
        this.setEnabled(true);
        this.toFront();
    }
    
    private void blockthis(){
        this.setEnabled(false);
        this.toBack();
    }
   
    private void AddBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBotonMouseClicked
        // TODO add your handling code here:
        try {
        if (DatosCombo.getSelectedItem()=="Mascotas"){
            MascotaDatos formulario2 = new MascotaDatos();
            formulario2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    cerrarsubFormulario();
                }
            });
            formulario2.setVisible(true);
            blockthis();
            
        }else if (DatosCombo.getSelectedItem()=="Clientes"){
            FormCliente formulario2 = new FormCliente();
            formulario2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    cerrarsubFormulario();
                }
            });
            
            formulario2.setVisible(true);
            blockthis();
        }else{
            
        }
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddBotonMouseClicked

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inicio().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton AddBoton;
    private javax.swing.JComboBox<String> DatosCombo;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
