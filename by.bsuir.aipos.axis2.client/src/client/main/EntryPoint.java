/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.main;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;
import model.Note;
import org.apache.axis2.AxisFault;
import service.ServiceIOExceptionException;
import service.ServiceParserConfigurationExceptionException;
import service.ServiceSAXExceptionException;
import service.ServiceStub;
import service.ServiceTransformerExceptionException;
import view.MainFrame;
import org.apache.axis2.description.AxisOperation;


public class EntryPoint {
    
    public static void main(String[] args) throws AxisFault, RemoteException, ServiceIOExceptionException, ServiceSAXExceptionException, ServiceParserConfigurationExceptionException, ServiceTransformerExceptionException, MalformedURLException  {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
