package com.vitgon.collections.tree;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public void add(Object[] path, Object object) {
		List<Object> mutablePathList = new ArrayList<>(Arrays.asList(path));
		rootNode.children = addRecursive(rootNode.children, mutablePathList, object);
	}
	
	public List<Node> addRecursive(List<Node> nodesList, List<Object> path, Object value) {
		if (nodesList == null) {
			nodesList = new ArrayList<>();
		}
		
		Node newNodeForLevel = null;
		
		// if we on the last node we need just to create node with [Object value]
		if (path.size() == 0) {
			return addValue(nodesList, value);
		}
		
		// create node with value provided in path
		newNodeForLevel = new Node(path.get(0));
		// remove value that we used to create node
		path.remove(0);
		// add new node with next path to children of current node
		newNodeForLevel.children = addRecursive(newNodeForLevel.children, path, value);
		// add current node with generated children to parent node children list
		nodesList.add(newNodeForLevel);
		
		return nodesList;
	}
	
	public List<Node> addValue(List<Node> nodesList, Object value) {
		Node nodeWithValue = new Node(value);
		nodesList.add(nodeWithValue);
		return nodesList;
	}
}

