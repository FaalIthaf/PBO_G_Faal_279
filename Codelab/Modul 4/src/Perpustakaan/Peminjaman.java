package Perpustakaan;

public interface Peminjaman {
    void pinjamBuku(String Judul);
    void pinjamBuku(String Judul,int durasi);
    void mengembalikanBuku(String Judul);
}
