package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BookContainer extends JPanel implements MouseListener {

    Book book;
    public BookContainer(int width, int height, Book book) {
        addMouseListener(this);
        this.book = book;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension((width - 5 * 4) / 4, (height - 5 * 2) / 2));
        this.setBackground(null);
        this.setOpaque(true);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("clicked");
        book.viewBook(book);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
