package Utility;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import App_Functions.GmailLogin;
import App_Functions.OpenHomePage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.AppData;

public class Payment extends BaseTestBugRegression{

	@Override
	@Test
	public void executeTestCase() throws Exception {
		OpenHomePage.openHomePage();
		scrollToClick(AppData.MobileAndTabletsLink);
		clickId(BugRegressionAppConstants.Android_phones_id);
		clickXpath(BugRegressionAppConstants.first_android_phone_xpath);
		clickName(BugRegressionAppConstants.BuyNow_button_text);
		GmailLogin.gmailLogin();
		clickId(BugRegressionAppConstants.CheckoutButton_id);
		clickId(BugRegressionAppConstants.ContinueButton_id);
		driver.findElement(By.name("Debit Card")).click();
		driver.findElement(By.name("Card Number")).sendKeys("5326 7605 0449 6071");
		driver.findElement(By.name("Name on Card")).sendKeys("ARGNESHU GUPTA");
		//driver.navigate().back();
		driver.findElement(By.name("Expiry Month")).click();
		driver.findElement(By.name("01")).click();
		driver.findElement(By.name("Expiry Year")).click();
		driver.findElement(By.name("2017")).click();
		driver.findElement(By.name("CVV")).sendKeys("573");
		driver.findElement(By.name("PLACE ORDER")).click();
		driver.findElement(By.xpath("//android.widget.Button[@index=1]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index=0]")).sendKeys("csdsdvv");
		driver.findElement(By.xpath("//android.widget.Button[@index=0]")).click();
	}

}
