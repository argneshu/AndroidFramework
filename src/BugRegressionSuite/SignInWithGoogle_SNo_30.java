package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenHomePage;
import Page_Objects.BugRegressionAppConstants;

public class SignInWithGoogle_SNo_30 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
		try{
//		clickClassName(AppConstants.Skip_button);
//		clickName(AppConstants.DetectAutomatically_name);
//		clickId(AppConstants.SkipButton_id);
//		clickClassName(AppConstants.Open_Navigation_Drawer);
//		clickId(AppConstants.NavDrawer_Login_button_id);
//		clickXpath(AppConstants.Google_button_xpath);
//		clickXpath(AppConstants.Gmail_account_id_option1_xpath);
//		clickId(AppConstants.Gmail_account_ok_button);
			OpenHomePage.openHomePage();
			GmailLogin.gmailLogin();
		AssertJUnit.assertEquals("My Account", driver.findElement(By.name(BugRegressionAppConstants.Myaccount_text)).getText());
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
