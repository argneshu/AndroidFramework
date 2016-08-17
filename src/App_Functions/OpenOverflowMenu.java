package App_Functions;

import org.testng.annotations.Test;

import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;

public class OpenOverflowMenu extends BaseTestBugRegression{
	
	public static void openOverflowMenu(){
		OpenHomePage.openHomePage();
		clickName(BugRegressionAppConstants.HomeOverflow_name);
	}

	@Override
	@Test(enabled=false)
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
