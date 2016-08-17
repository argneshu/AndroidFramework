package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenAndroidPage;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppVerificationChecks;

//Test case info: In this case we are verifying that whether the cart gets empty or not on deleting last item from it


public class ShoppingCartProductDelete extends BaseTestBugRegression {

	@Override
	@Test
	public void executeTestCase() throws Exception {
		
		try{
			OpenAndroidPage.openAndroidPage();
			OpenAndroidPage.clickOnFirstAndroidProduct();
//			clickId(AppConstants.Android_phones_id);
//			clickXpath(AppConstants.first_android_phone_xpath);
//			if(findElementByName(AppConstants.BuyNow_button_text).isDisplayed()){
				clickName(BugRegressionAppConstants.BuyNow_button_text);
				GmailLogin.gmailLogin();
				clickId(BugRegressionAppConstants.ShoppingCartDeleteButton_id);//Need to put check here to delete all items from cart
				clickId(BugRegressionAppConstants.DeleteCartItemPrompt_id);
				AssertJUnit.assertTrue(AppVerificationChecks.NoItemInCartLabel
						.equals(findElementById(BugRegressionAppConstants.NoItemInCartLabel_id)
								.getText()));

//			}
//
//			else {
				//System.out.println("Get Prices button is displayed");
//				backButton();
//				clickXpath(AppConstants.second_android_phone_xpath);
//				if (findElementById(AppConstants.GetPricesButton_id).isDisplayed()) {
//					System.out.println("Get Price button is displayed");
//				} else {
//					clickName(AppConstants.BuyNow_button_text);
//					GmailLogin.gmailLogin();
//					clickId(AppConstants.ShoppingCartDeleteButton_id);
//					clickId(AppConstants.DeleteCartItemPrompt_id);
//					Assert.assertTrue(AppVerificationChecks.NoItemInCartLabel
//							.equals(findElementById(
//									AppConstants.NoItemInCartLabel_id).getText()));
//				}
			
		}
			catch(Exception e){
				e.printStackTrace();
				takeSnapShot("D:\\takeScreenshots", "Shopping product cart delete");
				throw(e);
			}
	}}


