package BugRegressionSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.selendroid.server.common.exceptions.NoSuchElementException;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page_Objects.AppData;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;
import Utility.SendExecutionReport;
import Utility.UsernameValidator;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*********************** Base Class info: *****************************/
// 1.It includes initialization and killing of driver
// 2.It includes all the customized functions
// 3.It includes log4j functions
// 4.It includes Take screenshot functions

public abstract class BaseTestBugRegression {
	protected static AndroidDriver driver = null;
	protected static IOSDriver driver1 = null;
	protected MobileElement element;
	protected static WebDriverWait wait = null;
	protected static WebDriverWait wait1 = null;
	protected static WebDriver wDriver = null;
	protected static String packName = null;
	protected static String methodName = null;
	protected static String methodName_1 = null;
	public static String buildType = null;
	static String curentDate = null;
	protected static long startTime_Long = 0;
	public static long endTime_Long = 0;
	public static String startTime = null;
	public static String endTime = null;
	protected static String timeConsumed = null;
	static String deviceVersion = null;
	static int t_Case = 0;
	int p_Case = 0;
	static int f_Case = 0;
	static int r_Case = 0;
	DesiredCapabilities cap;
	File app;
	boolean staging = false;

	static int inc = 0;

	protected String Con_Package_Name = null;
	protected String Con_Activity_Name = null;

	protected static ExtentReports report;
	protected static ExtentTest logger;

	public static Logger Log = Logger.getLogger(BaseTestBugRegression.class.getName());

	static File currDir = new File("");
	protected static String path = currDir.getAbsolutePath();

	public static String resultFile = path + "/ExtentResult";
	
	public static String resultFile_1 = path + "/test-output";

	public BaseTestBugRegression() {
		report = new ExtentReports(resultFile + "/ConsumerAppSuiteResult.html");

	}

	public boolean isEnabled() {
		return true;
	}

	// @org.testng.annotations.Test
	// public void initTest() {
	// if (isEnabled()) {
	// initializeDrivers();
	//
	// executeTest();
	//
	// quitTest();
	// }
	//
	// }

	public static MobileElement findElementByClassName(String className) {
		return (MobileElement) driver.findElement(By.className(className));
	}

	public static MobileElement findElementById(String id) {
		return (MobileElement) driver.findElement(By.id(id));
	}

	public static MobileElement findElementByName(String name) {
		return (MobileElement) driver.findElement(By.name(name));
	}

	public static MobileElement findElementByXpath(String xpath) {
		return (MobileElement) driver.findElement(By.xpath(xpath));
	}

	public static void clickClassName(String className) {
		findElementByClassName(className).click();
	}

	public static void clickName(String name) {
		findElementByName(name).click();
	}

	public static void clickId(String id) {
		findElementById(id).click();
	}

	public static void clickXpath(String xpath) {
		findElementByXpath(xpath).click();
	}

	public static void sendKeysForID(String id, String keyword) {
		findElementById(id).clear();
		findElementById(id).sendKeys(keyword);
		hideKeyboard();
	}

	public static void sendKeysForName(String name, String keyword) {
		findElementByName(name).sendKeys(keyword);
	}

	public static void sendKeysForXpath(String xpath, String keyword) {
		findElementByXpath(xpath).sendKeys(keyword);
	}

	public void scrollTo(String textname) {
		driver.scrollToExact(textname);
	}

