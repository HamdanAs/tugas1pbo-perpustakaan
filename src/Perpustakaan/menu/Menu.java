package Perpustakaan.menu;

import java.sql.SQLException;

public interface Menu {
    void loadData() throws SQLException;
    void show() throws SQLException;
}
