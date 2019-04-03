package fr.cactuscata.ytd.help;

import java.io.File;
import java.net.URL;

public class Checker {

	public static boolean checkCorrectUrl(String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean fileExist(String filePath) {
		return new File(filePath).exists();
	}

}
