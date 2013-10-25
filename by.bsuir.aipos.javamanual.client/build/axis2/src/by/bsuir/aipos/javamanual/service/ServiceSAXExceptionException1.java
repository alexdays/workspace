
/**
 * ServiceSAXExceptionException1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */

package by.bsuir.aipos.javamanual.service;

public class ServiceSAXExceptionException1 extends java.lang.Exception{
    
    private by.bsuir.aipos.javamanual.service.ServiceSAXException faultMessage;
    
    public ServiceSAXExceptionException1() {
        super("ServiceSAXExceptionException1");
    }
           
    public ServiceSAXExceptionException1(java.lang.String s) {
       super(s);
    }
    
    public ServiceSAXExceptionException1(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(by.bsuir.aipos.javamanual.service.ServiceSAXException msg){
       faultMessage = msg;
    }
    
    public by.bsuir.aipos.javamanual.service.ServiceSAXException getFaultMessage(){
       return faultMessage;
    }
}
    