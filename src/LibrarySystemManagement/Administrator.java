package LibrarySystemManagement;

import java.util.ArrayList;
import java.util.Arrays;

public class Administrator extends User {
    AccountManagement accountManagement;

    public Administrator(String address, String name, String surname) {
        super(address, name, surname);
    }

    public Administrator(String address, String name, String surname, String password, String login, boolean isBanned) {
        super(address, name, surname, password, login, isBanned);
    }

    public Administrator(Administrator administrator, AccountManagement accounts) {
        super(administrator);
        accountManagement = accounts;
    }

    @Override
    public void addDomain() {
        login += ".administrator.cb.pl";
    }

    public String[][] findUser(ArrayList<User> accounts, String string) {
        //Setting returned table's dimension supposing every user's data may match a condition
        String[][] data = new String[accounts.size()][3];
        int rowsNumber = 0;
        string = string.toLowerCase();
        try {
            int index = 0;
            for (User user : accounts) {
                if (user.getAddress().toLowerCase().contains(string) || user.getName().toLowerCase().contains(string) ||
                        user.getSurname().toLowerCase().contains(string) || user.getLogin().toLowerCase().contains(string)) {
                    //Checking if the user is not the administrator, so it prevents from banning themselves
                    //for some reason "!user.equals(this)" doesn't work, I don't know why :(
                    if (!user.getLogin().equals(this.getLogin())) {
                        data[index][0] = user.getLogin();
                        data[index][1] = user.getName();
                        data[index][2] = user.getSurname();
                        index++;
                    }
                }
            }
            //Remembering the last row
            rowsNumber = index;
        } catch (Exception ex) {
            System.out.println("Error while finding a user");
        }
        //Eliminating the rows that are empty
        String[][] dataReady = new String[rowsNumber][3];
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < 3; j++) {
                dataReady[i][j] = data[i][j];
            }
        }
        return dataReady;
    }

    public void banUser(String login) {
        accountManagement.getUser(login).setBanned(true);
        accountManagement.saveAccounts();
    }

    public void unbanUser(String login) {
        accountManagement.getUser(login).setBanned(false);
        accountManagement.saveAccounts();
    }
}
