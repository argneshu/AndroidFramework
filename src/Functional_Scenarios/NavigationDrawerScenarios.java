package Functional_Scenarios;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenHomePage;
import App_Functions.OpenLoginPage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;
import Utility.EmailValidator;
import Utility.UsernameValidator;

public class NavigationDrawerScenarios extends BaseTestBugRegression {
	// Test case info:In this test case we are verifying mutiple scenarios for
	// navigation drawer functionality
	// In first test case we are verifying all root categories are clickable in
	// nav drawer
	// In second test case we are verifying gmail login from nav Drawer
	// In third test case we are verifyig normal user login
	// In fourth test case we are verifying trending products screen
	// In fifth test case we are verifying Popular category
	// Author : Argneshu Gupta

	@Override
	@Test(enabled = true)
	public void executeTestCase() throws Exception {
		try {
			extentInfoLogs( "open Home Page");
			OpenHomePage.openHomePage();
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs( "open navigation drawer");
			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			extentInfoLogs( "click on Mobile and tablets link");
			Assert.assertTrue(
					findElementByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link).getText().equals(AppData.MTtext));
			extentInfoLogs( "verifying assertion");
			clickClassName(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage);
			extentInfoLogs( "open navigation drawer");
			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Kitchen_Appliances_link);
			extentInfoLogs( "click on Kitchen appliances link");
			Assert.assertTrue(
					findElementByName(BugRegressionAppConstants.NavDrawer_Kitchen_Appliances_link).getText().equals(AppData.KAtext));
			extentInfoLogs( "verifying assertion");
			clickClassName(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage);
			extentInfoLogs( "open navigation drawer");
			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Home_Appliances_link);
			extentInfoLogs( "click on Home appliances link");
			Assert.assertTrue(
					findElementByName(BugRegressionAppConstants.NavDrawer_Home_Appliances_link).getText().equals(AppData.HAtext));
			extentInfoLogs( "verifying assertion");
			clickClassName(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage);
			Thread.sleep(2000);
			//swipeWithAxis(10, 500, 50, 200, 2000);
			extentInfoLogs( "open navigation drawer");
			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_TV_Home_Entertainment_link);
			extentInfoLogs( "click on Tv and video appliances link");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.NavDrawer_TV_Home_Entertainment_link).getText()
					.equals(AppData.TVVtext));
			extentInfoLogs( "verifying assertion");
			clickClassName(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage);
			Thread.sleep(2000);
			//swipeWithAxis(10, 500, 50, 200, 2000);
			extentInfoLogs("open navigation drawer");

			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawerComputerAccessorieslink_name);
			extentInfoLogs( "click on Computer Acessories link");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.NavDrawerComputerAccessorieslink_name).getText()
					.equals(AppData.CAtext));
			extentInfoLogs( "verifying assertion");
			clickClassName(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage);
			Thread.sleep(2000);
			//swipeWithAxis(10, 500, 50, 200, 2000);
			extentInfoLogs( "open navigation drawer");

			//swipeWithAxis(10, 500, 50, 200, 2000);
	
			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawerPersonalCare_name);
			extentInfoLogs( "click on Personal care link");
			Assert.assertTrue(
					findElementByName(BugRegressionAppConstants.NavDrawerPersonalCare_name).getText().equals(AppData.PCtext));
			extentInfoLogs( "verifying assertion");
			
			clickClassName(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage);
			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawerHomeElectricals);
			extentInfoLogs( "click on Home Electricals link");
			Assert.assertTrue(
					findElementByName(BugRegressionAppConstants.NavDrawerHomeElectricals).getText().equals(AppData.HEtext));
			extentInfoLogs( "verifying assertion");

		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void gmailLoginFromNavDrawer() throws Exception {
		try {
			extentInfoLogs( "open Home Page");
			OpenHomePage.openHomePage();
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs( "open navigation drawer");
			wait.until(ExpectedConditions.elementToBeClickable(By.id(BugRegressionAppConstants.NavDrawer_Login_button_id)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BugRegressionAppConstants.NavDrawer_Login_button_id)));
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);
			extentInfoLogs( "clicking on Login text on nav drawer");
			GmailLogin.gmailLogin();
			extentInfoLogs( "appying gmail functions");
			String text = findElementById(BugRegressionAppConstants.UserEmailtext_id).getText();
			System.out.println(text);
			EmailValidator em = new EmailValidator();
			boolean valid = em.validate(text);
			extentInfoLogs( "validating email id");
			Assert.assertEquals(valid, true);
			extentInfoLogs( "verifying assertion");
			clickClassName(BugRegressionAppConstants.BackButton_class);
			extentInfoLogs( "clicking back button");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs( "open navigation drawer");
			String text1 = findElementById(SanitySuiteAppConstants.NavDrawer_Login_Title_Id).getText();
			UsernameValidator uv = new UsernameValidator();
			boolean valid1 = uv.validate(text1);
			extentInfoLogs( "applying validator");
			Assert.assertEquals(valid1, true);

		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void normalUserLogin() throws Exception {
		try {
			
			extentInfoLogs( "open Home Page");
			OpenHomePage.openHomePage();
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs( "open navigation drawer");
			clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);
			extentInfoLogs( "clicking on Login text on nav drawer");
			sendKeysForID(BugRegressionAppConstants.Login_UserName_Id, AppData.username);
			extentInfoLogs( "entering username");
			sendKeysForID(BugRegressionAppConstants.Login_Password_Id, AppData.password);
			extentInfoLogs( "entering password");
			clickId(BugRegressionAppConstants.LoginButton_id);
			extentInfoLogs( "clicking on login button");
			//extentInfoLogs( "entering password");
			//clickName(BugRegressionAppConstants.LoginButton_name);
//			extentInfoLogs( "clicking on login button");
			String text = findElementById(BugRegressionAppConstants.UserEmailtext_id).getText();
			EmailValidator em = new EmailValidator();
			boolean valid = em.validate(text);
			extentInfoLogs( "validating email id");
			Assert.assertEquals(valid, true);
			extentInfoLogs( "verifying assertion");
			clickClassName(BugRegressionAppConstants.BackButton_class);
			extentInfoLogs( "clicking back button");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs( "open navigation drawer");
			String text1 = findElementById(SanitySuiteAppConstants.NavDrawer_Login_Title_Id).getText();
			UsernameValidator uv = new UsernameValidator();
			boolean valid1 = uv.validate(text1);
			extentInfoLogs( "applying validator");
			Assert.assertEquals(valid1, true);

		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}
	}

