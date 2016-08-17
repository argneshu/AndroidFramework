package Functional_Scenarios;

import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.ChangeZopperPassword;
import App_Functions.GmailLogin;
import App_Functions.OpenHomePage;
import App_Functions.OpenLoginPage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;
import Page_Objects.BugRegressionAppConstants;

//Test case info:In this test case we are  verifying multiple cases
//In first test case we are  verifying Sending Feedback using Contact Us option
//In second test case  we are verifying BackLink Functionality On FAQs AboutUs Page
//In third test case we are verifying share app fuctionality
//Author: Argneshu Gupta
public class OverflowMenuScenarios extends BaseTestBugRegression {

	@Override
	@Test(enabled = true)
	public void executeTestCase() throws Exception {
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BugRegressionAppConstants.NavDrawerHomeIcon_id)));
			swipeVertically_FullPage();
			swipeVertically_FullPage();
			extentInfoLogs("clicking on Overflow menu");
			try {
				clickName(BugRegressionAppConstants.ContactUs_name);
			} catch (Exception e) {
				swipeVertically_FullPage();
				swipeVertically_FullPage();
				clickName(BugRegressionAppConstants.ContactUs_name);
			}
			extentInfoLogs("clicking on Contact us option");
//			clickId(BugRegressionAppConstants.SelectNatureofFeedback_id);
//			extentInfoLogs("cliking on select nature of feedback id");
//			clickName(BugRegressionAppConstants.PaymentRelated_name);
//			extentInfoLogs("clicking on Payment related option");
//			clickName(BugRegressionAppConstants.Happy_name);
//			extentInfoLogs("Selecting happy value");
			clickName(BugRegressionAppConstants.Product_Radio_Text);
			extentInfoLogs("Check product radio");
			//swipeVertically_FullPage();
			sendKeysForID(BugRegressionAppConstants.Fullname_id, AppData.Fullname);
			extentInfoLogs("entering data for fullname");
			sendKeysForID(BugRegressionAppConstants.EmailID_id, AppData.EmailID);
			//swipeVertically(300);
			extentInfoLogs("entering data for email ID");
			sendKeysForID(BugRegressionAppConstants.WriteAfeedback_id, AppData.Feedback);
			clickId(BugRegressionAppConstants.SubmitButton_id);
			extentInfoLogs("clicking on submit button");
			clickId(BugRegressionAppConstants.PromptOKButton_id);
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
					.getText().equals(AppData.HomePageExploreExcitingCategories_text));
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}

	// Author:Arvind

	@Test(enabled = true)
	public void verifyBackLinkFunctionalityOnFAQsAboutUsPage() throws Exception {
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			extentInfoLogs("Open nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			swipeVertically_FullPage();
			swipeVertically_FullPage();
			extentInfoLogs("Click on FAQ");
			try {
				clickName(BugRegressionAppConstants.FAQ_name);
			} catch (Exception e) {
				swipeVertically_FullPage();
				swipeVertically_FullPage();
				clickName(BugRegressionAppConstants.FAQ_name);
			}
			extentInfoLogs("Click on About zopper");
			clickName(AppData.AboutZopper);

			// clickClassListObjectByName(App_Data.AboutZopper,
			// App_Constants.FAQsPageList_name);

			extentInfoLogs("Click on back");
			clickName(AppData.BackLinkText);
			extentInfoLogs("Assert for about us");
			Assert.assertEquals(verifyClickName(AppData.AboutZopper), true);

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	@Test(enabled = true)
	public void WarrantyOnFAQs() throws Exception {

		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			extentInfoLogs("Open nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(BugRegressionAppConstants.Home_name)));
			Thread.sleep(1000);
			swipeVertically_FullPage();
			swipeVertically_FullPage();
			swipeVertically_FullPage();
			swipeVertically_FullPage();

			extentInfoLogs("Click on FAQ");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(BugRegressionAppConstants.FAQ_name)));
			clickName(BugRegressionAppConstants.FAQ_name);

			extentInfoLogs("Click on About zopper");
			clickName(AppData.Warranty);

			Assert.assertTrue(findElementByName(BugRegressionAppConstants.WarrantyFAQsHeader_Text).isDisplayed());

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}
	// Autor:Arvind

	// @Test(enabled = true) Functionality removed
	public void verifyShareAppFunctionality() throws Exception {
		boolean flag = false;
		try {
			extentInfoLogs("open Login Page");
			OpenLoginPage.openLoginPage();

			extentInfoLogs("Gmail Login Page");
			GmailLogin.gmailLogin();

			extentInfoLogs("Click on more options link");
			clickName(BugRegressionAppConstants.HomeOverflow_name);

			extentInfoLogs("Click on Share app");
			clickName(BugRegressionAppConstants.ShareApp_name);

			extentInfoLogs("Click on Gmail app");
			try {
				clickName(BugRegressionAppConstants.Gmail_name);
			} catch (Exception e) {
			}
			// System.out.println("1");
			// System.out.println(findElementByXpath(App_Constants.Mail_To_xpath).isDisplayed());
			extentInfoLogs("Waiting for mail to text field");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.id(BugRegressionAppConstants.Mail_To_id)));
			extentInfoLogs("Enter TO mail id");

			sendKeysForID(BugRegressionAppConstants.Mail_To_id, AppData.UserId);

			java.util.Date date = new java.util.Date();
			String timeStamp = AppData.MailSubject + " " + new Timestamp(date.getTime()).toString();

			hideKeyboard();
			extentInfoLogs("Enter subject");
			// clickId(App_Constants.Mail_From_id);

			sendKeysForID(BugRegressionAppConstants.Mail_Subject_id, timeStamp);

			extentInfoLogs("Click on send button");
			clickId(BugRegressionAppConstants.Mail_Send_id);

			extentInfoLogs("Close Appium Session");
			closeAppiumSession();

			// ==================================================================================

			extentInfoLogs("Running selenium script");

			extentInfoLogs("Open selenium browser");
			ChangeZopperPassword.openBrowser(AppData.Rediff_URL);

			extentInfoLogs("Rediff login");
			ChangeZopperPassword.rediffLogin();

			extentInfoLogs("Closing child window");
			ChangeZopperPassword.closeChildWindow();

			extentInfoLogs("Click on mail box link");
			ChangeZopperPassword.openMailBox();

			// ChangeZopperPassword.closeChildWindow();

			extentInfoLogs("Click on mail");
			flag = ChangeZopperPassword.verifyMailHeader(timeStamp.trim());

			extentInfoLogs("Close selenium session");
			ChangeZopperPassword.closeBrowser();

			Assert.assertEquals(flag, true);

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}
}
