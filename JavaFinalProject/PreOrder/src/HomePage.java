
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame implements ActionListener{

	JLabel shoesicon,title1,title2;
	JButton enter,exit;
	
	public HomePage() {
		BufferedImage icon = null,shoes = null,enterr = null,exitt = null;
		try {
			icon = ImageIO.read(new File("img/icon.jpg"));
		    this.setIconImage(icon);
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocation(350, 100);
			this.getContentPane().setBackground(Color.GRAY);
			this.setLayout(null);
			
			title1 = new JLabel("Pre-Order");
			title1.setBounds(290,50,400,50);
			title1.setFont(new Font("Mali-Bold",Font.BOLD,40));
			title1.setForeground(Color.BLACK);
			title1.setBorder(new EmptyBorder(0,10,0,0));
			
			title2 = new JLabel("Sneaker");
			title2.setBounds(300,100,400,50);
			title2.setFont(new Font("Mali-Bold",Font.BOLD,40));
			title2.setForeground(Color.BLACK);
			title2.setBorder(new EmptyBorder(0,10,0,0));
			
			shoes = ImageIO.read(new File("img/222222.png"));
			enterr = ImageIO.read(new File("img/enter.png"));
			exitt = ImageIO.read(new File("img/logout.png"));
			
			shoesicon = new JLabel("");
			shoesicon.setIcon(new ImageIcon(shoes.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
			shoesicon.setBounds(200,60,400,400);
			
			enter = new JButton("Enter");
			enter.setIcon(new ImageIcon(enterr.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
			enter.setBounds(200,450,90,40);
			enter.addActionListener(this);
			
			exit = new JButton("Exit");
			exit.setIcon(new ImageIcon(exitt.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
			exit.setBounds(500,450,90,40);
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
			System.exit(0);
		}
		if (e.getActionCommand().equals("Enter")) {
			this.dispose();
			new Show().setVisible(true);
		}
	}
}
