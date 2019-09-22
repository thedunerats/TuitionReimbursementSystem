package proj1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj1.service.RequestService;

/**
 * Servlet implementation class NewServlet
 */
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
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
		PrintWriter write = response.getWriter();
		
		/*
		 * In this case, we have written plain text to our response body.
		 * We are not, however, limited to plain text. We can also write 
		 * back HTML and JSON (and so many others.)
		 * 
		 * Example of Content Type:
		 * application/json
		 * text/html
		 * text/plain
		 */
		
		response.setContentType("text/plain");
		//We use the print method to write something to the response body.
		// You can use JSON or XML to complete your project.
		write.print(rs.verifyLogin("thefirstuser","badpassword")); //for now. may change it later.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
