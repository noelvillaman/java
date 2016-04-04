/**
 * HelloNoelServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.arpit.javapostsforlearning.webservices;

public class HelloNoelServiceLocator extends org.apache.axis.client.Service implements org.arpit.javapostsforlearning.webservices.HelloNoelService {

    public HelloNoelServiceLocator() {
    }


    public HelloNoelServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloNoelServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloNoel
    private java.lang.String HelloNoel_address = "http://localhost:8081/SimpleSOAPExample/services/HelloNoel";

    public java.lang.String getHelloNoelAddress() {
        return HelloNoel_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloNoelWSDDServiceName = "HelloNoel";

    public java.lang.String getHelloNoelWSDDServiceName() {
        return HelloNoelWSDDServiceName;
    }

    public void setHelloNoelWSDDServiceName(java.lang.String name) {
        HelloNoelWSDDServiceName = name;
    }

    public org.arpit.javapostsforlearning.webservices.HelloNoel getHelloNoel() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloNoel_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloNoel(endpoint);
    }

    public org.arpit.javapostsforlearning.webservices.HelloNoel getHelloNoel(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.arpit.javapostsforlearning.webservices.HelloNoelSoapBindingStub _stub = new org.arpit.javapostsforlearning.webservices.HelloNoelSoapBindingStub(portAddress, this);
            _stub.setPortName(getHelloNoelWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloNoelEndpointAddress(java.lang.String address) {
        HelloNoel_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.arpit.javapostsforlearning.webservices.HelloNoel.class.isAssignableFrom(serviceEndpointInterface)) {
                org.arpit.javapostsforlearning.webservices.HelloNoelSoapBindingStub _stub = new org.arpit.javapostsforlearning.webservices.HelloNoelSoapBindingStub(new java.net.URL(HelloNoel_address), this);
                _stub.setPortName(getHelloNoelWSDDServiceName());
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
        if ("HelloNoel".equals(inputPortName)) {
            return getHelloNoel();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.javapostsforlearning.arpit.org", "HelloNoelService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.javapostsforlearning.arpit.org", "HelloNoel"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloNoel".equals(portName)) {
            setHelloNoelEndpointAddress(address);
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
