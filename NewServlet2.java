package proj1web;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import proj1.service.RequestService;



/**
 * Servlet implementation class NewServlet
 */
public class NewServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }
    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestService rs = new RequestService();
		String flag = request.getParameter("custID");
		//switch (flag) using ajax, so we don't need this. put somewhere else when necessary.
		//case "1111":
			// view requests
			// will be different for different roles
		    HttpSession session = request.getSession();
		    
		    int empID = (Integer)session.getAttribute("employeeID");
		    int posID = (Integer)session.getAttribute("positionID");
		    System.out.println(empID); //testing
		    // set the output to a JSON
			response.setContentType("application/json");
			ObjectMapper imTheMap = new ObjectMapper();
		    switch (posID) {
		    case 1:
		    	response.sendRedirect("http://localhost:8084/Test/Outputs/requests.html"); 
		    	response.setStatus(200);
				response.getOutputStream().write(imTheMap.writeValueAsBytes(rs.getAllRequestsperEmployee(empID))); 
		    		// only their requests
		    	break;
		    case 2: // all employees and their own
		    	response.getOutputStream().write(imTheMap.writeValueAsBytes(rs.getAllRequestsperEmployee(empID)));
		    	response.getOutputStream().write(imTheMap.writeValueAsBytes(rs.getRequestStatusByRole(posID)));
		    	response.setStatus(200);
		    	response.sendRedirect("http://localhost:8084/Test/Outputs/requests.html"); 
		    	break;
		    case 3: //employees and supervisors
		    	
		    	break;
		    case 4: // all of them
		    	
		    	break;
		    }
		//}

		//We use the print method to write something to the response body.
		// You can use JSON or XML to complete your project.

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String uri = request.getRequestURI().substring(request.getContextPath().length());
		//String uri = request.getRequestURI().replace("/Test/Login", "");
		//System.out.println(request.getRequestURI()); // test the output
		//System.out.println(uri); 
		//System.out.println(request.getRequestURI());
		RequestService rs = new RequestService();
		String flag = request.getParameter("custID");
		
		String uri = request.getRequestURI().substring(request.getContextPath().length()); 
		System.out.println(uri);	
		System.out.println(request.getRequestURL());// testing
		//String page = request.getRequestURI().replaceAll("/Athenaeum/FrontController", "");
		switch(flag) {
		case "0001":
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
	
			System.out.println(username + password);
			int authInt = rs.verifyLogin(username,password);
			// if authentication is successful, return Authorization to the client; otherwise
			if(authInt > 0) {
				HttpSession session = request.getSession();
				int posID = rs.getPositionID(authInt);
				session.setAttribute("positionID", posID); 
				session.setAttribute("employeeID", authInt);
				System.out.println("made it");
				response.sendRedirect("http://localhost:8084/Test/LoggedIn/devientlabsloginsuccessful.html"); 
			} else {
				response.setStatus(401); // 401 Unauthorized
			}
			break;
		
		//make a new request
		case "3487":	
			
		    HttpSession session = request.getSession();
		    
		    int empID = (Integer)session.getAttribute("employeeID");
		    int posID = (Integer)session.getAttribute("positionID");
		    System.out.println(empID); //testing
		    
			String title = request.getParameter("coursetitle");
			String courseType = request.getParameter("coursetype");
			String location = request.getParameter("courselocation");
			String description = request.getParameter("coursedescription");
			int missedDays = Integer.parseInt(request.getParameter("misseddays"));
			double cost = Double.parseDouble(request.getParameter("cost"));
			String gradingFormat =  request.getParameter("gradingformat");
			String passingGrade = request.getParameter("passinggrade");
			
			//date inputs
			int year = Integer.parseInt(request.getParameter("year"));
			int month = Integer.parseInt(request.getParameter("startmonth"));
			int day = Integer.parseInt(request.getParameter("startday"));
			
			//get a timestamp
			java.util.Date date = new java.util.Date();
			Timestamp timestamp1 = new Timestamp(date.getTime());
			
			//second timestamp, based on startdate
			String date1 = Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day)
			+ " 00:00:00";
			
			SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat(
	                "yyyy-MM-dd hh:mm:ss");
			Date lFromDate1 = null;
			try {
				lFromDate1 = datetimeFormatter1.parse(date1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Timestamp timestamp2 = new Timestamp(lFromDate1.getTime());
			
			long milliseconds = timestamp2.getTime() - timestamp1.getTime();
		    int seconds = (int) milliseconds / 1000;
		 
		    // calculate hours minutes and seconds
		    int days = seconds / (3600 * 24); // will be days until course start
		    System.out.println(empID + "\n"+ timestamp1 + timestamp2 + "\n" + cost + passingGrade +
					title + days + missedDays+ 0 + courseType + location + description + gradingFormat +
					posID);
		    System.out.println(days);
		    System.out.println(missedDays);
		    

			// store in db
			// need to get the ids, then put them here rs1.createRequest(); you need the occupationID from the session.
			rs.createRequest(empID, timestamp1, timestamp2, cost, passingGrade, 
					title, days, missedDays, 0, courseType, location, description, gradingFormat,
					posID);
			//need request ID
			int reqID = rs.getRequestByEmployee(empID, timestamp1);
			//also need to create a request status from the request id.
			rs.createRequestStatus(reqID, posID);
			// maybe send redirect afterward
			response.sendRedirect("http://localhost:8084/Test/LoggedIn/devientlabsloginsuccessful.html"); 
			
			
		}
		
	}
	
	
}
