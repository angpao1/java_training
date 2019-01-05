package th.co.extosoft.app.itf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppTierResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5906117880142373315L;
	private String status;
	private String errorMessage;
	private List<ConfigurationResponse> configRespList;
	
	public AppTierResponse(){
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<ConfigurationResponse> getConfigRespList() {
		return configRespList;
	}

	public void setConfigRespList(List<ConfigurationResponse> configRespList) {
		if(configRespList == null){
			configRespList = new ArrayList<ConfigurationResponse>();
		}
		this.configRespList = configRespList;
	}
	
	
}
