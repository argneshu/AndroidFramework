package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import BugRegressionSuite.BaseTestBugRegression;

public class FolderZip extends BaseTestBugRegression {
	List<String> fileList;
	private static final String OUTPUT_ZIP_FILE = resultFile + ".zip";
	private static final String OUTPUT_ZIP_FILE_1 = resultFile_1 + ".zip";
	private static final String SOURCE_FOLDER = resultFile;
	private static final String SOURCE_FOLDER_1 = resultFile_1;

	public static String destFolderPath = "\\\\192.168.11.11/all/QA_Team/Automation_Results/Consumer_App/"
			+ folderName();

	FolderZip() {
		fileList = new ArrayList<String>();
	}

	public static void CompressResultFolder() {
		FolderZip appZip = new FolderZip();
		appZip.generateFileList(new File(SOURCE_FOLDER));
		appZip.zipIt(OUTPUT_ZIP_FILE);
	}
	
//	public static void CompressResultFolderfortestng() {
//		FolderZip appZip = new FolderZip();
//		appZip.generateFileList(new File(SOURCE_FOLDER_1));
//		appZip.zipIttestng(OUTPUT_ZIP_FILE_1);
//	}

	public static String folderName() {
		String dateTime = null;
		try {
			Date curDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
			dateTime = format.format(curDate);
			dateTime = dateTime.replace(",", "_");
			dateTime = dateTime.replace(" ", "_");
			dateTime = dateTime.replace(":", "_");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dateTime;
	}

	/**
	 * Zip it
	 * 
	 * @param zipFile
	 *            output ZIP file location
	 */
	public void zipIt(String zipFile) {

		byte[] buffer = new byte[1024];

		try {

			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (String file : this.fileList) {
				System.out.println(file);

				ZipEntry ze = new ZipEntry(file);
				zos.putNextEntry(ze);
                
				FileInputStream in = new FileInputStream(SOURCE_FOLDER + File.separator + file);

				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}

				in.close();
			}

			zos.closeEntry();
			// remember close it
			zos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
//	public void zipIttestng(String zipFile) {
//
//		byte[] buffer = new byte[1024];
//
//		try {
//
//			FileOutputStream fos = new FileOutputStream(zipFile);
//			ZipOutputStream zos = new ZipOutputStream(fos);
//
//			for (String file : this.fileList) {
//
//				ZipEntry ze = new ZipEntry(file);
//				zos.putNextEntry(ze);
//
//				FileInputStream in = new FileInputStream(SOURCE_FOLDER_1 + File.separator + file);
//
//				int len;
//				while ((len = in.read(buffer)) > 0) {
//					zos.write(buffer, 0, len);
//				}
//
//				in.close();
//			}
//
//			zos.closeEntry();
//			// remember close it
//			zos.close();
//
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//	}

	/**
	 * Traverse a directory and get all files, and add the file into fileList
	 * 
	 * @param node
	 *            file or directory
	 */

	public void generateFileList(File node) {

		// add file only
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename));
			}
		}

	}

	/**
	 * Format the file path for zip
	 * 
	 * @param file
	 *            file path
	 * @return Formatted file path
	 */
	private String generateZipEntry(String file) {
		return file.substring(SOURCE_FOLDER.length() + 1, file.length());
	}

	@Override
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

	public static void copyResultSharedDrive() {

		File srcFolder = new File(path + "/ExtentResult");
		File destFolder = new File(destFolderPath);

		// make sure source exists
		if (!destFolder.exists()) {
			if (destFolder.mkdir()) {
			} else {
				System.out.println("Failed to create directory!");
			}
			try {
				copyFolder(srcFolder, destFolder);
			} catch (IOException e) {
				e.printStackTrace();
				// error, just exit
				System.exit(0);
			}
			// just exit
			System.exit(0);

		} else {

			try {
				copyFolder(srcFolder, destFolder);
			} catch (IOException e) {
				e.printStackTrace();
				// error, just exit
				System.exit(0);
			}
		}

	}

	public static void copyFolder(File src, File dest) throws IOException {

		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
		}
	}

}
