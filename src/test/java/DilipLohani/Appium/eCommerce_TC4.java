package DilipLohani.Appium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_TC4 extends BaseTest
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
		
		driver.findElements(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).get(0).click();

		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
	    	List<WebElement> Price = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	    	
	    	int count = Price.size();
	    	Double sum = (double) 0;
	    	for(int i=0; i<count; i++)
	    	{
	    	String Amount =	Price.get(i).getText();
	    	Double FinalPrice = Double.parseDouble(Amount.substring(1)); 
	    	sum = sum+FinalPrice;
	    		
	    	}
	
	    	String displayPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	    	Double displayFinalPrice = Double.parseDouble(displayPrice.substring(1)); 
	    	
	    	Assert.assertEquals(sum,displayFinalPrice);
	    	
	    	WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	    	longPress(ele);
	    	
	    	String alertTitle = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
	    	
	    	Assert.assertEquals(alertTitle, "Terms Of Conditions");
	    	
	    	driver.findElement(By.id("android:id/button1")).click();
	    	driver.findElement(By.id("android.widget.CheckBox")).click();
	    	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
	}
		
	
}

