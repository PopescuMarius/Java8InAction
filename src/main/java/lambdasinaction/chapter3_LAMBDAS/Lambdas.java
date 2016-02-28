package lambdasinaction.chapter3_LAMBDAS;

import java.util.*;

public class Lambdas {
	public static void main(String ...args){

		// Simple example
		Runnable r = () -> System.out.println("Hello!");
		r.run();

		// Filtering with lambdas
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]	
		//IT is the same as using an anonymous class that implements that interface but using lambda I only care about the
		//parameters and return. So I need an APPLE as parameter and a return of BOOLEAN.
		List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
		System.out.println("with lambda :" + greenApples);


		Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

		// [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
		inventory.sort(c);
		System.out.println(inventory);
	}

	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		//for this argument(apple) my lambda will return a boolean. It respects the contract of the interface, it doesn't care about the
		// naming of the function :) just the argument and the return. If you change this it will not compile :)
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}   

	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}

	//this is a functional interface. if you add another method then you won't be able to use the lambda.
	//You cah use the annotation FunctionalInterface (the same principle as @Override)
	interface ApplePredicate{
		public boolean test(Apple a);
	}
}