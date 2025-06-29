package LibrarySystemManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class BookStock implements FilePaths {
    protected ArrayList<Book> bookStock = new ArrayList<>();
    private static final File BOOK_STOCK_FILE = new File(BOOK_STOCK_FILEPATH);

    BookStock() {
        this.bookStock = updateBooks(BOOK_STOCK_FILE);
        sortList(bookStock);
        //presentBooks(bookStock);
    }

    public void sortList(ArrayList<Book> bookList) {
        //Comparing by an author and secondary by a title
        bookList.sort(Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle));
    }

    public void presentBooks(ArrayList<Book> bookList) {
        for (Book books : bookList) {
            System.out.println(books.getAuthor() + ", " + books.getTitle() + ", "
                    + books.getGenre() + ", "  + books.getCopiesAvailable() + ", "  + books.getPrice());
        }
    }

    public String presentBook(Book book) {
        return book.getAuthor() + ", " + book.getTitle() + ", " + book.getGenre() + ", "
                + book.getCopiesAvailable() + ", " + book.getPrice();
    }

    protected void saveBooks(File bookFile, ArrayList<Book> bookList) {
        //Wrapping FileWriter into BufferedWriter to use methods of BufferedWriter, like newLine()
        //Creating the object in try block makes it live temporarily
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bookFile))) {
            for (Book book : bookList) {
                fileWriter.write(presentBook(book));
                fileWriter.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Error during writing to file");
        }
    }

    protected ArrayList<Book> updateBooks(File bookFile) {
        //Making a temporary list for loading new users from a file to the main list accounts that can be used on ongoing bases
        ArrayList<Book> updatedBookList = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(bookFile))) {
            String string;
            //placing readLine() inside of the loop makes it iterate until null value and the "string" variable stands for one line
            while ((string = fileReader.readLine()) != null) {
                //Deciding to use ", " as a regex, splitting the string into data
                String[] data = string.split(", ");
                //Sourcing the data in the order it was previously saved per every regex
                String author = data[0];
                String title = data[1];
                String genre = data[2];
                //Other values need to be converted
                int copiesAvailable = Integer.parseInt(data[3]);
                double price = Double.parseDouble(data[4]);
                updatedBookList.add(new Book(author, title, genre, copiesAvailable, price));
            }
        } catch (Exception ex) {
            System.out.println(("Error during reading from the file"));
        }
        return updatedBookList;
    }
}

