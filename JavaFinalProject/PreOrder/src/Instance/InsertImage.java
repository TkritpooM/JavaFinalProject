package Instance;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class InsertImage {

	//Case : Still not find image
	public static JLabel InsertImage(String path, int x, int y, int w, int h) {
		JLabel ImageI = null;
		try {
			BufferedImage image = null;
			image = ImageIO.read(new File(path));

			ImageI = new JLabel("");
			ImageI.setIcon(new ImageIcon(image.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH)));
			ImageI.setBounds(x, y, w, h);
			return ImageI;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ImageI;
	}
	
	//Case : Already have image
	public static JLabel InsertImageBuffer(BufferedImage Bimage, int x, int y, int w, int h) {
		JLabel ImageI = null;
		try {
			BufferedImage image = null;
			
			ImageI = new JLabel("");
			ImageI.setIcon(new ImageIcon(Bimage.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH)));
			ImageI.setBounds(x, y, w, h);
			return ImageI;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ImageI;
	}

}
