package forProducts;

import java.io.IOException;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Date date = new Date(); //date of invoice submission
	String invoiceID; //invoice identification number
	ProductGenerator collectionOfCakes;
	
	public void init() {
		//Creating collection of cakes
		 collectionOfCakes = new ProductGenerator();
	}//init method
	
    public ProductServlet() {
        super();
    }//ProductSummaryServlet constructor
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
		doPost(request, response); //directs to doPost method
	}//doGet method

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String[] cakeNames = {"AssortedCakes", "ChocoCreamCake",
				"ChocoCake", "RoseCake", "MangoMousseCake",
				"PeachCake", "MarshmallowCake", "DarkChocoCake",
				"JelloCake", "TirimisuCake"};
		String[] cakesQuantity = {"assortedQuantity", "chocoCreamQuantity",
			 "chocoQuantity", "roseQuantity", "mangoMousseQuantity",
			 "peachQuantity", "marshmallowQuantity", "darkChocoQuantity",
			 "jelloQuantity", "tirimisuQuantity"};
		String[] cakeMsg = {"assortedMsg", "chocoCreamMsg", "chocoMsg",
				"roseMsg", "mangoMousseMsg", "peachMsg", 
				"marshmallowMsg", "darkChocoMsg", "jelloMsg",
				"tirimisuMsg"};
		String[] cakeID = {"AssortedID", "ChocoCreamID",
				"ChocoID", "RoseID", "MangoMousseID",
				"PeachID", "MarshmallowID", "DarkChocoID",
				"JelloID", "TirimisuID"};
		String wrappedValue = request.getParameter("wrapped");
		
		//Create the invoiceID using the currentDate
		invoiceID = "Invoice_"+ date;
		
		//Create an instance of the Invoice class
		Invoice newInvoice = new Invoice(date, invoiceID);
		
		//Process information sent by the form
		for(int i=0; i < cakesQuantity.length; i++) {
			//Requests for cake quantity information
			String totalCakes = request.getParameter(cakesQuantity[i]);
       	 	int cakesNum = Integer.parseInt(totalCakes);
       	 	//Requests for cake id information
       	 	String myCakeID = request.getParameter(cakeID[i]);
       	 	Cake myCake = collectionOfCakes.getCake(myCakeID);
       	 	//Requests for cake message information
			String message = request.getParameter(cakeMsg[i]);
			//Requests for cake name information
			String name = request.getParameter(cakeNames[i]);
			//Determine whether item will have customized or default
			if (message.equals("")){
	       	 	LineItem lineItem = new LineItem(myCake, cakesNum, name, myCake.getMessage());
	       	 	newInvoice.addLineItem(lineItem);
			}else {
				LineItem lineItem = new LineItem(myCake, cakesNum, name, message);
				newInvoice.addLineItem(lineItem);
			}//else
		}//looping through each cake to create an invoice

		//Pass the invoice object as an attribute
		request.setAttribute("cake", newInvoice);
			
		//Pass the wrapped value as an attribute
		request.setAttribute("wrapped", wrappedValue);
		
		//Forward information to JSP for display
		String url = "/Summary.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}//doPost method
	
}//ProductSummaryServlet
