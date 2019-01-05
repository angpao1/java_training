package th.co.extosoft.web.util;

import java.text.DecimalFormat;

public class WebTierConstant {
	
	// Configuration file for application setting
	public static final String APP_CONFIGURATION_FILE = getUserHome()+"/conf/AppTier/AppTierConfig.properties";
	// Configuration file for log setting
	public static final String LOG_CONFIGURATION_FILE = getUserHome()+"/conf/AppTier/AppTierLog4j.properties";
	
	//Logger - SOAP Message -- Debug
	public static final String LOGGER_NAME_APPTIER_DEBUG = "AppTierDebug";
	public static final String LOGGER_NAME_APPTIER_TRNS = "AppTierTrns";
	// Logger - SOAP Message -- Debug
	public static DecimalFormat creditFormat = new DecimalFormat("#,##0");
    // Log Message Type
    public static String INPUT = "INPUT";
    public static String OUTPUT = "OUTPUT";
    public static String PROC = "PROC";
    
	public static final String PATH_CONFIG_DIR = getUserHome() + "/conf/AppTier";
	public static final String PATH_DATA_DIR = getUserHome() + "/data/AppTier";
	public static final String PATH_LOG_DIR = getUserHome() + "/log/AppTier";
	public static final String PATH_TEMP_DATA_DIR = PATH_DATA_DIR + "/tmp";
	public static final String DATETIME_PATTERN_AWSEC_EXPORT = "yyyyMMddHHmmss";
	
    public static String format(int number){
    	return creditFormat.format(number);
    }
    
	public static String getUserHome() {
		return System.getProperty("user.home");
	}
	
    public static String replace(String source, String pattern, String replace) {
		if (source != null) {
			final int len = pattern.length();
			StringBuffer sb = new StringBuffer();
			int found = -1;
			int start = 0;

			while ((found = source.indexOf(pattern, start)) != -1) {
				sb.append(source.substring(start, found));
				sb.append(replace);
				start = found + len;
			}

			sb.append(source.substring(start));

			return sb.toString();
		} else
			return "";
	}
	
}
