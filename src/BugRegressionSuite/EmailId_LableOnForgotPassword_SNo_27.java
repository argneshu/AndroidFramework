package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import Page_Objects.BugRegressionAppConstants;

public class EmailId_LableOnForgotPassword_SNo_27 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
	try{	
//		clickClassName(AppConstants.Skip_button);
//		clickName(AppConstants.DetectAutomatically_name);
		OpenHomePage.openHomePage();
		clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
		clickId(BugRegressionAppConstants.NavDrawer_Login_button_id);
		clickId(BugRegressionAppConstants.Forgot_password_id);
		AssertJUnit.assertEquals("Forgot Password", driver.findElement(By.name(BugRegressionAppConstants.Forgot_password_text)).getText());
		AssertJUnit.assertEquals(BugRegressionAppConstants.Email_id_text,driver.findElement(By.name(BugRegressionAppConstants.Email_id_text)).getText());
	}
	catch(Exception e)
	{
		//e.setStackTrace(null);
		e.printStackTrace();
	}

		
	}

}
