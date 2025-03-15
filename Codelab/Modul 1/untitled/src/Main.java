import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        String nama;
        char jenisKelamin;
        int tahunLahir;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama: ");
        nama = scanner.nextLine();
        System.out.print("Masukkan Jenis Kelamin (P/L): ");
        jenisKelamin = scanner.next().charAt(0);
        System.out.print("Masukkan Tahun Lahir: ");
        tahunLahir = scanner.nextInt();

        scanner.close();

        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        String jenisKelaminString;
        if (jenisKelamin == 'L' || jenisKelamin == 'l') {
            jenisKelaminString = "Laki-laki";
        } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
            jenisKelaminString = "Perempuan";
        } else {
            jenisKelaminString = "Tidak Diketahui";
        }

        System.out.println("\nData Diri:");
        System.out.println("Nama         : " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminString);
        System.out.println("Umur         : " + umur);
    }
}
