package src;

import javax.swing.*;
import java.awt.*;
import java.nio.file.DirectoryNotEmptyException;

public class Home extends JFrame {

    public Home(boolean isAdmin) {
//        Frame -----------------------------------
        int height = 900;
        int width = 1300;
        int sideBardWidth = 250;


        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


//        SIDEBAR -----------------------------------
//
//        JPanel sidebar = new JPanel();
//        sidebar.setBackground(new Color(0xdee2e6));
//        sidebar.setOpaque(true);
//        sidebar.setPreferredSize(new Dimension(sideBardWidth, height));
//
//        JLabel sideBard

        JPanel sidebar = new SideBar(sideBardWidth, height, isAdmin, this);





//        Main container -----------------------------------



        JPanel mainContainer = new JPanel();
        mainContainer.setPreferredSize(new Dimension(width - sideBardWidth, height));
        mainContainer.setBackground(new Color(0xfafafa));


        this.add(mainContainer, BorderLayout.CENTER);
        this.add(sidebar, BorderLayout.LINE_START);
        this.setVisible(true);

    }

}
