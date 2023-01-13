package Instance;

import java.awt.Font;

import javax.swing.JRadioButton;

public class CreateRadioButton {
	
	public static JRadioButton CreateRadioButton(String RadioName,int x,int y,int w,int h,int font) {
		JRadioButton blank = new JRadioButton(RadioName);
		blank.setFont(new Font("Mali-Bold", Font.BOLD, font));
		blank.setFocusable(false);
		blank.setBounds(x, y, w, h);
		return blank;
	}

}
