package edu.bu.main;

public class SearchNode {
	long nodeId;
	float cost;
	long parent;
	boolean settled;

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public long getParent() {
		return parent;
	}

	public void setParent(long parent) {
		this.parent = parent;
	}

	public boolean isSettled() {
		return settled;
	}

	public void setSettled(boolean settled) {
		this.settled = settled;
	}


	public SearchNode(long nodeId, float cost) {
		this.nodeId = nodeId;
		this.cost = cost;

	}

}