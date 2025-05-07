 package Perpustakaan;

public abstract class Buku {
    String Judul;
    String Penulis;
    String Kategori;


    public Buku(String Judul, String Penulis, String Kategori){
        this. Judul = Judul;
        this. Penulis = Penulis;
        this. Kategori = Kategori;
    }

    public abstract void displayInfo();

}
