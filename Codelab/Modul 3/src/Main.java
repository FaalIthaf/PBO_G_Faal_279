import java.util.Scanner;
class KarakterGame{ // kelas (Superclass) untuk mempresentasikan karakterGame
    private String nama; //atribute untuk menyimpan nama karakter
    private int kesehatan; // menyimpan jumlah kesehatan karakter

    public void tampilkaninfo(){ // menampilkan informasi karakter berupa nama dan kesehatan
        System.out.println(getNama() + " memiliki kesehatan: " + getKesehatan());
    }

    public KarakterGame(String nama, int kesehatan){ // Constructor untuk menginisialisasi nama dan kesehatan.
        this.nama = nama;
        this.kesehatan = kesehatan;
    }
    public String getNama() { // mengambil nama
        return nama;
    }

    public void setNama(String nama) { // menetapkan nama
        this.nama = nama;
        System.out.println("Nama Pahlawan : " + this.nama);
    }

    public int getKesehatan() { // mengambil kesehatan
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) { // menetapkan kesehatan
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target, String serangan){ // method yang akan di Override pada subclass
    }
}

class Pahlawan extends KarakterGame{ // subclass dari Superclass Karaktergame
    public Pahlawan(String nama, int kesehatan){ // memanggil constructor dari Karaktergame dengan keyword super
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target, String serangan){ // Menampilkan pesan bahwa pahlawan menyerang
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan " + serangan + "!");
        target.setKesehatan(target.getKesehatan() - 50);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

class Musuh extends KarakterGame{ // subclass dari Superclass Karaktergame
    public Musuh(String nama, int kesehatan){ // memanggil constructor dari Karaktergame dengan keyword super
        super(nama, kesehatan);
    }
    @Override
    public void serang(KarakterGame target, String serangan){ // menampilkan pesan bahwa musuh menyerang
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan " + serangan + "!");
        target.setKesehatan(target.getKesehatan() - 15);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

public class Main { // kelas utama untuk menjalankan program
    public static void main(String[] args) { // titik awal eksekusi program
        Scanner scanner = new Scanner(System.in);
        KarakterGame KarakterUmum = new KarakterGame("karakter Umum", 100); // membuat objek karakter umum, pahlawan, dan musuh
        Pahlawan pahlawan = new Pahlawan("Karakter", 150);
        Musuh musuh = new Musuh("Viper", 200);

        System.out.print("Masukkan nama Pahlawan Anda: "); // meminta pengguna memasukkan nama pahlawan
        String namapahlawan = scanner.nextLine();
        pahlawan.setNama(namapahlawan);// mengatur nama pahlawan dengan metode setNama

        System.out.println("Status awal:" ); // menampilkan status awal pahlawan dan juga musuh
        pahlawan.tampilkaninfo();
        musuh.tampilkaninfo();

        pahlawan.serang(musuh, "Orbital Strike"); // menampilkan bahwa pahlawan menyerang musuh
        musuh.serang(pahlawan, "Snake Bite"); // menampilkan bahwa musuh menyerang pahlawan

        scanner.close();

    }
}