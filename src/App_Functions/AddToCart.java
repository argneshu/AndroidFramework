package App_Functions;

import org.testng.annotations.Test;

import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;

public class AddToCart extends BaseTestBugRegression {

	public static void addToCart() {
		try {
			if(findElementsById(BugRegressionAppConstants.AddToCartButton_id).size()>0){
				clickId(BugRegressionAppConstants.AddToCartButton_id);
			}

		} catch (Exception e) {
		}
	}

	@Override
	@Test(enabled = false)
	public void executeTestCase() throws Exception {

		// TODO Auto-generated method stub

	}

}
