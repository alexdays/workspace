package by.bsuir.OTS.Kalenik.grapheditor.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class GraphModel extends Observable implements Serializable {

	private static final long serialVersionUID = 2034560809598304488L;
	
	private final List<VertexModel> vertices;
	private final List<EdgeModel> edges;

	public GraphModel() {
		vertices = new ArrayList<VertexModel> ();
		edges = new ArrayList<EdgeModel> ();
	}

	public void addVertex(VertexModel vertex) {
		vertices.add(vertex);
	}

	public void addEdge(EdgeModel edge) {
		edges.add(edge);
	}
	
	public int getVerticesCount() {
		return vertices.size();
	}
	
	public List<EdgeModel> getIncidentEdges(VertexModel vertex) {
		List<EdgeModel> incidentEdges = new ArrayList<EdgeModel> ();
		for (EdgeModel i : edges) {
			if (i.getVertex1() == vertex || i.getVertex2() == vertex) {
				incidentEdges.add(i);
			}
		}
		return incidentEdges;
	}
	
	public boolean isEdgeExist(VertexModel v1, VertexModel v2) {
		if (v1.equals(v2)) return true;
		for (EdgeModel i : edges) {
			if ((i.getVertex1() == v1 && i.getVertex2() == v2) || 
				(i.getVertex1() == v2 && i.getVertex2() == v1)) {
				return true;
			}
		}
		return false;
	}
	
	public void getAdjacencyMatrix(List<VertexModel> vm){
		try {
			PrintWriter pw = new PrintWriter(new File("C://input.txt"));

			pw.println(this.getVerticesCount());
		int graphMatrix[][] = new int[this.vertices.size()][this.vertices.size()];
		for(int vertexIt = 0; vertexIt< this.vertices.size();vertexIt++){
			List<EdgeModel> edges = this.getIncidentEdges(vertices.get(vertexIt));
			for(int edgesIt = 0; edgesIt < edges.size(); edgesIt++){
				VertexModel incVertex = edges.get(edgesIt).getIncidentVertex(vertices.get(vertexIt));
				int weight = edges.get(edgesIt).getWeight();
				graphMatrix[vertexIt][vertices.lastIndexOf(incVertex)] = edges.get(edgesIt).getWeight();
			}
		}
		
		for(int i = 0; i< this.vertices.size(); i++){
			for(int j = 0; j< this.vertices.size(); j++){
				pw.print(graphMatrix[i][j]);
				if(this.vertices.size() == (j+1)){
					pw.println();
				}
				else{
					pw.print(" ");
				}
			}
		}
		
		int v1 = vertices.lastIndexOf(vm.get(0))+1;
		int v2 = vertices.lastIndexOf(vm.get(1))+1;
		pw.print(v1+" "+v2);
		pw.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void removeEdge(EdgeModel edge) {
		edges.remove(edge);		
	}
	
	public void removeVertex(VertexModel vertex) {
		vertices.remove(vertex);
	}

	public List<VertexModel> getVertices() {
		return vertices;
	}
	
	public List<EdgeModel> getEdges() {
		return edges;
	}
}