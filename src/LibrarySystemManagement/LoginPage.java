package LibrarySystemManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginPage implements ActionListener {
    AccountManagement accounts = new AccountManagement();
    private String address;
    private String name;
    private String surname;

    //All graphic tools needed for this page
    JFrame loginPage = new JFrame("Cloudbrary - Log in");

    JLabel headerLabel = new JLabel();
    JLabel hintLabel = new JLabel("Who would you like to use the system as?");
    JLabel loginLabel = new JLabel("Login:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel addressLabel = new JLabel("Address e-mail:");
    JLabel nameLabel = new JLabel("Name:");
    JLabel surnameLabel = new JLabel("Surname:");
    JLabel messageLabel = new JLabel();

    JTextField loginField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField addressField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField surnameField = new JTextField();
    JTextField librarianCodeField = new JTextField();
    JTextField administratorCodeField = new JTextField();

    JButton loginButton = new JButton("Log in");
    JButton registerPageButton = new JButton("Sign up");
    JButton nextPageButton = new JButton("Next page →");
    JButton previousPageButton = new JButton("← Previous Page");
    JButton loginPageButton = new JButton("Log in");
    JButton registerButton = new JButton("Sign up");
    JButton BorrowerButton = new JButton("Borrower");
    JButton librarianButton = new JButton("Library worker");
    JButton administratorButton = new JButton("Administrator");


    LoginPage(AccountManagement accounts) {
        if(accounts.getLastSession() == null) {
            this.accounts = accounts;

            //Modifying the frame itself
            loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Setting the page to exit on close button
            loginPage.setSize(800, 600);
            loginPage.getContentPane().setBackground(new Color(49, 54, 59));
            loginPage.setResizable(false);
            loginPage.setVisible(true);
            loginPage.setLayout(null);
            loginPage.setLocationRelativeTo(null); //puts the frame in the center of a screen

            headerLabel.setText("Log in");
            headerLabel.setBounds(250, 60, 300, 60);
            headerLabel.setHorizontalAlignment(JTextField.CENTER);
            headerLabel.setFont(new Font(null, Font.BOLD, 40));
            headerLabel.setForeground(Color.WHITE);

            hintLabel.setBounds(250, 140, 300, 40);
            hintLabel.setHorizontalAlignment(JTextField.CENTER);
            hintLabel.setFont(new Font(null, Font.PLAIN, 15));
            hintLabel.setForeground(new Color(93, 96, 98));

            loginLabel.setBounds(130, 240, 100, 40);
            loginLabel.setHorizontalAlignment(JTextField.RIGHT);
            loginLabel.setFont(new Font(null, Font.PLAIN, 15));
            loginLabel.setForeground(Color.WHITE);

            passwordLabel.setBounds(130, 300, 100, 40);
            passwordLabel.setHorizontalAlignment(JTextField.RIGHT);
            passwordLabel.setFont(new Font(null, Font.PLAIN, 15));
            passwordLabel.setForeground(Color.WHITE);

            addressLabel.setBounds(100, 180, 130, 40);
            addressLabel.setHorizontalAlignment(JTextField.RIGHT);
            addressLabel.setFont(new Font(null, Font.PLAIN, 15));
            addressLabel.setForeground(Color.WHITE);

            nameLabel.setBounds(130, 240, 100, 40);
            nameLabel.setHorizontalAlignment(JTextField.RIGHT);
            nameLabel.setFont(new Font(null, Font.PLAIN, 15));
            nameLabel.setForeground(Color.WHITE);

            surnameLabel.setBounds(130, 300, 100, 40);
            surnameLabel.setHorizontalAlignment(JTextField.RIGHT);
            surnameLabel.setFont(new Font(null, Font.PLAIN, 15));
            surnameLabel.setForeground(Color.WHITE);

            messageLabel.setBounds(200, 480, 400, 40);
            messageLabel.setHorizontalAlignment(JTextField.CENTER);
            messageLabel.setFont(new Font(null, Font.PLAIN, 15));
            messageLabel.setForeground(Color.WHITE);

            loginField.setBounds(250, 240, 300, 40);
            loginField.setBackground(new Color(35, 38, 41));
            //loginField.setBorder(BorderFactory.createEmptyBorder()); //aesthetics, deletes borders of the text field
            loginField.setMargin(new Insets(0, 10, 0, 10)); //Allows to save space between the field and an input text
            loginField.setHorizontalAlignment(JTextField.CENTER); //Sets an input text in the center of the text field
            loginField.setFont(new Font(null, Font.PLAIN, 15));
            loginField.setForeground(Color.WHITE);

            passwordField.setBounds(250, 300, 300, 40);
            passwordField.setBackground(new Color(35, 38, 41));
            passwordField.setMargin(new Insets(0, 10, 0, 10)); //Allows to save space between the field and an input text
            //passwordField.setBorder(BorderFactory.createLineBorder(new Color(61, 174, 233), 2)); //aesthetics, deletes borders of the text field
            passwordField.setHorizontalAlignment(JTextField.CENTER); //Sets an input text in the center of the text field
            passwordField.setFont(new Font(null, Font.PLAIN, 20));
            passwordField.setForeground(Color.WHITE);

            addressField.setBounds(250, 180, 300, 40);
            addressField.setBackground(new Color(35, 38, 41));
            //loginField.setBorder(BorderFactory.createEmptyBorder()); //aesthetics, deletes borders of the text field
            addressField.setMargin(new Insets(0, 10, 0, 10)); //Allows to save space between the field and an input text
            addressField.setHorizontalAlignment(JTextField.CENTER); //Sets an input text in the center of the text field
            addressField.setFont(new Font(null, Font.PLAIN, 15));
            addressField.setForeground(Color.WHITE);

            nameField.setBounds(250, 240, 300, 40);
            nameField.setBackground(new Color(35, 38, 41));
            //loginField.setBorder(BorderFactory.createEmptyBorder()); //aesthetics, deletes borders of the text field
            nameField.setMargin(new Insets(0, 10, 0, 10)); //Allows to save space between the field and an input text
            nameField.setHorizontalAlignment(JTextField.CENTER); //Sets an input text in the center of the text field
            nameField.setFont(new Font(null, Font.PLAIN, 15));
            nameField.setForeground(Color.WHITE);

            surnameField.setBounds(250, 300, 300, 40);
            surnameField.setBackground(new Color(35, 38, 41));
            surnameField.setMargin(new Insets(0, 10, 0, 10)); //Allows to save space between the field and an input text
            //passwordField.setBorder(BorderFactory.createLineBorder(new Color(61, 174, 233), 2)); //aesthetics, deletes borders of the text field
            surnameField.setHorizontalAlignment(JTextField.CENTER); //Sets an input text in the center of the text field
            surnameField.setFont(new Font(null, Font.PLAIN, 15));
            surnameField.setForeground(Color.WHITE);

            librarianCodeField.setBounds(250, 240, 300, 40);
            librarianCodeField.setBackground(new Color(35, 38, 41));
            librarianCodeField.setMargin(new Insets(0, 10, 0, 10)); //Allows to save space between the field and an input text
            //passwordField.setBorder(BorderFactory.createLineBorder(new Color(61, 174, 233), 2)); //aesthetics, deletes borders of the text field
            librarianCodeField.setHorizontalAlignment(JTextField.CENTER); //Sets an input text in the center of the text field
            librarianCodeField.setFont(new Font(null, Font.PLAIN, 15));
            librarianCodeField.setForeground(Color.WHITE);

            administratorCodeField.setBounds(250, 300, 300, 40);
            administratorCodeField.setBackground(new Color(35, 38, 41));
            administratorCodeField.setMargin(new Insets(0, 10, 0, 10)); //Allows to save space between the field and an input text
            //passwordField.setBorder(BorderFactory.createLineBorder(new Color(61, 174, 233), 2)); //aesthetics, deletes borders of the text field
            administratorCodeField.setHorizontalAlignment(JTextField.CENTER); //Sets an input text in the center of the text field
            administratorCodeField.setFont(new Font(null, Font.PLAIN, 15));
            administratorCodeField.setForeground(Color.WHITE);

            loginButton.setBounds(250, 420, 125, 40);
            loginButton.setFont(new Font(null, Font.BOLD, 15));
            loginButton.setForeground(Color.WHITE);
            loginButton.setBackground(new Color(61, 174, 233));
            loginButton.addActionListener(this); //the implemented ActionListener with the overridden method

            registerPageButton.setBounds(425, 420, 125, 40);
            registerPageButton.setFont(new Font(null, Font.BOLD, 15));
            registerPageButton.setForeground(Color.WHITE);
            registerPageButton.setBackground(new Color(61, 174, 233));
            registerPageButton.addActionListener(this); //the implemented ActionListener with the overridden method

            BorrowerButton.setBounds(250, 180, 300, 40);
            BorrowerButton.setFont(new Font(null, Font.PLAIN, 15));
            BorrowerButton.setForeground(Color.WHITE);
            BorrowerButton.setBackground(new Color(93, 96, 98));
            BorrowerButton.addActionListener(this); //the implemented ActionListener with the overridden method

            librarianButton.setBounds(250, 240, 300, 40);
            librarianButton.setFont(new Font(null, Font.PLAIN, 15));
            librarianButton.setForeground(Color.WHITE);
            librarianButton.setBackground(new Color(93, 96, 98));
            librarianButton.addActionListener(this); //the implemented ActionListener with the overridden method

            administratorButton.setBounds(250, 300, 300, 40);
            administratorButton.setFont(new Font(null, Font.PLAIN, 15));
            administratorButton.setForeground(Color.WHITE);
            administratorButton.setBackground(new Color(93, 96, 98));
            administratorButton.addActionListener(this); //the implemented ActionListener with the overridden method

            nextPageButton.setBounds(250, 360, 300, 40);
            nextPageButton.setFont(new Font(null, Font.PLAIN, 15));
            nextPageButton.setForeground(Color.WHITE);
            nextPageButton.setBackground(new Color(93, 96, 98));
            nextPageButton.addActionListener(this); //the implemented ActionListener with the overridden method

            previousPageButton.setBounds(250, 360, 300, 40);
            previousPageButton.setFont(new Font(null, Font.PLAIN, 15));
            previousPageButton.setForeground(Color.WHITE);
            previousPageButton.setBackground(new Color(93, 96, 98));
            previousPageButton.addActionListener(this); //the implemented ActionListener with the overridden method

            loginPageButton.setBounds(250, 420, 125, 40);
            loginPageButton.setFont(new Font(null, Font.BOLD, 15));
            loginPageButton.setForeground(Color.WHITE);
            loginPageButton.setBackground(new Color(61, 174, 233));
            loginPageButton.addActionListener(this); //the implemented ActionListener with the overridden method

            registerButton.setBounds(425, 420, 125, 40);
            registerButton.setFont(new Font(null, Font.BOLD, 15));
            registerButton.setForeground(Color.WHITE);
            registerButton.setBackground(new Color(61, 174, 233));
            registerButton.addActionListener(this); //the implemented ActionListener with the overridden method

            LoginAndRegisterPageVisibilitySettings(true, false);

            //Adding all components needed to the frames
            loginPage.add(headerLabel);
            loginPage.add(hintLabel);
            loginPage.add(loginLabel);
            loginPage.add(passwordLabel);
            loginPage.add(messageLabel);
            loginPage.add(loginField);
            loginPage.add(passwordField);
            loginPage.add(loginButton);
            loginPage.add(registerPageButton);

            //For the registration
            loginPage.add(addressLabel);
            loginPage.add(nameLabel);
            loginPage.add(surnameLabel);
            loginPage.add(addressField);
            loginPage.add(addressField);
            loginPage.add(nameField);
            loginPage.add(surnameField);
            loginPage.add(librarianCodeField);
            loginPage.add(administratorCodeField);
            loginPage.add(nextPageButton);
            loginPage.add(previousPageButton);
            loginPage.add(loginPageButton);
            loginPage.add(registerButton);
            loginPage.add(BorrowerButton);
            loginPage.add(librarianButton);
            loginPage.add(administratorButton);
        } else {
            loggingProcedure(accounts.getLastSession());
        }
    }

    private void LoginAndRegisterPageVisibilitySettings(boolean login, boolean register) {
        loginLabel.setVisible(login);
        passwordLabel.setVisible(login);
        loginField.setVisible(login);
        passwordField.setVisible(login);
        loginButton.setVisible(login);
        registerPageButton.setVisible(login);

        hintLabel.setVisible(false);
        librarianCodeField.setVisible(false);
        administratorCodeField.setVisible(false);
        BorrowerButton.setVisible(false);
        librarianButton.setVisible(false);
        administratorButton.setVisible(false);
        previousPageButton.setVisible(false);
        registerButton.setVisible(false);

        addressLabel.setVisible(register);
        nameLabel.setVisible(register);
        surnameLabel.setVisible(register);
        addressField.setVisible(register);
        nameField.setVisible(register);
        surnameField.setVisible(register);
        loginPageButton.setVisible(register);
        nextPageButton.setVisible(register);
    }
    private void registerPageVisibilitySettings(boolean previous, boolean next) {
        nextPageButton.setVisible(previous);
        addressLabel.setVisible(previous);
        nameLabel.setVisible(previous);
        surnameLabel.setVisible(previous);
        addressField.setVisible(previous);
        nameField.setVisible(previous);
        surnameField.setVisible(previous);

        BorrowerButton.setBorderPainted(false);
        BorrowerButton.setBorder(BorderFactory.createEmptyBorder());
        librarianCodeField.setVisible(false);
        librarianCodeField.setText(null);
        administratorCodeField.setVisible(false);
        administratorCodeField.setText(null);

        hintLabel.setVisible(next);
        BorrowerButton.setVisible(next);
        librarianButton.setVisible(next);
        administratorButton.setVisible(next);
        previousPageButton.setVisible(next);
        registerButton.setVisible(next);
    }

    private void backToLoginPage() {
        addressField.setText(null);
        nameField.setText(null);
        surnameField.setText(null);
        messageLabel.setText(null);

        loginPage.setTitle("Cloudbrary - Log in");
        headerLabel.setText("Log in");

        registerButton.setVisible(false);
        LoginAndRegisterPageVisibilitySettings(true, false);
    }

    private void loggingProcedure(String login) {
        //Open page as a borrower, a librarian or an administrator
        if (accounts.getUser(login) instanceof Borrower) {
            MainPage mainPage = new MainPage((Borrower) accounts.getUser(login), accounts);
        }
        if (accounts.getUser(login) instanceof Librarian) {
            MainPage mainPage = new MainPage((Librarian) accounts.getUser(login), accounts);
        }
        if (accounts.getUser(login) instanceof Administrator) {
            MainPage mainPage = new MainPage((Administrator) accounts.getUser(login), accounts);
        }
    }

    //Substring is to cut the string into parts, so the name and surname are always written correctly
    private String correctDataSourcing(String string) {
        string = string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
        return string;
    }

    public ArrayList<User> getAccounts() {
        return accounts.getAccounts();
    }
    public void setAccounts(AccountManagement accounts) {
        this.accounts = accounts;
    }

    //Handling events by overriding ActionListener's method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BorrowerButton) {
            registerPageVisibilitySettings(false, true);
            BorrowerButton.setBorderPainted(true);
            BorrowerButton.setBorder(BorderFactory.createLineBorder(new Color(61, 174, 233), 2));
        }
        if (e.getSource() == librarianButton) {
            registerPageVisibilitySettings(false, true);
            librarianButton.setVisible(false);
            librarianCodeField.setVisible(true);
        }
        if (e.getSource() == administratorButton) {
            registerPageVisibilitySettings(false, true);
            administratorButton.setVisible(false);
            administratorCodeField.setVisible(true);
        }
        if (e.getSource() == loginButton) {
            String login = loginField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (accounts.verifyUser(login, password)) {
                messageLabel.setText("Logging successful!");
                loginPage.dispose();
                accounts.setLastSession(login);
                loggingProcedure(login);
            } else {
                messageLabel.setText("The input login or password may be wrong. Try again.");
            }
        }
        if (e.getSource() == registerPageButton) {
            loginPage.setTitle("Cloudbrary - Sign up");
            headerLabel.setText("Sign up");

            messageLabel.setText("This won't take long...");

            LoginAndRegisterPageVisibilitySettings(false, true);
        }
        if (e.getSource() == previousPageButton) {
            registerPageVisibilitySettings(true, false);
        }
        if (e.getSource() == nextPageButton) {
            String address = addressField.getText().toLowerCase();
            String name = nameField.getText();
            String surname = surnameField.getText();
            //Checking correctness of address and if all the required parameters are given
            //Trim is to avoid letting whitespace in
            if (!address.trim().isEmpty() && !name.trim().isEmpty() && !surname.trim().isEmpty()) {
                //Defining what a string should include
                //char-char - any character from char to char
                //+ - at least one character must appear
                //\\. - literally a dot
                if(address.matches("[a-z, A-Z, 1-9]+@[a-z, A-Z, 1-9]+\\.[a-z, A-Z, 1-9]+")) {
                        this.address = address.toLowerCase();
                        this.name = correctDataSourcing(name);
                        this.surname = correctDataSourcing(surname);

                        registerPageVisibilitySettings(false, true);
                } else {
                    messageLabel.setText("Please, input correct address");
                }
            } else {
                messageLabel.setText("Please, input all the required data");
            }
        }
        if (e.getSource() == loginPageButton) {
            if (!messageLabel.getText().equals("You signed up successfully!")) {
                int result = JOptionPane.showOptionDialog(null, "This action will disrupt the registration. Are you sure?",
                        "Go to \"Log in\" page", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
                if (result == JOptionPane.OK_OPTION) {
                    backToLoginPage();
                }
            } else {
                backToLoginPage();
            }
        }
        if (e.getSource() == registerButton) {
            String administratorCode = administratorCodeField.getText();
            String librarianCode = librarianCodeField.getText();
            if (administratorCode.equals("administratorC0de")) {
                if (accounts.verifyAddress(address)) {
                    accounts.registerAccount(new Administrator(address, name, surname));
                    System.out.println("An administrator has been registered.");
                    messageLabel.setText("You signed up successfully!");
                } else {
                    messageLabel.setText("An account with this address already exists.");
                }
            } else if (librarianCode.equals("librarianC0de")) {
                if (accounts.verifyAddress(address)) {
                    accounts.registerAccount(new Librarian(address, name, surname));
                    System.out.println("A librarian has been registered.");
                    messageLabel.setText("You signed up successfully!");
                } else {
                    messageLabel.setText("An account with this address already exists.");
                }
            } else if (BorrowerButton.isBorderPainted()) {
                if (accounts.verifyAddress(address)) {
                    accounts.registerAccount(new Borrower(address, name, surname));
                    System.out.println("A borrower has been registered.");
                    messageLabel.setText("You signed up successfully!");
                } else {
                    messageLabel.setText("An account with this address already exists.");
                }
            } else if (!BorrowerButton.isBorderPainted() && !librarianCodeField.isVisible() && !administratorCodeField.isVisible()) {
                messageLabel.setText("Please, choose an option");
            } else {
                messageLabel.setText("Incorrect code");
            }
        }
    }
}
