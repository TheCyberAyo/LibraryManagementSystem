import java.util.ArrayList;

public class Member extends User {
    private ArrayList<book> borrowedBooks;

    public Member(String name, int userId) {
        super(name, userId);
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public void displayRole() {
        System.out.println("Member: " + name);
    }

    public void borrowBook(book book) {
        if (!book.isBorrowed()) {
            book.borrowBook();
            borrowedBooks.add(book);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void returnBook(book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by you.");
        }
    }
}
