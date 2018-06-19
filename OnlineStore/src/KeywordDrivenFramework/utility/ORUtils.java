package KeywordDrivenFramework.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import KeywordDrivenFramework.config.Constants;

public class ORUtils {
	public static Properties OR;
	
	public static void ORLoadFs() throws IOException {
		String Path_OR = Constants.PATH_OR;
		FileInputStream fs = new FileInputStream(Path_OR);
		
		OR = new Properties(System.getProperties());
		OR.load(fs);
	}
}
