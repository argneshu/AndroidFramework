package App_Functions;

import org.testng.annotations.Test;

import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;

//This function is created to handle the Gmail login from Login page
public class GmailLogin extends BaseTestBugRegression {

	public static void gmailLogin() {
		String pckgeName = BaseTestBugRegression.packName;

		try {
			if (pckgeName.contains("Functional_Scenarios")) {
				clickId(SanitySuiteAppConstants.Google_SignInId);
			} else {
				clickId(BugRegressionAppConstants.Google_SignInId);
			}

			clickXpath(BugRegressionAppConstants.Gmail_account_id_option2_xpath);
			clickId(BugRegressionAppConstants.Gmail_account_ok_button);


		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
