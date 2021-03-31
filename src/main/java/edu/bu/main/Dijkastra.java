//package edu.bu.main;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.Stack;
//
//public class Dijkastra {
//	private Comparator<SearchNode> comparator =new Comparator<SearchNode>() {
//		
//		@Override
//		public int compare(SearchNode a1, SearchNode a2) {
//			
//			return (int) (a1.cost-a2.cost);
//		}
//	};
//
//	
//	
//	PriorityQueue<SearchNode> pQueue = new PriorityQueue<SearchNode>(comparator);
//
//	static Hashtable<Long, SearchNode> visitedNode = new Hashtable<Long, SearchNode>();
//
//	public Path getShortestPath(Graph g, int source, int destination) {
//		SearchNode sourceSearchNode = new SearchNode(source, 0);
//		visitedNode.put((long) source, sourceSearchNode);
//		sourceSearchNode.setParent(-1);
//		pQueue.add(sourceSearchNode);
//		while (!pQueue.isEmpty()) {
//			SearchNode currNode = pQueue.poll();
//			if (currNode.nodeId == destination) {
//				//ShortestPath(currNode);
//				float b = currNode.cost;
//				return null;
//			}
//
//			if (currNode.isSettled() == true)
//				continue;
//			currNode.setSettled(true);
//			// if (visitedNode.get(currNode.nodeId).settled) {
//			List<Edge> edges = g.getEdges(currNode.nodeId);
//			for (Edge edge : edges) {
//				float newCost = currNode.cost + edge.getCost();
//				float edgeDesNodeId = edge.getDestinationNodeId();
//
//				SearchNode edgeDesSearchNode = visitedNode.get(edgeDesNodeId);
//				if (edgeDesSearchNode == null) {
//					edgeDesSearchNode = new SearchNode((long) edgeDesNodeId, newCost);
//					edgeDesSearchNode.setParent(currNode.nodeId);
//					visitedNode.put((long) edgeDesNodeId, edgeDesSearchNode);
//				} else if (newCost < edgeDesSearchNode.cost) {
//
//					edgeDesSearchNode.cost = newCost;
//					edgeDesSearchNode.setParent(currNode.nodeId);
//					pQueue.add(edgeDesSearchNode);
//
//				}
//				// }
//			}
//
//		}
//		return null;
//
//	}
//
//	public static Path ShortestPath(SearchNode node) {
//		Path path = new Path();
//		System.out.println("the path is : ");
//		ArrayList<Long> listPath =null;
//		Stack<SearchNode> searchNodes = new Stack<SearchNode>();
//
//		SearchNode sNode = node;
//		while (sNode != null) {
//			searchNodes.push(sNode);
//			sNode = visitedNode.get(sNode.getParent());
//
//		}
//		
//		while (!searchNodes.isEmpty()) {
//			listPath = searchNodes.pop().getNodeId();
//			System.out.println(searchNodes.pop().getNodeId());
//		}
//		path.setPathNodes(listPath);
//		return path;
//
//	}
//
//	}
