package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import Page_Objects.BugRegressionAppConstants;

public class AN_184 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		
		try{
	
			OpenHomePage.openHomePage();
			//driver.swipe(335, 35, 335, 558, 2000);
//			clickId(AppConstants.Lets_Go_Shopping_Id);
//			clickName(AppConstants.DetectAutomatically_name);
			//clickId(AppConstants.SkipButton_id);
			//System.out.println("Before SEarch");
			//clickXpath(AppConstants.Home_search_button_xpath);
			clickId(BugRegressionAppConstants.Home_Search_box_id);
//			sendKeysForName(BugRegressionAppConstants.Search_product_text,"Hitachi");
			AssertJUnit.assertEquals("hitachi", findElementByXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario).getText());
			System.out.println("Text matched ");
		}
		catch(Throwable e)
		{
			System.out.println(e);
			//System.out.println("Element Not Found");
		}
	}

}
