package App_Functions;

import org.testng.annotations.Test;

import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;

public class OpenNavigationDrawer extends BaseTestBugRegression {

	public static void openNavigationDrawer() {
		try {
			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();
			extentInfoLogs("Open Navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
		} catch (Exception e) {
			throw (e);
		}
	}

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
