package proj1.model;

public class RequestStatus {
	
	private int requestID;
	private String Decision;
	private String decisionMaker;
	private String extraEmployeeInfo;
	private String extraSupervisorInfo;
	private String extraHeadInfo;
	private double amountAwarded;
	private String reasonForDecision;
	private boolean isExceeding;
	private String supervisorDecision;
	private String depHeadDecision;
	private String benCoDecision;
	private int occupationID;
	public RequestStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestStatus(int requestID, String decision, String decisionMaker, String extraEmployeeInfo,
			String extraSupervisorInfo, String extraHeadInfo, double amountAwarded, String reasonForDecision,
			boolean isExceeding, String supervisorDecision, String depHeadDecision, String benCoDecision,
			int occupationID) {
		super();
		this.requestID = requestID;
		Decision = decision;
		this.decisionMaker = decisionMaker;
		this.extraEmployeeInfo = extraEmployeeInfo;
		this.extraSupervisorInfo = extraSupervisorInfo;
		this.extraHeadInfo = extraHeadInfo;
		this.amountAwarded = amountAwarded;
		this.reasonForDecision = reasonForDecision;
		this.isExceeding = isExceeding;
		this.supervisorDecision = supervisorDecision;
		this.depHeadDecision = depHeadDecision;
		this.benCoDecision = benCoDecision;
		this.occupationID = occupationID;
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public String getDecision() {
		return Decision;
	}
	public void setDecision(String decision) {
		Decision = decision;
	}
	public String getDecisionMaker() {
		return decisionMaker;
	}
	public void setDecisionMaker(String decisionMaker) {
		this.decisionMaker = decisionMaker;
	}
	public String getExtraEmployeeInfo() {
		return extraEmployeeInfo;
	}
	public void setExtraEmployeeInfo(String extraEmployeeInfo) {
		this.extraEmployeeInfo = extraEmployeeInfo;
	}
	public String getExtraSupervisorInfo() {
		return extraSupervisorInfo;
	}
	public void setExtraSupervisorInfo(String extraSupervisorInfo) {
		this.extraSupervisorInfo = extraSupervisorInfo;
	}
	public String getExtraHeadInfo() {
		return extraHeadInfo;
	}
	public void setExtraHeadInfo(String extraHeadInfo) {
		this.extraHeadInfo = extraHeadInfo;
	}
	public double getAmountAwarded() {
		return amountAwarded;
	}
	public void setAmountAwarded(double amountAwarded) {
		this.amountAwarded = amountAwarded;
	}
	public String getReasonForDecision() {
		return reasonForDecision;
	}
	public void setReasonForDecision(String reasonForDecision) {
		this.reasonForDecision = reasonForDecision;
	}
	public boolean isExceeding() {
		return isExceeding;
	}
	public void setExceeding(boolean isExceeding) {
		this.isExceeding = isExceeding;
	}
	public String getSupervisorDecision() {
		return supervisorDecision;
	}
	public void setSupervisorDecision(String supervisorDecision) {
		this.supervisorDecision = supervisorDecision;
	}
	public String getDepHeadDecision() {
		return depHeadDecision;
	}
	public void setDepHeadDecision(String depHeadDecision) {
		this.depHeadDecision = depHeadDecision;
	}
	public String getBenCoDecision() {
		return benCoDecision;
	}
	public void setBenCoDecision(String benCoDecision) {
		this.benCoDecision = benCoDecision;
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
		result = prime * result + ((Decision == null) ? 0 : Decision.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amountAwarded);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((benCoDecision == null) ? 0 : benCoDecision.hashCode());
		result = prime * result + ((decisionMaker == null) ? 0 : decisionMaker.hashCode());
		result = prime * result + ((depHeadDecision == null) ? 0 : depHeadDecision.hashCode());
		result = prime * result + ((extraEmployeeInfo == null) ? 0 : extraEmployeeInfo.hashCode());
		result = prime * result + ((extraHeadInfo == null) ? 0 : extraHeadInfo.hashCode());
		result = prime * result + ((extraSupervisorInfo == null) ? 0 : extraSupervisorInfo.hashCode());
		result = prime * result + (isExceeding ? 1231 : 1237);
		result = prime * result + occupationID;
		result = prime * result + ((reasonForDecision == null) ? 0 : reasonForDecision.hashCode());
		result = prime * result + requestID;
		result = prime * result + ((supervisorDecision == null) ? 0 : supervisorDecision.hashCode());
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
		RequestStatus other = (RequestStatus) obj;
		if (Decision == null) {
			if (other.Decision != null)
				return false;
		} else if (!Decision.equals(other.Decision))
			return false;
		if (Double.doubleToLongBits(amountAwarded) != Double.doubleToLongBits(other.amountAwarded))
			return false;
		if (benCoDecision == null) {
			if (other.benCoDecision != null)
				return false;
		} else if (!benCoDecision.equals(other.benCoDecision))
			return false;
		if (decisionMaker == null) {
			if (other.decisionMaker != null)
				return false;
		} else if (!decisionMaker.equals(other.decisionMaker))
			return false;
		if (depHeadDecision == null) {
			if (other.depHeadDecision != null)
				return false;
		} else if (!depHeadDecision.equals(other.depHeadDecision))
			return false;
		if (extraEmployeeInfo == null) {
			if (other.extraEmployeeInfo != null)
				return false;
		} else if (!extraEmployeeInfo.equals(other.extraEmployeeInfo))
			return false;
		if (extraHeadInfo == null) {
			if (other.extraHeadInfo != null)
				return false;
		} else if (!extraHeadInfo.equals(other.extraHeadInfo))
			return false;
		if (extraSupervisorInfo == null) {
			if (other.extraSupervisorInfo != null)
				return false;
		} else if (!extraSupervisorInfo.equals(other.extraSupervisorInfo))
			return false;
		if (isExceeding != other.isExceeding)
			return false;
		if (occupationID != other.occupationID)
			return false;
		if (reasonForDecision == null) {
			if (other.reasonForDecision != null)
				return false;
		} else if (!reasonForDecision.equals(other.reasonForDecision))
			return false;
		if (requestID != other.requestID)
			return false;
		if (supervisorDecision == null) {
			if (other.supervisorDecision != null)
				return false;
		} else if (!supervisorDecision.equals(other.supervisorDecision))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RequestStatus [requestID=" + requestID + ", Decision=" + Decision + ", decisionMaker=" + decisionMaker
				+ ", extraEmployeeInfo=" + extraEmployeeInfo + ", extraSupervisorInfo=" + extraSupervisorInfo
				+ ", extraHeadInfo=" + extraHeadInfo + ", amountAwarded=" + amountAwarded + ", reasonForDecision="
				+ reasonForDecision + ", isExceeding=" + isExceeding + ", supervisorDecision=" + supervisorDecision
				+ ", depHeadDecision=" + depHeadDecision + ", benCoDecision=" + benCoDecision + ", occupationID="
				+ occupationID + "]";
	}
	
	

}
