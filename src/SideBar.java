package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class SideBar extends JPanel {
    public SideBar(int width, int height, boolean isAdmin, Home parent, ArrayList<Book> books) {
        int x = 30;
        int y = 40;


//        this.setBackground(new Color(0xEfEfEf));
        this.setBackground(new Color(0xdee2e6));

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);

        ImageIcon headerImg = new ImageIcon(Objects.requireNonNull(SideBar.class.getResource("../images/sidebarHeader.png")));
        Image image =  headerImg.getImage(); // transform it
        Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        headerImg = new ImageIcon(newimg);  // transform it back


        JLabel header = new JLabel("ReadIt");
        header.setIcon(headerImg);
        header.setFont(new Font(Font.SERIF, Font.PLAIN, 42));
        header.setIconTextGap(20);
        header.setBounds(x , y, width, 50);
        y += y * 2 + y/2;

        header.setHorizontalTextPosition(JLabel.LEFT);
        header.setVerticalTextPosition(JLabel.CENTER);
        header.setHorizontalAlignment(JLabel.LEFT);
        header.setVerticalTextPosition(JLabel.CENTER);


        ImageIcon verticalBooks = new ImageIcon(Objects.requireNonNull(SideBar.class.getResource("../images/verticalBooks.png")));
        image =  verticalBooks.getImage(); // transform it
        newimg = image.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        verticalBooks = new ImageIcon(newimg);  // transform it back


        JLabel library = new JLabel("Library");
        library.setIcon(verticalBooks);
        library.setIconTextGap(15);
        library.setVerticalAlignment(JLabel.CENTER);
        library.setHorizontalAlignment(JLabel.LEFT);
        library.setHorizontalTextPosition(JLabel.RIGHT);
        library.setVerticalTextPosition(JLabel.CENTER);
        library.setFont(new Font("Cantarell", Font.PLAIN, 22));
        library.setPreferredSize(new Dimension(width, 30));

        JPanel libraryContainer = new JPanel();
        libraryContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 35, 7));
        libraryContainer.setBounds(0, y, width, 50);
        libraryContainer.setBackground(Color.white);
        libraryContainer.setOpaque(true);

        libraryContainer.add(library);

        y += 50;

        JPanel btnContainer;
        if (isAdmin) {
            btnContainer = new JPanel(new GridLayout(2, 1, 0, 0));
            btnContainer.setBounds(0, y, width, 100);

            JButton addBookBtn = new JButton("Add Book");
            addBookBtn.addActionListener(actionEvent -> {
                new AdminAddBook(books, parent);
            });
            btnContainer.add(addBookBtn);

        } else {
            btnContainer = new JPanel(new GridLayout(1, 1, 0, 0));
            btnContainer.setBounds(0, y, width, 50);
        }
        btnContainer.setOpaque(true);


        JButton signOutBtn = new JButton("Sign Out");
        btnContainer.add(signOutBtn);
        signOutBtn.addActionListener(actionEvent -> {
            parent.dispose();
            new RoleLogin();
        });

        for (Component btn :  btnContainer.getComponents()) {
            JButton casted = (JButton) btn;
            casted.setFocusable(false);
            casted.setHorizontalAlignment(JButton.LEFT);
            casted.setBorder(null);
            casted.setBorder(BorderFactory.createEmptyBorder(0, x + 2, 0, 0));
            casted.setBackground(this.getBackground());
            casted.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
        }



        this.add(header);
        this.add(libraryContainer);
        this.add(btnContainer);
    }
}
