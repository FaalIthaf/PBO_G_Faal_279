public class Main { // untuk kelas main
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank(); // membuat objek baru dengan nama rekening1 dan rekening2
        RekeningBank rekening2 = new RekeningBank();

        rekening1.nomorRekening = "202410370110279"; // menetapkan nomor, nama, saldo untuk objek rekening1 dan rekening2
        rekening1.namaPemilik = "FaalIthaf";
        rekening1.saldo = 1000000.0;

        rekening2.nomorRekening = "202310370311129";
        rekening2.namaPemilik = "Maharani";
        rekening2.saldo = 500000.0;

        rekening1.tampilkaninfo(); // untuk menampilkan rekening1 dan rekening2 dengan nilai yang sudh ditetapkan
        System.out.println();

        rekening2.tampilkaninfo();
        System.out.println();

        rekening1.setorUang(1000000); // menambah saldo pada rekening1 dan rekening2
        System.out.println();
        rekening2.setorUang(500000);
        System.out.println("\n");

        rekening1.tarikUang(21000000); // menarik uang pada rekening1 dan rekening2
        System.out.println();
        rekening2.tarikUang(300000);
        System.out.println("\n");

        rekening1.tampilkaninfo(); // untuk menampilkan informasi rekening kembali dengan saldo terbaru
        System.out.println();

        rekening2.tampilkaninfo();
    }
}