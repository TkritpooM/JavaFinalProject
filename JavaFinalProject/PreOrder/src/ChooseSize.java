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

import Instance.CreateButton;
import Instance.CreateLabel;
import Instance.CreateRadioButton;
import Instance.InsertImage;

public class ChooseSize extends JFrame implements ActionListener{
	
	//--Sent variable--//
	public String AllInfo; //""
	public BufferedImage Spic;
	
	JLabel shoes,Sname,price,Scolor;
	JRadioButton S1, S2, S3, S4;
	JButton cancel,confirm;
	
	public ChooseSize (String modelcode,BufferedImage Cshoes,String Ainfo) {
		
		AllInfo = Ainfo; //"Jordan 1 Chicago,5200B,Red"
		Spic = Cshoes;
		
		BufferedImage icon,confrm;
		
		try {
			icon = ImageIO.read(new File("img/icon.jpg"));
		    this.setIconImage(icon);
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocationRelativeTo(null);
			this.setLayout(null);
			
			CreateLabel cl = new CreateLabel();
			CreateButton cb = new CreateButton();
			CreateRadioButton cr = new CreateRadioButton();
			InsertImage ii = new InsertImage();
			
			JLabel title1 = cl.CreateLabel("Choose Your Size", 200,25,400,50, 40);
			
			shoes = ii.InsertImageBuffer(Cshoes, 280, 100, 200, 200);
			
			confrm = ImageIO.read(new File("img/checked.png"));
			confirm = new JButton("Confirm");
			confirm.setIcon(new ImageIcon(confrm.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
			confirm.setBounds(660, 500, 100, 40);
			confirm.addActionListener(this);
			
			S1 = cr.CreateRadioButton(" 40", 340, 320, 300, 50, 20);
			S2 = cr.CreateRadioButton(" 41", 340, 360, 300, 50, 20);
			S3 = cr.CreateRadioButton(" 42", 340, 400, 300, 50, 20);
			S4 = cr.CreateRadioButton(" 43", 340, 440, 300, 50, 20);
			
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
				AllInfo += "," + size;  //"Jordan 1 Chicago,5200B,Red,40" 
				this.dispose();
				new Address(AllInfo,Spic).setVisible(true);
			}
		}
		
	}

}
