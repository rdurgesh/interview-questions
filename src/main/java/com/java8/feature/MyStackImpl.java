package com.java8.feature;

public class MyStackImpl {

	private int stackSize;
	private int[] stackArr;
	private int top;

	public MyStackImpl(int stackSize) {
		this.stackSize = stackSize;
		this.stackArr = new int[stackSize];
		this.top = -1;
	}

	public void push(int entry) throws StackOverFlowException {
		if (this.isStackFull()) {
			throw new StackOverFlowException("Stack is already full. Can not add element.");
		}
		System.out.println("Adding: " + entry);
		this.stackArr[++top] = entry;
	}

	public int pop() throws StackUnderFlowException {
		if (this.isStackEmpty()) {
			throw new StackUnderFlowException("Stack is empty. Can not remove element.");
		}
		int entry = this.stackArr[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}

	public int peek() {
		return stackArr[top];
	}

	public boolean isStackEmpty() {
		return (top == -1);
	}

	public boolean isStackFull() {
		return (top == stackSize - 1);
	}

	public static void main(String[] args) {
		MyStackImpl myStack = new MyStackImpl(5);
		try {
			myStack.push(4);
			myStack.push(8);
			myStack.push(3);
			myStack.push(89);
			myStack.push(34);
			myStack.push(45);
			myStack.push(78);
		} catch (StackOverFlowException e) {
			e.printStackTrace();
		}
		try {
			myStack.pop();
			myStack.pop();
			myStack.pop();
			myStack.pop();
			myStack.pop();
			myStack.pop();
		} catch (StackUnderFlowException e) {
			e.printStackTrace();
		}
	}
}
