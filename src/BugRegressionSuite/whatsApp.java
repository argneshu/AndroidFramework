package BugRegressionSuite;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class whatsApp {
	// private static XSSFSheet ExcelWSheet;
	//
	// private static XSSFWorkbook ExcelWBook;
	//
	// private static XSSFCell Cell;
	//
	// private static XSSFRow Row;
	public AndroidDriver driver;

	// String sellername = "";
	// String sellerco = "";
	// String sellermob = "";
	// String selleradd = "";
	// String sellercity = "";

	@Test
	public void whatsAppGroupAttachment() throws Exception {
		// String Path_TestData =
		// "D:\\Zopper\\ConsumerAppBugRegression\\src\\TestData\\";
		// String File_TestData = "testData.xlsx";
		// setExcelFile(AppConstants.Path_TestData + AppConstants.File_TestData,
		// "Sheet1");

		// setCellData("pass", 1, 2);
		File appdir = new File("C:\\sdk\\build-tools\\android-4.4W");
		File app = new File(appdir, "WhatsApp_com.whatsapp.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformname", "Android");
		cap.setCapability("noReset", true);
		cap.setCapability("fullReset", false);
		cap.setCapability("deviceName", "SM-N750");
		cap.setCapability("platformVersion", "4.4.2");
		cap.setCapability("app-package", "com.whatsapp");
		// cap.setCapability("app-activity","com.nnacres.app.activity.SplashActivity");
		cap.setCapability("app", app.getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// Log.info("New driver instantiated");
		// driver.get("https://www.google.com/maps/@28.6251545,77.3788139,19z");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		List<WebElement> groupList = driver.findElements(By
				.id("com.whatsapp:id/conversations_row_contact_name"));
		for (WebElement rowList : groupList) {
			System.out.println("text is " + rowList.getText());
			if (driver.findElements(
					By.id("com.whatsapp:id/conversations_row_contact_name"))
					.size() > 0) {
				if (rowList.getText().equalsIgnoreCase("Automation")) {
					rowList.click();
					break;
				}

			} else {
				swipeVertically();

			}
		}
		driver.findElement(By.name("More options")).click();
		driver.findElement(By.name("More")).click();
		driver.findElement(By.name("Email chat")).click();
		if (driver.findElements(By.name("Gmail")).size() > 0) {
			driver.findElement(By.name("Gmail")).click();// Gmail
		} else {
			swipeVertically();
			driver.findElement(By.name("Gmail")).click();
		}
		driver.findElement(By.id("com.google.android.gm:id/to")).sendKeys(
				"developer.android.nitin@gmail.com");
		driver.findElement(By.id("com.google.android.gm:id/send")).click();
		

	}

	public void swipeVertically() {
		Dimension screenSize = driver.manage().window().getSize();
		int screenWidth = screenSize.getWidth() / 2;
		int screenHight = screenSize.getHeight();
		screenHight = screenHight - screenHight * 20 / 100;
		driver.swipe(screenWidth, screenHight, screenWidth, 0, 1000);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

	// public static void setCellData(String Result, int RowNum, int ColNum)
	// throws Exception {
	// System.out.println(RowNum);
	// System.out.println(ColNum);
	// try{
	//
	//
	// Row = ExcelWSheet.getRow(RowNum);
	// System.out.println(Row);
	//
	// Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
	// System.out.println(Cell);
	//
	// if (Cell == null) {
	//
	//
	// Cell = Row.createCell(ColNum);
	//
	// Cell.setCellValue(Result);
	//
	// } else {
	//
	// Cell.setCellValue(Result);
	//
	// }

	// Constant variables Test Data path and Test Data file name

	// FileOutputStream fileOut = new
	// FileOutputStream(AppConstants.Path_TestData +
	// AppConstants.File_TestData);

	// ExcelWBook.write(fileOut);

	// fileOut.flush();

	// fileOut.close();

	// }catch(Exception e){
	//
	// throw (e);
	//
	// }
	//
	// }

	// public static void setExcelFile(String Path, String SheetName)
	// throws Exception {
	//
	// try {
	//
	// // Open the Excel file
	//
	// FileInputStream ExcelFile = new FileInputStream(Path);
	//
	// // Access the required test data sheet
	//
	// ExcelWBook = new XSSFWorkbook(ExcelFile);
	//
	// ExcelWSheet = ExcelWBook.getSheet(SheetName);
	//
	// } catch (Exception e) {
	//
	// throw (e);
	//
	// }
	//
	// }

}
