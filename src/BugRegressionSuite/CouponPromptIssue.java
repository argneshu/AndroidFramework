package BugRegressionSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenAndroidPage;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;

//Test case info : In this test case we are verifying that correct error is displayed for invalid coupon code
//@SuppressWarnings("deprecation")
public class CouponPromptIssue extends BaseTestBugRegression {

	@Override
	@Test
	public void executeTestCase() throws Exception {
//		try {
//			OpenAndroidPage.openAndroidPage();
//			clickId(AppConstants.Android_phones_id);
//			clickXpath(AppConstants.first_android_phone_xpath);
//			try {
//				if (findElementByName(AppConstants.BuyNow_button_text)
//						.isDisplayed()) {
//					clickName(AppConstants.BuyNow_button_text);
//					GmailLogin.gmailLogin();
//					
//
//				} else {
//					System.out.println("Get prices button is displayed");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw (e);
//			}
//			sendKeysForID(AppConstants.CouponTextbox_id,
//					AppData.CouponTextboxData);
//			clickId(AppConstants.CouponApplyButton_id);
//			Assert.assertTrue(AppVerificationChecks.CouponErrorText
//					.equals(findElementById(AppConstants.CouponError_id)
//							.getText()));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			takeSnapShot("D:\\takeScreenshots", "Coupon Pormpt Issue");
//			throw (e);
//		}
//
//	}


try {
	OpenAndroidPage.openAndroidPage();
	OpenAndroidPage.clickOnCategoryByName(BugRegressionAppConstants.Home_Menu_Id,BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
	OpenAndroidPage.clickOnFirstAndroidProduct();
	clickName(BugRegressionAppConstants.BuyNow_button_text);
	GmailLogin.gmailLogin();
	sendKeysForID(BugRegressionAppConstants.CouponTextbox_id,
			AppData.CouponTextboxData);
	clickId(BugRegressionAppConstants.CouponApplyButton_id);
	Assert.assertTrue(AppVerificationChecks.CouponErrorText
			.equals(findElementById(BugRegressionAppConstants.CouponError_id)
					.getText()));
}
catch(Exception e)
{
	e.printStackTrace();
	}
	
}}
