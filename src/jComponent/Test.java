package jComponent;

import javax.swing.UIManager;

class Test {
	public static void main(String args[]) throws Exception {
		new Fereastra(" Facilitati JComponent ").show();
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	}
}