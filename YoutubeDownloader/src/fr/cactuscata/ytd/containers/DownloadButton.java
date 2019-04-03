package fr.cactuscata.ytd.containers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import fr.cactuscata.ytd.VideoDownloaderFrame;
import fr.cactuscata.ytd.help.Checker;
import fr.cactuscata.ytd.help.YTDLConstructor;

public class DownloadButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 9135379014169498676L;

	public DownloadButton() {
		super("Download");
		super.addActionListener(this);
		// Défini la taille du bouton
		super.setPreferredSize(new Dimension(100, 30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VideoDownloaderFrame vdf = VideoDownloaderFrame.getInstance();
		boolean isCorrect = true;

		// check si l'url est correcte
		if (!Checker.checkCorrectUrl(vdf.videoUrlField.getText())) {
			isCorrect = false;
			vdf.videoUrlField.invalidText();
		}

		// check si le fichier youtubedl.exe existe bien au path donné
		if (!Checker.fileExist(vdf.ytdlExeField.getText())) {
			vdf.ytdlExeField.invalidText();
			isCorrect = false;
		}

		// check si le path de la destination existe bien
		if (!Checker.fileExist(vdf.destinationPathField.getText())) {
			vdf.destinationPathField.invalidText();
			isCorrect = false;
		}

		if (!isCorrect) return;

		super.setEnabled(false);
		// lancer le bat si tout est ok
		try {
			File batFile = createBatFile();
			Runtime.getRuntime().exec(String.format("cmd /c start %s", batFile.getPath()));
			//if (batFile.exists()) batFile.delete();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				DownloadButton.super.setEnabled(true);
				// //Permet de modifier la taille du bouton
				// DownloadButton.super.setPreferredSize(
				// new Dimension(
				// (int) DownloadButton.super.getPreferredSize().getWidth() +
				// 10,
				// (int) DownloadButton.super.getPreferredSize().getHeight() +
				// 4));
				// //Permet de mettre à jour la taille du bouton
				// DownloadButton.super.revalidate();
			}
		}, 2000L);
	}

	private File createBatFile() throws IOException {
		VideoDownloaderFrame vdf = VideoDownloaderFrame.getInstance();
		File file = new File(System.getProperty("user.dir").replace("\\", "/"), "executor.bat");
		if (file.exists()) file.delete();
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		writeFile(dos, "@echo off");
		writeFile(dos, "echo [website-url]: %s", vdf.videoUrlField.getText());
		writeFile(dos, "echo [youtubedl folder path]: %s", vdf.ytdlExeField.getText());
		writeFile(dos, "echo [Format dl]: %s", vdf.mp3dlFormat.isSelected() ? "mp3" : "mp4");
		writeFile(dos, "echo [destination folder]: %s", vdf.destinationPathField.getText());
		writeFile(dos, "echo [is playlist]: %b", vdf.isPlaylist.isSelected());
		writeFile(dos, "cd /D %s", vdf.ytdlExeField.getText().replaceAll("youtube-dl.exe", ""));
		writeFile(dos, YTDLConstructor.construct());
		writeFile(dos, "pause");
		System.out.println(YTDLConstructor.construct());
		dos.close();
		return file;
	}

	private void writeFile(DataOutputStream dos, String string, Object... objects)
			throws IOException {
		dos.writeBytes(objects.length != 0 ? String.format(string, objects) : string);
		dos.write(System.getProperty("line.separator").getBytes());
	}

}
