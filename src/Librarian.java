import java.util.ArrayList;

public class Librarian extends User {
    private ArrayList<book> libraryBooks;

    public Librarian(String name, int userId, ArrayList<book> libraryBooks) {
        super(name, userId);
        this.libraryBooks = libraryBooks;
    }

    @Override
    public void displayRole() {
        System.out.println("Librarian: " + name);
    }

    public void addBook(book book) {
        libraryBooks.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(String ISBN) {
        try {
            book bookToRemove = libraryBooks.stream().filter(book -> book.getISBN().equals(ISBN)).findFirst()
                    .orElseThrow(() -> new Exception("Book not found!"));
            libraryBooks.remove(bookToRemove);
            System.out.println("Book removed: " + bookToRemove.getTitle());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
