package src;
import java.awt.Image;

public class Book {

    private String title;
    private String author;
    private String pages;
    private String desc;
    private String image;

    public Book(String title, String author, String pages, String desc, String image) {
        this.title = title;
        this.author = author;
        this.pages  = pages;
        this.desc = desc;
        this.image = image;
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

    public String getImage(){
        return this.image;
    }


}
