
/**
 * ServiceIOExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package service;

public class ServiceIOExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1381503746974L;
    
    private service.ServiceStub.ServiceIOException faultMessage;

    
        public ServiceIOExceptionException() {
            super("ServiceIOExceptionException");
        }

        public ServiceIOExceptionException(java.lang.String s) {
           super(s);
        }

        public ServiceIOExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ServiceIOExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(service.ServiceStub.ServiceIOException msg){
       faultMessage = msg;
    }
    
    public service.ServiceStub.ServiceIOException getFaultMessage(){
       return faultMessage;
    }
}
    