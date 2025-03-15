class Hewan { // untuk class hewan
    String nama;
    String jenis;
    String suara;


    void tampilkaninfo() { // untuk menampilkan kepada user
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);

    }
}

public class Main{ // untuk class main
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan();  // membuat objek baru pada kelas hewan
        Hewan hewan2 = new Hewan();

        hewan1.nama = "Kucing"; // untuk menentukan nama hewan
        hewan2.nama = "Anjing";

        hewan1.jenis = "Mamalia"; // untuk menentukan jenis hewan
        hewan2.jenis = "Mamalia";

        hewan1.suara = "Nyann~~"; // untuk menentukan suara hewan
        hewan2.suara = "Woof-Woof!!";

        System.out.println(); // untuk memanggil objek hewan1
        hewan1.tampilkaninfo();

        System.out.println(); // untuk memanggil objek hewan2
        hewan2.tampilkaninfo();
    }
}

