import java.util.Scanner;
class RekeningBank { // untuk class rekeningbank
    String nomorRekening; // attribute
    String namaPemilik;
    double saldo;
    double jumlah;

    void tampilkaninfo(){ // untuk menampilkan output kepada user
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo);
    }

    void setorUang(){ // untuk menampilkan output setor uang
        Scanner scanner = new Scanner (System.in);
        System.out.print("Masukkan jumlah uang yang ingin anda setor: Rp.");
        jumlah = scanner.nextDouble();
        saldo += jumlah;//rumus
        System.out.printf("%s menyetor Rp%.1f. Saldo Sekarang: Rp%.1f", namaPemilik, jumlah, saldo);
    }

    void tarikUang(){ // menampilkan output tarik uang
        Scanner scanner = new Scanner (System.in);
        System.out.print("Masukkan jumlah uang yang ingin anda tarik: ");
        jumlah = scanner.nextDouble();

        if(saldo >= jumlah){ // jika saldo lebih besar dari pada sama dengan jumlah yang akan ditarik maka tarik uang akan berhasil
            saldo -= jumlah; // rumus
            System.out.printf("%s menarik Rp%.1f. (Berhasil) Saldo sekarang: Rp%.1f", namaPemilik, jumlah, saldo);
        } else{ // jika saldo kurang dari pada jumlah yang akan ditarik maka tarik uang akan gagal
            System.out.printf("%s menarik Rp%.1f. (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp%.1f", namaPemilik, jumlah, saldo);
        }
    }

}

public class Main { // untuk kelas main
    public static void main(String[] args) {

        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        rekening1.nomorRekening = "202410370110279";
        rekening1.namaPemilik = "FaalIthaf";
        rekening1.saldo = 1000000.0;

        rekening2.nomorRekening = "202310370311129";
        rekening2.namaPemilik = "Maharani";
        rekening2.saldo = 1200000.0;

        rekening1.tampilkaninfo();
        System.out.println();

        rekening2.tampilkaninfo();
        System.out.println();

        rekening1.setorUang();
        System.out.println("\n");

        rekening2.setorUang();
        System.out.println("\n");

        rekening1.tarikUang();
        System.out.println("\n");

        rekening2.tarikUang();
        System.out.println("\n");

        rekening1.tampilkaninfo();
        System.out.println();

        rekening2.tampilkaninfo();


    }
}