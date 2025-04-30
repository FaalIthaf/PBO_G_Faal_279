package Perpustakaan;

public class Fiksi extends Buku {
    public Fiksi(String Judul, String Penulis, String Kategori){
        super(Judul, Penulis, Kategori);
    }

    @Override
    public void displayInfo(){
        System.out.println("Buku Fiksi: " + Judul +" oleh " + Penulis + " (Genre: " + Kategori + ")\n");
    }
}
