package a6;
/* Jason Yescas
   Object-Oriented Programming : CPSC-24500-001
   4/8/2024
   Nodes Class */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Nodes {
	private ArrayList<INode> nodes;
	
	// Default constructor, initializes list as empty
	public Nodes() {
		nodes = new ArrayList<>();
	}
	
	/**
	 * Fills list with inputed number of random nodes
	 * @param size
	 * @throws Exception
	 */
	public void fill(int size) throws Exception {
		nodes.clear();
		for (int i = 0; i< size; i++) {
			nodes.add(Math.random() > 0.5 ? NodeFactory.getNode() : NodeFactory.getThreeDNode());
		}
	}
	
	// Clears all nodes from list
	public void clear() {
		nodes.clear();
	}
	
	/**
	 * Counts and returns number of nodes in the list
	 * @return
	 */
	public int countNodes() {
		return (int) nodes.stream().filter(n -> n instanceof Node && !(n instanceof ThreeDNode)).count();
	}
	
	/**
	 * Counts and returns number of ThreeDNodes in the list
	 * @return
	 */
	public int countThreeDNodes() {
		return (int) nodes.stream().filter(n -> n instanceof ThreeDNode).count();
	}
	
	// Sorts list of nodes based on their coordinate
	public void sort() {
		Collections.sort(nodes, new Sorter());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (INode node : nodes) {
			sb.append(node.toString()).append("\n");
		}
		return sb.toString();
	}
}

// Comparator for INode objects. Compares nodes based on sum of their coordinates
class Sorter implements Comparator <INode> {
	@Override
	public int compare(INode o1, INode o2) {
		int sum1;
		int sum2;
		if (o1.getClass() == Node.class) {
			Node obj1 = (Node) o1;
			sum1 = obj1.getX() + obj1.getY();
		}
		else {
			ThreeDNode obj1 = (ThreeDNode) o1;
			sum1 = obj1.getX() + obj1.getY() + obj1.getZ();
		}
		if (o2.getClass() == Node.class) {
			Node obj2 = (Node) o2;
			sum2 = obj2.getX() + obj2.getY();
		}
		else {
			ThreeDNode obj2 = (ThreeDNode) o2;
			sum2 = obj2.getX() + obj2.getY() + obj2.getZ();
		}
		if(sum1 > sum2) {
			return 1;
		}
		if(sum1 == sum2) {
			return 0;
		}
		return -1;
	}
}
