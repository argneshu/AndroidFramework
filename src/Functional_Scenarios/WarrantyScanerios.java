package Functional_Scenarios;

import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;

public class WarrantyScanerios extends BaseTestBugRegression {

	@Test(enabled = true, priority = 0)
	public void addWarrantyProduct() throws Exception {
		boolean flag = false;
		try {

			extentInfoLogs("Open Login page");
			OpenLoginPage.openLoginPage();

			extentInfoLogs("Gmail login");
			GmailLogin.gmailLogin();

			extentInfoLogs("Click on my account warranty");
			// driver.findElements(By.id(App_Constants.MyAccountTabs)).get(3).click();
			clickId(BugRegressionAppConstants.myAccount_Warranty_id);

			extentInfoLogs("Click on Add a product link");
			clickId(BugRegressionAppConstants.Add_Product_id);

			extentInfoLogs("Click on enter your product name");
			clickId(BugRegressionAppConstants.Add_Product_Name_id);

			// for (int i = 0; i < 3; i++) {
			// if
			// (findElementsByName(BugRegressionAppConstants.Warranty_Product_Category_name).size()
			// > 0) {
			extentInfoLogs("Click on refrigrator product category");
			clickName(BugRegressionAppConstants.Warranty_Product_Category_name);
			extentInfoLogs("Enter product name");
			// sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id,
			// AppData.LG_Name);
			findElementById(BugRegressionAppConstants.Home_SearchEditBox_id).sendKeys(AppData.LG_Name);
			// } else
			// break;
			// }
			Thread.sleep(3000);

			extentInfoLogs("Click on first index product");
			wait.until(ExpectedConditions
					.elementToBeClickable(findElementsById(BugRegressionAppConstants.Warranty_Product_id).get(1)));
			extentInfoLogs("Click on first index product");
			String productName = findElementsById(BugRegressionAppConstants.Warranty_Product_id).get(1).getText();
			findElementsById(BugRegressionAppConstants.Warranty_Product_id).get(1).click();
			// clickId(BugRegressionAppConstants.Warranty_Product_id);
			Thread.sleep(20000);

			extentInfoLogs("Click on select");
			clickId(BugRegressionAppConstants.Select_id);
			int i=0;
			while(i<1){
			if(findElementsById(BugRegressionAppConstants.Select_id).size()>0){
				clickId(BugRegressionAppConstants.Select_id);
				break;
			}else{
				
			}
			i++;
			}

			extentInfoLogs("Click on camera image");
			clickId(BugRegressionAppConstants.Camera_id);

			String deviceVersion = getDeviceVersion();
			System.out.println("device version is : "+deviceVersion);

			if (!deviceVersion.contains("5.")) {
				extentInfoLogs("Capture image");
				hitADBCommandForCamera("27");

				extentInfoLogs("Save image");
				hitADBCommandForCamera("21");
				hitADBCommandForCamera("22");
				hitADBCommandForCamera("23");
				Thread.sleep(5000);
			}
			
			else if(deviceVersion.contains("5.1"))
			{
				extentInfoLogs("Capture image");
				hitADBCommandForCamera("27");
				extentInfoLogs("Save image");
				hitADBCommandForCamera("22");
				hitADBCommandForCamera("22");
				hitADBCommandForCamera("66");
				Thread.sleep(5000);
			}
			
			else {
			//	driver.sendKeyEvent(KeyEvent.KEYCODE_CAMERA);
				Runtime.getRuntime().exec("adb shell input keyevent 23");
				Thread.sleep(2000);
				clickId(BugRegressionAppConstants.LollipopCameraSaveButton_id);
//				Runtime.getRuntime().exec("adb shell input keyevent 23");
//				Thread.sleep(2000);
//				Runtime.getRuntime().exec("adb shell input keyevent 27");
//				Thread.sleep(5000);
//				Runtime.getRuntime().exec("adb shell input keyevent 61");
//				Thread.sleep(2000);
//				Runtime.getRuntime().exec("adb shell input keyevent 61");
//				Thread.sleep(2000);
//				Runtime.getRuntime().exec("adb shell input keyevent 66");
//				Thread.sleep(5000);
			}

			extentInfoLogs("Click next button");
			clickId(BugRegressionAppConstants.Next_Add_Warrenty_One_id);

			extentInfoLogs("Warranty valid for");
			clickId(BugRegressionAppConstants.type_id);
			clickName(AppData.Warrant_For);

			extentInfoLogs("Select date");
			clickId(BugRegressionAppConstants.Warranty_Purchase_Date_id);
			clickId(BugRegressionAppConstants.Warranty_Date_Done_id);

			extentInfoLogs("Click next button");
			clickId(BugRegressionAppConstants.Next_Add_Warrenty_Two_id);

			extentInfoLogs("Assert for product name");
			flag = verifyElementExistByName(productName);
			Assert.assertEquals(flag, true);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void claimAfterWarrantyValidForIsDisplayed() throws Exception {
		try {
			extentInfoLogs("Add warranty");
			addWarrantyProduct();
			extentInfoLogs("Click on warranty product");
			findElementsById(BugRegressionAppConstants.Warrant_Product_Name).get(0).click();
			extentInfoLogs("First Warranty product on list");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.Claim_Warranty_Header_Text).isDisplayed());
			extentInfoLogs("Claim warranty page open");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw (ex);
		}
	}

