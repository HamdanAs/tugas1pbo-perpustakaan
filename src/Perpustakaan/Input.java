package Perpustakaan;

import Perpustakaan.menu.Buku;
import Perpustakaan.menu.Menu;
import Perpustakaan.menu.Peminjam;
import Perpustakaan.menu.Peminjaman;

import java.sql.SQLException;
import java.util.Scanner;

public class Input {

    private int pilihan;

    private Scanner input;
    private Menu buku, peminjaman, peminjam;

    public Input() throws SQLException {
        pilihan = 0;
        input = new Scanner(System.in);
        buku = new Buku();
        peminjaman = new Peminjaman();
        peminjam = new Peminjam();
    }

    public void init() throws SQLException {
        menuHeader();
        System.out.println("Pilihan : ");
        pilihan = input.nextInt();
        switch(pilihan){
            case 1 :
                buku.show();
                break;
            case 2:
                peminjaman.show();
                break;
            case 3:
                peminjam.show();
                break;
            case 4 :
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan anda salah! Silahkan masukan pilihan yang benar! [1 - 4]");
                init();
                break;
        }
    }

    private void menuHeader(){
        System.out.println("APLIKASI PERPUSTAKAAN");
        System.out.println("**************************");
        System.out.println("1. Melihat Data Buku");
        System.out.println("2. Meminjam Buku");
        System.out.println("3. Melihat Data Peminjaman");
        System.out.println("4. Keluar");
        System.out.println("**************************");
    }
}
