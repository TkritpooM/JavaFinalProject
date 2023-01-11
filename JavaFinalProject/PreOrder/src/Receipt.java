import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Receipt extends JFrame implements ActionListener {

	static JLabel line;
	JLabel Ttitle,Spic; // ---Title / Picture---//
	JLabel Stitle1, name, address, contract; // ---Sub Title1 (Shipping Address)---//
	JLabel Stitle2, Iname, Icolor, Isize, Iprice, TaxPrice; // ---Sub Title2 (Items Information)---//
	JLabel Net; // ---Price that needed to pay---//
	JTable table;
	JButton Ok;

	public Receipt(String Ainfo,BufferedImage Cshoes) {

		String info[] = Ainfo.split(","); // "Jordan 1 Chicago,5200B,Red,40,name,address,zip,mail,country,phone"
		BufferedImage icon;

		try {
			icon = ImageIO.read(new File("img/icon.jpg"));
			this.setIconImage(icon);
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(780, 700);
			this.setLocationRelativeTo(null); // ---Set Frame in the middle---//
			this.setLayout(null);

			ImageIcon backgd = new ImageIcon("img\\ReceiptBackGd.jpg");
			Image back = backgd.getImage().getScaledInstance(800, 665, java.awt.Image.SCALE_SMOOTH);
			backgd = new ImageIcon(back);
			this.setContentPane(new JLabel(backgd));
			this.setVisible(true);

			Ttitle = new JLabel("Receipt");
			Ttitle.setBounds(310, 50, 400, 40);
			Ttitle.setFont(new Font("Mali-Bold", Font.BOLD, 38));
			Ttitle.setForeground(Color.BLACK);

			Stitle1 = new JLabel("Address For Shipping");
			Stitle1.setBounds(80, 130, 400, 40);
			Stitle1.setFont(new Font("Mali-Bold", Font.BOLD, 20));
			Stitle1.setForeground(Color.BLACK);

			// ----------------------------------------------------------------//
			// ------Display name------//
			name = new JLabel("Name : " + info[4]);
			name.setBounds(100, 160, 400, 40);
			name.setFont(new Font("Mali-Bold", Font.BOLD, 16));
			name.setForeground(Color.BLACK);

			// ------[Display address --> country --> zip]------//
			address = new JLabel("Address : ");
			address.setBounds(100, 190, 400, 40);
			address.setFont(new Font("Mali-Bold", Font.BOLD, 16));
			address.setForeground(Color.BLACK);

			JLabel Sadd1 = new JLabel(info[5] + " " + info[8] + " " + info[6]);
			Sadd1.setBounds(180, 190, 600, 40);
			Sadd1.setFont(new Font("Mali-Bold", Font.BOLD, 14));
			Sadd1.setForeground(Color.BLACK);

			// ------Display Contract [mail--->phone]------//
			contract = new JLabel("Email : " + info[7]);
			contract.setBounds(100, 220, 400, 40);
			contract.setFont(new Font("Mali-Bold", Font.BOLD, 16));
			contract.setForeground(Color.BLACK);

			JLabel Scon = new JLabel("Phone : " + info[9]);
			Scon.setBounds(100, 250, 400, 40);
			Scon.setFont(new Font("Mali-Bold", Font.BOLD, 16));
			Scon.setForeground(Color.BLACK);

			// ----------------------------------------------------------------//
			Stitle2 = new JLabel("Items Information");
			Stitle2.setBounds(80, 320, 400, 40);
			Stitle2.setFont(new Font("Mali-Bold", Font.BOLD, 20));
			Stitle2.setForeground(Color.BLACK);

			Iname = new JLabel("Items Name : " + info[0]);
			Iname.setBounds(100, 350, 400, 40);
			Iname.setFont(new Font("Mali-Bold", Font.BOLD, 16));
			Iname.setForeground(Color.BLACK);
			this.add(Iname);

			Icolor = new JLabel("Items Color : " + info[2]);
			Icolor.setBounds(100, 380, 400, 40);
			Icolor.setFont(new Font("Mali-Bold", Font.BOLD, 16));
			Icolor.setForeground(Color.BLACK);
			this.add(Icolor);

			Isize = new JLabel("Items Size  : " + info[3]);
			Isize.setBounds(100, 410, 400, 40);
			Isize.setFont(new Font("Mali-Bold", Font.BOLD, 16));
			Isize.setForeground(Color.BLACK);

			Iprice = new JLabel("Items Price  :                                  " + info[1]);
			Iprice.setBounds(100, 440, 400, 40);
			Iprice.setFont(new Font("Mali-Bold", Font.BOLD, 16));
			Iprice.setForeground(Color.BLACK);

			// ----------------------------------------------------------------//
			int price = Integer.parseInt(info[1].replace("B", ""));
			TaxPrice = new JLabel(
					"Tax 7%       :                                " + (price + (price * 7 / 100)) + " baht");
			TaxPrice.setBounds(100, 470, 800, 40);
			TaxPrice.setFont(new Font("Mali-Bold", Font.BOLD, 16));
			TaxPrice.setForeground(Color.BLACK);

			Net = new JLabel("Total Net Price                 " + (price + (price * 7 / 100)) + ".00 baht");
			Net.setBounds(80, 530, 800, 40);
			Net.setFont(new Font("Mali-Bold", Font.BOLD, 20));
			Net.setForeground(Color.BLACK);

			//-----------------------Picture---------------------
			Spic = new JLabel("");
			Spic.setIcon(new ImageIcon(Cshoes.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH)));
			Spic.setBounds(480, 330, 180, 180);
			
			// ---------------------save button-------------------
			Ok = new JButton("Ok");
			Ok.setBounds(620, 580, 80, 30);
			Ok.setFocusable(false);
			Ok.setFont(new Font("Mali-Bold", Font.BOLD, 13));
			Ok.setBackground(Color.LIGHT_GRAY);
			Ok.setForeground(Color.black);
			Ok.addActionListener(this);

			// ----------------------------------------------------------------//
			this.add(Ttitle);
			line(230, 60, 800, 100);
			this.add(line);
			// -----------------------------//
			this.add(Stitle1);
			this.add(name);
			this.add(address);
			this.add(Sadd1);
			this.add(contract);
			this.add(Scon);
			// -----------------------------//
			line(230, 250, 800, 100);
			this.add(line);
			// -----------------------------//
			this.add(Stitle2);
			this.add(Isize);
			this.add(Iprice);
			this.add(TaxPrice);
			Sline(290, 470, 800, 100);
			this.add(line);
			this.add(Net);
			// -----------------------------//
			this.add(Spic);
			this.add(Ok);
		} catch (Exception e) {
			// use to detected error from image search --> print in console
			// print in the console class name and line number where the exception occurred
			e.printStackTrace();
		}
	}

	public static void line(int x, int y, int width, int height) {
		line = new JLabel("- - - -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x- - - -");
		line.setBounds(x, y, width, height);
		line.setFont(new Font("Mali-Bold", Font.BOLD, 15));
		line.setForeground(Color.BLACK);
	}

	public static void Sline(int x, int y, int width, int height) {
		line = new JLabel("-----------------------------------------------");
		line.setBounds(x, y, width, height);
		line.setFont(new Font("Mali-Bold", Font.BOLD, 10));
		line.setForeground(Color.BLACK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Ok")) {
			this.dispose();
			new HomePage().setVisible(true);
		}
	}
}