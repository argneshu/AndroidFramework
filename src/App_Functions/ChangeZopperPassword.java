package App_Functions;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.AppData;
import Page_Objects.BugRegressionAppConstants;

//This function is created to handle the Gmail login from Login page
public class ChangeZopperPassword extends BaseTestBugRegression {


	public static void openBrowser(String URL) throws Exception {
		try {
//			System.setProperty("webdriver.chrome.driver", "E:/chromedriver_win32/chromedriver.exe");


			String osName = System.getProperty("os.name");
			if(osName.contains("Windows"))
			{
			System.out.println(osName);
			wDriver = new FirefoxDriver();
			wait1= new WebDriverWait(wDriver,10);
//			wDriver=new ChromeDriver();
			wDriver.get(URL);
			wDriver.manage().window().maximize();
			wDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			wait1= new WebDriverWait(wDriver,10);
			Actions action = new Actions(wDriver);
			}
			else
			{
				File chromeDriver = new File("");
				String path = chromeDriver.getAbsolutePath();

				String os= System.getProperty("os.name");
				System.out.println(os);
				if (os.contains("Linux"))
				{
				String driverPath = path+"/linux/chromedriver";
				System.out.println(driverPath);
				System.setProperty("webdriver.chrome.driver", driverPath);
				}
				else
				{
					String driverPath = path+"/chromedriver";
					System.out.println(driverPath);
					System.setProperty("webdriver.chrome.driver", driverPath);
				}
				
				wDriver = new ChromeDriver();
				wDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait1= new WebDriverWait(wDriver,20);
				wDriver.get(URL);
				wDriver.manage().window().maximize();
				Actions action = new Actions(wDriver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "openBrowser");
			throw (e);
		}
	}
	

	public static void rediffLogin() throws Exception {
		try {
			wDriver.findElement(By.id(BugRegressionAppConstants.Rediff_LoginUser_id))
					.sendKeys(AppData.UserId);
			wDriver.findElement(By.id(BugRegressionAppConstants.Rediff_ContinueButton_id))
					.click();
			Thread.sleep(1000);
			wDriver.findElement(By.id(BugRegressionAppConstants.Rediff_Password_id))
					.click();
			Thread.sleep(1000);
			wDriver.findElement(By.id(BugRegressionAppConstants.Rediff_Password_id))
					.sendKeys(AppData.password);
			wDriver.findElement(
					By.xpath(BugRegressionAppConstants.Rediff_LoginButton_xpath)).click();
		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "rediffLogin");
			throw (e);
		}
	}

