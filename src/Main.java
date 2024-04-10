package src;

public class Main {

    public static void main(String[] args) {
        Book book = new Book("Subtle art of not giving a F*ck", "Mark Manson", "300", "What are the values that you should priority. Mark Manson also has a youtube channel that will help you be a better person each day of the month", "images/bookImages/subtleArtOfNotGivingAFuck.jpg");
        
        book.viewBook(book);
        new Home(true);
    }
}
