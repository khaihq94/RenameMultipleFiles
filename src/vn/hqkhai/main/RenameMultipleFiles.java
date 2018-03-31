package vn.hqkhai.main;

import java.io.File;
import java.net.URISyntaxException;

public class RenameMultipleFiles {

	private static final int PREFIX = 0;
	private static final String UNDER_SCORE="_";
	private static final String JPG_FORMAT = ".jpg";
	private static final String PNG_FORMAT = ".png";
	private static final String SLASH = "\\";

	public static void main(String[] args) throws URISyntaxException {
		if (args.length != 1) {
			System.out.println("Please run jar again with ONLY 1 parameter is the prefix of new file name");
		} else {
			String path = getCurrentPath();
			path = path.substring(0, path.lastIndexOf(SLASH));
			File dir = new File(path);
			File[] files = dir.listFiles();
			for (File file : files) {
				String currentName = file.getName();
				String extensionName = currentName.substring(currentName.length() - 4);
				boolean isImage = extensionName.equalsIgnoreCase(JPG_FORMAT) || extensionName.equalsIgnoreCase(PNG_FORMAT);
				if(isImage) {
					String newName = args[PREFIX] + UNDER_SCORE + currentName;
					file.renameTo(new File(path + SLASH + newName));
				}
			}
			System.out.println("Rename done!");
		}
	}

	private static String getCurrentPath() throws URISyntaxException {
		return new File(
				RenameMultipleFiles.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath())
						.getAbsolutePath();
	}

}
