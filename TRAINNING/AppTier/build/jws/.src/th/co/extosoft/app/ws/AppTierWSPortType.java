package th.co.extosoft.app.ws;

/**
 * Generated interface, please do not edit.
 * Date: [Sat Jan 05 15:05:46 ICT 2019]
 */

public interface AppTierWSPortType extends java.rmi.Remote {

  /**
   * Web Method: callDeleteData ...
   */
  th.co.extosoft.app.itf.AppTierResponse callDeleteData(th.co.extosoft.app.itf.ConfigurationRequest configReqs)
      throws java.rmi.RemoteException;
  /**
   * Web Method: getListConfigurationResponse ...
   */
  java.util.List getListConfigurationResponse()
      throws java.rmi.RemoteException;
  /**
   * Web Method: getConfigurationResponse ...
   */
  th.co.extosoft.app.itf.ConfigurationResponse getConfigurationResponse()
      throws java.rmi.RemoteException;
  /**
   * Web Method: callAddData ...
   */
  th.co.extosoft.app.itf.AppTierResponse callAddData(th.co.extosoft.app.itf.ConfigurationRequest configReqs)
      throws java.rmi.RemoteException;
  /**
   * Web Method: callUpdateData ...
   */
  th.co.extosoft.app.itf.AppTierResponse callUpdateData(th.co.extosoft.app.itf.ConfigurationRequest configReqs)
      throws java.rmi.RemoteException;
  /**
   * Web Method: callGetData ...
   */
  th.co.extosoft.app.itf.AppTierResponse callGetData(th.co.extosoft.app.itf.ConfigurationRequest configReqs)
      throws java.rmi.RemoteException;
}
