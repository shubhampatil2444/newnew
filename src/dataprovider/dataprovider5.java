package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider5 {
  @Test(dataProvider="TestData")
  public void login(String value) {
	  System.out.println(value);
  }
  
  @DataProvider(name="TestData")
  public String []getdata(){
	  
	  String[] data=new String[3];
	  data[0]="a";
	  data[1]="b";
	  data[2]="c";
	return data;
	  
  }
}
