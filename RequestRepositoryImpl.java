package proj1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import proj1.model.Employee;
import proj1.model.ReimbursementRequest;
import proj1.util.ConnectionClosers;
import proj1.util.ConnectionFactory;
import proj1.model.*;

public class RequestRepositoryImpl implements RequestRepository {

	@Override
	public List<ReimbursementRequest> getAllRequests() { //FIXME: Don't use this one. Write a different one.
		// TODO Auto-generated method stub
		
		ArrayList<ReimbursementRequest> requests = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		final String SQL = "select * from requests";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			//FIXME: we need different methods. The entries in the DB do not match the ones in Java.
			while (set.next()) {
				requests.add(
						new ReimbursementRequest (
							set.getInt(1),
							set.getInt(2),
							set.getTimestamp(3),
							set.getDouble(4),
							set.getString(5),
							set.getString(6),
							set.getInt(7),
							set.getString(8),
							set.getBoolean(9),
							set.getInt(10),
							set.getInt(11),
							set.getDouble(12),
							set.getString(13),
							set.getString(14),
							set.getTimestamp(15),
							set.getString(16),
							set.getInt(17)
							)
								);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return requests;
	}
	
	
	public List<RequestStatus> getAllRequestStatuses() { 
		
		ArrayList<RequestStatus> requests = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		final String SQL = "select * from request_status";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			//FIXME: we need different methods. The entries in the DB do not match the ones in Java.
			while (set.next()) {
				requests.add(
						new RequestStatus (
							set.getInt(1),
							set.getString(2),
							set.getString(3),
							set.getString(4),
							set.getString(5),
							set.getString(6),
							set.getDouble(7),
							set.getString(8),
							set.getBoolean(9),
							set.getString(10),
							set.getString(11),
							set.getString(12),
							set.getInt(13)
							)
								);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return requests;
	}
	
	public void createAccount(Employee e) {
		// we will use a prepared statement to parametrize what goes into the database.
		// TODO Auto-generated method stub
				// we need  a connection to insert a movie.
				// we need a statement we can execute to insert the movie.
				Connection conn = null;
				PreparedStatement stmt = null;
				
				try {
					conn = ConnectionFactory.getConnection(); 
					// we can parameterize what we put in the columns with question marks.
					// Use this with a prepared statement in order to prevent SQL injection.
					// This helps avoid a SQL injection.
					// You are not protected from SQL injection if you don't parameterize 
					// the data.
					//PUT A SEMI COLON INSIDE THE STATEMENT: will REMOVE IF ITS DOESNT WORK
					stmt = conn.prepareStatement("insert into login_credentials values(default, ?,?,?)");
					// NOTE: When we set the parameterized values, note that the parameter index refers to the 
					// number of the question mark for which you are setting that value.
					//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
					stmt.setString(1, e.geteMailAddress()); // FIXME: this is breaking our driver right now.
					stmt.setString(2, e.getUserName());
					stmt.setString(3, e.getPassword());
					stmt.execute();
					//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
				} catch (SQLException ex) {
				} finally {
					try {
						conn.close();
						stmt.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					} finally {
						ConnectionClosers.closeConnection(conn);
						ConnectionClosers.closeStatement(stmt);
					}

				}
	}
	//another method here
	
	//set employee info: this is the corporate info used to make decisions.
	public void setEmployeeInfo(int id, String firstName, String lastName, String occupation) {
		// we will use a prepared statement to parametrize what goes into the database.
		// TODO Auto-generated method stub
				// we need  a connection to insert a movie.
				// we need a statement we can execute to insert the movie.
		
				//generate the occupation id
				int occupation_id = 0;
				switch (occupation) {
					case "Supervisor":
						occupation_id = 2;
						break;
					case "Department Head":
						occupation_id= 3;
						break;
					case "Benefits Coordinator":
						occupation_id = 4;
						break;
					default:
						occupation_id = 1;
						break;
				}
		
				Connection conn = null;
				PreparedStatement stmt = null;
				
				try {
					conn = ConnectionFactory.getConnection(); 
					// we can parameterize what we put in the columns with question marks.
					// Use this with a prepared statement in order to prevent SQL injection.
					// This helps avoid a SQL injection.
					// You are not protected from SQL injection if you don't parameterize 
					// the data.
					//PUT A SEMI COLON INSIDE THE STATEMENT: will REMOVE IF ITS DOESNT WORK
					stmt = conn.prepareStatement("insert into employee_info values(?,?,?,?,?,?)");
					// NOTE: When we set the parameterized values, note that the parameter index refers to the 
					// number of the question mark for which you are setting that value.
					//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
					stmt.setInt(1, id); // FIXME: this is breaking our driver right now.
					stmt.setString(2, firstName);
					stmt.setString(3, lastName);
					stmt.setString(4, occupation);
					stmt.setInt(5, occupation_id);
					stmt.setInt(6, 0);
					
					stmt.execute();
					//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
				} catch (SQLException ex) {
				} finally {
					try {
						conn.close();
						stmt.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					} finally {
						ConnectionClosers.closeConnection(conn);
						ConnectionClosers.closeStatement(stmt);
					}

				}
	}
	
	//we will also need a method to get their employee id number, which is generated during account creation.
	// we will need to pull that one from the table. Why don't we write verify account first?
	
	public int verifyLogin(String a, String b) {
		//return the id from the login. use this for other services.
		int acct_id = 0;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		try {
			conn = ConnectionFactory.getConnection(); 
			// we can parameterize what we put in the columns with question marks.
			// Use this with a prepared statement in order to prevent SQL injection.
			// This helps avoid a SQL injection.
			// You are not protected from SQL injection if you don't parameterize 
			// the data.
			//PUT A SEMI COLON INSIDE THE STATEMENT: will REMOVE IF ITS DOESNT WORK
			stmt = conn.prepareStatement("select id from login_credentials where user_name = ? and pass_word = ?");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setString(1, a);
			stmt.setString(2, b);
			set = stmt.executeQuery();
			while (set.next()) {
				 //pull id from username as password
				acct_id = set.getInt(1);  // you NEED THIS. cant pull from result set without it
			}
			//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
		} catch (SQLException e) {
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
			}
		}
		//Check for validity.
		// it will throw null if it doesnt find anything. will check for an integer.
		// success case	
		if (acct_id > 0) { //if the result set brings back an integer
			return acct_id; 
		} else {
			return acct_id; //login failed case
		}
	}
	
	
	// we will call the method to calculate the remaining days in advance and pass them in. we
	//only need to pass in the date and time the request was submitted.
	public void createRequest(int empId, Timestamp submissionDate, Timestamp startDate, double tuition, 
			int passingGrade,  String courseTitle, int daysRemaining, int daysMissed, int fees, String courseType,
			String location, String description, String gradingFormat, int occupationID) {
		//we will create the future timestamp outside the method and ass it in. 
		//status will be initialized to pending.
		boolean urgencyStatus = false;
		String requestStatus = "Pending";
		
		//will import 2 timestamps to the method, will be created when event listener is called
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.getConnection(); 
			//PUT A SEMI COLON INSIDE THE STATEMENT: will REMOVE IF ITS DOESNT WORK
			stmt = conn.prepareStatement("insert into requests values(default, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setInt(1, empId); 
			stmt.setTimestamp(2, submissionDate);
			stmt.setDouble(3, tuition);
			stmt.setString(4,description);
			stmt.setString(5,requestStatus);
			stmt.setInt(6,passingGrade);
			stmt.setString(7,courseTitle);
			stmt.setBoolean(8,urgencyStatus);
			stmt.setInt(9,daysRemaining);
			stmt.setInt(10,daysMissed);
			stmt.setDouble(11,fees);
			stmt.setString(12,courseType);
			stmt.setString(13,location);
			stmt.setTimestamp(14,startDate);
			stmt.setString(15, gradingFormat);
			stmt.setInt(16, occupationID);
			stmt.execute();

		} catch (SQLException ex) {
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
			}

		}
	}
	
