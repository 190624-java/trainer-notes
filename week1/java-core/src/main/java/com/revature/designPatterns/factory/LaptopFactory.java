package com.revature.designPatterns.factory;
/*
 * Factory Design Pattern
 * - the factory handles object creation logic while providing
 * an interface for the client. (client is any code that may
 * be accessing/instantiating/utilizing these objects)
 * - maintains a layer of abstraction when working with complex
 * instantiation logic.
 * - major benefit is being able to abstract away what object
 * the client is actually working with. -> allows for much 
 * looser coupling.
 * 
 * loose coupling = good
 * tight coupling = bad
 * 
 * Practical Example:
 * Calendar calendar = Calendar.getInstance();
 * this is better than:
 * Calendar cal = new GregorianCalendar();
 * because what is Oracle decides that they don't like 
 * Gregorian Calendar anymore, so they want to change it.
 * You would now have to change your code as well.
 */
public class LaptopFactory {

	//one common approach
	public static Laptop getLaptop(String type) {
		switch(type) {
		case "Lenovo":
			return new ThinkPad();
		case "HP":
			//return new Envy();
			return new Pavilion();
		default:
			return new Laptop() {
				@Override
				public void startUp() {
					System.out.println("Generic Laptop Start Up");
				}
			};
		}
	}//end of getLaptop method
	
	//another common approach
	public static Laptop getHPLaptop() {
		return new Pavilion();
	}
	
	public static Laptop getLenovoLaptop() {
		return new ThinkPad();
	}
	
}
