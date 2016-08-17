package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.IOUtils;

import BugRegressionSuite.BaseTestBugRegression;

public class SendExecutionReport extends BaseTestBugRegression {

	private String SMTP_HOST = "smtp.gmail.com";
	private static String FROM_ADDRESS = "qa-test@zopper.com";
	private static String PASSWORD = "tech@1234";
	URL url;

	public boolean sendMail(String version,String os_Name) throws FileNotFoundException, IOException {
		try {
			String FROM_NAME = "Consumer Automation Report";
			Properties props = new Properties();
			props.put("mail.smtp.host", SMTP_HOST);
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "false");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.port", "localhost");
			props.put("mail.smtp.starttls.enable", "true");

			String[] recipients = new String[] {"arvind@zopper.com"};
			String[] bccRecipients = new String[] {"argneshu@zopper.com","qa@zopper.com"};
			Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

			Date currentTime = localCalendar.getTime();

			String subject = "Consumer App Automation Report(OS Name and Device Brand : "+os_Name+" Version : "+version +") " + currentTime;

			Session session = Session.getInstance(props, new SocialAuth());
			Message msg = new MimeMessage(session);

			InternetAddress from = new InternetAddress(FROM_ADDRESS, FROM_NAME);
			msg.setFrom(from);

			InternetAddress[] toAddresses = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++) {
				toAddresses[i] = new InternetAddress(recipients[i]);
			}
			msg.setRecipients(Message.RecipientType.TO, toAddresses);

			InternetAddress[] bccAddresses = new InternetAddress[bccRecipients.length];
			for (int j = 0; j < bccRecipients.length; j++) {
				bccAddresses[j] = new InternetAddress(bccRecipients[j]);
			}
			msg.setRecipients(Message.RecipientType.BCC, bccAddresses);

			msg.setSubject(subject);

			FolderZip.CompressResultFolder();
			//FolderZip.CompressResultFolderfortestng();
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1
					.setText("Hi,\n\n" + "" + "Please find below Consumer app automation suite execution report.\n"
							+ "Detailed test report can be found in the attached zip file \n\n"
							+ "Execution report is also available on : " + FolderZip.destFolderPath);

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			//MimeBodyPart messageBodyPart4 = new MimeBodyPart();

			DataSource source = new FileDataSource(resultFile + ".zip");
			//DataSource source1 = new FileDataSource(resultFile_1 + ".zip");
			//DataSource source = new FileDataSource(path+"/test-output/html.zip");
			messageBodyPart2.setDataHandler(new DataHandler(source));
			//messageBodyPart4.setDataHandler(new DataHandler(source1));
//			messageBodyPart2.setFileName("ConsumerSuiteResult_"+os_Name+"_"+version.replace(".", "")+".zip");
			messageBodyPart2.setFileName("ExtentResult.zip");
			//messageBodyPart4.setFileName("testng.zip");

			StringWriter writer = new StringWriter();
			IOUtils.copy(new FileInputStream(new File(path + "/PiChartReport.html")), writer);
			BodyPart messageBodyPart3 = new MimeBodyPart();
			messageBodyPart3.setContent(writer.toString(), "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart3);
			//multipart.addBodyPart(messageBodyPart4);

			msg.setContent(writer.toString(), "text/html");
			msg.setContent(multipart);

			Transport.send(msg);
			return true;
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(SendExecutionReport.class.getName()).log(Level.SEVERE, null, ex);
			return false;

		} catch (MessagingException ex) {
			Logger.getLogger(SendExecutionReport.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	class SocialAuth extends Authenticator {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {

			return new PasswordAuthentication(FROM_ADDRESS, PASSWORD);

		}
	}

	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		SendExecutionReport exR = new SendExecutionReport();
		String version=getDeviceVersion();
		String os_name=getOSNameWithDeviceBrand();
		exR.sendMail(version,os_name);

	}

	@Override
	public void executeTestCase() throws Exception {
		// TODO Auto-generated method stub

	}

}