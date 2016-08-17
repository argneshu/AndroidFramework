package App_Functions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;

public class OpenAndroidPage extends BaseTestBugRegression {

	public static void openAndroidPage() {
		try {
			OpenHomePage.openHomePage();
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			// clickName(AppConstants.NavDrawer_Mobile_tablets_link);
			if (packName.contains("Functional_Scenarios")) {
				clickOnCategoryByName(SanitySuiteAppConstants.Home_Menu_Id,
						BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
				clickId(SanitySuiteAppConstants.Android_phones_id);
			} else {
				clickOnCategoryByName(BugRegressionAppConstants.Home_Menu_Id,
						BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
				clickId(BugRegressionAppConstants.Android_phones_id);
			}
			// clickClassName(AppConstants.Open_Navigation_Drawer);
			// clickName(AppConstants.NavDrawer_Mobile_tablets_link);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	public static void clickOnAndroidProduct_CurrentPage() throws Exception {
		List<WebElement> elements = null;
		try {

			if (packName.contains("Functional_Scenarios")) {
				elements = driver.findElements(By.id(SanitySuiteAppConstants.MyAccountFirstFavouriteProduct_id));
			} else {
				elements = driver.findElements(By.id(BugRegressionAppConstants.MyAccountFirstFavouriteProduct_id));

			}
			for (WebElement elemnt : elements) {
				elemnt.click();

				Thread.sleep(1000);

				clickClassName(BugRegressionAppConstants.ProductDetailsBackbutton_class);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	public static void openAndroidPageFromHomeScreen() {
		try {
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			clickName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			clickId(BugRegressionAppConstants.ProductionAndroid_phones_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	public static String clickOnCategoryByName(String id, String category) {

		try {
			List<WebElement> elements = driver.findElements(By.id(id));
			for (WebElement elemnt : elements) {
				if (elemnt.getText().replace(" ", "").toLowerCase()
						.contains(category.replace(" ", "").toLowerCase())) {
					elemnt.click();
					break;
				}
			}
		} catch (Exception e) {
			throw (e);
		}
		return category;
	}

	public static String clickOnFirstAndroidProduct() {
		String productName = null;
		// String packageName = BaseTestBugRegression.packName;
		List<WebElement> elements = null;
		try {
			if (packName.contains("Functional_Scenarios")) {

				elements = driver.findElements(By.id(SanitySuiteAppConstants.MyAccountFirstFavouriteProductName_id));
			} else {
				elements = driver.findElements(By.id(BugRegressionAppConstants.MyAccountFirstFavouriteProduct_id));
				wait.until(ExpectedConditions.visibilityOf(
						findElementsById(SanitySuiteAppConstants.MyAccountFirstFavouriteProductName_id).get(0)));
				elements = findElementsById(SanitySuiteAppConstants.MyAccountFirstFavouriteProductName_id);
			}
			// System.out.println(elements);
			for (WebElement elemnt : elements) {
				productName = elemnt.getText().trim().toString();
				// System.out.println("product name : " + productName);
				elemnt.click();
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		return productName;
	}

	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
