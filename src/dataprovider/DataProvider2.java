package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {
	
  @Test(dataProvider="TestData")
  public void login(String value) {
	  System.out.println(value);
  }
  
  @DataProvider(name="TestData")
  public String[]getdata() {
	  
	  String []data=new String[3];
	  data[0]="Frist value";
	  data[1]="second value";
	  data[2]="third value";
	return data;
}
  
}
