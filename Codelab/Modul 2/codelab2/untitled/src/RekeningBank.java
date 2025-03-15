public class RekeningBank { // untuk class rekeningbank
    String nomorRekening; // attribute
    String namaPemilik;
    double saldo;

    void tampilkaninfo(){ // untuk menampilkan output kepada user
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo);
    }

    void setorUang(double jumlah){ // untuk menampilkan output setor uang
        saldo += jumlah; // rumus
        System.out.printf("%s menyetor Rp%.1f. Saldo Sekarang: Rp%.1f",namaPemilik, jumlah, saldo);
    }

    void tarikUang(double jumlah){ // menampilkan output tarik uang
        if(saldo >= jumlah){ // jika saldo lebih besar dari pada sama dengan jumlah yang akan ditarik maka tarik uang akan berhasil
            saldo -= jumlah; // rumus
            System.out.printf("%s menarik Rp%.1f. (Berhasil) Saldo sekarang: Rp%.1f", namaPemilik, jumlah, saldo);
        } else{ // jika saldo kurang dari pada jumlah yang akan ditarik maka tarik uang akan gagal
            System.out.printf("%s menarik Rp%.1f. (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp%.1f", namaPemilik, jumlah, saldo);
        }
    }

}
