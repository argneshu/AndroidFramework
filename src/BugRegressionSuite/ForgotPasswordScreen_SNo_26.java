package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenLoginPage;
import Page_Objects.BugRegressionAppConstants;

public class ForgotPasswordScreen_SNo_26 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
		try{
		OpenLoginPage.openLoginPage();
		clickId(BugRegressionAppConstants.Forgot_password_id);
		AssertJUnit.assertEquals("SUBMIT", driver.findElement(By.name(BugRegressionAppConstants.submit_button_text)).getText());
		AssertJUnit.assertEquals(BugRegressionAppConstants.submit_button_text,driver.findElement(By.name(BugRegressionAppConstants.submit_button_text)).getText());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
