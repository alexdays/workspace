package by.bsuir.aipos.javamanual.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Client {
    private final String endpoint = "http://localhost:8084/axis/services/Service";
    private Service service;
    private Call call;
        
    public void callStart() throws MalformedURLException, ServiceException{
        service = new Service();
        call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));
    }
    public String getAllConcepts() throws AxisFault{
        Object[] param = new Object[]{};
        String response = (String)call.invoke("getAllConcepts", param);
        return response;
    }
    public void addConcept(String name, String content) throws AxisFault{
        Object[] param = new Object[]{name,content};
        String response = (String)call.invoke("addConcept", param);
    }
    public String eraseConcept(String name) throws AxisFault{
        Object[] param = new Object[]{name};
        String response = (String)call.invoke("eraceConcept", param);
        return response;
    }
    public String getConceptContent(String name) throws AxisFault{
        Object[] param = new Object[]{name};
        String response = (String)call.invoke("getConceptContent", param);
        return response;
    }
    public void changeConcept(String conceptName, String content) throws AxisFault{
        Object[] param = new Object[]{conceptName, content};
        String response = (String)call.invoke("changeConcept", param);
    }
    
    
}