	public static void openMailBox() throws Exception {
		try {
			wDriver.findElement(By.xpath(BugRegressionAppConstants.Rediff_MailBox_xpath))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "openMailBox");
			throw (e);
		}
	}

	public static void clickChangePasswordMail() throws Exception {
		try {
//			System.out.println("Mail link function");
			List<WebElement> element = wDriver.findElements(By
					.xpath(BugRegressionAppConstants.Rediff_ResetMail_xpath));
//			System.out.println("list size : " + element);
			for (WebElement ele : element) {
//				System.out.println("Mail name : " + ele.getText());
				ele.click();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "clickChangePasswordMail");
			throw (e);
		}
	}

	public static void clickMailLink() throws Exception {
		try {
			wDriver.findElement(
					By.xpath(BugRegressionAppConstants.Rediff_ResetLinkInMail_xpath))
					.click();

		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "clickMailLink");
			throw (e);
		}
	}

	public static void switchToChildWindow() throws Exception {
		try {
			String parentWindow = wDriver.getWindowHandle();
//			System.out.println("Parent window : " + parentWindow);
			Set<String> handles = wDriver.getWindowHandles();
			for (String windowHandle : handles) {
				if (!windowHandle.equals(parentWindow)) {
					wDriver.switchTo().window(windowHandle);
//					System.out.println("Child window : " + windowHandle);
					break;
				} else {
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "switchToChildWindow");
			throw (e);
		}
	}

	public static void closeChildWindow() throws Exception {
		try {
			String parentWindow = wDriver.getWindowHandle();
//			System.out.println("Parent window : " + parentWindow);
			Set<String> handles = wDriver.getWindowHandles();
			for (String windowHandle : handles) {
				if (!windowHandle.equals(parentWindow)) {
					wDriver.switchTo().window(windowHandle);
					wDriver.close();
				}
			}
			wDriver.switchTo().window(parentWindow);

		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "switchToChildWindow");
			throw (e);
		}
	}

	public static boolean resetPassword() throws Exception {
		boolean flag = false;
		try {
			wDriver.findElement(By.id(BugRegressionAppConstants.Rediff_NewPassword_id))
					.sendKeys(AppData.password);
			wDriver.findElement(By.id(BugRegressionAppConstants.Rediff_ConfirmPassword_id))
					.sendKeys(AppData.password);
			wDriver.findElement(By.id(BugRegressionAppConstants.Rediff_Submit_id)).click();
			Thread.sleep(5000);
//			System.out.println("Flag value : "
//					+ wDriver.findElement(
//							By.id(App_Constants.Rediff_SuccessMsg_id))
//							.getText());
			if (wDriver.findElement(By.id(BugRegressionAppConstants.Rediff_SuccessMsg_id))
					.getText().trim().contains(AppData.Success_Msg))
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "resetPassword");
			throw (e);
		}
		return flag;
	}

	public static void closeBrowser() {
		wDriver.quit();
	}
	
	public static boolean verifyMailHeader(String sub) {
        boolean flag = false;
        try {
//                System.out.println("Mail link function");
                if (wDriver.findElements(By.xpath("//*[@id='mailList']//span[contains(text(),sub)]")).size() > 0)
                        flag = true;
        } catch (Exception e) {
                e.printStackTrace();
                // takeSnapShot("D:\\takeScreenshots", "clickChangePasswordMail");
                throw (e);
        }
        return flag;
}

	// public static void main(String[] args) throws Exception
	// {
	// openBrowser();
	// rediffLogin();
	// closeChildWindow();
	// openMailBox();
	// closeChildWindow();
	// clickChangePasswordMail();
	// Thread.sleep(5000);
	// clickMailLink();
	// Thread.sleep(5000);
	// switchToChildWindow();
	// resetPassword();
	// closeBrowser();
	//
	// }

	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}
	
	public static void gMailLogin(String userId,String password) throws Exception {
		try {
			wDriver.findElement(By.id(BugRegressionAppConstants.GMail_User_Id))
					.sendKeys(userId);
			wDriver.findElement(By.id(BugRegressionAppConstants.Gmail_Next_Id))
					.click();
			Thread.sleep(1000);
			wDriver.findElement(By.id(BugRegressionAppConstants.Gmail_Password_Id))
					.sendKeys(password);
			wDriver.findElement(
					By.id(BugRegressionAppConstants.Gmail_SignIn_Button_Id)).click();
		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "rediffLogin");
			throw (e);
		}
	}
	
	public static void clickOnZopperForgotPasswordLink() throws Exception {
		try {
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BugRegressionAppConstants.Gmail_MailList_User_Id)));		
			List<WebElement> mailList=wDriver.findElements(By.xpath(BugRegressionAppConstants.Gmail_MailList_User_Id));
			for(WebElement ele:mailList){
				//Thread.sleep(2000);
				ele.click();
				break;
			}try{
				wDriver.findElement(By.xpath(BugRegressionAppConstants.Gmail_ChangePassword_LinkText)).click();
			}catch(Exception e){
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='ajT']")));
				wDriver.findElement(By.xpath("//img[@class='ajT']")).click();
				wDriver.findElement(By.xpath(BugRegressionAppConstants.Gmail_ChangePassword_LinkText)).click();
			}

//			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BugRegressionAppConstants.Gmail_ChangePassword_LinkText)));
//			int count = wDriver.findElements(By.xpath(BugRegressionAppConstants.Gmail_ChangePassword_LinkText)).size();
//			try{
//			wDriver.findElements(By.xpath(BugRegressionAppConstants.Gmail_ChangePassword_LinkText)).get(count-1).click();
//			}catch(Exception e){
//				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='ajT']")));
//				wDriver.findElement(By.xpath("//img[@class='ajT']")).click();
//				wDriver.findElement(By.xpath(BugRegressionAppConstants.Gmail_ChangePassword_LinkText)).click();
//
//			}
			
			//if (wDriver.findElements(By.xpath(BugRegressionAppConstants.Gmail_ChangePassword_LinkText)).size()>0){
				//wDriver.findElement(By.xpath(BugRegressionAppConstants.Gmail_ChangePassword_LinkText)).click();	
				//wDriver.findElement(By.className("firefinder-match")).click();
			//}
		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapShot("D:\\takeScreenshots", "rediffLogin");
			throw (e);
		}
	}
	
	public static void changeZopperGmailPassword(String password) throws Exception {
		try {
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.id(BugRegressionAppConstants.Gmail_NewPassword_Id)));
			
			wDriver.findElement(By.id(BugRegressionAppConstants.Gmail_NewPassword_Id)).sendKeys(password);
			wDriver.findElement(By.id(BugRegressionAppConstants.Gmail_ConfirmPassword_Id)).sendKeys(password);
			wDriver.findElement(By.id(BugRegressionAppConstants.Gmail_ChangePWDButton)).click();
			Thread.sleep(2000);
			Assert.assertTrue(wDriver.findElement(By.id(BugRegressionAppConstants.Gmail_PwdChangeSuccessMsg_Id)).getText().trim().contains(AppData.ChangePassword_SuccessMsg));
		} catch (Exception e) {
			e.printStackTrace();
			// takeSnapSh;ot("D:\\takeScreenshots", "rediffLogin");
			throw (e);
		}
	}
	

	public static void main(String args[]) throws Exception{
		String url= "htts://www.google.com";
		openBrowser(url);
	}

}
