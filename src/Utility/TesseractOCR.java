package Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import BugRegressionSuite.BaseTestBugRegression;

public class TesseractOCR extends BaseTestBugRegression {
	static String path = "";

	static {
		File currDir = new File("");
		path = currDir.getAbsolutePath();
	}

	public static void excCommand() {
		Runtime rt = Runtime.getRuntime();
		try {
			String batPath = path + "/Tesseract-OCR/test.bat";
			System.out.println("path is :    " + batPath);
			rt.exec("cmd.exe /c start " + batPath);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public static String readTextFile(String path) {
		String sCurrentLine = "", fileText = "";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
				fileText = fileText + sCurrentLine;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileText;
	}

	public static String readAllCurrentScreenText() {
		String text = "";
		try {
			TesseractOCR ocr = new TesseractOCR();
			captureScreenShot(driver, path + "/Tesseract-OCR", "Toast");
			ocr.excCommand();
			Thread.sleep(5000);
			text = ocr.readTextFile(path + "/Tesseract-OCR/out.txt");
			// Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;
	}

	// public static void main(String[] args) throws IOException{
	// // readAllCurrentScreenText();
	// File currDir = new File("");
	// path = currDir.getAbsolutePath();
	// System.out.println("path::::"+path);
	//
	// }

	@Override
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}
}
