package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Login {
	WebDriver driver;
	@Test(dataProvider = "data-set")
	public void verifylogin(String username,String password) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/rajesh.l/Downloads/chromedriver_win32/chromedriver.exe");
		 driver = new ChromeDriver();
		
		 driver.get("https://mobileworld.banyanpro.com/");
		 driver.findElement(By.cssSelector("button[type='submit']")).click();
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		 driver.findElement(By.cssSelector("label[for='remember-me']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[@type='submit']")).click();
		 Thread.sleep(1000);
		 int L= username.length();
	       if ((L < 3) || (L > 20)) {
	            Assert.assertEquals("https://mobileworld.banyanpro.com/sign.html", driver.getCurrentUrl());
	        } else {
	            Assert.assertEquals("https://mobileworld.banyanpro.com/index.html", driver.getCurrentUrl());
	        }
		 
		 	
		 driver.quit();
		
		 
		
	}
	@DataProvider(name = "data-set")
	public Object[][] dataset(){
		Object[][] obj = { 
				{"Rajesh","Rajesh@123"},
				{"ra","r1"},
				{"ghafgshdsghjhadgshbdagsdsgvgcvcvc","Rghasjaj65863416837863286"},
				{" ",""}};
		
		return obj;
		 
	}

}



                                                               

