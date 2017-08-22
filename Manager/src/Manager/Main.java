package Manager;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Helper helper = new Helper(manager); // Создаю экземпляр класса Helper и передаю переменную ссылку manager для использования в классе Helper
        helper.start();
        // использую подход chein для создания экземпляров класса Book
        manager.addBook(new Book("Толстой Л.Н.", "Декабристы"))
                .addBook(new Book("Толстой Л.Н.", "Война и мир"))
                .addBook(new Book("Толстой Л.Н.", "Альберт"))
                .addBook(new Book("Толстой Л.Н.", "Воскресение"))
                .addBook(new Book("Толстой Л.Н.", "Анна Каренина"));

        helper.chooseMenu();
    }
}
