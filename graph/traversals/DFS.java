package graph.traversals;
import java.util.Stack;

import graph.Graph;
import graph.Node;

public class DFS {
	
	public static void DFStraversal(Graph<? extends Number> g, Node<? extends Number> from) {
		//creating array to keep the visited nodes
		boolean[] visited = new boolean[g.getVertices().size()];
		for(int i =0; i<visited.length;i++) {
			visited[i] = false;
		}
		
		//visiting the first node
		Stack<Node<? extends Number>> stack = new Stack<>();
		stack.add(from);
		visit(g, from, visited);
		
		//visiting all the nodes
		while(!stack.isEmpty()) {
			Node<? extends Number> current = stack.pop();
			System.out.println(current.getData());
			
			for(int i =0; i< current.getNeighbours().size();i++) {
				Node<? extends Number> neighbour = current.getNeighbours().get(i);
				
				if(!isVisited(g, neighbour, visited)) {
					visit(g, neighbour, visited);
					stack.add(neighbour);
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
