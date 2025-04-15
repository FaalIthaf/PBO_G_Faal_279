import java.util.Scanner;
class admin{
    String usernameterdaftar = "Admin279";
    String passwordterdaftar = "Password279";
    void login(String username, String password){
        if(username.equals(usernameterdaftar) && password.equals(passwordterdaftar)){
            System.out.print("Login Admin Berhasil!");
        } else {
            System.out.print("Login gagal! Username atau Password salah!");
        }
    }
}
class mahasiswa{
    String namaterdaftar = "Fa'al Ithaf Nida Nibras";
    String nimterdaftar = "202410370110279";
    String jurusan = "Informatika";

    void login(String nama, String NIM){
        if(nama.equals(namaterdaftar) && NIM.equals(nimterdaftar)){
            System.out.println("Login Mahasiswa berhasil!");
        } else {
            System.out.println("Login gagal! Nama atau NIM salah!");
        }
    }

    void displayinfo(){
        System.out.println("Informasi Mahasiswa:");
        System.out.println("Nama: " + namaterdaftar);
        System.out.println("NIM: " + nimterdaftar);
        System.out.println("Jurusan: " + jurusan);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        admin Admin = new admin();
        mahasiswa Mahasiswa = new mahasiswa();

        System.out.println("Harap Pilih Jenis Login: ");
        System.out.println("1. Admin \n2. Mahasiswa");
        System.out.print("Pilihan: ");
        int pilihan = scan.nextInt();
        scan.nextLine();

        if(pilihan == 1){
            System.out.print("Masukkan username: ");
            String username = scan.nextLine();
            System.out.print("Masukkan password: ");
            String password = scan.nextLine();
            Admin.login(username, password);
        } else if(pilihan == 2){
            System.out.print("Masukkan Nama: ");
            String nama = scan.nextLine();
            System.out.print("Masukkan NIM: ");
            String NIM = scan.nextLine();
            Mahasiswa.login(nama, NIM);
            Mahasiswa.displayinfo();
        }

    }
}
