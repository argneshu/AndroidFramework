 package Functional_Scenarios;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import App_Functions.OpenNavigationDrawer;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;
import Page_Objects.BugRegressionAppConstants;
import Utility.TesseractOCR;

//Test case info:In this test case we are  verifying multiple cases
//In first test case we are verifying correct location is selected and detect automatically is working
//In second test case we are verifying mutiple cities
//In third test case we are verifying that correct prompt is displayed on clicking link App displays a popup if user tap on Dont see your city in the list
//In fourth test case we are verifying locality 
//Author: Argneshu Gupta

public class LocationScenarios extends BaseTestBugRegression {
	static String path = "";

	static {
		File currDir = new File("");
		path = currDir.getAbsolutePath();
	}

	@Override
	@Test(enabled = true)
	public void executeTestCase() throws Exception {

		try {
			extentInfoLogs("Open nav drawer");
			OpenNavigationDrawer.openNavigationDrawer();
			extentInfoLogs("clicking on location icon");
			clickId(BugRegressionAppConstants.NavDrawerLocationIcon_id);
			extentInfoLogs("verifying location name");
			Assert.assertTrue(findElementByName(
					BugRegressionAppConstants.SelectLocation_text).getText()
					.equals(AppData.Locationtext));
			extentInfoLogs("click on detect automatically link");
			clickName(BugRegressionAppConstants.DetectAutomatically_name);
			extentInfoLogs("Open Nav Drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			clickId(BugRegressionAppConstants.NavDrawerHomeIcon_id);
			extentInfoLogs("clicking on home icon");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
					.getText().equals(AppData.HomePageExploreExcitingCategories_text));
			extentInfoLogs("Open Nav Drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Open Nav Drawer");
			clickId(BugRegressionAppConstants.NavDrawerLocationTitle_id);
			extentInfoLogs("clicking Navdrawer location title");
			clickName(BugRegressionAppConstants.BangaloreLocation_text);
			extentInfoLogs("clicking on Banglaore location");
			Assert.assertTrue(findElementByName(
					BugRegressionAppConstants.BTMLocation_text).getText()
					.equals(AppData.BTMtext));
			extentInfoLogs("applying explicit wait");
			clickName(BugRegressionAppConstants.BTMLocation_text);
			extentInfoLogs("clicking on BTM location");
			extentInfoLogs("Open Navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			Assert.assertTrue(findElementById(
					BugRegressionAppConstants.NavDrawerLocationChild_id)
					.getText().equals(AppData.BTMtext));

		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void mutipleCities() {
		try {
			extentInfoLogs("Calling tour page function");
			OpenNavigationDrawer.openNavigationDrawer();
			extentInfoLogs("clicking on location icon");
			clickId(BugRegressionAppConstants.NavDrawerLocationIcon_id);
			extentInfoLogs("Reteriving list of cities");
			List<WebElement> cities = findElementsById(BugRegressionAppConstants.Location_CitiesNames_Id);
			extentInfoLogs("verifying cities content");
			Assert.assertTrue(cities.size() > 0);
		}

		catch (Exception e) {
			throw (e);
		}
	}

	@Test(enabled = true)
	public void unavailableCitiesPopUpConfirmation() throws Exception {
		try {
			extentInfoLogs("Open Nav drawer");
			OpenNavigationDrawer.openNavigationDrawer();
			extentInfoLogs("clicking on location icon");
			clickId(BugRegressionAppConstants.NavDrawerLocationIcon_id);
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.name(BugRegressionAppConstants.SelectLocation_text)));

			for (int i = 0; i < 6; i++) {
				swipeVertically_FullPage();
			}
			extentInfoLogs("Applying swipe on the page");
			extentInfoLogs("Absent city pop up is displayed");
			clickId(BugRegressionAppConstants.AbsentCity_id);
			Thread.sleep(2000);
			extentInfoLogs("clicking on url ->App displays a popup if user tap on Dont see your city in the list");
			extentInfoLogs("Verifying Pop up");
			Assert.assertTrue(findElementById(
					BugRegressionAppConstants.EmailIdTextBox_Id).isDisplayed());
			Assert.assertTrue(findElementById(
					BugRegressionAppConstants.YourCityTextBox_Id).isDisplayed());

			extentInfoLogs("appying assertion");
		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void enterDataInCitiesPopUp() throws Exception {
		try {
			extentInfoLogs("Open nav drawer");
			OpenNavigationDrawer.openNavigationDrawer();
			extentInfoLogs("clicking on location icon");
			clickId(BugRegressionAppConstants.NavDrawerLocationIcon_id);
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.name(BugRegressionAppConstants.SelectLocation_text)));
			for (int i = 0; i < 6; i++) {
				swipeWithAxis(10, 700, 10, 250, 3000);
			}
			extentInfoLogs("applying swipe function");
			extentInfoLogs("Pop up displayed for absent cities");
			clickId(BugRegressionAppConstants.AbsentCity_id);
			extentInfoLogs("clicking on url ->App displays a popup if user tap on Dont see your city in the list");
			info("enter mail id ,city name and click on OK button");
			extentInfoLogs("enter mail id ,city name and click on OK button");
			sendKeysForID(BugRegressionAppConstants.EmailIdTextBox_Id,
					AppData.UserId);
			sendKeysForID(BugRegressionAppConstants.YourCityTextBox_Id,
					AppData.Location_text);
			clickId(BugRegressionAppConstants.OkButton_Id);
		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void localitySelection() throws Exception {
		try {
			extentInfoLogs("Calling home page ");
			OpenHomePage.openHomePage();
			extentInfoLogs("Open Nav Drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("click on location icon");
			extentInfoLogs("open menu drawer");
			clickId(BugRegressionAppConstants.NavDrawerLocationIcon_id);
			extentInfoLogs("clicking on location icon");
			String locality = getTextByName(
					BugRegressionAppConstants.Citylocality_id,
					AppVerificationChecks.locality);
			Assert.assertEquals(locality, AppVerificationChecks.locality);

		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}

	}

	@Test(enabled =  true)
	public void locationCount() throws Exception {
		int count = 0;
		String lastName = "", cLastName = "";
		String allLoc = "";

		try {
			extentInfoLogs("Calling home page ");
			OpenHomePage.openHomePage();
			extentInfoLogs("Open Nav Drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("click on location icon");
			extentInfoLogs("open menu drawer");
			clickId(BugRegressionAppConstants.NavDrawerLocationIcon_id);
			extentInfoLogs("clicking on location icon");
			wait.until(ExpectedConditions.elementToBeClickable(By
					.name(BugRegressionAppConstants.SelectLocation_text)));
			extentInfoLogs("Wait for select location");
			for (int i = 0; i < 10; i++) {
				List<WebElement> locations = findElementsById(BugRegressionAppConstants.Location_CitiesNames_Id);
				for (WebElement ele : locations) {
					
					System.out.println("cities text is : "+ele.getText());
					System.out.println("allLoc variable is "+ allLoc);
					if (!allLoc.contains(ele.getText().trim())) {
						count++;
						System.out.println("count is "+ count);
						allLoc = allLoc + "##" + ele.getText().trim();
					}
					cLastName = ele.getText().trim();
					System.out.println("cLastname is :" +cLastName);

				}
				System.out.println("lastname is "+lastName);
				if (!lastName.equals(cLastName)) {
					lastName = cLastName;
					swipeVertically_FullPage();
				} else
					break;

			}
			extentInfoLogs("Total location available: " + count);
			Assert.assertTrue(count == 28);
		} catch (

		Exception e)

		{
			e.getMessage();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void autoDetectLocation() throws Exception {
		// Method method = null;
		// method = LocationScenarios.class.getMethod("autoDetectLocation",
		// null);
		try {
			extentInfoLogs("clicking on let go shopping link");
			// TesseractOCR ocr = new TesseractOCR();
			if(findElementsById(BugRegressionAppConstants.Lets_Go_Shopping_Id).size()>0){
			clickId(BugRegressionAppConstants.Lets_Go_Shopping_Id);
			extentInfoLogs("detecting auto location");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(BugRegressionAppConstants.AutoLocationToast_id)));
			captureScreenShot(driver, path + "/Tesseract-OCR", "Toast");
			TesseractOCR.excCommand();
			Thread.sleep(3000);
			String text = TesseractOCR.readTextFile(path+ "/Tesseract-OCR/out.txt");
			System.out.println(text);
			// Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
			// System.out.println(text);
			Assert.assertTrue(text.trim().contains(AppVerificationChecks.AutoLocationtext.trim()));
			}else{
				extentInfoLogs("detecting auto location");
//				wait.until(ExpectedConditions.presenceOfElementLocated(By
//						.id(BugRegressionAppConstants.AutoLocationToast_id)));
				captureScreenShot(driver, path + "/Tesseract-OCR", "Toast");
				TesseractOCR.excCommand();
				Thread.sleep(3000);
				String text = TesseractOCR.readTextFile(path
						+ "/Tesseract-OCR/out.txt");
				System.out.println(text);
				// Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
				// System.out.println(text);
				Assert.assertTrue(text.trim().contains(
						AppVerificationChecks.AutoLocationtext.trim()));
			}
			// closeAppiumSession();
		} catch (Exception e) {
			throw (e);
		}
	}

	@Test(enabled = true)
	public void changeLinkforAutoDetectLocation() throws Exception {
		// Method method1 = null;
		// method1 = LocationScenarios.class.getMethod(
		// "changeLinkforAutoDetectLocation", null);
		try {
			extentInfoLogs("clicking on let go shopping link");
			if(findElementsById(BugRegressionAppConstants.Lets_Go_Shopping_Id).size()>0)
			{
				extentInfoLogs("clicking on let go shopping link");
				clickId(BugRegressionAppConstants.Lets_Go_Shopping_Id);
				if(findElementById(BugRegressionAppConstants.AutoLocationToast_id).isDisplayed())
				{
					String change = driver.findElement(By.id(BugRegressionAppConstants.AutoLocationChangetext_id)).getText();

					System.out.println(change);
					Assert.assertTrue(change.contains("CHANGE"));
				}
				// findElementById(BugRegressionAppConstants.AutoLocationChangetext_id).getText();
			}
			else
			{
				extentInfoLogs("get text for change link");
				String change = driver.findElement(By.id(BugRegressionAppConstants.AutoLocationChangetext_id)).getText();

				// findElementById(BugRegressionAppConstants.AutoLocationChangetext_id).getText();
				System.out.println(change);
				Assert.assertTrue(change.contains("CHANGE"));
			}
		}
		catch (Exception e)
		{
			throw (e);
		}
	}
}
