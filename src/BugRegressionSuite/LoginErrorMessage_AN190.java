package BugRegressionSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.OpenLoginPage;
import Page_Objects.BugRegressionAppConstants;

public class LoginErrorMessage_AN190 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		
		try{
//			clickClassName(AppConstants.Skip_button);
//			clickName(AppConstants.DetectAutomatically_name);
			OpenLoginPage.openLoginPage();
			sendKeysForName(BugRegressionAppConstants.Email_name, "vinay.kumar@zopper.com");
			sendKeysForID(BugRegressionAppConstants.login_passwd_id,"zoppe");
			Thread.sleep(5000);
			clickName(BugRegressionAppConstants.LoginButton_name);
			Assert.assertEquals("Login", findElementByName(BugRegressionAppConstants.Login_text).getText());
	
		}
		catch(Throwable e){
			//e.printStackTrace();
			System.out.println("Inside Outer Catch");
		}
	}

}

