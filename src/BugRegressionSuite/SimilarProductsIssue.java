package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import App_Functions.RegisteredGmailUser;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;

//Test case info: In this test case we are verifying regarding similar products.
//Similar products must not include products with same name 

/**************** Requirements to run the the test cases ***********************/
// This test case needs to run for Samsung galaxy Grand Neo 8GB Black product
// If this product get removed script will fail

public class SimilarProductsIssue extends BaseTestBugRegression {

	@Override
	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		try {
			//OpenHomePage.openHomePage();
			 //RegisteredGmailUser.gmailUserLogin();
			RegisteredGmailUser.gmailUserLogin();
			clickXpath(BugRegressionAppConstants.MyAccountSearchIcon_xpath);
			sendKeysForName(BugRegressionAppConstants.Search_Bar_textbar_text,
					AppData.EnteredStringInTextBox);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			String text = findElementByName(
					BugRegressionAppConstants.SamsungProductSimilarProductIssue_text)
					.getText();

			for (int i = 0; i < 7; i++) {
				driver.swipe(0, 770, 0, 250, 1000);
			}
			clickId(BugRegressionAppConstants.FirstSimilarProduct_id);
			String text1 = findElementById(
					BugRegressionAppConstants.FirstSimilarProductPagination_id).getText();

			AssertJUnit.assertTrue(text != text1);
			clickClassName(BugRegressionAppConstants.ProductDetailsBackbutton_class);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			for (int i = 0; i < 7; i++) {
				driver.swipe(0, 770, 0, 250, 1000);
			}
			clickId(BugRegressionAppConstants.SecondSimilarProduct_id);
			String text2 = findElementById(
					BugRegressionAppConstants.FirstSimilarProductPagination_id).getText();
			AssertJUnit.assertTrue(text != text2);
			clickClassName(BugRegressionAppConstants.ProductDetailsBackbutton_class);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			for (int i = 0; i < 7; i++) {
				driver.swipe(0, 770, 0, 250, 1000);
			}
			clickId(BugRegressionAppConstants.ThirdSimilarProduct_id);
			String text3 = findElementById(
					BugRegressionAppConstants.FirstSimilarProductPagination_id).getText();
			AssertJUnit.assertTrue(text != text3);
			clickClassName(BugRegressionAppConstants.ProductDetailsBackbutton_class);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			for (int i = 0; i < 7; i++) {
				driver.swipe(0, 770, 0, 250, 1000);
			}
			clickId(BugRegressionAppConstants.FourthSimilarProduct_id);
			String text4 = findElementById(
					BugRegressionAppConstants.FirstSimilarProductPagination_id).getText();
			AssertJUnit.assertTrue(text != text4);
			clickClassName(BugRegressionAppConstants.ProductDetailsBackbutton_class);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			AssertJUnit.assertEquals(
					AppVerificationChecks.SimilarProductsIssue,
					findElementById(
							BugRegressionAppConstants.FirstSimilarProductPagination_id)
							.getText());

			// Assert.assertTrue("value donot match", val!=text);
		} catch (Exception e) {
			e.printStackTrace();
			takeSnapShot("D:\\takeScreenshots",
					"Similar products must not include products with same name ");
			throw (e);
		}

	}

	@Test(enabled = false)
	public void similarProductSamsungIssue() {
		String verifyText = AppData.Lg;
		String verifyText1 = AppData.Fly;

		try {
			OpenHomePage.openHomePage();
			//RegisteredGmailUser.gmailUserLogin();
			clickXpath(BugRegressionAppConstants.MyAccountSearchIcon_xpath);
			sendKeysForName(BugRegressionAppConstants.Search_Bar_textbar_text,
					AppData.EnteredStringInTextBox1);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);

			for (int i = 0; i < 7; i++) {
				swipeWithAxis(0, 770, 0, 250, 1000);
			}

			clickId(BugRegressionAppConstants.FirstSimilarProduct_id);

			String text1 = findElementById(
					BugRegressionAppConstants.FirstSimilarProductPagination_id).getText();
			AssertJUnit.assertTrue(verifyText != text1);
			AssertJUnit.assertTrue(verifyText1 != text1);
			clickClassName(BugRegressionAppConstants.ProductDetailsBackbutton_class);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			for (int i = 0; i < 7; i++) {
				swipeWithAxis(0, 770, 0, 250, 1000);
			}
			clickId(BugRegressionAppConstants.SecondSimilarProduct_id);
			String text2 = findElementById(
					BugRegressionAppConstants.FirstSimilarProductPagination_id).getText();
			AssertJUnit.assertTrue(verifyText != text2);
			AssertJUnit.assertTrue(verifyText1 != text2);
			clickClassName(BugRegressionAppConstants.ProductDetailsBackbutton_class);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			for (int i = 0; i < 7; i++) {
				swipeWithAxis(0, 770, 0, 250, 1000);
			}
			clickId(BugRegressionAppConstants.ThirdSimilarProduct_id);
			String text3 = findElementById(
					BugRegressionAppConstants.FirstSimilarProductPagination_id).getText();
			AssertJUnit.assertTrue(verifyText != text3);
			AssertJUnit.assertTrue(verifyText1 != text3);
			clickClassName(BugRegressionAppConstants.ProductDetailsBackbutton_class);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			for (int i = 0; i < 7; i++) {
				swipeWithAxis(0, 770, 0, 250, 1000);
			}
			clickId(BugRegressionAppConstants.ThirdSimilarProduct_id);
			String text4 = findElementById(
					BugRegressionAppConstants.FirstSimilarProductPagination_id).getText();
			AssertJUnit.assertTrue(verifyText != text4);
			AssertJUnit.assertTrue(verifyText1 != text4);

		} catch (Exception e) {
			e.printStackTrace();
			takeSnapShot("D:\\takeScreenshots", "similar Product Samsung Issue");
			throw (e);

		}

	}

	@Test(enabled = false)
	public void similarEurekaProductIssue() {
		// String verifyText = AppData.Eureka;
		try {
			OpenHomePage.openHomePage();
			//RegisteredGmailUser.gmailUserLogin();
			clickXpath(BugRegressionAppConstants.MyAccountSearchIcon_xpath);
			sendKeysForName(BugRegressionAppConstants.Search_Bar_textbar_text,
					AppData.EnteredStringInTextBox2);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);

			for (int i = 0; i < 7; i++) {
				swipeWithAxis(0, 770, 0, 250, 1000);
			}

			AssertJUnit.assertTrue(findElementById(
					BugRegressionAppConstants.FirstSimilarProduct_id).isEnabled());
			AssertJUnit.assertTrue(findElementById(
					BugRegressionAppConstants.SecondSimilarProduct_id).isEnabled());

		} catch (Exception e) {
			e.printStackTrace();
			takeSnapShot("D:\\takeScreenshots", "Similar Eureka Product issue");
			throw (e);

		}

	}

}
