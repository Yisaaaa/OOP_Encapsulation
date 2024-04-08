import javax.swing.*;
import java.awt.*;

public class AdminHome  extends JFrame {

    public AdminHome() {
//        this.setSize(650, 650);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Home");
        this.setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 22));

        JLabel welcome = new JLabel("Hello Admin");
        welcome.setFont(new Font("Verdana", Font.PLAIN, 28));
        welcome.setHorizontalAlignment(JLabel.CENTER);

        JButton searchBtn = new JButton();
        searchBtn.setText("Search book");
        searchBtn.setFocusable(false);
        searchBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        searchBtn.setPreferredSize(new Dimension(200, 50));

        JButton addBtn = new JButton();
        addBtn.setText("Add book");
        addBtn.setFocusable(false);
        addBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        addBtn.setPreferredSize(new Dimension(200, 50));


        addBtn.addActionListener(actionEvent -> {
            this.dispose();
            new AdminAddBook();
        });


        buttonPanel.add(searchBtn);
        buttonPanel.add(addBtn);


        this.add(welcome, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setVisible(true);
        this.pack();
    }

}
