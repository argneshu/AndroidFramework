package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenLoginPage;
import Page_Objects.BugRegressionAppConstants;

public class AlreadyHaveAnAccount_Login_SNo_38 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		
		try{
			info("");
		OpenLoginPage.openLoginPage();
//			clickId(AppConstants.Lets_Go_Shopping_Id);
//			clickName(AppConstants.DetectAutomatically_name);
//			clickClassName(AppConstants.Open_Navigation_Drawer);
		info("");
		clickName(BugRegressionAppConstants.SignUP_name);
		info("");
			clickId(BugRegressionAppConstants.SignUp_already_have_acc_id);
			info("");
			AssertJUnit.assertEquals("LOGIN", driver.findElement(By.name(BugRegressionAppConstants.Login_text)).getText());
			
		}
		catch(Throwable e){
			e.printStackTrace();
		}
	}

}
