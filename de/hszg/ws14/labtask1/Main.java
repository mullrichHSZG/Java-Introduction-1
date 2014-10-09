package de.hszg.ws14.labtask1;

public class Main {

	public static void main(String[] args) {
		//First we create some fractions, we want to perform math operations on.
		FractionCreatorGUI gui = new FractionCreatorGUI();
		Fraction f1 = new Fraction(11,3);
		Fraction f2 = new Fraction(7,4);
		Fraction f3 = new Fraction(10,17);
		Fraction f4 = new Fraction(7,3);
		Fraction f5 = new Fraction(5,9);
		Fraction f6 = new Fraction(6,23);
		Fraction f7 = new Fraction(1,8);
		Fraction f8 = new Fraction(8,2);
		Fraction f9 = new Fraction(2,4);
		Fraction f10 = new Fraction(1,3);
		Fraction f11 = new Fraction(9,12);
		//Then we solve the given equations and print the results so that they look pleasant.
		System.out.println(f1 + " + " + f2 + " = " + FractionMath.add(f1, f2));
		System.out.println(f3 + " - " + f4 + " = " + FractionMath.sub(f3, f4));
		System.out.println(f5 + " * " + f6 + " = " + FractionMath.mul(f5, f6));
		System.out.println(f7 + " / " + f8 + " = " + FractionMath.div(f7, f8));
		//For the last equation we need to add the first two fractions first and then we can subtract the third fraction.
		//We can use another variable to save the result from the addition.
		Fraction added = FractionMath.add(f9, f10);
		System.out.println(f9 + " + " + f10 + " - " + f11 + " = " + FractionMath.sub(added,f11));
		//Or we can chain the calls of the add and sub methods.
		//The inner brackets always will be executed first, which is the add method.
		System.out.println(f9 + " + " + f10 + " - " + f11 + " = " + FractionMath.sub(FractionMath.add(f9, f10), f11));
	}

}
