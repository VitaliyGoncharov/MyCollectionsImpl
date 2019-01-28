package com.vitgon.collections.tree;


public class TreeTest {
	public static void main(String... args) {
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.add(8);
		binaryTree.add(2);
		binaryTree.add(17);
		
		System.out.println(binaryTree);
	}
}
