package th.co.extosoft.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import th.co.extosoft.app.itf.ConfigurationRequest;
import th.co.extosoft.app.itf.ConfigurationResponse;

public class AppTierDB {

	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";//com.mysql.jdbc.Driver
	private String DB_URL = "jdbc:mysql://localhost/apptierdb";//jdbc:mysql://localhost/apptierdb

	// Database credentials
	private String USER = "root";//root
	private String PASS = "1234";//1234
	
	public List<ConfigurationResponse> queryLoadConfig(ConfigurationRequest configReqs) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<ConfigurationResponse> configRespList = new ArrayList<ConfigurationResponse>();
		ConfigurationResponse configResp = null;
//		int i = 1;
		try {
			// STEP 2: Register JDBC driver
			System.out.println(JDBC_DRIVER);
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println(DB_URL);
			System.out.println(USER);
			System.out.println(PASS);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// STEP 4: Execute a query
			StringBuffer sql = new StringBuffer("SELECT  CONFIG_ID, CONFIG_NAME, CONFIG_VALUE, CONFIG_DTTM, CONFIG_BY FROM APPTIER_CONFIG WHERE 1 = 1 ");
			
			System.out.println("QueryLoadConfig sql --> " + sql.toString());
			pstmt = conn.prepareStatement(sql.toString());
			//pstmt.setInt(i++, request.getConfigId());
			
			ResultSet rs = pstmt.executeQuery();
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				configResp = new ConfigurationResponse();
				configResp.setConfigId(rs.getInt("CONFIG_ID"));
				configResp.setConfigName(rs.getString("CONFIG_NAME"));
				configResp.setConfigValue(rs.getString("CONFIG_VALUE"));
				configResp.setConfigDttm(rs.getString("CONFIG_DTTM"));
				configResp.setConfigBy(rs.getString("CONFIG_BY"));
				configRespList.add(configResp);
			}
			// STEP 6: Clean-up environment
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
			}// nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return configRespList;
	}
	
	
	public List<ConfigurationResponse> getConfig(ConfigurationRequest configReqs) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<ConfigurationResponse> configRespList = new ArrayList<ConfigurationResponse>();
		ConfigurationResponse configResp = null;
		int i = 1;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			StringBuffer sql = new StringBuffer("SELECT CONFIG_ID, CONFIG_NAME, CONFIG_VALUE, CONFIG_DTTM, CONFIG_BY FROM APPTIER_CONFIG WHERE 1 = 1 ");
			
			if(configReqs != null && configReqs.getConfigId() > 0){
				sql.append("AND CONFIG_ID = ? ");
			}
			
			if(configReqs != null && configReqs.getConfigName() != null && !"".equals(configReqs.getConfigName())){
				sql.append("AND CONFIG_NAME LIKE ? ");
			}
			
			if(configReqs != null && configReqs.getConfigValue() != null && !"".equals(configReqs.getConfigValue())){
				sql.append("AND CONFIG_VALUE LIKE ? ");
			}
			
			System.out.println("GetConfig sql --> " + sql.toString());
			pstmt = conn.prepareStatement(sql.toString());
			
			if(configReqs != null && configReqs.getConfigId() > 0 ){
				pstmt.setInt(i++, configReqs.getConfigId());
			}
			
			if(configReqs != null && configReqs.getConfigName() != null && !"".equals(configReqs.getConfigName())){
				pstmt.setString(i++, "%" + configReqs.getConfigName() + "%");
			}
			
			if(configReqs != null && configReqs.getConfigValue() != null && !"".equals(configReqs.getConfigValue())){
				pstmt.setString(i++, "%" + configReqs.getConfigValue() + "%");
			}

			ResultSet rs = pstmt.executeQuery();
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				configResp = new ConfigurationResponse();
				configResp.setConfigId(rs.getInt("CONFIG_ID"));
				configResp.setConfigName(rs.getString("CONFIG_NAME"));
				configResp.setConfigValue(rs.getString("CONFIG_VALUE"));
				configResp.setConfigDttm(rs.getString("CONFIG_DTTM"));
				configResp.setConfigBy(rs.getString("CONFIG_BY"));
				configRespList.add(configResp);
			}
			// STEP 6: Clean-up environment
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
			}// nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return configRespList;
	}
	
	public boolean addConfig(ConfigurationRequest configReqs) {
		boolean completed = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 1;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			StringBuffer sql = new StringBuffer("INSERT INTO APPTIER_CONFIG(CONFIG_NAME, CONFIG_VALUE, CONFIG_DTTM, CONFIG_BY) VALUES(?,?,?,?)");
			
			System.out.println("AddConfig sql --> " + sql.toString());
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(i++, configReqs.getConfigName());
			pstmt.setString(i++, configReqs.getConfigValue());
			pstmt.setTimestamp(i++, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(i++, "admin");
			
			int result = pstmt.executeUpdate();
			// STEP 5: Extract data from result set
			if(result > 0){
				completed = true;
			}else{
				completed = false;
			}
			
			// STEP 6: Clean-up environment
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
			}// nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return completed;
	}
	
	public boolean updateConfig(ConfigurationRequest configReqs) {
		boolean completed = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int i = 1;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			StringBuffer sql = new StringBuffer("UPDATE APPTIER_CONFIG SET CONFIG_NAME = ?, CONFIG_VALUE = ?, CONFIG_DTTM = ?, CONFIG_BY = ? WHERE 1 = 1 ");
			if(configReqs != null && configReqs.getConfigId() > 0){
				sql.append(" AND CONFIG_ID = ? ");
			}
			
			System.out.println("UpdateConfig sql --> " + sql.toString());
			pstmt = conn.prepareStatement(sql.toString());
			if(configReqs != null && !"".equals(configReqs.getConfigName())){
				pstmt.setString(i++, configReqs.getConfigName());
			}
			
			if(configReqs != null && !"".equals(configReqs.getConfigValue())){
				pstmt.setString(i++, configReqs.getConfigValue());
			}
			
			pstmt.setTimestamp(i++, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(i++, "admin");
			
			if(configReqs != null && configReqs.getConfigId() > 0){
				pstmt.setInt(i++, configReqs.getConfigId());
			}
			
			int result = pstmt.executeUpdate();
			// STEP 5: Extract data from result set
			if(result > 0){
				completed = true;
			}else{
				completed = false;
			}
			// STEP 6: Clean-up environment

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
			}// nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return completed;
	}
	
	public boolean deleteConfig(ConfigurationRequest configReqs) {
		boolean completed = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int i = 1;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			StringBuffer sql = new StringBuffer("DELETE FROM APPTIER_CONFIG WHERE 1 = 1 ");
			if(configReqs != null && configReqs.getConfigId() > 0){
				sql.append(" AND CONFIG_ID = ? ");
			}
			
			if(configReqs != null && configReqs.getConfigName() != null && !"".equals(configReqs.getConfigName())){
				sql.append(" AND CONFIG_NAME LIKE ? ");
			}
			
			pstmt = conn.prepareStatement(sql.toString());
			if(configReqs != null && configReqs.getConfigId() > 0){
				pstmt.setInt(i++, configReqs.getConfigId());
			}
			
			if(configReqs != null && configReqs.getConfigName() != null && !"".equals(configReqs.getConfigName())){
				pstmt.setString(i++, "%" + configReqs.getConfigName() + "%");
			}
			
			int result = pstmt.executeUpdate();
			// STEP 5: Extract data from result set
			if(result > 0){
				completed = true;
			}else{
				completed = false;
			}
			// STEP 6: Clean-up environment

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException ex) {
			}// nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return completed;
	}
}
