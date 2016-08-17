package App_Functions;

import org.testng.annotations.Test;

import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;

public class OpenLoginPage extends BaseTestBugRegression {

	public static void openLoginPage() {
		OpenHomePage.openHomePage();
		clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
		clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);

	}

	public static void logOutFromPage() {
		clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
		clickId(BugRegressionAppConstants.SignUpIcon_id);
		clickId(BugRegressionAppConstants.Logout_button_Prod_id);
	}

	@Test(enabled = false)
	public void executeTestCase() throws Exception {

	}
}
