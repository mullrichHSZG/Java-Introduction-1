package de.hszg.ws14.labtask1;

public class FractionMath {

	/**
	 * This method adds one fraction to another.
	 * @param a - the first fraction
	 * @param b - the second fraction
	 * @return fraction a plus fraction b
	 */
	public static Fraction add(Fraction a, Fraction b){
		//Because the normalize() function requires an array of Fractions, we need to create this array first.
		//Since we only have two objects, the length of the array will be two as well.
		//Arrays are created using square brackets '[]' after the object or data type.
		//It would also be possible to create an int[] for example.
		//When we initialize the array with 'new Fraction[]' we have two options. The first one you can see here.
		//We used curly brackets and added the objects belonging to this array in between, separated by a comma.
		//Another option is, to write the length of the array in between the square brackets '[2]'.
		//And then to add the objects by using the index for a specific field in the array.
		//fracArray[0] = a;
		//fracArray[1] = b;
		//The index starts with 0 and not with 1.
		//So an array with length 2 will have the indices 0 and 1, an array with length 4 will have the indices 0 to 3.
		Fraction[] fracArray = new Fraction[2];
		fracArray[0] = a;
		fracArray[1] = b;
		//We get a new array which contains the normalized fractions.
		Fraction[] norm = FractionMath.normalize(fracArray);
		//We can access the numerators from a Fraction in this area directly by accessing the fraction via it's index.
		//Here we just need to add the numerators for the new fraction.
		int newNumerator = norm[0].getNumerator() + norm[1].getNumerator();
		//Since the denominator has been normalized, it stays the same so we can use any fraction of the normalized array.
		//That means 'norm[1].getDenominator()' would work as well.
		Fraction addedFraction = new Fraction(newNumerator, norm[0].getDenominator());
		return addedFraction;
	}
	
	/**
	 * The sub method works just like the add method, but with subtracting the second numerator from the first on instead.
	 * @param a - the first fraction
	 * @param b - the second fraction
	 * @return fraction a minus fraction b
	 */
	public static Fraction sub(Fraction a, Fraction b){
		Fraction[] fracArray = new Fraction[]{a,b};
		Fraction[] norm = FractionMath.normalize(fracArray);
		int newNumerator = norm[0].getNumerator()-norm[1].getNumerator();
		return new Fraction(newNumerator, norm[0].getDenominator());
	}
	
	/**
	 * For the multiplication, we just need to multiply the numerators and the denominators with each other.
	 * @param a - the first fraction
	 * @param b - the second fraction
	 * @return fraction a multiplied with fraction b
	 */
	public static Fraction mul(Fraction a, Fraction b){
		int newNum = a.getNumerator()*b.getNumerator();
		int newDen = a.getDenominator()*b.getDenominator();
		return new Fraction(newNum, newDen);
	}
	
	/**
	 * The division works exactly like the multiplication except the divisor needs to be reversed. 
	 * @param a - the first fraction
	 * @param b - the second fraction
	 * @return fraction a divided by fraction b
	 */
	public static Fraction div(Fraction a, Fraction b){
		Fraction bRev = new Fraction(b.getDenominator(), b.getNumerator());
		//We can reuse the mul method here, so we do not need to rewrite it.
		return FractionMath.mul(a, bRev);
	}

	/**
	 * This method normalizes the given fractions which are stored in the fractions array.
	 * @param fractions - a number of fractions
	 * @return - an array with the normalized fractions
	 */
	private static Fraction[] normalize(Fraction[] fractions) {
		//A boolean variable can hold either true or false.
		//First we assume, that the fractions are normalized.
		boolean allDenEqual = true;
		//We need the first denominator to compare it with the ones from the other fractions.
		int normDen = fractions[0].getDenominator();
		//This is an easy way of creating a for-loop.
		//This line means: "Do the following (everything in the curly brackets after it) for all the Fractions 'f' in the fractions array."
		for(Fraction f : fractions){
			//The if statement checks a condition, so the statement inside the brackets must return true or false
			//allDenEqual is a boolean, so it can only return true or false
			//'normDen == f.getDenominator' checks if the normalized Denominator equals the one from the current fraction f.
			//This statement returns also true or false so it can be connected to the other statement, which is just the boolean variable.
			//We use a logical 'and' operator for that because both conditions must be true. In Java that is the '&&' operator.
			if(allDenEqual && normDen == f.getDenominator()){
				//Nothing to do here because the denominators of the fractions before were equal which is indicated by 'allDenEqual' being true.
			//The else statement is used after an if statement. Everything that follows the else statement in the curly brackets
			//will be executed if the above expression (allDenEqual && normDen == f.getDenominator()) returns false.
			} else {
				//We correct the normalized denominator by multiplying it with the current denominator.
				//This is a short version of 'normDen = normDen * f.getDenominator();'
				normDen *= f.getDenominator();
				//We set allDenEqual false, to indicate that we need to create a new array with normalized fractions.
				allDenEqual = false;
			}
		}
		//If we only have one other statement after an if or else statement or in a loop, we do not have to use brackets around it.
		//However, it is not a good practice to do that in the beginning, so we add brackets here as well.
		if(allDenEqual){
			return fractions;
		}
		//We do not need an else statement here, because the return statement after the 'if' exits the method.
		//Thus, the following code will not be executed in that case anyway.
		//Only if 'allDenEqual' is false in which case the above return statement is not executed.
		
		//Now we create an array with the same length as the original array.
		//We can get the length of an array simply by accessing the 'length' variable of it.
		Fraction[] normFracs = new Fraction[fractions.length];
		//This for-loop uses the index of an element in an array to go through it.
		//If we do not have a variable for the index yet, we need to initialize it first: 'int index = 0'
		//After that, we add our criteria for staying in this loop: 'index < fractions.length'
		//Since that would result in an endless loop if the index does not change we declare how to change it in the last part: 'index++'
		//Now the index will be incremented by one after each loop.
		//So basically this statement means: Create an index that starts with zero, if the index is smaller than the length of the array
		//do the following and increment the index by one after that, otherwise exit the loop.
		for(int index = 0 ; index < fractions.length ; index++){
			//Now we just need to calculate the new numerator based on the normalized denominator.
			int num = fractions[index].getNumerator();
			int den = fractions[index].getDenominator();
			int normNum = num * (normDen / den);
			//And we add a normalized Fraction object to the new array that has the same index as the un-normalized one from the other array.
			normFracs[index] = new Fraction(normNum, normDen);
		}
		return normFracs;
	}
	
}
