package src;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SideBar extends JPanel {
    public SideBar(int width, int height, boolean isAdmin) {
        int x = 30;
        int y = 40;


        this.setBackground(new Color(0xEfEfEf));
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





        this.add(header);
        this.add(libraryContainer);

    }
}
