package Perpustakaan;

public class NonFiksi extends Buku{
    public NonFiksi(String Judul, String Penulis, String Kategori){
        super (Judul, Penulis,Kategori);
    }
    @Override
    public void displayInfo(){
        System.out.println("Buku Non-Fiksi: " + Judul + " oleh " + Penulis + " (Bidang: " + Kategori +")");
    }
}
