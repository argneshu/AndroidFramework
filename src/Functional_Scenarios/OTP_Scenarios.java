package Functional_Scenarios;

import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.API_Main;
import App_Functions.AddToCart;
import App_Functions.GmailLogin;
import App_Functions.OpenAndroidPage;
import App_Functions.OpenHomePage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;
import Utility.Getdbdata;
import Utility.TesseractOCR;

public class OTP_Scenarios extends BaseTestBugRegression {

	public String getStoreId_DB(String order_Id) throws Exception {
		String store_Id = "";
		try {
			Getdbdata.connectDB();
			store_Id = Getdbdata.executeQuery(
					"SELECT store_id FROM accounts.orders_orderitem where order_summary_id=(SELECT id FROM accounts.orders_ordersummary where order_id='"
							+ order_Id + "')");
			Getdbdata.closeDBConnection();
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
		return store_Id;
	}

	public boolean deliver_Order_API(String order_id) throws Exception {
		boolean flag = false;
		try {
			flag = API_Main.OrderAccept_Consumer(order_id, "ACCEPTED");
			extentInfoLogs("Verifying consumer order acceptance");
			Assert.assertTrue(flag);
			Thread.sleep(5000);

			String Store_id = getStoreId_DB(order_id).trim();
			for (int i = 0; i < 3; i++) {
				if (Store_id.equals("")) {
					Store_id = getStoreId_DB(order_id).trim();
				} else {
					break;
				}
			}
			System.out.println("Store_id::::::::" + Store_id);
			flag = API_Main.RetailerOrder_Confirm(order_id, Store_id, "ACCEPTED");
			extentInfoLogs("Verifying retailer order acceptance");
			Assert.assertTrue(flag);
			Thread.sleep(5000);
			String order_Item = API_Main.getOrder_Item(order_id, Store_id, "PENDING");
			extentInfoLogs("Verifying order item value");
			System.out.println("order_Item::::::" + order_Item);
			Assert.assertTrue(order_Item.length() > 0);
			Thread.sleep(5000);
			String shipment_Id = API_Main.getShipmentHandler("3pl", order_Item, Store_id);
			extentInfoLogs("Verifying order shipment status");
			Assert.assertTrue(shipment_Id.length() > 0);
			Thread.sleep(5000);
			
			extentInfoLogs("Navigate back");
			backButton();
			extentInfoLogs("clicking on My order option");
			clickId(BugRegressionAppConstants.MyAccount_OrderMenu_Id);
			
			String OrderSts=findElementById(SanitySuiteAppConstants.MyAccount_OrderStatus_id).getText();
			extentInfoLogs("Assert for in trasit status "+OrderSts);
			Assert.assertTrue(OrderSts.toLowerCase().replace(" ", "").equals("In Transit".toLowerCase().replace(" ", "")));
			
			
			flag = API_Main.getOrderDeliveryStatus(shipment_Id, "DELIVERED", Store_id, order_id);
			extentInfoLogs("Verifying oder delivery status");
			Assert.assertTrue(flag);
			System.out.println("Order delivered successfully");
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
		return flag;

	}

	public String dbGetData(String phoneno) throws Exception {
		String otp = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://45.56.112.183:3306/accounts",
					"accounts", "accounts");

			java.sql.Statement stmt = con.createStatement();

			java.sql.ResultSet rs = stmt
					.executeQuery("SELECT code FROM accounts.user_auth_onetimecode where attribute_value =" + phoneno);

			while (rs.next()) {
				otp = rs.getString(1);
			}
			if (otp == null || otp.isEmpty()) {
				otp = "OTP not generated for given number";
			}
			con.close();

		} catch (Exception e) {
			System.out.println("OTP not generated for given number\n::" + e.getMessage());
			throw e;
		}
		return otp;
	}

