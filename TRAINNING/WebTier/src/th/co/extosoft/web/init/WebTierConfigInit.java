package th.co.extosoft.web.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: WebTierConfigInit
 *
 */
 public class WebTierConfigInit extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public WebTierConfigInit() {
		super();
	}   	
	
	private static final String CONTENT_TYPE = "text/html";
	
	private static long lastReloadTime = 0L;
	private static long reloadDelayTime = 30000;
	private static String configPath = System.getProperty("user.home")+"/conf/WebTier/WebTierConfig.properties";
	private static long fileLastUpdatetime = 0L;
	private static HashMap<String, String> configs;
	
	public void init() throws ServletException {
		super.init();
		if(configs == null){
			configs = new HashMap<String, String>();
		}
		reloadDelayTime = Long.parseLong(getInitParameter("reload"));
		try {
			File configFile = new File(configPath);
			if (System.currentTimeMillis() - lastReloadTime > reloadDelayTime
					|| fileLastUpdatetime != configFile.lastModified()) {
				Properties prop = new Properties();
				prop.load(new FileInputStream(configFile));

				Object[] keyArray = prop.keySet().toArray();
				for (int i = 0; i < keyArray.length; i++) {
					String key = (String) keyArray[i];
					if (key != null) {
						String value = (String) prop.getProperty(key);
						if (value != null) {
							if(key.equals("RELOAD_DELAY_TIME")){
								reloadDelayTime = Long.parseLong(value);
							}
							configs.put(key, value);
						}
					}
				}
				lastReloadTime = System.currentTimeMillis();
				fileLastUpdatetime = configFile.lastModified();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		if("reload".equals(mode)){
	        response.setContentType(CONTENT_TYPE);
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head><title>WebTierLog4jInit</title></head>");
	        out.println("<body bgcolor=\"#ffffff\">");
	        reload();
	        System.out.println("Init WebTierLog4jInit Reload V1.0");
	        out.println("<p>The servlet has received a GET. This is the reload.</p>");
	        out.println("</body>");
	        out.println("</html>");
	        out.close();
		}
	}	
	
	public static void reload(){

		try {
			if(configs == null){
				configs = new HashMap<String, String>();
			}
			File configFile = new File(configPath);
			if (System.currentTimeMillis() - lastReloadTime > reloadDelayTime
					|| fileLastUpdatetime != configFile.lastModified()) {
				Properties prop = new Properties();
				prop.load(new FileInputStream(configFile));

				Object[] keyArray = prop.keySet().toArray();
				for (int i = 0; i < keyArray.length; i++) {
					String key = (String) keyArray[i];
					if (key != null) {
						String value = (String) prop.getProperty(key);
						if (value != null) {
							configs.put(key, value);
						}
					}
				}
				lastReloadTime = System.currentTimeMillis();
				fileLastUpdatetime = configFile.lastModified();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getConfig(String configName) {
		//reload();
		return (String) configs.get(configName);
	}	  	    
}