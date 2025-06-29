package LibrarySystemManagement;

public class Book {
    private String author;
    private String title;
    private String genre;
    private int copiesAvailable;
    private double price;
    private BookStatus status;

    public Book(String author, String title, String genre, int copiesAvailable, double price) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.copiesAvailable = copiesAvailable;
        this.price = price;
    }

    public Book(String author, String title, String genre, int copiesAvailable, double price, BookStatus status) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.copiesAvailable = copiesAvailable;
        this.price = price;
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
