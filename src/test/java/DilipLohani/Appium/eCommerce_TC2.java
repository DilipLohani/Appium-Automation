package DilipLohani.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_TC2 extends BaseTest
{
	
	
	@Test
	public void FillForm() 
	{
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Girl");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Brazil\")")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String ToastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getText();
		Assert.assertEquals(ToastMessage,"Please enter your name");
		
	}

}
