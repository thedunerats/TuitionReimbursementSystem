package proj1.repository;

import java.sql.Timestamp;
import java.util.List;

import proj1.model.Employee;
import proj1.model.ReimbursementRequest;
import proj1.model.RequestStatus;

public interface RequestRepository {

	List<ReimbursementRequest> getAllRequests();	

	List<RequestStatus> getAllRequestStatuses();
	
	List<ReimbursementRequest> getAllRequestsperEmployee(int empID);
	
	List<ReimbursementRequest> getSpecificRequest(int requestID);
	
	List<RequestStatus> getAllRequestStatusesperEmployee(int empID);
	
	List<RequestStatus> getSpecificRequestStatus(int requestID);
	
	void createAccount(Employee e);
	
	int verifyLogin(String a, String b);
	
	void setEmployeeInfo(int id, String firstName, String lastName, String occupation);
	
	void createRequest(int empId, Timestamp submissionDate, Timestamp startDate, double tuition, 
			String passingGrade,  String courseTitle, int daysRemaining, int daysMissed, int fees, String courseType,
			String location, String description, String gradingFormat, int occupationID);
	
	void createRequestStatus(int requestID, int occupationID);
	
	int getRequestByEmployee(int empID, Timestamp dateSubmitted);
	
	int getPositionID(int empID);
	
	void requestMoreInformation (int requestID, int positionID);
	
	void addMoreInformation (int requestID, int positionID, String moreInfo);
	
	void makeDecision(int requestID, String Decision);
	
	void setDecider(int requestID, int positionID);
	
	void awardReimbursement (int requestID, double amount);
	
	void resetAvailableReimbursement (int empID, double Reimbursement);
	
	void autoApproveRequest(int requestID, int daysElapsed);
	
	List<ReimbursementRequest> getRequestsByRole(int roleID);
	
	List<RequestStatus> getRequestStatusByRole(int roleID);
	
}
