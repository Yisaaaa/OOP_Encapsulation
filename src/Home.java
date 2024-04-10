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


// Search Bar --------------------------

        JPanel searchContainer = new JPanel();
        searchContainer.setBackground(null);
        searchContainer.setOpaque(true);
        searchContainer.setPreferredSize(new Dimension(width - sideBardWidth, 140));
        searchContainer.setLayout(null);

        JPanel searchBar = new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 0));
        searchBar.setBackground(null);
        searchBar.setOpaque(true);
        searchBar.setBounds(100, 40, width - sideBardWidth, 60);

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

//        Page Buttons
        JPanel pageBtnContainer = new JPanel(new FlowLayout(FlowLayout.TRAILING, 0, 0));
        pageBtnContainer.setBounds(0, 100, width - sideBardWidth, 40);
        pageBtnContainer.setBackground(null);
        pageBtnContainer.setOpaque(true);
        pageBtnContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        JButton prevBtn = new JButton("<");
        JButton nextBtn = new JButton(">");


        pageBtnContainer.add(prevBtn);
        pageBtnContainer.add(nextBtn);

        for (Component btn : pageBtnContainer.getComponents()) {
            JButton casted = (JButton) btn;
            casted.setVerticalAlignment(JButton.CENTER);
            casted.setVerticalTextPosition(JButton.CENTER);
            casted.setPreferredSize(new Dimension(50, 40));
            casted.setFont(new Font("DejaVu Sans", Font.BOLD, 19));
            casted.setFocusable(false);
            casted.setBackground(null);
            casted.setBorder(null);

        }

        searchContainer.add(searchBar);
        searchContainer.add(pageBtnContainer);

//      BookList -------------------------------------


        JPanel BookList = new JPanel();
        BookList.setPreferredSize(new Dimension(width - sideBardWidth, height - 200));
        BookList.setBackground(Color.yellow);
        BookList.setOpaque(true);
        BookList.setLayout(new GridLayout(2, 4));


        mainContainer.add(searchContainer, BorderLayout.PAGE_START);
        mainContainer.add(BookList, BorderLayout.CENTER);


        this.add(mainContainer, BorderLayout.CENTER);
        this.add(sidebar, BorderLayout.LINE_START);
        this.setVisible(true);

    }

}
