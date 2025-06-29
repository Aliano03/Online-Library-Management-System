package LibrarySystemManagement;

public class Main {
    public static void main(String[] args) {
        AccountManagement m = new AccountManagement();

        m.presentAccounts();

        LoginPage loginPage = new LoginPage(m);
    }
}