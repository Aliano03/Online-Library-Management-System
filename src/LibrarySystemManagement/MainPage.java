package LibrarySystemManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainPage implements ActionListener {
    User user;
    AccountManagement accounts = new AccountManagement();
    DefaultTableModel model;
    int searchButtonType;

    JFrame mainPage = new JFrame("Cloudbrary - your online library");

    JButton addBookToLibraryButton = new JButton("Add new books to Cloudbrary");
    JButton manageBooksInLibrary = new JButton("Manage books in the Cloudbrary");
    JButton addBookButton = new JButton("Add book");
    JButton addBooksToBookshelf = new JButton("Add books to your bookshelf");
    JButton readBooks = new JButton("Read your books");
    JButton banUsersButton = new JButton("Ban some users!");
    JButton accountSettingsButton = new JButton("Change account settings");
    JButton changePasswordButton = new JButton("Change your password");
    JButton confirmButton = new JButton("Confirm");
    JButton deleteAccountButton = new JButton("Delete account");
    JButton logOutButton = new JButton("Log out");
    JButton banUserButton = new JButton("Ban user");
    JButton unbanUserButton = new JButton("Unban user");
    JButton searchButton = new JButton("Search");
    JButton backToMainPageButton = new JButton("Go back to main page");

    JLabel headerLabel = new JLabel("Cloudbrary");
    JLabel welcomeLabel = new JLabel();
    JLabel messageLabel = new JLabel();

    JTextField searchBarField = new JTextField();
    JTextField passwordField = new JTextField();

    JTable searchResultsTable = new JTable();

    MainPage(Borrower borrower, AccountManagement accounts) {
        //Using copying constructor
        this.user = new Borrower(borrower, accounts);
        this.accounts = accounts;

        if (!user.isBanned()) {
            mainPagePattern();

            model = (DefaultTableModel) searchResultsTable.getModel();
            model.addColumn("Author");
            model.addColumn("Title");
            model.addColumn("Genre");
            model.addColumn("Price");
            model.addColumn("Copies");
        } else {
            bannedPagePattern();
        }
    }
    MainPage(Librarian librarian, AccountManagement accounts) {
        //Using copying constructor
        this.user = new Librarian(librarian, accounts);
        this.accounts = accounts;

        if (!user.isBanned()) {
            mainPagePattern();

            addBookToLibraryButton.setBounds(250, 180, 300, 60);
            blueButtonSettings(addBookToLibraryButton);

            manageBooksInLibrary.setBounds(250, 240, 300, 60);
            blueButtonSettings(manageBooksInLibrary);

            accountSettingsButton.setBounds(250, 320, 300, 60);

            logOutButton.setBounds(250, 400, 300, 60);

            addBookButton.setBounds(200, 360, 400, 40);
            blueButtonSettings(addBookButton);

            model = (DefaultTableModel) searchResultsTable.getModel();
            model.addColumn("Author");
            model.addColumn("Title");
            model.addColumn("Genre");
            model.addColumn("Price");
            model.addColumn("Copies");

            mainPage.add(addBookToLibraryButton);
            mainPage.add(manageBooksInLibrary);
            mainPage.add(addBookButton);
        } else {
            bannedPagePattern();
        }
    }
    MainPage(Administrator administrator, AccountManagement accounts) {
        //Using copying constructor
        this.user = new Administrator(administrator, accounts);
        this.accounts = accounts;

        if (!user.isBanned()) {
            mainPagePattern();

            banUsersButton.setBounds(250, 180, 300, 80);
            blueButtonSettings(banUsersButton);

            banUserButton.setBounds(400, 360, 200, 40);
            blueButtonSettings(banUserButton);

            unbanUserButton.setBounds(200, 360, 200, 40);
            blueButtonSettings(unbanUserButton);

            mainPage.add(banUsersButton);
            mainPage.add(banUserButton);
            mainPage.add(unbanUserButton);
            //mainPage.add()

            model = (DefaultTableModel) searchResultsTable.getModel();
            model.addColumn("Login");
            model.addColumn("Name");
            model.addColumn("Surname");
        }
        else {
            bannedPagePattern();
        }
    }

    private void bannedPagePattern() {
        mainPage();

        welcomeLabel.setText("Welcome " + user.getName() + ". You've been banned");
        welcomeLabel.setBounds(200, 120, 400, 40);
        labelSettings(welcomeLabel);

        mainPage.add(welcomeLabel);
    }

    private void mainPage() {
        mainPage.setSize(800, 600);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Setting the page to exit on close button
        mainPage.getContentPane().setBackground(new Color(49, 54, 59));
        mainPage.setResizable(true);
        mainPage.setVisible(true);
        mainPage.setLayout(null);
        mainPage.setLocationRelativeTo(null);
        //mainPage.setLayout(new FlowLayout());

        headerLabel.setBounds(250, 60, 300, 60);
        headerLabel.setHorizontalAlignment(JTextField.CENTER);
        headerLabel.setFont(new Font(null, Font.BOLD, 40));
        headerLabel.setForeground(Color.WHITE);

        accountSettingsButton.setBounds(250, 280, 300, 80);
        blueButtonSettings(accountSettingsButton);

        logOutButton.setBounds(250, 380, 300, 80);
        blueButtonSettings(logOutButton);

        mainPage.add(headerLabel);
        mainPage.add(accountSettingsButton);
        mainPage.add(logOutButton);
    }

    private void mainPagePattern() {
        mainPage();

        searchButton.setBounds(470, 180, 130, 40);
        blueButtonSettings(searchButton);
        searchButton.setBackground(new Color(93, 96, 98));

        changePasswordButton.setBounds(250, 180, 300, 40);
        blueButtonSettings(changePasswordButton);

        confirmButton.setBounds(250, 220, 300, 40);
        blueButtonSettings(confirmButton);

        deleteAccountButton.setBounds(250, 280, 300, 80);
        blueButtonSettings(deleteAccountButton);

        blueButtonSettings(backToMainPageButton);

        welcomeLabel.setText("Welcome " + user.getName() + "! What would you like to do today?");
        welcomeLabel.setBounds(200, 120, 400, 40);
        labelSettings(welcomeLabel);

        searchBarField.setBounds(200, 180, 250, 40);
        textFieldSettings(searchBarField);

        passwordField.setBounds(250, 180, 300, 40);
        textFieldSettings(passwordField);

        messageLabel.setBounds(200, 460, 400, 40);
        labelSettings(messageLabel);

        searchResultsTable.setBounds(200, 240, 400, 120);
        searchResultsTable.setBackground(new Color(35, 38, 41));

        //searchResultsScrollPane.setPreferredSize(new Dimension(200, 200));

        mainPage.add(searchButton);
        mainPage.add(changePasswordButton);
        mainPage.add(confirmButton);
        mainPage.add(deleteAccountButton);
        mainPage.add(backToMainPageButton);
        mainPage.add(searchBarField);
        mainPage.add(passwordField);
        mainPage.add(welcomeLabel);
        mainPage.add(messageLabel);
        mainPage.add(searchResultsTable);

        /*JScrollPane searchResultsScrollPane = new JScrollPane(searchResultsTable);
        mainPage.getContentPane().add(searchResultsScrollPane, BorderLayout.CENTER);*/
        //mainPage.pack();

        setVisibilityToFalse();
        mainPageVisibilitySettings();
    }

    private void blueButtonSettings(JButton button) {
        button.setFont(new Font(null, Font.PLAIN, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(61, 174, 233));
        button.addActionListener(this);
    }

    private void textFieldSettings(JTextField textField) {
        textField.setBackground(new Color(35, 38, 41));
        textField.setMargin(new Insets(0, 10, 0, 10)); //Allows to save space between the field and an input text
        textField.setHorizontalAlignment(JTextField.CENTER); //Sets an input text in the center of the text field
        textField.setFont(new Font(null, Font.PLAIN, 15));
        textField.setForeground(Color.WHITE);
    }

    private void labelSettings(JLabel label) {
        label.setHorizontalAlignment(JTextField.CENTER);
        label.setFont(new Font(null, Font.PLAIN, 15));
        label.setForeground(new Color(93, 96, 98));
    }

    private void searchPageVisibilitySettings() {
        searchButton.setVisible(true);
        backToMainPageButton.setVisible(true);
        searchBarField.setVisible(true);
        searchResultsTable.setVisible(true);

        banUserButton.setVisible(true);
        unbanUserButton.setVisible(true);

        addBookButton.setVisible(true);

        backToMainPageButton.setBounds(200, 420, 400, 40);
    }

    private void mainPageVisibilitySettings() {
        addBookToLibraryButton.setVisible(true);
        manageBooksInLibrary.setVisible(true);

        banUsersButton.setVisible(true);
        accountSettingsButton.setVisible(true);
        logOutButton.setVisible(true);
    }

    private void accountSettingsPageVisibilitySettings() {
        passwordField.setVisible(false);

        changePasswordButton.setVisible(true);
        confirmButton.setVisible(true);
        deleteAccountButton.setVisible(true);
        backToMainPageButton.setVisible(true);

        backToMainPageButton.setBounds(250, 380, 300, 80);
    }

    private void setVisibilityToFalse() {
        searchButton.setVisible(false);
        backToMainPageButton.setVisible(false);
        searchBarField.setVisible(false);
        searchResultsTable.setVisible(false);
        banUserButton.setVisible(false);
        unbanUserButton.setVisible(false);
        backToMainPageButton.setVisible(false);

        messageLabel.setText("");

        addBookToLibraryButton.setVisible(false);
        manageBooksInLibrary.setVisible(false);
        addBookButton.setVisible(false);

        changePasswordButton.setVisible(false);
        confirmButton.setVisible(false);
        passwordField.setVisible(false);
        deleteAccountButton.setVisible(false);

        banUsersButton.setVisible(false);
        accountSettingsButton.setVisible(false);
        logOutButton.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == banUsersButton) {
            setVisibilityToFalse();
            searchPageVisibilitySettings();
        }
        if (e.getSource() == searchButton) {
            String string = searchBarField.getText();
            //Clearing all the previous results
            model.setRowCount(0);
            if (user instanceof Borrower) {

            }
            if (user instanceof Librarian) {
                if (searchButtonType == 1) {
                    String[][] data = ((Librarian) user).findBookInStock(string);
                    for (String[] datum : data) {
                        model.addRow(new String[]{datum[0], datum[1], datum[2], datum[3], datum[4]});
                    }
                } else {
                    String[][] data = ((Librarian) user).findBookInLibrary(string);
                    for (String[] datum : data) {
                        model.addRow(new String[]{datum[0], datum[1], datum[2], datum[3], datum[4]});
                    }
                }
            }
            if (user instanceof Administrator) {
                String[][] data = ((Administrator) user).findUser(accounts.getAccounts(), string);
                for (String[] datum : data) {
                    model.addRow(new String[]{datum[0], datum[1], datum[2]});
                }
            }
        }
        if (e.getSource() == accountSettingsButton) {
            setVisibilityToFalse();
            accountSettingsPageVisibilitySettings();
        }
        if (e.getSource() == changePasswordButton) {
            changePasswordButton.setVisible(false);
            passwordField.setVisible(true);
        }
        if (e.getSource() == confirmButton) {
            String password = passwordField.getText();
            if (!password.isEmpty()) {
                //Can't change it directly by user.setPassword since the changes must be applied to the list...
                accounts.getUser(user.getLogin()).setPassword(password);
                accounts.saveAccounts();
                messageLabel.setText("Your password has been changed successfully!");
                System.out.println(user.getName() + "'s password has been changed to " + accounts.getUser(user.getLogin()).getPassword());
            } else {
                messageLabel.setText("Input a new password");
            }
        }
        if (e.getSource() == deleteAccountButton) {
            accountSettingsPageVisibilitySettings();
            int result = JOptionPane.showOptionDialog(null, "Your account will be gone forever. Are you sure?",
                    "delete account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
            if (result == JOptionPane.OK_OPTION) {
                System.out.println(user.getLogin() + " has been successfully removed");
                //This list knows user's index so it not out of bounds
                accounts.removeAccount(accounts.findByLogin(user.getLogin()));
                accounts.setLastSession("");
                mainPage.dispose();
                LoginPage loginPage = new LoginPage(accounts);
            }
        }
        if (e.getSource() == logOutButton) {
            int result = JOptionPane.showOptionDialog(null, "This will log you out. Are you sure?",
                    "Log out", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
            if (result == JOptionPane.OK_OPTION) {
                accounts.setLastSession("");
                mainPage.dispose();
                LoginPage loginPage = new LoginPage(accounts);
            }
        }
        if (e.getSource() == addBookToLibraryButton) {
            searchButtonType = 1;
            setVisibilityToFalse();
            searchPageVisibilitySettings();
        }
        if (e.getSource() == addBookButton) {
            Object author = searchResultsTable.getValueAt(searchResultsTable.getSelectedRow(), 0);
            Object title = searchResultsTable.getValueAt(searchResultsTable.getSelectedRow(), 1);
            System.out.println("Added book is " + title + " by " + author);
            ((Librarian) user).addBookToLibrary((String) author, (String) title);
            System.out.println(title + " has been added successfully");
        }
        if (e.getSource() == manageBooksInLibrary) {
            searchButtonType = 2;
            setVisibilityToFalse();
            searchPageVisibilitySettings();
            addBookButton.setVisible(false);
        }
        if (e.getSource() == banUserButton) {
            if(searchResultsTable.getSelectedRowCount() == 1) {
                Object value = searchResultsTable.getValueAt(searchResultsTable.getSelectedRow(), 0);
                System.out.println("User to be banned: " + value);
                ((Administrator) user).banUser((String) value);
                System.out.println("User " + value + " has been banned successfully");
            }
        }
        if (e.getSource() == unbanUserButton) {
            Object value = searchResultsTable.getValueAt(searchResultsTable.getSelectedRow(), 0);
            System.out.println("User to be unbanned: " + value);
            ((Administrator) user).unbanUser((String) value);
            System.out.println("User " + value + " has been unbanned successfully");
        }
        if (e.getSource() == backToMainPageButton) {
            setVisibilityToFalse();
            mainPageVisibilitySettings();
        }
    }
}


