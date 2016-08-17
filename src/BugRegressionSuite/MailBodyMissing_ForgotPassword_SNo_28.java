package BugRegressionSuite;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenLoginPage;
import Page_Objects.BugRegressionAppConstants;

public class MailBodyMissing_ForgotPassword_SNo_28 extends BaseTestBugRegression{

	
	public void switchToChildWindow() throws Exception {
        try {
               String parentWindow = wDriver.getWindowHandle();
                System.out.println("Parent window : " + parentWindow);
                Set<String> handles = wDriver.getWindowHandles();
                for (String windowHandle : handles) {
                        if (!windowHandle.equals(parentWindow)) {
                                wDriver.switchTo().window(windowHandle);
                                System.out.println("Child window : " + windowHandle);
                                break;
                        } else {
                                System.out.println("Unable to switch");
                        }
                }

        } catch (Exception e) {
                e.printStackTrace();
                // takeSnapShot("D:\\takeScreenshots", "switchToChildWindow");
                throw (e);
        }
}
	@Override
	@Test
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub
		try{
//		clickClassName(AppConstants.Skip_button);
//		clickName(AppConstants.DetectAutomatically_name);
		OpenLoginPage.openLoginPage();
		clickId(BugRegressionAppConstants.Forgot_password_id);
		AssertJUnit.assertEquals("SUBMIT", driver.findElement(By.name(BugRegressionAppConstants.submit_button_text)).getText());
		sendKeysForName(BugRegressionAppConstants.Email_id_text,"vinay.kumar@zopper.com");
		clickName(BugRegressionAppConstants.submit_button_text );
		AssertJUnit.assertEquals(BugRegressionAppConstants.Login_text, driver.findElement(By.name("LOGIN")).getText());
//		wDriver= new FirefoxDriver();
		wDriver= new HtmlUnitDriver();
		System.out.println("launching gmail");
		wDriver.get("http://www.gmail.com");
		System.out.println("launched gmail");
		wDriver.manage().window().maximize();
		wDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wDriver.findElement(By.id("Email")).sendKeys("vinay.kumar@zopper.com");
		wDriver.findElement(By.id("next")).click();
		wDriver.findElement(By.id("Passwd")).sendKeys("zopper@123");
		wDriver.findElement(By.id("signIn")).click();
		WebDriverWait wait= new WebDriverWait(wDriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Zopper account password reset')]")));
		System.out.println("Count : "+wDriver.findElements(By.xpath("//span[contains(text(),'Zopper account password reset')]")).size());
		wDriver.findElement(By.xpath("//span[contains(text(),'Zopper account password reset')]")).click();
		wDriver.findElement(By.partialLinkText("http://zopper.com/forgot-password")).click();
//		Runtime.getRuntime().exec("taskkill firefox.exe");
		//wDriver.switchTo().window(parentWindow);
		System.out.println("abc");
		
		Thread.sleep(5000);
		switchToChildWindow();
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}