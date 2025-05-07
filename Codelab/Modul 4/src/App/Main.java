package App;
import Perpustakaan.*;
public class Main {
    public static void main(String[] args){
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi ("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        buku1.displayInfo();
        buku2.displayInfo();

        Anggota anggota1 = new Anggota ("Fa'al", "G279");
        Anggota anggota2 = new Anggota ("Dikha", "G312");

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa ", 7);

        anggota1.mengembalikanBuku("Madilog");
        anggota2.mengembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}
