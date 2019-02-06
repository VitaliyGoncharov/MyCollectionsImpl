package com.vitgon.collections.tree.binary;

public class TreeTest {
	public static void main(String... args) {
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.add(8);
		binaryTree.add(2);
		binaryTree.add(17);
		
		System.out.println(binaryTree);
		
		System.out.println(binaryTree.containsNode(3));
		System.out.println(binaryTree.containsNode(17));
	}
}
