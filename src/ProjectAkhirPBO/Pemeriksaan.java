/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectAkhirPBO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;

/**
 * Kelas Pemeriksaan merepresentasikan entitas pemeriksaan dalam sistem.
 * Kelas ini menyediakan metode untuk menyimpan, menghapus, dan mengambil data pemeriksaan.
 * 
 * @author Aryanto Pratama
 */
public class Pemeriksaan {
    private String idPemeriksaan;
    private String nopasien;
    private String tanggal;
    private String diagnosa;

    /**
     * Konstruktor untuk membuat objek Pemeriksaan dengan semua atribut.
     * 
     * @param idPemeriksaan ID pemeriksaan.
     * @param noPasien Nomor pasien.
     * @param tanggal Tanggal pemeriksaan.
     * @param diagnosa Diagnosa pemeriksaan.
     */
    public Pemeriksaan(String idPemeriksaan, String noPasien, String tanggal, String diagnosa) {
        this.idPemeriksaan = idPemeriksaan;
        this.nopasien = noPasien;
        this.tanggal = tanggal;
        this.diagnosa = diagnosa;
    }

    /**
     * Konstruktor untuk membuat objek Pemeriksaan dengan hanya ID pemeriksaan.
     * 
     * @param idPemeriksaan ID pemeriksaan.
     */
    
    // Overloading
    public Pemeriksaan(String idPemeriksaan) {
        this.idPemeriksaan = idPemeriksaan;
    }

    /**
     * Mengambil ID pemeriksaan.
     * 
     * @return ID pemeriksaan.
     */
    public String getIdPemeriksaan() {
        return idPemeriksaan;
    }

    /**
     * Mengambil diagnosa pemeriksaan.
     * 
     * @return Diagnosa pemeriksaan.
     */
    public String getDiagnosa() {
        return diagnosa;
    }

    /**
     * Mengambil nomor pasien.
     * 
     * @return Nomor pasien.
     */
    public String getNopasien() {
        return nopasien;
    }

    /**
     * Mengambil tanggal pemeriksaan.
     * 
     * @return Tanggal pemeriksaan.
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * Mengatur diagnosa pemeriksaan.
     * 
     * @param diagnosa Diagnosa pemeriksaan.
     */
    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    /**
     * Mengatur ID pemeriksaan.
     * 
     * @param idPemeriksaan ID pemeriksaan.
     */
    public void setIdPemeriksaan(String idPemeriksaan) {
        this.idPemeriksaan = idPemeriksaan;
    }

    /**
     * Mengatur nomor pasien.
     * 
     * @param nopasien Nomor pasien.
     */
    public void setNopasien(String nopasien) {
        this.nopasien = nopasien;
    }

    /**
     * Mengatur tanggal pemeriksaan.
     * 
     * @param tanggal Tanggal pemeriksaan.
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    /**
     * Menyimpan data pemeriksaan ke database.
     */
    public void simpanPemeriksaan() {
        try {
            // Query SQL dengan PreparedStatement
            String sql = "INSERT INTO dataperiksa (idperiksa, nopasien, tgl, diagnosa) VALUES (?, ?, ?, ?)";
            Connection conn = ProjectAkhirPBO.Koneksi.koneksiDB();
            PreparedStatement pst = conn.prepareStatement(sql);

            // Set nilai parameter
            pst.setString(1, idPemeriksaan);
            pst.setString(2, nopasien);
            pst.setString(3, tanggal);
            pst.setString(4, diagnosa);

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
     * Menghapus data pemeriksaan dari database berdasarkan ID pemeriksaan.
     */
    public void deletePemeriksaan() {
        try {
            // Query SQL dengan PreparedStatement untuk delete
            String sql = "DELETE FROM dataperiksa WHERE idperiksa = ?";
            Connection conn = ProjectAkhirPBO.Koneksi.koneksiDB();
            PreparedStatement pst = conn.prepareStatement(sql);

            // Set nilai parameter idperiksa
            pst.setString(1, idPemeriksaan);

            // Jalankan pernyataan SQL delete
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                // Jika berhasil dihapus
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } else {
                // Jika tidak ada data yang terhapus (mungkin karena id tidak ditemukan)
                JOptionPane.showMessageDialog(null, "Data dengan ID Pemeriksaan " + idPemeriksaan + " tidak ditemukan",
                        "Data Tidak Ditemukan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            // Tangkap dan tampilkan pesan kesalahan
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Menampilkan nomor pasien terakhir di dalam JTextField.
     * 
     * @param textField JTextField tempat nomor pasien akan ditampilkan.
     */
    public void tampilkanNomorPasien(JTextField textField) {
        try {
            // Query SQL untuk mendapatkan nomor pasien terakhir dari datapasien
            String sql = "SELECT nopasien FROM datapasien ORDER BY nopasien DESC LIMIT 1";
            Connection conn = ProjectAkhirPBO.Koneksi.koneksiDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String nomorPasien = rs.getString("nopasien");
                textField.setText(nomorPasien); // Set textfield nopasien dengan nomor pasien dari database
            } else {
                textField.setText("PAS-001"); // Jika tabel kosong, set default PAS-001
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil nomor pasien: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
