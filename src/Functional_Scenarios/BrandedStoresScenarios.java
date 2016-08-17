package Functional_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenHomePage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;
import Page_Objects.BugRegressionAppConstants;

public class BrandedStoresScenarios extends BaseTestBugRegression {
	String[] storeparam = null;
	String[] nonlfrstore = null;

	@Test(enabled = true)
	public void brandedStoresVerification() throws Exception {
		extentInfoLogs("API execution");
		storeparam = ProductDetailsScenarios.createNewStore();
		nonlfrstore = ProductDetailsScenarios.createnonlfrNewStore();
		for (int i = 0; i < storeparam.length; i++) {
			System.out.println(storeparam[i]);
		}
		ProductDetailsScenarios.getSellQuery("1819", storeparam[1], "2200");
		ProductDetailsScenarios.getSellQuery("1819", nonlfrstore[1], "2199");
		extentInfoLogs("open home page");
		OpenHomePage.openHomePage();
		extentInfoLogs("open nav drawer");
		clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
		extentInfoLogs("clicking on nav drawer location title");
		clickId(BugRegressionAppConstants.NavDrawerLocationTitle_id);
		clickOnCategoryByName(BugRegressionAppConstants.LocatioCity_id, AppData.VadodaraCity);
		extentInfoLogs("clicking on vadodara");
		clickName(BugRegressionAppConstants.VadodaraCity);
		extentInfoLogs("clicking on akota");
		clickName(BugRegressionAppConstants.Akotalocation);
		extentInfoLogs("click on Home");
//		clickId(BugRegressionAppConstants.Homelink_id);
		clickId(BugRegressionAppConstants.HomeSearchtextbox_id);
		extentInfoLogs("click on search textbox");
		sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, AppData.Brandedproduct);
		extentInfoLogs("click on auto suggest product");
		clickId(BugRegressionAppConstants.AutoSuggestSearch_id);
		int i = 0;
		while (i < 3) {
			if (findElementsById(BugRegressionAppConstants.BrandedStorestext_id).size() > 0) {
				Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStorestext_id).size() > 0);
				break;
			} else {
				swipeVertically_FullPage();
			}
			i++;
		}
		if (verifyElementExistById(BugRegressionAppConstants.BrandedStoresViewPricelink_id)) {
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresViewPricelink_id).size() > 0);
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresLogo_id).size() > 0);
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresLocationtext_id).size() > 0);
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresdistancevalue_id).size() > 0);
		} else {
			swipeVertically_FullPage();
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresViewPricelink_id).size() > 0);
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresLogo_id).size() > 0);
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresLocationtext_id).size() > 0);
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresdistancevalue_id).size() > 0);
		}
		extentInfoLogs("click on view price link");
		clickId(BugRegressionAppConstants.BrandedStoresViewPricelink_id);
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.id(BugRegressionAppConstants.BrandedStoresBuyNow_id)));
		Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresBuyNow_id).size() > 0);
		Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresCloseOption_id).size() > 0);
		Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresProductImage_id).size() > 0);
		Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresProductPrice_id).size() > 0);
		Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresProductTitle_id).size() > 0);
		Assert.assertTrue(findElementsById(BugRegressionAppConstants.BrandedStoresStoreAddress_id).size() > 0);
		clickId(BugRegressionAppConstants.BrandedStoresBuyNow_id);
		GmailLogin.gmailLogin();
		Assert.assertTrue(findElementByName(BugRegressionAppConstants.ShoppingCart_Text).getText()
				.contains(AppVerificationChecks.ShoppingCarttext));

	}

	@Test(enabled = false, dependsOnMethods = { "brandedStoresVerification" })
	public void verifyPriceforBrandedStores() throws Exception {
		// nonlfrstore = ProductDetailsScenarios.createnonlfrNewStore();
		// ProductDetailsScenarios.getSellQuery("6180841", nonlfrstore[1],
		// "4999");
		// extentInfoLogs("open home page");
		// OpenHomePage.openHomePage();
		// extentInfoLogs("open nav drawer");
		// clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
		// extentInfoLogs("clicking on nav drawer location title");
		// clickId(BugRegressionAppConstants.NavDrawerLocationTitle_id);
		// clickOnCategoryByName(BugRegressionAppConstants.LocatioCity_id,
		// AppData.VadodaraCity);
		// extentInfoLogs("clicking on vadodara");
		// clickName(BugRegressionAppConstants.VadodaraCity);
		// extentInfoLogs("clicking on akota");
		// clickName(BugRegressionAppConstants.Akotalocation);
		// extentInfoLogs("click on Home");
		// clickId(BugRegressionAppConstants.Homelink_id);
		// clickId(BugRegressionAppConstants.HomeSearchtextbox_id);
		// extentInfoLogs("click on search textbox");
		// sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id,
		// AppData.Brandedproduct);
		// extentPassLogs("click on auto suggest product");
		// clickId(BugRegressionAppConstants.AutoSuggestSearch_id);
		// int i = 0;
		// while (i < 3) {
		// if
		// (findElementsById(BugRegressionAppConstants.BrandedStoresViewPricelink_id)
		// .size() > 0) {
		// Assert.assertTrue(findElementsById(
		// BugRegressionAppConstants.BrandedStoresViewPricelink_id).size() > 0);
		// break;
		// } else {
		// swipeVertically_FullPage();
		// }
		// i++;
		// }

		// ProductDetailsScenarios.purgePriceByStore("6180841", storeparam[1]);
		// ProductDetailsScenarios.purgePriceByStore("6180841", nonlfrstore[1]);
		// ProductDetailsScenarios.deleteStore(nonlfrstore[0]);
		// ProductDetailsScenarios.deleteStore(storeparam[0]);

	}

	@Override
	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
