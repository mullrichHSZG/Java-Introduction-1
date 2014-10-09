/**
 * 
 */
package de.hszg.ws14.labtask1;

/**
 * @author Markus Ullrich
 *
 */
public class Fraction {

	//We need to declare those variables as private because we do not want direct access to them.
	private int numerator;
	private int denominator;

	/**
	 * @param numerator
	 * @param denominator
	 */
	public Fraction(int numerator, int denominator) {
		super();
		//This constructor creates a new Fraction object and initializes the numerator and denominator as well,
		//using the two values it receives when called.
		//The key word 'this' is used to specifically access the variables of this object which is created at that point.
		//We need that key word here since the variables the constructor receives have the same name as the ones belonging to the object.
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * The variables have to be accessed via the getter and setter methods instead.
	 * By doing that, we can add additional logic to the setter for example, to prevent illegal values.
	 * @return the numerator
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * @param numerator the numerator to set
	 */
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	/**
	 * @return the denominator
	 */
	public int getDenominator() {
		return denominator;
	}

	/**
	 * @param denominator the denominator to set
	 */
	public void setDenominator(int denominator) {
		//By using the setter method to access the variable, we can check if the denominator is greater than zero.
		if(denominator > 0)
			this.denominator = denominator;
		else
			//do not set the denominator
			return;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result + numerator;
		return result;
	}

	/* This method is used to check if two objects of this class are equal.
	 * You can use it like this:
	 * Fraction a = new Fraction(1,3);
	 * Fraction b = new Fraction(1,3);
	 * if(a.equals(b))
	 * 	System.out.println("Fraction a equals fraction b.");
	 * else
	 * 	System.out.println("Fraction a does not equal fraction b.") 
	 * @see java.lang.Object#equals(java.lang.Object) for details.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//We changed the output of this method to create something that looks more like a real fraction.
		//We simply concatenate the numerator, a slash sign and the denominator with each other.
		return numerator + "/" + denominator;
	}
	
	
	
}
