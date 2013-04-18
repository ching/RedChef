package forProducts;

public class Cake extends Food{

	private String message; //message for the cake
	private String color; //color of the cake
	private String filling; //filling of the cake
	
	public Cake(String theColor, String theFilling, 
			String theProductID, double theCost){
		super(theProductID, theCost);
		this.message = "";
		this.color = theColor;
		this.filling = theFilling;
	}//Cake constructor without message
	
	public Cake(String theColor, String theFilling, String theMessage, 
			String theProductID, double theCost){
		super(theProductID, theCost);
		this.message = theMessage;
		this.color = theColor;
		this.filling = theFilling;
	}//Cake constructor with message
	
	public String getMessage() {
		return message;
	}//message access method

	public void setMessage(String message) {
		this.message = message;
	}//setMessage method

	public String getColor() {
		return color;
	}//color access method

	public void setColor(String color) {
		this.color = color;
	}//setColor method

	public String getFilling() {
		return filling;
	}//filling access method

	public void setFilling(String filling) {
		this.filling = filling;
	}//setFilling method

	public String toString(){
		String toReturn;
		if(message!=null){
			toReturn = "You ordered " + color +  " cake(s) with " + filling +" filling."
				+ "\n\nThe message that will appear on your cake is:\n\n " + message + ".\n\n"
				+ "The total cost of your order is " + getCost() + ".\n\n" 
				+ "Your product ID is " + getProductID() ;
		}else {
			toReturn = "You ordered  " + color +  " cake(s) with " + filling +" filling."
				+ "\n\nYour cake(s) contain(s) no message." + "\n\n" 
				+ "The total cost of your order is: " + getCost() + ".\n\n"
				+ "Your product ID is " + getProductID() ;
		}//else
		return toReturn;
	}//toString method
	
}//Cake class
