package Functional_Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

//Test case info:In this test case we are  verifying multiple cases
//In first test case we are verifying store details on Cart
//In second test case we are verifying cart should get empty on changing location
//In third case 
//Author : Argneshu Gupta

public class CartScenarios extends BaseTestBugRegression {

	@Override
	@Test(enabled = true, priority = 1)
	public void executeTestCase() throws Exception {
		try {
			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();
			extentInfoLogs("open navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			info("open navigation drawer");
			extentInfoLogs("click on Mobiles and Tablets link");
			OpenHomePage
					.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			info("click on Mobile and tablets link");

			extentInfoLogs("Open Android phone category");
			clickByName(BugRegressionAppConstants.SmartphoneName,
					BugRegressionAppConstants.SmartphoneName);

			extentInfoLogs("click On First Android Product");
			OpenAndroidPage.clickOnFirstAndroidProduct();
			extentInfoLogs("click on Buy Now button ");
			clickXpath(BugRegressionAppConstants.ProductDetailsVarBuyNow_xpath);

			info("clicking on Buy Now button");
			AddToCart.addToCart();
			extentInfoLogs("verifying assertion for login screen");
			Assert.assertEquals(
					findElementByName(BugRegressionAppConstants.Login_text)
							.getText(), AppVerificationChecks.Logintext);
			info("verifying assertion");
			extentInfoLogs("Login to Gmail");
			GmailLogin.gmailLogin();
			extentInfoLogs("Verifying assertion for store locality");
			boolean storeLocalityDisplayed = findElementById(
					BugRegressionAppConstants.StoreLocality_id).isDisplayed();
			Assert.assertEquals(storeLocalityDisplayed, true);
			boolean storeTitleDisplayed = findElementById(
					BugRegressionAppConstants.StoreTitle_id).isDisplayed();
			extentInfoLogs("Verifying assertion for store title");
			Assert.assertEquals(storeTitleDisplayed, true);

		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots",
			// "Store details on Cart Page");
			throw (e);
		}

	}

	@Test(enabled = true, priority = 2)
	public void emptyCartOnChangingLocation() throws Exception {
		try {
			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();
			extentInfoLogs("open navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			info("open navigation drawer");

			extentInfoLogs("click on Mobiles and Tablets link");
			OpenHomePage
					.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			info("click on Mobile and tablets link");

			extentInfoLogs("Open Android Phone category");

			clickByName(BugRegressionAppConstants.SmartphoneName,
					BugRegressionAppConstants.SmartphoneName);

			extentInfoLogs("click On First Android Product");
			OpenAndroidPage.clickOnFirstAndroidProduct();
			extentInfoLogs("click on Buy Now button ");
			clickXpath(BugRegressionAppConstants.ProductDetailsVarBuyNow_xpath);

			extentInfoLogs("clicking on Buy Now button");
			AddToCart.addToCart();
			extentInfoLogs("Login to Gmail");
			GmailLogin.gmailLogin();

			extentInfoLogs("Navigate back");
			backButton();
			extentInfoLogs("Navigate back");
			backButton();
			extentInfoLogs("Navigate back");
			backButton();
			extentInfoLogs("opening navigation drawer");
			Thread.sleep(2000);
			driver.swipe(0, 200, 0, 1000, 3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage)));
			Thread.sleep(8000);
			clickClassName(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage);
			extentInfoLogs("clicking on location icon");
			clickId(BugRegressionAppConstants.NavDrawerLocationIcon_id);

			extentInfoLogs("clicking on bangalore");
			clickName(BugRegressionAppConstants.BangaloreLocation_text);

			extentInfoLogs("clicking on BTM location");
			clickName(BugRegressionAppConstants.BTMLocation_text);
			info("clicking on BTM location");
			extentInfoLogs("clicking on cart alert");
			clickName(BugRegressionAppConstants.LocationChangeCartPrompt_name);
			info("clicking on cart alert");
			extentInfoLogs("open nav drawer");
			if (findElementsById(BugRegressionAppConstants.NavDrawerHomeIcon_id)
					.size() > 0) {
				clickId(BugRegressionAppConstants.NavDrawerHomeIcon_id);
			}
			info("clicking on Home icon");

			extentInfoLogs("clicking on cart");
			clickCart();
			info("clicking on cart");
			extentInfoLogs("Verifying assertion for empty cart");
			Assert.assertEquals(
					findElementById(BugRegressionAppConstants.NoItemInCart_id)
							.getText(), AppVerificationChecks.NoItemInCart);

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}


	@Test(enabled = true, priority = 3)
	public void itemVerificationInCart() throws Exception {
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			Thread.sleep(4000);
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("open navigation drawer");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);
			extentInfoLogs("clicking on Login text on nav drawer");
			GmailLogin.gmailLogin();
			extentInfoLogs("appying gmail functions");
			clickId(BugRegressionAppConstants.Prod_Cart_Id);
			extentInfoLogs("Opening cart");
			while (true) {
				if (findElementsById(
						BugRegressionAppConstants.NoItemInCartLabel_id).size() > 0) {
					clickId(BugRegressionAppConstants.CartGoHome_Id);
					break;
				} else {
					if (findElementsById(
							BugRegressionAppConstants.CartDeleteButton_Id)
							.size() > 0) {
						clickId(BugRegressionAppConstants.CartDeleteButton_Id);
						clickId(BugRegressionAppConstants.OkButton_Id);
					}
				}
			}
			Thread.sleep(4000);
			extentInfoLogs("open navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			info("open navigation drawer");

			extentInfoLogs("click on Mobiles and Tablets link");
			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			info("click on Mobile and tablets link");

			extentInfoLogs("Open Android Phone category");
			// clickName(BugRegressionAppConstants.AndroidPhones_name);
			clickByName(BugRegressionAppConstants.SmartphoneName,BugRegressionAppConstants.SmartphoneName);
			extentInfoLogs("click On First Android Product");
			OpenAndroidPage.clickOnFirstAndroidProduct();
			extentInfoLogs("click on Buy Now button ");
			clickXpath(BugRegressionAppConstants.ProductDetailsVarBuyNow_xpath);
			info("clicking on Buy Now button");
			AddToCart.addToCart();
			for(int h=0;h<5;h++)
			{
				extentInfoLogs("click on Increase Item Count");
				clickId(BugRegressionAppConstants.ProductItemCountIncrease_Id);
			}
			String ItemCount=findElementById(BugRegressionAppConstants.ProductItemCount_Id).getText();
			Assert.assertEquals(ItemCount, "5");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw (e);
		}
	}
	@Test(enabled = true, priority = 4)
	public void sortingInTrendingProducts() throws Exception {
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			Thread.sleep(4000);
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("open navigation drawer");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);
			extentInfoLogs("clicking on Login text on nav drawer");
			GmailLogin.gmailLogin();
			extentInfoLogs("appying gmail functions");
			clickId(BugRegressionAppConstants.Prod_Cart_Id);
			extentInfoLogs("Opening cart");
			while (true) {
				if (findElementsById(
						BugRegressionAppConstants.NoItemInCartLabel_id).size() > 0) {
					clickId(BugRegressionAppConstants.CartTrendingProduct_Id);
					break;
				} else {
					if (findElementsById(
							BugRegressionAppConstants.CartDeleteButton_Id)
							.size() > 0) {
						clickId(BugRegressionAppConstants.CartDeleteButton_Id);
						clickId(BugRegressionAppConstants.OkButton_Id);
					}
				}
			}
//			clickClassName(BugRegressionAppConstants.BackButton_class);
//			extentInfoLogs( "clicking back button");
			Thread.sleep(4000);
			clickId(BugRegressionAppConstants.Seller_More_Seller_Sorting);
			Assert.assertTrue(findElementByName(AppData.SortingText_Alert).isDisplayed());
			List<WebElement> list = findElementsById(BugRegressionAppConstants.Sorting_orders_Id);
			int count =list.size();
			Assert.assertEquals(count, 2);
		}
		catch(Exception e)
		{
			// clickClassName(BugRegressionAppConstants.BackButton_class);
			// extentInfoLogs( "clicking back button");
			e.printStackTrace();
			throw (e);
		}
	}
}
