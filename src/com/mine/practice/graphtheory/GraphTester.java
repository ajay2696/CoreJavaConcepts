package com.mine.practice.graphtheory;

import java.util.List;
import java.util.Map;

public class GraphTester {

	public static void main(String[] args) {
		Graph graph= new Graph();
		
		graph.addEdge("100", "1", "2");
		graph.addEdge("101", "1", "3");
		graph.addEdge("103", "1", "4");
		graph.addEdge("104", "3", "4");
		
		
		graph.getEdgeList().
			forEach((e)->
				{System.out.println(e.getEdgeValue()+"--"+
						e.getFrom_Node().getName()+"---"+
							e.getTo_Node().getName());});
		List<Map<String,String>> adjustmentList= graph.getAdjacencyList();
		
		for(int i=0;i<adjustmentList.size();i++) {
			System.out.println(" Index Of the Node"+i);
			Map<String,String> resultMap= adjustmentList.get(i);
			if(resultMap!=null) {
				resultMap.entrySet().forEach((e)->{System.out.println(e.getKey()+"--"+e.getValue());});
			}
		}
		
	  int[][] adjusentMatrix =graph.getAdjacentMatrix();
	  
	  for(int i=0;i<adjusentMatrix.length;i++) {
		  for(int j=0;j<adjusentMatrix[i].length;j++) {
			  System.out.print(adjusentMatrix[i][j]+"--");
		  }
		  System.out.println();
	  }
		
		
	}

}
