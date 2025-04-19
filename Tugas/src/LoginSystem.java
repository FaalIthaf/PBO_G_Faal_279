import java.util.Scanner;
public class LoginSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Harap pilih jenis login: ");
        System.out.println("1. Admin\n2. Mahasiswa");
        System.out.print("Silahkan pilih: ");
        int pilihan = scan.nextInt();
        scan.nextLine();

        if(pilihan == 1){

            System.out.print("Masukkan username: ");
            String username = scan.nextLine();
            System.out.print("Masukkan password: ");
            String password = scan.nextLine();
            Admin admin = new Admin ("Admin279", "password279", username, password);
            admin.login(username, password);
        } else if(pilihan == 2){
            System.out.print("Masukkan Nama: ");
            String nama = scan.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scan.nextLine();
            Mahasiswa mahasiswa = new Mahasiswa(nama, nim);
            mahasiswa.login(nama, nim);
        }
    }
}
