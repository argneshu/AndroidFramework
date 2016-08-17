package Functional_Scenarios;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import App_Functions.ChangeZopperPassword;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.BugRegressionAppConstants;

public class DownloadFromPlayStore extends BaseTestBugRegression {

	public static void installAppFromPlayStore() throws Exception {

		try {
			extentInfoLogs("Opening playstore url");
			ChangeZopperPassword.openBrowser(AppData.playStore_URL);

			extentInfoLogs("clicking on android app on plays store");
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(BugRegressionAppConstants.Play_Store_AndroidApp_Download_css)));
			 wDriver.findElement(By.xpath("//a[@href='https://play.google.com/store/apps/details?id=com.zopperapp&referrer=utm_source%3Ddesktop']")).click();
			//List<WebElement> element =
			//element.get(0).click();

			extentInfoLogs("click on sign in button");
			String currentWindowHandle = wDriver.getWindowHandle();
			System.out.println("current window handle is: "+ currentWindowHandle);
			Set<String> allWindowHandle = wDriver.getWindowHandles();
			for(String handle: allWindowHandle){
				System.out.println("handle before condition" + handle);
				if(!handle.equals(currentWindowHandle)){
					wDriver.switchTo().window(handle);
					System.out.println("handle after condition" + handle);
				}
			}
			//wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Sign in')]")));
			//boolean result =isElementPresent(By.xpath("//a[contains(text(),'Sign in')]"), wDriver);
//			List<WebElement> eletext =wDriver.findElements(By.tagName("a"));
//			for(WebElement element: eletext){
//				System.out.println("the text is :"+ element.getText());
//				if(element.getText().trim().contains("Sign in")){
//					element.click();
//				}
//			}
			wDriver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
			extentInfoLogs("enter email id");
			wDriver.findElement(By.id(BugRegressionAppConstants.Play_Store_Email_id)).sendKeys(AppData.PlayStore_Email);
			extentInfoLogs("click on next button");
			wDriver.findElement(By.id(BugRegressionAppConstants.Play_Store_Next_id)).click();
			Thread.sleep(5000);
			extentInfoLogs("enter password");
			wDriver.findElement(By.id(BugRegressionAppConstants.Play_Store_Password_id))
					.sendKeys(AppData.PlayStore_Password);
			extentInfoLogs("Click on login login button");
			wDriver.findElement(By.id(BugRegressionAppConstants.Play_Store_Login_id)).click();
			extentInfoLogs("click on installed button");
			wDriver.findElement(By.xpath(BugRegressionAppConstants.Play_Store_Installed_xpath)).click();
			if(wDriver.findElements(By.xpath(BugRegressionAppConstants.Play_Store_Installed_xpath)).size()>0){
				wDriver.findElement(By.xpath(BugRegressionAppConstants.Play_Store_Installed_xpath)).click();
			}
			Thread.sleep(2000);
			extentInfoLogs("click on pay store dropdown");
			wDriver.findElement(By.xpath(BugRegressionAppConstants.Play_Store_DropDown_xpath)).click();
			extentInfoLogs("Get device name");
			String deviceName = getDeviceName();
			System.out.println("device name is :" +deviceName);
			extentInfoLogs("Select device name");
			wDriver.findElement(By.xpath("//span[@class='device-title' and contains(text(),'" + deviceName + "')]"))
					.click();
			extentInfoLogs("Click on install");
			Thread.sleep(2000);
			extentInfoLogs("click on install button");
			wDriver.findElement(By.id(BugRegressionAppConstants.Play_Store_InstallButton_id)).click();
			extentInfoLogs("Wait for congratulation message");
			wait = new WebDriverWait(wDriver, 60);
			extentInfoLogs("click on ok button");
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(BugRegressionAppConstants.Play_Store_CongratulationMessage_xpath)));
			extentInfoLogs("click on ok button");
			wDriver.findElement(By.id(BugRegressionAppConstants.Play_Store_CongratulationMessage_Ok_id)).click();
			extentInfoLogs("close browser");
			ChangeZopperPassword.closeBrowser();
			Thread.sleep(12000);

		} catch (Exception e) {
			System.out.println(e.toString());
			/*File file=((TakesScreenshot)wDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("/home/zopper/Desktop/name.png"));*/
			
			captureScreenShot(wDriver, "/home/zopper/Desktop/", "Downloadwalascreenshot");
			 throw(e);
		}

	}

	@Test(enabled = true, priority = 0)
	public void verifyPlayStoreAppInstallationFunctionality() throws Exception {

		try {
			
			extentInfoLogs("Open Notifications");
			driver.openNotifications();
			if(findElementsById(BugRegressionAppConstants.ClearNotifications_Id).size()>0)
			{
				clickId(BugRegressionAppConstants.ClearNotifications_Id);
				swipeVertically_FullPage();
			}
			else
			{
				swipeVertically_FullPage();
			}
			
			extentInfoLogs("close appium session");
			closeAppiumSession();

			extentInfoLogs("uninstall consumer app");
			Runtime.getRuntime().exec("adb uninstall com.zopperapp");

			extentInfoLogs("Calling instsall app from playstore function");
			installAppFromPlayStore();

		} catch (Exception e) {
			System.out.println(e.toString());
			throw (e);
		}
	}

	@Test(enabled = true, dependsOnMethods = { "verifyPlayStoreAppInstallationFunctionality" }, priority = 0)
	public void verifyInstalledApp() throws Exception {
		boolean flag = false;
		try {
			extentInfoLogs("Open Notifications");
			driver.openNotifications();
			extentInfoLogs("Verify intalled app notificaation");
			for (int i = 0; i < 3; i++) {
				List<WebElement> element = driver
						.findElements(By.className(BugRegressionAppConstants.Mobile_Notification_Class));
				for (WebElement ele : element) {
					System.out.println(ele.getText());
					if (ele.getText().trim().equalsIgnoreCase(AppData.InstalledApp_Notification)) {
						flag = true;
						break;
					}
				}
				swipeVertically_FullPage();
			}
			extentInfoLogs("Assert for installed app notification");
			Assert.assertEquals(flag, true);
		} catch (Exception e) {
			System.out.println(e.toString());
			throw (e);
		}
	}

	@Override
	@Test(enabled = false)
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
