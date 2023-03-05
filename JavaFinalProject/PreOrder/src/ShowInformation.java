import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import Instance.CreateButton;
import Instance.CreateLabel;
import Instance.CreateRadioButton;
import Instance.InsertImage;

public class ShowInformation extends JFrame implements ActionListener {

	/* Sent variable */
	public String AllInfo; // ""
	public String ID;
	public BufferedImage Spic;

	JLabel title1, shoes, Sname, price, Scolor;
	JButton cancel, confirm;

	public ShowInformation(String modelcode, BufferedImage Cshoes) {

		AllInfo = modelcode; /* "Jordan 1 Chicago,5200B,Red" */

		/* Put name/picture into variable and sent to other Class */
		String Sinfo[] = modelcode.split(",");
		ID = Sinfo[0];
		Spic = Cshoes;

		try {
			this.setIconImage(ImageIO.read(ShowInformation.class.getResource("icon.jpg")));
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocationRelativeTo(null);
			this.setLayout(null);

			CreateLabel cl = new CreateLabel();
			CreateButton cb = new CreateButton();
			CreateRadioButton cr = new CreateRadioButton();
			InsertImage ii = new InsertImage();

			JLabel title1 = cl.CreateLabel("Shoes Information", 200, 25, 400, 50, 40);

			shoes = ii.InsertImage(Cshoes, 280, 100, 200, 200);

			Sname = cl.CreateLabel("Model name : " + Sinfo[0] + " (Nike)", 150, 160, 400, 400, 20);

			price = cl.CreateLabel("Price            : " + Sinfo[1], 150, 200, 400, 400, 20);

			Scolor = cl.CreateLabel("Color            : " + Sinfo[2], 150, 240, 400, 400, 20);

			cancel = cb.CreateButton(ImageIO.read(ShowInformation.class.getResource("cancel.png")), "Cancel", 540, 500, 100, 40, 15, 15);
			cancel.addActionListener(this);

			confirm = cb.CreateButton(ImageIO.read(ShowInformation.class.getResource("checked.png")), "Confirm", 660, 500, 100, 40, 15, 15);
			confirm.addActionListener(this);

			this.add(title1);
			this.add(shoes);
			this.add(Sname);
			this.add(price);
			this.add(Scolor);
			this.add(cancel);
			this.add(confirm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Cancel")) {
			this.dispose();
			new Show().setVisible(true);
		} else if (e.getActionCommand().equals("Confirm")) {
			this.dispose();
			new ChooseSize(ID, Spic, AllInfo).setVisible(true);
		}
	}
}
