package ExcelUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static void writeExcelData(String sheetName, int rownum, int colnum, String data) throws IOException {
		//Opening the excel file
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Excel\\Book1.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(file); 
		//Creating the sheet
		if(book.getSheetIndex(sheetName)==-1) {
		book.createSheet(sheetName);              
		}
		XSSFSheet sheet=book.getSheet(sheetName);
		if(sheet.getRow(rownum)==null)
		sheet.createRow(rownum);
		XSSFRow row =sheet.getRow(rownum);   
		// Creating cell
		XSSFCell cell=row.createCell(colnum); 
		//Setting the data in the column
		cell.setCellValue(data); 
		// Writing the data by fileOutput
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\Book1.xlsx");
		book.write(fo);
		book.close();
		file.close();
		fo.close();
}


public static void writeExcelData1(String sheetName, int rownum, int colnum, int c) throws IOException {
	//Opening the excel file
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Excel\\Book1.xlsx");
	XSSFWorkbook book=new XSSFWorkbook(file); 
	//Creating the sheet
	if(book.getSheetIndex(sheetName)==-1) {
	book.createSheet(sheetName);              
	}
	XSSFSheet sheet=book.getSheet(sheetName);
	if(sheet.getRow(rownum)==null)
	sheet.createRow(rownum);
	XSSFRow row =sheet.getRow(rownum);   
	// Creating cell
	XSSFCell cell=row.createCell(colnum); 
	//Setting the data in the column
	cell.setCellValue(c); 
	// Writing the data by fileOutput
	FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\Book1.xlsx");
	book.write(fo);
	book.close();
	file.close();
	fo.close();
}
}
