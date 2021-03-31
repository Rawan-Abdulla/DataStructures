package edu.bu.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
	private long nodeId;
	private String nameNode;
	private float lat;
	private float lon;
	private List<Edge> edges;

	public Node(long nodeId, String nameNode, float lat, float lon) {
		edges = new ArrayList<Edge>();

		this.nodeId = nodeId;
		this.nameNode = nameNode;
		this.lat = lat;
		this.lon = lon;

	}

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public String getNameNode() {
		return nameNode;
	}

	public void setNameNode(String nameNode) {
		this.nameNode = nameNode;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public List<Edge> getEdges() {
		return (List<Edge>) (edges == null ? Collections.emptyList() : edges);
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public void addEdge(Edge edge) {

		edges.add(edge);
	}

	public List<Edge> getEdges(int nodeId) {
		return edges;
	}
}
