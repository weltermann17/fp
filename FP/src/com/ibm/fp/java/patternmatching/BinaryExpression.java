package com.ibm.fp.java.patternmatching;

public abstract class BinaryExpression implements Expression {

	private final Expression left;
	private final Expression right;
	
	public BinaryExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	public Expression getLeft() {
		return this.left;
	}
	
	public Expression getRight() {
		return this.right;
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.getLeft().toString() + "," + this.getRight().toString() + ")"; 
	}
}
