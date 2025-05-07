package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions{
    Scanner scan = new Scanner(System.in);
    public Mahasiswa(String nama, String nim){
        super(nama, nim);
    }
    @Override
    public boolean login(String nama, String nim){
        if(nama.equals(getNama()) && nim.equals(getNim())){
            displayInfo();
            return true;
        } else {
            System.out.println("Login gagal! Nama atau NIM salah!");
            System.out.println();
            return false;
        }
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Informasi Pengguna: ");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim() + "\n");
    }

    @Override
    public void displayAppMenu(){
        while (true) {
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");
            int pilihan = scan.nextInt();
            if (pilihan == 1) {
                reportItem();
            }else if (pilihan == 2) {
                viewReportedItems();
            }else if(pilihan == 0) {
                System.out.println("Logout Berhasil!");
                return;
            } else{
                return;
            }
        }
    }

    @Override
    public void reportItem(){
        System.out.print("Nama Barang: ");
        String barang = scan.next();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scan.next();
        System.out.print("Lokasi Terakhir/Ditemukan:");
        String lokasi = scan.next();
        System.out.println();

        System.out.println("Nama Barang: " + barang);
        System.out.println("Deskripsi Barang: " + deskripsi);
        System.out.println("Lokasi Terakhir: " + lokasi);
        System.out.println();
    }

    @Override
    public void viewReportedItems(){
        System.out.println(">>Fitur Lihat Laporan Belum Tersedia<<");
    }
}
