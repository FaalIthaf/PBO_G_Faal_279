import java.util.Scanner;
class RekeningBank { // untuk class rekeningbank
    String nomorRekening; // attribute
    String namaPemilik;
    double saldo;
    double jumlah;

    void tampilkaninfo(){ // untuk  output kepada user tentang informasi rekening
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo);
    }

    void setorUang(){ // untuk meminta dan mencetak jumlah uang yang ingin di setor
        Scanner scanner = new Scanner (System.in);
        System.out.print("Masukkan jumlah uang yang ingin anda setor: Rp."); // untuk memasukkan jumlah uang yang ingin di setor
        jumlah = scanner.nextDouble();
        saldo += jumlah;//rumus
        System.out.printf("%s menyetor Rp%.1f. Saldo Sekarang: Rp%.1f", namaPemilik, jumlah, saldo);
    }

    void tarikUang(){ // untuk meminta dan mencetak jumlah uang yang ingin di tarik
        Scanner scanner = new Scanner (System.in);
        System.out.print("Masukkan jumlah uang yang ingin anda tarik: "); // meminta jumlah uang yang ingin di tarik
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

        RekeningBank rekening1 = new RekeningBank(); // membuat objek baru yakni rekening1 dan rekening2
        RekeningBank rekening2 = new RekeningBank();

        rekening1.nomorRekening = "202410370110279"; // nomor, nama, saldo diinisialisasi
        rekening1.namaPemilik = "FaalIthaf";
        rekening1.saldo = 1000000.0;

        rekening2.nomorRekening = "202310370311129";
        rekening2.namaPemilik = "Maharani";
        rekening2.saldo = 1200000.0;

        rekening1.tampilkaninfo(); // memanggil tampilkaninfo untuk menampilkan informasi rekening
        System.out.println();

        rekening2.tampilkaninfo();
        System.out.println();

        rekening1.setorUang(); // memanggil setorUang untuk meminta pengguna memasukkan jumlah uang yang ingin disetor.
        System.out.println("\n");

        rekening2.setorUang();
        System.out.println("\n");

        rekening1.tarikUang(); // memanggil tarikuang untuk meminta pengguna memasukkan jumlah uang yang ingin ditarik
        System.out.println("\n");

        rekening2.tarikUang();
        System.out.println("\n");

        rekening1.tampilkaninfo(); // menampilkan informasi rekening terakhir setelah terjadi proses setor dan tarik
        System.out.println();

        rekening2.tampilkaninfo();
    }
}