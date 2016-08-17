package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.RegisteredGmailUser;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;

//Test case info: Submitting review for Symphony Ninja product. This test case should be execute for already registered user in mobile device

/**************** Requirements to run the the test cases ***********************/
// Can use account(zopper.test@gmail.com)
// For login user One review should be added in app Symphony Ninja product
// Wifi should be open in app
// Review for symphony ninja product should be submitted only 1 characters like
// (.) or a

public class SubmitReview extends BaseTestBugRegression {

	@Override
	@Test
	public void executeTestCase() throws Exception {
		try {
			RegisteredGmailUser.gmailUserLogin();
			clickClassName(BugRegressionAppConstants.Back_Arrow_ClassName);
			clickName(BugRegressionAppConstants.Search_Bar_textbar_text);
			sendKeysForID(BugRegressionAppConstants.Search_Bar_textbar_id, "symphony cooler");
			clickName("symphony air cooler");
			clickName("Symphony Sumo Air Cooler");
			driver.scrollTo("review");
			clickId(BugRegressionAppConstants.ReadAllReviews_Id);
			clickId(BugRegressionAppConstants.ProductReviewsPencilIcon_id);
			clickName(BugRegressionAppConstants.ReviewProductFiveStarRating_text);
			clearForId(BugRegressionAppConstants.ReviewProductTitle_ID);
			sendKeysForID(BugRegressionAppConstants.ReviewProductTitle_ID, AppData.title);
//			driver.findElement(By.id(AppConstants.ReviewProductDescription_ID));
			driver.hideKeyboard();
			clearForId(BugRegressionAppConstants.ReviewProductDescription_ID);
			sendKeysForID(BugRegressionAppConstants.ReviewProductDescription_ID,
					AppData.description);
			driver.hideKeyboard();
			clickName(BugRegressionAppConstants.ReviewProductSubmitButton);
			System.out.println("submitted");
			//navigateBack();
			System.out.println("clicking back");
			clickClassName(BugRegressionAppConstants.Back_Arrow_ClassName);
			System.out.println("clicked back");
			driver.scrollTo("review");
			AssertJUnit.assertEquals(findElementById(BugRegressionAppConstants.ReviewText_Id).getText(), AppData.title);
			System.out.println(findElementById(BugRegressionAppConstants.ReviewText_Id).getText());
			//clickXpath(AppConstants.SuggestedProductForSubmitReviewScenario);
			// scrollTo(AppData.ReviewString);
//			for (int i = 0; i < 3; i++) {
//				swipeWithAxis(0, 750, 0, 250, 3000);
//			}
//
//			clickXpath(AppConstants.SecondViewDetailsLink_xpath);
//
//			clickId(AppConstants.ProductReviewsPencilIcon_id);
//			GmailLogin.gmailLogin();
//			clickName(AppConstants.ReviewProductFiveStarRating_text);
//			if (findElementById(AppConstants.ReviewProductTitle_ID)
//					.isDisplayed())
//				;
//			{
//				clearForId(AppConstants.ReviewProductTitle_ID);
//			}
//
//			sendKeysForID(AppConstants.ReviewProductTitle_ID, AppData.title);
//
//			navigateBack();
//			if (findElementById(AppConstants.ReviewProductDescription_ID)
//					.isDisplayed())
//				;
//			{
//				clearForId(AppConstants.ReviewProductDescription_ID);
//			}
//
//			sendKeysForID(AppConstants.ReviewProductDescription_ID,
//					AppData.description);
//
//			navigateBack();
//
//			clickName(AppConstants.ReviewProductSubmitButton);
//			//driver1.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
//			Thread.sleep(2000);
//			clickClassName(AppConstants.ProductReviewsBackbutton_class);
//			//driver1.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
//			Thread.sleep(2000);
//
//			for (int i = 0; i < 2; i++) {
//				swipeWithAxis(0, 750, 0, 250, 3000);
//			}
//			clickXpath(AppConstants.SecondViewDetailsLink_xpath);
//			Assert.assertEquals(AppVerificationChecks.SubmitReviewCheck,
//					findElementById(AppConstants.ProductReviewsAddedTitle_id)
//							.getText());

		} catch (Exception e) {
			takeSnapShot("D:\\takeScreenshots", "Submit Review");
			e.printStackTrace();
			throw (e);

		}

	}

}
