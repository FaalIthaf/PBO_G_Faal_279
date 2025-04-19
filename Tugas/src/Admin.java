public class Admin extends User{
    String username, password;

    public Admin(String nama, String nim, String username, String password){
        super(nama, nim);
        this.username = username;
        this.password = password;
    }
    @Override
    void login(String username, String password){
        if(username.equals("Admin279") && password.equals("password279")){
            displayInfo();
        } else {
            System.out.print("Login gagal! Username atau Password salah!");
        }
    }
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Informasi pengguna: ");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
