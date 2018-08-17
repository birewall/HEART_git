package Model;

import org.apache.log4j.Logger;

import Common.Main;

public class MLogger extends AbsMetaModel{
	private static Logger logger = Logger.getLogger(Main.class);
	
	public void info(Object message) {
		this.logger.info(message);
	}
	
	public void error(Object message) {
		this.logger.error(message);
	}
	
	public void debug(Object message) {
		this.logger.debug(message);
	}
	
	public void fatal(Object message) {
		this.logger.fatal(message);
	}
}
