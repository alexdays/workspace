package by.bsuir.ppvis.server.main;

import java.io.IOException;

import by.bsuir.ppvis.server.view.ServerFrame;

public class EntryPoint {

	public static void main(String[] args) throws IOException {
		ServerFrame serverFrame = new ServerFrame();
		serverFrame.setVisible(true);
	}

}
