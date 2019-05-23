package multipleWindows;

import java.io.IOException;

import javax.swing.SwingUtilities;

public class TestInternalFrame {
	public static void main(String args[]) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					new FereastraPrincipala(" Test ferestre interne ", 106);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

}
