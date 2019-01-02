package graph.algorithms;

import graph.Graph;
import graph.Node;

/**
 * Checking if a graph contains a cycle using the coloring method.
 * Instead of using a boolean array to keep the state of the
 * nodes this algorithm uses array of integers where: 
 *  0 - unvisited / WHITE
 * -1 - currently being visited / GRAY
 *  1 - visited / BLACK
 *  
 *  If during a DFS traversal a node that is gray is being visited then there is a cycle in the graph
 */

public class DFSColoringCycleDetection {
	
	public static void DFStraversal(Graph<? extends Number> g, Node<? extends Number> from) {
		int[] visited = new int[g.getVertices().size()];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}
		
		recursiveDFS(g, from, visited);
	}

	private static void recursiveDFS(Graph<? extends Number> g, Node<? extends Number> node, int[] visited) {
		System.out.println(node.getData());
		visit(g, node, visited, -1); 

		for (int i = 0; i < node.getNeighbours().size(); i++) {
			Node<? extends Number> neighbour = node.getNeighbours().get(i);
			
			if (isVisited(g, neighbour, visited) == 0 || isVisited(g, neighbour, visited) == 1) {
				visit(g, neighbour, visited, -1); 
				recursiveDFS(g, neighbour, visited);
			}
			else {
				g.setHasCycles(true);
			}
		}
		
		visit(g, node, visited, 1); // mark as finished

	}
	
	private static void visit(Graph<? extends Number> g, Node<? extends Number> node, int[] visited, int color) {
		for(int i =0; i<visited.length;i++) {
			if(g.getVertices().get(i).equals(node)) {
				visited[i] = color;
			}
		}
	}
	
	private static int isVisited(Graph<? extends Number> g, Node<? extends Number> node, int[] visited) {
		for(int i =0; i<visited.length;i++) {
			if(g.getVertices().get(i).equals(node)) {
				return visited[i];
			}
		}
		return 0;
	}
}