	//return the request id from the login. use this for other services.
	// FIXME: might need to create a request object to output the requests pulled from the DB.
	// on the other hand, we might be able to pass in some other parameters initialized earlier and 
	//get it that way (i.e. the timestamps)
	
	// we need to pass this into the pending requests table.
	
	// need a way to pull a request id. lets pass in an employee id and grab the requests that pertain to them.
	// need to write the method to get requests by employee first. then we can pull one by the ID.
	public int getRequestByEmployee(int empID, Timestamp dateSubmitted) {

		int requestID = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		try {
			conn = ConnectionFactory.getConnection(); 
			// we can parameterize what we put in the columns with question marks.
			// Use this with a prepared statement in order to prevent SQL injection.
			// This helps avoid a SQL injection.
			// You are not protected from SQL injection if you don't parameterize 
			// the data.
			//PUT A SEMI COLON INSIDE THE STATEMENT: will REMOVE IF ITS DOESNT WORK
			stmt = conn.prepareStatement("select request_id from requests where employee_id = ? and date_submitted = ?");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setInt(1, empID);
			stmt.setTimestamp(2, dateSubmitted);
			set = stmt.executeQuery();
			while (set.next()) {
				 //pull id from employee id and timestamp
				requestID = set.getInt(1);  // you NEED THIS. cant pull from result set without it
			}
			//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
		} catch (SQLException e) {
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
			}
		}
		return requestID;
	}
	
