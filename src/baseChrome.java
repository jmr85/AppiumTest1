import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseChrome {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException{

        AndroidDriver<AndroidElement> driver;

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 10 API 29");//Emulator
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return driver;

    }
    
}
