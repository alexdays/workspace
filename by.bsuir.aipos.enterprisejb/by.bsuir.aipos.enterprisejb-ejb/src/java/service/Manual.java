/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import operations.OperationBeanLocal;

/**
 *
 * @author Александр
 */
@WebService(serviceName = "Manual")
@Stateless()
public class Manual {
    @EJB
    private OperationBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getAllConcepts")
    public List<String> getAllConcepts() {
        return ejbRef.getAllConcepts();
    }

    @WebMethod(operationName = "addConcept")
    @Oneway
    public void addConcept(@WebParam(name = "name") String name, @WebParam(name = "content") String content) {
        ejbRef.addConcept(name, content);
    }

    @WebMethod(operationName = "changeConcept")
    @Oneway
    public void changeConcept(@WebParam(name = "name") String name, @WebParam(name = "content") String content) {
        ejbRef.changeConcept(name, content);
    }

    @WebMethod(operationName = "eraseConcept")
    @Oneway
    public void eraseConcept(@WebParam(name = "name") String name) {
        ejbRef.eraseConcept(name);
    }

    @WebMethod(operationName = "getConceptContent")
    public String getConceptContent(@WebParam(name = "name") String name) {
        return ejbRef.getConceptContent(name);
    }

    @WebMethod(operationName = "init")
    @Oneway
    public void init() {
        ejbRef.init();
    }
    
}
