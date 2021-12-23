package utility;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DesiredCapabilitiesUtil {

	public static AppiumDriver getAndroidDriver(String platformVersion , String deviceName, String udid, String deviceURL) throws Exception {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		AppiumDriver androidDriver;
		
		try {
			capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capability.setCapability(MobileCapabilityType.UDID, udid);
			capability.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + getApkRelativePATH());
			
			androidDriver = new AndroidDriver<MobileElement>(new URL(deviceURL), capability);
			androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return androidDriver;
		
		} catch (Exception ex) {
			throw new Exception("Error : " + ex.getMessage());
		}
	}
	
	public static String getApkRelativePATH() {
		if(System.getProperty("os.name").equals("Linux")) {
			return "/src/test/resources/apps/app-development-release.apk";
		}
		else if (System.getProperty("os.name").equals("Windows 10")){
			return "\\src\\test\\resources\\apps\\app-development-release.apk";
		}
		else {
			System.out.println("No apk file found!");
			return null;
		}
	}
	
}
