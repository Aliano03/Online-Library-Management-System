package LibrarySystemManagement;

import java.io.File;
import java.util.ArrayList;

public class BookshelfManagement extends LibraryManagement implements FilePaths {
    ArrayList<Book> bookshelf = new ArrayList<>();
    private static final File BOOKSHELF_FILE = new File(BOOKSHELF_FILEPATH);

    BookshelfManagement() {
        super();
        this.bookshelf = updateBooks(BOOKSHELF_FILE);
    }

    @Override
    public void addBook(Book book) {
        this.bookshelf.add(book);
        sortList(bookshelf);
        saveBooks(BOOKSHELF_FILE, bookshelf);
    }
}
