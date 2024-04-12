package src;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class Home extends JFrame implements ActionListener {

    JButton prevBtn;
    JButton nextBtn;
    JButton searchBtn;
    JTextField titleInput;
    int height = 900;
    int width = 1300;
    int sideBardWidth = 250;
    JPanel bookList;
    JPanel mainContainer;

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Book> booksToDisplay = new ArrayList<>();
    int currentPage = 0;

    public Home(boolean isAdmin) {
//        Initializing books
//        for (int i = 0; i < 10; i++) {
//            books.add(new Book("Dune",
//                "Frank Herbert",
//                "230",
//                "Welcome to the world of dune",
//                "/images/covers/the-subtle-art-of-not-giving-a-fuck.jpg"
//                ));
//        }
//
        Gson gson = new Gson();
        try  {
            String stringJson = readJsonStringFromFile("books.json");
            java.lang.reflect.Type list = new TypeToken<ArrayList<Book>>(){}.getType();
            books = gson.fromJson(stringJson, list);

            System.out.println(books.get(0).getImage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Initial books to display
        int start = currentPage * 8;
        int end = Math.min(start + 8, books.size());
        currentPage++;

        for (int i = 0; i < end; i++) {
            booksToDisplay.add(books.get(i));
        }


//        Frame -----------------------------------


        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library");


//        SIDEBAR -----------------------------------
//
//        JPanel sidebar = new JPanel();
//        sidebar.setBackground(new Color(0xdee2e6));
//        sidebar.setOpaque(true);
//        sidebar.setPreferredSize(new Dimension(sideBardWidth, height));
//
//        JLabel sideBard

        JPanel sidebar = new SideBar(sideBardWidth, height, isAdmin, this, books);





//        Main container -----------------------------------



        mainContainer = new JPanel();
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


        titleInput = new JTextField();
        titleInput.setPreferredSize(new Dimension(500, 30));
        titleInput.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        titleInput.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
        titleInput.setText("Search book...");


        searchBtn = new JButton("search");
        searchBtn.addActionListener(this);
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

        prevBtn = new JButton("<");
        prevBtn.addActionListener(this);

        nextBtn = new JButton(">");
        nextBtn.addActionListener(this);


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


        bookList = new BookList(
            width - sideBardWidth,
            height - 200,
            booksToDisplay
        );

        mainContainer.add(searchContainer, BorderLayout.PAGE_START);
        mainContainer.add(bookList, BorderLayout.CENTER);


        this.add(mainContainer, BorderLayout.CENTER);
        this.add(sidebar, BorderLayout.LINE_START);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == nextBtn) {

            int startIndex = currentPage * 8;

            if (startIndex > books.size()) {
                return;
            }

            int endIndex = Math.min(startIndex + 8, books.size());

            System.out.println("\nnext");
            System.out.println("currentpage " + currentPage);
            System.out.println("start " + startIndex);
            System.out.println("end " + endIndex);

            booksToDisplay.clear();


            for (int i = startIndex; i < endIndex; i++) {
                booksToDisplay.add(books.get(i));
            }

            currentPage++;

            mainContainer.remove(bookList);

            bookList = new BookList(
                width - sideBardWidth,
                height - 200,
                booksToDisplay);

            mainContainer.add(bookList);
            mainContainer.revalidate();
            mainContainer.repaint();

        } else if (actionEvent.getSource() == prevBtn) {
            if (currentPage == 0) {
                return;
            }

            if (currentPage - 2 < 0) {
                currentPage = 0;
            } else {
                currentPage -= 2;
            }

            System.out.println("\nprev");
            System.out.println("currentpage " + currentPage);

            int startIndex = currentPage * 8;

            if (startIndex > books.size()) {
                return;
            }

            int endIndex = Math.min(startIndex + 8, books.size());

            System.out.println("start " + startIndex);
            System.out.println("end " + endIndex);

            booksToDisplay.clear();


            for (int i = startIndex; i < endIndex; i++) {
                booksToDisplay.add(books.get(i));
            }

            System.out.println(booksToDisplay.size());

            mainContainer.remove(bookList);


            bookList = new BookList(
                width - sideBardWidth,
                height - 200,
                booksToDisplay);

            mainContainer.add(bookList);
            mainContainer.revalidate();
            mainContainer.repaint();

            if (currentPage == 0) {
                currentPage = 1;
            }
        } else if (actionEvent.getSource() == searchBtn) {
            String title = titleInput.getText();
            System.out.println("saerch");
            for (Book book : books) {
                if (Objects.equals(book.getTitle().toLowerCase(), title.toLowerCase())) {
                    book.viewBook(book);
                } else {
                    new JOptionPane("No book found");
                }
            }
        }
    }

    public static String readJsonStringFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader(filePath)) {
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }
}
