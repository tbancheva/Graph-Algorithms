package graph.algorithms;
import java.util.List;
import java.util.Stack;

import graph.Graph;
import graph.Node;

public class KahnsTopologicalSort {
	
	public static boolean topologicalSort(Graph<? extends Number> g) {
		Stack<Node<? extends Number>> stack = new Stack<>();
		List<Integer> degrees = g.getIndegrees();
		
		for (int i = 0; i < degrees.size(); i++) {
			if (degrees.get(i) == 0) {
				stack.add(g.getVertices().get(i));
			}
		}

		while (!stack.isEmpty()) {
			Node<? extends Number> n = stack.pop();
			System.out.println(n.getData());
			for (Node<? extends Number> m : n.getNeighbours()) {
				int index = getDegreeIndex(g,m);				
				degrees.set(index, degrees.get(index) - 1);
				if (degrees.get(index) == 0) {
					stack.add(m);
				}
			}
		}

		// if the graph still has edges then it has at least one cycle
		for (int i = 0; i < g.getVertices().size(); i++) {
			if (degrees.get(i) != 0) {
				return false;
			}
		}

		return true;
	}
	
	
	private static int getDegreeIndex(Graph<? extends Number> g, Node<? extends Number> n) {
		for(int i =0; i < g.getVertices().size() ;i++) {
			if(g.getVertices().get(i).equals(n)) {
				return i;
			}
		}
		return -1;
	}
}
