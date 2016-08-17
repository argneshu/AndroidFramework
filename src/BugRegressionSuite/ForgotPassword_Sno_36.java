package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenLoginPage;
import Page_Objects.BugRegressionAppConstants;

public class ForgotPassword_Sno_36 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
	try{
//		clickClassName(AppConstants.Skip_button);
//		clickName(AppConstants.DetectAutomatically_name);
		OpenLoginPage.openLoginPage();
		clickId(BugRegressionAppConstants.Forgot_password_id);
		AssertJUnit.assertEquals("Forgot Password", driver.findElement(By.name(BugRegressionAppConstants.Forgot_password_text)).getText());
		sendKeysForName(BugRegressionAppConstants.Email_id_text,"vinay.kumar@zopper.com");
		clickName(BugRegressionAppConstants.submit_button_text );
//		WebDriver driver1 = new FirefoxDriver();
//		driver1.get("http://www.gmail.com");
		
		AssertJUnit.assertEquals("LOGIN", driver.findElement(By.name(BugRegressionAppConstants.Login_text)).getText());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

		
	}

}

