package com.ibm.fp.java;

import java.util.ArrayList;
import java.util.List;

import scala.actors.threadpool.Arrays;

public class ListReverse {

	public static void main(String[] args) {

		List<String> a = new ArrayList<String>();
		a.add("A");
		a.add("B");
		a.add("C");
		System.out.println(a);

		String[] arr = { "A", "B", "C" };
		List<?> b = Arrays.asList(arr);
		System.out.println(b);

		System.out.println(a.equals(b));
		System.out.println(a == b);
		
		System.out.println("a reverse : " + reverse(a));
		System.out.println("b reverse : " + reverse(b));
		System.out.println("empty list reverse : " + reverse(new ArrayList<String>()));

		System.out.println(reverse(a).equals(reverse(b)));

	}

	public static <A> List<A> reverse(List<A> list) {
		List<A> result = new ArrayList<A>(list.size());
		for (A a : list)
			result.add(0, a);
		return result;
	}

}
