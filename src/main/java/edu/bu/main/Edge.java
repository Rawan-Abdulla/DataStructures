package edu.bu.main;

public class Edge {
	private long destinationNodeId;
	private String name;
	private float cost;
	private float distance;

	public Edge(long destinationNodeId, float cost, float distance) {
		super();
		this.destinationNodeId = destinationNodeId;
		this.cost = cost;
		this.distance = distance;
	}

	public Edge(long destinationNodeIdd) {
		this.destinationNodeId = destinationNodeIdd;
	}

	public long getDestinationNodeId() {
		return destinationNodeId;
	}

	public void setDestinationNodeId(long destinationNodeId) {
		this.destinationNodeId = destinationNodeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Edge [destinationNodeId=" + destinationNodeId + ", name=" + name + ", cost=" + cost + ", distance="
				+ distance + "]";
	}


}

