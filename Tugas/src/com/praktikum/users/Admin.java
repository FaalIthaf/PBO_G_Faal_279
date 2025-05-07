package com.praktikum.users;
import com.praktikum.actions.AdminACtions;
import java.util.Scanner;

public class Admin extends User implements AdminACtions {
    Scanner scan = new Scanner(System.in);
    String username, password;

    public Admin(String nama, String nim, String username, String password){
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean login(String username, String password){
        if(username.equals(getUsername()) && password.equals(getPassword())){
            displayInfo();
            return true;
        } else {
            System.out.println("Login gagal! Username atau Password salah!\n");
            return false;
        }
    }
    @Override
    public void displayInfo(){
        System.out.println("Login Berhasil!\n");
    }

    @Override
    public void displayAppMenu(){
        while (true) {
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.print("Pilihan: ");
            int pilihan = scan.nextInt();
            if(pilihan == 1){
                manageItems();
                return;
            } else if (pilihan == 2){
                manageUsers();
                return;
            }
        }
    }

    @Override
    public void manageItems(){
        System.out.println(">>Fitur Kelola Barang Belum Tersedia<<");
    }

    @Override
    public void manageUsers(){
        System.out.println(">>Fitur Kelola Mahasiswa Belum Tersedia<<");
    }
}
