package proj1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import proj1.service.RequestService;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//commented out above for now. Currently testing this servlet. Currently not working.
		
		RequestService rs = new RequestService();
		PrintWriter write = response.getWriter();
		response.setContentType("text/plain");
		
		/*
		 * NOTE: this doesn't come from the servlet API. We've included the Jackson 
		 * dependency, which gives us access to the object mapper. An ObjectMapper provides a
		 * convenient way of mapping our java objects as JSON and vice versa.
		 * 
		 * You don't use the printwriter if you're putting out bytes.
		 */
		
		/*
		 * NOTE: Here we are writing the movies from our database back to the client as JSON. 
		 * In order to "consume" this REST, we need only hit the appropriate endpoint. In this
		 * case the endpoint we must hit to access our data is:
		 * localhost:8084/ServletDemo/GetAllMovies
		 */
		write.print(rs.verifyLogin("thefirstuser","badpassword"));
		
		//you can use bytes, but notice how we have it as a string.
		//I think the ultimate test comes when you add it to your own DAO.
		
		// just a test. modify if it works.
		//response.getOutputStream().write((imTheMap.writeValueAsBytes(rs.verifyLogin("thefirstuser","badpassword"))));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
