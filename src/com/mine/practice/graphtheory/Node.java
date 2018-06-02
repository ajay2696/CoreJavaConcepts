package com.mine.practice.graphtheory;

import java.util.HashSet;
import java.util.Set;

public class Node {
	private String name;
	   private Set<Edge> edges=new HashSet<Edge>();
	   Node(String name){
		   this.name=name;
	   }
	   public void addEdge(Edge edge) {
		   edges.add(edge);
	   }
	   
	   public String getName() {
		   return name;
	   }
		public Set<Edge> getEdges() {
		   return edges;
	   }
	   
	   @Override
	   public int hashCode() {
		   return this.name.hashCode();
	   }
	   @Override
	   public boolean equals(Object obj) {
		    Node node=(Node)obj;
		    if(this.getName().equals(node.getName())) {
		    	return true;
		    } else {
		    	return false;
		    }
	   }


}
