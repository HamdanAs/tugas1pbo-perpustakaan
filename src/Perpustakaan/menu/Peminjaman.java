package Perpustakaan.menu;

import Perpustakaan.Input;
import Perpustakaan.database.Data;
import Perpustakaan.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Peminjaman implements Menu{
    private final Data data;
    private final String tableName = "buku";

    public Peminjaman() throws SQLException {
        data = new Data(tableName);
    }

    public void show() throws SQLException {
        tableHeader();
        loadData();
        pinjamBuku();
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

    private void pinjamBuku() throws SQLException {
        Scanner input = new Scanner(System.in);
        Statement stat = data.getRes().getStatement();
        ResultSet res;

        int pilihan;
        String nama;

        System.out.print("Silahkan masukan ID buku yang ingin anda pinjam : ");
        pilihan = input.nextInt();
        System.out.print("Silahkan masukan nama anda : ");
        nama = input.next();

        res = stat.executeQuery("select * from buku where id = " + pilihan);
        if (res.next()){
            String judul = res.getString("judul_buku");
            String pengarang = res.getString("pengarang");

            boolean isLanjutkan = Util.getYesOrNo("Anda akan meminjam buku "
                    + judul +
                    " karya dari " + pengarang +
                    "\nLanjutkan ? [Y/N]");
            if(isLanjutkan){
                String insertQuery = String.format("insert into peminjam values ('%d', '%d', '%s', '%d')", Util.getRandomInt(), pilihan, nama, 1);
                stat.executeUpdate("update buku set dipinjam = dipinjam + 1, stok_akhir = stok - dipinjam where id = " + pilihan);
                stat.executeUpdate(insertQuery);
                System.out.println("DATA PEMINJAM ");
                System.out.println("Nama : " + nama);
                System.out.println("Buku : " + judul);
                System.out.println("Data berhasil disimpan!");
            }
        }

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
