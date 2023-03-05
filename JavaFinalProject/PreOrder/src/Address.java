import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Instance.CreateButton;
import Instance.CreateLabel;
import Instance.CreateRadioButton;
import Instance.InsertImage;

public class Address extends JFrame implements ActionListener {

	// ---Sent variable---//
	public String AllInfo; // ""
	public BufferedImage Spic;

	JTextField username, address, zip, email, phone;

	// ---Choice for choosing---//
	JComboBox country;
	String[] _country = { "", "Thailand", "Other..." };

	// ---Save---//
	JButton save;

	public Address(String Ainfo, BufferedImage Cshoes) {

		AllInfo = Ainfo; /* "Jordan 1 Chicago,5200B,Red,40" */
		Spic = Cshoes;

		try {
			this.setIconImage(ImageIO.read(Address.class.getResource("icon.jpg")));
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocationRelativeTo(null); /* Set Frame in the middle */
			this.setLayout(null);

			CreateLabel cl = new CreateLabel();
			CreateButton cb = new CreateButton();
			CreateRadioButton cr = new CreateRadioButton();
			InsertImage ii = new InsertImage();

			// ----------------Topic-----------------------------
			JLabel title = cl.CreateLabel("Address", 300, 20, 400, 40, 38);

			// ------------------Name----------------------------
			JLabel label_username = cl.CreateLabel("Name-Surname", 20, 70, 250, 40, 15);
			username = new JTextField();
			username.setBounds(19, 110, 700, 30);

			// ---------------Address----------------------------
			JLabel label_address = cl.CreateLabel("Address", 20, 140, 250, 40, 15);
			address = new JTextField();
			address.setBounds(19, 180, 700, 30);

			// ------------ZIP/Postal Code-----------------------
			JLabel label_zip = cl.CreateLabel("Zip/Postal Code", 20, 210, 250, 40, 15);
			zip = new JTextField();
			zip.setBounds(19, 250, 700, 30);

			// ----------email-----------------------------------
			JLabel label_email = cl.CreateLabel("Email", 20, 280, 250, 40, 15);
			email = new JTextField();
			email.setBounds(19, 320, 700, 30);

			// ------------country-------------------------------
			JLabel label_country = cl.CreateLabel("Country", 20, 350, 250, 40, 15);
			country = new JComboBox(_country);
			country.setBounds(19, 390, 700, 30);

			// --------------phone-------------------------------
			JLabel label_phone = cl.CreateLabel("Phone", 20, 420, 250, 40, 15);
			phone = new JTextField();
			phone.setBounds(19, 460, 700, 30);

			// ---------------------save button-------------------
			save = new JButton("Save");
			save.setBounds(680, 515, 80, 30);
			save.setFocusable(false);
			save.setFont(new Font("Mali-Bold", Font.BOLD, 13));
			save.setBackground(Color.yellow);
			save.setForeground(Color.black);
			save.addActionListener(this);

			this.add(title);
			this.add(label_username);
			this.add(username);
			this.add(label_address);
			this.add(address);
			this.add(label_zip);
			this.add(zip);
			this.add(label_email);
			this.add(email);
			this.add(label_country);
			this.add(country);
			this.add(label_phone);
			this.add(phone);
			this.add(save);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean alltrue = false;

	@Override
	public void actionPerformed(ActionEvent e) {

		int counter = 0;

		if (e.getActionCommand().equals("Save")) {

			String checkusername = username.getText();
			String checkaddress = address.getText();
			String checkzip = zip.getText();
			String checkemail = email.getText();
			String checkcountry = country.getSelectedItem().toString();
			String checkphone = phone.getText();

			/* Check first condition || If fill all the blank || counter == 0 */
			if (checkusername.length() == 0 || checkaddress.length() == 0 || checkzip.length() == 0
					|| checkemail.length() == 0 || country.getSelectedItem() == "" || checkphone.length() == 0) {
				JOptionPane.showMessageDialog(null, "Please fill all blank !!!", "ERROR !!",
						JOptionPane.QUESTION_MESSAGE);
				counter++;
			}

			/* Check Second condition */
			if (counter == 0) {
				//// ------------If Zip/Postal is all number || counter ==
				//// 0-----------------////
				for (int i = 0; i < checkzip.length(); i++) {
					if (!(Character.isDigit(checkzip.charAt(i)))) {
						zip.setText("");
						zip.setBounds(19, 250, 700, 30);
						JOptionPane.showMessageDialog(null,
								"Please\nInput (Zip/Postal Code) again\nMust Have Only (Number)", "ERROR !!",
								JOptionPane.ERROR_MESSAGE);
						counter++;
						break;
					}
				}

				//// ------------If email is input in the correct format || counter ==
				//// 0-----------------////
				if (!(checkemail.endsWith("@gmail.com") || checkemail.endsWith("@hotmail.com"))) {
					email.setText("");
					email.setBounds(19, 320, 700, 30);
					JOptionPane.showMessageDialog(null,
							"Please\nInput Email again\nMust Endwith (@gmail.com or @hotmail.com)", "ERROR !!",
							JOptionPane.ERROR_MESSAGE);
					counter++;
				}

				//// ---------If phone is input only number || counter == 0------------////
				for (int i = 0; i < checkphone.length(); i++) {
					if (!(Character.isDigit(checkphone.charAt(i)))) {
						phone.setText("");
						phone.setBounds(19, 460, 700, 30);
						JOptionPane.showMessageDialog(null, "Please\nInput Phone Number again\nMust Have Only (Number)",
								"ERROR !!", JOptionPane.ERROR_MESSAGE);
						counter++;
						break;
					}
				}
			}

			/* Final Condition || if all is correct format || counter == 0 */
			if (counter == 0) {
				alltrue = true;
				String Addressinfo = checkusername + "," + checkaddress + "," + checkzip + "," + checkemail + ","
						+ checkcountry + "," + checkphone;
				/* inside this String == "name,address,zip,mail,country,phone" */
				if (e.getActionCommand().equals("Save") && alltrue == true) {
					AllInfo += "," + Addressinfo; // "Jordan 1 Chicago,5200B,Red,40,name,address,zip,mail,country,phone"
					this.setVisible(false);
					new Receipt(AllInfo, Spic).setVisible(true);
				}
			}
		}
	}
}
