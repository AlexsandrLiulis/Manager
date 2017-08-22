package Manager;

import java.util.ArrayList;

public class LibraryManager {
    private int countBooks; // убрал статическую переменную
    private int booksId = 0; //  присвоение уникального id номера для каждой созданной книги

    ArrayList<Book> library = new ArrayList<>();

    public LibraryManager addBook(Book book) {
        this.library.add(book);
        this.countBooks++;
        book.setId(++booksId);
        return this; // Вернул ссылку на экзэмпляр текущего класса для использования chein при добавлении книги
    }

    // Поиск книги по номеру в списке
    public void removeAllBook() {
        for (int i = 0; i < countBooks; ) {
            library.remove(i);
            countBooks--;
        }
    }

    public ArrayList<Book> getLibrary() {
        return library;
    }

    public void removeOfListNumber(int number) {
        library.remove(library.get(number));
        countBooks--;
    }

    // Переделал вывод библиотеки по списку
    public void showAllLibrary() {
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            System.out.println(i + 1 + " " + book.getAuthor() + ": " + book.getTitle());
        }
    }

    // Вывод всех Id номеров книг
    public void showAllIdBooks() {
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            System.out.println("Id номер " + book.getId() + ": " + book.getAuthor() + ": " + book.getTitle());
        }
    }

    public Book searchOfId(int id) {
        for (Book book : library) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public int getCountBooks() {
        return countBooks;
    }
}
