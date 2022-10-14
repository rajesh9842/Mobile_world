package automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;


public class Login {
	WebDriver driver;
	@Test(dataProvider = "data-set")
	public void verifylogin(String username,String password) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/rajesh.l/Downloads/chromedriver_win32/chromedriver.exe");
		 driver = new ChromeDriver();
		
		 driver.get("https://qualicoach.org/mwapp/index.html");
		 
		 driver.findElement(By.cssSelector("button[type='submit']")).click();
		 
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		 
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		 
		 driver.findElement(By.cssSelector("label[for='remember-me']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[@type='submit']")).click();
		 
		 int L= username.length();
		 int Length=password.length();
	       if ((L < 3) || (L > 20)) {
	    	   AssertJUnit.assertEquals("https://qualicoach.org/mwapp/sign.html", driver.getCurrentUrl());
	        } else {
	            AssertJUnit.assertEquals("https://qualicoach.org/mwapp/index.html", driver.getCurrentUrl());
	        }
	       
	       if ((Length < 3) || (Length > 10)) {
	    	   AssertJUnit.assertEquals("https://qualicoach.org/mwapp/sign.html", driver.getCurrentUrl());
	        } else {
	            AssertJUnit.assertEquals("https://qualicoach.org/mwapp/index.html", driver.getCurrentUrl());
	        }
	    	   
	       
	       Thread.sleep(1000);
		 	
		 driver.close();
		 
		
		 
		
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



                                                               

