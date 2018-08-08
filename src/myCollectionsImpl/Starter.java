package myCollectionsImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Starter {
	private static int size;
	public static void main(String[] args) {
		
		Stack<Person> myStack = new Stack<>();
		myStack.push(new Person("David",24));
		myStack.push(new Person("Houston",29));
		myStack.push(new Person("Lary",25));
		
		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}
		
		ArrayList<Person> arr1 = new ArrayList<>();
		arr1.add(new Person("John",34));
		arr1.add(new Person("Mike",19));
		arr1.add(new Person("Jane",18));
		
		System.out.println("\nIteration :: simple one");
		for (Person p : arr1) {
			System.out.println(p);
		}
		
		arr1.remove(1);
		
		System.out.println("\nIteration :: hard one [Deleted the element at 1 position]");
		Iterator<Person> itr = arr1.iterator();
		System.out.println(itr.next());
		System.out.println(itr.next());
	}
}

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
