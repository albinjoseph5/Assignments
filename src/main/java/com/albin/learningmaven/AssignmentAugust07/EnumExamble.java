package com.albin.learningmaven.AssignmentAugust07;

enum Color {
	RED, GREEN, BLUE;
}
/* internally above enum Color is converted to
class Color
{
     public static final Color RED = new Color();
     public static final Color BLUE = new Color();
     public static final Color GREEN = new Color();
}*/

public class EnumExamble {
//	Enumerations serve the purpose of representing a group of named constants in a programming language.
	public static void main(String[] args) {
		Color c1 = Color.RED;
		System.out.println(c1);
	}
}
