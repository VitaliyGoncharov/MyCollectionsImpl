package com.vitgon.collections.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	Node rootNode;
	
	Tree(Object value) {
		rootNode = new Node(value);
	}
	
	private class Node {
		Object value;
		List<Node> children;
		
		Node(Object value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", children=" + children + "]";
		}
	}

	@Override
	public String toString() {
		return "DayTree [rootNode=" + rootNode + "]";
	}
	
	public void add(Object... args) {
		List<Node> nodesLvl1 = rootNode.children;
		
		if (nodesLvl1 == null) {
			nodesLvl1 = new ArrayList<>();
		}
		
		for (Object value : args) {
			nodesLvl1.add(new Node(value));
		}
		
		rootNode.children = nodesLvl1;
	}
	
	public void add(Object lvl1Value, Object lvl2Value, Object lvl3Value) {
		System.out.println("My add() method");
		
		List<Node> nodesLvl1 = rootNode.children;
		List<Node> nodesLvl2 = null;
		List<Node> nodesLvl3 = null;
		
		if (nodesLvl1 == null) {
			nodesLvl1 = new ArrayList<>();
			nodesLvl2 = new ArrayList<>();
			nodesLvl3 = new ArrayList<>();
			
			Node nodeLvl1 = new Node(lvl1Value);
			Node nodeLvl2 = new Node(lvl2Value);
			Node nodeLvl3 = new Node(lvl3Value);
			
			// add scheduleDTO node to empty list and set as a child for week level
			nodesLvl3.add(nodeLvl3);
			nodeLvl2.children = nodesLvl3;
			
			// add week node to empty list and set as a child for lessonNumber level
			nodesLvl2.add(nodeLvl2);
			nodeLvl1.children = nodesLvl2;
			
			// add lessonNumber node to empty list and set as a child for rootNode
			nodesLvl1.add(nodeLvl1);
			rootNode.children = nodesLvl1;
		}
	}
}

