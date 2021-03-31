package edu.bu.main;

import java.util.Hashtable;
import java.util.List;

public interface Graph {
	public void addEdge(long source, long destination, boolean biDirectional);

	public void addEdge(long source, long destination, float cost, float distance, boolean biDirectional);

	public void addNode(long nodeId, String nameNode, float lat, float lon);

	public Node getNode(long nodeId);

	public List<Edge> getEdges(long nodeId);

	int getNumberOfNodes();

	int getNumberOfEdges();

	Hashtable<Integer, Node> getNodes();

}