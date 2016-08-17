package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenLoginPage;
import Page_Objects.BugRegressionAppConstants;

public class UserNameTapping_SNo_32 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
		try{
			OpenLoginPage.openLoginPage();
			GmailLogin.gmailLogin();
//			clickClassName(AppConstants.Skip_button);
//			clickName(AppConstants.DetectAutomatically_name);
//			clickXpath(AppConstants.Google_button_xpath);
//			clickXpath(AppConstants.Gmail_account_id_option2_xpath);
//			clickId(AppConstants.Gmail_account_ok_button);
			clickClassName(BugRegressionAppConstants.Back_Arrow_ClassName);
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			clickId(BugRegressionAppConstants.NavDrawer_Login_button_id);
			AssertJUnit.assertEquals("My Account", driver.findElement(By.name(BugRegressionAppConstants.Myaccount_text)).getText());
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
