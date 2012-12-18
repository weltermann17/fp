package com.ibm.fp.java.patternmatching;

public class PatternMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PatternMatching();
	}
	
	private final Expression a = new NOT(new AND(TRUE.getInstance(), new NOT(new OR(FALSE.getInstance(), TRUE.getInstance()))));
	
	public PatternMatching() {
		System.out.println("a = " + a);
		System.out.println("eval(a) = " + eval(a));
	}
	
	private boolean eval(Expression e) {
		if (e instanceof AND) {
			AND and = (AND) e;
			return eval(and.getLeft()) && eval(and.getRight());
		} else if (e instanceof OR) {
			OR or = (OR) e;
			return eval(or.getLeft()) || eval(or.getRight());
		} else if (e instanceof NOT) {
			return !eval(((NOT) e).getValue());
		} else if (e == TRUE.getInstance()) {
			return true;
		} else if (e == FALSE.getInstance()) {
			return false;
		} else {
			throw new IllegalArgumentException("Unknown Expression.");
		}
	}

}
