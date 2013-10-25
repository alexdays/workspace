
/**
 * ServiceParserConfigurationExceptionException3.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */

package by.bsuir.aipos.javamanual.service;

public class ServiceParserConfigurationExceptionException3 extends java.lang.Exception{
    
    private by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException faultMessage;
    
    public ServiceParserConfigurationExceptionException3() {
        super("ServiceParserConfigurationExceptionException3");
    }
           
    public ServiceParserConfigurationExceptionException3(java.lang.String s) {
       super(s);
    }
    
    public ServiceParserConfigurationExceptionException3(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException msg){
       faultMessage = msg;
    }
    
    public by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException getFaultMessage(){
       return faultMessage;
    }
}
    