package Controlador;

import Modelo.Validaciones;
import Modelo.Ventas;
import Modelo.cn_BaseDeDatos;
import Modelo.det_vntas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class reg_vntas {

    static DefaultTableModel datos;
    private PreparedStatement ps = null;
    cn_BaseDeDatos bd = new cn_BaseDeDatos();
    Validaciones val = new Validaciones();
    DefaultTableModel datosVenta;

    public int codigoVentas() {//codigo de los clientes
        return val.cod_tablas("select max(cod_vntas) from ventas");
    }

    public String codFact() {

        return val.codFacturas("select max(cod_vntas) from ventas");

    }
 
    public boolean insert(Ventas vn) {
       Connection cn = bd.Conectar();
        String inser = "Insert Into ventas(cod_vntas,cod_cli,cod_usu,date,sub_total,iva_vntas,descuento,total_vntas)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            ps = cn.prepareStatement(inser); 
            
            ps.setString(1, vn.getCod_vnta());
            ps.setInt(2, vn.getCod_cli());
            ps.setInt(3, vn.getCod_usu());
            ps.setDate(4, vn.getFecha());
            ps.setDouble(5, vn.getSubtotal());
            ps.setDouble(6, vn.getIva_vntas());
            ps.setDouble(7, vn.getDesc());
            ps.setDouble(8, vn.getTotal());
            ps.executeUpdate();
            bd.desconectar();
            
        } catch (SQLException ex) {
            System.out.println("Esto se muestra:" + ex);
        } catch (Throwable ex) {
            Logger.getLogger(reg_vntas.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  bd.desconectar();//Desconectar la base de datos
        return true;
    }

    public DefaultTableModel cargarCamposTable() {
        String[] data = {"Cod", "Descripcion", "Marca", "Precio", "Cantidad", "Iva", "Total"};
        //String[] data = {"Cod", "Descripcion", "Marca", "Precio", "Iva", "Cantidad", "Total"};
        datosVenta = new DefaultTableModel(null, data) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return datosVenta;
    }
    //GUARDA DETALLE

    public boolean insert_detalle(det_vntas dvn) {
        String insertar = "INSERT INTO det_ventas(cod_vntas,cod_prod,cant,prec,iva_vntas,importe)"
                + "VALUES (?, ?, ?,?, ?, ?)";
        try {
            Connection cn = bd.Conectar();
            ps = cn.prepareStatement(insertar);
            ps.setString(1, dvn.getCod_vnta());
            ps.setString(2, dvn.getCod_prod());
            ps.setInt(3, dvn.getCant());
            ps.setDouble(4, dvn.getPrecio());
            ps.setDouble(5, dvn.getIva());
            ps.setDouble(6, dvn.getImporte());
            ps.executeUpdate();
            bd.desconectar();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Throwable ex) {
            Logger.getLogger(reg_vntas.class.getName()).log(Level.SEVERE, null, ex);
        }
        //   bd.desconectar();//Desconectar la base de datos
        return true;
    }

    //Cargar datos de ventas por fecha
    public DefaultTableModel load_label_caja() {
        String[] data = {"Cod", "Cliente", "Vendedor", "Fecha", "Subtotal", "Iva", "Desc", "Total"};
        //String[] data = {"Cod", "Descripcion", "Marca", "Precio", "Iva", "Cantidad", "Total"};
        datosVenta = new DefaultTableModel(null, data) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return datosVenta;
    }

    ArrayList<Ventas> listVnta;

    public String show_all_vntas() {//para ver todas las ventas
        return "SELECT * FROM ventas ";
    }

    
    
    
    public String show_vnta_date(String fec1, String fec2) {
        return "SELECT * FROM ventas where date between '" + fec1 + "' and '" + fec2 + "'";
    }
    
    

    public ArrayList load_vntas_caja(String sql) {
        try {
            Connection cn = bd.Conectar();
            listVnta = new ArrayList<Ventas>();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listVnta.add(new Ventas(
                        rs.getString("cod_vntas"),
                        rs.getInt("cod_cli"),
                        rs.getInt("cod_usu"),
                        rs.getDate("date"),
                        rs.getDouble("sub_total"),
                        rs.getDouble("iva_vntas"),
                        rs.getDouble("descuento"),
                        rs.getDouble("total_vntas")));
            }
            bd.desconectar();

        } catch (Exception ex) {
            System.out.println(ex);
        } catch (Throwable ex) {
            Logger.getLogger(reg_vntas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return listVnta;
    }

}
