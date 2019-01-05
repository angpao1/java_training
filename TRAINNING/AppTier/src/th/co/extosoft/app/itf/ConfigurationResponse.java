package th.co.extosoft.app.itf;

import java.io.Serializable;

public class ConfigurationResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3653593094946536663L;
	private int configId;
	private String configName;
	private String configValue;
	private String configDttm;
	private String configBy;
	
	public ConfigurationResponse(){
		
	}

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getConfigDttm() {
		return configDttm;
	}

	public void setConfigDttm(String configDttm) {
		this.configDttm = configDttm;
	}

	public String getConfigBy() {
		return configBy;
	}

	public void setConfigBy(String configBy) {
		this.configBy = configBy;
	}

	
}
