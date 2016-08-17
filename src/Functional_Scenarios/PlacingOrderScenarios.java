package Functional_Scenarios;

import java.util.List;

import javax.print.attribute.standard.Fidelity;

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
//Test case info:In this test case we are  verifying placing order scenarios
// In first test case we are verifying placing order scenario
import Page_Objects.SanitySuiteAppConstants;

public class PlacingOrderScenarios extends BaseTestBugRegression {
	String price = null;
	int intprice = 0;

	public void clickBuyNowBySeller_MoreSeller(String sellerName) {
		// String buildType = ".staging";
		try {
			WebElement parentLayout = driver.findElement(By.id("com.zopperapp"
					+ BugRegressionAppConstants.buildType + ":id/rv_stores"));
			List<WebElement> linearLayout = parentLayout.findElements(By
					.className("android.widget.LinearLayout"));
			for (WebElement ele : linearLayout) {
				String StoreName = ele.findElement(
						By.id("com.zopperapp"
								+ BugRegressionAppConstants.buildType
								+ ":id/tv_item_product_store_title")).getText();
				System.out.println(StoreName);
				if (StoreName.trim().toLowerCase()
						.equals(sellerName.trim().toLowerCase())) {
					List<WebElement> priceStoreList = driver
							.findElementsById("com.zopperapp.staging:id/price_store_parent");
					for (WebElement buy : priceStoreList) {
						System.out.println(buy.getText());
						ele.findElement(
								By.id("com.zopperapp"
										+ BugRegressionAppConstants.buildType
										+ ":id/tv_item_buy")).click();
					}
					int var = 0;
					while (var < 20) {
						if (ele.findElements(
								By.id("com.zopperapp"
										+ BugRegressionAppConstants.buildType
										+ ":id/tv_item_buy")).size() > 0) {
							ele.findElement(
									By.id("com.zopperapp"
											+ BugRegressionAppConstants.buildType
											+ ":id/tv_item_buy")).click();
							break;
						}
						var++;
					}
					break;
				}
			}
		}catch(Exception e){
			
		}
	}