	public void scrollToClick(String textname) {
		driver.scrollToExact(textname).click();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void backButton() {
		driver.findElement(By.className(BugRegressionAppConstants.ProductDetailsBackbutton_class)).click();
	}

	public void clearForId(String id) {
		findElementById(id).clear();
	}

	public void clearForName(String name) {
		findElementByName(name).clear();
	}

	public void clickCart() {
		driver.findElement(By.id(SanitySuiteAppConstants.Cart_id)).click();
	}

	public void swipeWithAxis(int x, int y, int z, int a, int b) {
		driver.swipe(x, y, z, a, b);
	}

	public void closeAppiumSession() {
		driver.quit();
	}

	public void closeAppiumSessionWithClose() {
		driver.close();
	}

	public static List<WebElement> findElementsById(String Id) {
		return driver.findElements(By.id(Id));
	}

	public static List<WebElement> findElementsByName(String name) {
		return driver.findElements(By.name(name));
	}

	public static List<WebElement> findElementsByClassName(String className) {
		return driver.findElements(By.className(className));
	}

	public static boolean verifyElementDisplayedByName(String name) {
		boolean flag = false;
		try {
			driver.findElement(By.name(name)).isDisplayed();
			flag = true;
		} catch (Exception e) {

		}
		return flag;
	}

	public static boolean verifyElementDisplayedByLink(String link) {
		boolean flag = false;
		try {
			driver.findElement(By.linkText(link)).isDisplayed();
			flag = true;
		} catch (Exception e) {

		}
		return flag;
	}

	public void clearEditFieldByID(String id) {
		findElementById(id).clear();
	}

	public static void hitADBCommandForCamera(String KeyData) {
		try {
			for (int i = 0; i < 3; i++) {
				Runtime.getRuntime().exec("adb shell input keyevent " + KeyData);
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
	}

	public static void hitADBCommandForUninstallCallerApp() {
		try {
			for (int i = 0; i < 3; i++) {
				Runtime.getRuntime().exec("adb uninstall " + AppData.Fake_Caller_PackageName);
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
	}

	public static void hitADBCommandForWiFi(String KeyData) {
		try {
			for (int i = 0; i < 3; i++) {
				Runtime.getRuntime().exec("adb shell am start -n io.appium.settings/.Settings -e wifi " + KeyData);
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
	}

	public static void hideKeyboard() {
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
		}
	}

	public static boolean verifyClickName(String name) {
		boolean flag = false;
		try {
			findElementByName(name).click();
			flag = true;
		} catch (Exception e) {
			e.toString();
		}
		return flag;
	}

	public boolean verifyElementExistById(String id) {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			if (driver.findElements(By.id(id)).size() > 0)
				flag = true;

		} catch (Exception e) {

		} finally {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return flag;
	}

	public static boolean verifyElementExistByName(String name) {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (driver.findElements(By.name(name)).size() > 0)
				flag = true;

		} catch (Exception e) {

		} finally {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return flag;
	}

	public static void swipeHorizontally() {

		try {
			// swipeHight = swipeValue;
			Dimension screenSize = driver.manage().window().getSize();

			int screenWidth = screenSize.getWidth();
			int screenHight = screenSize.getHeight() / 2;
			// if (screenHight + swipeValue > screenHight * 2 || swipeValue ==
			// 0) {
			// swipeHight = screenHight / 2;
			//
			// }

			driver.swipe(screenWidth + screenWidth / 2 + screenWidth / 3, screenHight, 20, screenHight, 2000);

			// waitForVisible(30);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static void waitForVisible(int waitTime) throws InterruptedException {
		final By by = null;
		for (int attempt = 0; attempt < waitTime; attempt++) {
			try {
				driver.findElement(by);
				break;
			} catch (Exception e) {
				Thread.sleep(2000);
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void swipeVertically(int swipeValue) {

		try {
			int swipeHight = 0;
			swipeHight = swipeValue;
			Dimension screenSize = driver.manage().window().getSize();

			int screenWidth = screenSize.getWidth() / 2;
			int screenHight = screenSize.getHeight() / 2;
			if (screenHight + swipeValue > screenHight * 2 || swipeValue == 0) {
				swipeHight = screenHight / 2;

			}
			// waitForVisible(30);
			driver.swipe(screenWidth, screenHight + swipeHight, screenWidth, screenHight, 1000);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static String clickByName(String name, String category) throws Exception {
		boolean flag = false;
		String elementText = null;
		try {
			for (int i = 0; i < 3; i++) {
				List<WebElement> elements = driver.findElements(By.name(name));
				for (WebElement elemnt : elements) {
					if (elemnt.getText().replace(" ", "").toLowerCase()
							.contains(category.replace(" ", "").toLowerCase())) {
						elementText = elemnt.getText();
						elemnt.click();
						flag = true;
						break;
					}
				}
				if (flag == false) {
					swipeVertically_FullPage();
					swipeVertically_FullPage();
				} else {
					break;
				}
			}
		} catch (Exception e) {
			throw (e);
		}
		return elementText;

	}
	
	public static String clickOnCategoryByName(String id, String category) throws Exception {
		boolean flag = false;
		String elementText = null;
		System.out.println("catgeory name is " + category);
		try {
			for (int i = 0; i < 3; i++) {
				List<WebElement> elements = driver.findElements(By.id(id));
				for (WebElement elemnt : elements) {
					System.out.println("element text is : "+elemnt.getText());
					if (elemnt.getText().replace(" ", "").toLowerCase()
							.contains(category.replace(" ", "").toLowerCase())) {
						elementText = elemnt.getText();
						elemnt.click();
						flag = true;
						break;
					}
				}
				if (flag == false) {
					swipeVertically_FullPage();
					swipeVertically_FullPage();
				} else {
					break;
				}
			}
		} catch (Exception e) {
			throw (e);
		}
		return elementText;

	}
	
	

	public static String getTextByName(String id, String category) throws Exception {
		boolean flag = false;
		String elementText = null;
		try {
			for (int i = 0; i < 3; i++) {
				List<WebElement> elements = driver.findElements(By.id(id));
				for (WebElement elemnt : elements) {
					if (elemnt.getText().replace(" ", "").toLowerCase()
							.contains(category.replace(" ", "").toLowerCase())) {
						elementText = elemnt.getText();
						flag = true;
						break;
					}
				}
				if (flag == false) {
					swipeVertically_FullPage();
					swipeVertically_FullPage();
				} else {
					break;
				}
			}
		} catch (Exception e) {
			throw (e);
		}
		return elementText;
	}

	public static void clickIDByIndex(String id, int index) {
		 driver.findElementsById(id).get(index).click();
	}

	public static void swipeVertically_FullPage() {

		try {
			Dimension screenSize = driver.manage().window().getSize();

			int screenWidth = screenSize.getWidth() / 2;
			int screenHight = screenSize.getHeight();
			screenHight = screenHight - screenHight * 20 / 100;
			// if (screenHight + swipeValue > screenHight * 2 || swipeValue ==
			// 0) {
			// swipeHight = screenHight / 2;
			//
			// }
			// waitForVisible(30);
			driver.swipe(screenWidth, screenHight, screenWidth, 0, 1000);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}
		
	public static boolean verifyObjectPresent(AndroidDriver driver) {

		try {

			driver.findElement(By.linkText("+ Report Categories"));

			return true;

		} catch (Exception e) {

			return false;

		}

	}

	@BeforeSuite
	public void currentDate() {
		try {
			deleteAllImageFiles();
			report.loadConfig(new File(path + "/extent-config.xml"));
			Date curDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			format = new SimpleDateFormat("E, dd MMM yyyy");
			curentDate = format.format(curDate);

			format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			startTime = format.format(curDate);
			startTime_Long = curDate.getTime();
			System.out.println("start time is : " + startTime_Long);
		} catch (Exception e) {
			System.out.println("Date time exception::" + e.getMessage());
		}
	}

	@Test
	public abstract void executeTestCase() throws Exception;

	@BeforeMethod
	public AndroidDriver initializeDrivers(Method method) throws Exception {
		try {
			packName = this.getClass().getCanonicalName();
			methodName = this.getClass().getSimpleName() + "(" + method.getName() + ")";
			if (!methodName.equals(methodName_1)) {
				t_Case++;
			} else {
				r_Case++;
			}

			File app;
			logger = report.startTest(methodName);
			System.out.println(" Initializing Drivers for Class :" + this.getClass().getSimpleName() + "("
					+ method.getName() + ")");

			DOMConfigurator.configure("log4j.xml");

			String appPath = path + "/app";
		String osName=	System.getProperty("os.name");
		System.out.println(osName);

			cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");//"Android" //iOS
			cap.setCapability("deviceName","" );//"SM-N750"
			//cap.setCapability("udid", "0532bef2379f1be3cee91d63b556dc4252a9080a");
			//cap.setCapability("bundleId", "com.zopper.zopper-stag");
			cap.setCapability("platformVersion", "");//5.1.1
			if (packName.contains("Functional_Scenarios")) {
				if(staging == false){//(System.getProperty("staging").equalsIgnoreCase("true")) //staging == false
					System.out.println("functional scenarios on staging......");
					app = new File(appPath, "app-staging-debug-1.4.1.14101891.apk");
					Con_Package_Name = "com.zopperapp.staging";
					Con_Activity_Name = "com.zopper.aegon.ui.activity.SplashActivity";
					
				} else {
					System.out.println("functional scenarios on production ......");
					app = new File(appPath, "app-prod-release-1.4.0.14001847.apk");

					Con_Package_Name = "com.zopperapp";
					Con_Activity_Name = "com.zopper.aegon.ui.activity.SplashActivity";
				}
				// Production build
			} else {
				System.out.println("functional scenarios on staging(else)");
				app = new File(appPath, "app-staging-debug-13100.apk");
				Con_Package_Name = "com.zopperapp.staging";
				Con_Activity_Name = "com.zopper.aegon.ui.activity.OnBoardingActivity";
			}
			cap.setCapability("app-package", Con_Package_Name);
			cap.setCapability("app-activity", Con_Activity_Name);
			cap.setCapability("app", app.getAbsolutePath());
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);  //"http://127.0.0.1:4723/wd/hub"
		//IOSDriver driver1 = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			//"http://localhost:4444

		} catch (Exception e)

		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		return driver;

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		try {
			System.out.println("Test Case Result is "+result);
			String imgFileName = this.getClass().getSimpleName() + "_" + result.getName();
			if (!result.isSuccess()) {
				f_Case++;
				captureScreenShot(driver, "./ExtentResult", imgFileName);
				String img = logger.addScreenCapture(imgFileName + ".png");
				logger.log(LogStatus.FAIL, result.getName(), img);
				extentFailLogs(result.getThrowable().getMessage());
			} else {
				extentPassLogs(result.getName());
			}

			report.endTest(logger);
			report.flush();
			methodName_1 = methodName;
			driver.quit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getTotalExecutionTime(long starttime, long endtime) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		String datetype = dateFormat.format(cal.getTime());
		long diff = endtime - starttime;
		@SuppressWarnings("unused")
		long diffMilliSeconds = diff % 1000;
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		// long diffDays = diff / (24 * 60 * 60 * 1000);

		return (datetype + diffHours + ":" + diffMinutes + ":" + diffSeconds);

	}

	public static long getTotalExecutionTimeInMS(long starttime, long endtime) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		String datetype = dateFormat.format(cal.getTime());
		long diff = endtime - starttime;
		diff = diff/1000;
		@SuppressWarnings("unused")
		long diffMilliSeconds = diff % 1000;
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		// long diffDays = diff / (24 * 60 * 60 * 1000);

		return diff;

	}

	public static String getTotalExecutionTimeSeconds(long starttime, long endtime) {
		long diff = endtime - starttime;
		@SuppressWarnings("unused")
		long diffMilliSeconds = diff % 1000;
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		// long diffDays = diff / (24 * 60 * 60 * 1000);

		return (":" + diffSeconds);

	}

	// @AfterTest
	// public void openReport() throws IOException{
	// File htmlFile = new File(resultFile + "/ConsumerAppSuiteResult.html");
	// Desktop.getDesktop().browse(htmlFile.toURI());
	// }

	@Parameters("sendMail")
	@AfterSuite
	public void afterExecution() {
		try {
			report.close();
			Date date = new Date();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
			format1 = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			endTime = format1.format(date);
			endTime_Long = date.getTime();
			System.out.println("end time is :" + endTime_Long);
			timeConsumed = getTotalExecutionTime(startTime_Long, endTime_Long);
			int failed = f_Case - r_Case;
			copyFile(new File(resultFile + "/ConsumerAppSuiteResult.html"),
					new File(resultFile + "/ConsumerAppSuiteResult_Copy.html"));
			String replacingString = "<script id='myScript' src='extent.js?" + failed
					+ " type='text/javascript'></script>";
			Thread.sleep(10000);
			replaceJS(replacingString);
			textToHtml();
			File htmlFile = new File(resultFile + "/ConsumerAppSuiteResult.html");
			Desktop.getDesktop().browse(htmlFile.toURI());

			
			if (System.getProperty("sendMail").equalsIgnoreCase("true")) {
				SendExecutionReport sReport = new SendExecutionReport();
				sReport.sendMail(getDeviceVersion(), getOSNameWithDeviceBrand());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String captureScreenShot(WebDriver driver, String path, String screenShotName) {
		String dest = "";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = (File) ts.getScreenshotAs(OutputType.FILE);
			dest = path + "/" + screenShotName + ".png";
			System.out.println(path);
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		return dest;
	}

	@AfterTest
	protected void quitTest() {
		driver.quit();
	}

	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String sTestCaseName) {

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

		Log.info("X");

		Log.info("X");

		Log.info("X");

		Log.info("X");

	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {

		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(String message) {

		Log.error(message);

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}

	// public void takeSnapShot(AndroidDriver webdriver,String fileWithPath,
	// String method) throws Exception{
	public void takeSnapShot(String fileWithPath, String method) {
		// Convert web driver object to TakeScreenshot
		try {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			TakesScreenshot scrShot = ((TakesScreenshot) augmentedDriver);

			// Call getScreenshotAs method to create image file

			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination

			// File DestFile = new File("E:\\Screenshots\\hello.jpg");
			File DestFile = new File(fileWithPath + "\\" + method + ".jpg");

			// Copy file at destination

			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void textToHtml() {
		try {
			BufferedReader txtfile = new BufferedReader(new FileReader(path + "/PiChartReport.txt"));
			OutputStream htmlfile = new FileOutputStream(new File(path + "/PiChartReport.html"));
			PrintStream printhtml = new PrintStream(htmlfile);

			String[] txtbyLine = new String[500];
			String temp = "";
			String txtfiledata = "";

			String htmlheader = "<html><head>";
			htmlheader += "<title>Equivalent HTML</title>";
			htmlheader += "</head><body>";
			String htmlfooter = "</body></html>";
			int linenum = 0;
			while ((txtfiledata = txtfile.readLine()) != null) {
				txtfiledata = txtfiledata.replace("Ex_Date", curentDate);
				txtfiledata = txtfiledata.replace("S_Time", startTime);
				txtfiledata = txtfiledata.replace("E_Time", endTime);
				txtfiledata = txtfiledata.replace("Time_Consumed", timeConsumed);
				txtfiledata = txtfiledata.replace("T_Scenarios", Integer.toString(t_Case));
				txtfiledata = txtfiledata.replace("P_Scenarios", Integer.toString(t_Case - (f_Case - r_Case)));
				txtfiledata = txtfiledata.replace("F_Scenerios", Integer.toString(f_Case - r_Case));
				txtfiledata = txtfiledata.replace("R_Scenerios", Integer.toString(r_Case));

				txtbyLine[linenum] = txtfiledata;
				linenum++;
			}
			for (int i = 0; i < linenum; i++) {
				if (i == 0) {
					temp = htmlheader + txtbyLine[0];
					txtbyLine[0] = temp;
				}
				if (linenum == i + 1) {
					temp = txtbyLine[i] + htmlfooter;
					txtbyLine[i] = temp;
				}
				printhtml.println(txtbyLine[i]);
			}

			printhtml.close();
			htmlfile.close();
			txtfile.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void replaceJS(String replacingString) {
		try {
			File file = new File(resultFile + "/ConsumerAppSuiteResult.html");
			String str_To = "<script src='http://cdn.rawgit.com/anshooarora/extentreports/005d99e2f2716f6d749c77c65b57ca3c632c35a8/cdn/extent.js' type='text/javascript'></script>";

			String fileContext = FileUtils.readFileToString(file);
			fileContext = fileContext.replaceAll(str_To, replacingString);
			FileUtils.write(file, fileContext);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void extentInfoLogs(String message) {
		logger.log(LogStatus.INFO, "<span class='label info'>" + message + "</span>");
	}

	public static void extentFailLogs(String message) {
		logger.log(LogStatus.FAIL, "<span class='label failure'>" + message + "</span>");
	}

	public static void extentPassLogs(String message) {
		logger.log(LogStatus.PASS, "<span class='label success'>" + message + "</span>");
	}

	public static void deleteCartItems() {
		try {
			for (int i = 0; i < 3; i++) {
				if (findElementsById(BugRegressionAppConstants.CartDeleteButton_Id).size() > 0) {
					List<WebElement> delButton = findElementsById(BugRegressionAppConstants.CartDeleteButton_Id);
					for (int j = 0; j < delButton.size(); j++) {
						wait.until(ExpectedConditions
								.elementToBeClickable(By.id(BugRegressionAppConstants.CartDeleteButton_Id)));
						clickId(BugRegressionAppConstants.CartDeleteButton_Id);
						clickName(AppData.Delete_text);
					}
				} else {
					break;
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void copyFile(File sourceFile, File destFile) throws IOException {
		if (!sourceFile.exists()) {
			return;
		}
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		source = new FileInputStream(sourceFile).getChannel();
		destination = new FileOutputStream(destFile).getChannel();
		if (destination != null && source != null) {
			destination.transferFrom(source, 0, source.size());
		}
		if (source != null) {
			source.close();
		}
		if (destination != null) {
			destination.close();
		}

	}

	public static String getDeviceName() {
		String id = null;
		try {
			InputStream is = Runtime.getRuntime().exec("adb devices").getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			id = out.toString().split("attached")[1];
			id = id.split("	")[0];

			is = Runtime.getRuntime().exec("adb -s " + id + " shell getprop ro.product.model").getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			out = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			id = out.toString();
		} catch (Exception e) {
			System.out.println("Connect your device properly : " + e.getMessage());
		}
		return id;
	}

	public static String getDeviceId() {
		String id = null;
		try {
			InputStream is = Runtime.getRuntime().exec("adb devices").getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			id = out.toString().split("attached")[1];
			id = id.split("	")[0];

			is = Runtime.getRuntime().exec("adb -s " + id + " shell getprop net.hostname").getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			out = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			id = out.toString().split("-")[1];

		} catch (Exception e) {
			System.out.println("Connect your device properly : " + e.getMessage());
		}
		return id;
	}

	public static String getDeviceVersion() {
		String id = null;
		try {
			InputStream is = Runtime.getRuntime().exec("adb devices").getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			id = out.toString().split("attached")[1];
			id = id.split("	")[0];

			is = Runtime.getRuntime().exec("adb -s " + id + " shell getprop ro.build.description").getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			out = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			id = out.toString().split("user ")[1];
			id = id.split(" ")[0];

		} catch (Exception e) {
			System.out.println("Connect your device properly : " + e.getMessage());
		}
		return id;
	}

	public static String getOSNameWithDeviceBrand() {
		String id = null;
		try {
			InputStream is = Runtime.getRuntime().exec("adb devices").getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			id = out.toString().split("attached")[1];
			id = id.split("	")[0];

			is = Runtime.getRuntime().exec("adb -s " + id + " shell getprop ro.com.google.clientidbase")
					.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			out = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			id = out.toString();
		} catch (Exception e) {
			System.out.println("Connect your device properly : " + e.getMessage());
		}
		return id;
	}

	public static void verifyProductDetailPage() {
		try {
			if (findElementsById(SanitySuiteAppConstants.ProductList_Product_Id).get(0).isDisplayed()) {
				findElementsById(SanitySuiteAppConstants.ProductList_Product_Id).get(0).click();
			}
		} catch (Exception e) {
		}
	}

	public void deleteAllImageFiles() {
		String[] okFileExtensions = new String[] { "jpg", "png", "gif" };
		try {
			File dir = new File("./ExtentResult");

			// list the files using our FileFilter
			File[] files = dir.listFiles();
			for (File f : files) {
				for (String extension : okFileExtensions) {
					if (f.getName().toLowerCase().endsWith(extension)) {
						f.delete();
						System.out.println("Deleted filr name::" + f.getName());
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void selectCity(String city, String sub_City) {
		boolean flag = false;
		try {
			if (!verifyElementExistByName(AppData.Locationtext)) {
				clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
				clickId(BugRegressionAppConstants.NavDrawerLocationIcon_id);
			}
			Assert.assertTrue(findElementByName(BugRegressionAppConstants.SelectLocation_text).getText()
					.equals(AppData.Locationtext));
			for (int i = 0; i < 5; i++) {
				List<WebElement> cityList = findElementsById(BugRegressionAppConstants.Location_CitiesNames_Id);
				for (WebElement cityName : cityList) {
					if (cityName.getText().trim().toLowerCase().equals(city.trim().toLowerCase())) {
						cityName.click();
						for (int j = 0; j < 10; j++) {
							List<WebElement> subCityList = findElementsById(
									BugRegressionAppConstants.Location_Sub_City_Id);
							for (WebElement subCityName : subCityList) {
								if (sub_City.equals("")) {
									subCityName.click();
									flag = true;
									break;
								}
								if (subCityName.getText().trim().toLowerCase().equals(sub_City.trim().toLowerCase())) {
									subCityName.click();
									flag = true;
									break;
								}
							}
							if (flag)
								break;
							else {
								swipeVertically_FullPage();
								swipeVertically_FullPage();
							}

						}
						if (flag)
							break;
						else {
							swipeVertically_FullPage();
							swipeVertically_FullPage();
						}
					}
				}

				if (flag)
					break;
				else {
					swipeVertically_FullPage();
					swipeVertically_FullPage();
				}

			}

		} catch (Exception e) {

		}
	}
	
	public static void clickOnFirstSuggestedProduct(){
		WebElement searchList =findElementById(BugRegressionAppConstants.SearchList_id);
		List<WebElement> linearlayout = searchList.findElements(By.className(BugRegressionAppConstants.SearchLinearLayout_classname));
		linearlayout.get(0).click();
	}
	
	public static String propertiesFile(){
		try {  
			// Create FileInputStream Object  
			FileInputStream fileInput = new FileInputStream(new File("./Config.properties"));  
			// Create Properties object  
			Properties prop = new Properties();  
			//load properties file  
			prop.load(fileInput);
	}catch(Exception e){
		
	}
		return "";
}
	
	public static boolean isElementPresent(By by, WebDriver driver) 
    {
      boolean present;
      try
        {
          driver.findElement(by);
          present = true;
        }catch (NoSuchElementException e)
        {
          present = false;
         }
     return present;
    }
}
