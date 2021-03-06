package by.bsuir.OTS.Kalenik.grapheditor.views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import by.bsuir.OTS.Kalenik.grapheditor.controllers.GraphController;
import by.bsuir.OTS.Kalenik.grapheditor.models.GraphModel;

public class GraphView extends JPanel implements Observer {

	private static final long serialVersionUID = 5915112810769913119L;
	private final GraphModel model;
	private final GraphController controller;
	
	public GraphView(GraphController controller, GraphModel model) {
		super();
		this.setLayout(null);
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
	}
	
}
