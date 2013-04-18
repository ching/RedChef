<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=" java.util.ArrayList, forProducts.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Review Your Order</title>
</head>
<body>
	<%
		//Get invoice object from request
		Invoice newInvoice = (Invoice) request.getAttribute("cake");
		//Retrieve all line items from the invoice
		LineItem[] lineItems = newInvoice.getLineItems();
	%>
	<br><br><h2>Your Order Information</h2>
	<div id="wrapperCake">
		<div id="center"><br><br>
			Thank you for your order! We will process it within the next 24 hours!<br>
			You ordered the following cake(s):
		</div>
		<br><br><table>
			<tbody>
				<tr>
					<th>Cake Name</th>
					<th>Customized Message</th>
					<th>Quantity</th>
					<th>Cost</th>
				</tr>
			<%
				for(int i=0; i < lineItems.length; i++){
					LineItem lineItem = lineItems[i];
					if (lineItem.getQuantity() > 0){
			%>
					<tr>
		    			<td><%=lineItem.getName()%></td>
		    			<td>"<%=lineItem.getMessage()%>"</td>
		    			<td><%=lineItem.getQuantity()%>
		   			<%
		    			for(int count = lineItem.getQuantity(); count > 0; count--){
		    		%>
		    					<img id="miniIcon" src="images/miniIcon.png" alt="cake">
		    		<%
		    			}//display an image for each cake ordered
		   			 %>
		    			</td>
		    			<td><%=lineItem.costToCurrency()%></td>
		    		</tr>
		    <%
					}//print only when we have something
				}//looping through each line item
		    %>
		    </tbody>
		</table>
		<% 
			//Get wrappedValue object from request
			String wrappedValue = (String) request.getAttribute("wrapped");
		%>
	 	<div id="center"><br><br>
	 		Your invoice ID number is: <%=newInvoice.getInvoiceID()%><br>
	 		Your total cost for this order is: <%=newInvoice.costToCurrency()%>.<br>
	 		And it looks like we will <%=wrappedValue%> your cake(s) for you :)<br>
	 		<br><br><a href="homepage.html">Return to Main Page</a>
	 	</div>
	</div>
</body>
</html>