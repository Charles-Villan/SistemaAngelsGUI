package Vista;

import Controlador.reg_marca_tip;
import Controlador.reg_permisos;
import Controlador.reg_personal;
import Controlador.reg_productos;
import Modelo.Marca;
import Modelo.Permisos;
import Modelo.Producto;
import Modelo.tipo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brayan Torres
 */
public class vntana_inventario extends javax.swing.JDialog {

    /**
     * Creates new form vntana_inventario
     */
    ArrayList<Marca> listMarc;
    reg_marca_tip rmt = new reg_marca_tip();
    DefaultTableModel datos;
    ArrayList<Producto> listprod;
    reg_productos rp = new reg_productos();
    ArrayList<tipo> listTipPrend;
    reg_permisos rperm = new reg_permisos();
    reg_personal rpersonal = new reg_personal();
    ArrayList<Permisos> listPerm;
    String ced;

    public vntana_inventario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         setIconImage(new ImageIcon(getClass().getResource("/iconos/tools.png")).getImage());      
        this.setLocationRelativeTo(null);
        ced = menu_principal.ced_usu;
        loadPermisos(ced);
        tabla_load(rp.busc_cod(""));
        cargarCombMarca();
        cargarCombPrendas();
        lbl_count.setText(rp.countProd() + "");


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void loadPermisos(String ced) {//Busca por cedula
        listPerm = rperm.cargar_permisos(ced);
        for (Permisos per : listPerm) {

        }
    }

    public void tabla_load(String sql) {
        load_table(sql);
        modelo_tabla();
    }

    public void modelo_tabla() {
        try {
            tbl_inventario.getColumnModel().getColumn(0).setPreferredWidth(15);
            tbl_inventario.getColumnModel().getColumn(1).setPreferredWidth(35);
            tbl_inventario.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbl_inventario.getColumnModel().getColumn(3).setPreferredWidth(35);
            tbl_inventario.getColumnModel().getColumn(4).setPreferredWidth(20);
            tbl_inventario.getColumnModel().getColumn(5).setPreferredWidth(20);
            tbl_inventario.getColumnModel().getColumn(6).setPreferredWidth(25);
            tbl_inventario.getColumnModel().getColumn(7).setPreferredWidth(25);
            tbl_inventario.getColumnModel().getColumn(8).setPreferredWidth(100);
            tbl_inventario.getColumnModel().getColumn(9).setPreferredWidth(40);
           // tbl_inventario.getColumnModel().getColumn(10).setPreferredWidth(40);
            tbl_inventario.getTableHeader().setBackground(Color.decode("#666666"));
            tbl_inventario.getTableHeader().setForeground(Color.WHITE);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            tbl_inventario.getColumnModel().getColumn(0).setCellRenderer(tcr);
            // tbl_inventario.getTableHeader().setBackground(Color.decode(colorHeadTable));
            DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
            tcr1.setHorizontalAlignment(SwingConstants.RIGHT);
            tbl_inventario.getColumnModel().getColumn(3).setCellRenderer(tcr1);
            tbl_inventario.getColumnModel().getColumn(4).setCellRenderer(tcr1);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public void cargarCombMarca() {
        combo_marca.removeAllItems();
        combo_marca.addItem("");
        listMarc = rmt.CargarListMarca("");
        for (Marca m : listMarc) {
            combo_marca.addItem(m.getNom_marca());
        }
    }

    public void cargarCombPrendas() {
        combo_tip.removeAllItems();
        combo_tip.addItem("");
        listTipPrend = rmt.LoadListTip("");
        for (tipo tp : listTipPrend) {
            combo_tip.addItem(tp.getDescrip());
        }
    }

    //debe ser el sql
    public void load_table(String sql) {
        datos = rp.label_table();
        Object[] data = new Object[10];
        listprod = rp.llenar_prod_vnta(sql);
        for (Producto pr : listprod) {
            try {
                data[0] = pr.getNum_prod();
                data[1] = pr.getCod_prod();
                data[2] = rmt.ObtNomMarca(pr.getCod_marca() + "");
                data[3] = rmt.ObtNomTip(pr.getCod_tip_prend() + "");
                data[4] = pr.getPrec_cmpra();
                data[5] = pr.getPrec_vnta();
                data[6] = pr.getStok();
                data[7] = pr.isIva();
                data[8] = pr.getDescripcion();
                data[9] = pr.getObserv();
                datos.addRow(data);
                tbl_inventario.setModel(datos);
                // }
            } catch (Exception ex) {
                System.out.println("aqui:" + ex);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_cab = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_imprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_busc = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbl_count = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        combo_marca = new javax.swing.JComboBox();
        combo_tip = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de Productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_cab.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inventario de ropa");

        javax.swing.GroupLayout pnl_cabLayout = new javax.swing.GroupLayout(pnl_cab);
        pnl_cab.setLayout(pnl_cabLayout);
        pnl_cabLayout.setHorizontalGroup(
            pnl_cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(933, Short.MAX_VALUE))
        );
        pnl_cabLayout.setVerticalGroup(
            pnl_cabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(pnl_cab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, -1));

        btn_imprimir.setBackground(new java.awt.Color(0, 153, 102));
        btn_imprimir.setForeground(new java.awt.Color(255, 255, 255));
        btn_imprimir.setText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 90, 30));

        tbl_inventario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbl_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_inventario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1050, 313));

        jPanel1.setBackground(new java.awt.Color(244, 236, 225));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Buscar por Código:");

        txt_busc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscKeyReleased(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/todo.png"))); // NOI18N
        jButton4.setText("Ver Todo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad de Productos:");

        lbl_count.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_busc, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_count, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2))
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_count, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txt_busc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1050, 50));

        combo_marca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(combo_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 13, -1));

        combo_tip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(combo_tip, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 11, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        tabla_load(rp.busc_cod(""));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_buscKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscKeyPressed

    }//GEN-LAST:event_txt_buscKeyPressed

    private void txt_buscKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscKeyReleased
        // TODO add your handling code here:
        tabla_load(rp.busc_cod(txt_busc.getText()));
    }//GEN-LAST:event_txt_buscKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int dato = rmt.ObtCodMarca(combo_marca.getSelectedItem().toString());
        int dato1 = rmt.ObtCodTip(combo_tip.getSelectedItem().toString());
        tabla_load(rp.busc_marca_tipo(dato + "", dato1 + ""));

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        // TODO add your handling code here:
        //  btn_imprimir
        if (!lbl_count.getText().equals("0")) {
            String mrca = combo_marca.getSelectedItem().toString();
            String tip = combo_tip.getSelectedItem().toString();
            JOptionPane.showMessageDialog(this, "Realizando operación.......Espere un momento");
            try {

                Map<String, Object> params = new HashMap<String, Object>();

                params.put("nom_marca", mrca);
                params.put("tip", tip);
                System.out.println(mrca);
                //  params.put("tipo", tip);
                Reportes_g.generarReporte("rep_inventario", params);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No existen datos");
        }


    }//GEN-LAST:event_btn_imprimirActionPerformed

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
            java.util.logging.Logger.getLogger(vntana_inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vntana_inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vntana_inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vntana_inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vntana_inventario dialog = new vntana_inventario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JComboBox combo_marca;
    private javax.swing.JComboBox combo_tip;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JLabel lbl_count;
    private javax.swing.JPanel pnl_cab;
    private javax.swing.JTable tbl_inventario;
    private javax.swing.JTextField txt_busc;
    // End of variables declaration//GEN-END:variables
}