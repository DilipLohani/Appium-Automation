package DilipLohani.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_TC3 extends BaseTest
{
	
	
	@Test
	public void FillForm() throws InterruptedException 
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Girl");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Brazil\")")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();  
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		int ProductCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0;i< ProductCount;i++)
		{
		String ProductName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(ProductName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}

		 driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
	}
		
	
}

