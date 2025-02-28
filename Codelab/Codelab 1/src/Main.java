// mengambil input
import java.util.Scanner;
// mengambil waktu sekarang
import java.time.LocalDateTime;

public class Main{
    public static void main(String[] args){
        // objek scanner untuk membaca input
        Scanner scan = new Scanner (System.in);

        // meminta pengguna untuk memasukkan input yang diminta
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();

        System.out.print("Masukkan Jenis Kelamin (L/P): ");
        char jeniskelamin = scan.next().charAt(0);

        System.out.print("Masukkan Tahun Lahir: ");
        int tahunlahir = scan.nextInt();

        // menutup scanner untuk menghindari kebocoran
        scan.close();

        // rumus untuk menghitung umur
        int tahunsekarang = LocalDateTime.now().getYear();
        int umur = tahunsekarang - tahunlahir;

        // output dari system setelah pengguna mengisi input
        System.out.println("\nData Diri: ");
        System.out.println("Nama         : " + nama);

        // percabangan untuk mengetahui jenis kelamin
        if(jeniskelamin == 'L' || jeniskelamin == 'l'){
            System.out.println("Jenis Kelamin: Laki-laki");
        } else if(jeniskelamin == 'P' || jeniskelamin == 'p'){
            System.out.println("Jenis Kelamin: Permpuan");
        } else{
            System.out.println("Pilihan tidak valid!");
        }
        
        System.out.println("Umur         : " + umur);
    }
}