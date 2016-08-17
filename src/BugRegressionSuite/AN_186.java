package BugRegressionSuite;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenLoginPage;
import Page_Objects.BugRegressionAppConstants;

public class AN_186 extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		
		try{
			OpenLoginPage.openLoginPage();
			//clickClassName(AppConstants.Back_Arrow_ClassName);
			//System.out.println("opening nav");
			//clickClassName(AppConstants.Open_Navigation_Drawer);
//			clickId(AppConstants.Lets_Go_Shopping_Id);
//			clickName(AppConstants.DetectAutomatically_name);
//			sendKeysForID(AppConstants.login_passwd_id,"shashank@24");
//			clickName(AppConstants.LoginButton_name);
//			Assert.assertEquals("Home", findElementByName(AppConstants.Home_name).getText());
//			clickClassName(AppConstants.Open_Navigation_Drawer);
//			//clickName(AppConstants.LoginButton_name);
//			//System.out.println(findElementById(AppConstants.NavDrawer_Login_button_id).getText());
//			//String name=new String(findElementById(AppConstants.NavDrawer_Login_button_id).getText());
			//clickId(AppConstants.NavDrawer_Login_button_id);
			sendKeysForName(BugRegressionAppConstants.Email_name, "vinay.kumar@zopper.com");
			sendKeysForID(BugRegressionAppConstants.login_passwd_id,"zopper");
			//Thread.sleep(5000);
			clickId(BugRegressionAppConstants.Login_Button_Id);
			//navigateBack();
			//Thread.sleep(1000);
			clickClassName(BugRegressionAppConstants.Back_Arrow_ClassName);
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			System.out.println("opening nav drawer");
			String name=new String(findElementById(BugRegressionAppConstants.NavDrawer_Login_button_id).getText());
			System.out.println(findElementById(BugRegressionAppConstants.NavDrawer_Login_button_id).getText());
			AssertJUnit.assertEquals(name, findElementById(BugRegressionAppConstants.ProfileName_id).getText());
			System.out.println("After Test");
			
		}
		catch(Throwable e){
			e.printStackTrace();
			//System.out.println("Inside Outer Catch");
		}
	}

}

