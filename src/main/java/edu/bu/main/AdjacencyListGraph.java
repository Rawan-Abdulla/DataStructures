package edu.bu.main;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class AdjacencyListGraph implements Graph {
	private int numberOfNodes;
	private int numberOfEdges;
	private Hashtable<Integer, Node> nodes;

	public AdjacencyListGraph(int numberOfNodes) {
		nodes = new Hashtable<Integer, Node>();
	}

	public AdjacencyListGraph() {
		nodes = new Hashtable<Integer, Node>();
	}

	@Override
	public void addEdge(long source, long destination, boolean biDirectional) {
		nodes.get(source).addEdge(new Edge(destination));
		numberOfEdges++;
		if (biDirectional) {
			nodes.get(destination).addEdge(new Edge(source));
			numberOfEdges++;
		}
	}

	@Override
	public void addEdge(long source, long destination, float cost, float distance, boolean biDirectional) {

		nodes.get(source).addEdge(new Edge(destination, cost, distance));
		numberOfEdges++;

		if (biDirectional) {
			nodes.get(destination).addEdge(new Edge(source, cost, distance));
			numberOfEdges++;

		}
	}

	@Override
	public void addNode(long nodeId, String nameNode, float lat, float lon) {
		Node n = new Node(nodeId, nameNode, lat, lon);
		nodes.put((int) nodeId, n);
		numberOfNodes++;
	}

	@Override
	public Node getNode(long nodeId) {

		return nodes.get(nodeId);

	}

	@Override
	public List<Edge> getEdges(long nodeId) {
		return (List<Edge>) (nodes.get(nodeId).getEdges() == null ? Collections.emptyList()
				: nodes.get(nodeId).getEdges());

	}

	@Override
	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	@Override
	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	@Override
	public Hashtable<Integer, Node> getNodes() {
		return nodes;
	}

}
