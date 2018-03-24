package vn.hqkhai.main;

import java.io.File;
import java.net.URISyntaxException;

public class RenameMultipleFiles {

	private static final String SLASH = "\\";

	public static void main(String[] args) throws URISyntaxException {
		if (args.length != 1) {
			System.out.println("Please run jar again with ONLY 1 parameter is the prefix of file name");
		} else {
			String path = new File(
					RenameMultipleFiles.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath())
							.getAbsolutePath();
			path = path.substring(0, path.lastIndexOf(SLASH));
			File dir = new File(path);
			File[] files = dir.listFiles();
			for (File file : files) {
				String currentName = file.getName();
				String extensionName = currentName.substring(currentName.length() - 4);
				String newName = args[0] + "_" + currentName + extensionName;
				file.renameTo(new File(path + SLASH + newName));
			}
			System.out.println("Rename done!");
		}
	}

}
