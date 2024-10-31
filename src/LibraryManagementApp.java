import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementApp {
    public static void main(String[] args) {
        ArrayList<book> libraryBooks = new ArrayList<>();
        Librarian librarian = new Librarian("Alice", 1, libraryBooks);
        Member member = new Member("Bob", 2);
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Library System!");

        while (!exit) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        librarian.addBook(new book(title, author, isbn));
                        System.out.println("Book added.");
                        break;
                    case 2:
                        System.out.print("Enter ISBN to remove: ");
                        String removeISBN = scanner.nextLine();
                        librarian.removeBook(removeISBN);
                        System.out.println("Book removed.");
                        break;
                    case 3:
                        System.out.print("Enter ISBN to borrow: ");
                        String borrowISBN = scanner.nextLine();
                        libraryBooks.stream()
                            .filter(b -> b.getISBN().equals(borrowISBN))
                            .findFirst()
                            .ifPresentOrElse(
                                member::borrowBook,
                                () -> System.out.println("Not available."));
                        break;
                    case 4:
                        System.out.print("Enter ISBN to return: ");
                        String returnISBN = scanner.nextLine();
                        libraryBooks.stream()
                            .filter(b -> b.getISBN().equals(returnISBN))
                            .findFirst()
                            .ifPresentOrElse(
                                member::returnBook,
                                () -> System.out.println("Not found in your list."));
                        break;
                    case 5:
                        System.out.println("Library Books:");
                        if (libraryBooks.isEmpty()) {
                            System.out.println("No books here yet.");
                        } else {
                            libraryBooks.forEach(System.out::println);
                        }
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Library System closed. See you!");
    }
}
