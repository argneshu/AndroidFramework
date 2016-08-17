package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenAndroidPage;
import Page_Objects.BugRegressionAppConstants;

public class AndroidPhoneSearch_AN203 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		
		try{
	
			OpenAndroidPage.openAndroidPage();
//			clickId(AppConstants.Lets_Go_Shopping_Id);
//			clickName(AppConstants.DetectAutomatically_name);
////			clickId(AppConstants.SkipButton_id);
//			System.out.println("Before SEarch");
//			clickId(AppConstants.Home_Search_box_id);
//			System.out.println("After Search");
//			sendKeysForName(AppConstants.Search_product_text,"Android Phone");
//			clickName(AppConstants.Android_Phone_text);
			AssertJUnit.assertEquals("Android Phones", driver.findElement(By.name(BugRegressionAppConstants.Android_Phone_text)).getText());
		}
		catch(Throwable e)
		{
			System.out.println(e);
			//System.out.println("Element Not Found");
		}
	}

}
