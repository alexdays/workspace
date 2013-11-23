package by.bsuir.OTS.Kalenik.grapheditor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph1 {

    public int used[];
    private int parent[];
    private LinkedList nodes[];
    private LinkedList q;
    private int weight[][];
    
    public Graph1(int n) {
        used = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(used, -1);
        nodes = new LinkedList[n];
        q = new LinkedList();
        for (int i = 0; i < n; i++) {
            nodes[i] = new LinkedList();
        }
        weight = new int[n][n];
    }



    public void bfs(int start) {
        used[start] = 0;
        init(start);
        while (!q.isEmpty()) {
        	//q.poll();
        	
        	init((Integer) q.poll());
        }
    }
    
    private void init(int start) {
        Iterator it = nodes[start].listIterator();
        while (it.hasNext()) {
            int curr = (Integer) it.next();
            if (used[curr] == -1) {
                used[curr] = used[start] + this.weight[start][curr];
                q.add(curr);
                parent[curr] = start;
            }
        }
    }

    public int [] getUsed(){
        return used;
    }

    public void addEdgeOriented(int first, int second, int weight) {
    	
        nodes[first].add(second);
        this.weight[first][second] = weight;
    }
}
