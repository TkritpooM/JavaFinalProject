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

public class Show extends JFrame implements ActionListener{

	JLabel title1,shoes1,shoes2,shoes3,shoes4;  //����ٻ�ͧ���
	JRadioButton blackC,blueC,orangeC,redC; //�������͡�ͧ���
	JButton confirm;
	
	public Show() {
		BufferedImage icon,blackS,blueS,orangeS,redS,confrm;
		try {
			icon = ImageIO.read(new File("img/icon.jpg"));
		    this.setIconImage(icon);
			this.setTitle("Shoes Pre-Order");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800, 600);
			this.setLocation(350, 100);
			//this.getContentPane().setBackground(Color.WHITE);
			this.setLocationRelativeTo(null);
			this.setLayout(null);
			
			title1 = new JLabel("Shoes List");
			title1.setBounds(290,25,400,50);
			title1.setFont(new Font("Mali-Bold",Font.BOLD,40));
			title1.setForeground(Color.BLACK);
			title1.setBorder(new EmptyBorder(0,10,0,0));
			
			blackS = ImageIO.read(new File("img/black.png"));
			blueS = ImageIO.read(new File("img/blue.png"));
			orangeS = ImageIO.read(new File("img/orange.png"));
			redS = ImageIO.read(new File("img/red.png"));
			confrm = ImageIO.read(new File("img/checked.png"));
			
			blackC = new JRadioButton("black");
			blackC.setFont(new Font("Mali-Bold",Font.BOLD,18));
			blackC.setFocusable(false);
			blackC.setBounds(180,250,300,50);
			shoes1 = new JLabel("");
			shoes1.setIcon(new ImageIcon(blackS.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
			shoes1.setBounds(170,100,150,150);
			//3700
			
			blueC = new JRadioButton("blue");
			blueC.setFont(new Font("Mali-Bold",Font.BOLD,18));
			blueC.setFocusable(false);
			blueC.setBounds(500,250,300,50);
			shoes2 = new JLabel("");
			shoes2.setIcon(new ImageIcon(blueS.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
			shoes2.setBounds(490,100,150,150);
			//9200B
			
			orangeC = new JRadioButton("orange");
			orangeC.setFont(new Font("Mali-Bold",Font.BOLD,18));
			orangeC.setFocusable(false);
			orangeC.setBounds(190,450,300,50);
			shoes3 = new JLabel("");
			shoes3.setIcon(new ImageIcon(orangeS.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
			shoes3.setBounds(170,300,150,150);
			//5200

			redC = new JRadioButton("red");
		    redC.setFont(new Font("Mali-Bold",Font.BOLD,18));
			redC.setFocusable(false);
			redC.setBounds(500,450,300,50);
			shoes4 = new JLabel("");
			shoes4.setIcon(new ImageIcon(redS.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
			shoes4.setBounds(490,300,150,150);
			//5200
			
			confirm = new JButton("Confirm");
			confirm.setIcon(new ImageIcon(confrm.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
			confirm.setBounds(650,490,100,40);
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
			this.add(confirm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String information = "";
		if (e.getActionCommand().equals("Confirm")) 
		{
			if ( (blackC.isSelected()||blueC.isSelected()||orangeC.isSelected()||redC.isSelected()) ) 
			{
				if (blackC.isSelected()) {
					information = "A111,10B,black,1doapw";
				}
				if (blueC.isSelected()) {
					information = "A112,10B,blue,2doapwocpmfap";
				}
				if (orangeC.isSelected()) {
					information = "A113,10B,orange,3doapwocpmfapovmgfop";
				}
				if (redC.isSelected()) {
					information = "A114,1000B,red,4doapwocpmfapovmgfop;amvgoa";
				}
				this.dispose();
				new ShowInformation(information).setVisible(true);
			}
			else if (  !(blackC.isSelected()||blueC.isSelected()||orangeC.isSelected()||redC.isSelected()) ) 
			{
		        JOptionPane.showMessageDialog(null,
						"You must select 1 types of shoes", "ERROR !!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
}
