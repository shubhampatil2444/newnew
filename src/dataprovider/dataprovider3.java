package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider3 {
  @Test(dataProvider="TestData")
  public void login(String value) {
	  System.out.println(value);
  }
  
  @DataProvider(name="TestData")
  public String[] getdata(){
	  
	  String[] da=new String[3];
	  da[0]="1";
	  da[1]="2";
	  da[2]="3";
	return da;
	  
  }
  
}
