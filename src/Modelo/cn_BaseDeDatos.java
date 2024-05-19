package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Leonel
 */


public class cn_BaseDeDatos {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    public String db = "asmintegra";
    public String url = "jdbc:mysql://localhost:3306/" + db;
    public String user = "root";
    public String pass = "";

    public Connection Conectar() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            if (conn != null) {
                System.out.println("Conexion establecida.....");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return conn;
    }

    public void desconectar() {
        conn = null;
        if (conn == null) {
            System.out.println("Conexion terminada");
        }
    }
}
