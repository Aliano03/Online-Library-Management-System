package LibrarySystemManagement;

import java.io.*;
import java.util.ArrayList;

public class LibraryManagement extends BookStock implements FilePaths {
    ArrayList<Book> library = new ArrayList<>();
    private static final File LIBRARY_FILE = new File(LIBRARY_FILEPATH);

    LibraryManagement() {
        super();
        this.library = updateBooks(LIBRARY_FILE);
    }
    public String[][] findBookInStock(String string) {
        return findBook(bookStock, string);
    }

    public String[][] findBookInLibrary(String string) {
        return findBook(library, string);
    }

    public String[][] findBook(ArrayList<Book> bookList, String string) {
        //Using contains instead of matches so the range of search is wider
        String[][] data = new String[bookList.size()][5];
        int rowsNumber = 0;
        string = string.toLowerCase();
        try {
            int index = 0;
            for (Book book : bookList) {
                if (book.getTitle().toLowerCase().contains(string) ||
                        book.getAuthor().toLowerCase().contains(string) || book.getGenre().toLowerCase().contains(string)) {
                    data[index][0] = book.getAuthor();
                    data[index][1] = book.getTitle();
                    data[index][2] = book.getGenre();
                    data[index][3] = String.valueOf(book.getCopiesAvailable());
                    data[index][4] = String.valueOf((book.getPrice()));
                    index++;
                }
            }
            //Remembering the last row
            rowsNumber = index;
        } catch (Exception ex) {
            System.out.println("Error while finding a book");
        }
        //Eliminating the rows that are empty
        String[][] dataReady = new String[rowsNumber][5];
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < 5; j++) {
                dataReady[i][j] = data[i][j];
            }
        }
        return dataReady;
    }

    public int findByAuthorAndTitleInStock(String author, String title) {
        return bookStock.indexOf(bookStock.stream()
                .filter(book -> book.getAuthor().equals(author) && book.getTitle().equals(title))
                .findFirst()
                .orElse(null));
    }

    public int findByAuthorAndTitleInLibrary(String author, String title) {
        return library.indexOf(library.stream()
                .filter(book -> book.getAuthor().equals(author) && book.getTitle().equals(title))
                .findFirst()
                .orElse(null));
    }

    public Book getBook(String author, String title) {
        return bookStock.get(findByAuthorAndTitleInStock(author, title));
    }

    public void addBook(Book book) {
        library.add(book);
        sortList(library);
        saveBooks(LIBRARY_FILE, library);
    }

    void removeBook(Book book) {
        //Uses findBook command or a given book object
    }

    void editBookProperty() {
        //Uses findBook command or a given book object
    }
}
