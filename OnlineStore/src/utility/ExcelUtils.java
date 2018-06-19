package utility;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/
public class ExcelUtils {
	/*
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook; 
	private static XSSFCell Cell;
	private static XSSFRow Row;
	*/
	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook; 
	private static HSSFCell Cell;
	private static HSSFRow Row;
	
	public static void SetExcelFile(String Path,String SheetName) throws Exception{
		try {			
			 FileInputStream ExcelFile = new FileInputStream(Path);
			 ExcelWBook = new HSSFWorkbook(ExcelFile);
			 ExcelWSheet = ExcelWBook.getSheet(SheetName);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
	}
	
	public static String getCellData(int RowNum,int ColNum)throws Exception{
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			
			return CellData;
			
		}catch(Exception e) {
			throw(e);
		}
	}
	
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception{
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if(Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			}else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData+Constant.File_TestData);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
	}
	
}
