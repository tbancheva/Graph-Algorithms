package graph;
import java.util.ArrayList;
import java.util.List;

import graph.algorithms.KahnsTopologicalSort;

public class Graph<T> {
	
	private List<Node<T>> vertices;
	private List<Integer> indegrees;
	private boolean hasCyscles;
	
	public Graph(){
		this.vertices = new ArrayList<>();
		this.indegrees = new ArrayList<>();
		this.hasCyscles = false;
	}
	
	public void addVertex(Node<T> n) {
		vertices.add(n);
		indegrees.add(0);
	}
	
	public void addEdge(Node<T> from, Node<T> to) {
		if(!vertices.contains(from)) {
			addVertex(from);
		}
		if(!vertices.contains(to)) {
			addVertex(to);
		}
		from.addNeighbour(to);
		
		for(int i =0; i< vertices.size(); i++) {
			if(vertices.get(i).equals(to)) {
				indegrees.set(i, indegrees.get(i) + 1);
			}
		}		
	}
	
	public void print() {
		for(Node<T> n: vertices) {
			System.out.println("Node: " + n.getData());
			System.out.println("Neighbours: " + n.getNeighbours().stream().map(v -> v.getData().toString()).reduce("", String::concat));
		}
	}
	
	public static void main(String[] args) {
		/*Node<Integer> node0 = new Node<>(0);
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		
		Graph<Integer> graph = new Graph<>();
		graph.addVertex(node0);
		graph.addVertex(node1);
		graph.addVertex(node2);
		graph.addVertex(node3);
		
		graph.addEdge(node0, node1);
		//graph.addEdge(node0, node2);
		//graph.addEdge(node1, node2);
		graph.addEdge(node2, node0);
		graph.addEdge(node2, node3);
		//graph.addEdge(node3, node3);
		//graph.print();
		
		//BFS.BFStraversal(graph, node2);
		//DFS.DFStraversal(graph, node2);
		//RecursiveDFS.DFStraversal(graph, node2);
		//DFSColoringCycleDetection.DFStraversal(graph, node2);
		//System.out.println(graph.hasCyscles);
		System.out.println(KahnsTopologicalSort.topologicalSort(graph));*/
		
		
		Node<Integer> node0 = new Node<>(0);
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node6 = new Node<>(6);
		Node<Integer> node7 = new Node<>(7);
		
		Graph<Integer> graph = new Graph<>();
		graph.addEdge(node5, node1);
		graph.addEdge(node7, node1);
		graph.addEdge(node1, node6);
		graph.addEdge(node1, node4);
		graph.addEdge(node1, node2);
		graph.addEdge(node7, node0);
		graph.addEdge(node3, node0);
		graph.addEdge(node0, node6);
		graph.addEdge(node3, node4);
		System.out.println(KahnsTopologicalSort.topologicalSort(graph));
		System.out.println(graph.hasCyscles);
	}

	public List<Node<T>> getVertices() {
		return vertices;
	}
	
	public List<Integer> getIndegrees() {
		return indegrees;
	}
	
	public void setHasCycles(boolean hasCycles) {
		this.hasCyscles = hasCycles;
	}
	
}
