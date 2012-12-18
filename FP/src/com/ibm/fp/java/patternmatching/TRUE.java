package com.ibm.fp.java.patternmatching;

public class TRUE implements Expression {

	private static TRUE instance;
	
	private TRUE() {
		
	}
	
	public static TRUE getInstance() {
		if (instance == null) {
			instance = new TRUE();
		}
		
		return instance;
	}
	
	@Override
	public String toString() {
		return "TRUE";
	}
	
}
