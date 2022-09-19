package automation;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class orders {

		WebDriver driver;
		@BeforeMethod
		public void verifyorder( ) throws InterruptedException 
		{
			
			System.setProperty("webdriver.chrome.driver","C:/Users/rajesh.l/Downloads/chromedriver_win32/chromedriver.exe");
			 driver = new ChromeDriver();
			
			 driver.get("https://mobileworld.banyanpro.com/");
			 
			 driver.findElement(By.xpath("//body/nav[@id='navbar']/div[@id='navbarSupportedContent']/ul[@class='navbar-nav mx-auto']/li[4]/a[1]")).click();
            driver.findElement(By.cssSelector(".dropdown-item[href='order.html']")).click();
		}
		@Test(dataProvider = "data")
		public void adddata(String Firstname,String Lastname,String email,String password,String Mnumber,String add1,String add2,String city,String zip,String count,String times) throws InterruptedException
		{
			
			
            Set windows = driver.getWindowHandles();
            Iterator<?> it = windows.iterator();
            String parentId = (String) it.next();
            String childId = (String) it.next();
            driver.switchTo().window(childId);
           // driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[@id='inputFirstName']")).sendKeys(Firstname);
            Thread.sleep(1000);
           
            driver.findElement(By.xpath("//body/div[@class='container']/div[1]/div[2]/form[1]/div[1]/div[2]/input")).sendKeys(Lastname);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(email);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#inputPassword")).sendKeys(password);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//label[@for='flexRadioDefault1']")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[placeholder='00000000000']")).sendKeys(Mnumber);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id=' address1']")).sendKeys(add1);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#address2")).sendKeys(add2);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#inputCity")).sendKeys(city);
            Thread.sleep(1000);
            WebElement State=driver.findElement(By.id("inputState"));
            Select S=new Select(State);
            S.selectByIndex(2);
            Thread.sleep(1000);
            driver.findElement(By.id("inputZip")).sendKeys(zip);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@rel='lenovo']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@rel='samsung']")).click();
            Thread.sleep(1000);
             driver.findElement(By.xpath("//div[@class='lenovo']//option[1]")).click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@placeholder='no of mobiles']")).sendKeys(count);
             Thread.sleep(1000);
             WebElement yes = driver.findElement(By.id("bought"));
             Thread.sleep(1000);
             Select R= new Select( yes );
             R.selectByIndex(0);
             driver.findElement(By.cssSelector("#time")).sendKeys(times);
             Thread.sleep(1000);
             List a=driver.findElements(By.id("gridCheck1"));
             ((WebElement) a.get(0)).click();
             ((WebElement) a.get(1)).click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//button[normalize-space()='Order Now']")).click();
             
             Thread.sleep(1000);
             
          
             driver.quit();
             
             }
		@DataProvider(name = "data")
		public Object[][] data(){
			Object[][] ob = {{"rajesh","raje","rajesh@gmail.com","raj@123","1234567898","48 eastufq","iwvgiwbibh","saleeennn","1234567898","2","4"},
					{"ra","ra","rajesg@gmail","r4","12345","3d","7u","sa","12345","1","3"},
					{"qwertyuioplkjhgfdsazxcv","mnbvcxzlkjhgfdsapoiuyt","QWERTYUIOIG@GMAIL","rffgh@#$%^HTR","123456789098765","yugjuiodsjkdshi673268wfejdsgvg","67ey68gtjgtjgyujdfyddddguy8yyug87y","mnbvcxzasdfghjklpoiuytrewq","987654321234","1","4"},
					{"@#$%","*&%$#","Raheshgmail.com","123456","qwert","@wsaed","#5east","!@#&*","tthgfbhjh","a","r"},
					{"12344","346767","raj@g.com","wertyyttgh","1234567890","45qwer","87gyggy","123456","@#$%","$","$"},
				    {"","","","","","","","","","",""}};
return ob;
}
}
