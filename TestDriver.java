package proj1.model;

import org.apache.logging.log4j.core.lookup.MainMapLookup;

import proj1.service.RequestService;

public class TestDriver {

	public TestDriver() {
		// TODO Auto-generated constructor stub
		
	}
	public static void main (String args[]) {
				RequestService rs = new RequestService();
				
				System.out.println(rs.verifyLogin("thefirstuser","badpassword"));
			}

		

	

}
