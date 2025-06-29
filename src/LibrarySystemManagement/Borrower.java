package LibrarySystemManagement;

public class Borrower extends User {
    private BookshelfManagement bookshelfManagement;

    public Borrower(String address, String name, String surname) {
        super(address, name, surname);
    }

    public Borrower(String address, String name, String surname, String login, String password, boolean isBanned) {
        super(address, name, surname, login, password, isBanned);
    }

    public Borrower(Borrower borrower, AccountManagement accounts) {
        super(borrower);
    }

    public BookshelfManagement getBookshelf() {
        return bookshelfManagement;
    }

    public void setBookshelf(BookshelfManagement bookshelfManagement) {
        this.bookshelfManagement = bookshelfManagement;
    }

    //Constructors getters and setters

    public void addDomain() {
        login += ".borrower.cb.pl";
    }

    public void makeOrder() {
        //A user can make an order
    }
}
