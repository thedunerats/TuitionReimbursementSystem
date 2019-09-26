package proj1.model;

import java.sql.Timestamp;

public class ReimbursementRequest {
	
	private int requestID;
	private int employeeID;
	private Timestamp submittedDate;
	private double Tuition;
	private String description;
	private String requestStatus;
	private String passingGrade;
	private String courseTitle;
	private boolean urgencyStatus;
	private int daysUntilStart;
	private int workDaysMissed;
	private double fees;
	private String courseType;
	private String location;
	private Timestamp startdate;
	private String gradingFormat;
	private int occupationID;
	
	public ReimbursementRequest(int requestID, int employeeID, Timestamp submittedDate, double tuition,
			String description, String requestStatus, String passingGrade, String courseTitle, boolean urgencyStatus,
			int daysUntilStart, int workDaysMissed, double fees, String courseType, String location,
			Timestamp startdate, String gradingFormat, int occupationID) {
		super();
		this.requestID = requestID;
		this.employeeID = employeeID;
		this.submittedDate = submittedDate;
		Tuition = tuition;
		this.description = description;
		this.requestStatus = requestStatus;
		this.passingGrade = passingGrade;
		this.courseTitle = courseTitle;
		this.urgencyStatus = urgencyStatus;
		this.daysUntilStart = daysUntilStart;
		this.workDaysMissed = workDaysMissed;
		this.fees = fees;
		this.courseType = courseType;
		this.location = location;
		this.startdate = startdate;
		this.gradingFormat = gradingFormat;
		this.occupationID = occupationID;
	}

	public ReimbursementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public Timestamp getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;
	}

	public double getTuition() {
		return Tuition;
	}

	public void setTuition(double tuition) {
		Tuition = tuition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public boolean isUrgencyStatus() {
		return urgencyStatus;
	}

	public void setUrgencyStatus(boolean urgencyStatus) {
		this.urgencyStatus = urgencyStatus;
	}

	public int getDaysUntilStart() {
		return daysUntilStart;
	}

	public void setDaysUntilStart(int daysUntilStart) {
		this.daysUntilStart = daysUntilStart;
	}

	public int getWorkDaysMissed() {
		return workDaysMissed;
	}

	public void setWorkDaysMissed(int workDaysMissed) {
		this.workDaysMissed = workDaysMissed;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getStartdate() {
		return startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public int getOccupationID() {
		return occupationID;
	}

	public void setOccupationID(int occupationID) {
		this.occupationID = occupationID;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Tuition);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((courseTitle == null) ? 0 : courseTitle.hashCode());
		result = prime * result + ((courseType == null) ? 0 : courseType.hashCode());
		result = prime * result + daysUntilStart;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employeeID;
		temp = Double.doubleToLongBits(fees);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((gradingFormat == null) ? 0 : gradingFormat.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + occupationID;
		result = prime * result + ((passingGrade == null) ? 0 : passingGrade.hashCode());
		result = prime * result + requestID;
		result = prime * result + ((requestStatus == null) ? 0 : requestStatus.hashCode());
		result = prime * result + ((startdate == null) ? 0 : startdate.hashCode());
		result = prime * result + ((submittedDate == null) ? 0 : submittedDate.hashCode());
		result = prime * result + (urgencyStatus ? 1231 : 1237);
		result = prime * result + workDaysMissed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementRequest other = (ReimbursementRequest) obj;
		if (Double.doubleToLongBits(Tuition) != Double.doubleToLongBits(other.Tuition))
			return false;
		if (courseTitle == null) {
			if (other.courseTitle != null)
				return false;
		} else if (!courseTitle.equals(other.courseTitle))
			return false;
		if (courseType == null) {
			if (other.courseType != null)
				return false;
		} else if (!courseType.equals(other.courseType))
			return false;
		if (daysUntilStart != other.daysUntilStart)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (Double.doubleToLongBits(fees) != Double.doubleToLongBits(other.fees))
			return false;
		if (gradingFormat == null) {
			if (other.gradingFormat != null)
				return false;
		} else if (!gradingFormat.equals(other.gradingFormat))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (occupationID != other.occupationID)
			return false;
		if (passingGrade == null) {
			if (other.passingGrade != null)
				return false;
		} else if (!passingGrade.equals(other.passingGrade))
			return false;
		if (requestID != other.requestID)
			return false;
		if (requestStatus == null) {
			if (other.requestStatus != null)
				return false;
		} else if (!requestStatus.equals(other.requestStatus))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		if (submittedDate == null) {
			if (other.submittedDate != null)
				return false;
		} else if (!submittedDate.equals(other.submittedDate))
			return false;
		if (urgencyStatus != other.urgencyStatus)
			return false;
		if (workDaysMissed != other.workDaysMissed)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementRequest [requestID=" + requestID + ", employeeID=" + employeeID + ", submittedDate="
				+ submittedDate + ", Tuition=" + Tuition + ", description=" + description + ", requestStatus="
				+ requestStatus + ", passingGrade=" + passingGrade + ", courseTitle=" + courseTitle + ", urgencyStatus="
				+ urgencyStatus + ", daysUntilStart=" + daysUntilStart + ", workDaysMissed=" + workDaysMissed
				+ ", fees=" + fees + ", courseType=" + courseType + ", location=" + location + ", startdate="
				+ startdate + ", gradingFormat=" + gradingFormat + ", occupationID=" + occupationID + "]";
	}
	

	
}
