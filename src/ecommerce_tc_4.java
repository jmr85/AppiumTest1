import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_4 extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		//if it doesn't work try this line
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));    
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();//$120.0 
		amount1 = amount1.substring(1);//120.0
		double amount1value = Double.parseDouble(amount1);
		String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		amount2 = amount2.substring(1);
		//160.97
		double amount2value = Double.parseDouble(amount2);
		double sumOfProducts = amount1value + amount2value;
		System.out.println("sum of products: " + sumOfProducts);
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		total = total.substring(1);
		double totalvalue = Double.parseDouble(total);
		System.out.println("Total value of products: " + totalvalue);
		Assert.assertEquals(sumOfProducts, totalvalue);
	}

}
