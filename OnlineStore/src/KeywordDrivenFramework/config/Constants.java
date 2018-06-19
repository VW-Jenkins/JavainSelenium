package KeywordDrivenFramework.config;

public class Constants {

	// Variable of set driver
	public static final String Driver_FFName = "webdriver.gecko.driver";
	public static final String Driver_Path = "C:\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe";

	// This is the list of System Variables
	public static final String URL = "http://www.store.demoqa.com";
	public static final String Path_TestData = "D:\\ToolsQA\\OnlineStore\\src\\KeywordDrivenFramework\\dataEngine\\DataEngine.xlsx";
	public static final String File_TestData = "DataEngine.xlsx";
	// OR path
	public static final String PATH_OR = "D:\\ToolsQA\\OnlineStore\\src\\KeywordDrivenFramework\\config\\OR.txt";

	// List of Data Sheet Column Numbers
	public static final int Col_TestCaesId = 0;
	public static final int Col_TestScerarioID = 1;
	public static final int Col_PageObject = 3;
	public static final int Col_ActionKeyword = 4;
	public static final int Col_RunMode = 2;
	public static final int Col_Result = 3;
	public static final int Col_DataSet = 5;
	public static final int Col_TestStepsResult = 6;

	// List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "Test Steps";
	public static final String Sheet_TestCases = "Test Cases";

	// List of Test Data
	public static final String UserName = "TestingLA4v@outlook.com";
	public static final String Password = "9Esu%YxUmZuP1lBA";

	// Results variable
	public static final String KEYWORD_FAIL = "FAIL";
	public static final String KEYWORD_PASS = "PASS";

}
