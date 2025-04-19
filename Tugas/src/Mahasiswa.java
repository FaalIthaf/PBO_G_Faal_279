public class Mahasiswa extends User{
     public Mahasiswa(String nama, String nim){
        super(nama, nim);
    }
    @Override
    void login(String nama, String nim){
        if(nama.equals("Fa'al Ithaf Nida Nibras") && nim.equals("202410370110279")){
            displayInfo();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah!");
        }
    }
    @Override
    void displayInfo(){
         super.displayInfo();
        System.out.println("Informasi Pengguna: ");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}
