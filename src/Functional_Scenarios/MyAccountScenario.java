package Functional_Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.ChangeZopperPassword;
import App_Functions.GmailLogin;
import App_Functions.NormalLogin;
import App_Functions.OpenHomePage;
import App_Functions.OpenLoginPage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;
import Utility.PincodeValidator;
import Utility.ProductDescValidator;
import Utility.PhoneNumberValidator;
import Utility.LocalityValidator;

import Utility.PincodeValidator;
import Utility.ProductDescValidator;
import Utility.PhoneNumberValidator;
import Utility.LocalityValidator;

import com.relevantcodes.extentreports.LogStatus;
import Utility.PhoneNumberValidator;
import Utility.PincodeValidator;

//Test case info:In this test case we are  verifying multiple cases
//In first test case we are verifying connection error should get displayed MY account page on closing internet connection
//In second test  case we are verifying forget password functionality
//Author: Arvind
public class MyAccountScenario extends BaseTestBugRegression {

	public String verifyConnectionErrorOnAllTabs() {
		String tabs = AppData.ConnectionErrortext;
		int i = 1;
		try {
			WebElement element = driver.findElement(By.className(SanitySuiteAppConstants.MyAccountTabsParent_class));
			List<WebElement> elements = element
					.findElements(By.className(SanitySuiteAppConstants.MyAccountTabsChilld_class));
			for (WebElement elemnt : elements) {
				elemnt.click();
				try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(BugRegressionAppConstants.ConnectionErrorPage_name)));
				}catch(Exception e){
					wait.until(ExpectedConditions.presenceOfElementLocated(By.name(BugRegressionAppConstants.ConnectionErrorPage_name)));
				}
				if (verifyElementDisplayedByName(BugRegressionAppConstants.ConnectionErrorPage_name)) {
				} else {
					tabs = tabs + " Tab " + i;
				}
				i++;
				backButton();
				if(findElementsById(BugRegressionAppConstants.OkButton_Id).size()>0){
					clickId(BugRegressionAppConstants.OkButton_Id);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		return tabs;
	}

	@Test(enabled = false)
	public void verifyConnectionErrorOnMyAccountPage() throws Exception {
		try {
			extentInfoLogs("Open login page");
			OpenLoginPage.openLoginPage();
			extentInfoLogs("Gmail Login Page");
			GmailLogin.gmailLogin();
			Thread.sleep(5000);
			extentInfoLogs("Switch off the wifi");
			hitADBCommandForWiFi("off");
			Thread.sleep(8000);
			extentInfoLogs("Verify connection error on my account tabs");
			String err_Tabs = verifyConnectionErrorOnAllTabs();
			Assert.assertEquals(err_Tabs, AppData.ConnectionErrortext);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			extentInfoLogs("Open Wi-Fi connection");
			hitADBCommandForWiFi("on");
		}
	}

