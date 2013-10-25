
/**
 * ServiceTransformerExceptionException2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */

package by.bsuir.aipos.javamanual.service;

public class ServiceTransformerExceptionException2 extends java.lang.Exception{
    
    private by.bsuir.aipos.javamanual.service.ServiceTransformerException faultMessage;
    
    public ServiceTransformerExceptionException2() {
        super("ServiceTransformerExceptionException2");
    }
           
    public ServiceTransformerExceptionException2(java.lang.String s) {
       super(s);
    }
    
    public ServiceTransformerExceptionException2(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(by.bsuir.aipos.javamanual.service.ServiceTransformerException msg){
       faultMessage = msg;
    }
    
    public by.bsuir.aipos.javamanual.service.ServiceTransformerException getFaultMessage(){
       return faultMessage;
    }
}
    