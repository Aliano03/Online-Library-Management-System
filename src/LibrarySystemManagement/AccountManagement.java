package LibrarySystemManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class AccountManagement implements FilePaths {
    private static final String CHARACTERS_AVAILABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private ArrayList<User> accounts = new ArrayList<>();
    private static final File ACCOUNTS_LIST = new File(USERS_FILEPATH);
    private static final File LAST_SESSION = new File(LAST_SESSION_FILEPATH);

    public AccountManagement() {
        this.accounts = updateAccounts();
    }

    //Creating new login
    public String createLogin(User user) {
        return (user.getName().charAt(0) + user.getSurname()).toLowerCase();
    }

    //Creating new password
    public String createPassword() {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i <= 8; i++) {
            password.append(CHARACTERS_AVAILABLE.charAt(random.nextInt(62)));
        }
        System.out.println("Your password is " + password);
        return password.toString();
    }

    public void registerAccount(User user) {
        //Adding a user to the user's list
        accounts.add(user);

        //creating exemplary login
        String login = createLogin(user);

        //Searching for repeats and modifies if it's needed
        for (int i = 1; checkForRepeats(login); i++) {
            login += i;
            System.out.println("A repeat has been found. New login is " + login);
        }

        //Setting the user's login
        user.setLogin(login);

        //Generating new password
        user.setPassword(createPassword());

        //Setting user's status
        user.setBanned(false);

        //Adding user's domain
        user.addDomain();

        //Alphabetical sorting of the user's list by login
        sortList();

        //Uploading the new account to the list
        saveAccounts();
    }

    public void sortList() {
        //Sorts alphabetically by comparing user's logins
        accounts.sort(Comparator.comparing(User::getLogin));
    }

    public int findByLogin(String login) {
        return accounts.indexOf(accounts.stream().filter(user -> user.getLogin().equals(login)).findFirst().orElse(null));
    }

    public User getUser(String login) {
        return accounts.get(findByLogin(login));
    }

    public String getLastSession() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(LAST_SESSION))) {
            String string;
            if ((string = fileReader.readLine()) != null) {
                return string;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println(("Error during reading from the file"));
        }
        return null;
    }

    public void setLastSession(String login) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(LAST_SESSION))) {
                fileWriter.write(login);
            } catch (IOException ex) {
                System.out.println("Error during writing to file");
        }
    }

    //Checks if a certain login already exists
    public boolean checkForRepeats(String login) {
        String string;
        for (User user : accounts) {
            string = user.getLogin();
            try {
                String[] separateLogin = string.split("\\.");
                if (login.equals(separateLogin[0])) {
                    return true;
                }
            } catch (NullPointerException ex) {
                System.out.println("No repeats found, your login is " + login);
            }
        }
        return  false;
    }

    public boolean doesLoginExist(String login) {
        int index = 0;
        for (User user : accounts) {
            index = accounts.indexOf(user);
            if (login.equals(user.getLogin())) {
                break;
            }
        }
        return login.equals(accounts.get(index).getLogin());
    }

    //Displaying list of users' logins
    public void presentAccounts() {
        for(User user : accounts) {
            System.out.println(user.getLogin() + " " + user.getPassword());
        }
    }

    public boolean verifyUser(String login, String password) {
        if(doesLoginExist(login)) {
            int index = findByLogin(login);
            return password.equals(accounts.get(index).getPassword());
        } else {
            return false;
        }
    }

    public boolean verifyAddress(String address) {
        //Checking if the address exists
        if(accounts.stream().noneMatch(u -> u.getAddress().equals(address))) { //u is any object of the class that matches
            return true;
        } else {
            System.out.println("An account with this address already exists.");
            return false;
        }
    }

    public void removeAccount(int index) {
        accounts.remove(index);
        saveAccounts();
    }

    public void clearAccounts() {
        accounts.clear();
        saveAccounts();
    }

    public ArrayList<User> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<User> accounts) {
        this.accounts = accounts;
    }

    //Modified code from lesson 3
    public void saveAccounts() {
        //Wrapping FileWriter into BufferedWriter to use methods of BufferedWriter, like newLine()
        //Creating the object in try block makes it live temporarily
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(ACCOUNTS_LIST))) {
            for (User user : accounts) {
                //Using instanceof to recognize the inheriting class to avoid problems in readAccounts
                if (user instanceof Borrower) {
                    fileWriter.write("Borrower");
                }
                if (user instanceof Librarian) {
                    fileWriter.write("Librarian");
                }
                if (user instanceof Administrator) {
                   fileWriter.write("Administrator");
                }
                fileWriter.write(", " + user.getAddress() + ", " + user.getName() + ", " + user.getSurname() + ", "
                        + user.getLogin() + ", " + user.getPassword() + ", " + String.valueOf((user).isBanned()));
                fileWriter.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Error during writing to file");
        }
    }

    //Modified code from lesson 3
    public ArrayList<User> updateAccounts() {
        //Making a temporary list for loading new users from a file to the main list accounts that can be used on ongoing bases
        ArrayList<User> updatedAccounts = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(ACCOUNTS_LIST))) {
            String string;
            //placing readLine() inside of the loop makes it iterate until null value and the "string" variable stands for one line
            while ((string = fileReader.readLine()) != null) {
                //Deciding to use ", " as a regex, splitting the string into data
                String[] data = string.split(", ");
                //Sourcing the data in the order it was previously saved per every regex
                String address = data[1];
                String name = data[2];
                String surname = data[3];
                String login = data[4];
                String password = data[5];
                boolean isBanned = Boolean.parseBoolean(data[6]);
                //Recognizing the class
                if (data[0].equals("Borrower")) {
                    updatedAccounts.add(new Borrower(address, name, surname, login, password, isBanned));
                }
                if (data[0].equals("Librarian")) {
                    updatedAccounts.add(new Librarian(address, name, surname, login, password, isBanned));
                }
                if (data[0].equals("Administrator")) {
                    updatedAccounts.add(new Administrator(address, name, surname, login, password, isBanned));
                }
            }
        } catch (Exception ex) {
            System.out.println(("Error during reading from the file"));
        }
        return updatedAccounts;
    }
}