// might need one to pull all the requests as well.
// need a method to reset the amount of money available. i.e. when the year resets. it should apply to 
// ALL the employees.
	
// For the make decision method: you will need to pass in the ID of the party making the decision
// and write a switch statement for the role of the party that makes the decision.
	
	//request pending

		
		// FIX ME: Need to write additional methods to modify the elements. 
		// need to pass occupation id into those roles.
		// need a method to get occupation id as well. so that's on the to-do list.
	
	
	public void createRequestStatus(int requestID, int occupationID) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.getConnection(); 
			stmt = conn.prepareStatement("insert into request_status values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setInt(1, requestID); 
			stmt.setString(2, "Pending");
			stmt.setString(3, "Unknown");
			stmt.setString(4,"None Provided");
			stmt.setString(5,"None Provided");
			stmt.setString(6,"None Provided");
			stmt.setDouble(7,0.0);
			stmt.setString(8,"None Provided");
			stmt.setBoolean(9,false);
			stmt.setString(10,"None Provided");
			stmt.setString(11,"None Provided");
			stmt.setString(12,"None Provided");
			stmt.setInt(13, occupationID);
			stmt.execute();

		} catch (SQLException ex) {
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
			}

		}
	}
	
	// make a decision: do a switch based on who makes the decision.
	// we will need to pass the roleID into this one.
	
	public int getPositionID(int empID) {
		
		int positionID = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		try {
			conn = ConnectionFactory.getConnection(); 
			// we can parameterize what we put in the columns with question marks.
			// Use this with a prepared statement in order to prevent SQL injection.
			// This helps avoid a SQL injection.
			// You are not protected from SQL injection if you don't parameterize 
			// the data.
			//PUT A SEMI COLON INSIDE THE STATEMENT: will REMOVE IF ITS DOESNT WORK
			stmt = conn.prepareStatement("select position_id from requests where employee_id = ?");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setInt(1, empID);
			set = stmt.executeQuery();
			while (set.next()) {
				 //pull id from employee id and timestamp
				positionID = set.getInt(1);  // you NEED THIS. cant pull from result set without it
			}
			//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
		} catch (SQLException e) {
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
			}
		}
		return positionID;
	}
	
	// update request status
	// need a request id, the decision maker and the role of the decision maker
	// update the request decision
	
	public void requestMoreInformation (int requestID, int positionID) {
	
		// get the role of the requestor
		String moreinfo = "More information needed from the ";
		switch (positionID) {
			case 2:
				moreinfo = moreinfo + "supervisor.";
				break;
			case 3:
				moreinfo = moreinfo + "department head.";
				break;
			case 4:
				moreinfo = moreinfo + "benefits coordinator.";
				break;
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("update request_status set request_decision = ? where request_id = ?");
			
			stmt.setString(1,moreinfo);
			stmt.setInt(2,requestID);
			stmt.execute();
		} catch (SQLException ex) {
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
				}
			}
		}
	
	// method to add more info if requested
	public void addMoreInformation (int requestID, int positionID, String moreInfo) {
		//moreinfo collects info from front end. this puts it in DB.
		//need a switch based on which role asks for it
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			switch (positionID) {
				case 2:
					stmt = conn.prepareStatement("update request_status set extra_info_from_employee = ? where request_id = ?");
					break;
				case 3:
					stmt = conn.prepareStatement("update request_status set extra_info_from_supervisor = ? where request_id = ?");
					break;
				case 4:
					stmt = conn.prepareStatement("update request_status set extra_info_from_head = ? where request_id = ?");
					break;
			}
			
			
			stmt.setString(1,moreInfo);
			stmt.setInt(2,requestID);
			stmt.execute();
		} catch (SQLException ex) {
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
				}
			}
		
	}
	

	//either approved or denied is passed in as a string
	public void makeDecision(int requestID, String Decision) {

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.getConnection(); 
			// can be called by any role, will be called before the setDecider method is called.
			// all done on the back end.
			stmt = conn.prepareStatement("update request_status set request_decision = ? where request_id = ?)");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setString(1, Decision); // FIXME: this is breaking our driver right now.
			stmt.setInt(2, requestID);
			stmt.execute();
			//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
		} catch (SQLException ex) {
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
			}

		}
	}
	
	public void setDecider(int requestID, int positionID) {
		
		String Decider = null; //role of who made final decision
		switch (positionID) {
		case 2:
			Decider = "Supervisor";
			break;
		case 3:
			Decider = "Department Head";
			break;
		case 4:
			Decider = "Benefits Coordinator";
			break;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.getConnection(); 
			// we can parameterize what we put in the columns with question marks.
			// Use this with a prepared statement in order to prevent SQL injection.
			// This helps avoid a SQL injection.
			// You are not protected from SQL injection if you don't parameterize 
			// the data.
			//PUT A SEMI COLON INSIDE THE STATEMENT: will REMOVE IF ITS DOESNT WORK
			stmt = conn.prepareStatement("update request_status set final_decision_maker = ? where request_id = ?)");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setString(1, Decider); // FIXME: this is breaking our driver right now.
			stmt.setInt(2, requestID);
			stmt.execute();
			//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
		} catch (SQLException ex) {
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
			}

		}
	}
	

			// award reimbursement (0 if denied),
	public void awardReimbursement (int requestID, double amount) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.getConnection(); 
			// we can parameterize what we put in the columns with question marks.
			// Use this with a prepared statement in order to prevent SQL injection.
			// This helps avoid a SQL injection.
			// You are not protected from SQL injection if you don't parameterize 
			// the data.
			//PUT A SEMI COLON INSIDE THE STATEMENT: will REMOVE IF ITS DOESNT WORK
			stmt = conn.prepareStatement("update request_status set amount_awarded = ? where request_id = ?)");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setDouble(1, amount); // FIXME: this is breaking our driver right now.
			stmt.setInt(2, requestID);
			stmt.execute();
			//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
		} catch (SQLException ex) {
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
			}

		}
	}
	
	public void resetAvailableReimbursement (int empID, double Reimbursement) {
		// benco will reset everyone's total once a year.
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.getConnection(); 
			// we can parameterize what we put in the columns with question marks.
			// Use this with a prepared statement in order to prevent SQL injection.
			// This helps avoid a SQL injection.
			// You are not protected from SQL injection if you don't parameterize 
			// the data.
			//PUT A SEMI COLON INSIDE THE STATEMENT: will REMOVE IF ITS DOESNT WORK
			stmt = conn.prepareStatement("update employee_info set amount_claimed_this_year = amount_claimed_this_year + ? where employee_id = ?)");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setDouble(1, Reimbursement);
			stmt.setInt(2, empID);
			stmt.execute();
			//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
		} catch (SQLException ex) {
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
			}
		}
	}

	
	

	// auto approve request if department takes 7 days to decide
	public void autoApproveRequest(int requestID, int daysElapsed) {
		//will call the time method outside and pass in the number of days. (max of 7)
		Connection conn = null;
		PreparedStatement stmt = null;
		if (daysElapsed >= 7) {
		try {
			conn = ConnectionFactory.getConnection(); 
			stmt = conn.prepareStatement("update request_status set dephead_decision = ? where request_id = ?)");
			// NOTE: When we set the parameterized values, note that the parameter index refers to the 
			// number of the question mark for which you are setting that value.
			//REMEMBER: the question marks are indexes. 1 = first question mark and so on.
			stmt.setString(1, "Approved");
			stmt.setInt(2, requestID);
			stmt.execute();
			//SIDENOTE: Hibernate is better than JBDC, but that's a future thing.
		} catch (SQLException ex) {
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
				}
			}
		}
	}

	//get all requests for an employee
	public List<ReimbursementRequest> getAllRequestsperEmployee(int empID) { //FIXME: Don't use this one. Write a different one.
		// TODO Auto-generated method stub
		
		ArrayList<ReimbursementRequest> requests = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select from requests where employee_id = ?");
			stmt.setInt(1,empID);
			set = stmt.executeQuery();
			//FIXME: we need different methods. The entries in the DB do not match the ones in Java.
			while (set.next()) {
				requests.add(
						new ReimbursementRequest (
							set.getInt(1),
							set.getInt(2),
							set.getTimestamp(3),
							set.getDouble(4),
							set.getString(5),
							set.getString(6),
							set.getInt(7),
							set.getString(8),
							set.getBoolean(9),
							set.getInt(10),
							set.getInt(11),
							set.getDouble(12),
							set.getString(13),
							set.getString(14),
							set.getTimestamp(15),
							set.getString(16),
							set.getInt(17)
							)
								);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return requests;
	}
	
	public List<ReimbursementRequest> getSpecificRequest(int requestID) { //FIXME: Don't use this one. Write a different one.
		// TODO Auto-generated method stub
		
		ArrayList<ReimbursementRequest> requests = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select from requests where request_id = ?");
			stmt.setInt(1,requestID);
			set = stmt.executeQuery();
			//FIXME: we need different methods. The entries in the DB do not match the ones in Java.
			while (set.next()) {
				requests.add(
						new ReimbursementRequest (
							set.getInt(1),
							set.getInt(2),
							set.getTimestamp(3),
							set.getDouble(4),
							set.getString(5),
							set.getString(6),
							set.getInt(7),
							set.getString(8),
							set.getBoolean(9),
							set.getInt(10),
							set.getInt(11),
							set.getDouble(12),
							set.getString(13),
							set.getString(14),
							set.getTimestamp(15),
							set.getString(16),
							set.getInt(17)
							)
								);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return requests;
	}
	
	// all for one employee
	public List<RequestStatus> getAllRequestStatusesperEmployee(int empID) { 
		
		ArrayList<RequestStatus> requests = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select from request_status where employee_id = ?");
			stmt.setInt(1,empID);
			set = stmt.executeQuery();
			
			//FIXME: we need different methods. The entries in the DB do not match the ones in Java.
			while (set.next()) {
				requests.add(
						new RequestStatus (
							set.getInt(1),
							set.getString(2),
							set.getString(3),
							set.getString(4),
							set.getString(5),
							set.getString(6),
							set.getDouble(7),
							set.getString(8),
							set.getBoolean(9),
							set.getString(10),
							set.getString(11),
							set.getString(12),
							set.getInt(13)
							)
								);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return requests;
	}
	
	public List<RequestStatus> getSpecificRequestStatus(int requestID) { 
		
		ArrayList<RequestStatus> requests = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select from request_status where request_id = ?");
			stmt.setInt(1,requestID);
			set = stmt.executeQuery();
			
			//FIXME: we need different methods. The entries in the DB do not match the ones in Java.
			while (set.next()) {
				requests.add(
						new RequestStatus (
							set.getInt(1),
							set.getString(2),
							set.getString(3),
							set.getString(4),
							set.getString(5),
							set.getString(6),
							set.getDouble(7),
							set.getString(8),
							set.getBoolean(9),
							set.getString(10),
							set.getString(11),
							set.getString(12),
							set.getInt(13)
							)
								);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return requests;
	}
	// change password down the line. also, change urgency status to true.
	
	public List<ReimbursementRequest> getRequestsByRole(int roleID) { //FIXME: Don't use this one. Write a different one.
		// TODO Auto-generated method stub
		//only for higher-ups. regular employees can only see their own.
		ArrayList<ReimbursementRequest> requests = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select from requests where occupation_id < ?");
			stmt.setInt(1,roleID);
			set = stmt.executeQuery();
			//FIXME: we need different methods. The entries in the DB do not match the ones in Java.
			while (set.next()) {
				requests.add(
						new ReimbursementRequest (
							set.getInt(1),
							set.getInt(2),
							set.getTimestamp(3),
							set.getDouble(4),
							set.getString(5),
							set.getString(6),
							set.getInt(7),
							set.getString(8),
							set.getBoolean(9),
							set.getInt(10),
							set.getInt(11),
							set.getDouble(12),
							set.getString(13),
							set.getString(14),
							set.getTimestamp(15),
							set.getString(16),
							set.getInt(17)
							)
								);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return requests;
	}
	
	public List<RequestStatus> getRequestStatusByRole(int roleID){
		ArrayList<RequestStatus> requests = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		//not available to regular employees.
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select from request_status where occupation_id < ?");
			stmt.setInt(1,roleID);
			set = stmt.executeQuery();
			
			//FIXME: we need different methods. The entries in the DB do not match the ones in Java.
			while (set.next()) {
				requests.add(
						new RequestStatus (
							set.getInt(1),
							set.getString(2),
							set.getString(3),
							set.getString(4),
							set.getString(5),
							set.getString(6),
							set.getDouble(7),
							set.getString(8),
							set.getBoolean(9),
							set.getString(10),
							set.getString(11),
							set.getString(12),
							set.getInt(13)
							)
								);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return requests;
	}
	
}
