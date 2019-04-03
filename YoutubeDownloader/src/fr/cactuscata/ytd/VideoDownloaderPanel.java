package fr.cactuscata.ytd;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class VideoDownloaderPanel extends JPanel {

	private static final long serialVersionUID = -4632199543467134044L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		
		// Presentation title
		drawCenteredString("VideoDownloader", 10, g);
		
		// link download [text, textfield url]
		g.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
		g.drawString("Video-url to download:", 10, 40);
		//super.getContentPane().add(videoUrlField);

		// Youtubedl.exe folder path [text, textfield, bouton for search
		// program]
		g.drawString("YoutubeDL.exe path:", 10, 60);
		//super.getContentPane().add(ytdlExeField);

		// Choice between mp3 & mp4 [2 radioBox]
//		JRadioButton mp4dlFormat = new JRadioButton("Mp4", true);
//		JRadioButton mp3dlFormat = new JRadioButton("Mp3");
//		group.add(mp4dlFormat);
//		group.add(mp3dlFormat);
//		super.getContentPane().add(mp4dlFormat);
//		super.getContentPane().add(mp3dlFormat);

		// is playlist [CheckBox]
		// 	super.getContentPane().add(this.isPlaylist);

		// path destination [text, textfield, bouton for search program]
		g.drawString("Path destination:", 10, 80);
		// 	super.getContentPane().add(destinationPathField);

		// Bouton de download
		//JButton downloadButton = new DownloadButton();
		// super.getContentPane().add(downloadButton);

	}

	private void drawCenteredString(String sentence, int height, Graphics g) {
		int stringwidth = g.getFontMetrics().stringWidth(sentence);
		g.drawString(sentence, (int) (super.getSize().getWidth() / 2 - stringwidth / 2), height);
		
		
	}

}
