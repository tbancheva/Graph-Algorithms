package graph.traversals;
import graph.Graph;
import graph.Node;

public class RecursiveDFS {
	
	public static void DFStraversal(Graph<? extends Number> g, Node<? extends Number> from) {
		// creating array to keep the visited nodes
		boolean[] visited = new boolean[g.getVertices().size()];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		
		recursiveDFS(g, from, visited);
	}

	private static void recursiveDFS(Graph<? extends Number> g, Node<? extends Number> node, boolean[] visited) {
		System.out.println(node.getData());
		visit(g, node, visited);

		for (int i = 0; i < node.getNeighbours().size(); i++) {
			Node<? extends Number> neighbour = node.getNeighbours().get(i);
			if (!isVisited(g, neighbour, visited)) {
				visit(g, neighbour, visited);
				recursiveDFS(g, neighbour, visited);
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
