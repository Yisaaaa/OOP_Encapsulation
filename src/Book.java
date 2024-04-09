package src;

public class Book {

    private String title;
    private String author;
    private String pages;
    private String desc;

    public Book(String title, String author, String pages, String desc) {
        this.title = title;
        this.author = author;
        this.pages  = pages;
        this.desc = desc;
    }


    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPages() {
        return this.pages;
    }

    public String getDesc() {
        return this.desc;
    }


}
