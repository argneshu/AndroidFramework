package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenAndroidPage;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;
import Page_Objects.AppVerificationChecks;

public class UniqueCouponMultipleTime_SNo_39 extends BaseTestBugRegression {

	@Override
	@Test
	public void executeTestCase() throws Exception {
		//
		try {
			OpenAndroidPage.openAndroidPage();
			OpenAndroidPage.clickOnFirstAndroidProduct();
			clickName(BugRegressionAppConstants.BuyNow_button_text);
			GmailLogin.gmailLogin();
			sendKeysForID(BugRegressionAppConstants.CouponTextbox_id,
			AppData.CouponTextboxData);
			clickId(BugRegressionAppConstants.CouponApplyButton_id);
			clickId(BugRegressionAppConstants.CheckoutButton_id);
			info("clicking on checkout button");
			clickId(BugRegressionAppConstants.ContinueButton_id);
			info("clicking on continue button");
			clickName(BugRegressionAppConstants.CashOnDelivery_Name);
			info("clicking on COD");
			clickId(BugRegressionAppConstants.PlaceOrder_id);
			info("Clicking on Placed order id");
			clickId(BugRegressionAppConstants.ShopMore_id);
			info("clicking on Shop More");
			OpenAndroidPage.clickOnCategoryByName(BugRegressionAppConstants.Home_Menu_Id,BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			OpenAndroidPage.clickOnFirstAndroidProduct();
			clickName(BugRegressionAppConstants.BuyNow_button_text);
			//GmailLogin.gmailLogin();
			sendKeysForID(BugRegressionAppConstants.CouponTextbox_id,
			AppData.CouponTextboxData);
			clickId(BugRegressionAppConstants.CouponApplyButton_id);
			AssertJUnit.assertTrue(AppVerificationChecks.CouponErrorTextDiscounted
					.equals(findElementById(BugRegressionAppConstants.CouponError_id)
							.getText()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// try{
	// OpenLoginPage.openLoginPage();
	// sendKeysForName(AppConstants.Email_name,"vinay.kumar@zopper.com");
	// Thread.sleep(5000);
	// sendKeysForID(AppConstants.login_passwd_id,"zopper");
	// clickName(AppConstants.LoginButton_name);
	// clickClassName(AppConstants.Back_Arrow_ClassName);
	// Assert.assertEquals("Home",
	// driver.findElement(By.name("Home")).getText());
	// clickId(AppConstants.fourth_product_id);
	// clickName(AppConstants.BuyNow_button_text);
	//
	// sendKeysForID(AppConstants.CouponCode_id,"call");
	// clickId(AppConstants.ApplyCoupon_id);
	// }
	// //
	// if(findElementById(AppConstants.CouponErrorMessage_id).getText()=="Have other coupon? Reapply to avail the offer")
	// // {
	// //Assert.assertEquals("Have other coupon? Reapply to avail the offer",
	// driver.findElement(By.id(AppConstants.CouponErrorMessage_id)).getText());
	// // }
	// // else{
	// // System.out.println("else");
	// // throw new Throwable();
	// // }
	//
	// //
	// // clickId(AppConstants.CheckoutButton_id);
	// // clickId(AppConstants.ContinueButton_id);
	// // clickId(AppConstants.CashOnDelivery_id);
	// // clickId(AppConstants.PlaceOrderButton_id);
	// // clickId(AppConstants.ShopMoreButton_id);
	// //
	// // Assert.assertEquals("Home",
	// driver.findElement(By.name("Home")).getText());
	// // clickId(AppConstants.fourth_product_id);
	// // clickName(AppConstants.BuyNow_button_text);
	// // sendKeysForID(AppConstants.CouponCode_id,"QW123");
	// // clickId(AppConstants.ApplyCoupon_id);
	// //
	// Assert.assertEquals("Sorry, You have reached the maximum limit for this coupon",
	// driver.findElement(By.id(AppConstants.CouponErrorMessage_id)).getText());
	// //// throw new Throwable();
	// //// }
	// catch(Throwable e)
	// {
	// e.printStackTrace();
	// }
	// }

}
