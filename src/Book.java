package src;

import java.awt.*;
import java.util.Objects;
import javax.swing.*;

public class Book {

    private String title;
    private String author;
    private String pages;
    private String desc;
    private String cover;

    public Book(String title, String author, String pages, String desc, String cover) {
        this.title = title;
        this.author = author;
        this.pages  = pages;
        this.desc = desc;
        this.cover = cover;
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
        return this.cover;
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
        viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewFrame.setSize(800,500);
        viewFrame.setResizable(false);
        viewFrame.setLocationRelativeTo(null);
        viewFrame.setTitle(this.getTitle());

        title = new JLabel( this.getTitle());
        title.setFont(new Font("Sans-Serif", Font.BOLD,20));

        author = new JLabel("by: " + this.getAuthor());
        author.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        author.setForeground(Color.RED);

        pages = new JLabel("Pages: " + this.getPages());
        pages.setFont(new Font("Sans-Serif", Font.PLAIN, 15));

        desc = new JTextArea();

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1, 0, 3));

        infoPanel.add(title);

        infoPanel.add(author);

        infoPanel.add(pages);


        bookImage = new ImageIcon(Objects.requireNonNull(Book.class.getResource(this.getImage())));
        Image image = bookImage.getImage().getScaledInstance(
            300,
            viewFrame.getHeight() - 100,
            Image.SCALE_SMOOTH);
        bookImage =  new ImageIcon(image);

        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel(bookImage);

        imagePanel.add(imageLabel);

        JPanel descPanel = new JPanel();
        desc= new JTextArea(this.getDesc());
        desc.setLineWrap(true);
        desc.setColumns(10);
        desc.setBackground(rightPanel.getBackground());
        desc.setCaretColor(rightPanel.getBackground());
        descPanel.setLayout(new BorderLayout());;
        descPanel.add(new JScrollPane(desc),BorderLayout.CENTER);
        descPanel.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
        descPanel.setSize(imagePanel.getWidth(),0);

//        add = new JButton("add");
//        add.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
//        add.setFocusable(false);
//        add.addActionListener(actionEvent -> {
//
//        });

        ok = new JButton("ok");
        ok.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
        ok.setFocusable(false);
        ok.addActionListener(actionEvent -> {
            viewFrame.dispose();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1,0,0));
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