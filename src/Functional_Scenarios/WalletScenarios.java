
package Functional_Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import App_Functions.GmailLogin;
import App_Functions.OpenHomePage;
import BugRegressionSuite.BaseTestBugRegression;
import Page_Objects.BugRegressionAppConstants;
import Page_Objects.SanitySuiteAppConstants;

public class WalletScenarios extends BaseTestBugRegression {

	public void walletValidation() {
		try {
			extentInfoLogs("Open Home page");
			OpenHomePage.openHomePage();
			extentInfoLogs("Open Navigation drawer");
			clickClassName(BugRegressionAppConstants.Open_Navigation_Drawer);
			extentInfoLogs("Click on sign up  iconOpen Home page");
			clickId(BugRegressionAppConstants.SignUpIcon_id);
			extentInfoLogs("Gmail login");
			GmailLogin.gmailLogin();
			try {
				clickId(SanitySuiteAppConstants.MyAccount_Wallet_Id);
			} catch (Exception e) {
				swipeVertically_FullPage();
				clickId(SanitySuiteAppConstants.MyAccount_Wallet_Id);
			}

			wait.until(ExpectedConditions.visibilityOf(findElementById(SanitySuiteAppConstants.Wallet_Layout_Id)));

			for (int i = 0; i < 3; i++) {
				WebElement walletLayout = findElementById(SanitySuiteAppConstants.Wallet_Layout_Id);

				List<WebElement> linearLayout = walletLayout
						.findElements(By.className(SanitySuiteAppConstants.Wallet_Relative_Layout_Class));
				for (WebElement ele : linearLayout) {
					String walletCardTitle = ele.findElement(By.id(SanitySuiteAppConstants.Wallet_Card_Title_Id))
							.getText();
					System.out.println(walletCardTitle);
					String walletValidTill = ele.findElement(By.id(SanitySuiteAppConstants.Wallet_ValidityDate_Id))
							.getText();
					System.out.println(walletValidTill);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
	}

	@Override
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}
