package com.mine.practice.graphtheory;

public class Edge {

	   private String edgeValue;
	   private Node from_Node;
	   private Node to_Node;   

		Edge(String edgeValue,Node from_Node, Node to_Node){
			   this.edgeValue =edgeValue;
			   this.from_Node =from_Node;
			   this.to_Node =to_Node;
		}
	   
	    public String getEdgeValue() {
	    	return edgeValue;
		}
		public Node getFrom_Node() {
			return from_Node;
		}
		public Node getTo_Node() {
			return to_Node;
		}	
	   @Override
	   public int hashCode() {
		return edgeValue.hashCode();	   
	   }
	   @Override
	   public boolean equals(Object obj) {
		   Edge edgeObj=(Edge)obj;
		   //Grpah is two Dimensional
		   if((edgeObj.getFrom_Node().getName().equals(this.getFrom_Node().getName()) && 
				   edgeObj.getTo_Node().getName().equals(this.getTo_Node().getName())) ||
				   (edgeObj.getFrom_Node().getName().equals(this.getTo_Node().getName()) && 
						   edgeObj.getTo_Node().getName().equals(this.getFrom_Node().getName())
			)) {
			   return true;
		   } else {
			   return false;
		   }
	   }
	 
}
