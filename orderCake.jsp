<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="forProducts.Cake, forProducts.Food"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Review your order information</title>
</head>
<body>
	<%
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
					<th>Message</th>
					<th>Quantity</th>
				</tr>
		
			<%
				//Loop through the cakes selected to show information
		 		for(int i=0; i < cakesQuantity.length; i++) {
		 			String totalCakes = request.getParameter(cakesQuantity[i]);
		       	 	int cakesNum = Integer.parseInt(totalCakes);
		     		if(cakesNum > 0) {
	    	 %>
	    	 			<tr>
		    				<td><%=request.getParameter(cakeNames[i])%></td>
		    				<td>"<%=request.getParameter(cakeMsg[i])%>"</td>
		    				<td><%=cakesNum %>
		    		<%
		    				for(int num = cakesNum; num > 0; num--){
		    		%>
		    					<img id="miniIcon" src="images/miniIcon.png" alt="cake">
		    		<%
		    				}//loop through
		    		%>
		    				</td>
		    			</tr>
	    	<% 
	   			 	}//if
				}//for
		 	%>
	 		</tbody>
	 	</table>
	 	<div id="center"><br><br>
	 		Looks like we will <%=request.getParameter("wrapped")%> your cake(s) for you :)
	 	</div>
	</div>
</body>
</html>