package Instance;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class CreateButton {
	public static JButton CreateButton(String message,int x,int y,int w,int h,int font) {
		JButton Blank = new JButton(message);
		Blank.setBounds(x, y, w, h);
		Blank.setFocusable(false);
		Blank.setFont(new Font("Mali-Bold", Font.BOLD, font));
		Blank.setBackground(Color.LIGHT_GRAY);
		Blank.setForeground(Color.black);
		return Blank;
	}

}
