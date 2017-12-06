package com.java8.feature;

import java.lang.reflect.Array;

public class MyStackImpl<T> {

	private int stackSize;
	private T[] stackArr;
	private int top;

	public MyStackImpl(Class<T[]> clazz, int stackSize) {
		this.stackSize = stackSize;
		this.stackArr = clazz.cast(Array.newInstance(clazz.getComponentType(), stackSize));
		this.top = -1;
	}

	public void push(T entry) throws StackOverFlowException {
		if (this.isStackFull()) {
			throw new StackOverFlowException("Stack is already full. Can not add element");
		}
		System.out.println("Adding: " + entry);
		this.stackArr[++top] = entry;
	}

	public T pop() throws StackUnderFlowException {
		if (this.isStackEmpty()) {
			throw new StackUnderFlowException("Stack is empty. Can not remove element");
		}
		T entry = this.stackArr[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}

	public T peek() {
		return stackArr[top];
	}

	public boolean isStackEmpty() {
		return (top == -1);
	}

	public boolean isStackFull() {
		return (top == stackSize - 1);
	}

	public static void main(String[] args) {
		MyStackImpl<Integer> myStack = new MyStackImpl<Integer>(Integer[].class, 5);
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
