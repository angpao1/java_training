package th.co.extosoft.app.biz;

import java.util.List;

import th.co.extosoft.app.db.AppTierDB;
import th.co.extosoft.app.itf.AppTierResponse;
import th.co.extosoft.app.itf.ConfigurationRequest;
import th.co.extosoft.app.itf.ConfigurationResponse;

public class AppTierBusiness {

	public AppTierResponse callGetConfig(ConfigurationRequest configReqs) {
		AppTierResponse appTierResp = new AppTierResponse();
		appTierResp.setStatus("0000");
		appTierResp.setErrorMessage("");
		
		List<ConfigurationResponse> configRespList = null;
		AppTierDB appTierDB = new AppTierDB();
		configRespList = appTierDB.getConfig(configReqs);
		
		String configId = "";
		String configName = "";
		String configValue = "";
		String configDttm = "";
		String configBy = "";
		
		if(configRespList != null && configRespList.size() > 0){
			for(int i = 0; i < configRespList.size();i++){
				configId = "" + configRespList.get(i).getConfigId();
				configName = configRespList.get(i).getConfigName();
				configValue = configRespList.get(i).getConfigValue();
				configDttm = configRespList.get(i).getConfigDttm();
				configBy = configRespList.get(i).getConfigBy();
				
				System.out.println("Get Successfully Data found");
				System.out.println("ConfigId[" + i + "] --> " + configId);
				System.out.println("ConfigName[" + i + "] --> " + configName);
				System.out.println("ConfigValue[" + i + "] --> " + configValue);
				System.out.println("ConfigDttm[" + i + "] --> " + configDttm);
				System.out.println("ConfigBy[" + i + "] --> " + configBy);
				appTierResp.setStatus("0000");
				appTierResp.setErrorMessage("Get Successfully Data found");
				appTierResp.setConfigRespList(configRespList);
			}
		}else{
				System.out.println("Get Failed Data not found");
				appTierResp.setStatus("1000");
				appTierResp.setErrorMessage("Get Failed Data not found");
		}
		
		return appTierResp;
	}

	public AppTierResponse callAddConfig(ConfigurationRequest configReqs) {
		AppTierResponse appTierResp = new AppTierResponse();
		appTierResp.setStatus("0000");
		appTierResp.setErrorMessage("");
		
		AppTierDB appTierDB = new AppTierDB();
		boolean completed = appTierDB.addConfig(configReqs);
		if(completed){
			System.out.println("Add Successfully");
			appTierResp.setStatus("0000");
			appTierResp.setErrorMessage("Add Successfully");
		}else{
			System.out.println("Add Failed");
			appTierResp.setStatus("2000");
			appTierResp.setErrorMessage("Add Failed");
		}
		return appTierResp;
	}
	
	public AppTierResponse callUpdateConfig(ConfigurationRequest configReqs) {
		AppTierResponse appTierResp = new AppTierResponse();
		appTierResp.setStatus("0000");
		appTierResp.setErrorMessage("");
		
		AppTierDB appTierDB = new AppTierDB();
		boolean completed = appTierDB.updateConfig(configReqs);
		if(completed){
			System.out.println("Update Successfully");
			appTierResp.setStatus("0000");
			appTierResp.setErrorMessage("Update Successfully");
		}else{
			System.out.println("Update Failed");
			appTierResp.setStatus("3000");
			appTierResp.setErrorMessage("Update Failed");
		}
		return appTierResp;
	}
	
	public AppTierResponse callDeleteConfig(ConfigurationRequest configReqs) {
		AppTierResponse appTierResp = new AppTierResponse();
		appTierResp.setStatus("0000");
		appTierResp.setErrorMessage("");
		
		AppTierDB appTierDB = new AppTierDB();
		boolean completed = appTierDB.deleteConfig(configReqs);
		if(completed){
			System.out.println("Delete Successfully");
			appTierResp.setStatus("0000");
			appTierResp.setErrorMessage("Delete Successfully");
		}else{
			System.out.println("Delete Failed");
			appTierResp.setStatus("4000");
			appTierResp.setErrorMessage("Delete Failed");
		}
		return appTierResp;
	}
	
}
