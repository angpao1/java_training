package th.co.extosoft.app.init;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class for Servlet: AppTierLog4jInit
 *
 */
 public class AppTierLog4jInit extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AppTierLog4jInit() {
		super();
	}   	
	
	private static final String CONTENT_TYPE = "text/html";
	
	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		super.init();
		
		File f = new File(System.getProperty("user.home") + File.separator
				+ getInitParameter("AppTierLog4jInitPropsFile"));
		if (!f.canRead()) {
			throw new ServletException("Init AppTier log4j Exception");
		}
		
		System.out.println("Init AppTier log4j path --> " + f.toString());
		//System.out.println("Init AppTier manage --> " + System.getProperty("weblogic.Name"));
		//String log4jProp = f.toString() + File.separator + System.getProperty("weblogic.Name") + ".AuctionWebLog4j.properties";
		String log4jProp = f.toString() + File.separator + "AppTierLog4j.properties";
		System.out.println("Init AppTier log4j file --> " + log4jProp);
		PropertyConfigurator.configureAndWatch(log4jProp);
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
	        out.println("<head><title>AppTierLog4jInit</title></head>");
	        out.println("<body bgcolor=\"#ffffff\">");
	        init();
	        System.out.println("Init AppTierLog4jInit Reload");
	        out.println("<p>The servlet has received a GET. This is the reload.</p>");
	        out.println("</body>");
	        out.println("</html>");
	        out.close();
		}
	}  	
	
    //Clean up resources
    public void destroy() {
    	
    }   	  	    
}