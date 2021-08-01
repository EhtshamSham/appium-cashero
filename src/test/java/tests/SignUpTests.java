package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpTests extends BaseClass{
	
	@Test
	public void personalRegistartion_001() {
		ExtentTest test_001 = extent.createTest("Personal Registration Test", "Positive: Checks the personal registartion");	
	}
	@Test
	public void personalRegistartion_002() {
		ExtentTest test_002 = extent.createTest("Personal Registration Test", "Positive: Checks the personal registartion");	
	}
	
}
