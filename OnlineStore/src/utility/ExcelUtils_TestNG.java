package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils_TestNG {
	//private static XSSFSheet ExcelWSheet;
	private static HSSFSheet ExcelWSheet;
	//private static XSSFWorkbook ExcelWBook;
	private static HSSFWorkbook ExcelWBook;
	//private static XSSFCell Cell;
	private static HSSFCell Cell;
	//private static XSSFRow Row;
	
	public static Object [][] getTableArray(String FilePath,String SheetName)throws Exception{
		String[][] tabArray = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int startRow=1;
			int startCol=1;
			int totalRows = ExcelWSheet.getLastRowNum();
			int totalCols = 2;
			int ci,cj;
			tabArray = new String[totalRows][totalRows];
			
			ci=0;
			for(int i=startRow;i<=totalRows;i++,ci++) {
				cj=0;
				for(int j=startCol;j<=totalCols;j++,cj++) {
					tabArray[ci][cj] = getCellData(i,j);
					System.out.println(tabArray[ci][cj]);
				}
			}
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Could not read the Excel Sheet");
			e.printStackTrace();
		}
		return (tabArray);	
	}
	
	public static String getCellData(int RowNum, int ColNum)throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			
			//getCelltype is deprecated!
			int dataType = Cell.getCellType();
			
			if(/*Cell.getCellTypeEnum()==CellType.BLANK*/ dataType==3) {
				return "";
			}else {
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw(e);
		}
	}
	// According class name execute the TCs
	//-----------------------------------Jun2018 - 06 - 05---------------------------
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		 
		   try {

				// Open the Excel file

				FileInputStream ExcelFile = new FileInputStream(Path);

				// Access the required test data sheet

				ExcelWBook = new HSSFWorkbook(ExcelFile);

				ExcelWSheet = ExcelWBook.getSheet(SheetName);

				} catch (Exception e){

					throw (e);

				}

		}
	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow)    throws Exception
	 
	{   

	   String[][] tabArray = null;

	   try{

		   FileInputStream ExcelFile = new FileInputStream(FilePath);

		   // Access the required test data sheet

		   ExcelWBook = new HSSFWorkbook(ExcelFile);

		   ExcelWSheet = ExcelWBook.getSheet(SheetName);

		   int startCol = 1;

		   int ci=0,cj=0;

		   int totalRows = 1;

		   int totalCols = 2;

		   tabArray=new String[totalRows][totalCols];

			   for (int j=startCol;j<=totalCols;j++, cj++)

			   {

				   tabArray[ci][cj]=getCellData(iTestCaseRow,j);

				   System.out.println(tabArray[ci][cj]);

			   }

		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return(tabArray);

	}
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		 
		String value = sTestCase;

		try{

			int posi = value.indexOf("@");

			value = value.substring(0, posi);

			posi = value.lastIndexOf(".");	

			value = value.substring(posi + 1);

			return value;

				}catch (Exception e){

			throw (e);

					}

		}
	
	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
		 
		int i;

		try {

			int rowCount = ExcelUtils_TestNG.getRowUsed();

			for ( i=0 ; i<rowCount; i++){

				if  (ExcelUtils_TestNG.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){

					break;

				}

			}

			return i;

				}catch (Exception e){

			throw(e);

			}

		}
	
	public static int getRowUsed() throws Exception {
		 
		try{

			int RowCount = ExcelWSheet.getLastRowNum();

			return RowCount;

		}catch (Exception e){

			System.out.println(e.getMessage());

			throw (e);

		}

	}
}
