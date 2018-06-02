package com.mine.practice.graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {
	private Set<Node> nodes;
	private Set<Edge> edges;
	public Graph(){
		this.nodes=new HashSet<Node>();
		this.edges=new HashSet<Edge>();
	}
	
	public void addNode(String nodeValue) {
		Node newNode=new Node(nodeValue);
		this.nodes.add(newNode);
	}
	
	public void addEdge(String edgeValue,String from_NodeVal, String to_NodeVal) {
		Node from_Node=this.nodes.stream().
				filter(n->from_NodeVal.equals(n.getName())).findAny().orElse(null);
		if(from_Node==null) {
			from_Node=new Node(from_NodeVal);
			this.nodes.add(from_Node);
		}
		
		Node to_Node= this.nodes.stream().
				filter(n->to_NodeVal.equals(n.getName())).findAny().orElse(null);
		if(to_Node==null) {
			to_Node=new Node(to_NodeVal);
			this.nodes.add(to_Node);
		}
		
		Edge newEdge=new Edge(edgeValue,from_Node,to_Node);
		
		this.edges.add(newEdge);
		from_Node.addEdge(newEdge);
		//to_Node.addEdge(newEdge);		
	}
	
	public List<Edge> getEdgeList(){
		return this.edges.stream().collect(Collectors.toCollection(ArrayList::new));
	}
	
	public List<Map<String,String>> getAdjacencyList() {
		List<Node> listNodes=this.nodes.stream().collect(Collectors.toCollection(ArrayList::new));
		listNodes.sort((Node obj1,Node obj2)->Integer.parseInt(obj1.getName())-Integer.parseInt(obj2.getName()));
		
		List<Map<String,String>> result= new ArrayList<Map<String,String>>();
		
		for(Node n:listNodes) {
			int listIndex=Integer.parseInt(n.getName())-1;
			Map<String,String> adjusentList= new HashMap<String,String>();
			for(Edge e:n.getEdges()) {
				adjusentList.put(e.getTo_Node().getName(), e.getEdgeValue());
			}
			result.add(listIndex,adjusentList);			
		}
		return result;
	}
	
	public int[][] getAdjacentMatrix(){
		List<Node> listNodes=this.nodes.stream().collect(Collectors.toCollection(ArrayList::new));
		listNodes.sort((Node obj1,Node obj2)->Integer.parseInt(obj1.getName())-Integer.parseInt(obj2.getName()));
		
		int[][] result= new int[listNodes.size()+1][listNodes.size()+1];
		
		for(Edge e:this.edges) {
			int i=Integer.parseInt(e.getFrom_Node().getName());
			int j=Integer.parseInt(e.getTo_Node().getName());
			result[i][j]=1;			
		}
		
		return result;
	}
	
	
}
