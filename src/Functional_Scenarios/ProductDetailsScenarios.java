package Functional_Scenarios;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import Page_Objects.AppVerificationChecks;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;
import Utility.ParamObject;
import Utility.ProductDescValidator;
import Utility.RestClient;
import Utility.UsernameValidator;

import com.relevantcodes.extentreports.LogStatus;
//import Parameters.APIParameters;
//import Payload.APIPayload;
//import Parameters.APIParameters;
//import Parameters.APIParameters;
//import Payload.APIPayload;
//import StoreAPI.ParamObject;
//import StoreAPI.RestClient;
//import Parameters.APIParameters;
//import Payload.APIPayload;
//import StoreAPI.ParamObject;
//import StoreAPI.RestClient;
//import VerificationChecks.Verification_Checks;

//for favorite product function uncheck all the favorite products
//Test case info:we are  verifying multiple cases for Product scenarios
//In first test case case we are verifying Product image,name,button should get displayed for entered products
//In second test case we are verifying single image picture scenario
//In third test case we are verifying Image enlarge scenario
//In fourth test case we are verifying product details for product
//In fifth test case we are verifying for login page if user submit review without login
//In sixth test case we are  verifying product listing should be scrollable
//In seventh test case we are verifying filter for the products

//Author : Argneshu Gupta
public class ProductDetailsScenarios extends BaseTestBugRegression {
	String buildType=".staging";
	//String buildType = "";

	public void clickOnCategoryByName(String category) {

		try {
			List<WebElement> elements = driver
					.findElements(By.id("com.zopperapp" + buildType + ":id/tv_drawer_list_row_title"));
			for (WebElement elemnt : elements) {
				if (elemnt.getText().equalsIgnoreCase(category)) {
					elemnt.click();
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	@Test(enabled = true)
	public void executeTestCase() throws Exception {
		try {

			String[] products = { AppData.Producttext, AppData.Producttext1, AppData.Producttext2,
					AppData.Producttext6, };

			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();

			extentInfoLogs("Click on home page search text box");
			clickId(BugRegressionAppConstants.Home_Search_TextBox_Id);

			for (String product : products) {

				extentInfoLogs("Enter search text as " + product);
				sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, product);

				extentInfoLogs("Click on first auto suggest product");
				clickOnFirstSuggestedProduct();
				//clickXpath(BugRegressionAppConstants.SearchSuggestedFirstProduct_xpath);

				extentInfoLogs("Assert for product title");
				Assert.assertTrue(findElementById(BugRegressionAppConstants.ProductionProductTitle_id).isDisplayed());
				extentInfoLogs("Assert for product image");
				Assert.assertTrue(findElementById(BugRegressionAppConstants.ProductImage_id).isDisplayed());
				extentInfoLogs("Press back button");
				backButton();
			}

		} catch (Exception e) {
			e.getMessage();
			throw (e);

		}

	}

	// @Test(enabled = false)
	// public void singleImagePicture() throws Exception {
	// try {
	// String[] products = { AppData.Producttext4,
	// AppData.Producttext5, AppData.Producttext7, };
	// startTestCase("singleImagePicture");
	// extentInfoLogs("Call the function of home page function");
	// OpenHomePage.openHomePage();
	//
	// clickId(AppConstants.Home_Search_TextBox_Id);
	// extentInfoLogs("Click on Search icon id");
	//
	// for (String product : products) {
	//// Thread.sleep(4000);
	//// swipeWithAxis(350, 750, 350, 250, 2000);
	//
	// sendKeysForID(AppConstants.Home_SearchEditBox_id, product);
	// extentInfoLogs("sending keys on search bar");
	// clickXpath(AppConstants.SearchSuggestedFirstProduct_xpath);
	// extentInfoLogs("clicking suggested product");
	// Assert.assertTrue(findElementById(
	// AppConstants.ProductionProductTitle_id).isDisplayed());
	// Assert.assertTrue(findElementById(
	// AppConstants.ProductImage_id).isDisplayed());
	//
	// }
	// endTestCase("singleImagePicture");
	//
	// } catch (Exception e) {
	// e.getMessage();
	// takeSnapShot("D:\\takeScreenshots",
	// "singleImagePicture");
	// throw (e);
	//
	// }
	//
	// }

	@Test(enabled = true)
	public void productEnlargedImage() throws Exception {

		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			//Thread.sleep(4000);
			//extentInfoLogs("Swipe screen veritically");
			//swipeWithAxis(350, 750, 350, 250, 2000);
			extentInfoLogs("Click on home screen search icon");
			clickId(BugRegressionAppConstants.Home_search_button_id);

			extentInfoLogs("Enter search string as " + AppData.Producttext);
			sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, AppData.Producttext);
			extentInfoLogs("Click on auto suggest first item");
			WebElement searchList =findElementById(BugRegressionAppConstants.SearchList_id);
			List<WebElement> linearlayout = searchList.findElements(By.className(BugRegressionAppConstants.SearchLinearLayout_classname));
			linearlayout.get(0).click();
		//	clickXpath(BugRegressionAppConstants.SearchSuggestedFirstProduct_xpath);
			extentInfoLogs("Click on product image");
			clickId(BugRegressionAppConstants.ProductImage_id);

			Thread.sleep(2000);
			extentInfoLogs("Assert for enlarge product image");
			Assert.assertTrue(findElementById(BugRegressionAppConstants.ProductLargeImage_id).isDisplayed());
			
			extentInfoLogs("Click on buy now button");
			clickId(BugRegressionAppConstants.EnlargedImage_BuyNow_Id);
			
			if(verifyElementExistById(BugRegressionAppConstants.LargeImageBuyNowButton_id))
				clickId(BugRegressionAppConstants.LargeImageBuyNowButton_id);
			GmailLogin.gmailLogin();
			extentInfoLogs("Assert for checkout button");
			wait.until(ExpectedConditions.elementToBeClickable(findElementById(BugRegressionAppConstants.CheckoutButton_id)));
			Assert.assertTrue(findElementById(BugRegressionAppConstants.CheckoutButton_id).isDisplayed());
		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}
	}

	@Test(enabled = true)
	public void productFeaturesDetails() throws Exception {
		boolean flag = false;
		try {
			String[] products = { AppData.Producttext, AppData.Producttext2 };
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();

			extentInfoLogs("Enter search Text");
			clickId(BugRegressionAppConstants.Home_Search_TextBox_Id);

			for (String product : products) {

				extentInfoLogs("Enter search string as " + product);
				sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, product);
				extentInfoLogs("Click on auto suggest first item");
				OpenAndroidPage.clickOnCategoryByName(BugRegressionAppConstants.AutoSuggestSearch_id, product);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SanitySuiteAppConstants.Cart_id)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BugRegressionAppConstants.ProductionProductTitleOnProductDetails_id)));
				extentInfoLogs("Swipe vertically");
				for (int i = 0; i < 3; i++) {
					if (flag) {
						flag = false;
						break;
					}
					swipeVertically_FullPage();
					swipeVertically_FullPage();
					try {
						if (findElementsByName(BugRegressionAppConstants.ProductDetailsPageFirstViewAll_Text)
								.size() > 0) {
							for (; flag == false;) {
								System.out.println("Product Found");
								Thread.sleep(2000);
								clickName(BugRegressionAppConstants.ProductDetailsPageFirstViewAll_Text);
								if (findElementsByName(BugRegressionAppConstants.ProductDetailsPageFirstViewAll_Text)
										.size() > 0) {

								} else {
									flag = true;
									break;
								}
							}
						}
					} catch (Exception e) {
						swipeVertically_FullPage();
					}
				}
				extentInfoLogs("clicking on View all link");

				extentInfoLogs("Assert for general features");
				Assert.assertTrue(findElementByName(BugRegressionAppConstants.ProductFeature_Text).isDisplayed());
				extentInfoLogs("click on back button");
				backButton();

				Thread.sleep(2000);
				swipeWithAxis(100, 300, 100, 900, 1000);
				backButton();

			}

		} catch (Exception e) {
			e.getMessage();
			throw (e);

		}
	}

	@Test(enabled = true)
	public void loginCheckForSubmitReview() throws Exception {
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			selectCity("Delhi", "");
			extentInfoLogs("Click on home screen search box");
			clickId(BugRegressionAppConstants.Home_Search_TextBox_Id);
			extentInfoLogs("Enter search string as " + AppData.Producttext);
			sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, AppData.Producttext);
			extentInfoLogs("Click on auto suggest first item");
			// clickXpath(BugRegressionAppConstants.SuggestedProductForSubmitReviewScenario);
			clickOnCategoryByName(BugRegressionAppConstants.AutoSuggestSearch_id, AppData.Producttext);
			extentInfoLogs("Swipe screen verically");
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SanitySuiteAppConstants.Cart_id)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BugRegressionAppConstants.ProductionProductTitleOnProductDetails_id)));
			
			for (int i = 0; i < 5; i++) {
				swipeWithAxis(100, 600, 100, 250, 3000);
			}
			extentInfoLogs("Click on stars for review");
			
			WebElement reviewStarList = findElementById(BugRegressionAppConstants.ReviewListingId);
			List<WebElement> reviewStars = reviewStarList.findElements(By.className(BugRegressionAppConstants.Open_Navigation_Drawer));
			reviewStars.get(4).click();
			
			extentInfoLogs("Click on submit review");
			clickId(BugRegressionAppConstants.SubmitReviewDoneId);
