package LibrarySystemManagement;

public abstract class User {
    protected boolean isBanned;
    protected String address;
    protected String name;
    protected String surname;
    protected String password;
    protected String login;

    public User(String address, String name, String surname) {
        this.address = address;
        this.name = name;
        this.surname = surname;
    }

    public User(String address, String name, String surname, String login, String password, boolean isBanned) {
        this.address = address;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.login = login;
        this.isBanned = isBanned;
    }

    public User(User user) {
        this.address = user.address;
        this.name = user.name;
        this.surname = user.surname;
        this.login = user.login;
        this.password = user.password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void addDomain();

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }
}
