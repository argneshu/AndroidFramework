package App_Functions;

import org.testng.annotations.Test;

import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;

public class RegisteredGmailUser extends BaseTestBugRegression {

	public static void gmailUserLogin() {
		try {
//			clickClassName(AppConstants.Skip_button);
//			clickName(AppConstants.DetectAutomatically_name);
			OpenHomePage.openHomePage();
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			clickId(BugRegressionAppConstants.NavDrawer_Login_button_id);
			//clickXpath(AppConstants.Google_button_xpath);
			GmailLogin.gmailLogin();
			//clickXpath(AppConstants.Gmail_account_id_option1_xpath);
			//clickId(AppConstants.Gmail_account_ok_button);
			//clickClassName(AppConstants.Back_Arrow_ClassName);
			//clickClassName(AppConstants.Open_Navigation_Drawer);
			//clickId(AppConstants.NavDrawer_Login_button_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(enabled=false)
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

	

}

