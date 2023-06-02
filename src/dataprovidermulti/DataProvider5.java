package dataprovidermulti;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider5 {

	public String[][]getdata() throws IOException{
		String path="C:\\Users\\Admin\\Documents\\orangehrm.xlsx";
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
}
