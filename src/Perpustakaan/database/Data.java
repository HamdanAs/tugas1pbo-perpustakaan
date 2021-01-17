package Perpustakaan.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data{

    private Statement stat;
    private ResultSet res;
    private Database data;

    public Data(String tableName) throws SQLException {
        data = new Database();
        stat = data.getConn().createStatement();
        res = stat.executeQuery(getTable(tableName));
    }

    public ResultSet getRes(){
        return res;
    }

    private String getTable(String tableName){
        return "select * from " + tableName;
    }

}