////			boolean flg = false;
////			for (; flg == false;) {
////				if (findElementsById(BugRegressionAppConstants.SubmitReview_id).size() > 0) {
////					clickId(BugRegressionAppConstants.SubmitReview_id);
////				} else {
////					flg = true;
////					break;
////				}
////			}
//			//WebElement parentList = driver.findElement(By.id(BugRegressionAppConstants.ReviewRatingList_id));
//			//List<WebElement> childList= parentList.findElements(By.className("android.widget.ImageView"));
//			//System.out.println("the size is " + childList);
//			//childList.get(3).click();
//			driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[5]")).click();
//
//			
////			extentInfoLogs("Click on product review");
////			clickId(BugRegressionAppConstants.ProductionProductReviewsPencilIcon_id);
////			extentInfoLogs("Click on star rating");
////			clickName(BugRegressionAppConstants.ReviewProductFiveStarRating_text);
//			extentInfoLogs("Check for review product title");
//			if (findElementById(BugRegressionAppConstants.ProductionReviewProductTitle_ID).isDisplayed()) {
//				clearForId(BugRegressionAppConstants.ProductionReviewProductTitle_ID);
//			}
//			extentInfoLogs("Swipe screen vertically");
//		//	swipeVertically(150);
//		//	extentInfoLogs("Enter review product title");
//			sendKeysForID(BugRegressionAppConstants.ProductionReviewProductTitle_ID, AppData.title);
//
//			if (findElementById(BugRegressionAppConstants.ProductionReviewProductDescription_ID).isDisplayed()) {
//				clearForId(BugRegressionAppConstants.ProductionReviewProductDescription_ID);
//			}
//
////			extentInfoLogs("Swipe screen vertically");
//		//	swipeVertically(300);
//			extentInfoLogs("Enter review product description");
//			sendKeysForID(BugRegressionAppConstants.ProductionReviewProductDescription_ID, AppData.description);
//			hideKeyboard();
//
//			extentInfoLogs("Click on review ubmit button");
//			clickId(BugRegressionAppConstants.ReviewProductSubmitButton_id);
			extentInfoLogs("Assert for login");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.Login_text).getText()
					.equals(AppVerificationChecks.Logintext));
			extentInfoLogs("loginCheckForSubmitReview");

		} catch (Throwable e) {
			e.getMessage();
			throw new Exception(e);
		}
	}

	@Test(enabled = true)
	public void scrollableProductList() throws Exception {
		String prod_List = "";
		int count = 0;
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			extentInfoLogs("Click home search box");
			clickId(BugRegressionAppConstants.Home_Search_TextBox_Id);

			extentInfoLogs("Enter search string as " + AppData.Producttext9);
			sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, AppData.Producttext9);
			extentInfoLogs("Click on auto suggest first item");
			Thread.sleep(2000);
			clickOnCategoryByName(BugRegressionAppConstants.AutoSuggestSearch_id, AppData.Producttext9);

			for (int i = 0; i < 5; i++) {
				List<WebElement> prodList = findElementsById(
						SanitySuiteAppConstants.MyAccountFirstFavouriteProductName_id);
				for (WebElement ele : prodList) {
					if (!prod_List.contains(ele.getText()))
						count++;
					prod_List = prod_List + ele.getText();

				}
				swipeVertically_FullPage();
			}

			extentInfoLogs("Assert for Scrollable Product List");
			Assert.assertTrue(count > 4);

		} catch (Exception e) {
			e.getMessage();
			throw (e);

		}
	}

	@Test(enabled = true)
	public void productWithFilter() throws Exception {
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			extentInfoLogs("open navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on mobile and tablet link");
			clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			//clickName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			extentInfoLogs("Click on android phone category");
			clickId(BugRegressionAppConstants.ProductionAndroid_phones_id);
			extentInfoLogs("Click on filter");
			clickId(BugRegressionAppConstants.Filter_id);
			//swipeVertically(300);
			extentInfoLogs("Select samsung filter");
		    clickByName(BugRegressionAppConstants.SamsungFilter_name, BugRegressionAppConstants.SamsungFilter_name);

			//clickName(BugRegressionAppConstants.SamsungFilter_name);
			extentInfoLogs("Click on apply button");
			clickId(BugRegressionAppConstants.FilerApplybutton_id);
			extentInfoLogs("Get product title");
			String text = findElementsById(SanitySuiteAppConstants.MyAccountFirstFavouriteProductName_id).get(0)
					.getText();
			String[] splitString = text.split(" ");
			extentInfoLogs("Assert for product category");
			Assert.assertEquals(splitString[0], AppVerificationChecks.Samsung);

		} catch (Exception e) {
			e.getMessage();
			throw (e);

		}
	}

	@Test(enabled = true)
	public void removeAppliedFilter() throws Exception {
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			extentInfoLogs("open navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on mobile and tablet categories");
			clickOnCategoryByName(BugRegressionAppConstants.Home_Menu_Id,
					BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			extentInfoLogs("Click on Android phones");
			clickId(BugRegressionAppConstants.ProductionAndroid_phones_id);
			extentInfoLogs("Click on filter");
			clickId(BugRegressionAppConstants.Filter_id);
			extentInfoLogs("Select samsung");
			clickByName(BugRegressionAppConstants.SamsungFilter_name, BugRegressionAppConstants.SamsungFilter_name);
//			try {
//				clickName(BugRegressionAppConstants.SamsungFilter_name);
//			} catch (Exception e) {
//				swipeVertically_FullPage();
//				clickName(BugRegressionAppConstants.SamsungFilter_name);
//			}
			extentInfoLogs("Clear filter");
			clickId(BugRegressionAppConstants.ClearSelected_id);
			extentInfoLogs("Assert for samsung filter");
			boolean notSelected = findElementByName(BugRegressionAppConstants.SamsungFilter_name).isSelected();
			Assert.assertEquals(notSelected, false);
			extentInfoLogs("Select samsung");
			try {
				clickName(BugRegressionAppConstants.SamsungFilter_name);
			} catch (Exception e) {
				swipeVertically_FullPage();
				clickName(BugRegressionAppConstants.SamsungFilter_name);
			}
			
			extentInfoLogs("Clear all filter");
			clickId(BugRegressionAppConstants.ClearAll_id);
			extentInfoLogs("Assert for android phones");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.SmartphoneName).getText()
					.equals(AppVerificationChecks.SmartPhonetext));
		} catch (Exception e) {
			e.getMessage();
			throw (e);
		}
	}

	@Test(enabled = true)
	public void sorting() throws Exception {
		try {

			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			extentInfoLogs("open navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on mobile and tablet link");
			clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			//clickName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			extentInfoLogs("Click on android phone category");
			clickId(BugRegressionAppConstants.ProductionAndroid_phones_id);
			//extentInfoLogs("Click on filter");
			extentInfoLogs("Click on sort button");
			clickId(BugRegressionAppConstants.ProductionAndroidPhonesSortingButton_id);
			extentInfoLogs("click on low to high priority");
			clickName(BugRegressionAppConstants.LTH);
			extentInfoLogs("Get product title");
			String text = findElementById(BugRegressionAppConstants.ProductionPriceOfFirstProduct_id).getText();
			extentInfoLogs("click on sort button");
			clickId(BugRegressionAppConstants.ProductionAndroidPhonesSortingButton_id);
			extentInfoLogs("click on high to low priority");
			clickName(BugRegressionAppConstants.HTL);
			extentInfoLogs("Get product title");
			String text1 = findElementById(BugRegressionAppConstants.ProductionPriceOfFirstProduct_id).getText();
			extentInfoLogs("Assert for product title");
			Assert.assertTrue(text != text1);
			extentInfoLogs("Click on search");
			clickId(BugRegressionAppConstants.InnerPage_search_button_id);
			extentInfoLogs("Enter search string as " + AppData.Producttext9);
			sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, AppData.Producttext9);
			extentInfoLogs("Click on auto suggest first item");
			WebElement searchList =findElementById(BugRegressionAppConstants.SearchList_id);
			List<WebElement> linearlayout = searchList.findElements(By.className(BugRegressionAppConstants.SearchLinearLayout_classname));
			linearlayout.get(0).click();
			//clickXpath(BugRegressionAppConstants.SearchSuggestedFirstProduct_xpath);
			extentInfoLogs("Click on sort button");
			clickId(BugRegressionAppConstants.ProductionAndroidPhonesSortingButton_id);
			extentInfoLogs("verifying assertion");
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.Relevance_text).getText()
					.equals(AppVerificationChecks.Relevancetext));
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void moreCategoryProductListing() throws Exception {
		try {
			extentInfoLogs("open Home Page");
			OpenHomePage.openHomePage();
			extentInfoLogs("open navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("click on Mobile and tablets link");
			OpenHomePage.clickOnCategoryByName(BugRegressionAppConstants.NavDrawer_Mobile_tablets_link);
			extentInfoLogs("click on HeadphoneHeadset link");
			if (findElementsByName(BugRegressionAppConstants.HeadphoneHeadset_text).size() > 0) {
				clickName(BugRegressionAppConstants.HeadphoneHeadset_text);
			} else {

				swipeVertically_FullPage();
				clickName(BugRegressionAppConstants.HeadphoneHeadset_text);
			}
			extentInfoLogs("Assert for HeadphoneHeadset first product");
			Assert.assertTrue(
					findElementsById(SanitySuiteAppConstants.MyAccountFirstFavouriteProduct_id).get(0).isEnabled());
			extentInfoLogs("Assert for HeadphoneHeadset Second product");
			Assert.assertTrue(
					findElementsById(SanitySuiteAppConstants.MyAccountFirstFavouriteProduct_id).get(1).isEnabled());
			extentInfoLogs("Assert for HeadphoneHeadset Third product");
			Assert.assertTrue(
					findElementsById(SanitySuiteAppConstants.MyAccountFirstFavouriteProduct_id).get(2).isEnabled());
			extentInfoLogs("Assert for HeadphoneHeadset Fourth product");
			Assert.assertTrue(
					findElementsById(SanitySuiteAppConstants.MyAccountFirstFavouriteProduct_id).get(3).isEnabled());

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}

	@Test(enabled = true)
	public void favouritesProducts() throws Exception {
		try {
			extentInfoLogs("open Android Page");
			OpenAndroidPage.openAndroidPage();
			extentInfoLogs("Click on Android phones");
			clickName(AppData.SmartPhonetext);
			extentInfoLogs("Click on first android product");
			findElementsById(SanitySuiteAppConstants.MyAccountFirstFavouriteProduct_id).get(0).click();
			extentInfoLogs("Get product title");
			String productDetailsProduct = findElementById(BugRegressionAppConstants.ProductionProductTitleOnProductDetails_id).getText();
					// extentInfoLogs( "Get bookmark status");
					// findElementById(BugRegressionAppConstants.BookmarkButton_id).click();

			// extentInfoLogs( "Navigate back");
			// navigateBack();
			// extentInfoLogs( "Navigate back");
			// navigateBack();
			//
			// extentInfoLogs( "clicking on home overflow menu");
			// clickClassName(BugRegressionAppConstants.HomeOverflow_name);
			//// extentInfoLogs( "clicking on overflow menu login icon");
			//// clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);
			// extentInfoLogs( "clicking on my account favourite");
			// clickId(BugRegressionAppConstants.myAccount_FavouriteList_id);
			//
			// extentInfoLogs( "Gmail login");
			// GmailLogin.gmailLogin();
			// extentInfoLogs( "Checking favourite button is selected or not");
			// if
			// (findElementByXpath(BugRegressionAppConstants.MyAccountFavouritesButton_xpath).isSelected()
			// == false) {
			// extentInfoLogs( "Click on favourite button");
			// clickXpath(BugRegressionAppConstants.MyAccountFavouritesButton_xpath);
			// }
			// extentInfoLogs( "Get favourite product text");
			// String favProduct =
			// findElementById(BugRegressionAppConstants.MyAccountFirstFavouriteProduct_id).getText();
			// extentInfoLogs( "Assert for favourite product");
			// Assert.assertEquals(productDetailsProduct, favProduct);
			// } else {
			extentInfoLogs("clicking on favourite button");
			clickId(BugRegressionAppConstants.BookmarkButton_id);
			extentInfoLogs("Gmail login");
			GmailLogin.gmailLogin();
			extentInfoLogs("Checking favourite button status");
			boolean button = findElementById(BugRegressionAppConstants.BookmarkButton_id).isSelected();
			if (button == false) {
				extentInfoLogs("clicking on favourite button");
				clickId(BugRegressionAppConstants.BookmarkButton_id);
				extentInfoLogs("Navigate back");
				navigateBack();
				extentInfoLogs("Navigate back");
				navigateBack();
				extentInfoLogs("clicking on overflow menu");
				clickClassName(BugRegressionAppConstants.OpenNavigationDrawerForMobAndTabPage);
				extentInfoLogs("clicking on my order option");
				clickId(SanitySuiteAppConstants.NavDrawer_Login_button_id);
				extentInfoLogs("clicking favourites id");
				clickId(BugRegressionAppConstants.myAccount_FavouriteList_id);
				extentInfoLogs("Checking product detail status");
				Thread.sleep(2000);
				for (int i = 0; i <= 3; i++) {
					if (findElementsByName(productDetailsProduct.trim()).size() > 0) {
						extentInfoLogs("Assert for product details status");
						Assert.assertTrue(findElementByName(productDetailsProduct.trim()).isDisplayed());
						break;
					} else {
						swipeVertically_FullPage();
					}
				}
				// extentInfoLogs( "Assert for product details status");
				// Assert.assertEquals(flag, true);
				// } else {
				// // clickId(App_Constants.BookmarkButton_id);
				// clickName(BugRegressionAppConstants.HomeOverflow_name);
				// extentInfoLogs( "clicking on overflow menu");
				// clickName(BugRegressionAppConstants.OFMyOrders_name);
				// extentInfoLogs( "clicking on my order option");
				//
				// // extentInfoLogs( "clicking on my order option");
				// //
				// clickId(BugRegressionAppConstants.NavDrawer_Login_button_id);
				//
				// clickXpath(BugRegressionAppConstants.MyAccountFavouritesButton_xpath);
				// extentInfoLogs( "clicking favourites xpath");
				// // String favProduct = findElementById(
				// // App_Constants.MyAccountFirstFavouriteProduct_id)
				// // .getText();
				// // System.out.println(favProduct);
				// boolean flag =
				// findElementByName(productDetailsProduct.trim()).isDisplayed();
				// extentInfoLogs( "Assert for product details status");
				// Assert.assertEquals(flag, true);
			}
			// }

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	@Test(enabled = false)
	public void exchangeFunctionality() throws Exception {
		try {
			boolean flag = true;
			extentInfoLogs("open Login Page");
			OpenLoginPage.openLoginPage();

			extentInfoLogs("Gmail Login Page");
			GmailLogin.gmailLogin();

			extentInfoLogs("Executing loop according to product list");
			String[] exchangeProList = AppData.ExchangeProductList.split("##");
			for (int i = 0; i < exchangeProList.length; i++) {
				extentInfoLogs("Click on search icon");
				clickId(BugRegressionAppConstants.InnerPage_search_button_id);

				extentInfoLogs("Enter product name in search field");
				sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, exchangeProList[i].trim());
				extentInfoLogs("Click on Auto suggest first value");
				// OpenHomePage.clickOnFirstIndex(BugRegressionAppConstants.AutoSuggestSearch_id);
				clickOnCategoryByName(BugRegressionAppConstants.AutoSuggestSearch_id, exchangeProList[i].trim());

				extentInfoLogs("Get product price");
				String prevPrice = getAllPrice();
				extentInfoLogs("Scroll screen till " + AppData.Similar_Product_Text);
				swipeVertically(3000);
				swipeVertically(3000);
				swipeVertically(3000);
				extentInfoLogs("Verify exchange id");
				extentInfoLogs("Scroll screen till " + AppData.Similar_Product_Text);
				extentInfoLogs("Verify exchange id");
				if (verifyElementExistById(BugRegressionAppConstants.MoreSellers_id)) {
					clickId(BugRegressionAppConstants.MoreSellers_id);
				}
				
			
				for(int z=0;z<2;i++){
					int sellerCount = findElementsById(
							BugRegressionAppConstants.More_Sellers_Store_Name_Id)
							.size();
					System.out.println(sellerCount);
					for(int j=0;j<sellerCount;j++){
						//System.out.println(findElementsById(BugRegressionAppConstants.More_Sellers_Store_Name_Id).get(j).getText());
						try{
						if(findElementsById("com.zopperapp:id/exchange_image").get(j).isDisplayed() ){
							findElementsById(BugRegressionAppConstants.MoreSellersBuyNow_id).get(j).click();
							break;
						}else{
							swipeVertically_FullPage();
						}
						}catch(Exception e)
						{
							swipeVertically_FullPage();
							swipeVertically_FullPage();

						}
					}
					if(flag){
						break;
					}
					
				}
//					extentInfoLogs("Click on buy now button");
//					clickXpath(BugRegressionAppConstants.ProductDetailsVarBuyNow_xpath);
//					AddToCart.addToCart();
//				} else if (verifyElementExistById(BugRegressionAppConstants.MoreSeller_Exchange)) {
//					extentInfoLogs("Click on more seller link");
//					clickId(BugRegressionAppConstants.MoreSeller_Exchange);
//					for (int j = 0; j < 3; j++) {
//						if (findElementsById(BugRegressionAppConstants.MoreSeller_Exchange).size() > 0)
//							clickId(BugRegressionAppConstants.MoreSeller_Exchange);
//						else
//							break;
//					}
					// clickName(BugRegressionAppConstants.ExchangeAvailable_Text);
					extentInfoLogs("Click on exchange available seller");
					verifyExchangeOnBuyClick();
				

				extentInfoLogs("Click on Buy with exchange link");
				clickId(BugRegressionAppConstants.BuyWithExchange_id);

				extentInfoLogs("Click on product type");
				Thread.sleep(1000);
				extentInfoLogs("Swipe screen vertically");
				swipeWithAxis(100, 600, 100, 300, 2000);
				List<WebElement> types = driver.findElements(By.id(BugRegressionAppConstants.type_id));
				extentInfoLogs("Select exchange perameter");
				for (WebElement ele : types) {
					ele.click();
					((WebElement) driver.findElements(By.id(BugRegressionAppConstants.type_id)).get(1)).click();
				}

				Thread.sleep(2000);
				extentInfoLogs("Get product price after exchange");
				String exChangePrice = getAllPrice();
				extentInfoLogs("Assert to verify product price after exchange");
				Assert.assertNotEquals(prevPrice, exChangePrice);
				extentInfoLogs("Swipe screen vertically");
				swipeWithAxis(100, 300, 100, 900, 1000);
				extentInfoLogs("Click on back button");
				backButton();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}

	}
	
	@Test(enabled = true)
    public static void Seller_Rating()
    {
            try
            {
                    extentInfoLogs("open Home Page");
                    OpenHomePage.openHomePage();
                    selectCity("Delhi", "");
                    extentInfoLogs("Click on home screen search box");
                    clickId(BugRegressionAppConstants.Home_Search_TextBox_Id);
                    extentInfoLogs("Enter search string as " + AppData.Producttext);
                    sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, AppData.Producttext);
                    extentInfoLogs("Click on auto suggest first item");
                    clickId(BugRegressionAppConstants.AutoSuggestSearch_id);
                    for(int i=0;i<3;i++)
                     {
                             if(findElementsByName(BugRegressionAppConstants.Seller_Info_Product_Details_Id).size()>0)
                             {
                                     Assert.assertTrue(findElementById(BugRegressionAppConstants.Seller_Rating_Product_Details_Id).isDisplayed());
                                     break;
                             }
                             else
                             {
                                     swipeVertically_FullPage();
                             }
                     }
                    if(findElementById(BugRegressionAppConstants.Seller_View_All_Stores_Id).isDisplayed())
                    {
                            clickId(BugRegressionAppConstants.Seller_View_All_Stores_Id);
                            Assert.assertTrue(findElementById(BugRegressionAppConstants.Seller_More_Seller_Sorting).isDisplayed());
                            for(int i=0;i<3;i++)
                             {
                                     if(findElementsById(BugRegressionAppConstants.Seller_Rating_Product_Details_Id).size()>0)
                                     {
                                             Assert.assertTrue(findElementById(BugRegressionAppConstants.Seller_Rating_Product_Details_Id).isDisplayed());
                                             break;
                                     }
                                     else
                                     {
                                             swipeVertically_FullPage();
                                     }
                             }
                    }
            }
            catch(Exception e)
            {
                    throw(e);
            }
    }
	
	@Test(enabled = true)
    public static void productDescription()
    {
            try
            {
                    extentInfoLogs("open Home Page");
                    OpenHomePage.openHomePage();
                    selectCity("Delhi", "");
                    extentInfoLogs("Click on home screen search box");
                    clickId(BugRegressionAppConstants.Home_Search_TextBox_Id);
                    extentInfoLogs("Enter search string as " + AppData.Producttext2);
                    sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, AppData.Producttext2);
                    extentInfoLogs("Click on auto suggest first item");
                    clickId(BugRegressionAppConstants.AutoSuggestSearch_id);
                    for(int i=0;i<3;i++)
                     {
                             if(findElementsByName(BugRegressionAppConstants.Product_Description_Link).size()>0)
                             {
                                     Assert.assertTrue(findElementById(BugRegressionAppConstants.Product_Description_Read_Id).isDisplayed());
                                     clickId(BugRegressionAppConstants.Product_Description_Read_Id);
                                     break;
                             }
                             else
                             {
                                     swipeVertically_FullPage();
                                     swipeVertically_FullPage();
                             }
                     }
                    Assert.assertTrue(findElementByName(BugRegressionAppConstants.Product_Description_Title_Link).isDisplayed());
                    String Product_Description=findElementById(BugRegressionAppConstants.Product_Description_Id).getText();
                    ProductDescValidator pdv = new ProductDescValidator();
                    boolean valid1 = pdv.validate(Product_Description);
                    extentInfoLogs( "applying validator");
                    Assert.assertEquals(valid1, true);
            }
            catch(Exception e)
            {
                    throw(e);
            }
    }
	
	@Test(enabled = true)
    public static void sellerRating()
    {
            try
            {
                    extentInfoLogs("open Home Page");
                    OpenHomePage.openHomePage();
                    selectCity("Delhi", "");
                    extentInfoLogs("Click on home screen search box");
                    clickId(BugRegressionAppConstants.Home_Search_TextBox_Id);
                    extentInfoLogs("Enter search string as " + AppData.Producttext);
                    sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id, AppData.Producttext);
                    extentInfoLogs("Click on auto suggest first item");
                    clickId(BugRegressionAppConstants.AutoSuggestSearch_id);
                    for(int i=0;i<3;i++)
                     {
                             if(findElementsByName(BugRegressionAppConstants.Seller_Info_Product_Details_Id).size()>0)
                             {
                                     Assert.assertTrue(findElementById(BugRegressionAppConstants.Seller_Rating_Product_Details_Id).isDisplayed());
                                     break;
                             }
                             else
                             {
                                     swipeVertically_FullPage();
                             }
                     }
                    if(findElementById(BugRegressionAppConstants.Seller_View_All_Stores_Id).isDisplayed())
                    {
                            clickId(BugRegressionAppConstants.Seller_View_All_Stores_Id);
                            Assert.assertTrue(findElementById(BugRegressionAppConstants.Seller_More_Seller_Sorting).isDisplayed());
                            for(int i=0;i<3;i++)
                             {
                                     if(findElementsById(BugRegressionAppConstants.Seller_Rating_Product_Details_Id).size()>0)
                                     {
                                             Assert.assertTrue(findElementById(BugRegressionAppConstants.Seller_Rating_Product_Details_Id).isDisplayed());
                                             break;
                                     }
                                     else
                                     {
                                             swipeVertically_FullPage();
                                     }
                             }
                    }
            }
            catch(Exception e)
            {
                    throw(e);
            }
    }
	
	@Test(enabled = true)
    public void colorVariant()
    {
            try
            {
                    extentInfoLogs("Open Home page");
                    OpenHomePage.openHomePage();
                    clickId(BugRegressionAppConstants.HomeSearchtextbox_id);
                    extentInfoLogs("click on search textbox");
                    sendKeysForID(BugRegressionAppConstants.Home_SearchEditBox_id,
                                    AppData.ColorVariant_Product);
                    extentInfoLogs("enter text on search textbox");
                    List<WebElement> list = findElementsById(BugRegressionAppConstants.AutoSuggestSearch_id);
                    int count =list.size();
                    for(int k=0;k<count;k++)
                    {
                            extentInfoLogs("click on first autosuggest");
                            list.get(0).click();
                            break;
                    }
                    if(findElementsById(BugRegressionAppConstants.ColorVariants_Id).size()>0)
                    {
                            System.out.println(findElementsById(BugRegressionAppConstants.ColorVariants_Id).size());
                    }
            }
            catch(Exception e)
            {
                    throw(e);
            }
    }
	

	// @Test(enabled = false)
	// public void ZSP_On_Product_Details() throws Exception {
	// try {
	// startTestCase("ZSP on Product Details");
	// extentInfoLogs("Call the function of home page function");
	// OpenHomePage.openHomePage();
	// Thread.sleep(4000);
	// swipeWithAxis(200, 300, 200, 100, 3000);
	// clickId(AppConstants.Home_search_button_id);
	// extentInfoLogs("Click on Search icon id");
	//
	// sendKeysForID(AppConstants.Home_SearchEditBox_id, AppData.ZSP_Product);
	// extentInfoLogs("sending text to search bar");
	// clickXpath(AppConstants.SearchSuggestedFirstProduct_xpath);
	// extentInfoLogs("clicking suggested product");
	//
	// Assert.assertTrue(findElementByXpath(AppConstants.ZSP_Price_xpath).isDisplayed());
	// extentInfoLogs("verify ZSP on product details");
	// Assert.assertTrue(findElementByXpath(AppConstants.SP_Price_xpath).isDisplayed());
	// extentInfoLogs("verify SP product details");
	// Assert.assertTrue(findElementByXpath(AppConstants.MRP_Price_xpath).isDisplayed());
	// extentInfoLogs("verify MRP product details");
	// endTestCase("ZSP on Product Details");
	// } catch (Exception e) {
	// e.getMessage();
	// takeSnapShot("D:\\takeScreenshots", "Product search by product
	// categories");
	// throw (e);
	// }
	// }

	// @Test(enabled = false)
	// public void ZSP_On_Product_Details() throws Exception {
	// try {
	// startTestCase("ZSP on Product Details");
	// extentInfoLogs("Call the function of home page function");
	// OpenHomePage.openHomePage();
	// Thread.sleep(4000);
	// swipeWithAxis(200, 300, 200, 100, 3000);
	// clickId(AppConstants.Home_search_button_id);
	// extentInfoLogs("Click on Search icon id");
	//
	// sendKeysForID(AppConstants.Home_SearchEditBox_id, AppData.ZSP_Product);
	// extentInfoLogs("sending text to search bar");
	// clickXpath(AppConstants.SearchSuggestedFirstProduct_xpath);
	// extentInfoLogs("clicking suggested product");
	//
	// Assert.assertTrue(findElementByXpath(AppConstants.ZSP_Price_xpath).isDisplayed());
	// extentInfoLogs("verify ZSP on product details");
	// Assert.assertTrue(findElementByXpath(AppConstants.SP_Price_xpath).isDisplayed());
	// extentInfoLogs("verify SP product details");
	// Assert.assertTrue(findElementByXpath(AppConstants.MRP_Price_xpath).isDisplayed());
	// extentInfoLogs("verify MRP product details");
	// endTestCase("ZSP on Product Details");
	// } catch (Exception e) {
	// e.getMessage();
	// takeSnapShot("D:\\takeScreenshots", "Product search by product
	// categories");
	// throw (e);
	// }
	// }

	public void verifyExchangeOnBuyClick() {
		int count = 0, i;
		try {
			count = driver.findElements(By.id(BugRegressionAppConstants.MoreSellersBuyNow_id)).size();
			for (i = 0; i < count; i++) {
				((WebElement) driver.findElements(By.id(BugRegressionAppConstants.MoreSellersBuyNow_id)).get(i))
						.click();
				AddToCart.addToCart();
				if (verifyElementExistById(BugRegressionAppConstants.BuyWithExchange_id)) {
					break;
				} else {
					clickClassName(BugRegressionAppConstants.BackButton_class);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	public String getAllPrice() {
		String price = "";
		try {
			List<WebElement> elements = driver.findElements(By.id(BugRegressionAppConstants.ProductPrice_id));
			for (WebElement ele : elements) {
				price = price + " " + ele.getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		return price;
	}

	@Test(enabled = false)
	public void brandedStores() {

	}

	public static String[] createNewStore() throws Exception {
		String[] storeparam = new String[2];
		String store_id = "", slug = null;
		try {
			String[] phn_nos = { "1124566776" };
			String[] contPer = { "Ram", "Shyam", "Laxman" };
			String[] wrkdays = { "mo", "tu" };
			String payload = jsonPayLoadForStoreCreation(phn_nos, contPer, wrkdays);
			Utility.ParamObject params = getParamsForCreateNewStoreAPI(payload);
			System.out.println(params.toString());
			String jsonString = (String) Utility.RestClient.getJSONFromParamsObject(params,
					Utility.RestClient.RETURN_JSON_STRING);

			System.out.println("createNewStore" + jsonString);
			JSONObject root = new JSONObject(jsonString);
			storeparam[0] = root.getString("slug");
			storeparam[1] = root.getString("store_id");
			// getSellQuery("9316162", "204117", "1000");

		} catch (Exception e) {
			e.getMessage();
		}
		return storeparam;
	}

	public static String[] createnonlfrNewStore() throws Exception {
		String[] storeparam = new String[2];
		String store_id = "", slug = null;
		try {
			String[] phn_nos = { "1124566776" };
			String[] contPer = { "Ram", "Shyam", "Laxman" };
			String[] wrkdays = { "mo", "tu" };
			String payload = jsonPayLoadForNonLfrStoreCreation(phn_nos, contPer, wrkdays);
			Utility.ParamObject params = getParamsForCreateNewNonLfrStoreAPI(payload);
			System.out.println(params.toString());
			String jsonString = (String) Utility.RestClient.getJSONFromParamsObject(params,
					Utility.RestClient.RETURN_JSON_STRING);

			System.out.println("createNewStore" + jsonString);
			JSONObject root = new JSONObject(jsonString);
			storeparam[0] = root.getString("slug");
			storeparam[1] = root.getString("store_id");
			// getSellQuery("9316162", "204117", "1000");

		} catch (Exception e) {
			e.getMessage();
		}
		return storeparam;
	}

	public static String jsonPayLoadForNonLfrStoreCreation(String[] phn_nos, String[] contactPerson, String[] wrkngDy)
			throws JSONException {
		Random rnd = new Random();
		String randStr = Long.toHexString(System.currentTimeMillis());
		JSONObject root = new JSONObject();// {}
		JSONObject child = new JSONObject();
		JSONObject startTime = new JSONObject();
		JSONObject endTime = new JSONObject();
		JSONObject timeSlot = new JSONObject();
		JSONObject children = new JSONObject();
		JSONObject location = new JSONObject();
		JSONObject brand = new JSONObject();
		JSONObject categories = new JSONObject();
		JSONObject storeTiming = new JSONObject();
		JSONArray catArray = new JSONArray();// []
		JSONArray contPersonArray = new JSONArray();
		JSONArray timeSlotArray = new JSONArray();
		JSONArray services = new JSONArray();
		JSONArray brandArray = new JSONArray();
		JSONArray childrenArray = new JSONArray();
		JSONArray categoriesArray = new JSONArray();
		JSONArray workingDays = new JSONArray();

		root.put("chain_id", "0");
		root.put("name", "Test Store " + randStr);
		root.put("address", "Test Address " + randStr);
		root.put("locality", "Test Locality " + randStr);
		root.put("landmark", "Test LandMark " + randStr);
		root.put("pincode", 100000 + rnd.nextInt(900000));
		root.put("state", "Gujarat");
		root.put("city", "Vadodara");

		// phone_nos Array string
		for (int i = 0; i < phn_nos.length; i++) {
			catArray.put(child.put("phone_number", phn_nos[i]));
		}
		root.put("phone_nos", catArray);

		root.put("email", "TestStore@" + randStr + ".com");
		root.put("owner", "Test Owner " + randStr);

		// ContactPerson Array string
		for (String s : contactPerson) {
			contPersonArray.put(s);// ["230"] // ["230","231"]
		}
		root.put("contactPerson", contPersonArray);

		// working days
		for (String s : wrkngDy) {
			workingDays.put(s);// ["230"] // ["230","231"]
		}

		// Start time
		startTime.put("time", "10:30");
		startTime.put("meridian", "AM");
		timeSlot.put("start", startTime);

		// End time
		endTime.put("time", "8:00");
		endTime.put("meridian", "PM");
		timeSlot.put("end", endTime);

		// Time slot array
		timeSlotArray.put(timeSlot);

		// Store timing array
		storeTiming.put("workingDays", workingDays);
		storeTiming.put("timeSlot", timeSlotArray);
		root.put("storeTiming", storeTiming);

		// Location array
		location.put("lat", "14.12");
		location.put("lng", "12.34");
		root.put("location", location);

		// service array
		services.put("Self");
		services.put("warranty");
		root.put("services", services);

		root.put("agreement", true);

		// brand array
		brand.put("name", "TestCategory" + randStr);
		brandArray.put(brand);

		// children array
		children.put("name", "TestCategory" + randStr);
		children.put("cat_id", 2);
		children.put("brand", brandArray);
		childrenArray.put(children);

		// Categories array
		categories.put("name", "TestCategory" + randStr);
		categories.put("cat_id", 1);
		categories.put("children", childrenArray);
		categoriesArray.put(categories);
		root.put("categories", categoriesArray);
		System.out.println(root.toString());
		return root.toString();
	}

	public static String jsonPayLoadForStoreCreation(String[] phn_nos, String[] contactPerson, String[] wrkngDy)
			throws JSONException {
		Random rnd = new Random();
		String randStr = Long.toHexString(System.currentTimeMillis());
		JSONObject root = new JSONObject();// {}
		JSONObject child = new JSONObject();
		JSONObject startTime = new JSONObject();
		JSONObject endTime = new JSONObject();
		JSONObject timeSlot = new JSONObject();
		JSONObject children = new JSONObject();
		JSONObject location = new JSONObject();
		JSONObject brand = new JSONObject();
		JSONObject categories = new JSONObject();
		JSONObject storeTiming = new JSONObject();
		JSONArray catArray = new JSONArray();// []
		JSONArray contPersonArray = new JSONArray();
		JSONArray timeSlotArray = new JSONArray();
		JSONArray services = new JSONArray();
		JSONArray brandArray = new JSONArray();
		JSONArray childrenArray = new JSONArray();
		JSONArray categoriesArray = new JSONArray();
		JSONArray workingDays = new JSONArray();

		root.put("chain_id", "3");
		root.put("name", "Test Store " + randStr);
		root.put("address", "Test Address " + randStr);
		root.put("locality", "Test Locality " + randStr);
		root.put("landmark", "Test LandMark " + randStr);
		root.put("pincode", 100000 + rnd.nextInt(900000));
		root.put("state", "Gujarat");
		root.put("city", "Vadodara");

		// phone_nos Array string
		for (int i = 0; i < phn_nos.length; i++) {
			catArray.put(child.put("phone_number", phn_nos[i]));
		}
		root.put("phone_nos", catArray);

		root.put("email", "TestStore@" + randStr + ".com");
		root.put("owner", "Test Owner " + randStr);

		// ContactPerson Array string
		for (String s : contactPerson) {
			contPersonArray.put(s);// ["230"] // ["230","231"]
		}
		root.put("contactPerson", contPersonArray);

		// working days
		for (String s : wrkngDy) {
			workingDays.put(s);// ["230"] // ["230","231"]
		}

		// Start time
		startTime.put("time", "10:30");
		startTime.put("meridian", "AM");
		timeSlot.put("start", startTime);

		// End time
		endTime.put("time", "8:00");
		endTime.put("meridian", "PM");
		timeSlot.put("end", endTime);

		// Time slot array
		timeSlotArray.put(timeSlot);

		// Store timing array
		storeTiming.put("workingDays", workingDays);
		storeTiming.put("timeSlot", timeSlotArray);
		root.put("storeTiming", storeTiming);

		// Location array
		location.put("lat", "14.12");
		location.put("lng", "12.34");
		root.put("location", location);

		// service array
		services.put("Self");
		services.put("warranty");
		root.put("services", services);

		root.put("agreement", true);

		// brand array
		brand.put("name", "TestCategory" + randStr);
		brandArray.put(brand);

		// children array
		children.put("name", "TestCategory" + randStr);
		children.put("cat_id", 2);
		children.put("brand", brandArray);
		childrenArray.put(children);

		// Categories array
		categories.put("name", "TestCategory" + randStr);
		categories.put("cat_id", 1);
		categories.put("children", childrenArray);
		categoriesArray.put(categories);
		root.put("categories", categoriesArray);
		System.out.println(root.toString());
		return root.toString();
	}

	public static Utility.ParamObject getParamsForCreateNewStoreAPI(String payLoad) {
		Utility.ParamObject obj = new Utility.ParamObject();
		String URL = "http://139.162.14.155";
		String xAPIVersion = "1.1";
		String accessToken = "ffc08b95d9ea451d308d35c44545100986691911";
		String authorization = "Token ffc08b95d9ea451d308d35c44545100986691911";
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL + "/stores/";
		obj.setUrl(url);
		obj.addHeader("X-Api-Version", xAPIVersion);
		obj.addHeader("Authorization", authorization);
		obj.setPayload(payLoad);
		obj.setMethodType("POST");
		return obj;
	}

	public static Utility.ParamObject getParamsForCreateNewNonLfrStoreAPI(String payLoad) {
		Utility.ParamObject obj = new Utility.ParamObject();
		String URL = "http://139.162.14.155";
		String xAPIVersion = "1.1";
		String accessToken = "ffc08b95d9ea451d308d35c44545100986691911";
		String authorization = "Token ffc08b95d9ea451d308d35c44545100986691911";
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL + "/stores/";
		obj.setUrl(url);
		obj.addHeader("X-Api-Version", xAPIVersion);
		obj.addHeader("Authorization", authorization);
		obj.setPayload(payLoad);
		obj.setMethodType("POST");
		return obj;
	}

	public static void getSellQuery(String productId, String storeId, String sPrice) throws Exception {

		String summary = "";
		try {
			RestClient.restClient_Flag = false;
			String payload = jsonPayLoadForSellQuery(productId, storeId, sPrice);
			ParamObject params = getParamsForSellQuery(payload);
			String jsonString = (String) Utility.RestClient.getJSONFromParamsObject(params,
					Utility.RestClient.RETURN_JSON_STRING);
			System.out.println(jsonString);

			// summary = getValueFromParser(jsonString, "message");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static String jsonPayLoadForSellQuery(String productId, String storeId, String sPrice) throws JSONException {
		// JSONObject root = new JSONObject();// {}
		// root.put("product_id", productId);
		// root.put("store_id", storeId);
		// root.put("price", sPrice);
		//
		// return root.toString();
		return "store_id=" + storeId + "&price=" + sPrice + "&product_id=" + productId;
	}

	public static Utility.ParamObject getParamsForSellQuery(String payLoad) {
		Utility.ParamObject obj = new Utility.ParamObject();
		String URL_Retailer = "http://139.162.6.154";

		String xAPIVersion = "1.1";
		String accessToken = "ffc08b95d9ea451d308d35c44545100986691911";
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL_Retailer + "/rms/retailer/sellquery/";
		obj.setUrl(url);
		obj.addHeader("X-Api-Version", xAPIVersion);
		obj.addHeader("Access-Token", accessToken);
		// obj.addHeader("Accept", "application/x-www-form-urlencoded");
		// obj.addHeader("Content-type", "application/x-www-form-urlencoded");
		obj.setPayload(payLoad);
		obj.setMethodType("POST");
		return obj;
	}

	public static void deleteStore(String slug) throws Exception {
		try {
			// String[] str = slug.split("##");
			ParamObject params = getParamsForDeleteStoreAPI(slug);
			String jsonString = (String) RestClient.getJSONFromParamsObject(params, RestClient.RETURN_JSON_STRING);

			System.out.println("deleteStore" + jsonString);

			int responseCode = RestClient.getResponseCode();
			System.out.println(responseCode);

		} catch (Exception e) {
			throw (e);
		}
	}

	public static ParamObject getParamsForDeleteStoreAPI(String slug) {
		ParamObject obj = new ParamObject();
		String URL = "http://139.162.14.155";
		String xAPIVersion = "1.1";
		String authorization = "Token ffc08b95d9ea451d308d35c44545100986691911";
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL + "/stores/" + slug + "/";
		obj.setUrl(url);
		obj.addHeader("X-Api-Version", xAPIVersion);
		obj.addHeader("Authorization", authorization);
		// obj.setPayload(payLoad);
		obj.setMethodType("DELETE");
		return obj;
	}

	public static void purgePriceByStore(String prod_Id, String store_id) throws Exception {
		boolean flag = true;
		try {
			String payload = jsonPayLoadForPurgePriceByStore(prod_Id);
			ParamObject params = getParamsForPurgePriceByStore(payload, store_id);

			String jsonString = (String) RestClient.getJSONFromParamsObject(params, RestClient.RETURN_JSON_STRING);
			System.out.println(jsonString);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String jsonPayLoadForPurgePriceByStore(String prod_id) throws JSONException {
		JSONObject root = new JSONObject();// {}
		root.put("product_id", prod_id);

		return root.toString();
	}

	public static ParamObject getParamsForPurgePriceByStore(String payLoad, String store_Id) {
		ParamObject obj = new ParamObject();
		String authorization = "Token ffc08b95d9ea451d308d35c44545100986691911";
		String URL = "http://139.162.14.155";
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String url = URL + "/store/" + store_Id + "/purgeprice/";
		obj.setUrl(url);
		obj.addHeader("Authorization", authorization);
		obj.setPayload(payLoad);
		obj.setMethodType("POST");
		return obj;
	}

	public static void main(String args[]) throws Exception {
		// String [] slug ;
		// String [] lfrslug;
		// slug =createNewStore();
		// lfrslug =createnonlfrNewStore();
		//// System.out.println(slug[0]);
		// System.out.println(slug[0]);
		// System.out.println(slug[1]);
		// System.out.println(lfrslug[0]);
		// System.out.println(lfrslug[1]);
		//

		// getSellQuery("6180841", lfrslug[1], "5000");
		// getSellQuery("6180841", slug[1], "4999");
		purgePriceByStore("6180841", "204194");
		purgePriceByStore("6180841", "204195");
		deleteStore("test-store-1528cf2747c");
		deleteStore("test-store-1528cf2771c");

		// getSellQuery("6180841", "204150", "4999");
		int i = 0;
		// while(i<slug.length){
		// System.out.println("main function"+slug[i]);
		// i++;
		// }

		// System.out.println("main function"+slug[]);
		// getSellQuery("1821", "204133", "5000");
		// purgePriceByStore("1821", "204133");
		// deleteStore("test-store-15287d7c139")
	}
}
