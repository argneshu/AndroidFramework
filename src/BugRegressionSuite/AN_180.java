package BugRegressionSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import App_Functions.OpenHomePage;
import Page_Objects.BugRegressionAppConstants;

public class AN_180  extends BaseTestBugRegression{
	
	void changeandroidsetting(String setting)
	{
		try{
			List<WebElement> elements = driver.findElements(By.id("com.android.systemui:id/text"));
			for(WebElement loc : elements){
				if(loc.getText().contains(setting)){
					System.out.println("loct"+loc.getText());
					loc.click();
				break;
			}}}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}

	@Override
	@Test
	public void executeTestCase() throws Exception {
		
		
		
		
		try{
			System.out.println("executing adb to disable location");
			Runtime.getRuntime().exec("adb shell settings put secure location_providers_allowed ' '");
			System.out.println("executing adb");
			//System.out.println("wifioff");
			//driver.openNotifications();
			//clickId(AppConstants.Android_Location_Setting_Id);
			//changeandroidsetting("Location");
			//driver.quit();
			//initializeDrivers();
			OpenHomePage.openHomePage();
			AssertJUnit.assertEquals("Location Disabled", findElementByName("Location Disabled").getText());
			clickId(BugRegressionAppConstants.DetectAutomaticallyDisabled_popup_cancelButton_id);
			//driver.openNotifications();
			//clickId(AppConstants.Android_Location_Setting_Id);
			//changeandroidsetting("Location");
			Runtime.getRuntime().exec("adb shell settings put secure location_providers_allowed gps,wifi,network");
			}
//			
		
		catch(Throwable e)
		{
			System.out.println(e);
			//System.out.println("Element Not Found");
		}
	}

}
