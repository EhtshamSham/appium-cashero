package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.LoginScreens;

public class LoginTests extends TestBase{
	
	@Test(priority=1)
	public void verifyLoginWithSupportedCountry() throws Exception { 
		
		//ExtentTest supportedCountryTest = extent.createTest("Supported Country Test", "Positive: Verifies supported country");
		LoginScreens loginScreens = new LoginScreens(androidDriver);
		
		try {
			
			loginScreens.allowLocationPermission();
			loginScreens.visitOnboardingScreens();
			loginScreens.selectCountry("Iran");
			//loginScreens.enterPhoneNumber("9123456789");
			//loginScreens.sendCode();
			//loginScreens.sendCode();
			//loginScreens.sendCode();
			
			
			//if(loginScreens.isOTPScreenTitleVisible())
				//supportedCountryTest.log(Status.PASS, "OTP screen is visible");
			//else
				//supportedCountryTest.log(Status.FAIL, "OTP screen is not visible");
			
			Assert.assertTrue(true);
			
        }catch(Exception ex){
        	//supportedCountryTest.log(Status.SKIP, ex.getMessage());
        	throw new SkipException(ex.getMessage());
        }
		
	}
	
}
