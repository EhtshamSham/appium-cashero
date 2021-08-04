package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AbstractPageObject {

	protected final AppiumDriver androidDriver;
	WebDriverWait wait;

    public AbstractPageObject(AppiumDriver driver){
        this.androidDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }
    
}
