
/**
 * ServiceParserConfigurationExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package service;

public class ServiceParserConfigurationExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1381503746983L;
    
    private service.ServiceStub.ServiceParserConfigurationException faultMessage;

    
        public ServiceParserConfigurationExceptionException() {
            super("ServiceParserConfigurationExceptionException");
        }

        public ServiceParserConfigurationExceptionException(java.lang.String s) {
           super(s);
        }

        public ServiceParserConfigurationExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ServiceParserConfigurationExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(service.ServiceStub.ServiceParserConfigurationException msg){
       faultMessage = msg;
    }
    
    public service.ServiceStub.ServiceParserConfigurationException getFaultMessage(){
       return faultMessage;
    }
}
    