//	@Test(enabled = false) // not feasible right now
	public void facebook() throws Exception {
		// startTestCase("gmailLoginFromNavDrawer");
		// extentInfoLogs("executing home functions");
		OpenHomePage.openHomePage();
		clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
		extentInfoLogs("open navigation drawer");
		clickId(BugRegressionAppConstants.NavDrawer_Login_button_id);
		extentInfoLogs("clicking on Login text on nav drawer");

		System.out.println("Click on Fb button");
		clickId(BugRegressionAppConstants.Facebook_button_id);

		Thread.sleep(10000);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if (contextName.contains("WEBVIEW")) {
				driver.context(contextName);
				System.out.println(contextName);
				Thread.sleep(1500);

				List<WebElement> auth = findElementsById(BugRegressionAppConstants.FB_User_Password_Id);

				auth.get(0).sendKeys(AppData.UserId_1);
				auth.get(0).sendKeys(AppData.password);

				clickId(BugRegressionAppConstants.FB_Login_Button_Id);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BugRegressionAppConstants.FB_Login_Button_Id)));

				clickName(AppData.Ok_Text);
			}
		}
		Set<String> handles = driver.getContextHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (handle.contains("WEBVIEW")) {

				// driver.context((String) handles.toArray()[1]);
				driver.switchTo().window(handle);
				System.out.println("mobile web view");
			}
		}

	}

	 @Test(enabled = true)
	public void trendingProductsScreen() throws Exception {
		try {
			extentInfoLogs( "open Login Page");
			OpenLoginPage.openLoginPage();

			extentInfoLogs( "Gmail Login Page");
			GmailLogin.gmailLogin();
			extentInfoLogs( "navigate back");
			backButton();
			
			extentInfoLogs( "Click on cart icon");
			clickId(BugRegressionAppConstants.Prod_Cart_Id);
			extentInfoLogs( "Delete all cart products");
			for (int i = 0; i <= 3; i++) {
				if (findElementsById(BugRegressionAppConstants.CartDeleteButton_Id).size() > 0) {
					List<WebElement> delButton = findElementsById(BugRegressionAppConstants.CartDeleteButton_Id);
					for (int j=0;j<delButton.size();j++) {
						wait.until(ExpectedConditions.elementToBeClickable(By.id(BugRegressionAppConstants.CartDeleteButton_Id)));
						clickId(BugRegressionAppConstants.CartDeleteButton_Id);
						clickName(AppData.Delete_text);
					}
				} else {
					break;
				}
			}
			extentInfoLogs( "Click on tranding products link");
			clickName(AppData.SEEWHATTRENDING_Text);
			extentInfoLogs( "Waiting for cart icon");
			wait.until(ExpectedConditions.elementToBeClickable(By.id(BugRegressionAppConstants.Prod_Cart_Id)));
			extentInfoLogs( "Assert for Trending in you city");
			Assert.assertTrue(findElementByName(AppData.TrendingInYourCity_Text).isDisplayed());
		}
		catch (Exception e)
		{
			e.getMessage();
			throw (e);
		}
	}
	 
	 @Test(enabled=true)
	 public void weCareLink() throws Exception
	 {
		 try
		 {
			 extentInfoLogs( "open Home Page");
			 OpenHomePage.openHomePage();
			 clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			 extentInfoLogs( "open navigation drawer");
			 for(int i=0;i<3;i++)
			 {
				 if(findElementsById(BugRegressionAppConstants.NavDrawer_ContactUs_id).size()>0)
				 {
					 clickId(BugRegressionAppConstants.NavDrawer_ContactUs_id);
					 break;
				 }
				 else
				 {
					 swipeVertically_FullPage();
					 swipeVertically_FullPage();
					 swipeVertically_FullPage();
				 }
			 }
			 Assert.assertTrue(findElementById(BugRegressionAppConstants.WeCare_Email_id).isDisplayed());
			 clickId(BugRegressionAppConstants.WeCare_Email_id);
//			 Assert.assertTrue(findElementByName(BugRegressionAppConstants.Complete_ActionUsing_Link).isDisplayed());
//			 WebElement Client_Selection=findElementById(BugRegressionAppConstants.Email_Client_Selection_Id);
//			 List <WebElement> Email_Clients=Client_Selection.findElements(By.className(BugRegressionAppConstants.Email_Client_Class));
//			 Email_Clients.get(2).click();
//			 clickName(BugRegressionAppConstants.Select_JustOnce_Link);
			 Assert.assertTrue(findElementByName(BugRegressionAppConstants.Gmail_ContactUs_Compose_Link).isDisplayed());
		 }
		 catch(Exception e)
		 {
			 throw(e);
		 }
	 }

 
	 @Test(enabled=true)
     public void phoneNumberlogin()
     {
             try
             {
            	    extentInfoLogs("open home page");
                    OpenHomePage.openHomePage();
                    clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
                    extentInfoLogs("open navigation drawer");
                    clickId(BugRegressionAppConstants.NavDrawer_Login_button_id);
                    extentInfoLogs("clicking on Login text on nav drawer");
                    sendKeysForID(BugRegressionAppConstants.Login_UserName_Id, AppData.PhoneNumber);
                    extentInfoLogs( "entering username");
                    sendKeysForID(BugRegressionAppConstants.Login_Password_Id, AppData.PhonePassword);
                    extentInfoLogs( "entering password");
                    clickId(BugRegressionAppConstants.LoginButton_id);
                    extentInfoLogs( "clicking on login button");
                    String text = findElementById(BugRegressionAppConstants.UserEmailtext_id).getText();
                    EmailValidator em = new EmailValidator();
                    boolean valid = em.validate(text);
                    extentInfoLogs( "validating email id");
                    Assert.assertEquals(valid, true);
                    extentInfoLogs( "verifying assertion");
                    clickClassName(BugRegressionAppConstants.BackButton_class);
                    extentInfoLogs( "clicking back button");
                    clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
                    extentInfoLogs( "open navigation drawer");
                    String text1 = findElementById(SanitySuiteAppConstants.NavDrawer_Login_Title_Id).getText();
                    UsernameValidator uv = new UsernameValidator();
                    boolean valid1 = uv.validate(text1);
                    extentInfoLogs( "applying validator");
                    Assert.assertEquals(valid1, true);
             }
             catch(Exception e)
             {
                     throw(e);
            }
     }


	//@Test(enabled = true)
