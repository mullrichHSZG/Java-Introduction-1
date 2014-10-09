/**
 * 
 */
package de.hszg.ws14.labtask1;

/**
 * @author Markus Ullrich
 *
 */
public class ComputeArea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Create the radius and area variable
		double radius = 0.0;
		double area;
		
		//Initialize the radius variable with a value of 20.0
		String radiusString = null;
		try{
			radiusString = args[0];
			radius = Double.parseDouble(radiusString);	
		}catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("Please provide a radius when running this program!");
			return;
		}catch(NumberFormatException ex){
			System.out.println("The radius shoud be a number, e.g. \"20\"");
			return;
		}
		
		//Calculate the area while initializing the area variable
		area = radius * radius * 3.14159;
		
		//Print the results to the console using the 'out' object from the 'System' class.
		System.out.println("The area for a circle of radius " + radius + " is " + area);
	}

}
