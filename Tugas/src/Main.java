import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Pilih login: ");
        System.out.println("1. Admin\n2. Mahasiswa");

        System.out.print("Masukkan Pilihan: ");
        int pilihan = scan.nextInt();

        scan.nextLine();

        if(pilihan == 1) {
            String usernameterdaftar = "Admin279";
            String passwordterdaftar = "Password279";

            System.out.print("Masukkan Username: ");
            String username = scan.nextLine();
            System.out.print("Masukkan Password: ");
            String password = scan.nextLine();

            if(username.equals(usernameterdaftar) && password.equals(passwordterdaftar)){
                System.out.println("Login Admin Berhasil!");
            }else {
                System.out.println("Login gagal! Username atau password salah!");
            }
        } else if (pilihan == 2){
            String namaterdaftar = "Fa'al Ithaf Nida Nibras";
            String nimterdaftar = "202410370110279";

            System.out.print("Masukkan Nama: ");
            String nama = scan.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scan.nextLine();

            if(nama.equals(namaterdaftar) && nim.equals(nimterdaftar)){
                System.out.println("Login Mahasiswa Berhasil!");
            } else{
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } scan.close();
    }
}
