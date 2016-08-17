package Functional_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import App_Functions.TourPage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;

//Test case info: In this test case we are verifying two scenarios
//1.Quick tour page should be completely scrollable
//2.User should be able to skip Quick tour page
//Author: Argneshu Gupta

public class QuickTourScenarios extends BaseTestBugRegression {

	@Override
	@Test(enabled = true)
	public void executeTestCase() throws Exception {
		try {
			if(findElementsById(BugRegressionAppConstants.Lets_Go_Shopping_Id).size()>0){
			extentInfoLogs("Wait for let's go shoping");
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.id(BugRegressionAppConstants.Lets_Go_Shopping_Id)));
			for (int i = 0; i < 6; i++) {
				extentInfoLogs("Swipe screen horizontally");
				swipeWithAxis(600, 300, 100, 300, 3000);
				// swipeHorizontally();
			}
			extentInfoLogs("Click on skip tour");
			TourPage.tourSkip();

			extentInfoLogs("Assert for Home exciting categories");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
					.getText().equals(AppData.HomePageExploreExcitingCategories_text));
			}else{
				Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
						.getText().equals(AppData.HomePageExploreExcitingCategories_text));
			}

		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void skipQuickTour() {
		
		try {
			if(findElementsById(BugRegressionAppConstants.Lets_Go_Shopping_Id).size()>0){
			extentInfoLogs("Click on skip tour");
			TourPage.tourSkip();
			if (verifyElementExistByName(BugRegressionAppConstants.DetectAutomatically_name))
				clickName(BugRegressionAppConstants.DetectAutomatically_name);
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
					.getText().equals(AppData.HomePageExploreExcitingCategories_text));
			}else{
				extentInfoLogs("verifying assertion");
				if (verifyElementExistByName(BugRegressionAppConstants.DetectAutomatically_name))
					clickName(BugRegressionAppConstants.DetectAutomatically_name);
				Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
						.getText().equals(AppData.HomePageExploreExcitingCategories_text));
			}

		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}
	}

	@Test(enabled = true)
	public void quickTourForExistingApp() throws Exception {
		try {
			if(findElementsById(BugRegressionAppConstants.Lets_Go_Shopping_Id).size()>0){
			extentInfoLogs("Click on skip tour");
			TourPage.tourSkip();
			
			extentInfoLogs("Install retailer app");
			System.out.println(path);
			Runtime.getRuntime().exec("adb install "+path+"/app/RMS-staging-debug-22200.apk");
			Thread.sleep(5000);
			extentInfoLogs("Switch to retailer app");
			driver.startActivity(AppData.Retailer_PackageName, AppData.Retailer_ActivityName);
			Thread.sleep(5000);
			extentInfoLogs("Switch to consumer app");
			System.out.println(Con_Activity_Name);
			System.out.println(Con_Package_Name);
			driver.startActivity(Con_Package_Name, Con_Activity_Name);
			extentInfoLogs("Assert for select location");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
					.getText().equals(AppData.HomePageExploreExcitingCategories_text));
			}else{
				extentInfoLogs("Install retailer app");
				System.out.println(path);
				Runtime.getRuntime().exec("adb install "+path+"/app/RMS-staging-debug-22200.apk");
				Thread.sleep(5000);
				extentInfoLogs("Switch to retailer app");
				driver.startActivity(AppData.Retailer_PackageName, AppData.Retailer_ActivityName);
				Thread.sleep(5000);
				extentInfoLogs("Switch to consumer app");
				System.out.println(Con_Activity_Name);
				System.out.println(Con_Package_Name);
				driver.startActivity(Con_Package_Name, Con_Activity_Name);
				extentInfoLogs("Assert for select location");
				Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
						.getText().equals(AppData.HomePageExploreExcitingCategories_text));
			}
		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}
	}
	
}
