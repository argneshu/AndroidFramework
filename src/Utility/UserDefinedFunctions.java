package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import BugRegressionSuite.BaseTestBugRegression;

public class UserDefinedFunctions extends BaseTestBugRegression {
	
	public void takeSnapShot(String fileWithPath, String method) {
		// Convert web driver object to TakeScreenshot
		try {
			WebDriver augmentedDriver = new Augmenter().augment(wDriver);
			TakesScreenshot scrShot = ((TakesScreenshot) augmentedDriver);

			// Call getScreenshotAs method to create image file

			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination

			//File DestFile = new File("E:\\Screenshots\\hello.jpg");
			File DestFile = new File(fileWithPath+"\\"+ method +".jpg");
			

			// Copy file at destination

			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
		
	}


}
