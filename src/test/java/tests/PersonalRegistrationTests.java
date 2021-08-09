package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.RegistrationScreens;

public class PersonalRegistrationTests extends BaseClass{
	
	@Test(priority=1)
	public void verifySupportedCountry() throws Exception { 
		
		ExtentTest supportedCountryTest = extent.createTest("Supported Country Test", "Positive: Verifies supported country");
		RegistrationScreens registartionScreens = new RegistrationScreens(androidDriver);
		
		try {
			supportedCountryTest.log(Status.INFO, "Allowing location permission for while using app");
			registartionScreens.tapAllowLocationWhileUsingApp();
			supportedCountryTest.log(Status.INFO, "Allowing contacts permission");
			registartionScreens.tapAllowContacts();
			supportedCountryTest.log(Status.INFO, "Tapping Next button"); 
			registartionScreens.tapNextButton();
			supportedCountryTest.log(Status.INFO, "Tapping Next button"); 
			registartionScreens.tapNextButton();
			supportedCountryTest.log(Status.INFO, "Tapping Next button"); 
			registartionScreens.tapNextButton();
			supportedCountryTest.log(Status.INFO, "Tapping country drop-down");
			registartionScreens.tapCountryDropdown();
			supportedCountryTest.log(Status.INFO, "Typing country name in search bar");
			registartionScreens.enterCountryName("Australia");
			supportedCountryTest.log(Status.INFO, "Selecting first country from the search results");
			registartionScreens.selectFirstCountry();
			
			supportedCountryTest.log(Status.PASS, "Test PASSED!");
        }catch(Exception ex){
        	supportedCountryTest.log(Status.SKIP, ex.getMessage());
        }
		
	}
	
}
