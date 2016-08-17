package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenAndroidPage;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;


//Test case Info: In this test case we are verifying whether the correct validtion label is displayed or not for Email and Contact Number
// Address Page of consumer
public class AddressPageValidationIssue extends BaseTestBugRegression {

	@Override
	@Test
	public void executeTestCase() throws Exception {
		try {
			//OpenHomePage.openHomePage();
			info("Open android page and clicking on first android product");
			OpenAndroidPage.openAndroidPage();
			OpenAndroidPage.clickOnFirstAndroidProduct();
//			int count = 0, loop = 0;
//			String[] android_phone_product_xpath = {
//					AppConstants.first_android_phone_xpath,
//					AppConstants.second_android_phone_xpath,
//					AppConstants.third_android_phone_xpath,
//					AppConstants.fourth_android_phone_xpath };
//			App_Functions.OpenOverflowMenu.openOverflowMenu();
			//App_Functions.RegisteredGmailUser.gmailUserLogin();
			//OpenAndroidPage.openAndroidPage();
			//OpenHomePage.openHomePage();
			//clickClassName(AppConstants.Open_Navigation_Drawer);
			//clickName(AppConstants.NavDrawer_Mobile_tablets_link);
//			OpenAndroidPage.clickOnCategoryByName(AppConstants.Home_Menu_Id,AppConstants.NavDrawer_Mobile_tablets_link);
//			clickId(AppConstants.Android_phones_id);
//			while (count == 0 && loop < 4) {
//
//				clickXpath(android_phone_product_xpath[loop]);
//				try {
//					if (findElementByName(AppConstants.BuyNow_button_text)
//							.isDisplayed())
//
//					{
//						count++;
//						clickName(AppConstants.BuyNow_button_text);
//						GmailLogin.gmailLogin();
//					}
//				} catch (Throwable e) {
//					backButton();
//					loop++;
//					if (loop == 2) {
//						swipeWithAxis(224, 750, 224, 400, 3000);
//					}
//				}
            info("Clicking on buy now");
			clickName(BugRegressionAppConstants.BuyNow_button_text);
			info("");
			GmailLogin.gmailLogin();
			info("");
			clickId(BugRegressionAppConstants.CheckoutButton_id);
			info("");
			clickId(BugRegressionAppConstants.AddNewAdress_id);
			info("");
			sendKeysForID(BugRegressionAppConstants.AddressPageEmail_id,
					AppData.AddressEmailTextboxData);
			info("");
			clickId(BugRegressionAppConstants.AddressPageContactNumber_id);
			info("");
			AssertJUnit.assertTrue(AppVerificationChecks.AddressEmailtext
					.equals(findElementByName(BugRegressionAppConstants.EmailValidation_text)
							.getText()));
			info("");
			sendKeysForID(BugRegressionAppConstants.AddressPageContactNumber_id,
					AppData.AdressContactNumberData);
			info("");
			clickId(BugRegressionAppConstants.AddressPageFullName_id);
			info("");
			navigateBack();
			AssertJUnit.assertTrue(AppVerificationChecks.AddresContactNumber
					.equals(findElementByName(BugRegressionAppConstants.MobileNumber_text)
							.getText()));
System.out.println("asserted");
		} catch (Exception e) {
			e.printStackTrace();
			takeSnapShot("D:\\takeScreenshots", "AddressPageValidationIssue");
			throw (e);
		}

	}

}
