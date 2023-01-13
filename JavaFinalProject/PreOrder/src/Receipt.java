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

import Instance.CreateButton;
import Instance.CreateLabel;
import Instance.CreateRadioButton;
import Instance.InsertImage;

public class Receipt extends JFrame implements ActionListener {

	static JLabel line;
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

			CreateLabel cl = new CreateLabel();
			CreateButton cb = new CreateButton();
			CreateRadioButton cr = new CreateRadioButton();
			InsertImage ii = new InsertImage();
			
			JLabel Ttitle = cl.CreateLabel("Receipt", 310, 50, 400, 40, 38);

			// -------------------Address For Shipping-------------------
			JLabel Stitle1 = cl.CreateLabel("Address For Shipping", 80, 130, 400, 40, 20);
			JLabel name = cl.CreateLabel("Name : " + info[4], 100, 160, 400, 40, 16);
			JLabel address = cl.CreateLabel("Address : ", 100, 190, 400, 40, 16);
			JLabel Sadd1 = cl.CreateLabel(info[5] + " " + info[8] + " " + info[6], 180, 190, 600, 40, 14);
			JLabel contract = cl.CreateLabel("Email : " + info[7], 100, 220, 400, 40, 16);
			JLabel Scon = cl.CreateLabel("Phone : " + info[9], 100, 250, 400, 40, 16);

			// --------------------Items Information-----------------------
			JLabel Stitle2 = cl.CreateLabel("Items Information", 80, 320, 400, 40, 20);
			JLabel Iname = cl.CreateLabel("Items Name : " + info[0], 100, 350, 400, 40, 16);
			//this.add(Iname);
			JLabel Icolor = cl.CreateLabel("Items Color : " + info[2], 100, 380, 400, 40, 16);
			//this.add(Icolor);
			JLabel Isize = cl.CreateLabel("Items Size  : " + info[3], 100, 410, 400, 40, 16);
			JLabel Iprice = cl.CreateLabel("Items Price  :                                  " + info[1], 100, 440, 400, 40, 16);
			
			// -------------------------Price------------------------------
			int price = Integer.parseInt(info[1].replace("B", ""));
			JLabel TaxPrice = cl.CreateLabel("Tax 7%       :                                " + (price + (price * 7 / 100)) + " baht",100, 470, 800, 40, 16);
			JLabel Net = cl.CreateLabel("Total Net Price                 " + (price + (price * 7 / 100)) + ".00 baht", 80, 530, 800, 40, 20);
			
			//-----------------------Picture-------------------------------
			JLabel Spic = ii.InsertImageBuffer(Cshoes, 510, 330, 150, 150);
			
			// ---------------------save button----------------------------
			Ok = new JButton("Ok");
			Ok.setBounds(620, 580, 80, 30);
			Ok.setFocusable(false);
			Ok.setFont(new Font("Mali-Bold", Font.BOLD, 13));
			Ok.setBackground(Color.LIGHT_GRAY);
			Ok.setForeground(Color.black);
			Ok.addActionListener(this);
			
			// --------------------------------------------------------------
			this.add(Ttitle);
			JLabel line1 = cl.CreateLabel("- - - -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x- - - -", 230, 60, 800, 100, 15);
			this.add(line1);
			this.add(Stitle1);
			this.add(name);
			this.add(address);
			this.add(Sadd1);
			this.add(contract);
			this.add(Scon);
			line1 = cl.CreateLabel("- - - -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x- - - -", 230, 250, 800, 100, 15);
			this.add(line1);
			this.add(Stitle2);
			this.add(Iname);
			this.add(Icolor);
			this.add(Isize);
			this.add(Iprice);
			this.add(TaxPrice);
			JLabel line2 = cl.CreateLabel("-----------------------------------------------", 290, 470, 800, 100, 15);
			this.add(line2);
			this.add(Net);
			this.add(Spic);
			this.add(Ok);
		} catch (Exception e) {
			// use to detected error from image search --> print in console
			// print in the console class name and line number where the exception occurred
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Ok")) {
			this.dispose();
			new HomePage().setVisible(true);
		}
	}
}
