package org.arpit.javapostsforlearning.webservices;

public class HelloNoelProxy implements org.arpit.javapostsforlearning.webservices.HelloNoel {
  private String _endpoint = null;
  private org.arpit.javapostsforlearning.webservices.HelloNoel helloNoel = null;
  
  public HelloNoelProxy() {
    _initHelloNoelProxy();
  }
  
  public HelloNoelProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloNoelProxy();
  }
  
  private void _initHelloNoelProxy() {
    try {
      helloNoel = (new org.arpit.javapostsforlearning.webservices.HelloNoelServiceLocator()).getHelloNoel();
      if (helloNoel != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloNoel)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloNoel)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloNoel != null)
      ((javax.xml.rpc.Stub)helloNoel)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.arpit.javapostsforlearning.webservices.HelloNoel getHelloNoel() {
    if (helloNoel == null)
      _initHelloNoelProxy();
    return helloNoel;
  }
  
  public java.lang.String cryHello(java.lang.String name) throws java.rmi.RemoteException{
    if (helloNoel == null)
      _initHelloNoelProxy();
    return helloNoel.cryHello(name);
  }
  
  
}