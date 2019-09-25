package proj1.service;

import java.sql.Timestamp;
import java.util.List;

import proj1.model.Employee;
import proj1.model.ReimbursementRequest;
import proj1.repository.RequestRepositoryImpl;
import proj1.model.RequestStatus;


public class RequestService {


		// TODO Auto-generated constructor stub
		public List<ReimbursementRequest> getAllRequests(){
			return new RequestRepositoryImpl().getAllRequests();
	
		}
		
		public List<RequestStatus> getAllRequestStatuses(){
			return new RequestRepositoryImpl().getAllRequestStatuses();
		}
		
		public List<ReimbursementRequest> getAllRequestsperEmployee(int empID){
			return new RequestRepositoryImpl().getAllRequestsperEmployee(empID);
		}
		
		public List<ReimbursementRequest> getSpecificRequest(int requestID) {
			return new RequestRepositoryImpl().getSpecificRequest(requestID); 
		}
		
		public List<RequestStatus> getAllRequestStatusesperEmployee(int empID){
			return new RequestRepositoryImpl().getAllRequestStatusesperEmployee(empID);
		}
		
		public List<RequestStatus> getSpecificRequestStatus(int requestID) { 
			return new RequestRepositoryImpl().getSpecificRequestStatus(requestID);
		}
		/*
		 * METHODS TO WRITE:
		
	
		change password
		amend request
		also need methods for hierarchical roles, too. will collect that in another method.
			-the front end will provide some of these in drop down menus.
		
		NOTE: for the methods that require modular SQL statements, pass in the modular value into the 
		method (i.e. amend request) so you don't haveto write a bunch of different methods.
		we will use the webpage navigation for the different roles.
		 */

		public void createAccount(Employee e) {
			new RequestRepositoryImpl().createAccount(e);
		}
	
		public int verifyLogin(String a, String b) {
			return new RequestRepositoryImpl().verifyLogin(a,b);
		}

		public void setEmployeeInfo(int id, String firstName, String lastName, String occupation){
			new RequestRepositoryImpl().setEmployeeInfo(id,firstName,lastName,occupation);
		}
		
		public void createRequest(int empId, Timestamp submissionDate, Timestamp startDate, double tuition, 
				int passingGrade,  String courseTitle, int daysRemaining, int daysMissed, int fees, String courseType,
				String location, String description, String gradingFormat, int occupationID) {
			new RequestRepositoryImpl().createRequest(empId, submissionDate, startDate, tuition, passingGrade,
					courseTitle, daysRemaining, daysMissed, fees, courseType, location, description, gradingFormat, occupationID);
		}
		
		public void createRequestStatus(int requestID, int occupationID) {
			new RequestRepositoryImpl().createRequestStatus(requestID, occupationID);
		}
		
		public int getRequestByEmployee(int empID, Timestamp dateSubmitted) {
			return new RequestRepositoryImpl().getRequestByEmployee(empID, dateSubmitted);
		}
		
		public int getPositionID(int empID) {
			return new RequestRepositoryImpl().getPositionID(empID); 
		}
		
		public void requestMoreInformation(int requestID, int positionID) {
			new RequestRepositoryImpl().requestMoreInformation(requestID, positionID);
		}
		
		public void addMoreInformation (int requestID, int positionID, String moreInfo) {
			new RequestRepositoryImpl().addMoreInformation (requestID, positionID, moreInfo);
		}
		
		public void makeDecision(int requestID, String Decision) {
			new RequestRepositoryImpl().makeDecision(requestID, Decision);
		}
		
		public void setDecider(int requestID, int positionID) {
			new RequestRepositoryImpl().setDecider(requestID, positionID);
		}
		
		public void awardReimbursement (int requestID, double amount) {
			new RequestRepositoryImpl().awardReimbursement(requestID, amount);
		}
		
		public void resetAvailableReimbursement (int empID, double Reimbursement) {
			new RequestRepositoryImpl().resetAvailableReimbursement (empID, Reimbursement);
		}
		
		public void autoApproveRequest(int requestID, int daysElapsed) {
			new RequestRepositoryImpl().autoApproveRequest(requestID, daysElapsed);
		}
		
		public List<ReimbursementRequest> getRequestsByRole(int roleID) {
			return new RequestRepositoryImpl().getRequestsByRole(roleID);
		}
		
		public List<RequestStatus> getRequestStatusByRole(int roleID) {
			return new RequestRepositoryImpl().getRequestStatusByRole(roleID);
		}
}
