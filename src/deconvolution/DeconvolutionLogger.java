package deconvolution;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

	public class DeconvolutionLogger {
	  static private FileHandler outfilePath;
	  protected final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	  static public void setup(String outputDir) throws IOException {
	    // get the global logger to configure it
	    log.setLevel(Level.INFO);
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    setOutfilePath(new FileHandler(outputDir+"/DeconvolutionLog_"+dateFormat.format(date)+".txt"));
	    CustomRecordFormatter customFormatter = new CustomRecordFormatter();
	    ConsoleHandler consoleHandler = new ConsoleHandler();
	    consoleHandler.setFormatter(customFormatter);
	    outfilePath.setFormatter(customFormatter);
	    log.setUseParentHandlers(false);
	    log.addHandler(consoleHandler);
	    log.addHandler(outfilePath);
	    
	  }
public static FileHandler getOutfilePath() {
	return outfilePath;
}
public static void setOutfilePath(FileHandler outfilePath) {
	DeconvolutionLogger.outfilePath = outfilePath;
}
}
 

