package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import App_Functions.RegisteredGmailUser;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;

//Test case: submitting review for Special characters. This test case
// should be execute for already registered user in mobile device

/**************** Requirements to run the the test cases ***********************/
// Can use account(zopper.test@gmail.com)
// One review should be added in app for login user
// Wifi should be open in app
// Review for symphony ninja product should be submitted only 4 characters like
// (....)

public class ReviewWithSpecialCharacters extends BaseTestBugRegression {

	@Override
	@Test
	public void executeTestCase() throws Exception {
		try {
			RegisteredGmailUser.gmailUserLogin();
			clickClassName(BugRegressionAppConstants.Back_Arrow_ClassName);
			clickName(BugRegressionAppConstants.Search_Bar_textbar_text);
			sendKeysForID(BugRegressionAppConstants.Search_Bar_textbar_id, "symphony");
			//System.out.println("clicking symphony");
			clickName("symphony air cooler");
			//System.out.println("clicked symphony");
			clickName("Symphony Air Cooler winter");
			driver.scrollTo("review");
			//System.out.println(driver.findElement(By.name("No Reviews")).getText());
			//Thread.sleep(5000);
			if(driver.findElements(By.name("No Reviews")).size()>0)
					{
						clickId(BugRegressionAppConstants.WriteAReview_Id);
						clickName(BugRegressionAppConstants.ReviewProductFiveStarRating_text);
						clearForId(BugRegressionAppConstants.ReviewProductTitle_ID);
						sendKeysForID(BugRegressionAppConstants.ReviewProductTitle_ID, AppData.title1);
//						driver.findElement(By.id(AppConstants.ReviewProductDescription_ID));
						driver.hideKeyboard();
						clearForId(BugRegressionAppConstants.ReviewProductDescription_ID);
						sendKeysForID(BugRegressionAppConstants.ReviewProductDescription_ID,
								AppData.description1);
						driver.hideKeyboard();
						clickName(BugRegressionAppConstants.ReviewProductSubmitButton); 						
						
					}
			else
			{
				System.out.println("reached else");
				clickId(BugRegressionAppConstants.ReadAllReviews_Id);
				clickId(BugRegressionAppConstants.ProductReviewsPencilIcon_id);
				clickName(BugRegressionAppConstants.ReviewProductFiveStarRating_text);
				clearForId(BugRegressionAppConstants.ReviewProductTitle_ID);
				sendKeysForID(BugRegressionAppConstants.ReviewProductTitle_ID, AppData.title1);
//				driver.findElement(By.id(AppConstants.ReviewProductDescription_ID));
				driver.hideKeyboard();
				clearForId(BugRegressionAppConstants.ReviewProductDescription_ID);
				sendKeysForID(BugRegressionAppConstants.ReviewProductDescription_ID,
						AppData.description1);
				driver.hideKeyboard();
				clickName(BugRegressionAppConstants.ReviewProductSubmitButton);
				System.out.println("submitted");
				//navigateBack();
				System.out.println("clicking back");
				clickClassName(BugRegressionAppConstants.Back_Arrow_ClassName);
			}
//			OpenHomePage.openHomePage();
//			clickXpath(AppConstants.MyAccountSearchIcon_xpath);
//			sendKeysForName(AppConstants.Search_Bar_textbar_text,
//					AppData.SubmitReviewTestData);
//			clickXpath(AppConstants.SuggestedProductForSubmitReviewScenario);
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
//			sendKeysForID(AppConstants.ReviewProductTitle_ID, AppData.title1);
//			navigateBack();
//			if (findElementById(AppConstants.ReviewProductDescription_ID)
//					.isDisplayed())
//				;
//			{
//				clearForId(AppConstants.ReviewProductDescription_ID);
//			}
//			sendKeysForID(AppConstants.ReviewProductDescription_ID,
//					AppData.description1);
//
//			navigateBack();
//
//			clickName(AppConstants.ReviewProductSubmitButton);
//			// MobileElement element = (MobileElement)
//			// driver.findElement(By.className("android.widget.ImageButton"));
//			// wait.until(ExpectedConditions.elementToBeClickable(element));
//			Thread.sleep(2000);
//			clickClassName(AppConstants.ProductReviewsBackbutton_class);
//			Thread.sleep(2000);
//			for (int i = 0; i < 2; i++) {
//				swipeWithAxis(0, 750, 0, 250, 3000);
//			}
//
//			clickXpath(AppConstants.SecondViewDetailsLink_xpath);
//			Assert.assertEquals(AppVerificationChecks.ReviewWithSpecialChar,
//					findElementById(AppConstants.ProductReviewsAddedTitle_id)
//							.getText());
		} catch (Exception e) {
			e.printStackTrace();
			takeSnapShot("D:\\takeScreenshots",
					"Review with special character ");
			throw (e);
		}

	}

}