	@Test(enabled = true, priority = 0)
	public void claimWarranty() throws Exception {
		try {
			extentInfoLogs("Add warranty");
			addWarrantyProduct();
			findElementsById(BugRegressionAppConstants.Warrant_Product_Name).get(0).click();
			if (findElementsById(BugRegressionAppConstants.WarrantyReason_id).size() < 0) {
				findElementsById(BugRegressionAppConstants.Warrant_Product_Name).get(1).click();
			}
			swipeWithAxis(200, 500, 200, 300, 2000);
			extentInfoLogs("Enter product reason");
			sendKeysForID(BugRegressionAppConstants.WarrantyReason_id, AppData.ProductReasons);
			extentInfoLogs("Enter Contact no");
			if(findElementsById(BugRegressionAppConstants.ClaimWarrantyPencil_id).size()>0){
				clickId(BugRegressionAppConstants.ClaimWarrantyPencil_id);
			}
			sendKeysForID(BugRegressionAppConstants.WarrantyContactNo_id, AppData.Contacts);
			hideKeyboard();
			swipeVertically_FullPage();
			// Thread.sleep(5000);
			extentInfoLogs("Click on Warranty claim button");
			clickId(BugRegressionAppConstants.WarrantyClaimButton_id);

			extentInfoLogs("Assert for warranty confirmation");
			Assert.assertTrue(
					findElementByName(BugRegressionAppConstants.WarrantyRequestConfirmation_text).isDisplayed());
			extentInfoLogs("Navigate back");
			navigateBack();
			extentInfoLogs("Navigate back");
			navigateBack();
			Thread.sleep(5000);
			extentInfoLogs("Click on my account warranty");
			clickId(BugRegressionAppConstants.myAccount_Warranty_id);
			extentInfoLogs("Click on first warrant product");
			findElementsById(BugRegressionAppConstants.Warrant_Product_Name).get(0).click();
			extentInfoLogs("Assert for warranty claim id");
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.Warranty_ClaimStatus_Id).size() > 0);

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	@Test(enabled = true, priority = 2)
	public void shareWarrantyInvoice() throws Exception {
		try {
			extentInfoLogs("open Login Page");
			OpenLoginPage.openLoginPage();

			extentInfoLogs("Gmail Login Page");
			GmailLogin.gmailLogin();

			extentInfoLogs("Click on warranty tab");
			clickId(BugRegressionAppConstants.myAccount_Warranty_id);
			extentInfoLogs("Click on view warranty invoice link");
			findElementsById(BugRegressionAppConstants.View_Warranty_Invoice_Id).get(0).click();
			extentInfoLogs("Click on share button");
			clickId(BugRegressionAppConstants.ImageShareButton_Id);
			for (int k = 0; k < 3; k++) {
				if (findElementsById(BugRegressionAppConstants.ImageShareButton_Id).size() > 0) {
					clickId(BugRegressionAppConstants.ImageShareButton_Id);
				} else {
					break;
				}
			}
			try {
				swipeVertically_FullPage();
				clickName(BugRegressionAppConstants.Gmail_name);
			} catch (Exception e) {
			}
			extentInfoLogs("Dynamic wait for mail To");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.id(BugRegressionAppConstants.Mail_To_id)));
			extentInfoLogs("Enter TO mail id");

			extentInfoLogs("Enter user mail id");
			sendKeysForID(BugRegressionAppConstants.Mail_To_id, AppData.UserId);

			java.util.Date date = new java.util.Date();
			String timeStamp = AppData.MailSubject + " " + new Timestamp(date.getTime()).toString();

			extentInfoLogs("Enter subject");
			hideKeyboard();
			sendKeysForID(BugRegressionAppConstants.Mail_Subject_id, timeStamp);

