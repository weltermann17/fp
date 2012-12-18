package com.ibm.fp.java.patternmatching;

public class FALSE implements Expression {

	private static FALSE instance;
	
	private FALSE() {
		
	}
	
	public static FALSE getInstance() {
		if (instance == null) {
			instance = new FALSE();
		}
		
		return instance;
	}
	
	@Override
	public String toString() {
		return "FALSE";
	}
	
}
