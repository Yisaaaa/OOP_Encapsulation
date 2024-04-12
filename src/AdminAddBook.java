package src;//import javax.swing.*;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AdminAddBook extends JFrame {

    Gson gson = new Gson();

    public AdminAddBook(ArrayList<Book> books, JFrame home) {

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
            component.setFont(new Font("Verdana", Font.PLAIN, 18));
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

            books.add(new Book(
                bookTitle,
                bookAuthor,
                bookPages,
                bookDesc,
                "/images/covers/no-cover.png"
            ));

            try (PrintWriter writer = new PrintWriter("books.json")) {
                String jsonString = gson.toJson(books);
                writer.println(jsonString);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            this.dispose();

        });

        cancelBtn.addActionListener(actionEvent -> {
            this.dispose();
        });

        btns.setBounds(x, y, width, height);
        btns.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.add(btns);

        this.add(descLabel);
        this.add(description);

        this.setVisible(true);
    }

}