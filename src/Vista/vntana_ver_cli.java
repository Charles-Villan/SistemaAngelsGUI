/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.reg_clientes;
import Controlador.reg_marca_tip;
import Controlador.reg_pais;
import Controlador.reg_permisos;
import Controlador.reg_personal;
import Modelo.Cliente;
import Modelo.Permisos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonel
 */
public class vntana_ver_cli extends javax.swing.JDialog {

    /**
     * Creates new form vntana_ver_cli
     */
    reg_marca_tip rmt = new reg_marca_tip();
    reg_clientes rc = new reg_clientes();
    reg_pais rp = new reg_pais();
    DefaultTableModel datos;
    public static String codigoCli;
    ArrayList<Cliente> listClie;
    reg_permisos rperm = new reg_permisos();
    reg_personal rpersonal = new reg_personal();
    ArrayList<Permisos> listPerm;
    String ced;

    public vntana_ver_cli(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/iconos/tools.png")).getImage());      
        try {
            ced = menu_principal.ced_usu;
            loadPermisos(ced);
            bloquearColumTable("");
            lbl_cant_cli.setText(rc.count() + "");
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public void loadPermisos(String ced) {//Busca por cedula
        listPerm = rperm.cargar_permisos(ced);
        for (Permisos per : listPerm) {

            if (per.isPer_regist()) {
                // btn_nuevo.setEnabled(true);
            }
            if (per.isPer_udate()) {
                // btn_actualizar.setEnabled(true);
                //update = true;
            }
            if (per.isPer_delete()) {
                System.out.println("Ingresa al eliminar");
                //  btn_delete.setEnabled(true);
                // delet = true;
            }
        }
    }

  

    public void bloquearColumTable(String dato) {//edicion de la tabla
        load_table(dato);
        modelo_tabla();
    }

    public void modelo_tabla() {
        try {
            table_clientes.getColumnModel().getColumn(0).setPreferredWidth(3);
            table_clientes.getColumnModel().getColumn(1).setPreferredWidth(10);
            table_clientes.getColumnModel().getColumn(2).setPreferredWidth(30);
            table_clientes.getColumnModel().getColumn(3).setPreferredWidth(30);
            table_clientes.getColumnModel().getColumn(4).setPreferredWidth(40);
            table_clientes.getColumnModel().getColumn(5).setPreferredWidth(60);
            table_clientes.getColumnModel().getColumn(6).setPreferredWidth(15);
            table_clientes.getColumnModel().getColumn(7).setPreferredWidth(30);
            table_clientes.getTableHeader().setBackground(Color.decode("#666666"));
            table_clientes.getTableHeader().setForeground(Color.WHITE);
        } catch (Exception err) {
            System.out.println(err);
        }

    }

    public void load_table(String dato) {
        datos = rc.load_clientes();
        String[] data = new String[8];
        listClie = rc.llenar_Clientes(rc.load_cliente(dato));
        for (Cliente cl : listClie) {
            data[0] = cl.getCod_clien() + "";
            data[1] = cl.getCed();
            data[2] = cl.getNombre();
            data[3] = cl.getApellido();
            data[4] = rp.ObtNomCiu(cl.getCod_ciu() + "");
            data[5] = cl.getDireccion();
            data[6] = cl.getTelefono();
            data[7] = cl.getCorreo_elect();
            datos.addRow(data);
            table_clientes.setModel(datos);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_clientes = new javax.swing.JTable();
        pnl_cab = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tbar = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        text_busca_prove = new javax.swing.JTextField();
        btn_all = new javax.swing.JButton();
        btn_cli = new javax.swing.JButton();
        btn_rfres = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        lbl_cant_cli = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Doble clic para seleccionar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(736, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 900, 40));

        table_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 78, 880, 390));

        pnl_cab.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Listado de Clientes");

        javax.swing.GroupLayout pnl_cabLayout = new javax.swing.GroupLayout(pnl_cab);
        pnl_cab.setLayout(pnl_cabLayout);
        pnl_cabLayout.setHorizontalGroup(
            pnl_cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(774, Short.MAX_VALUE))
        );
        pnl_cabLayout.setVerticalGroup(
            pnl_cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(pnl_cab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 30));

        tbar.setBackground(new java.awt.Color(204, 204, 204));
        tbar.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Cedula/Nombres:");
        tbar.add(jLabel1);
        tbar.add(jSeparator1);

        text_busca_prove.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_busca_proveKeyReleased(evt);
            }
        });
        tbar.add(text_busca_prove);

        btn_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar.png"))); // NOI18N
        btn_all.setText("Ver Todo");
        btn_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allActionPerformed(evt);
            }
        });
        tbar.add(btn_all);

        btn_cli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clientes.png"))); // NOI18N
        btn_cli.setText("Registrar Cliente");
        btn_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliActionPerformed(evt);
            }
        });
        tbar.add(btn_cli);

        btn_rfres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/refresh.png"))); // NOI18N
        btn_rfres.setText("Recargar");
        btn_rfres.setFocusable(false);
        btn_rfres.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_rfres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rfresActionPerformed(evt);
            }
        });
        tbar.add(btn_rfres);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad de Clientes:");
        tbar.add(jLabel5);
        tbar.add(jSeparator2);

        lbl_cant_cli.setText("0");
        tbar.add(lbl_cant_cli);
        tbar.add(jSeparator3);

        getContentPane().add(tbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 900, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clientesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            codigoCli = (table_clientes.getValueAt(table_clientes.getSelectedRow(), 1).toString());
            System.out.println(codigoCli + "esto sale");
            dispose(); //cerrar el diálogo
        }
    }//GEN-LAST:event_table_clientesMouseClicked

    private void text_busca_proveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_busca_proveKeyReleased
        // TODO add your handling code here:
        bloquearColumTable(text_busca_prove.getText());//buscar cliente


    }//GEN-LAST:event_text_busca_proveKeyReleased

    private void btn_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliActionPerformed
        vntana_clientes dlg = new vntana_clientes(null, false);
        dlg.setModal(true); //no permite acceder a otros formularios hasta que se cierre
        dlg.setVisible(true);
    }//GEN-LAST:event_btn_cliActionPerformed

    private void btn_rfresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rfresActionPerformed

        bloquearColumTable("");//buscar cliente


    }//GEN-LAST:event_btn_rfresActionPerformed

    private void btn_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allActionPerformed
        bloquearColumTable("");
    }//GEN-LAST:event_btn_allActionPerformed

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
            java.util.logging.Logger.getLogger(vntana_ver_cli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vntana_ver_cli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vntana_ver_cli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vntana_ver_cli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vntana_ver_cli dialog = new vntana_ver_cli(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_all;
    private javax.swing.JButton btn_cli;
    private javax.swing.JButton btn_rfres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JLabel lbl_cant_cli;
    private javax.swing.JPanel pnl_cab;
    private javax.swing.JTable table_clientes;
    private javax.swing.JToolBar tbar;
    private javax.swing.JTextField text_busca_prove;
    // End of variables declaration//GEN-END:variables
}
