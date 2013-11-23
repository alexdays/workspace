
/**
 * ServiceSAXExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package service;

public class ServiceSAXExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1381503746963L;
    
    private service.ServiceStub.ServiceSAXException faultMessage;

    
        public ServiceSAXExceptionException() {
            super("ServiceSAXExceptionException");
        }

        public ServiceSAXExceptionException(java.lang.String s) {
           super(s);
        }

        public ServiceSAXExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ServiceSAXExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(service.ServiceStub.ServiceSAXException msg){
       faultMessage = msg;
    }
    
    public service.ServiceStub.ServiceSAXException getFaultMessage(){
       return faultMessage;
    }
}
    