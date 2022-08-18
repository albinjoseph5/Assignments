package com.albin.learningmaven.AssignmentAugust07;

public class SingletonExamble {
//	In Java, Singleton is a design pattern that ensures that a class can only have one object.
//
//	To create a singleton class, a class must implement the following properties:
//
//	1.Create a private constructor of the class to restrict object creation outside of the class.
//	2.Create a private attribute of the class type that refers to the single object.
//	3.Create a public static method that allows us to create and access the object we created. 
//	Inside the method, we will create a condition that restricts us from creating more than one object.

	// private field that refers to the object
	private static SingletonExamble singleObject;

	private SingletonExamble() {
		// constructor of the SingletonExample class
	}

	public static SingletonExamble getInstance() {
		// access the object as per our need
		if (singleObject == null) {
			singleObject = new SingletonExamble();
		}
		return singleObject;
	}

	public static void main(String[] args) {
		SingletonExamble db1;

		// refers to the only object of Database
		db1 = SingletonExamble.getInstance();
	}
}
