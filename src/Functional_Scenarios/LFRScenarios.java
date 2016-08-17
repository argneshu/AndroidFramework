
package Functional_Scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;

public class LFRScenarios extends BaseTestBugRegression {

	@Override
	@Test(enabled = true)
	public void executeTestCase() throws Exception {
		try {
			extentInfoLogs("click on home page");
			OpenHomePage.openHomePage();
			int i = 0;
			while (i < 20) {
				extentInfoLogs("searching for lfr stores");
				if (findElementsByName(SanitySuiteAppConstants.PartnersStorestext_name)
						.size() > 0) {
					try{
					Assert.assertTrue(findElementById(
							SanitySuiteAppConstants.LFRStore_id).isDisplayed());
					}catch(Exception e){
						swipeVertically_FullPage();
						Assert.assertTrue(findElementById(
								SanitySuiteAppConstants.LFRStore_id).isDisplayed());
					}
					break;
				} else {
					swipeVertically_FullPage();
				}
				i++;
			}

		} catch (Exception e) {
			throw(e);
		}

	}
	
	@Test(enabled = true)
	public void clickOnLFRLogo(){
		try{
			extentInfoLogs("click on home page");
			OpenHomePage.openHomePage();
			int i = 0;
			while (i < 20) {
				extentInfoLogs("searching for lfr stores");
				if (findElementsByName(SanitySuiteAppConstants.PartnersStorestext_name)
						.size() > 0) {
					try{
					Assert.assertTrue(findElementById(
							SanitySuiteAppConstants.LFRStore_id).isDisplayed());
					}catch(Exception e){
						swipeVertically_FullPage();
						Assert.assertTrue(findElementById(
								SanitySuiteAppConstants.LFRStore_id).isDisplayed());
					}
					clickId(SanitySuiteAppConstants.LFRStore_id);
					Assert.assertTrue(findElementByClassName(BugRegressionAppConstants.BackButton_class).isDisplayed());
					clickClassName(BugRegressionAppConstants.BackButton_class);
					Assert.assertTrue(findElementByName(SanitySuiteAppConstants.PartnersStorestext_name).isDisplayed());
					break;
				} else {
					swipeVertically_FullPage();
				}
				i++;
			}
			
		}catch(Exception e){
			throw(e);
		}
	}

}
