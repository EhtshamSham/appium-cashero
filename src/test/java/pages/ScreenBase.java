package pages;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScreenBase {

	protected final AppiumDriver androidDriver;
	WebDriverWait wait;

    public ScreenBase(AppiumDriver driver){
        this.androidDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }
    
    public void tap(MobileElement element) throws Exception{
    	try {
        	wait.until(ExpectedConditions.visibilityOf(element));
        	element.click();
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
    }
    
    public void write(MobileElement element, String text) throws Exception{
    	try {
        	wait.until(ExpectedConditions.visibilityOf(element));
        	element.click();
        	element.sendKeys(text);
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
    }
    
    public boolean checkVisibility(MobileElement element) throws Exception{
    	try {
    		boolean displayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        	return displayed;
        }catch(Exception ex){
            throw new Exception("Error : " + ex.getMessage());
        }
    }
    
    public void swipeScreen(Direction dir) {

    	final int PRESS_TIME = 200; // ms
        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = androidDriver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        try {
            new TouchAction(androidDriver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
    
}
