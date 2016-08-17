package Utility;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import BugRegressionSuite.BaseTestBugRegression;

public class Performance extends BaseTestBugRegression{
	@Override
	@Test //(invocationCount = 4)
	
	public void executeTestCase() throws Exception {
		ArrayList<Long> measuretime = new ArrayList<Long>();
		long average =0;
		for (int i=0; i<5;i++){
		Timestamp t1 = new Timestamp(System.currentTimeMillis());
		System.out.println(t1);
		//clickClassName(AppConstants.Skip_button);driver
		clickCart();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Login")));
		driver.findElement(By.className("android.widget.ImageButton")).click();
		//driver.findElement(By.name("Detect Automatically")).click();
		Timestamp t2 = new Timestamp(System.currentTimeMillis());
		long duration = t1.getTime()- t2.getTime();
		System.out.println("Duration of page load was"+duration);
		
		measuretime.add(duration);
		//int x = measuretime.size();
	//	System.out.println(x);
		average += duration;
		
		}
		System.out.println("average page load time is " +Long.toString(average/measuretime.size()));
}

	 

		
	}
