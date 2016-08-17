package Functional_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.AddToCart;
import App_Functions.GmailLogin;
import App_Functions.OpenAndroidPage;
import App_Functions.OpenHomePage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;

//Test case info:In this test case we are Ola money scenarios
//In first test  case we are verifying different options which are displayed on OLA money page
//Author:Argneshu Gupta
public class OLAMoneyScenarios extends BaseTestBugRegression {

	@Override
	@Test(enabled = true)
	public void executeTestCase() throws Exception {
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();

			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("open navigation drawer");

			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			extentInfoLogs("click on Mobile and tablets link");
			extentInfoLogs("click on android phones");
			//clickName(BugRegressionAppConstants.AndroidPhones_name);
			clickByName(BugRegressionAppConstants.SmartphoneName, BugRegressionAppConstants.SmartphoneName);

			//clickName(BugRegressionAppConstants.AndroidPhones_name);
			extentInfoLogs("click on first android phones");
			OpenAndroidPage.clickOnFirstAndroidProduct();
			clickXpath(BugRegressionAppConstants.ProductDetailsVarBuyNow_xpath);
			extentInfoLogs("clicking on Buy Now button");
			AddToCart.addToCart();
			Assert.assertEquals(findElementByName(BugRegressionAppConstants.Login_text).getText(),
					AppVerificationChecks.Logintext);
			extentInfoLogs("verifying assertion");
			extentInfoLogs("Gmail login");
			GmailLogin.gmailLogin();
			clickId(BugRegressionAppConstants.ProductionCheckoutButton_id);
			extentInfoLogs("clicking on checkout button");

			if (findElementsById(SanitySuiteAppConstants.Shipping_FullName_Id).size() > 0) {
				extentInfoLogs("Enter user name in shipping address");
				sendKeysForID(SanitySuiteAppConstants.Shipping_FullName_Id, AppData.Shipping_UserName);
				extentInfoLogs("Enter address in shipping address");
				sendKeysForID(SanitySuiteAppConstants.Shipping_Address_Id, AppData.ShippingAddress);
//				extentInfoLogs("Enter Pincode in shipping address");
//				sendKeysForID(SanitySuiteAppConstants.Shipping_Pincode_Id, AppData.ShippingPincode);
				extentInfoLogs("Click on save button");
				clickId(SanitySuiteAppConstants.Shipping_SaveButton_Id);
			}

			clickId(BugRegressionAppConstants.ProductionContinueButton_id);
			extentInfoLogs("clicking on continue button");
			Thread.sleep(5000);
			swipeVertically(300);
			clickOnCategoryByName(BugRegressionAppConstants.AllPaymentMode_id, AppData.OlaMoney);
			// clickName(BugRegressionAppConstants.OlaMoneyIcon_name);
			extentInfoLogs("clicking on Ola Money");
			extentInfoLogs("Assert for Ola debit card name");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.OLADEBITCREDITCARDS_name).getText()
					.equals(AppVerificationChecks.OLADEBITCREDITCARDS));
			extentInfoLogs("Assert for Ola net banking name");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.OLANETBANKING_name).getText()
					.equals(AppVerificationChecks.OLANETBANKING));
			extentInfoLogs("Assert for Ola amount");
			Assert.assertTrue(findElementById(BugRegressionAppConstants.OLAAmount_id).isDisplayed());
			extentInfoLogs("Assert for Ola balance");
			Assert.assertTrue(findElementById(BugRegressionAppConstants.OLABalance_id).isDisplayed());

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);

		}

	}
	
	@Test(enabled = true)
	public void olaWalletMoney() throws Exception
	{
		try{
		extentInfoLogs("launching ola app");
		Thread.sleep(5000);
		driver.startActivity("com.olacabs.customer", "com.olacabs.customer.ui.SplashActivity");
		clickId(SanitySuiteAppConstants.OlaNavDrawer);
		clickName(SanitySuiteAppConstants.OlaMoney);
		String olaWallet = findElementById(SanitySuiteAppConstants.OlaMoneyBalance).getText();
		System.out.println(olaWallet);
//		String olaWalletText = olaWallet.split("\\₹")[1];
		if(BugRegressionAppConstants.buildType.contains(".staging")){
		driver.startActivity("com.zopperapp.staging", "com.zopper.aegon.ui.activity.SplashActivity");
		}else{
			driver.startActivity("com.zopperapp", "com.zopper.aegon.ui.activity.SplashActivity");
		}
		//Thread.sleep(2000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id(BugRegressionAppConstants.Prod_Lets_Go_Shopping_Id)));
		if(findElementsByName(BugRegressionAppConstants.LetsGoShopping_name).size()>0){
			clickName(BugRegressionAppConstants.LetsGoShopping_name);
		}
		clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
		extentInfoLogs("open navigation drawer");
		OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
		extentInfoLogs("click on Mobile and tablets link");
		extentInfoLogs("click on android phones");
		clickByName(BugRegressionAppConstants.SmartphoneName, BugRegressionAppConstants.SmartphoneName);

		extentInfoLogs("click on first android phones");
		OpenAndroidPage.clickOnFirstAndroidProduct();
		clickXpath(BugRegressionAppConstants.ProductDetailsVarBuyNow_xpath);
		extentInfoLogs("clicking on Buy Now button");
		AddToCart.addToCart();
		Assert.assertEquals(findElementByName(BugRegressionAppConstants.Login_text).getText(),
				AppVerificationChecks.Logintext);
		extentInfoLogs("verifying assertion");
		extentInfoLogs("Gmail login");
		GmailLogin.gmailLogin();
		clickId(BugRegressionAppConstants.ProductionCheckoutButton_id);
		extentInfoLogs("clicking on checkout button");

		if (findElementsById(SanitySuiteAppConstants.Shipping_FullName_Id).size() > 0) {
			extentInfoLogs("Enter user name in shipping address");
			sendKeysForID(SanitySuiteAppConstants.Shipping_FullName_Id, AppData.Shipping_UserName);
			extentInfoLogs("Enter address in shipping address");
			sendKeysForID(SanitySuiteAppConstants.Shipping_Address_Id, AppData.ShippingAddress);
			extentInfoLogs("Enter Pincode in shipping address");
			sendKeysForID(SanitySuiteAppConstants.Shipping_Pincode_Id, AppData.ShippingPincode);
			extentInfoLogs("Click on save button");
			clickId(SanitySuiteAppConstants.Shipping_SaveButton_Id);
		}

		clickId(BugRegressionAppConstants.ProductionContinueButton_id);
		extentInfoLogs("clicking on continue button");
		Thread.sleep(5000);
		swipeVertically(300);
		clickOnCategoryByName(BugRegressionAppConstants.AllPaymentMode_id, AppData.OlaMoney);
		Assert.assertTrue(findElementById(SanitySuiteAppConstants.UtilizeOlaWalletMoney).getText().split("\\₹")[1].replaceAll("\\)", "").trim().equalsIgnoreCase(olaWallet.trim()));
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
}