	//@Test(enabled = true)
	public void forgotPasswordFunctionality() throws Exception {
		boolean flag = false;
		try {
			extentInfoLogs("Open Login Page");
			OpenLoginPage.openLoginPage();
			extentInfoLogs("Click Forgot password link");
			clickId(BugRegressionAppConstants.Forgot_Password_Link_id);
			extentInfoLogs("sending data for email id");
			clickId(BugRegressionAppConstants.Forgot_Email_id);
			sendKeysForID(BugRegressionAppConstants.Forgot_Email_id, AppData.UserId);

			extentInfoLogs("Click submit button");
			clickId(BugRegressionAppConstants.Forgot_Submit_id);
			Thread.sleep(5000);
			extentInfoLogs("Close Appium Session");
			closeAppiumSession();

			extentInfoLogs("Open selenium browser");
			ChangeZopperPassword.openBrowser(AppData.Rediff_URL);

			extentInfoLogs("Rediff login");
			ChangeZopperPassword.rediffLogin();

			ChangeZopperPassword.closeChildWindow();

			extentInfoLogs("Click on mail box link");
			ChangeZopperPassword.openMailBox();

			ChangeZopperPassword.closeChildWindow();

			extentInfoLogs("Click on mail");
			ChangeZopperPassword.clickChangePasswordMail();
			Thread.sleep(5000);

			extentInfoLogs("Click on link in mail");
			ChangeZopperPassword.clickMailLink();

			Thread.sleep(5000);

			extentInfoLogs("Switch to child window");
			ChangeZopperPassword.switchToChildWindow();

			extentInfoLogs("Reset password");
			flag = ChangeZopperPassword.resetPassword();

			extentInfoLogs("Close selenium session");
			ChangeZopperPassword.closeBrowser();

			Assert.assertEquals(flag, true);

			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}
	
	@Test(enabled=true)
	public void newForgotPasswordFunctionality() throws Exception{
		try{
			
			extentInfoLogs("Open Login Page");
			OpenLoginPage.openLoginPage();
			extentInfoLogs("Click Forgot password link");
			clickId(BugRegressionAppConstants.Forgot_Password_Link_id);
			extentInfoLogs("sending data for email id");
			clickId(BugRegressionAppConstants.Forgot_Email_id);
			sendKeysForID(BugRegressionAppConstants.Forgot_Email_id, AppData.UserNo);
			extentInfoLogs("Click submit button");
			clickId(BugRegressionAppConstants.Forgot_Submit_id);
			Thread.sleep(5000);
		}catch(Exception e)
		{
			throw(e);
		}
	}

	@Test(enabled = false, dependsOnMethods = { "newForgotPasswordFunctionality" })
	public void loginWithChangedPassword() throws Exception {
		boolean flag = false;
		try {
			extentInfoLogs("open Login Page");
			OpenLoginPage.openLoginPage();

			extentInfoLogs("Enter Login user name");
			clickId(BugRegressionAppConstants.Login_UserName_Id);
			sendKeysForID(BugRegressionAppConstants.Login_UserName_Id, AppData.UserId);

			extentInfoLogs("Enter Login Password");
			sendKeysForID(BugRegressionAppConstants.Login_Password_Id, AppData.password);

			extentInfoLogs("Click On Login button");
			clickId(BugRegressionAppConstants.Login_Button_id);

			// extentInfoLogs("Open My Account Page");
			// clickClassName(App_Constants.Open_Navigation_Drawer);
			// clickId(App_Constants.SignUpIcon_id);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(AppData.UserId)));
			flag = verifyElementDisplayedByName(AppData.UserId);
			Assert.assertEquals(flag, true);
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	@Test(enabled = false)
	public void logOutPopupOnMyAccount() throws Exception {
		try {
			extentInfoLogs("Open Login Page");
			OpenLoginPage.openLoginPage();
			extentInfoLogs("Gmail Login Page");
			GmailLogin.gmailLogin();
			Thread.sleep(2000);
			clickId(BugRegressionAppConstants.Logout_button_Prod_id);

			extentInfoLogs("Verifying Logout pop out");
			Assert.assertTrue(findElementById(BugRegressionAppConstants.myAccount_LogOutPopupMessage_Id).isDisplayed());

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}
	
	@Test(enabled = false)
	public void forgotPasswordFunctionality_SocialLogin() throws Exception {
		try {
			extentInfoLogs("Open Login Page");
			OpenLoginPage.openLoginPage();
			extentInfoLogs("Click Forgot password link");
			clickId(BugRegressionAppConstants.Forgot_Password_Link_id);
			extentInfoLogs("sending data for email id");
			clickId(BugRegressionAppConstants.Forgot_Email_id);
			sendKeysForID(BugRegressionAppConstants.Forgot_Email_id, AppData.Gmail_MailId);

			extentInfoLogs("Click submit button");
			clickId(BugRegressionAppConstants.Forgot_Submit_id);

			Thread.sleep(2000);
			backButton();

			clickId(BugRegressionAppConstants.Forgot_Password_Link_id);
			extentInfoLogs("sending data for email id");
			clickId(BugRegressionAppConstants.Forgot_Email_id);
			sendKeysForID(BugRegressionAppConstants.Forgot_Email_id, AppData.Facebook_MailId);

			extentInfoLogs("Click submit button");
			clickId(BugRegressionAppConstants.Forgot_Submit_id);

			extentInfoLogs("Close Appium Session");
			closeAppiumSession();

			extentInfoLogs("Open selenium browser");
			ChangeZopperPassword.openBrowser(AppData.Gmail_URL);
			extentInfoLogs("Gmail login");
			ChangeZopperPassword.gMailLogin(AppData.Gmail_MailId, AppData.password);
			extentInfoLogs("Click on received change password link");
			Thread.sleep(5000);
			ChangeZopperPassword.clickOnZopperForgotPasswordLink();

			Thread.sleep(5000);

			extentInfoLogs("Switch to child window");
			ChangeZopperPassword.switchToChildWindow();

			extentInfoLogs("Reset zopper password");
			ChangeZopperPassword.changeZopperGmailPassword(AppData.password);

			wDriver.quit();
			
			extentInfoLogs("Open selenium browser");
			ChangeZopperPassword.openBrowser(AppData.Gmail_URL);

			extentInfoLogs("Gmail login");
			ChangeZopperPassword.gMailLogin(AppData.Facebook_MailId, AppData.password);
			extentInfoLogs("Click on received change password link");
			ChangeZopperPassword.clickOnZopperForgotPasswordLink();
			
			Thread.sleep(5000);
			
			extentInfoLogs("Switch to child window");
			ChangeZopperPassword.switchToChildWindow();

			extentInfoLogs("Reset zopper password");
			ChangeZopperPassword.changeZopperGmailPassword(AppData.password);
			
			wDriver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}
	
	
	@Test(enabled = false)
    public void fieldVerificationForNewAddress()
    {
            try
            {
                    extentInfoLogs("open Home Page");
                    OpenHomePage.openHomePage();
                    clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
                     extentInfoLogs( "open navigation drawer");
                     String current_location=findElementById(BugRegressionAppConstants.NavDrawer_Location_Id).getText();
                     String current_locality=findElementById(BugRegressionAppConstants.NavDrawer_Locality_Id).getText();
                     for(int i=0;i<3;i++)
                     {
                             if(findElementsById(BugRegressionAppConstants.NavDrawer_Login_Id).size()>0)
                             {
                                     clickId(BugRegressionAppConstants.NavDrawer_Login_Id);
                                     break;
                             }
                             else
                             {
                                     swipeVertically_FullPage();
                             }
                     }
                     NormalLogin.normalLogin();
                     Assert.assertTrue(findElementByName(BugRegressionAppConstants.Myaccount_text).isDisplayed());
                     String Current_UserName=findElementById(BugRegressionAppConstants.NavDrawer_NameProfile_Id).getText();
                     String Current_Email=findElementById(BugRegressionAppConstants.UserEmailtext_id).getText();
                     for(int i=0;i<2;i++)
                     {
                             if(findElementsById(BugRegressionAppConstants.MyAccount_Address_Id).size()>0)
                             {
                                     clickId(BugRegressionAppConstants.MyAccount_Address_Id);
                                     break;
                             }
                             else
                             {
                                     swipeVertically_FullPage();
                             }
                     }
                     extentInfoLogs( "open address page");
                     Assert.assertTrue(findElementByName(BugRegressionAppConstants.Address_Address_Text).isDisplayed());
                     if(findElementsById(BugRegressionAppConstants.Address_Saved_Address_Id).size()>0)
                     {
                             clickId(BugRegressionAppConstants.Address_Add_New_For_Saved_Id);
                     }
                     else
                     {
                             clickId(BugRegressionAppConstants.Address_Add_New_No_Saved_Id);
                     }
                     Assert.assertEquals(findElementById(BugRegressionAppConstants.Address_FullName_Id).getText(), Current_UserName);
                     Assert.assertEquals(findElementById(BugRegressionAppConstants.Address_Email_Id).getText(), Current_Email);
                     String phonenumber=findElementById(BugRegressionAppConstants.Address_PhoneNumber_Id).getText();
                     PhoneNumberValidator pnv=new PhoneNumberValidator();
                     boolean valid1 = pnv.validate(phonenumber);
                     extentInfoLogs( "applying validator");
                     Assert.assertEquals(valid1, true);
                     
                     if(findElementsById(BugRegressionAppConstants.Address_Locality_Id).size()>0)
                     {
                             String new_address_locality=findElementById(BugRegressionAppConstants.Address_Locality_Id).getText();
                             Assert.assertEquals(new_address_locality, current_locality);
                     }
                     else
                     {
                             swipeVertically_FullPage();
                     }
                     
                     if(findElementsById(BugRegressionAppConstants.Address_location_Id).size()>0)
                     {
                             String new_address_location=findElementById(BugRegressionAppConstants.Address_location_Id).getText();
                             Assert.assertTrue(current_location.contains(new_address_location));
                     }
                     else
                     {
                             swipeVertically_FullPage();
                     }
                     
                     if(findElementsById(BugRegressionAppConstants.Address_Pincode_Id).size()>0)
                     {
                             String pincode=findElementById(BugRegressionAppConstants.Address_Pincode_Id).getText();
				PincodeValidator pincodev=new PincodeValidator();
                             boolean valid4 = pincodev.validate(pincode);
                             extentInfoLogs( "applying validator");
                             Assert.assertEquals(valid4, true);
//                              Assert.assertTrue(pincode.matches(".*[0-9]{6}"));
                     }
                     else
                     {
                             swipeVertically_FullPage();
                     }
            }
            catch(Exception e)
            {
                    throw(e);
            }
    }

	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}
}
