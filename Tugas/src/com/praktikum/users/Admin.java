package com.praktikum.users;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import com.praktikum.actions.AdminACtions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

public class Admin extends User implements AdminACtions {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String userInput, String passInput) {
        if (userInput.equals(getUsername()) && passInput.equals(getPassword())) {
            displayInfo();
            return true;
        } else {
            System.out.println("Login gagal! Username atau password salah.");
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin Berhasil!");
    }

    @Override
    public void manageItems(Scanner input) {
        int pilih = -1;

        do {
            System.out.println("=== Kelola Barang ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilih = input.nextInt();
                input.nextLine();

                switch (pilih) {
                    case 1:
                        int i = 1;
                        for (Item item : LoginSystem.reportedItems) {
                            System.out.println(i++ + ". " + item.getItemName() + " | " + item.getStatus());
                            System.out.println("Deskripsi: " + item.getDescription());
                            System.out.println("Lokasi: " + item.getLocation());
                        }
                        break;

                    case 2:
                        ArrayList<Integer> reportedIndexes = new ArrayList<>();
                        System.out.println("Pilih Barang yang ingin ditandai:");

                        for (int j = 0; j < LoginSystem.reportedItems.size(); j++) {
                            Item item = LoginSystem.reportedItems.get(j);
                            if (item.getStatus().equals("Reported")) {
                                reportedIndexes.add(j);
                                System.out.println(reportedIndexes.size() + ". " + item.getItemName());
                            }
                        }

                        if (reportedIndexes.isEmpty()) {
                            System.out.println("Tidak ada barang yang dilaporkan.");
                            break;
                        }

                        System.out.print("Masukkan nomor indeks: ");
                        try {
                            int pilihanIndex = input.nextInt() - 1;
                            input.nextLine();

                            if (pilihanIndex < 0 || pilihanIndex >= reportedIndexes.size()) {
                                System.out.println("Indeks tidak valid.");
                            } else {
                                int realIndex = reportedIndexes.get(pilihanIndex);
                                Item selected = LoginSystem.reportedItems.get(realIndex);

                                if (selected.getStatus().equals("Reported")) {
                                    selected.setStatus("Claimed");
                                    System.out.println("Barang berhasil ditandai sebagai diambil.");
                                } else {
                                    System.out.println("Barang sudah pernah ditandai sebelumnya.");
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka!");
                            input.nextLine();
                        }
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
            }
        } while (pilih != 0);
    }

    @Override
    public void manageUsers(Scanner input) {
        int pilih = -1;

        do {
            System.out.println("=== Kelola Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilih = input.nextInt();
                input.nextLine();

                switch (pilih) {
                    case 1:
                        System.out.print("Nama Mahasiswa: ");
                        String nama = input.nextLine();
                        System.out.print("NIM Mahasiswa: ");
                        String nim = input.nextLine();
                        LoginSystem.userList.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa berhasil ditambahkan.");
                        break;

                    case 2:
                        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                        String nimHapus = input.nextLine();

                        boolean ditemukan = false;
                        for (int i = 0; i < LoginSystem.userList.size(); i++) {
                            User u = LoginSystem.userList.get(i);
                            if (u instanceof Mahasiswa && u.getNim().equals(nimHapus)) {
                                LoginSystem.userList.remove(i);
                                System.out.println("Mahasiswa berhasil dihapus.");
                                ditemukan = true;
                                break;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                        }
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
            }
        } while (pilih != 0);
    }

    @Override
    public void displayAppMenu(Scanner input) {
        int pilih = -1;

        do {
            System.out.println();
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            try {
                pilih = input.nextInt();
                input.nextLine();

                switch (pilih) {
                    case 1:
                        manageItems(input);
                        break;
                    case 2:
                        manageUsers(input);
                        break;
                    case 0:
                        System.out.println("Logout Berhasil.");
                        break;
                    default:
                        System.out.println("Pilihan Tidak Valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
            }
        } while (pilih != 0);
    }
}