	public void moreSeller() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			 int sellerCount =
			 findElementsById(BugRegressionAppConstants.More_Sellers_Store_Name_Id).size();
			 System.out.println(sellerCount);
			 for (int j = 0; j < sellerCount; j++) {
			 String storeName =
			 findElementsById(BugRegressionAppConstants.More_Sellers_Store_Name_Id).get(j)
			 .getText();
			 System.out.println(storeName);
			 System.out.println("the value of j counter"+ j);
			 if (storeName.trim().equals(AppData.Priyank_Store_Text))
			 {
			// try {
			// swipeVertically(1000);
				 Thread.sleep(5000);
			 findElementsById(BugRegressionAppConstants.MoreSellersBuyNow_id).get(j).click();
			 break;
			 }else{
				 swipeVertically_FullPage();
				 swipeVertically_FullPage();
			 }
			 

	}
	}
	}
	
	public void pdPageSwipe() throws InterruptedException{
		Thread.sleep(5000);
		for (int k = 0; k < 3; k++) {
			swipeVertically_FullPage();
		}
		extentInfoLogs("Get product name");
		String strName = findElementById(
				BugRegressionAppConstants.Product_Store_Name_id).getText();
		if (!strName.trim().equals(AppData.Priyank_Store_Text)) {
			extentInfoLogs("Click on view more sellers link");

			clickId(BugRegressionAppConstants.View_More_Sellers_Id);
			for (int j = 0; j < 2; j++) {
				if (findElementsById(
						BugRegressionAppConstants.View_More_Sellers_Id)
						.size() > 0)
					clickId(BugRegressionAppConstants.View_More_Sellers_Id);
				else
					break;
			}
		}
		else {
			extentInfoLogs("Click on buy now button");
			clickXpath(BugRegressionAppConstants.ProductDetailsVarBuyNow_xpath);
			AddToCart.addToCart();
		}
	}

	@Override
	@Test(enabled = true, invocationCount=1)
	public void executeTestCase() throws Exception {
		try {

			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();

			extentInfoLogs("Select location");
			selectCity("Delhi", "");
			extentInfoLogs("Open Navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on sign up  iconOpen Home page");
			clickId(BugRegressionAppConstants.SignUpIcon_id);
			extentInfoLogs("Gmail login");
			GmailLogin.gmailLogin();
			extentInfoLogs("Navigate back");
			backButton();
			extentInfoLogs("Click on cart icon");
			clickId(BugRegressionAppConstants.Prod_Cart_Id);
			extentInfoLogs("Delete all products from cart");
			deleteCartItems();
			extentInfoLogs("Navigate back");
			backButton();
			// clickClassName(AppConstants.Open_Navigation_Drawer);
			// extentInfoLogs("open navigation drawer");
			extentInfoLogs("Click on home search text box");
			clickId(BugRegressionAppConstants.Home_Search_TextBox_Id);
			extentInfoLogs("Enter product name in search field");
			sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id,AppData.Priyank_Store_SearchProduct_Name);
			extentInfoLogs("Select product from auto suggestion list");
			OpenAndroidPage.clickOnCategoryByName(BugRegressionAppConstants.AutoSuggestSearch_id,AppData.Priyank_Store_Product_Name);
			
			Thread.sleep(5000);
			extentInfoLogs("Scroll to view store link");
			// driver.scrollTo(AppData.View_Store_Text);
			for (int k = 0; k < 3; k++) {
				swipeVertically_FullPage();
			}
			
			findPriyankAndBuy();
			
			extentInfoLogs("clicking on checkout button");
			clickId(BugRegressionAppConstants.ProductionCheckoutButton_id);

			extentInfoLogs("Checking for address fields");
			if (findElementsById(SanitySuiteAppConstants.Shipping_FullName_Id).size() > 0)
			{
				extentInfoLogs("Enter user name in shipping address");
				sendKeysForID(SanitySuiteAppConstants.Shipping_FullName_Id,AppData.Shipping_UserName);
				extentInfoLogs("Enter address in shipping address");
				sendKeysForID(SanitySuiteAppConstants.Shipping_Address_Id,AppData.ShippingAddress);
				extentInfoLogs("Enter Pincode in shipping address");
				sendKeysForID(SanitySuiteAppConstants.Shipping_Pincode_Id,AppData.ShippingPincode);
				extentInfoLogs("Click on save button");
				clickId(SanitySuiteAppConstants.Shipping_SaveButton_Id);
			}

			extentInfoLogs("clicking on continue button");
			clickId(BugRegressionAppConstants.ProductionContinueButton_id);
			extentInfoLogs("clicking on cash on delivery button");
			clickOnCategoryByName(BugRegressionAppConstants.AllPaymentMode_id,BugRegressionAppConstants.CashOnDelievery_name);
			// if(findElementsByName(BugRegressionAppConstants.CashOnDelievery_name).size()>0){
			// clickName(BugRegressionAppConstants.CashOnDelievery_name);
			// }else{
			// swipeVertically_FullPage();
			// clickName(BugRegressionAppConstants.CashOnDelievery_name);
			// }
			// try {
			// clickName(BugRegressionAppConstants.CashOnDelievery_name);
			// } catch (Exception e) {
			// swipeVertically_FullPage();
			// clickName(BugRegressionAppConstants.CashOnDelievery_name);
			// }
			extentInfoLogs("clicking on place order button");
			clickId(BugRegressionAppConstants.ProductionPlaceOrder_id);
			extentInfoLogs("Getting order id after order");
			String verifyOrderPageOrderID = findElementById(
					BugRegressionAppConstants.VerifyOrderPageOrderId_id)
					.getText();
			extentInfoLogs("clicking on shop more button");
			clickId(BugRegressionAppConstants.ProductionShopMore_id);
			extentInfoLogs("Assert for home screen");
			// if(findElementsByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text).size()>0){

			// }else{
			// swipeVertically_FullPage();
			// swipeVertically_FullPage();
			// }
			// Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
			// .getText().equals(AppData.HomePageExploreExcitingCategories_text));
			extentInfoLogs("open nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Clicking on user profile");
			clickId(BugRegressionAppConstants.SignUpIcon_id);
			extentInfoLogs("clicking on My orderlink option");
			clickId(BugRegressionAppConstants.MyProfileOrderLink_id);
			extentInfoLogs("Getting ordr id from my orders page");
			String myOrderPageOrderID = findElementById(
					BugRegressionAppConstants.OrderID_id).getText();
			extentInfoLogs("Assert for order ids");
			Assert.assertEquals(verifyOrderPageOrderID, myOrderPageOrderID);
			clickIDByIndex(SanitySuiteAppConstants.ViewOrder_id, 0);
			swipeVertically(300);
			String orderPlaced = clickOnCategoryByName(
					BugRegressionAppConstants.OrderPlaced_id,
					AppData.OrderPlaced);
			System.out.println(orderPlaced);
			Assert.assertTrue(orderPlaced
					.equalsIgnoreCase(AppVerificationChecks.OrderStatusProcessing));
//			clickId(BugRegressionAppConstants.CancelButton_id);
//			clickId(BugRegressionAppConstants.CancellationReason_id);
//			clickName(BugRegressionAppConstants.Others_name);
//			sendKeysForID(BugRegressionAppConstants.WriteAfeedback_id, AppData.FeedbackTestOrder);
//			clickId(BugRegressionAppConstants.SubmitButton_id);
//			if(findElementsByName(BugRegressionAppConstants.ItemCancelled_name).size()>0){
//			Assert.assertTrue(findElementsByName(BugRegressionAppConstants.ItemCancelled_name).size()>0);
//			}else{
//				swipeVertically_FullPage();
//				Assert.assertTrue(findElementsByName(BugRegressionAppConstants.ItemCancelled_name).size()>0);
//			}

			} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void payTmFlow() throws Exception
	{
		try {
			try {
				extentInfoLogs("Open Home page");
				OpenHomePage.openHomePage();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By
						.id(BugRegressionAppConstants.HomeSpinner_id)));
				// swipeWithAxis(200, 300, 100, 100, 3000);
				extentInfoLogs("Click on home search icon");
				clickId(BugRegressionAppConstants.Home_search_button_id);
				extentInfoLogs("Enter search string as "
						+ AppData.Priyank_Store_Product_Name);
				sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id,
						AppData.Priyank_Store_SearchProduct_Name);
				extentInfoLogs("Click on auto suggest first item");
				// clickXpath(BugRegressionAppConstants.SearchSuggestedFirstProduct_xpath);
				WebElement searchList = findElementById(BugRegressionAppConstants.SearchList_id);
				List<WebElement> linearlayout = searchList
						.findElements(By
								.className(BugRegressionAppConstants.SearchLinearLayout_classname));
				linearlayout.get(0).click();
				List<WebElement> element = findElementsById(BugRegressionAppConstants.ProductPriceOnPrdctDetails_id);
				price = element.get(0).getText().replaceAll(",", "");
				intprice = Integer.parseInt(price);
				if (intprice <= 10000) {
					extentInfoLogs("Click on cart icon");
					clickId(BugRegressionAppConstants.Prod_Cart_Id);
					extentInfoLogs("Gmail login");
					GmailLogin.gmailLogin();
					extentInfoLogs("Delete all products from cart");
					deleteCartItems();
					extentInfoLogs("Navigate back");
					backButton();
					extentInfoLogs("Click on buy now button");
					clickXpath(BugRegressionAppConstants.ProductDetailsVarBuyNow_xpath);
					AddToCart.addToCart();
					extentInfoLogs("clicking on checkout button");
					clickId(BugRegressionAppConstants.ProductionCheckoutButton_id);

					extentInfoLogs("Checking for address fields");
					if (findElementsById(
							SanitySuiteAppConstants.Shipping_FullName_Id).size() > 0) {
						extentInfoLogs("Enter user name in shipping address");
						sendKeysForID(SanitySuiteAppConstants.Shipping_FullName_Id,
								AppData.Shipping_UserName);
						extentInfoLogs("Enter address in shipping address");
						sendKeysForID(SanitySuiteAppConstants.Shipping_Address_Id,
								AppData.ShippingAddress);
						extentInfoLogs("Enter Pincode in shipping address");
						sendKeysForID(SanitySuiteAppConstants.Shipping_Pincode_Id,
								AppData.ShippingPincode);
						extentInfoLogs("Click on save button");
						clickId(SanitySuiteAppConstants.Shipping_SaveButton_Id);
					}

					extentInfoLogs("clicking on continue button");
					clickId(BugRegressionAppConstants.ProductionContinueButton_id);
					extentInfoLogs("clicking on cash on continue button");
					clickOnCategoryByName(
							BugRegressionAppConstants.AllPaymentMode_id,
							AppData.PayTm);
					Assert.assertTrue(BugRegressionAppConstants.PaytmpageCancel_name
							.equalsIgnoreCase(AppVerificationChecks.PaytmCancel));
				} else {
					verifyProductForPaytm();
				}
			} 
			catch (Exception e) 
			{
				throw (e);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verifyProductForPaytm() throws Exception {
		extentInfoLogs("Click on home search icon");
		clickId(BugRegressionAppConstants.Home_search_button_id);
		extentInfoLogs("Enter search string as " + AppData.Producttext10);
		sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id,
				AppData.Producttext11);
		extentInfoLogs("Click on auto suggest first item");
		// clickXpath(BugRegressionAppConstants.SearchSuggestedFirstProduct_xpath);
		WebElement searchList = findElementById(BugRegressionAppConstants.SearchList_id);
		List<WebElement> linearlayout = searchList
				.findElements(By
						.className(BugRegressionAppConstants.SearchLinearLayout_classname));
		linearlayout.get(0).click();
		List<WebElement> element = findElementsById(BugRegressionAppConstants.ProductPriceOnPrdctDetails_id);
		price = element.get(0).getText().replaceAll(",", "");
		intprice = Integer.parseInt(price);
		extentInfoLogs("Click on cart icon");
		clickId(BugRegressionAppConstants.Prod_Cart_Id);
		extentInfoLogs("Gmail login");
		GmailLogin.gmailLogin();
		extentInfoLogs("Delete all products from cart");
		deleteCartItems();
		extentInfoLogs("Navigate back");
		backButton();
		extentInfoLogs("Click on buy now button");
		clickXpath(BugRegressionAppConstants.ProductDetailsVarBuyNow_xpath);
		AddToCart.addToCart();
		extentInfoLogs("clicking on checkout button");
		clickId(BugRegressionAppConstants.ProductionCheckoutButton_id);
		extentInfoLogs("clicking on continue button");
		clickId(BugRegressionAppConstants.ProductionContinueButton_id);
		extentInfoLogs("clicking on cash on continue button");
		clickOnCategoryByName(BugRegressionAppConstants.AllPaymentMode_id,
				AppData.PayTm);
		Assert.assertTrue(BugRegressionAppConstants.PaytmpageCancel_name
				.equalsIgnoreCase(AppVerificationChecks.PaytmCancel));

	}
	
	public void findPriyankAndBuy() throws InterruptedException
	{
		if(findElementById(BugRegressionAppConstants.Product_Store_Name_id).isDisplayed())
		{
			
		}
		else
		{
			swipeVertically_FullPage();
			swipeVertically_FullPage();
			swipeVertically_FullPage();
		}
		
		if(findElementById(BugRegressionAppConstants.Product_Store_Name_id).getText().contains(AppData.Priyank_Store_Text))
		{
			clickId(BugRegressionAppConstants.AddToCartButton_id);
		}
		else
		{
			clickId(BugRegressionAppConstants.MoreSellers_id);
			extentInfoLogs("Select priyank store from view more sellers");
			for (int i = 0; i < 5; i++) 
			{
				int sellerCount = findElementsById(BugRegressionAppConstants.More_Sellers_Store_Name_Id).size();
				System.out.println(sellerCount);
				for (int j = 0; j < sellerCount; j++)
				{
					String storeName = findElementsById(BugRegressionAppConstants.More_Sellers_Store_Name_Id).get(j).getText();
					System.out.println(storeName);
					System.out.println("the value of j counter" + j);
					if (storeName.trim().equals(AppData.Priyank_Store_Text))
					{
						Thread.sleep(5000);
						findElementsById(BugRegressionAppConstants.MoreSellersBuyNow_id).get(j).click();
						break;
					}
				}
				
				swipeVertically_FullPage();
				swipeVertically_FullPage();
				swipeVertically_FullPage();
			}
		
			if(findElementById(BugRegressionAppConstants.StoreTitle_id).getText().contains(AppData.Priyank_Store_Text))
			{
				
			}
			else
			{
				deleteCartItems();
				backButton();
				backButton();
				findPriyankAndBuy();
			}
		}
	}
}