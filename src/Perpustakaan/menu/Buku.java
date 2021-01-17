package Perpustakaan.menu;

import Perpustakaan.Input;
import Perpustakaan.database.Data;
import Perpustakaan.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Buku implements Menu{
    private Data data;
    private final String tableName = "buku";

    public Buku() throws SQLException {
        data = new Data(tableName);
    }

    public void show() throws SQLException {
        tableHeader();
        loadData();
        lanjutkan();
    }

    private void tableHeader(){
        System.out.println("DATA BUKU");
        System.out.println("ID \t| JUDUL BUKU \t| PENGARANG \t\t\t\t| STOK \t| DIPINJAM \t| STOK AKHIR |");
        System.out.println("**********************************************************************************");
    }

    public void loadData() throws SQLException {
        ResultSet res = data.getRes();

        int id, stok,dipinjam, stokAkhir;
        String judul, pengarang;

        while(res.next()){
            id = res.getInt("id");
            judul = res.getString("judul_buku");
            pengarang = res.getString("pengarang");
            stok = res.getInt("stok");
            dipinjam = res.getInt("dipinjam");
            stokAkhir = res.getInt("stok_akhir");

            System.out.printf("%d \t| %s \t| %s \t| %d \t| %d \t\t| %d \t\t |\n", id, judul, pengarang, stok, dipinjam, stokAkhir);
        }

        System.out.println("**********************************************************************************");
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
