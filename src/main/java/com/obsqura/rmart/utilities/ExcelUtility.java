package com.obsqura.rmart.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.obsqura.rmart.constant.Constant;

public class ExcelUtility {
	static FileInputStream fi;
	static XSSFWorkbook wb;
	static XSSFSheet sh;

public static String readString(int i,int j,String sheet) throws Exception{
	fi=new FileInputStream(Constant.EXCELPATH);
	wb=new XSSFWorkbook(fi);
	sh=wb.getSheet(sheet);
	XSSFRow row=sh.getRow(i);
	XSSFCell cell=row.getCell(j);
	 return cell.getStringCellValue();
}


public static String readNumber(int i,int j,String sheet) throws Exception{
	fi=new FileInputStream(Constant.EXCELPATH);
	wb=new XSSFWorkbook(fi);
	sh=wb.getSheet(sheet);
	XSSFRow row=sh.getRow(i);
	XSSFCell cell=row.getCell(j);
	
	int y= (int) cell.getNumericCellValue();
	return String.valueOf(y);
}


}
