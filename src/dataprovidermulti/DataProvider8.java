package dataprovidermulti;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider8 {
	WebDriver driver;
	
	@BeforeClass
	public void initilation() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver112\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
  @Test(dataProvider="orange")
  public void login(String username,String passward) {
	  System.out.println(username);
	  System.out.println(passward);
	  
	  driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(passward);
	  driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
  }
  @DataProvider(name="orange")
  public String[][]hrm() throws IOException{
	  String[][]data=DataProvider4.getdata();
	  try {
		  data=DataProvider4.getdata();
	  }
	  catch(IOException e) {
		  e.printStackTrace();
	  }
	return data;
	  
  }
}
