package Perpustakaan;

public class Anggota implements Peminjaman {
    String nama;
    String idAnggota;

    public Anggota(String nama, String idAnggota){
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    @Override
    public void pinjamBuku(String Judul){
        System.out.println(nama + " Meminjam buku berjudul: " + Judul);
    }
    @Override
    public void pinjamBuku(String Judul, int durasi){
        System.out.println(nama + " meminjam buku " + Judul + " selama " + durasi + " hari\n");
    }
    @Override
    public void mengembalikanBuku(String Judul){
        System.out.println(nama + " mengemalikan buku berjudul: " + Judul);

    }
}
