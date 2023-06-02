package dataprovidermulti;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3 {
	WebDriver driver;
	
	@BeforeClass
	public void initilation() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver112\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
  @Test(dataProvider="TestData")
  public void login(String username,String passward) {
	  System.out.println(username);
	  System.out.println(passward);
  }
  @DataProvider(name="TestData")
  public String [][]getdata() throws IOException{
	  String path="C:\\Users\\Admin\\Documents\\multidata.xlsx";
	  File file=new File(path);
	  FileInputStream fs=new FileInputStream(file);
	  XSSFWorkbook wb=new XSSFWorkbook(fs);
	  XSSFSheet sheet=wb.getSheetAt(0);
	  
	  int row=sheet.getLastRowNum();
	  int col=sheet.getRow(0).getLastCellNum();
	  System.out.println(row);
	  System.out.println(col);
	  
	  String [][]data=new String[row][col];
	  
	  for(int i=0;i<row;i++) {
		  for(int j=0;j<col;j++) {
			  
			  data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
		  }
	  }
	return data;
	  
  }
  @AfterClass
  public void Teardown() {
	  driver.close();
  }
}
