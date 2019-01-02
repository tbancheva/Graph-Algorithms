package graph.traversals;
import java.util.LinkedList;
import java.util.Queue;

import graph.Graph;
import graph.Node;

public class BFS{
	
	public static void BFStraversal(Graph<? extends Number> g, Node<? extends Number> from) {
		//creating array to keep the visited nodes
		boolean[] visited = new boolean[g.getVertices().size()];
		for(int i =0; i<visited.length;i++) {
			visited[i] = false;
		}
		
		//visiting the first node
		Queue<Node<? extends Number>> queue = new LinkedList<>();
		queue.add(from);
		visit(g, from, visited);
		
		//visiting all the nodes
		while(!queue.isEmpty()) {
			Node<? extends Number> current = queue.poll();
			System.out.println(current.getData());
			
			for(int i =0; i< current.getNeighbours().size();i++) {
				Node<? extends Number> neighbour = current.getNeighbours().get(i);
				
				if(!isVisited(g, neighbour, visited)) {
					visit(g, neighbour, visited);
					queue.add(neighbour);
				}
			}
		}
	}
	
	private static void visit(Graph<? extends Number> g, Node<? extends Number> node, boolean[] visited) {
		for(int i =0; i<visited.length;i++) {
			if(g.getVertices().get(i).equals(node)) {
				visited[i] = true;
			}
		}
	}
	
	private static boolean isVisited(Graph<? extends Number> g, Node<? extends Number> node, boolean[] visited) {
		for(int i =0; i<visited.length;i++) {
			if(g.getVertices().get(i).equals(node)) {
				return visited[i];
			}
		}
		return false;
	}
}
