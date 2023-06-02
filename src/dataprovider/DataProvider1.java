package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
  @Test(dataProvider="TestData")
  public void login(String value) {
	  System.out.println(value);
  }
  
  @DataProvider(name="TestData")
  public String[] getData() {
	  
	  String[] data=new String[3] ;
	  data[0]="Frist value";
	  data[1]="second value";
	  data[2]="Third value";
	  return data;
	  
  }
}
