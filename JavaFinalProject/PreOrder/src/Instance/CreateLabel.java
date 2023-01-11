package Instance;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class CreateLabel {
	
	public static JLabel CreateLabel(String message,int x,int y,int w,int h,int font) {
		JLabel blank = new JLabel(message);
		blank.setBounds(x,y,w,h);
		blank.setFont(new Font("Mali-Bold",Font.BOLD,font));
		blank.setForeground(Color.BLACK);
		return blank;
	}

}
