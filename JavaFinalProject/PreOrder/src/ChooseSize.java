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
import javax.swing.border.EmptyBorder;

public class ChooseSize extends JFrame implements ActionListener{
	
	JLabel title1,shoes,Sname,price,Scolor;
	JRadioButton S1, S2, S3, S4;
	JButton cancel,confirm;
	
	public ChooseSize (String modelcode,BufferedImage Cshoes) {
		
		BufferedImage icon,confrm;
		
		try {
			icon = ImageIO.read(new File("img/icon.jpg"));
		    this.setIconImage(icon);
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocation(350, 100);
			this.setLocationRelativeTo(null);
			this.setLayout(null);
			
			title1 = new JLabel("Choose Your Size");
			title1.setBounds(200,25,400,50);
			title1.setFont(new Font("Mali-Bold",Font.BOLD,40));
			title1.setForeground(Color.BLACK);
			title1.setBorder(new EmptyBorder(0,10,0,0));
			
			shoes = new JLabel("");
			shoes.setIcon(new ImageIcon(Cshoes.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
			shoes.setBounds(280, 100, 200, 200);
			
			confrm = ImageIO.read(new File("img/checked.png"));
			confirm = new JButton("Confirm");
			confirm.setIcon(new ImageIcon(confrm.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
			confirm.setBounds(660, 500, 100, 40);
			confirm.addActionListener(this);
			
			S1 = new JRadioButton(" 40");
			S1.setFont(new Font("Mali-Bold", Font.BOLD, 20));
			S1.setFocusable(false);
			S1.setBounds(340, 320, 300, 50);

			S2 = new JRadioButton(" 41");
			S2.setFont(new Font("Mali-Bold", Font.BOLD, 20));
			S2.setFocusable(false);
			S2.setBounds(340, 360, 300, 50);

			S3 = new JRadioButton(" 42");
			S3.setFont(new Font("Mali-Bold", Font.BOLD, 20));
			S3.setFocusable(false);
			S3.setBounds(340, 400, 300, 50);

			S4 = new JRadioButton(" 43");
			S4.setFont(new Font("Mali-Bold", Font.BOLD, 20));
			S4.setFocusable(false);
			S4.setBounds(340, 440, 300, 50);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(S1);
			bg.add(S2);
			bg.add(S3);
			bg.add(S4);
			
			this.add(title1);
			this.add(shoes);
			this.add(S1);
			this.add(S2);
			this.add(S3);
			this.add(S4);
			this.add(confirm);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//empty button command
		String size = null;
		
		if (e.getActionCommand().equals("Confirm")) {
			if (!(S1.isSelected() || S2.isSelected() || S3.isSelected() || S4.isSelected())) {
				JOptionPane.showMessageDialog(null, "You must select 1 size", "ERROR !!",
						                      JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (S1.isSelected()) {
					size = "40";
				}
				if (S2.isSelected()) {
					size = "41";
				}
				if (S3.isSelected()) {
					size = "42";
				}
				if (S4.isSelected()) {
					size = "43";
				}
				this.dispose();
				new Address().setVisible(true);
			}
		}
		
	}

}
