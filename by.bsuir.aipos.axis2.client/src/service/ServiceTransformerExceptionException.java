
/**
 * ServiceTransformerExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package service;

public class ServiceTransformerExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1381503747009L;
    
    private service.ServiceStub.ServiceTransformerException faultMessage;

    
        public ServiceTransformerExceptionException() {
            super("ServiceTransformerExceptionException");
        }

        public ServiceTransformerExceptionException(java.lang.String s) {
           super(s);
        }

        public ServiceTransformerExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ServiceTransformerExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(service.ServiceStub.ServiceTransformerException msg){
       faultMessage = msg;
    }
    
    public service.ServiceStub.ServiceTransformerException getFaultMessage(){
       return faultMessage;
    }
}
    