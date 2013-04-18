package forProducts;

public class Food {

	private double cost; //price of food
	private String productID; //productID for food

	public Food(String theProductID, double theCost) {
		this.cost = theCost;
		this.productID = theProductID;
	}//Food constructor

	public double getCost() {
		return cost;
	}//cost access method

	public void setCost(double theCost) {
		this.cost = theCost;
	}//setCost method
	
	public String getProductID(){
		return productID;
	}//getProductID method
	
	public void setProductID(String theProductID){
		this.productID = theProductID;
	}//setProductID method

	public String toString(){
		String toReturn;
		toReturn = "The total cost of your order is " + getCost() + "\n\n" 
				+ "Your product ID is " + getProductID();
		return toReturn;
	}//toString method

}//Food class


