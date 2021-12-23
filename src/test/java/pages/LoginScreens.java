package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginScreens extends ScreenBase{

	//PERMISSIONS POP-UP ELEMENTS
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button") private MobileElement allowLocationButton;
		
	//ONBOARDING SCREENS ELEMENTS
	@FindBy(className = "android.widget.Button") private MobileElement locationEnableButton;
	@FindBy(xpath = "//android.widget.Button[@content-desc='Next']") private MobileElement nextButton;
		
	//MOBILE NUMBER SCREEN ELEMENTS
	@FindBy(xpath = "//android.view.View[@index='0']") private MobileElement countryDropdown;
		
	//COUNTRY SELECTION SCREEN ELEMENTS
	@FindBy(xpath = "//android.widget.EditText[@index='1']") private MobileElement countrySearchBar;
		
	//OTP SCREEN ELEMENTS
	@FindBy(xpath = "//android.view.View[@content-desc='6-digit code']") private MobileElement otpScreenTitle;
	
	
    public LoginScreens(AppiumDriver driver){
        super(driver);
    }

    public void allowLocationPermission() throws Exception {
		tap(locationEnableButton);
		tap(allowLocationButton);
    }
	
	public void visitOnboardingScreens() throws Exception {
		tap(nextButton);
		tap(nextButton);
		tap(nextButton);
    }
	
	public void selectCountry(String countryName) throws Exception {
		System.out.println("Hello");
		tap(countryDropdown);
    }
	
	public void enterPhoneNumber(String phoneNumber) throws Exception {
		//write(numberField, phoneNumber);
    }
	
	public boolean isOTPScreenTitleVisible() throws Exception {
		return checkVisibility(otpScreenTitle);
    }
	
}
