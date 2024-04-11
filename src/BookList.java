package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class BookList extends JPanel{

    public BookList(int width, int height, ArrayList<Book> books) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(null);
        this.setOpaque(true);
        this.setLayout(new GridLayout(2, 4, 5, 5));

        for (Book book : books) {
            JPanel bookContainer = new BookContainer((width - 5 * 4) / 4, (height - 5 * 2) / 2, book);

            System.out.println(book.getTitle());
            System.out.println(book.getImage());

            JLabel coverAndTitle = new JLabel();
            ImageIcon coverImg = new ImageIcon(Objects.requireNonNull(BookList.class.getResource(book.getImage())));

//          Resizing image
//            Image image = coverImg.getImage().getScaledInstance(
//                bookContainer.getWidth() - 200,
//                bookContainer.getHeight() - 300,
//                Image.SCALE_SMOOTH);
            Image image = coverImg.getImage().getScaledInstance(
                200,
                270,
                Image.SCALE_SMOOTH);
            coverImg =  new ImageIcon(image);

            coverAndTitle.setIcon(coverImg);
            coverAndTitle.setText(book.getTitle());
            coverAndTitle.setVerticalTextPosition(JLabel.BOTTOM);
            coverAndTitle.setHorizontalTextPosition(JLabel.CENTER);
            coverAndTitle.setHorizontalAlignment(JLabel.CENTER);
            coverAndTitle.setAlignmentX(CENTER_ALIGNMENT);
            coverAndTitle.setAlignmentY(CENTER_ALIGNMENT);
            coverAndTitle.setFont(new Font("DejaVu Sans", Font.BOLD, 18));

            JLabel author = new JLabel(book.getAuthor());
            author.setHorizontalAlignment(JLabel.CENTER);
            author.setAlignmentX(CENTER_ALIGNMENT);
            author.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
            author.setForeground(new Color(0x868e96));

            bookContainer.add(coverAndTitle);
            bookContainer.add(Box.createRigidArea(new Dimension((width - 5 * 4), 5)));
            bookContainer.add(author);
            this.add(bookContainer);
        }


    }
}
