package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import Page_Objects.BugRegressionAppConstants;

import com.relevantcodes.extentreports.LogStatus;

public class CartConnectionError_SNo_25 extends BaseTestBugRegression {

	@Test
	public void executeTestCase() throws Exception {
		try {
			logger = report.startTest("Cart connection error");

			// clickId(AppConstants.Lets_Go_Shopping_Id);
			// clickName(AppConstants.DetectAutomatically_name);
			
			logger.log(LogStatus.INFO, "Open Home page");
			OpenHomePage.openHomePage();
			
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			logger.log(LogStatus.INFO, "Click on navigation drawer icon");
			
			clickId(BugRegressionAppConstants.NavDrawer_Login_button_id);
			logger.log(LogStatus.INFO, "Click on navigation login button");
			
			clearForName(BugRegressionAppConstants.Email_name);
			logger.log(LogStatus.INFO, "Clear email field");
			
			Thread.sleep(2000);
			sendKeysForName(BugRegressionAppConstants.Email_name, "vinay.kumar@zopper.com");
			logger.log(LogStatus.INFO, "Enter email id");
			
			// sendKeysForXpath(AppConstants.Password_xpath,"shashank@24");
			sendKeysForID(BugRegressionAppConstants.login_passwd_id, "zopper");
			logger.log(LogStatus.INFO, "Enter password");
			
			Thread.sleep(5000);
			clickName(BugRegressionAppConstants.LoginButton_name);
			logger.log(LogStatus.INFO, "Click on login button");
			
			clickClassName(BugRegressionAppConstants.Back_Arrow_ClassName);
			logger.log(LogStatus.INFO, "Click on back arrow");
			
			Assert.assertEquals("Home", driver.findElement(By.name("Home")).getText());
			logger.log(LogStatus.INFO, "Assert home");
			
			clickId(BugRegressionAppConstants.Cart_id);
			logger.log(LogStatus.INFO, "Click on card id");
			
			Assert.assertEquals(BugRegressionAppConstants.ShoppingCart_Text,
					driver.findElement(By.name("Shopping Cart")).getText());
			logger.log(LogStatus.PASS, "Cart connection error");
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}

}
