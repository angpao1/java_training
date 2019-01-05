package th.co.extosoft.trainning;

import th.co.extosoft.app.biz.AppTierBusiness;
import th.co.extosoft.app.itf.ConfigurationRequest;

public class TestConnectDB {

	public static void main(String args[]){
		
		AppTierBusiness appTierBusiness = new AppTierBusiness();
		
		//Call GetConfig
		ConfigurationRequest configReqs = new ConfigurationRequest();
		//configReqs.setConfigName("DB");
		//configReqs.setConfigValue("admin");
		
		System.out.println("ConfigId --> " + configReqs.getConfigId());
		System.out.println("ConfigName --> " + configReqs.getConfigName());
		System.out.println("ConfigValue --> " + configReqs.getConfigValue());
		System.out.println("ConfigDttm --> " + configReqs.getConfigDttm());
		System.out.println("ConfigBy --> " + configReqs.getConfigBy());
		appTierBusiness.callGetConfig(configReqs);
		
		//Call AddConfig
		configReqs = new ConfigurationRequest();
		configReqs.setConfigName("Jack2");
		configReqs.setConfigValue("Extosoft2");
		appTierBusiness.callAddConfig(configReqs);
		
		//Call UpdateConfig
//		configReqs = new ConfigurationRequest();
//		configReqs.setConfigId(48);
//		configReqs.setConfigName("Jack");
//		configReqs.setConfigValue("Extosoft1");
//		appTierBusiness.callUpdateConfig(configReqs);
		
		//Call DeleteConfig
//		configReqs = new ConfigurationRequest();
//		configReqs.setConfigId(48);
//		configReqs.setConfigName("Jack");
//		appTierBusiness.callDeleteConfig(configReqs);
		
	}
	
}
