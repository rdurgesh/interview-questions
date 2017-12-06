package com.java.interview.example;

public class BinarySearchTree {
	public static void main(String[] args) {
		Node node = new Node(10);
		node.insert(5);
		node.insert(11);
		node.printInOrder();
		System.out.println("Contains the node : " + node.contains(4));
		System.out.println("Is Binary Search Tree : " + checkBST(node));
	}

	static boolean checkBST(Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}
}

class Node {

	Node left, right;

	int data;

	public Node(int data) {
		this.data = data;
	}

	public void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}
	}

	public boolean contains(int value) {
		if (value == data) {
			return true;
		} else if (value < data) {
			if (left == null) {
				return false;
			} else {
				return left.contains(value);
			}
		} else if (right == null) {
			return false;
		} else {
			right.contains(value);
		}
		return false;
	}

	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.println("Node :=> " + data);
		if (right != null) {
			right.printInOrder();
		}
	}

}
