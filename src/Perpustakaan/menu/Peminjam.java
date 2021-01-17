package Perpustakaan.menu;

import Perpustakaan.Input;
import Perpustakaan.database.Data;
import Perpustakaan.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Peminjam implements Menu{
    private Data data;
    private final String tableName = "peminjam";

    public Peminjam() throws SQLException {
        data = new Data(tableName);
    }

    public void show() throws SQLException {
        tableHeader();
        loadData();
        lanjutkan();
    }

    private void tableHeader(){
        System.out.println("DATA PEMINJAM");
        System.out.println("ID \t\t| ID BUKU \t| NAMA \t\t\t\t| JML DIPINJAM |");
        System.out.println("********************************************************");
    }

    public void loadData() throws SQLException {
        ResultSet res = data.getRes();

        int id, idBuku,dipinjam;
        String nama;

        while(res.next()){
            id = res.getInt("id_peminjam");
            idBuku = res.getInt("id_buku");
            dipinjam = res.getInt("jml_dipinjam");
            nama = res.getString("nama_peminjam");

            System.out.printf("%d \t\t| %d \t| %s \t\t\t\t| %d \t\t|\n", id, idBuku, nama, dipinjam);
        }

        System.out.println("********************************************************");
    }

    private void lanjutkan() throws SQLException {
        boolean isLanjutkan = Util.getYesOrNo("Apakah anda ingin melanjutkan? [Y/N] : ");
        Input in = new Input();

        if(isLanjutkan){
            in.init();
        } else {
            System.exit(0);
        }
    }
}
