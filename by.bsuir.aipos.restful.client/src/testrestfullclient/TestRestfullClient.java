/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrestfullclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.thoughtworks.xstream.XStream;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import model.Note;
import view.MainFrame;

/**
 *
 * @author Александр
 */
public class TestRestfullClient {

    
    public static void main(String[] args) throws MalformedURLException, RemoteException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
