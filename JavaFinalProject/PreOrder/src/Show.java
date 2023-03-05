import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Instance.*;

public class Show extends JFrame implements ActionListener {

	JRadioButton blackC, blueC, orangeC, redC; // �������͡�ͧ���
	JButton back,confirm;

	public Show() {

		try {
			this.setIconImage(ImageIO.read(Show.class.getResource("icon.jpg")));
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocationRelativeTo(null);
			this.setLayout(null);

			CreateLabel cl = new CreateLabel();
			CreateButton cb = new CreateButton();
			CreateRadioButton cr = new CreateRadioButton();
			InsertImage ii = new InsertImage();

			JLabel title1 = cl.CreateLabel("Shoes List", 290, 25, 400, 50, 40);

			blackC = cr.CreateRadioButton("Dunk low panda", 160, 250, 300, 50, 18);
			JLabel shoes1 = ii.InsertImage(ImageIO.read(Show.class.getResource("black.png")), 150, 100, 150, 150);

			blueC = cr.CreateRadioButton("Dunk low blue", 480, 250, 300, 50, 18);
			JLabel shoes2 = ii.InsertImage(ImageIO.read(Show.class.getResource("blue.png")), 470, 100, 150, 150);

			orangeC = cr.CreateRadioButton("Air Jordan 1mid", 160, 450, 300, 50, 18);
			JLabel shoes3 = ii.InsertImage(ImageIO.read(Show.class.getResource("orange.png")), 150, 300, 150, 150);

			redC = cr.CreateRadioButton("Jordan 1 Chicago", 480, 450, 300, 50, 18);
			JLabel shoes4 = ii.InsertImage(ImageIO.read(Show.class.getResource("red.png")), 470, 300, 150, 150);

			back = cb.CreateButton("Back", 30, 500, 80, 40, 15);
			back.addActionListener(this);
			
			confirm = cb.CreateButton(ImageIO.read(Show.class.getResource("choose.png")), "Info", 670, 500, 85, 40, 15, 15);
			confirm.addActionListener(this);

			ButtonGroup bg = new ButtonGroup();
			bg.add(blackC);
			bg.add(blueC);
			bg.add(orangeC);
			bg.add(redC);

			this.add(title1);
			this.add(blackC);
			this.add(shoes1);
			this.add(blueC);
			this.add(shoes2);
			this.add(orangeC);
			this.add(shoes3);
			this.add(redC);
			this.add(shoes4);
			this.add(back);
			this.add(confirm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			String information = "";
			BufferedImage ChoosenShoes = null;

			if (e.getActionCommand().equals("Info")) {
				if ((blackC.isSelected() || blueC.isSelected() || orangeC.isSelected() || redC.isSelected())) {
					if (blackC.isSelected()) {
						information = "Dunk low panda,3700B,Black";
						ChoosenShoes = ImageIO.read(Show.class.getResource("black.png"));
					}
					if (blueC.isSelected()) {
						information = "Dunk low blue,9200B,Blue";
						ChoosenShoes = ImageIO.read(Show.class.getResource("blue.png"));
					}
					if (orangeC.isSelected()) {
						information = "Air Jordan 1mid,5200B,Orange";
						ChoosenShoes = ImageIO.read(Show.class.getResource("orange.png"));
					}
					if (redC.isSelected()) {
						information = "Jordan 1 Chicago,5200B,Red";
						ChoosenShoes = ImageIO.read(Show.class.getResource("red.png"));
					}
					this.dispose();
					new ShowInformation(information, ChoosenShoes).setVisible(true);
				} else if (!(blackC.isSelected() || blueC.isSelected() || orangeC.isSelected() || redC.isSelected())) {
					JOptionPane.showMessageDialog(null, "You must select 1 types of shoes", "ERROR !!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (e.getActionCommand().equals("Back")) {
				this.dispose();
				new HomePage().setVisible(true);
			}
		} catch (Exception c) {
			c.printStackTrace(); /* if Error --> class name/method/line that error */
		}
	}
}
