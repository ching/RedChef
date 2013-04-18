package forProducts;

import java.text.NumberFormat;
import java.util.Locale;

public class LineItem{

	private Cake cake; //cake object
	private String name; //name of cake object
	private String message; //message of cake object
	private int quantity; //number of cake objects

	public LineItem(Cake theCake, int theQuantity, 
			String theName, String theMessage){
		this.cake = theCake;
		this.message = theMessage;
		this.quantity = theQuantity;
		this.name = theName;
	}//4-parameter constructor
	
	public String getName() {
		return name;
	}//getName method

	public void setName(String theName) {
		this.name = theName;
	}//setName method
	
	public String getMessage() {
		return message;
	}//getMessage method

	public void setMessage(String theMessage) {
		this.message = theMessage;
	}//setMessage method

	public int getQuantity() {
		return quantity;
	}//getQuantity method

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}//setQuantity method
	
	public Cake getCake(){
		return cake;
	}//getCake method
	
	public void setCake(Cake theCake){
		this.cake = theCake;
	}//setCake method
	
	public double calculateCost(){
		return quantity * cake.getCost();
	}//calculateCost method
	
	public String costToCurrency(){
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		String formattedCost = formatter.format(this.calculateCost());
		return formattedCost;
	}//costToCurrency method

	public String toString(){
		String toReturn;
		if(message!=null){
			toReturn = "You ordered " + getQuantity() + " cake(s)."
				+ "\n\nThe message that will appear on your cake is:\n\n " + message + ".\n\n"
				+ "The total cost of your order is " + this.calculateCost() + ".\n\n"
				+  "Your product ID is " + cake.getProductID();
		}else {
			toReturn = "You ordered " + getQuantity() + " cake(s)."
				+ "\n\nYour cake(s) contain(s) no message." + "\n\n" 
				+ "The total cost of your order is: " + this.calculateCost() + ".\n\n"
				+  "Your product ID is " + cake.getProductID();
		}//else
		return toReturn;
	}//toString method

}//LineItem class
