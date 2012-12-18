package com.ibm.fp.java.patternmatching;

public abstract class UnaryExpression implements Expression {
	
	private final Expression value;
	
	public UnaryExpression(Expression value) {
		this.value = value;
	}
	
	public Expression getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.getValue() + ")";
	}
	
}
