package automation;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class Signup {
	WebDriver driver;
	@BeforeMethod
	public void verify( ) 
	{
		
		System.setProperty("webdriver.chrome.driver","C:/Users/rajesh.l/Downloads/chromedriver_win32/chromedriver.exe");
		 driver = new ChromeDriver();
		
		 driver.get("https://qualicoach.org/mwapp/index.html");
		 driver.findElement(By.cssSelector("button[type='submit']")).click();
		 driver.findElement(By.xpath("//a[normalize-space()='Sign up']")).click();
	}
		 @Test(dataProvider = "datasets")
		 public void testdata(String Fname,String Lname,String Email,String passwrd,String number,String date,String bio) throws InterruptedException 
		 {
		 driver.findElement(By.cssSelector("#myName")).sendKeys(Fname);
		 
		 driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys(Lname);
		 
		 driver.findElement(By.cssSelector("input[placeholder='Enter Email']")).sendKeys(Email);
		 
		 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passwrd);
		 
		 driver.findElement(By.cssSelector("input[placeholder='91XXXXXXXXXX']")).sendKeys(number);
		 
		 driver.findElement(By.xpath("//input[@type='date']")).sendKeys(date);
		 
		 driver.findElement(By.xpath("//textarea[@placeholder='Short Bio']")).sendKeys(bio);
		 
		 driver.findElement(By.xpath("//div[@class='col-md-2']//input[@name='gender']")).click();
		 Thread.sleep(1000);
			
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		 
		 driver.switchTo().alert().accept();
		 Thread.sleep(1000);
		
		 driver.quit(); 
		 
		
	} 

	
	@DataProvider(name = "datasets")
	public Object[][] datasets(){
		Object[][] data = {{"rajesh","raje","rajesh@gmail.com","raj@123","1234567898","05/22/2000","qwertyuiopasdfghjkl"},
				           {"ra","ra","rajes@hgmail","ra","dfghggffd","05/22/2000","rsghfas"},
				           {"rasdfghjkihugytrsdfgh","raqwertyuiiiiiiiiiiopppppppppo","rajesh@gmail.com","Raaghab243626@#$%&HRRt","@@@@@@","05/22/2000","1234567"},
				           {"","","","","","",""}};
		return data;
	}
}

