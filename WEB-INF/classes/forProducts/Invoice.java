package forProducts;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Invoice {
	private Date date; //when invoice was submitted
	private String invoiceID; //identification number for each invoice
	private LineItem[] lineItemArray; //array collection of lineItems
	private static final int MAX = 10; //maximum line items we can have in collection
	private int records = 0; //keeps track of # of items in invoice
	
	public Invoice(Date theDate, String theID){
		//construct an array of line items with max value
		lineItemArray = new LineItem[MAX];
		this.date = theDate;
		this.invoiceID = theID;
	}//Invoice constructor
	
	public Date getDate() {
		return date;
	}//getDate method

	public void setDate(Date date) {
		this.date = date;
	}//setDate method

	public String getInvoiceID() {
		return invoiceID;
	}//getInvoiceID method

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}//setInvoiceID method
	
	public void addLineItem(LineItem theLineItem){
		if(records < MAX) {
			//insert line item to the next array position
			lineItemArray[records++] = theLineItem;
		}//check whether array is full
	}//addLineItem method
	
	public LineItem[] getLineItems(){
			return lineItemArray;	
	}//getLineItems method
	
	public double calculateTotal(){
		double totalCost = 0;
		for(int i=0; i < lineItemArray.length; i++){
			totalCost += lineItemArray[i].calculateCost();
		}//loop through the array to calculate cost of each 
		return totalCost;
	}//calculateTotal method
	
	public String costToCurrency(){ 
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US); 
		String formattedCost = nf.format(calculateTotal()); 
		return formattedCost; 
	}//costToCurrency method
		
	public String toString(){ 
		String toReturn = "";
		for (int i=0; i < lineItemArray.length; i++){
			toReturn += lineItemArray[i] + "\n";
		}//loops through array to print out each item
		return toReturn;
	}//toString method
	
}//Invoice class
