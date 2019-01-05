package th.co.extosoft.app.ws;

import javax.jws.*;

import th.co.extosoft.app.biz.AppTierBusiness;
import th.co.extosoft.app.itf.AppTierResponse;
import th.co.extosoft.app.itf.ConfigurationRequest;
import th.co.extosoft.app.itf.ConfigurationResponse;
import java.util.List;
import java.util.ArrayList;

@WebService
public class AppTierWS {

	@WebMethod
	public AppTierResponse callGetData(ConfigurationRequest configReqs) {
		AppTierBusiness appTierBusiness = new AppTierBusiness();
		AppTierResponse appTierResp = null;
		appTierResp = appTierBusiness.callGetConfig(configReqs);
		return appTierResp;
	}
	
	@WebMethod
	public AppTierResponse callAddData(ConfigurationRequest configReqs) {
		AppTierBusiness appTierBusiness = new AppTierBusiness();
		AppTierResponse appTierResp = null;
		appTierResp = appTierBusiness.callAddConfig(configReqs);
		return appTierResp;
	}
	
	@WebMethod
	public AppTierResponse callUpdateData(ConfigurationRequest configReqs) {
		AppTierBusiness appTierBusiness = new AppTierBusiness();
		AppTierResponse appTierResp = null;
		appTierResp = appTierBusiness.callUpdateConfig(configReqs);
		return appTierResp;
	}
	
	@WebMethod
	public AppTierResponse callDeleteData(ConfigurationRequest configReqs) {
		AppTierBusiness appTierBusiness = new AppTierBusiness();
		AppTierResponse appTierResp = null;
		appTierResp = appTierBusiness.callDeleteConfig(configReqs);
		return appTierResp;
	}
	
	@WebMethod
	public List<ConfigurationResponse> getListConfigurationResponse() {
		return new ArrayList<ConfigurationResponse>();
	}  
	
	@WebMethod
	public ConfigurationResponse getConfigurationResponse() {
		return new ConfigurationResponse();
	}
}