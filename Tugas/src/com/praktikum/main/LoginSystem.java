package com.praktikum.main;
import java.util.Scanner;
import com.praktikum.users.*;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        User user;

        System.out.println("Harap pilih jenis login: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Silahkan pilih: ");

        int pilihan = scan.nextInt();
        scan.nextLine();
        
        if(pilihan == 1){
            System.out.print("Masukkan username: ");
            String username = scan.nextLine();
            System.out.print("Masukkan password: ");
            String password = scan.nextLine();

            user = new Admin("Fa'al", "279", "Admin279", "password279");

            if (user.login(username, password)){
                user.displayAppMenu();
            }

        } else if(pilihan == 2){
            System.out.print("Masukkan Nama: ");
            String nama = scan.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scan.nextLine();

            user = new Mahasiswa("Fa'al", "279");

            if (user.login(nama, nim)){
                user.displayAppMenu();
            }
        }


    }
}
