
/**
 * ServiceIOExceptionException0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */

package by.bsuir.aipos.javamanual.service;

public class ServiceIOExceptionException0 extends java.lang.Exception{
    
    private by.bsuir.aipos.javamanual.service.ServiceIOException faultMessage;
    
    public ServiceIOExceptionException0() {
        super("ServiceIOExceptionException0");
    }
           
    public ServiceIOExceptionException0(java.lang.String s) {
       super(s);
    }
    
    public ServiceIOExceptionException0(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(by.bsuir.aipos.javamanual.service.ServiceIOException msg){
       faultMessage = msg;
    }
    
    public by.bsuir.aipos.javamanual.service.ServiceIOException getFaultMessage(){
       return faultMessage;
    }
}
    