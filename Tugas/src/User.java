public class User {
    private String nama;
    private String nim;

    public User(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String setNama(String nama){
        this.nama = nama;
        return nama;
    }

    public String getNim(){
        return nim;
    }

    public String setNim(String nim){
        this.nim = nim;
        return nim;
    }

    void login(String nama, String nim){
    }

    void displayInfo(){
        System.out.println("Login Sukses!");
    }
}
