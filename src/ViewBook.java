package src;

import java.awt.Color;

import javax.swing.*;

public class ViewBook {


    JFrame viewFrame;
    JPanel imagePanel;
    JPanel infoPanel;

    ViewBook(){
        viewFrame = new JFrame();
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(500, 500);
        viewFrame.setLayout(null);

        imagePanel = new JPanel();
        imagePanel.setBackground(Color.yellow);
        imagePanel.setBounds(0, 0, 200, 500);
        imagePanel.setOpaque(true);

        infoPanel = new JPanel();
        infoPanel.setBackground(Color.orange);
        infoPanel.setBounds(200, 0, 300, 500);
        infoPanel.setOpaque(true);

        viewFrame.add(imagePanel);
        viewFrame.add(infoPanel);
        viewFrame.setVisible(true);
    }
}
