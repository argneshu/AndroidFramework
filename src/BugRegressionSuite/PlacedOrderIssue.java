package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenAndroidPage;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppVerificationChecks;

public class PlacedOrderIssue extends BaseTestBugRegression {

	@Override
	@Test
	public void executeTestCase() throws Exception {
		try{
			OpenAndroidPage.openAndroidPage();
			OpenAndroidPage.clickOnFirstAndroidProduct();
			clickName(BugRegressionAppConstants.BuyNow_button_text);
			GmailLogin.gmailLogin();
//			clickId(AppConstants.Android_phones_id);
//			clickXpath(AppConstants.first_android_phone_xpath);
//			try{
//			if(findElementByName(AppConstants.BuyNow_button_text).isDisplayed()){
//				clickName(AppConstants.BuyNow_button_text);
//				GmailLogin.gmailLogin();
//			}
//			
//			else{
//				backButton();
//				System.out.println("Get Prices button is displayed");
//			}
//			}catch(Exception e){
//				System.out.println("Get Prices button is displayed");
//				e.printStackTrace();
//				throw(e);
//			}
			
			clickId(BugRegressionAppConstants.CheckoutButton_id);
			info("clicking on checkout button");
			clickId(BugRegressionAppConstants.ContinueButton_id);
			info("clicking on continue button");
			clickName(BugRegressionAppConstants.CashOnDelivery_Name);
			info("clicking on CDO");
			clickId(BugRegressionAppConstants.PlaceOrder_id);
			info("Clicking on Placed order id");
			clickId(BugRegressionAppConstants.ShopMore_id);
			info("clicking on Shop More");
			clickCart();
			AssertJUnit.assertTrue(AppVerificationChecks.NoItemInCartLabel
					.equals(findElementById(BugRegressionAppConstants.NoItemInCartLabel_id)
							.getText()));

			
			
		}catch(Exception e){
			e.printStackTrace();
			takeSnapShot("D:\\takeScreenshots", "Placed Order issue");
			throw(e);
			
		}
		
	}

}
