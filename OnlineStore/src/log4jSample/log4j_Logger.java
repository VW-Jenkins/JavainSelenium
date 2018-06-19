package log4jSample;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class log4j_Logger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		Logger chance = LogManager.getLogger(log4j_Logger.class.getName());
		Logger logger1 = LogManager.getLogger("Child1");
		Logger logger1Child = LogManager.getLogger("Child1.ChildOfLogger1");
		Logger loggerGrandChild = LogManager.getLogger("Child1.ChildOfLogger1.GrandChild");
		
		 System.out.println("logger1's full name is " + logger1.getParent().getName());
	     System.out.println("logger1Child's full name is " + logger1Child.getParent().getName());
	     System.out.println("loggerGrandChild's full name is " + loggerGrandChild.getParent().getName());
	     
	     Logger Mylogger = LogManager.getLogger("DebugLogger");
	     
	     //Setting up the log level of both loggers
	      Mylogger.setLevel(Level.DEBUG);
	 
	      Mylogger.trace("This is the trace log - DEBUG");
	      Mylogger.debug("This is debug log - DEBUG");
	      Mylogger.info("This is info log - DEBUG");
	      Mylogger.warn("This is Warn log - DEBUG");
	      Mylogger.error("This is error log - DEBUG");
	      Mylogger.fatal("This is Fatal log - DEBUG");
	 
	      Mylogger.setLevel(Level.WARN);
	      Mylogger.trace("This is the trace log - WARN");
	      Mylogger.debug("This is debug log - WARN");
	      Mylogger.info("This is info log - WARN");
	      Mylogger.warn("This is Warn log - WARN");
	      Mylogger.error("This is error log - WARN");
	      Mylogger.fatal("This is Fatal log - WARN");   
	      
	      Logger LoggerParent = LogManager.getLogger("LoggerParent");
	      Logger LoggerChild = LogManager.getLogger("LoggerParent.Child");
	      //Setting up the log level of both loggers
	      LoggerParent.setLevel(Level.WARN);      
	      LoggerParent.trace("This is the trace log - PARENT");
	      LoggerParent.debug("This is debug log - PARENT");
	      LoggerParent.info("This is info log - PARENT");
	      LoggerParent.warn("This is Warn log - PARENT");
	      LoggerParent.error("This is error log - PARENT");
	      LoggerParent.fatal("This is Fatal log - PARENT");
	      LoggerChild.trace("This is the trace log - CHILD");
	      
	      LoggerChild.debug("This is debug log - CHILD");
	      LoggerChild.info("This is info log - CHILD");
	      LoggerChild.warn("This is Warn log - CHILD");
	      LoggerChild.error("This is error log - CHILD");
	      LoggerChild.fatal("This is Fatal log - CHILD");  
	      try{
		    	 // We will get a divide by zero exception her
		    	 int x = 200 / 0;
		     }
		     catch(Exception exp)
		     {
		       LoggerParent.warn("Following exception was raised", exp);	 
		     }     
	}

}
