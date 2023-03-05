import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Instance.CreateButton;
import Instance.CreateLabel;
import Instance.InsertImage;

public class Register extends JFrame implements ActionListener {

	JTextField firstname, lastname, user;
	JPasswordField pass, Cpass;
	JCheckBox showPassword;

	public Register() {
		try {
			this.setIconImage(ImageIO.read(Register.class.getResource("icon.jpg")));
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocationRelativeTo(null); /* Set Frame in the middle */
			this.setLayout(null);

			CreateLabel cl = new CreateLabel();
			CreateButton cb = new CreateButton();
			InsertImage ii = new InsertImage();

			JLabel Title = cl.CreateLabel("Register", 300, 30, 400, 50, 40);

			JLabel Fname = cl.CreateLabel("FirstName", 150, 150, 200, 40, 18);
			firstname = new JTextField();
			firstname.setBounds(350, 150, 200, 40);

			JLabel Lname = cl.CreateLabel("LastName", 150, 200, 200, 40, 18);
			lastname = new JTextField();
			lastname.setBounds(350, 200, 200, 40);

			JLabel Username = cl.CreateLabel("Username", 150, 250, 200, 40, 18);
			user = new JTextField();
			user.setBounds(350, 250, 200, 40);

			JLabel Password = cl.CreateLabel("Password", 150, 300, 200, 40, 18);
			pass = new JPasswordField();
			pass.setBounds(350, 300, 200, 40);

			JLabel CPassword = cl.CreateLabel("Confirm-Password", 120, 350, 200, 40, 18);
			Cpass = new JPasswordField();
			Cpass.setBounds(350, 350, 200, 40);

			JButton back = cb.CreateButton("Back", 30, 500, 90, 40, 12);
			back.addActionListener(this);

			JButton reg = cb.CreateButton("Sign-Up", 670, 500, 90, 40, 12);
			reg.addActionListener(this);

			showPassword = new JCheckBox("Show Password");
			showPassword.setBounds(350, 390, 150, 50);
			showPassword.addActionListener(this);

			this.add(Title);
			this.add(Fname);
			this.add(firstname);
			this.add(Lname);
			this.add(lastname);
			this.add(Username);
			this.add(user);
			this.add(Password);
			this.add(pass);
			this.add(CPassword);
			this.add(Cpass);
			this.add(back);
			this.add(reg);

			this.add(showPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String fname = firstname.getText();
		String lname = lastname.getText();
		String username = user.getText();
		String Ppass = new String(pass.getPassword());
		String CCpass = new String(Cpass.getPassword());

		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				pass.setEchoChar((char) 0);
				Cpass.setEchoChar((char) 0);
			} else {
				pass.setEchoChar('*');
				Cpass.setEchoChar('*');
			}
		}

		if (e.getActionCommand().equals("Back")) {
			this.dispose();
			new Login().setVisible(true);
		}

		if (e.getActionCommand().equals("Sign-Up")) {
			if (fname.length() == 0 || lname.length() == 0 || username.length() == 0 || Ppass.length() == 0
					|| CCpass.length() == 0) {
				JOptionPane.showMessageDialog(null, "Please fill all blank !!!", "ERROR !!", JOptionPane.ERROR_MESSAGE);
			} else {
				if (Arrays.equals(pass.getPassword(), Cpass.getPassword())) {
					try {
						/* If don't have file --> Create new file automatic */
						/* Using [Write File with PrintWriter] */
						/* if(boolean == true) --> insert new data in file after the previous data. */
						/* if(boolean == false) --> re-write file. */
						PrintWriter write = new PrintWriter(new FileWriter("User-Pass.txt", true));
						String pwdText = new String(pass.getPassword());
						write.println(username + "\t" + pwdText);
						write.close();
						this.dispose();
						new Login().setVisible(true);
					} catch (Exception t) {
						t.printStackTrace();
					}
				} else {
					Cpass.setText("");
					JOptionPane.showMessageDialog(null, "Pass and Confirm-Pass\nMust be the same", "ERROR !!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
