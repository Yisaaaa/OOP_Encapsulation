package src;

import java.awt.*;
import javax.swing.*;

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

    public String getImage(){
        return this.image;
    }


    public void viewBook(Book book){
        JFrame viewFrame;
        JLabel title;
        JLabel author;
        JLabel pages;
        JTextArea desc;
        ImageIcon bookImage;
        JButton ok;
        JButton add;
    
        viewFrame = new JFrame();
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(800,500);
        viewFrame.setResizable(false);

        title = new JLabel( book.getTitle());
        title.setFont(new Font("Sans-Serif", Font.BOLD,20));

        author = new JLabel("by: " + book.getAuthor());
        author.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        author.setForeground(Color.RED);

        pages = new JLabel("Pages: " + book.getPages());
        pages.setFont(new Font("Sans-Serif", Font.PLAIN, 15));

        desc = new JTextArea();

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1, 0, 3));

        infoPanel.add(title);

        infoPanel.add(author);

        infoPanel.add(pages);


        bookImage = new ImageIcon(book.getImage());
        

        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel(bookImage);

        imagePanel.add(imageLabel);

        JPanel descPanel = new JPanel();
        desc= new JTextArea(book.getDesc());
        desc.setLineWrap(true);
        desc.setColumns(10);
        desc.setBackground(rightPanel.getBackground());
        desc.setCaretColor(rightPanel.getBackground());
        descPanel.setLayout(new BorderLayout());;
        descPanel.add(new JScrollPane(desc),BorderLayout.CENTER);
        descPanel.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
        descPanel.setSize(imagePanel.getWidth(),0);

        add = new JButton("add");
        add.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
        add.setFocusable(false);
        ok = new JButton("ok");
        ok.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
        ok.setFocusable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2,0,0));
        buttonPanel.add(add);
        buttonPanel.add(ok);

        rightPanel.add(infoPanel,BorderLayout.NORTH);
        rightPanel.add(descPanel,BorderLayout.CENTER);
        rightPanel.add(buttonPanel,BorderLayout.PAGE_END);

        //for the arrangement of the text
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(imagePanel,BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        viewFrame.add(mainPanel);
        viewFrame.setVisible(true);
    }
}