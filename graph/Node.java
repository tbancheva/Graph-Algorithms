package graph;
import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	
	private T data;
	private List<Node<T>> neighbours;
	
	public Node(T data){
		this.data = data;
		neighbours = new ArrayList<>();
	}
	
	public void addNeighbour(Node<T> n) {
		neighbours.add(n);
	}

	public T getData() {
		return data;
	}

	public List<Node<T>> getNeighbours() {
		return neighbours;
	}

}
