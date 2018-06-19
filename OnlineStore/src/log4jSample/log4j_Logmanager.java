package log4jSample;


//– Create instances of Logger objects.
//– Store references of all the created logger objects.
//– Allow reuse of same logger object in different parts of the code.

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Enumeration;

import org.apache.log4j.BasicConfigurator;

public class log4j_Logmanager {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger1 = LogManager.getLogger("Logger1");
		Logger logger2 = LogManager.getLogger("Logger2");
		Logger logger3 = LogManager.getLogger("Logger3");
		BasicConfigurator.configure();
		
		logger1.info("This is logger 1");
		logger2.info("This is logger 2");
		logger3.info("This is logger 3");
		
		//Logger logger1_2 = LogManager.getLogger("Logger1");
		Logger logger1_3 = LogManager.getLogger("Logger1");
		
		if(logger1_3.equals(logger1)) {
			logger1_3.info("Both objects are same");
		}else {
			logger1_3.info("Logger1 and logger1_3 are different objects");
		}
		
		Logger rootLogger = LogManager.getRootLogger();
		Logger rootOf1 = Logger.getRootLogger();
		
		if(rootOf1.equals(rootLogger)) {
			rootOf1.info("Both rootLogger and rootOf1 are same objects");	
			rootOf1.info("The Name of the root logger is " + rootLogger.getName());
		}else {
			rootOf1.info("Both rootLogger and rootOf1 are different objects");
		}
		
		Enumeration loggers = LogManager.getCurrentLoggers();
		while(loggers.hasMoreElements()) {
			logger3.info("logger name is " + loggers.nextElement().getClass());
		}
		
		
	}

}
