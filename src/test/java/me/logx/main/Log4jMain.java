package me.logx.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Log4jMain {
	
	public Log log = LogFactory.getLog(this.getClass());

	public static void main(String[] args) {
		Log log = new Log4jMain().log;
		
		log.debug("fs");
		log.info("fs");
	}
}