//	public void viewPopularAndMoreCategory() throws Exception {
//		try {
//			extentInfoLogs( "open Home Page");
//			OpenHomePage.openHomePage();
//			String[] categories = { BugRegressionAppConstants.NavDrawer_Mobile_tablets_link,
//					BugRegressionAppConstants.NavDrawer_Kitchen_Appliances_link, BugRegressionAppConstants.NavDrawer_Home_Appliances_link,
//					BugRegressionAppConstants.NavDrawer_TV_Home_Entertainment_link,
//					BugRegressionAppConstants.NavDrawerComputerAccessorieslink_name, BugRegressionAppConstants.NavDrawerPersonalCare_name };
//			for (String category : categories) {
//				
//				extentInfoLogs( "Click on navigation drawer");
//				clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
//				if (!verifyElementDisplayedByName(category)) {
//					swipeVertically(200);
//				}
//				extentInfoLogs( "Click on "+category);
//				clickName(category);
//				
//				extentInfoLogs( "Assert for popular categories");
//				Assert.assertEquals(findElementById(BugRegressionAppConstants.PopularCategories_id).getText(),
//						AppData.PopularCategoriestext);
			//	swipeVertically_FullPage();
				//extentInfoLogs( "Assert for more categories");
				//Assert.assertEquals(findElementById(BugRegressionAppConstants.MoreCategories_id).getText(),
					//	AppData.MoreCategoriestext);
//				extentInfoLogs( "Assert for android phones");
//				Assert.assertTrue(findElementById(BugRegressionAppConstants.ProductionAndroid_phones_id).isDisplayed());
//				extentInfoLogs( "Assert for iphones");
//				Assert.assertTrue(findElementById(BugRegressionAppConstants.Productioniphone_id).isDisplayed());
//			}
//
//		} catch (Exception e) {
//			e.getMessage();
//			throw (e);
//
//		}
//
//	}
	 
}