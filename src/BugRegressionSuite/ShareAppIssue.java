package BugRegressionSuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import App_Functions.OpenOverflowMenu;
import Page_Objects.BugRegressionAppConstants;

public class ShareAppIssue extends BaseTestBugRegression{

	@Override
	@Test(enabled=false)
	public void executeTestCase() throws Exception {
		OpenOverflowMenu.openOverflowMenu();
		clickName(BugRegressionAppConstants.ShareApp_name);
		clickName(BugRegressionAppConstants.FaceBook_Name);
		sendKeysForID("com.facebook.katana:id/login_username", "abc");
		//driver.findElement(By.xpath("//android.widget.FrameLayout /android.widget.TextView[1]")).click();
		//driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("Share");
		driver.findElement(By.id("com.whatsapp:id/contactpicker_row_name")).click();
		driver.findElement(By.id("android:id/button1")).click();
		//List  li = (List) driver.findElements(By.id("android:id/list"));
	//int i =li.getRows();
		//System.out.println(i);
		 
	}

}
