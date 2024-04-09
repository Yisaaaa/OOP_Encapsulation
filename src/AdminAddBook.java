package src;//import javax.swing.*;
//import java.awt.*;
//
//public class src.AdminAddBook extends JFrame {
//
//    public src.AdminAddBook() {
//
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setSize(500, 500);
//
//        JPanel form = new JPanel();
//        form.setLayout(new GridLayout(4, 1));
//
//        JPanel titleContainer = new JPanel();
//        titleContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));
//        titleContainer.setBackground(Color.blue);
//        titleContainer.setOpaque(true);
//        titleContainer.setSize(20, 20);
//
//        JLabel titleText = new JLabel("Title");
//        titleText.setFont(new Font("Consolas", Font.PLAIN, 22));
//
//        JTextField title = new JTextField();
//        title.setFont(new Font("Consolas", Font.PLAIN, 22));
//        title.setPreferredSize(new Dimension(300, 30));
//
//        titleContainer.add(titleText);
//        titleContainer.add(title);
//
//
//
//
////
//
//        JPanel authorContainer = new JPanel();
//        authorContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));
//        authorContainer.setBackground(Color.red);
//        authorContainer.setOpaque(true);
//
//        JLabel authorText = new JLabel("Author");
//        authorText.setFont(new Font("Consolas", Font.PLAIN, 22));
//
//        JTextField author = new JTextField();
//        author.setFont(new Font("Consolas", Font.PLAIN, 22));
//        author.setPreferredSize(new Dimension(300, 30));
//
//        authorContainer.add(authorText);
//        authorContainer.add(author);
//
////
//
//        JPanel pagesContainer = new JPanel();
//        pagesContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));
////        pagesContainer.setBackground(Color.yellow);
////        pagesContainer.setOpaque(true);
//
//
//        JLabel pagesText = new JLabel("Pages");
//        pagesText.setFont(new Font("Consolas", Font.PLAIN, 22));
//
//        JTextField pages = new JTextField();
//        pages.setFont(new Font("Consolas", Font.PLAIN, 22));
//        pages.setPreferredSize(new Dimension(300, 30));
//
//        pagesContainer.add(pagesText);
//        pagesContainer.add(pages);
//
////
//
//        JPanel descriptionContainer = new JPanel();
//        descriptionContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 10));
////        descriptionContainer.setBackground(Color.green);
////        descriptionContainer.setOpaque(true);
//
//        JLabel descriptionText = new JLabel("Description");
//        descriptionText.setFont(new Font("Consolas", Font.PLAIN, 22));
//
////        JTextField description = new JTextField();
//        JTextArea description = new JTextArea(3, 30);
//        description.setLineWrap(true);
//
//        description.setFont(new Font("Consolas", Font.PLAIN, 22));
//        description.setPreferredSize(new Dimension(300, 30));
//
//        descriptionContainer.add(descriptionText);
//        descriptionContainer.add(description);
//
////
//
//
//
//
//
//        titleContainer.setPreferredSize(new Dimension(300, 10));
//        authorContainer.setPreferredSize(new Dimension(300, 10));
//        pagesContainer.setPreferredSize(new Dimension(300, 10));
//        description.setPreferredSize(new Dimension(300, 10));
//
//
//
//
//
//        form.add(titleContainer);
//        form.add(authorContainer);
//        form.add(pagesContainer);
//        form.add(descriptionContainer);
//
//        this.add(form, BorderLayout.CENTER);
//
//        this.setVisible(true);
//
//
//
//    }
//
//}

import javax.swing.*;
import java.awt.*;

public class AdminAddBook extends JFrame {

    public AdminAddBook() {

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(500,600);
        this.setTitle("Add book");
        this.setLocationRelativeTo(null);

        JTextField title = new JTextField();
        JTextField author = new JTextField();

        title.setName("title");
        author.setName("author");

        JSpinner pages = new JSpinner(new SpinnerNumberModel(0, 0, 10000, 1));
        JComponent editor = pages.getEditor();
        JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        pages.setName("Pages");


        JTextArea description = new JTextArea(3, 20);
        description.setName("Description");
        description.setFont(new Font("Verdana", Font.PLAIN, 16));
        description.setLineWrap(true);

        int x = 100;
        int y = 60;
        int height = 40;
        int width = 300;
        int labelHeight = 16;


        for (JComponent component : new JComponent[]{title, author, pages}) {
            JLabel label = new JLabel(component.getName());
            label.setFont(new Font("Verdana", Font.PLAIN, 16));

            component.setBounds(x, y, width, height);
            component.setFont(new Font("Verdana", Font.PLAIN, 24));
            component.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));

            label.setBounds(x, y - (labelHeight + 5), 100, labelHeight);

            this.add(label);
            this.add(component);

            y += height + 50;
        }

        description.setBounds(x, y, width, 100);
        JLabel descLabel = new JLabel(description.getName());
        descLabel.setBounds(x, y - (labelHeight + 5), width, labelHeight);
        descLabel.setFont(new Font("Verdana", Font.PLAIN, 16));

        y += 100 + 50;


        JPanel btns = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton cancelBtn = new JButton("Cancel");

        for (JButton btn : new JButton[]{addBtn, cancelBtn}) {
            btns.add(btn);
        }

        addBtn.addActionListener(actionEvent -> {
            String bookTitle = title.getText();
            String bookAuthor = author.getText();
            String bookPages = String.valueOf(pages.getValue());
            String bookDesc = description.getText();

            System.out.println(bookTitle);
            System.out.println(bookAuthor);
            System.out.println(bookPages);
            System.out.println(bookDesc);


            this.dispose();
            new AdminHome();

        });

        cancelBtn.addActionListener(actionEvent -> {
            this.dispose();
            new AdminHome();
        });

        btns.setBounds(x, y, width, height);
        btns.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.add(btns);

        this.add(descLabel);
        this.add(description);

        this.setVisible(true);
    }

}