/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.main;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;
import javax.xml.rpc.ServiceException;
import model.Note;
import org.apache.axis.AxisFault;

import view.MainFrame;

public class EntryPoint {
    
    public static void main(String[] args) throws RemoteException, MalformedURLException, AxisFault, ServiceException{
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
