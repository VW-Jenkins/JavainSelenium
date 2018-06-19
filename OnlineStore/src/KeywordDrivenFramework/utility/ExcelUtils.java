package KeywordDrivenFramework.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static KeywordDrivenFramework.executionEngine.DriverScript.bResult;
import KeywordDrivenFramework.config.Constants;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	/*
	 * public static void setExcelFile(String Path, String SheetName)throws
	 * Exception{ FileInputStream ExcelFile = new FileInputStream(Path); ExcelWBook
	 * = new XSSFWorkbook(ExcelFile); ExcelWSheet = ExcelWBook.getSheet(SheetName);
	 * }
	 */
	public static void setExcelFile(String Path) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			// ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Class Utils | Method setExcelFile | Exception desc : " + e.getMessage());
			bResult = false;
		}
	}

	public static String getCellData(int RowNum, int ColNum, String SheetName) {
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Class Utils | Method getCellData | Exception desc : " + e.getMessage());
			//----------------Victor - 2018-06-19 ------------
			//bResult = false;
			return "";
		}

	}

	public static int getRowCount(String SheetName) {
		int number = 0;
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			number = ExcelWSheet.getLastRowNum()+1;

		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Class Utils | Method getRowCount | Exception desc : " + e.getMessage());
			bResult = false;
		}
		return number;
	}

	public static int getRowContains(String sTestCaseName, int colNum, String SheetName) throws Exception {
		int i = 0;
		try {
			//ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelUtils.getRowCount(SheetName);
			for (; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum, SheetName).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Class Utils | Method getRowContains | Exception desc : " + e.getMessage());
			bResult = false;
		}
		return i;
	}

	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception {
		try {
			for (int i = iTestCaseStart; i < ExcelUtils.getRowCount(SheetName); i++) {
				if (!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaesId, SheetName))) {
					int number = i;
					return number;
				}
			}
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int number = ExcelWSheet.getLastRowNum() + 1;
			return number;

		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Class Utils | Method getRowContains | Exception desc : " + e.getMessage());
			bResult = false;
			return 0;
		}
	}

	public static void setCellData(String Result, int RowNum, int ColNum, String SheetName) throws Exception {
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum,org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell=Row.createCell(ColNum);
				
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData);
			ExcelWBook.write(fileOut);
			//fileOut.flush();
			fileOut.close();
			ExcelWBook = new XSSFWorkbook(new FileInputStream(Constants.Path_TestData));

		} catch (Exception e) {
			// TODO: handle exception
			bResult = false;
		}
	}
}
