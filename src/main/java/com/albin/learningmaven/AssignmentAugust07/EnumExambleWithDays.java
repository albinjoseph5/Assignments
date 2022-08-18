package com.albin.learningmaven.AssignmentAugust07;

public class EnumExambleWithDays {
	Day day;

	// Constructor
	public EnumExambleWithDays(Day day) {
		this.day = day;
	}

	// Prints a line about Day using switch
	public void dayIsLike() {
		switch (day) {
		case MONDAY:
			System.out.println("The first day of the week.");
			break;
		case SUNDAY:
			System.out.println("The last day of the week");
			break;
		default:
			System.out.println("Midweek days.");
			break;
		}
	}

	// Driver method
	public static void main(String[] args) {
		String str = "TUESDAY";
		EnumExambleWithDays t1 = new EnumExambleWithDays(Day.valueOf(str));
		t1.dayIsLike();
	}
}
