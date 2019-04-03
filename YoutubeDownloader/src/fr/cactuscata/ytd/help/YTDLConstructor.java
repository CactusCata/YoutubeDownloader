package fr.cactuscata.ytd.help;

import fr.cactuscata.ytd.VideoDownloaderFrame;

public class YTDLConstructor {

	public static String construct() {
		VideoDownloaderFrame vdf = VideoDownloaderFrame.getInstance();
		StringBuilder builder = new StringBuilder("youtube-dl.exe ");

		if (vdf.isPlaylist.isSelected()) builder.append("--yes-playlist ");
		
		if (vdf.mp3dlFormat.isSelected()) builder.append("--extract-audio --audio-format mp3 --audio-quality 0 ");

		builder.append("-o \"" + vdf.destinationPathField.getText().replace('\\', '/') + "/%%(title)s.%%(ext)s\" ");

		builder.append(vdf.videoUrlField.getText());

		return builder.toString();
	}

}
