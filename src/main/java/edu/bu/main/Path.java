package edu.bu.main;

import java.util.ArrayList;
import java.util.List;

public class Path {
	private long cost;
	private List<Long> pathNodes;

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public List<Long> getPathNodes() {
		return pathNodes;
	}

	public void setPathNodes(List<Long> pathNodes) {
		this.pathNodes = pathNodes;
	}

	public Path() {
		pathNodes=new ArrayList<Long>();
		
	}
}
