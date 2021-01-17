package Perpustakaan.database;

import javax.xml.crypto.Data;
import java.sql.*;

public class Database {
    private static final String DATABASE = "jdbc:mysql://localhost/perpustakaan";
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection conn;
    private Statement stat;

    public Database(){
        try {
            conn = DriverManager.getConnection(DATABASE, USER, PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public Statement getStat() throws SQLException {
        return conn.createStatement();
    }
}
