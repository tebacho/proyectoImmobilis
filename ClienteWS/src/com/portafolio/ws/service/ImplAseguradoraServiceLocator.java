/**
 * ImplAseguradoraServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portafolio.ws.service;

public class ImplAseguradoraServiceLocator extends org.apache.axis.client.Service implements com.portafolio.ws.service.ImplAseguradoraService {

    public ImplAseguradoraServiceLocator() {
    }


    public ImplAseguradoraServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ImplAseguradoraServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ImplAseguradora
    private java.lang.String ImplAseguradora_address = "http://localhost:8087/Aseguradora/services/ImplAseguradora";

    public java.lang.String getImplAseguradoraAddress() {
        return ImplAseguradora_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ImplAseguradoraWSDDServiceName = "ImplAseguradora";

    public java.lang.String getImplAseguradoraWSDDServiceName() {
        return ImplAseguradoraWSDDServiceName;
    }

    public void setImplAseguradoraWSDDServiceName(java.lang.String name) {
        ImplAseguradoraWSDDServiceName = name;
    }

    public com.portafolio.ws.service.ImplAseguradora getImplAseguradora() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ImplAseguradora_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getImplAseguradora(endpoint);
    }

    public com.portafolio.ws.service.ImplAseguradora getImplAseguradora(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.portafolio.ws.service.ImplAseguradoraSoapBindingStub _stub = new com.portafolio.ws.service.ImplAseguradoraSoapBindingStub(portAddress, this);
            _stub.setPortName(getImplAseguradoraWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setImplAseguradoraEndpointAddress(java.lang.String address) {
        ImplAseguradora_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.portafolio.ws.service.ImplAseguradora.class.isAssignableFrom(serviceEndpointInterface)) {
                com.portafolio.ws.service.ImplAseguradoraSoapBindingStub _stub = new com.portafolio.ws.service.ImplAseguradoraSoapBindingStub(new java.net.URL(ImplAseguradora_address), this);
                _stub.setPortName(getImplAseguradoraWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ImplAseguradora".equals(inputPortName)) {
            return getImplAseguradora();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.ws.portafolio.com", "ImplAseguradoraService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.ws.portafolio.com", "ImplAseguradora"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ImplAseguradora".equals(portName)) {
            setImplAseguradoraEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
