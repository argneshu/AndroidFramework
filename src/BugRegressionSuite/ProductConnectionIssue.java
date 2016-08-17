package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.RegisteredGmailUser;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;

//Test case info : In this test case we need to verify that Micromax 32 inch 32B200HD LED TV product should not throw connection error issue
public class ProductConnectionIssue extends BaseTestBugRegression {

	@Override
	@Test
	public void executeTestCase() throws Exception {
		try {
			RegisteredGmailUser.gmailUserLogin();
			clickClassName(BugRegressionAppConstants.Back_Arrow_ClassName);
			clickName(BugRegressionAppConstants.Search_Bar_textbar_text);
			sendKeysForID(BugRegressionAppConstants.Search_Bar_textbar_id, "micromax led");
			//OpenHomePage.openHomePage();
			//sendKeysForID(AppConstants.Home_Search_box_id, "Micromax led");
			clickName("micromax led tv");
			clickName("Micromax 32T7250 32 Inch HD Ready LED TV");
			clickXpath(BugRegressionAppConstants.MyAccountSearchIcon_xpath);
			sendKeysForName(BugRegressionAppConstants.Search_Bar_textbar_text,
					AppData.EnteredStringInTextBox3);
			clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			AssertJUnit.assertTrue(AppData.EnteredStringInTextBox3
					.equals(findElementById(
							BugRegressionAppConstants.FirstSimilarProductPagination_id)
							.getText()));

		} catch (Exception e) {
			e.printStackTrace();
			takeSnapShot("D:\\takeScreenshots", "Product Connection issue");
			throw (e);
		}

	}

}
