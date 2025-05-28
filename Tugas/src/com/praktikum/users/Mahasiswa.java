package com.praktikum.users;

import java.util.Scanner;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String namaInput, String nimInput) {
        if (namaInput.equals(getNama()) && nimInput.equals(getNim())) {
            displayInfo();
            return true;
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
            return false;
        }
    }
    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa Berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
    @Override
    public void reportItem(Scanner input){
        System.out.print("Nama Barang: ");
        String barang = input.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = input.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = input.nextLine();
        System.out.println();

        Item newItem = new Item(barang, deskripsi, lokasi);
        LoginSystem.reportedItems.add(newItem);

        System.out.println("Laporan Barang Dikirim");
        System.out.println("Barang: " +barang);
        System.out.println("Deskripsi: " +deskripsi);
        System.out.println("Lokasi: " +lokasi);
    }
    @Override
    public void viewReportedItems(){
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("=== Daftar Barang Dilaporkan ===");
        for (Item item : LoginSystem.reportedItems) {
            if (item.getStatus().equalsIgnoreCase("Reported")) {
                System.out.println("Nama: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("-----------------------------");
            }
        }
    }
    @Override
    public void displayAppMenu(Scanner input){
        int memilih;
        do {
            System.out.println();
            System.out.println("=== Menu Mahasiswa ===");
            System.out.println("1. Laporan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            memilih = input.nextInt();
            input.nextLine();
            System.out.println();

            switch (memilih){
                case 1:
                    reportItem(input);
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout Berhasil.");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid.");
                    break;
            }
        } while (memilih != 0);

    }
}
