package mTin;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;


public class SmokeTest {
  @Test
  public void f() throws MalformedURLException, InterruptedException {
	  
	  
	    DesiredCapabilities cap = new DesiredCapabilities();
	  
	    
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,360);
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.demo.mtin.mtin");
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.demo.mtin.mtin.SplashActivity");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap
		
		
		
		
		
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		//Waiting for elements to load
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement el = driver.findElementById("com.demo.mtin.mtin:id/imageView");
		wait.until(ExpectedConditions.elementToBeClickable(el));

		List<WebElement> liste = driver.findElementsById("com.demo.mtin.mtin:id/imageView");
		liste.get(0).click();
		
		String r = driver.findElementById("com.demo.mtin.mtin:id/review_naslov").getText();
		
		Assert.assertEquals(r, "Reviews");
		
		driver.closeApp();
		driver.quit();
		
	
  }
}
