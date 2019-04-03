package fr.cactuscata.ytd;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import fr.cactuscata.ytd.containers.CJTextField;
import fr.cactuscata.ytd.containers.DownloadButton;

public class VideoDownloaderFrame extends JFrame {

	private static final long serialVersionUID = 3950146736721813440L;
	private static VideoDownloaderFrame instance = null;

	public final JRadioButton mp4dlFormat = new JRadioButton("Mp4", true);
	public final JRadioButton mp3dlFormat = new JRadioButton("Mp3");
	public final JCheckBox isPlaylist = new JCheckBox("It's playlist ?");
	public final CJTextField videoUrlField = new CJTextField(
			20,
			"The link of your video no match !");
	public final CJTextField ytdlExeField = new CJTextField(20, "The file is not found !");
	public final CJTextField destinationPathField = new CJTextField(
			20,
			"The directory dosnt exist !");

	public VideoDownloaderFrame() {
		instance = this;

		super.setSize(new Dimension(450, 700));
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// Recupere la taille de l'écran de l'executeur
		Dimension dimensionFrame = toolkit.getScreenSize();
		// Va mettre la frame au milieu de l'écran
		super.setLocation(
				(int) (dimensionFrame.getWidth() / 2 - super.getSize().getWidth() / 2),
				(int) (dimensionFrame.getHeight() / 2 - super.getSize().getHeight() / 2));
		super.setTitle("VideoDownloader");
		// Va détruire l'objet frame quand on va fermer la fenetre
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setResizable(false);
		// Va organiser d'une façon la liste de tous les containers ajoutés
		super.setLayout(new FlowLayout());
		//VideoDownloaderPanel vdp = new VideoDownloaderPanel();
		//super.getContentPane().add(vdp);

		// -----------------------------------------------------------//

		// Presentation title
		JLabel presentationText = new JLabel("Video downloader");
		super.getContentPane().add(presentationText);

		// link download [text, textfield url]
		JLabel linkDLLabel = new JLabel("video-url to download");
		super.getContentPane().add(linkDLLabel);
		super.getContentPane().add(videoUrlField);

		// Youtubedl.exe folder path [text, textfield, bouton for search
		// program]
		JLabel ytdlExeLabel = new JLabel("YoutubeDL.exe path");
		super.getContentPane().add(ytdlExeLabel);
		super.getContentPane().add(ytdlExeField);

		// Choice between mp3 & mp4 [2 radioBox]
		ButtonGroup group = new ButtonGroup();
		group.add(mp4dlFormat);
		group.add(mp3dlFormat);
		super.getContentPane().add(mp4dlFormat);
		super.getContentPane().add(mp3dlFormat);

		// is playlist [CheckBox]
		super.getContentPane().add(this.isPlaylist);

		// path destination [text, textfield, bouton for search program]
		JLabel pathDestinationLabel = new JLabel("Path destination");
		super.getContentPane().add(pathDestinationLabel);
		super.getContentPane().add(destinationPathField);

		// Bouton de download
		JButton downloadButton = new DownloadButton();
		super.getContentPane().add(downloadButton);

	}

	public static VideoDownloaderFrame getInstance() {
		return instance;
	}

}
