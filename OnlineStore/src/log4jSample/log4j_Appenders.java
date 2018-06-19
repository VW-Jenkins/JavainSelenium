package log4jSample;

//– FileAppender
//– ConsoleAppender
//– JDBCAppender 
import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
//import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.LogManager;

public class log4j_Appenders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		Logger OurLogger = LogManager.getLogger("OurLogger");
		
		// -----------------FileAppender-------------------
		
		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile("logfile.txt");
		fileAppender.setLayout(new SimpleLayout());
		
		OurLogger.addAppender(fileAppender);
		fileAppender.activateOptions();
		
		//------------------Console Appender--------------
		/*
		ConsoleAppender consoleAppender = new ConsoleAppender();
		consoleAppender.setLayout(new SimpleLayout());
		
		OurLogger.addAppender(consoleAppender);
		consoleAppender.activateOptions();
		*/
		
		//---------------JDBC appender---------------
		/*
		JDBCAppender dataBaseAppender = new JDBCAppender();
		dataBaseAppender.setURL("jdbc:sqlserver://vendorsql01.database.windows.net:1433");
		dataBaseAppender.setUser("vendorsql01@vendorsql01");
		dataBaseAppender.setPassword("vendorsql_pwd_7");
		dataBaseAppender.setDriver("");
		dataBaseAppender.setSql("INSERT INTO LOGS VALUES ('%x', now() ,'%C','%p','%m'");   
		 
        //activate the new options
	    dataBaseAppender.activateOptions();

	     //Attach the appender to the Logger
	    OurLogger.addAppender(dataBaseAppender);
		*/
		int x=0;
		
		while(x<11) {
			OurLogger.debug("This is just a log that I want to print " + x);
			x++;
		}
	}

}
