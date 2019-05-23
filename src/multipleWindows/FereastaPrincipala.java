package multipleWindows;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

class FereastraPrincipala {

	private JFrame frame = new JFrame();
	private ArrayList<FereastraInterna> frameArray = new ArrayList<FereastraInterna>();
	private int counter = 0;
	private int size = 0;
	private Timer timer = null;

	public FereastraPrincipala(String titlu, int size) throws IOException {
		frame.setTitle(titlu);
		this.size = size;
		// setSize(300, 200);
		frame.setMinimumSize(new Dimension(2000, 2000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JDesktopPane desktop = new JDesktopPane();

		for (int i = 0; i < size; i++) {
			FereastraInterna fin = new FereastraInterna();
			fin.setVisible(true);

			BufferedImage myPicture = ImageIO.read(new File("C:\\pic\\" + (i + 1) + ".jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			fin.add(picLabel);

			// JPanel panel = new JPanel();
			
			// fin.add(panel);
			desktop.add(fin);
			frameArray.add(fin);
		}

		// try {
		// Thread.sleep(1000);
		// ((JInternalFrame) frameArray.get((counter++) % size)).moveToFront();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }sss
		frame.add(desktop);
		frame.setVisible(true);
		
		

//		try{
//		    AudioInputStream audioInputStream =
//		        AudioSystem.getAudioInputStream(
//		            this.getClass().getResource("C:\\aa.mp3"));
//		    Clip clip = AudioSystem.getClip();
//		    clip.open(audioInputStream);
//		    clip.start();
//		}
//		catch(Exception ex)
//		{
//		}
		// ((JInternalFrame) frameArray.get(size - 1)).moveToFront();

		timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				((JInternalFrame) frameArray.get((counter++) % size)).moveToFront();
			}
		});
		
		timer.start();

	}

}

class FereastraInterna extends JInternalFrame {
	static int n =  -1; // nr. de ferestre interne
	static final int x = 20, y = 2;

	public FereastraInterna() {
		super(" Document - ALI #" + ( ++ n), true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
//		Random rn = new Random();
//		int value = rn.nextInt() % 60 + 5;
		setLocation(n * x, n * y);
		setSize(new Dimension(1100, 1100));
	}
}
