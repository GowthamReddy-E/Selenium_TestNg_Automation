package gowe.utils;
import java.io.File;

public class FileUtils {

	/**
	 * Deletes all files inside the specified folder.
	 *
	 * @param folderPath The path of the folder from which files need to be deleted.
	 */
	public static void deleteFilesInFolder(String folderPath) {
		File folder = new File(folderPath);

		// Check if the folder exists and is a directory
		if (folder.exists() && folder.isDirectory()) {
			File[] files = folder.listFiles(); // List all files in the folder

			if (files != null && files.length > 0) {
				for (File file : files) {
					if (file.isFile()) {
						if (file.delete()) {
							System.out.println("Deleted file: " + file.getName());
						} else {
							System.out.println("Failed to delete file: " + file.getName());
						}
					}
				}
			} else {
				System.out.println("No files found in the folder.");
			}
		} else {
			System.out.println("The provided folder path is invalid or does not exist.");
		}
	}

}
