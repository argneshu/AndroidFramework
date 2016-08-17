package App_Functions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;

//This function is used to open Homepage of application

public class OpenHomePage extends BaseTestBugRegression  {
	static boolean staging = false;

	public static void openHomePage() {
		
		try {
			if (packName.contains("Functional_Scenarios")) {
				if(findElementsById(BugRegressionAppConstants.Lets_Go_Shopping_Id).size()>0){
				clickId(BugRegressionAppConstants.Lets_Go_Shopping_Id);
				}
			} else {
				if(findElementsById(BugRegressionAppConstants.Prod_Lets_Go_Shopping_Id).size()>0){
				clickId(BugRegressionAppConstants.Prod_Lets_Go_Shopping_Id);
				}
			}
			if (verifyElementExistByName(BugRegressionAppConstants.DetectAutomatically_name))
				clickName(BugRegressionAppConstants.DetectAutomatically_name);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	public static void clickOnCategoryByName(String category) {
		List<WebElement> elements = null;

		try {
			elements = driver.findElements(By.id(SanitySuiteAppConstants.NavDrawerCategories_id));
			for (WebElement elemnt : elements) {
				if (elemnt.getText().equalsIgnoreCase(category)) {
					elemnt.click();
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public static void goToHomePage() {
		try {
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			clickId(BugRegressionAppConstants.Homelink_Prod_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	public static void clickOnFirstIndex(String id) {
		try {
			List<WebElement> elements = driver.findElements(By.id(id));
			for (WebElement ele : elements) {
				ele.click();
				break;
			}
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
