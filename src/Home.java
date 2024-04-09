package src;

import javax.swing.*;
import java.awt.*;
import java.nio.file.DirectoryNotEmptyException;
import java.util.Objects;

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
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setPreferredSize(new Dimension(width - sideBardWidth, height));
        mainContainer.setBackground(new Color(0xfafafa));



        JPanel searchContainer = new JPanel();
        searchContainer.setBackground(null);
        searchContainer.setOpaque(true);
        searchContainer.setPreferredSize(new Dimension(width - sideBardWidth, 150));
        searchContainer.setLayout(null);

        JPanel searchBar = new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 0));
        searchBar.setBackground(null);
        searchBar.setOpaque(true);
        searchBar.setBounds(0, 40, width - sideBardWidth, 60);

        ImageIcon searchIcon = new ImageIcon(Objects.requireNonNull(Home.class.getResource("../images/search.png")));
        Image image = searchIcon.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        searchIcon = new ImageIcon(image);

        JLabel searchIconContainer = new JLabel();
        searchIconContainer.setPreferredSize(new Dimension(22, 60));
        searchIconContainer.setVerticalAlignment(JLabel.CENTER);
        searchIconContainer.setIcon(searchIcon);


        JTextField titleInput = new JTextField();
        titleInput.setPreferredSize(new Dimension(500, 30));
        titleInput.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        titleInput.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
        titleInput.setText("Search book...");


        JButton searchBtn = new JButton("search");
        searchBtn.setPreferredSize(new Dimension(100, 30));
        searchBtn.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        searchBtn.setOpaque(true);
        searchBtn.setFocusable(false);

        searchBar.add(searchIconContainer);
        searchBar.add(titleInput);
        searchBar.add(searchBtn);




        searchContainer.add(searchBar);


        JPanel BooksList = new JPanel();
        BooksList.setPreferredSize(new Dimension(width - sideBardWidth, height - 200));
        BooksList.setBackground(Color.yellow);
        BooksList.setOpaque(true);


        mainContainer.add(searchContainer, BorderLayout.PAGE_START);
        mainContainer.add(BooksList, BorderLayout.CENTER);


        this.add(mainContainer, BorderLayout.CENTER);
        this.add(sidebar, BorderLayout.LINE_START);
        this.setVisible(true);

    }

}
