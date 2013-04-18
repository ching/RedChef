package forProducts;

import java.util.Hashtable;

public class ProductGenerator {
	
	private Hashtable<String, Cake> allCakes;
	
	public ProductGenerator() {
		allCakes = new Hashtable<String, Cake>();
		generateCakes();
	}//0-parameter constructor
	
	public Cake getCake(String theProductID){
		return allCakes.get(theProductID);
	}//getCake method
	
	private void generateCakes(){ 
		Cake assortedCake = new Cake("Rainbow", "Fruits", "Happy Birthday!", "IDforAssorted", 3.00);
		Cake chocoCreamCake = new Cake("Brown", "Cream", "IDforChocoCream", 4.00);
		Cake chocoCake = new Cake("Brown", "Chocolate", "Chocolatious", "IDforChoco", 3.50);
		Cake roseCake = new Cake("Red", "Rose", "Happy Anniversary!", "IDforRose", 6.00);
		Cake mangoMousseCake = new Cake("Yellow", "Mango", "IDforMangoMousse", 2.00);
		Cake peachCake = new Cake("Orange", "Peach", "It's a girl!", "IDforPeach", 2.00);
		Cake marshmallowCake = new Cake("White", "Marshmallow", "It's a boy!", "IDforMarshmallow", 1.50);
		Cake darkChocoCake = new Cake("Dark Brown", "Dark Chocolate", "IDforDarkChoco", 3.25);
		Cake jelloCake = new Cake("Green", "Green Apple Jello", "IDforJello", 4.50);
		Cake tirimisuCake = new Cake("Coffee", "Coffee Mousse", "Coding 24/7 in Java woohoo!", "IDforTirimisu", 5.00);
		
		allCakes.put(assortedCake.getProductID(), assortedCake);
		allCakes.put(chocoCreamCake.getProductID(), chocoCreamCake);
		allCakes.put(chocoCake.getProductID(), chocoCake);
		allCakes.put(roseCake.getProductID(), roseCake);
		allCakes.put(mangoMousseCake.getProductID(), mangoMousseCake);
		allCakes.put(peachCake.getProductID(), peachCake);
		allCakes.put(marshmallowCake.getProductID(), marshmallowCake);
		allCakes.put(darkChocoCake.getProductID(), darkChocoCake);
		allCakes.put(jelloCake.getProductID(), jelloCake);
		allCakes.put(tirimisuCake.getProductID(), tirimisuCake);
	}//generateCakes method
	
}//ProductGenerator class
