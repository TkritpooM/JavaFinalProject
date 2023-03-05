
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Instance.*;

public class Login extends JFrame implements ActionListener {

	JTextField user;
	JPasswordField pass;
	JButton sign, regis_btn;
	JCheckBox showPassword;
	public String[] CheckuserP = { "", "" }; /* Remember Pass in Storage */

	public Login() {
		try {
			this.setIconImage(ImageIO.read(Login.class.getResource("icon.jpg")));
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocationRelativeTo(null); /* Set Frame in the middle */
			this.setLayout(null);

			CreateLabel cl = new CreateLabel();
			CreateButton cb = new CreateButton();
			InsertImage ii = new InsertImage();

			JLabel Title = cl.CreateLabel("Sneaker Pre-Order", 240, 30, 400, 50, 40);

			JLabel userimage = ii.InsertImage(ImageIO.read(Login.class.getResource("user.png")), 170, 160, 20, 20);
			JLabel Username = cl.CreateLabel("Username", 200, 150, 200, 40, 18);
			user = new JTextField();
			user.setBounds(300, 150, 200, 40);

			JLabel passimage = ii.InsertImage(ImageIO.read(Login.class.getResource("pass.png")), 170, 210, 20, 20);
			JLabel Password = cl.CreateLabel("Password", 200, 200, 200, 40, 18);
			pass = new JPasswordField();
			pass.setBounds(300, 200, 200, 40);

			showPassword = new JCheckBox("Show Password");
			showPassword.setBounds(300, 240, 300, 40);
			showPassword.addActionListener(this);

			sign = cb.CreateButton("Sign-in", 300, 290, 90, 40, 15);
			sign.addActionListener(this);

			regis_btn = cb.CreateButton("Register", 400, 290, 90, 40, 12);
			regis_btn.addActionListener(this);

			this.add(Title);
			// -----------------------//
			this.add(userimage);
			this.add(Username);
			this.add(user);
			// -----------------------//
			this.add(passimage);
			this.add(Password);
			this.add(pass);
			// -----------------------//
			this.add(showPassword);
			this.add(sign);
			this.add(regis_btn);
		} catch (Exception e) {
			/* use to detected error from image search --> print in console */
			/*
			 * print in the console class name and line number where the exception occurred
			 */
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String userText = new String(user.getText());
		String pwdText = new String(pass.getPassword());
		boolean checkUP = false;

		if (e.getSource() == sign) {
			if (userText.length() == 0 || pwdText.length() == 0) {
				JOptionPane.showMessageDialog(null, "Please fill all blank !!!", "ERROR !!", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					BufferedReader read = new BufferedReader(new FileReader("User-Pass.txt"));
					String temp = "";
					while ((temp = read.readLine()) != null) {
						String userpass[] = temp.split("\t");
						CheckuserP[0] = userpass[0];
						CheckuserP[1] = userpass[1];
						/* Check user&pass That are same or not */
						if (userText.equals(CheckuserP[0]) && pwdText.equals(CheckuserP[1])) {
							checkUP = true;
							this.dispose();
							new Show().setVisible(true);
							break;
						}
					}
					read.close();
					if (checkUP == false) {
						JOptionPane.showMessageDialog(null, "Username or Password is incorrect", "ERROR !!",
								JOptionPane.QUESTION_MESSAGE);
					}
				} catch (Exception c) {
					c.printStackTrace();
				}
			}
		}

		if (e.getActionCommand().equals("Register")) {
			this.dispose();
			new Register().setVisible(true);
		}

		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				pass.setEchoChar((char) 0);
			} else {
				pass.setEchoChar('*');
			}
		}
	}

}
