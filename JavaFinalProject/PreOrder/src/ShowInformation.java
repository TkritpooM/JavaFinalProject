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

public class ShowInformation extends JFrame implements ActionListener {

	//--Sent variable--//
	public String AllInfo; //""
	
	JLabel title1,shoes,Sname,price,Scolor;
	JButton cancel,confirm;
	public String ID;
	public BufferedImage Spic;
	
	public ShowInformation(String modelcode,BufferedImage Cshoes) {
		
		AllInfo = modelcode; //"Jordan 1 Chicago,5200B,Red"
		
		BufferedImage icon,cel,confrm;
		
		String Sinfo[] = modelcode.split(",");
		//put name/pic into variable and sent to other Class
		ID = Sinfo[0];
		Spic = Cshoes;
		
		try {
			icon = ImageIO.read(new File("img/icon.jpg"));
		    this.setIconImage(icon);
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocation(350, 100);
			//this.getContentPane().setBackground(Color.GRAY);
			this.setLocationRelativeTo(null);
			this.setLayout(null);
			
			title1 = new JLabel("Shoes Information");
			title1.setBounds(200,25,400,50);
			title1.setFont(new Font("Mali-Bold",Font.BOLD,40));
			title1.setForeground(Color.BLACK);
			title1.setBorder(new EmptyBorder(0,10,0,0));
			
			shoes = new JLabel("");
			shoes.setIcon(new ImageIcon(Cshoes.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
			shoes.setBounds(280, 100, 200, 200);
			
			Sname = new JLabel("Model name : " + Sinfo[0] + " (Nike)");
			Sname.setBounds(150,160,400,400);
			Sname.setFont(new Font("Mali-Bold",Font.BOLD,20));
			Sname.setForeground(Color.BLACK);
			Sname.setBorder(new EmptyBorder(0,10,0,0));
			
			price = new JLabel("Price            : " + Sinfo[1]);
			price.setBounds(150,200,400,400);
			price.setFont(new Font("Mali-Bold",Font.BOLD,20));
			price.setForeground(Color.BLACK);
			price.setBorder(new EmptyBorder(0,10,0,0));
			
			Scolor = new JLabel("Color            : " + Sinfo[2]);
			Scolor.setBounds(150,240,400,400);
			Scolor.setFont(new Font("Mali-Bold",Font.BOLD,20));
			Scolor.setForeground(Color.BLACK);
			Scolor.setBorder(new EmptyBorder(0,10,0,0));
			
			cel = ImageIO.read(new File("img/cancel.png"));
			cancel = new JButton("Cancel");
			cancel.setIcon(new ImageIcon(cel.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
			cancel.setBounds(540, 500, 100, 40);
			cancel.addActionListener(this);
			
			confrm = ImageIO.read(new File("img/checked.png"));
			confirm = new JButton("Confirm");
			confirm.setIcon(new ImageIcon(confrm.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
			confirm.setBounds(660, 500, 100, 40);
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
		}
		else if (e.getActionCommand().equals("Confirm")) {
			this.dispose();
			new ChooseSize(ID,Spic,AllInfo).setVisible(true);
		}
	}
}
