package App_Functions;

import org.testng.annotations.Test;

import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;

public class NormalLogin extends BaseTestBugRegression{
	public static void normalLogin()
	{
		sendKeysForID(BugRegressionAppConstants.Login_UserName_Id, AppData.UserId_2);
		sendKeysForID(BugRegressionAppConstants.Login_Password_Id, AppData.Password_userid2);
		clickId(BugRegressionAppConstants.Login_Button_id);
	}

	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
		
	}
}