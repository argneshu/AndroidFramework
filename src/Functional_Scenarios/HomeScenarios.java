package Functional_Scenarios;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.AddToCart;
import App_Functions.GmailLogin;
import App_Functions.OpenAndroidPage;
import App_Functions.OpenHomePage;
import App_Functions.OpenLoginPage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;
import Utility.ParamObject;
//import Parameters.APIParameters;
//import StoreAPI.RestClient;
//Test case info:In this test case we are  verifying multiple cases
//In first test case we are verifying recently viewed items
//In second test case we are verifying recently viewed items should get displayed on changing the user
//In third test case we are verifying connection error on page on closing the wifi
//Author : Argneshu Gupta
//import Parameters.APIParameters;
//import StoresAPI.ParamObject;

public class HomeScenarios extends BaseTestBugRegression {
	static String datetype = null;

	@Override
	@Test(enabled  = true)
	public void executeTestCase() throws Exception {
		try {
			extentInfoLogs("Open Android page");
			OpenAndroidPage.openAndroidPage();
			extentInfoLogs("Click on android products");
			OpenAndroidPage.clickOnAndroidProduct_CurrentPage();

			extentInfoLogs("calling back button function");
			backButton();
			extentInfoLogs("Open navigation drawer");
			clickClassName(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage);
			extentInfoLogs("clicking on home ");
			clickName(BugRegressionAppConstants.Hometext_name);

			for (int i = 0; i <= 6; i++) {
				try {
					findElementByName(BugRegressionAppConstants.HomeRecentlyViewedHeader_Text).isDisplayed();
					break;
				} catch (Exception e) {
					swipeVertically_FullPage();
					swipeVertically_FullPage();
					swipeVertically_FullPage();
				}
			}
			extentInfoLogs("Home screen recently viewed header");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomeRecentlyViewedHeader_Text).isDisplayed());

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}

	@Test(enabled  = true)
	public void exploreExcitingCategories() throws Exception {
		try {
			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();
			extentInfoLogs("Retrieving Exciting Categories");
			List<WebElement> excitCat = findElementsById(BugRegressionAppConstants.Home_ExcitingCategory);

			for (WebElement ele : excitCat) {
				String catText = ele.getText();
				ele.click();
				extentInfoLogs("Verifying assertion");
				Assert.assertTrue(findElementByName(catText).isDisplayed());
				navigateBack();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	@Test(enabled  = true)
	public void ExchageOnHomePage() throws Exception {
		try {
			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();
			extentInfoLogs("Adding explicit wait for exciting categories");
			wait.until(ExpectedConditions
					.elementToBeClickable(By.name(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)));
			extentInfoLogs("clicking on Homepage text ");
			for (int i = 0; i <= 10; i++) {
				try {
					findElementByName(BugRegressionAppConstants.HomePageExchange_Text).isDisplayed();
					break;
				} catch (Exception e) {
					swipeVertically_FullPage();
					swipeVertically_FullPage();
				}
			}
			extentInfoLogs("verifying assertion for Home page text");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExchange_Text).isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	// Author: Arvind
	// @Test(enabled = true)
	public void verifyAutoRefreshedRecentlyViewedProduct() throws Exception {
		boolean flag = false;
		try {
			extentInfoLogs("Open login page");
			OpenLoginPage.openLoginPage();
			extentInfoLogs("Login with Gmail");
			GmailLogin.gmailLogin();
			extentInfoLogs("Clicking on back button");
			clickClassName(BugRegressionAppConstants.BackButton_class);
			extentInfoLogs("opening android page from home screen");
			OpenAndroidPage.openAndroidPageFromHomeScreen();
			extentInfoLogs("clicking on first android phone");
			extentInfoLogs("clicking on first android product");
			String prod_Name = OpenAndroidPage.clickOnFirstAndroidProduct();
			extentInfoLogs("Clicking on back button");
			clickClassName(BugRegressionAppConstants.BackButton_class);
			clickClassName(BugRegressionAppConstants.BackButton_class);

			extentInfoLogs("Home Page");
			extentInfoLogs("Opening home page ");
			OpenHomePage.goToHomePage();
			extentInfoLogs("scrolling to recently viewed item");
			scrollTo(BugRegressionAppConstants.Home_RecentltViewed_name);
			for (int i = 1; i <= 2; i++) {
				swipeVertically(300);
				flag = verifyElementDisplayedByName(prod_Name);
				System.out.println("flag value : " + flag);
			}
			extentInfoLogs("verifying displayed name");
			Assert.assertEquals(flag, true);
			extentInfoLogs("Logout from Page");
			extentInfoLogs("log out from page");
			OpenLoginPage.logOutFromPage();

			extentInfoLogs("Login with different User");
			extentInfoLogs("login with different with valid username and password");
			clearEditFieldByID(BugRegressionAppConstants.Login_UserName_Id);
			sendKeysForID(BugRegressionAppConstants.Login_UserName_Id, AppData.UserId);
			clearEditFieldByID(BugRegressionAppConstants.Login_UserName_Id);
			sendKeysForID(BugRegressionAppConstants.Login_UserName_Id, AppData.UserId);
			sendKeysForID(BugRegressionAppConstants.Login_Password_Id, AppData.password);
			clickId(BugRegressionAppConstants.Login_Button_id);
			extentInfoLogs("clicking on back button");
			clickClassName(BugRegressionAppConstants.BackButton_class);
			extentInfoLogs("opening home page");
			extentInfoLogs("Home Page");
			OpenHomePage.goToHomePage();
			extentInfoLogs("scroll to recently viewed items");
			scrollTo(BugRegressionAppConstants.HomeRecentlyViewedHeader_Text);
			for (int i = 1; i <= 2; i++) {
				swipeVertically(300);
				flag = verifyElementDisplayedByName(prod_Name);
				// System.out.println("flag value : " + flag);
			}
			extentInfoLogs("verifying displayed name");
			Assert.assertEquals(flag, false);

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void internetConnectionIssue() throws Exception {
		try {
			extentInfoLogs("Open Android page");
			OpenAndroidPage.openAndroidPage();
			extentInfoLogs("Clicking on Android phones");
			//clickName(BugRegressionAppConstants.AndroidPhones_name);
			clickByName(BugRegressionAppConstants.SmartphoneName, BugRegressionAppConstants.SmartphoneName);
			extentInfoLogs("click on first android product");
			OpenAndroidPage.clickOnFirstAndroidProduct();
			extentInfoLogs("Click on first android product");
			clickName(BugRegressionAppConstants.BuyNow_button_text);
			AddToCart.addToCart();
			extentInfoLogs("clicking on Buy Now button");
			Thread.sleep(2000);
			extentInfoLogs("Turn off the wifi");
			hitADBCommandForWiFi("off");
			extentInfoLogs("click on back button");
			clickClassName(BugRegressionAppConstants.BackButton_class);
			extentInfoLogs("Verify assertion for connection error");
			Assert.assertEquals(findElementById(BugRegressionAppConstants.ConnectionErrorPage_id).getText(),
					AppData.ConnectionErrortext);

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			extentInfoLogs("Turn on the wifi");
			hitADBCommandForWiFi("on");
		}
	}

	@Test(enabled  = true)
	public void verifyDevice_HomeButton_Scenerio() throws Exception {
		try {
			extentInfoLogs("Open login page");
			OpenLoginPage.openLoginPage();

			extentInfoLogs("Press device home button");
			Runtime.getRuntime().exec("adb shell input keyevent 3");
			Thread.sleep(2000);

			try {
				Assert.assertFalse(findElementsById(SanitySuiteAppConstants.Google_SignInId).size() > 0);
				findElementsById(SanitySuiteAppConstants.Google_SignInId).get(0).click();
			} catch (Exception e) {
				driver.startActivity(Con_Package_Name, Con_Activity_Name);
				Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
						.getText().equals(AppData.HomePageExploreExcitingCategories_text));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	@Test(enabled  = true)
	public void callInterruption_Scenerio() throws Exception {
		try {
			extentInfoLogs("Install Fake Caller");
			System.out.println(path);
			Runtime.getRuntime().exec("adb install " + path + "/app/Assistant_com.popularapp.fakecall.apk");
			Thread.sleep(10000);

			extentInfoLogs("Launch Fake Caller");
			driver.startActivity(AppData.Fake_Caller_PackageName, AppData.Fake_Caller_ActivityName);
			extentInfoLogs("Enter caller name");
			sendKeysForID(SanitySuiteAppConstants.Caller_Name_Id, AppData.Fake_Caller_Name);
			extentInfoLogs("Enter caller Mobile number");
			Thread.sleep(10000);
			sendKeysForID(SanitySuiteAppConstants.Caller_Number_Id, AppData.Fake_Caller_MobNo);
			extentInfoLogs("Click on time set button");
			clickName(SanitySuiteAppConstants.Caller_TimeSet_Text);
			extentInfoLogs("Select time as 30 Sec");
			clickName(SanitySuiteAppConstants.Caller_TimeInMinutes_Text);
			extentInfoLogs("Click on save button");
			clickId(SanitySuiteAppConstants.Caller_SaveButton_Id);

			extentInfoLogs("Launch Consumer app");
			driver.startActivity(Con_Package_Name, Con_Activity_Name);

			extentInfoLogs("Open login page");
		//	OpenLoginPage.openLoginPage();
			OpenHomePage.openHomePage();

			Thread.sleep(15000);

			extentInfoLogs("Uninstall Fake Caller");
			hitADBCommandForUninstallCallerApp();
			
			Thread.sleep(5000);
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.HomePageExploreExcitingCategories_text)
					.getText().equals(AppData.HomePageExploreExcitingCategories_text));

		//	Assert.assertTrue(findElementsById(SanitySuiteAppConstants.Google_SignInId).size() > 0);

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			hitADBCommandForUninstallCallerApp();
		}
	}

	@Test(enabled = false)
	public void clickOnBanners() throws Exception {
		try {
			extentInfoLogs("Create banner");
			String offerid = createBanner();
			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();
			extentInfoLogs("open nav drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("clicking on nav drawer location title");
			clickId(BugRegressionAppConstants.NavDrawerLocationTitle_id);
			clickOnCategoryByName(BugRegressionAppConstants.LocatioCity_id, AppData.VadodaraCity);
			extentInfoLogs("clicking on vadodara");
			clickName(BugRegressionAppConstants.VadodaraCity);
			extentInfoLogs("clicking on akota");
			clickName(BugRegressionAppConstants.Akotalocation);
			extentInfoLogs("click on Home");
			clickId(BugRegressionAppConstants.Homelink_id);
			extentInfoLogs("Verifying assert for banner id");
			Assert.assertTrue(findElementsById(BugRegressionAppConstants.Banners_id).size() > 0);
			extentInfoLogs("click on banner id");
			clickId(BugRegressionAppConstants.Banners_id);
			extentInfoLogs("Verifying assert for android phones");
			Assert.assertTrue(findElementsByName(BugRegressionAppConstants.Android_Phone_text).size() > 0);
			extentInfoLogs("Delete banner");
			deleteBanner(offerid);
		} catch (Exception e) {
			e.getMessage();
			throw (e);

		}

	}

	public static ParamObject apiCreateBannerParameters(String payload) {
		String url = "http://52.72.9.68/offerzone/";
		ParamObject obj = new ParamObject();
		obj.setUrl(url);
		obj.setMethodType("POST");
		obj.setPayload(payload);
		return obj;
	}

	public static ParamObject apiDeleteBannerParameters(String payload) {
		String url = "http://52.72.9.68/banner/";
		ParamObject obj = new ParamObject();
		obj.setUrl(url);
		obj.setMethodType("PUT");
		obj.setPayload(payload);
		return obj;
	}

	public static String createBannerPayload(String regionid, String client, String clientversion, String date,
			String nextdate) throws JSONException {// ,String startdate, String
													// enddate)
		JSONObject root = new JSONObject();// {}
		JSONArray regionarray = new JSONArray();// []
		regionarray.put("25");
		JSONArray filter = new JSONArray();
		JSONArray templatewidget = new JSONArray();
		JSONObject templateroot = new JSONObject();
		JSONObject bpayload = new JSONObject();
		JSONObject fields = new JSONObject();
		root.put("name", "test");
		root.put("Region_ID", regionarray);
		root.put("Client_Name", client);
		root.put("Client_Version", clientversion);
		root.put("Start_Date", date);
		root.put("End_Date", nextdate);
		root.put("is_campaign", true);
		fields.put("bannerLink", "http://media.zopper.com/media/app_home_banner/01-01-2016/smartphones.jpg");
		fields.put("bannerActionType", "PROD_LISTING");
		bpayload.put("id", "230");
		bpayload.put("cat_name", "Android Phones");
		bpayload.put("sort_on", "");
		bpayload.put("filters", filter);
		fields.put("payload", bpayload);
		root.put("Template_Widgets", templatewidget);
		fields.put("is_active", true);
		fields.put("priority", "1");
		templateroot.put("is_active", true);
		templateroot.put("priority", "1");
		templateroot.put("fields", fields);
		templatewidget.put(templateroot);
		System.out.println(root.toString());
		return root.toString();

	}

	public static String deleteBannerPayload(String offerid) throws JSONException, IOException {
		JSONObject root = new JSONObject();
		root.put("is_active", false);
		root.put("offerid", offerid);
		// System.out.println(root.toString());
		return root.toString();

	}

	public static String createBanner() throws JSONException, IOException {
		String offerid = null;
		String date = getCurrentDateTime();
		System.out.println(date);
		String nextdate = getNextdayDateTime();
		System.out.println(nextdate);
		try {
			String payload = HomeScenarios.createBannerPayload("25", "1", "12700", date, nextdate);
			ParamObject params = apiCreateBannerParameters(payload);
			String jsonString = (String) Utility.RestClient.getJSONFromParamsObject(params,Utility.RestClient.RETURN_JSON_STRING);
			// System.out.println(jsonString);
			JSONObject obj = new JSONObject(jsonString);
			offerid = obj.getString("offer_id");
		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}
		return offerid;
	}

	public static String deleteBanner(String offerid) throws JSONException, IOException {
		try {
			String payload = HomeScenarios.deleteBannerPayload(offerid);
			ParamObject param = apiDeleteBannerParameters(payload);
			String jsonString = (String) Utility.RestClient.getJSONFromParamsObject(param,
					Utility.RestClient.RETURN_JSON_STRING);
		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}
		return "";
	}

	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");// "20-01-2016
																			// 23:59:00"
		// get current date time with Date()
		Date date = new Date();
		// System.out.println(dateFormat.format(date));

		// get current date time with Calendar()
		Calendar cal = Calendar.getInstance();
		String datetype = dateFormat.format(cal.getTime());
		// System.out.println(dateFormat.format(cal.getTime()));
		return datetype;
	}

	public static String getNextdayDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");// "20-01-2016
																			// 23:59:00"
		// get current date time with Date()
		Date date = new Date();
		// System.out.println(dateFormat.format(date));

		// get current date time with Calendar()
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		date = cal.getTime();
		String nextdate = dateFormat.format(cal.getTime());
		// System.out.println(nextdate);
		// String datetype = dateFormat.format(cal.getTime());
		// System.out.println(dateFormat.format(cal.getTime()));
		return nextdate;
	}

	public static void main(String args[]) throws JSONException, IOException {
		// getCurrentDateTime();
		createBanner();
		// getNextdayDateTime();
		// createBanner();
		// deleteBanner();
		// bannerPayload("25", "1", "12700");
	}

}
