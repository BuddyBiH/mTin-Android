package mTin;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class SmokeTest {
  @Test
  public void f() throws MalformedURLException, InterruptedException {
	  
	  File appDir = new File("src/test/resources");
	  File app = new File (appDir,"app-debug.apk");
	  
	  DesiredCapabilities cap = new DesiredCapabilities();
	  
	    cap.setCapability(MobileCapabilityType.APP, app);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,360);
		
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement el = driver.findElementById("com.demo.mtin.mtin:id/imageView");
		wait.until(ExpectedConditions.elementToBeClickable(el));

		driver.findElementByClassName("android.widget.ImageView").click();
		
		driver.findElementById("com.demo.mtin.mtin:id/title").click();
		
		TouchAction touch = new TouchAction(driver);
			
		touch.tap(245, 269).perform();
	  
		TimeUnit.SECONDS.sleep(3);
  }
}
