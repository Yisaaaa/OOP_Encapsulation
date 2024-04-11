package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RoleLogin implements ActionListener {
	
	JFrame roleFrame;
	JLabel welcomeLabel;
	JPanel loginPanel;
	JButton admin;
	JButton user;
	ImageIcon background;
	
	public static String pass() {
		return "password";
	}
	
	public RoleLogin(){
		roleFrame = new JFrame();
		roleFrame.setTitle("Welcome to Library");
		
		loginPanel = new JPanel();
		loginPanel.setLayout(new GridLayout(2,1,0,20));
		loginPanel.setBounds(45, 100, 400, 250);

		welcomeLabel = new JLabel("Welcome to Library");
		welcomeLabel.setFont(new Font("Serif", Font.BOLD, 50));
		welcomeLabel.setBounds(0,5,500,50);

		admin = new JButton("Admin");
		admin.setBackground(Color.orange);
		admin.setFont(new Font("Serif", Font.BOLD, 30));
		admin.addActionListener(this);
		
		user = new JButton("User");
		user.setBackground(Color.orange);
		user.setFont(new Font("Serif", Font.BOLD, 30));
		user.addActionListener(this);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.white);
		layeredPane.setBounds(0,0,500,500);
		
		roleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		roleFrame.setLayout(new BorderLayout());
		roleFrame.setSize(500, 500);
		roleFrame.setResizable(false);
		roleFrame.setLocationRelativeTo(null);

		loginPanel.add(admin);
		loginPanel.add(user);
		layeredPane.add(welcomeLabel);
		layeredPane.add(loginPanel);
		roleFrame.add(layeredPane);
		roleFrame.setVisible(true);


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == admin) {
			JPasswordField passwordField = new JPasswordField();
			int option = JOptionPane.showConfirmDialog(roleFrame, passwordField, "Passcode:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (option == JOptionPane.OK_OPTION) {
				char[] enteredPass = passwordField.getPassword();
				String enteredPassString = new String(enteredPass);
				if (RoleLogin.pass().equals(enteredPassString)) {
					System.out.println("Entered!");

					roleFrame.dispose();
					new Home(true);
				} else {
					JOptionPane.showMessageDialog(admin, "Wrong password!");
				}
			}
		} else if (e.getSource() == user) {
			System.out.println("logged in as user");
			roleFrame.dispose();
			new Home(false);

		}
	}
}

