package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BookList extends JPanel{

    public BookList(int width, int height, ArrayList<Book> books) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.yellow);
        this.setOpaque(true);
        this.setLayout(new GridLayout(2, 4));



    }
}
