package src;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SideBar extends JPanel {
    public SideBar(int width, int height) {
        this.setBackground(new Color(0xdee2e6));
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);

        ImageIcon headerImg = new ImageIcon(Objects.requireNonNull(SideBar.class.getResource("../images/sidebarHeader.png")));
        Image image =  headerImg.getImage(); // transform it
        Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        headerImg = new ImageIcon(newimg);  // transform it back


        JLabel header = new JLabel("Readit");
        header.setIcon(headerImg);
        header.setFont(new Font("Cantarell", Font.PLAIN, 36));
        header.setIconTextGap(20);
        header.setBounds(30 , 40, width, 50);

        header.setHorizontalTextPosition(JLabel.LEFT);
        header.setVerticalTextPosition(JLabel.CENTER);
        header.setHorizontalAlignment(JLabel.LEFT);
        header.setVerticalTextPosition(JLabel.CENTER);



        this.add(header);

    }
}
