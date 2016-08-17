package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenAndroidPage;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;

//Test Case info : In this test cases we are verifying application should not get crashed if application ask for user login 
// while submitting review and clicking on Cart
public class ApplicationCrashIssue extends BaseTestBugRegression {

	@Override
	@Test()
	public void executeTestCase() throws Exception {
		try {
			//OpenHomePage.openHomePage();

			//clickClassName(AppConstants.Open_Navigation_Drawer);
			//clickName(AppConstants.NavDrawer_Mobile_tablets_link);
			//clickId(AppConstants.Android_phones_id);
			OpenAndroidPage.openAndroidPage();
			OpenAndroidPage.clickOnFirstAndroidProduct();
			//clickId(AppConstants.BuyNow_id);
			clickCart();
			GmailLogin.gmailLogin();
			AssertJUnit.assertTrue(AppVerificationChecks.Checkouttext
					.equals(findElementById(BugRegressionAppConstants.CheckoutButton_id)
							.getText()));

		}

		catch (Exception e) {
			takeSnapShot("D:\\takeScreenshots", "Application Crash Issue");
			throw (e);
		}

	}

	@Test(priority=1)
	public void appCrashDuringReviewLogin() throws Exception {
		try {
			OpenAndroidPage.openAndroidPage();
			OpenAndroidPage.clickOnFirstAndroidProduct();
			driver.scrollTo("review");
			clickId(BugRegressionAppConstants.ReadAllReviews_Id);
			clickId(BugRegressionAppConstants.ProductReviewsPencilIcon_id);
			clickName(BugRegressionAppConstants.ReviewProductFiveStarRating_text);
			clearForId(BugRegressionAppConstants.ReviewProductTitle_ID);
			sendKeysForID(BugRegressionAppConstants.ReviewProductTitle_ID, AppData.title1);
//			driver.findElement(By.id(AppConstants.ReviewProductDescription_ID));
			driver.hideKeyboard();
			clearForId(BugRegressionAppConstants.ReviewProductDescription_ID);
			sendKeysForID(BugRegressionAppConstants.ReviewProductDescription_ID,
					AppData.description1);
			driver.hideKeyboard();
			clickName(BugRegressionAppConstants.ReviewProductSubmitButton);
//			OpenHomePage.openHomePage();
//			clickClassName(AppConstants.Open_Navigation_Drawer);
//			clickName(AppConstants.NavDrawer_Mobile_tablets_link);
//			clickId(AppConstants.Android_phones_id);
//			clickXpath(AppConstants.first_android_phone_xpath);
//			for (int i = 0; i < 3; i++) {
//				swipeWithAxis(0, 750, 0, 250, 3000);
//			}
//			clickXpath(AppConstants.SecondViewDetailsLink_xpath);
			GmailLogin.gmailLogin();
			clickClassName(BugRegressionAppConstants.Back_Arrow_ClassName);
			clickName(BugRegressionAppConstants.ReviewProductSubmitButton);
			AssertJUnit.assertTrue(AppVerificationChecks.ReviewProductText
					.equals(findElementByName(BugRegressionAppConstants.ReviewProductText)
							.getText()));
		} catch (Exception e) {
			e.printStackTrace();
			takeSnapShot("D:\takeScreenshots", "appCrashDuringReviewLogin");
			throw (e);
		}

	}
}
