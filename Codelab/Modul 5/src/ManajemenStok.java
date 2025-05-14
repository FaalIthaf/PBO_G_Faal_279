import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        daftarBarang.add(new Barang("Pensil", 50));
        while (true) {
            System.out.println("\n===== Menu Manajemen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("4. Total Seluruh Stok");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int opsi = -1;
            try {
                opsi = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (opsi) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan stok awal: ");
                    try {
                        int stok = scanner.nextInt();
                        scanner.nextLine();
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\n--- Daftar Barang ---");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                        }
                        System.out.println("----------------------");
                    }
                    break;

                case 3:

                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                        break;
                    }

                    try {
                        System.out.println("\n--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                        }

                        System.out.print("Masukkan nomor indeks barang: ");
                        int index = scanner.nextInt();
                        Barang barangDipilih = daftarBarang.get(index);

                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        if (jumlah > barangDipilih.getStok()) {
                            throw new StokTidakCukupException("Stok untuk '" + barangDipilih.getNama()
                                    + "' hanya tersisa " + barangDipilih.getStok());
                        }


                        barangDipilih.setStok(barangDipilih.getStok() - jumlah);
                        System.out.println("Stok barang '" + barangDipilih.getNama()
                                + "' berhasil dikurangi. Sisa stok: " + barangDipilih.getStok());

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid!");
                        scanner.nextLine();
                    } catch (StokTidakCukupException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    int totalStok = 0;
                    for (Barang b : daftarBarang) {
                        totalStok += b.getStok();
                    }
                    System.out.println("Total seluruh stok barang: " + totalStok);
                    break;
                case 0:

                    System.out.println("Terima kasih! Program berakhir.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}
