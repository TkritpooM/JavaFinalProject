
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import Instance.CreateButton;
import Instance.CreateLabel;
import Instance.InsertImage;

public class HomePage extends JFrame implements ActionListener {

	JButton enter, exit;

	public HomePage() {
		try {
			this.setIconImage(ImageIO.read(HomePage.class.getResource("icon.jpg")));
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocationRelativeTo(null);
			this.setLayout(null);

			CreateLabel cl = new CreateLabel();
			CreateButton cb = new CreateButton();
			InsertImage ii = new InsertImage();
			
			JLabel title1 = cl.CreateLabel("Pre-Order", 290, 50, 400, 50, 40);
			JLabel title2 = cl.CreateLabel("Sneaker", 300, 100, 400, 50, 40);

			JLabel shoesicon = ii.InsertImage(ImageIO.read(HomePage.class.getResource("222222.png")), 200, 60, 400, 400);

			enter = cb.CreateButton(ImageIO.read(HomePage.class.getResource("enter.png")), "Enter", 200, 450, 90, 40, 15, 15);
			enter.addActionListener(this);

			exit = cb.CreateButton(ImageIO.read(HomePage.class.getResource("logout.png")), "Exit", 500, 450, 90, 40, 15, 15);
			exit.addActionListener(this);

			this.add(title1);
			this.add(title2);
			this.add(shoesicon);
			this.add(enter);
			this.add(exit);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")) {
			JOptionPane.showMessageDialog(null, "\tThank You for Visiting");
			System.exit(0); /* Close the program */
		}
		if (e.getActionCommand().equals("Enter")) {
			this.dispose();
			new Login().setVisible(true);
		}
	}
}
