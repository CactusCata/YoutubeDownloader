package fr.cactuscata.ytd;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			try {
				new VideoDownloaderFrame().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
	}

}
