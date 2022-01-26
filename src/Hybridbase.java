import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Hybridbase {

	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
		// TODO Auto-generated method stub
		//chrome - url
		//App .apk, device, 4723
		//commands
		//AndroidDriver
		
		File appDir = new File("src");
		File app = new File(appDir, "ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		if(device.equals("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 10 API 29");//Emulator
		}else if(device.equals("real")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");//Real device
		}
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		// UI Automator -> Android apps
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		return driver;
	
	}

}