			extentInfoLogs("Click on send button");
			clickId(BugRegressionAppConstants.Mail_Send_id);
			Thread.sleep(3000);
			extentInfoLogs("Assert for share button");
			Assert.assertTrue(findElementById(BugRegressionAppConstants.ImageShareButton_Id).isDisplayed());
			extentInfoLogs("Close session");
			closeAppiumSession();

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	@Test(enabled = true, priority = 3)
	public void warrantyRemainingDay() throws Exception {
		try {
			extentInfoLogs("open Login Page");
			OpenLoginPage.openLoginPage();
			extentInfoLogs("Gmail Login Page");
			GmailLogin.gmailLogin();
			extentInfoLogs("Click on warranty tab");
			clickId(BugRegressionAppConstants.myAccount_Warranty_id);
			extentInfoLogs("Assert for warrant valid for date");
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.Warranty_Valid_For_Id).size() > 0);
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw (ex);
		}
	}

	@Test(enabled = true, priority = 3)
	public void warrantyAddFromDrawerMenu() throws Exception {
		try {
			extentInfoLogs("open Login Page");
			OpenLoginPage.openLoginPage();
			extentInfoLogs("Gmail Login");
			GmailLogin.gmailLogin();
			extentInfoLogs("Click on back tab");
			backButton();

			extentInfoLogs("Click on navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(BugRegressionAppConstants.Homelink_id)));
			swipeVertically(200);
			swipeVertically(200);
			extentInfoLogs("Click on add product for warranty text");
			clickName(BugRegressionAppConstants.Add_Product_For_Warranty_Text);

			extentInfoLogs("Assert for add product header");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.Add_Product_Header_Text).isDisplayed());
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw (ex);
		}
	}

	@Test(enabled = false, dependsOnMethods = { "claimWarranty" }, priority = 4)
	public void generateFreshdeskTicket() throws Exception {
		try {
			extentInfoLogs("open Login Page");
			OpenLoginPage.openLoginPage();
			extentInfoLogs("Gmail Login");
			GmailLogin.gmailLogin();
			String emailid = findElementById(BugRegressionAppConstants.UserEmailtext_id).getText();
			String splitemailid[] = emailid.split("@");
			System.out.println(splitemailid[0]);
			extentInfoLogs("clicking on my account warranty");
			clickId(BugRegressionAppConstants.myAccount_Warranty_id);
			// String warrantyClaimID = findElementById(
			// BugRegressionAppConstants.Warranty_ClaimId_Id).getText();
			// System.out.println(warrantyClaimID);
			closeAppiumSession();
			Thread.sleep(5000);
			String emailidname = openFreshDesk();
			Assert.assertTrue(splitemailid[0].equalsIgnoreCase(emailidname));
			// wDriver.close();
		} catch (Exception e) {
			throw (e);
		}

	}

	@SuppressWarnings("null")
	public static String openFreshDesk() throws Exception {
		String email_id = null;
		Actions action = null;
		try {
			ChangeZopperPassword.openBrowser(AppData.Freshdesklink);
			wDriver.findElement(By.id(SanitySuiteAppConstants.FresdeskUsername_id)).sendKeys(AppData.FreshdeskUsername);
			wDriver.findElement(By.id(SanitySuiteAppConstants.FreshdsekPassword_id))
					.sendKeys(AppData.FreshdeskPassword);
			wDriver.findElement(By.xpath(SanitySuiteAppConstants.FreshdeskButton_xpath)).click();
			if (verifyElementDisplayedByLink(SanitySuiteAppConstants.zoppertest_link)) {
				Assert.assertTrue(
						wDriver.findElements(By.linkText(SanitySuiteAppConstants.zoppertest_link)).size() > 0);
			} else {
				List<WebElement> anchortags = wDriver.findElements(By.tagName("a"));
				for (WebElement anchortag : anchortags) {
					if (anchortag.getText().equals(SanitySuiteAppConstants.zoppertest_link)) {
						System.out.println(anchortag.getText());
						break;
					}

				}

			}
			email_id = SanitySuiteAppConstants.zoppertest_link;
			ChangeZopperPassword.closeBrowser();
		} catch (Exception e) {
			throw (e);
		}
		return email_id;
	}

	@Test(enabled = true, priority = 3)
	public void addWarrantyFromHomePage() throws Exception {

		try {
			extentInfoLogs("open home Page");
			OpenHomePage.openHomePage();
//			extentInfoLogs("Click on navigation drawer");
//			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			Thread.sleep(2000);
			int i = 15;
			while (i-- > 0) {
				swipeWithAxis(300, 700, 300, 200, 2000);
			}
			extentInfoLogs("Click on add warranty");
			clickName(BugRegressionAppConstants.AddWarrantyFromHome_Text);
			extentInfoLogs("Gmail login");
			GmailLogin.gmailLogin();
			extentInfoLogs("Assert for add product header");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.Add_Product_Header_Text).isDisplayed());
		} catch (Exception e) {
			throw (e);
		}
	}

	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
