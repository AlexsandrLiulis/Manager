package Manager;

import java.util.Scanner;

public class Helper {
    private Scanner scanner = new Scanner(System.in);
    private LibraryManager libraryManager;  // Присвоил ссылочной переменной libraryManager созданный экземпляр класса для использования в методах без передачи параметра.

    public Helper(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    public void start() {
        System.out.println("Выбирете что нужно сделать:");
        System.out.println("1 - для просмотра количества книг");
        System.out.println("2 - для просмотра всей библиотеки");
        System.out.println("3 - для удаления всей библиотеки");
        System.out.println("4 - для добавления книги");
        System.out.println("5 - для удаления книги");
        System.out.println("6 - для поиска книги");
        System.out.println("7 - для просмотра ID номеров книг"); // добавил просмотр Id номеров
        System.out.println("8 - для поиска по ID номеру книги"); // добавил поиск по Id номеру
        System.out.println("0 - для выхода");
    }

    public int setScanner() {
        while (true) {
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                scanner.nextLine(); // После использования сканера очистил перевод строки
                if (x >= 0 && x < 9) {
                    int choose = x;
                    return choose;
                } else {
                    System.out.println("Введите число 1-8");
                }
            } else {
                String s = scanner.nextLine();
                System.out.println("Введите число");
            }
        }
    }

    public int setId() {
        while (true) {
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                scanner.nextLine();
                return x;

            } else {
                String s = scanner.nextLine();
                System.out.println("Введите число");
            }
        }
    }

    public String setAtrib() {
        String str = scanner.nextLine();
        return str;
    }

    //Удаление книг по номеру
    public int removeBookOfListNumber() {
        System.out.println("Введите номер книги для удаления");
        while (true) {
            if (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                if (x >= 1 && x < libraryManager.getLibrary().size() + 1) {
                    int number = x - 1;
                    return number;
                } else {
                    System.out.println("Введите число 1-" + libraryManager.getLibrary().size());
                }
            } else {
                String s = scanner.nextLine();
                System.out.println("Введите число");
            }
        }
    }

    public void writeBooks() {
        System.out.println("Введите Ф.И.О. писателя");
        String fio = setAtrib();
        System.out.println("Введите произведение");
        String title = setAtrib();
        libraryManager.addBook(new Book(fio, title));
        System.out.println("Книга добавлена");
    }

    public void finishMessage() {
        System.out.println("Для выхода - 0");
    }

    public Book searchBook(String atribut) {
        String s = atribut;
        for (int i = 0; i < libraryManager.getLibrary().size(); i++) {
            Book book = libraryManager.getLibrary().get(i);
            if (s.toLowerCase().equals(book.getTitle().toLowerCase())) {
                System.out.println("Такая книга найдена");
                Book searh = book;
                return searh;
            }
        }
        return null;
    }

    public void chooseMenu() {
        boolean finish = true;
        while (finish) {
            switch (setScanner()) {
                case 0:
                    System.out.println("выход");
                    finish = false;
                    break;
                case 1:
                    System.out.println("Колличество книг в библиотеке " + libraryManager.getCountBooks());
                    finishMessage();
                    break;
                case 2:
                    if (libraryManager.getCountBooks() == 0) {
                        System.out.println("В библиотеке нет книг");
                    }
                    libraryManager.showAllLibrary();
                    finishMessage();
                    break;
                case 3:
                    libraryManager.removeAllBook();
                    System.out.println("Вся библиотека удалена");
                    finishMessage();
                    break;
                case 4:
                    writeBooks();
                    finishMessage();
                    break;
                case 5:
                    libraryManager.removeOfListNumber(removeBookOfListNumber());
                    System.out.println("Книга удалена");
                    finishMessage();
                    break;
                case 6:
                    System.out.println("Введите название книги");
                    Book search = searchBook(setAtrib());
                    if (search != null) {
                        System.out.println("Id номер " + search.getId() + ": " + search.getAuthor() + ": " + search.getTitle());
                    } else {
                        System.out.println("Нет такой книги в библиотеке");
                    }
                    finishMessage();
                    break;
                case 7:
                    libraryManager.showAllIdBooks();
                    finishMessage();
                    break;
                case 8:
                    System.out.println("Введите Id номер книги");
                    Book book = libraryManager.searchOfId(setId());
                    if (book != null) {
                        System.out.println("Книга с таким Id номером найдена");
                        System.out.println("Id номер " + book.getId() + ": " + book.getAuthor() + ": " + book.getTitle());
                    } else {
                        System.out.println("Книги с таким Id номером в библиотеке нет");
                        finishMessage();
                        break;
                    }
            }
        }
    }
}
