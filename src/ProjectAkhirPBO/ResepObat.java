/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ProjectAkhirPBO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Kelas ResepObat mewakili resep obat yang terkait dengan pemeriksaan.
 * Kelas ini menyediakan metode untuk menyimpan resep obat ke dalam database.
 * ResepObat adalah subclass dari Pemeriksaan.
 * 
 * @see Pemeriksaan
 * @see ProjectAkhirPBO.Koneksi
 * @see javax.swing.JOptionPane
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.SQLException
 * 
 * @author Aryanto Pratama
 */
public class ResepObat extends Pemeriksaan {

    private String kodeObat;
    private String namaObat;
    private int jumlahObat;
    private int hargaObat;

    /**
     * Konstruktor untuk membuat objek ResepObat dengan semua atribut.
     * 
     * @param idPemeriksaan ID pemeriksaan yang terkait.
     * @param kodeObat Kode obat.
     * @param namaObat Nama obat.
     * @param jumlahObat Jumlah obat.
     * @param hargaObat Harga obat.
     */
    
    public ResepObat(String idPemeriksaan, String kodeObat, String namaObat, int jumlahObat, int hargaObat) {
        super(idPemeriksaan);
        this.kodeObat = kodeObat;
        this.namaObat = namaObat;
        this.jumlahObat = jumlahObat;
        this.hargaObat = hargaObat;
    }

    /**
     * Mengambil nama obat.
     * 
     * @return Nama obat.
     */
    public String getNamaObat() {
        return namaObat;
    }

    /**
     * Mengambil kode obat.
     * 
     * @return Kode obat.
     */
    public String getKodeObat() {
        return kodeObat;
    }

    /**
     * Mengambil harga obat.
     * 
     * @return Harga obat.
     */
    public int getHargaObat() {
        return hargaObat;
    }

    /**
     * Mengambil jumlah obat.
     * 
     * @return Jumlah obat.
     */
    public int getJumlahObat() {
        return jumlahObat;
    }

    /**
     * Mengatur harga obat.
     * 
     * @param hargaObat Harga obat.
     */
    public void setHargaObat(int hargaObat) {
        this.hargaObat = hargaObat;
    }

    /**
     * Mengatur jumlah obat.
     * 
     * @param jumlahObat Jumlah obat.
     */
    public void setJumlahObat(int jumlahObat) {
        this.jumlahObat = jumlahObat;
    }

    /**
     * Mengatur kode obat.
     * 
     * @param kodeObat Kode obat.
     */
    public void setKodeObat(String kodeObat) {
        this.kodeObat = kodeObat;
    }

    /**
     * Mengatur nama obat.
     * 
     * @param namaObat Nama obat.
     */
    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    /**
     * Menyimpan data resep obat ke database.
     */
    @Override
    public void simpanPemeriksaan() {
        try {
            // Query SQL dengan PreparedStatement
            String sql = "INSERT INTO resep_obat (idperiksa, kodeobat, namaobat, jumlahobat, hargaobat) VALUES (?, ?, ?, ?, ?)";
            Connection conn = ProjectAkhirPBO.Koneksi.koneksiDB();
            PreparedStatement pst = conn.prepareStatement(sql);

            // Set nilai parameter
            pst.setString(1, getIdPemeriksaan());
            pst.setString(2, kodeObat);
            pst.setString(3, namaObat);
            pst.setInt(4, jumlahObat);
            pst.setInt(5, hargaObat);

            // Jalankan pernyataan SQL
            pst.executeUpdate();

            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(null, "Data Berhasil di Input");
        } catch (SQLException e) {
            // Tangkap dan tampilkan pesan kesalahan
            JOptionPane.showMessageDialog(null, "Gagal di Simpan: " + e.getMessage());
        }
    }

    /**
     * Metode main untuk menjalankan logika aplikasi (jika diperlukan).
     * 
     * @param args Argumen baris perintah.
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
