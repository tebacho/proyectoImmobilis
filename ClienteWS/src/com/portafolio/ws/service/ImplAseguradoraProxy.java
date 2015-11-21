package com.portafolio.ws.service;

public class ImplAseguradoraProxy implements com.portafolio.ws.service.ImplAseguradora {
  private String _endpoint = null;
  private com.portafolio.ws.service.ImplAseguradora implAseguradora = null;
  
  public ImplAseguradoraProxy() {
    _initImplAseguradoraProxy();
  }
  
  public ImplAseguradoraProxy(String endpoint) {
    _endpoint = endpoint;
    _initImplAseguradoraProxy();
  }
  
  private void _initImplAseguradoraProxy() {
    try {
      implAseguradora = (new com.portafolio.ws.service.ImplAseguradoraServiceLocator()).getImplAseguradora();
      if (implAseguradora != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)implAseguradora)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)implAseguradora)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (implAseguradora != null)
      ((javax.xml.rpc.Stub)implAseguradora)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.portafolio.ws.service.ImplAseguradora getImplAseguradora() {
    if (implAseguradora == null)
      _initImplAseguradoraProxy();
    return implAseguradora;
  }
  
  public com.portafolio.ws.bean.BeanAseguradora validaAseguradora(com.portafolio.ws.bean.BeanAseguradora obj) throws java.rmi.RemoteException{
    if (implAseguradora == null)
      _initImplAseguradoraProxy();
    return implAseguradora.validaAseguradora(obj);
  }
  
  
}