package controller;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha<T> {

	private Deque<T> stack;
	
	public Pilha() {
		stack = new ArrayDeque<>();
	}
	
	public void push(T elemento) {
		stack.push(elemento);
	}
	
	public T pop() {
		return stack.pop();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
}
