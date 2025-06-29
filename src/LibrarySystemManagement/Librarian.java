package LibrarySystemManagement;

public class Librarian extends User {
    LibraryManagement libraryManagement;

    public Librarian(String address, String name, String surname) {
        super(address, name, surname);
    }

    public Librarian(String address, String name, String surname, String password, String login, boolean isBanned) {
        super(address, name, surname, password, login, isBanned);
    }

    public Librarian(Librarian librarian, AccountManagement accounts) {
        super(librarian);
        libraryManagement = new LibraryManagement();
    }

    public void addDomain() {
        login += ".librarian.cb.pl";
    }

    public String[][] findBookInStock(String string) {
        return libraryManagement.findBookInStock(string);
    }

    public String[][] findBookInLibrary(String string) {
        return libraryManagement.findBookInLibrary(string);
    }

    public void addBookToLibrary(String author, String title) {
        libraryManagement.addBook(libraryManagement.getBook(author, title));
    }
}
