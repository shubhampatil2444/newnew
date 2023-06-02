package dataprovider;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class DataProvider13 {
	WebDriver driver;
	
	@BeforeClass
	public void initilation() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver112\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
  @Test(dataProvider = "TestData")
  public void login(String value) {
	  System.out.println(value);
  }

  @DataProvider(name="TestData")
  public String[] getdata() throws IOException{
	  String path="C:\\Users\\Admin\\Documents\\spsheet.xlsx";
	  File file=new File(path);
	  FileInputStream fs=new FileInputStream(file);
	  XSSFWorkbook wb=new XSSFWorkbook(fs);
	  XSSFSheet sheet=wb.getSheetAt(0);
	  
	  int row=sheet.getPhysicalNumberOfRows();
	  System.out.println(row);
	  String []data=new String[row];
	  
	  for(int i=0;i<row;i++) {
		  String data1=sheet.getRow(i).getCell(0).getStringCellValue();
		  data[i]=data1;
	  }
	return data;
  
  }
}
