public class book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;

    public book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrowBook() { isBorrowed = true; }
    public void returnBook() { isBorrowed = false; }

    @Override
    public String toString() {
        return "book: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Borrowed: " + isBorrowed;
    }
}
