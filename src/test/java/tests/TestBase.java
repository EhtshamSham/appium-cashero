package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utility.DesiredCapabilitiesUtil;

public class TestBase {

	public AppiumDriver androidDriver;
	
	@BeforeSuite
	public void setup() {
		try {
			//htmlReporter = new ExtentHtmlReporter("./Reports/" + new SimpleDateFormat("yyyy-MM-dd_HH-mm'.html'").format(new Date()));
		} catch (Exception exp) {
			System.out.println("Message is : " + exp.getMessage());
		}
	}
	
	@BeforeMethod
	@Parameters(value={"PLATFORM_VERSION", "DEVICE_NAME", "UDID", "device-url"})
	public void initDevice(String platformVersion, String deviceName, String udid, String deviceURL) {
		try {
			androidDriver = DesiredCapabilitiesUtil.getAndroidDriver(platformVersion , deviceName, udid, deviceURL);
		} catch (Exception exp) {
			System.out.println("Message is : " + exp.getMessage());
			androidDriver.quit();
		}
	}
	
	@AfterMethod
	public void resetApp() {
		//androidDriver.resetApp();
	}
	
	@AfterSuite
	public void teardown() {
		//androidDriver.removeApp("com.rns.casheroapp.testing");
		//androidDriver.quit();
	}
	
}
