package com.praktikum.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

import com.praktikum.data.Item;
import com.praktikum.users.*;


public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        reportedItems.add(new Item("Laptop", "Elektronik", "Toko A"));
        reportedItems.add(new Item("Handphone", "Elektronik", "Toko B"));
        userList.add(new Admin( "Fa'al", "279", "Admin279", "password279"));
        userList.add(new Mahasiswa("Fa'al", "279"));
        User user = null;

        System.out.println("Harap pilih jenis login: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Silahkan pilih: ");

        int pilihan = -1;
        try{
            pilihan = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException e){
            System.out.println("Input Harus Berupa Angka!");
            scan.nextLine();
        }
        System.out.println();
        boolean Berhasil = false;
        switch (pilihan) {
            case 1:
                System.out.print("Masukkan username: ");
                String userAdmin = scan.nextLine();
                System.out.print("Masukkan password: ");
                String passAdmin = scan.nextLine();
                for (User u : userList) {
                    if (u instanceof Admin && u.login(userAdmin, passAdmin)) {
                        user = u;
                        Berhasil = true;
                        break;
                    }
                }
                break;

            case 2:
                System.out.print("Masukkan Nama: ");
                String namaMaha = scan.nextLine();
                System.out.print("Masukkan NIM: ");
                String nimMaha = scan.nextLine();
                for (User u : userList) {
                    if (u instanceof Mahasiswa && u.login(namaMaha, nimMaha)) {
                        user = u;
                        Berhasil = true;
                        break;
                    }
                }

                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        if (Berhasil && user != null){
            user.displayAppMenu(scan);
        }

    }
}
