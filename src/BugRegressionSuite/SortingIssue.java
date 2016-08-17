package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenAndroidPage;
import Page_Objects.BugRegressionAppConstants;

//Test case info : In this test case we are verifying sorting filters are working as expected

public class SortingIssue extends BaseTestBugRegression {

	@Override
	@Test
	public void executeTestCase() throws Exception {
		try{
		OpenAndroidPage.openAndroidPage();
		//clickId(AppConstants.Android_phones_id);
		clickId(BugRegressionAppConstants.AndroidPhonesSortingButton_id);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("com.zopperapp.dev:id/layout_product_sort")));
		clickName(BugRegressionAppConstants.LTH);
		String text = findElementById(BugRegressionAppConstants.PriceOfFirstProduct_id)
				.getText();
		System.out.println(text);
		clickId(BugRegressionAppConstants.AndroidPhonesSortingButton_id);
		clickName(BugRegressionAppConstants.HTL);
		String text1 = findElementById(BugRegressionAppConstants.PriceOfFirstProduct_id)
				.getText();
		System.out.println(text1);
		AssertJUnit.assertTrue(text != text1);
		}catch(Exception e){
			e.printStackTrace();
			takeSnapShot("D:\\takeScreenshots", "Sorting issue");
			throw(e);
		}

	}

}
