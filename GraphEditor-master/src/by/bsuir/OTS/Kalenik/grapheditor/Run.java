package by.bsuir.OTS.Kalenik.grapheditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Run {

	public static void main(String[] args) throws FileNotFoundException {
		new GraphEditorComponent();
		/*
		 Scanner sc = new Scanner(new File("C://input.txt"));
	        PrintWriter pw = new PrintWriter(new File("C://output.txt"));
	        int n;
	        n = sc.nextInt();
	        Graph1 graph = new Graph1(n);
	        
	        for(int i = 0; i < n; i++){
	            for(int j = 0; j < n; j++){
	                int tmp = sc.nextInt();
	                if(tmp >= 1){
	                    graph.addEdgeOriented(i, j, tmp);
	                }
	            }
	        }
	        int start, end;
	        start = sc.nextInt();
	        end = sc.nextInt();
	        graph.bfs(start - 1);
	        int a[] = graph.getUsed();
	        pw.print(a[end - 1]);
	        sc.close();
	        pw.close();
	        
	        */
	    }

}