	public int getProductPrice() {
		int prod_Price = 0;
		try {
			List<WebElement> prices = findElementsById(SanitySuiteAppConstants.Product_Price_id);
			for (WebElement ele : prices) {
				int price = Integer.parseInt(ele.getText().replace(",", ""));
				if (prod_Price > price && price != 0) {
					prod_Price = price;
				}
			}

		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
		return prod_Price;
	}

	public String generate10DigitNumber() {
		String no;
		try {
			Random random = new Random();
			int START = 1000000000;
			long END = 9999999999L;

			long range = (long) END - (long) START + 1;
			long fraction = (long) (range * random.nextDouble());
			no = "" + fraction;
			if (no.length() != 10) {
				no = generate10DigitNumber();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return no;
	}

	public void registerNewUser(String name, String email, String contact, String password, String referral) {
		try {
			extentInfoLogs("Enter user name : " + name);
			sendKeysForID(SanitySuiteAppConstants.SignUp_FullName_Edit_Id, name);
			extentInfoLogs("Enter Email Id : " + email);
			sendKeysForID(SanitySuiteAppConstants.SignUp_Email_Edit_Id, email);
			extentInfoLogs("Enter Contact no : " + contact);
			sendKeysForID(SanitySuiteAppConstants.SignUp_ContactNo_Edit_Id, contact);
			extentInfoLogs("Enter password : " + password);
			sendKeysForID(SanitySuiteAppConstants.SignUp_Password_Edit_Id, password);
			if (!referral.equals("")) {
				extentInfoLogs("Enter Refferal code : " + referral);
				System.out.println("referral is  " + referral);
				sendKeysForID(SanitySuiteAppConstants.SignUp_RefferalCode_Edit_Id, referral);
			}
			extentInfoLogs("Click on sign up button");
			clickId(SanitySuiteAppConstants.SignUp_SignUp_Button_Id);
		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}
	}

	public void removeDeviceIdFromDB() throws Exception {
		try {

			extentInfoLogs("Connect to DB");
			Getdbdata.connectDB();

			extentInfoLogs("Remove device id from DB");
			String user_id = Getdbdata.executeQuery(
					"select user_id from user_auth_userdevicesessionmap where android_id='" + getDeviceId() + "'");
			Getdbdata.updateQuery("update user_auth_userdevicesessionmap set has_referred=0 where user_id=" + user_id);
			extentInfoLogs("DisConnect DB connection");
			Getdbdata.closeDBConnection();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void createNewUser_OTP() throws Exception {
		try {
			extentInfoLogs("Open Nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Clicking login icon");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);
			extentInfoLogs("Click on sign up link");
			clickName(BugRegressionAppConstants.SignUP_name);
			String contNo = generate10DigitNumber();
			String user = "SignUp_User_" + contNo;
			String email = "SignUp_User_" + contNo + "@gmail.com";
			extentInfoLogs("Register a new user");
			registerNewUser(user, email, contNo, AppData.password, AppData.referalString);
			Thread.sleep(10000);
			if (findElementsById(SanitySuiteAppConstants.OTP_PopUp_Edit_Id).size() > 0) {

			} else {
				contNo = generate10DigitNumber();
				user = "SignUp_User_" + contNo;
				email = "SignUp_User_" + contNo + "@gmail.com";
				extentInfoLogs("Register a new user if OTP pop up is not displayed");
				registerNewUser(user, email, contNo, AppData.password, AppData.referalString);
			}
			extentInfoLogs("Click on submit button for OTP");
			clickId(SanitySuiteAppConstants.OTP_PopUp_Submit_Button_Id);
			String otp = dbGetData(contNo);
			extentInfoLogs("Get otp for contact number " + contNo + " i.e., " + otp);

			String scrnText = TesseractOCR.readAllCurrentScreenText();
			extentInfoLogs("Get current Screen text : " + scrnText);

			extentInfoLogs("Checking number is already exists or not");
			if (scrnText.contains("Contact Number already exists")) {
				contNo = generate10DigitNumber();
				extentInfoLogs("Enter contact number if previous number is already exists");
				sendKeysForID(SanitySuiteAppConstants.OTP_PopUp_Edit_Id, contNo);
				extentInfoLogs("Click on submit button for OTP");
				clickId(SanitySuiteAppConstants.OTP_PopUp_Submit_Button_Id);
				extentInfoLogs("Click on submit button for OTP");
				otp = dbGetData(contNo);
				extentInfoLogs("Get otp for contact number " + contNo + " i.e., " + otp);
			}
			extentInfoLogs("Enter OTP");
			sendKeysForID(SanitySuiteAppConstants.OTP_OTP_Edit_Id, otp);
			extentInfoLogs("Click on OTP verify button");
			clickId(SanitySuiteAppConstants.OTP_Verify_Button_Id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void placeOrder() throws Exception {
		try {
			clickId(BugRegressionAppConstants.Homelink_id);
			extentInfoLogs("Click on home sarch text box");
			clickId(BugRegressionAppConstants.Home_Search_TextBox_Id);

			extentInfoLogs("Enter product name in search field");
			sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, AppData.Priyank_Store_SearchProduct_Name);
			extentInfoLogs("Select product from auto suggestion list");
			OpenAndroidPage.clickOnCategoryByName(BugRegressionAppConstants.AutoSuggestSearch_id,
					AppData.Priyank_Store_Product_Name);

			Thread.sleep(5000);
			extentInfoLogs("Scroll to view store link");
			//driver.scrollTo(AppData.View_Store_Text);
			for (int k = 0; k < 3; k++) {
				swipeVertically_FullPage();
			}
			extentInfoLogs("Get product name");
			String strName = findElementById(BugRegressionAppConstants.Product_Store_Name_id).getText();
			if (!strName.trim().equals(AppData.Priyank_Store_Text)) {
				extentInfoLogs("Click on view more sellers link");

				clickId(BugRegressionAppConstants.View_More_Sellers_Id);
				for (int j = 0; j < 2; j++) {
					if (findElementsById(BugRegressionAppConstants.View_More_Sellers_Id).size() > 0)
						clickId(BugRegressionAppConstants.View_More_Sellers_Id);
					else
						break;
				}
				// clickId(BugRegressionAppConstants.View_More_Sellers_Id);
				extentInfoLogs("Select priyank store from view more sellers");
				for (int i = 0; i < 3; i++) {
					 int sellerCount =
					 findElementsById(BugRegressionAppConstants.More_Sellers_Store_Name_Id).size();
					 System.out.println(sellerCount);
					 for (int j = 0; j < sellerCount; j++) {
					 String storeName =
					 findElementsById(BugRegressionAppConstants.More_Sellers_Store_Name_Id).get(j)
					 .getText();
					 System.out.println(storeName);
					 if (storeName.trim().equals(AppData.Priyank_Store_Text))
					 {
					// try {
					// swipeVertically(1000);
					 findElementsById(BugRegressionAppConstants.MoreSellersBuyNow_id).get(j).click();
					 break;
					 }else{
						 //swipeVertically_FullPage();
					 }
					// AddToCart.addToCart();
					// break;
					// } catch (Exception e) {
					// }
					// }
					 }
					swipeVertically_FullPage();
					swipeVertically_FullPage();
				}

			} else {
				extentInfoLogs("Click on buy now button");
				clickName(BugRegressionAppConstants.BuyNow_Button_Text_Upper);
				AddToCart.addToCart();
			}

			extentInfoLogs("clicking on checkout button");
			clickId(BugRegressionAppConstants.ProductionCheckoutButton_id);

			sendKeysForID(SanitySuiteAppConstants.Shipping_Address_Id, AppData.ShippingAddress);
			swipeVertically_FullPage();
			sendKeysForID(SanitySuiteAppConstants.Shipping_Pincode_Id, AppData.ShippingPincode);
			clickId(SanitySuiteAppConstants.Shipping_SaveButton_Id);
			extentInfoLogs("clicking on continue button");
			clickId(BugRegressionAppConstants.ProductionContinueButton_id);

			extentInfoLogs("clicking on cash on delivery button");
			clickOnCategoryByName(SanitySuiteAppConstants.AllPaymentMode_id,
					BugRegressionAppConstants.CashOnDelievery_name);

			extentInfoLogs("clicking on place order button");
			clickId(BugRegressionAppConstants.ProductionPlaceOrder_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test(enabled = false)
	public void placeOrderWithNewUser() throws Exception {
		try {
			extentInfoLogs("Removing device id from DB");
			removeDeviceIdFromDB();

			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();

			extentInfoLogs("Creating new user using OTP");
			createNewUser_OTP();
			extentInfoLogs("Click on nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on My Profile menu");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);

			swipeVertically_FullPage();
			extentInfoLogs("Fetch wallat amount");
			String wallatAmount = findElementById(SanitySuiteAppConstants.MyProfile_Wallent_Amount_Id).getText();
			wallatAmount = wallatAmount.split(": ")[1];
			wallatAmount = wallatAmount.split(" ")[1];
			extentInfoLogs("Fetch wallat amount : " + wallatAmount);

			extentInfoLogs("Verify refferal amount");
			Assert.assertTrue(wallatAmount.contains("300"));
			extentInfoLogs("Click on cart icon");
			clickId(BugRegressionAppConstants.Prod_Cart_Id);
			extentInfoLogs("Delete all products from cart");
			deleteCartItems();
			extentInfoLogs("Navigate back");
			backButton();

			extentInfoLogs("Navigate back");
			backButton();

			extentInfoLogs("Placing a new order");
			selectCity("Delhi", "");
			placeOrder();

			extentInfoLogs("Getting order id after order");
			String verifyOrderPageOrderID = findElementById(BugRegressionAppConstants.VerifyOrderPageOrderId_id)
					.getText();
			extentInfoLogs("clicking on shop more button");
			clickId(BugRegressionAppConstants.ProductionShopMore_id);
			extentInfoLogs("Assert for home screen");
//			Assert.assertEquals(findElementByName(BugRegressionAppConstants.Hometext_name).getText(),
//					AppVerificationChecks.Hometext);

			extentInfoLogs("Click on nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on My Profile menu");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);

			// extentInfoLogs("clicking overflow menu");
			// clickName(BugRegressionAppConstants.HomeOverflow_name);
			// extentInfoLogs("Clicking on My profile option");
			// clickName(BugRegressionAppConstants.MyProfile_name);
			extentInfoLogs("clicking on My order option");
			clickId(BugRegressionAppConstants.MyAccount_OrderMenu_Id);
			extentInfoLogs("Getting ordr id from my orders page");
			String myOrderPageOrderID = findElementById(BugRegressionAppConstants.OrderID_id).getText();
			extentInfoLogs("Assert for order ids");
			Assert.assertEquals(verifyOrderPageOrderID, myOrderPageOrderID);
			extentInfoLogs("Delivering order using APIs");
			Assert.assertTrue(deliver_Order_API(myOrderPageOrderID.split(":")[1].trim()));

			String price = findElementById(SanitySuiteAppConstants.Product_Price_id).getText();
			System.out.println("price is :" + price);
			extentInfoLogs("Get order price : " + price);
			price = price.replace(",", "");

			int prod_Price = Integer.parseInt(price);

			prod_Price = prod_Price * 5 / 100;
			System.out.println("prod price is" + prod_Price);
			extentInfoLogs("Refferal amount calculation : " + price);
			if (prod_Price > 600)
				prod_Price = 600;
			extentInfoLogs("Navigate back");
			backButton();
			extentInfoLogs("Click on logout icon");
			clickId(BugRegressionAppConstants.Logout_button_Prod_id);
			extentInfoLogs("Click on logout acceptance");
			clickId(BugRegressionAppConstants.Logout_PopUp_Yes_Id);
			extentInfoLogs("Click on nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on login icon");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);

			extentInfoLogs("Gmail Login Page");
			GmailLogin.gmailLogin();
			extentInfoLogs("Click on my account wallet menu");
			try {
				clickId(SanitySuiteAppConstants.MyAccount_Wallet_Id);
			} catch (Exception e) {
				swipeVertically_FullPage();
				clickId(SanitySuiteAppConstants.MyAccount_Wallet_Id);
			}

			DateFormat formatter = new SimpleDateFormat("E, d MMM yyyy");
			Date date = new Date();
			String cur_Date = formatter.format(date);

			String ref_Date = findElementsById(SanitySuiteAppConstants.Wallet_Refferal_Date_Id).get(0).getText();
			System.out.println(ref_Date);
			extentInfoLogs("Fetching refferal date : " + ref_Date);
			String ref_Amount = findElementsById(SanitySuiteAppConstants.Wallet_RefferalAmount_Id).get(0).getText();
			System.out.println(ref_Amount);
			extentInfoLogs("Fetching refferal amount : " + ref_Amount);
			Assert.assertTrue(Integer.parseInt(ref_Amount.trim().split(" ")[1]) >= prod_Price - 1 && Integer.parseInt(ref_Amount.trim().split(" ")[1]) <= prod_Price + 1);
			extentInfoLogs("Assert for refferal amount");
			Assert.assertTrue(cur_Date.trim().replace(" ", "").equals(ref_Date.trim().replace(" ", "")));
			extentInfoLogs("Assert for refferal date");
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}


	@Test(enabled = true)
	public void placeAndCancelOrderWithNewUser() throws Exception {
		try {
			extentInfoLogs("Removing device id from DB");
			removeDeviceIdFromDB();
			
			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();
			
			extentInfoLogs("Creating new user using OTP");
			createNewUser_OTP();
			extentInfoLogs("Click on nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on My Profile menu");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);

			swipeVertically_FullPage();
			extentInfoLogs("Fetch wallat amount");
			String wallatAmount = findElementById(SanitySuiteAppConstants.MyProfile_Wallent_Amount_Id).getText();
			wallatAmount = wallatAmount.split(": ")[1];
			wallatAmount = wallatAmount.split(" ")[1];
			extentInfoLogs("Fetch wallat amount : " + wallatAmount);

			extentInfoLogs("Verify refferal amount");
			Assert.assertTrue(wallatAmount.contains("300"));
			extentInfoLogs("Click on cart icon");
			clickId(BugRegressionAppConstants.Prod_Cart_Id);
			extentInfoLogs("Delete all products from cart");
			deleteCartItems();
			extentInfoLogs("Navigate back");
			backButton();

			extentInfoLogs("Navigate back");
			backButton();

			extentInfoLogs("Placing a new order");
			selectCity("Delhi","");
			placeOrder();

			extentInfoLogs("Getting order id after order");
			String verifyOrderPageOrderID = findElementById(BugRegressionAppConstants.VerifyOrderPageOrderId_id)
					.getText();
			extentInfoLogs("clicking on shop more button");
			clickId(BugRegressionAppConstants.ProductionShopMore_id);
			extentInfoLogs("Assert for home screen");
//			Assert.assertEquals(findElementByName(BugRegressionAppConstants.Hometext_name).getText(),
//					AppVerificationChecks.Hometext);

			extentInfoLogs("Click on nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on My Profile menu");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);

			extentInfoLogs("clicking on My order option");
			clickId(BugRegressionAppConstants.MyAccount_OrderMenu_Id);
			extentInfoLogs("Getting ordr id from my orders page");
			String myOrderPageOrderID = findElementById(BugRegressionAppConstants.OrderID_id).getText();
			extentInfoLogs("Assert for order ids");
			Assert.assertEquals(verifyOrderPageOrderID, myOrderPageOrderID);

			extentInfoLogs("Delivering order using APIs");
			Assert.assertTrue(API_Main.OrderAccept_Consumer(myOrderPageOrderID.split(":")[1].trim(), "REJECTED"));

			extentInfoLogs("Navigate back");
			backButton();

			extentInfoLogs("Click on my account wallet menu");
			try {
				clickId(SanitySuiteAppConstants.MyAccount_Wallet_Id);
			} catch (Exception e) {
				swipeVertically_FullPage();
				clickId(SanitySuiteAppConstants.MyAccount_Wallet_Id);
			}
//
//			Assert.assertTrue(
//					findElementByName("Order Cancelled " + myOrderPageOrderID.split(":")[1].trim()).isDisplayed());

			extentInfoLogs("Navigate back");
			backButton();

			extentInfoLogs("Click on logout icon");
			clickId(BugRegressionAppConstants.Logout_button_Prod_id);
			extentInfoLogs("Click on logout acceptance");
			clickId(BugRegressionAppConstants.Logout_PopUp_Yes_Id);

			extentInfoLogs("Creating new user");
			createNewUser_OTP();

			extentInfoLogs("Click on nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on My Profile menu");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);

			swipeVertically_FullPage();
			extentInfoLogs("Fetch wallat amount");
			String wallatAmount_2 = findElementById(SanitySuiteAppConstants.MyProfile_Wallent_Amount_Id).getText();
			wallatAmount_2 = wallatAmount_2.split(": ")[1];
			wallatAmount_2 = wallatAmount_2.split(" ")[1];
			System.out.println("Second user wallet amount ::::"+wallatAmount_2);
			extentInfoLogs("Fetch wallat amount : " + wallatAmount_2);

			extentInfoLogs("Verify refferal amount");
			Assert.assertTrue(wallatAmount_2.contains("0.0"));

		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws Exception {
		OTP_Scenarios otp = new OTP_Scenarios();

		String store_Id = otp.getStoreId_DB("46641078");
		System.out.println("store_Id::::" + store_Id);
		// otp.deliver_Order_API("58155979", store_Id.trim());

	}

}
