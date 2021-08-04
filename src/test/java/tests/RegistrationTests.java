package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.RegistrationScreens;

public class RegistrationTests extends BaseClass{
	
	@Test(priority=1)
	public void personalRegistrationTest() throws Exception {
		
		ExtentTest personalRegistrationTest = extent.createTest("Personal Registration Test", "Positive: registartion");
		RegistrationScreens registartionScreens = new RegistrationScreens(androidDriver);
		
		try {
			personalRegistrationTest.log(Status.INFO, "Allowing location permission for while using app");
			registartionScreens.tapAllowLocationWhileUsingApp();
			personalRegistrationTest.log(Status.INFO, "Allowing contacts permission");
			registartionScreens.tapAllowContacts();
			personalRegistrationTest.log(Status.INFO, "Tapping Next button");
			registartionScreens.tapNextButton();
			personalRegistrationTest.log(Status.INFO, "Tapping Next button");
			registartionScreens.tapNextButton();
			personalRegistrationTest.log(Status.INFO, "Tapping Next button");
			registartionScreens.tapNextButton();
			personalRegistrationTest.log(Status.INFO, "Tapping country drop-down");
			registartionScreens.tapCountryDropdown();
			personalRegistrationTest.log(Status.INFO, "Typing country name in search bar");
			registartionScreens.enterCountryName("Pakistan");
			personalRegistrationTest.log(Status.INFO, "Selecting first country from the search results");
			registartionScreens.selectFirstCountry();
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
		
	}
	
}
