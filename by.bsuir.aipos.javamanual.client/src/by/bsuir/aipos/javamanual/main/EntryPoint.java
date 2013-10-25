/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.aipos.javamanual.main;

import by.bsuir.aipos.javamanual.view.MainFrame;
import java.net.MalformedURLException;
import javax.xml.rpc.ServiceException;

public class EntryPoint {
    public static void main(String[] args) throws MalformedURLException, ServiceException{
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
