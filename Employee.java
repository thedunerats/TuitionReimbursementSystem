package proj1.model;

public class Employee {

		private String userName;
		private String password;
		private String firstName;
		private String lastName;
		private String eMailAddress;
		private String occupation;
		private int positionID;
		private double amountClaimedThisYear;
		
		//field constructor


		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(String userName, String password, String firstName, String lastName, String eMailAddress,
				String occupation, int positionID, double amountClaimedThisYear) {
			super();
			this.userName = userName;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.eMailAddress = eMailAddress;
			this.occupation = occupation;
			this.positionID = positionID;
			this.amountClaimedThisYear = amountClaimedThisYear;
		}

		public String getUserName() {
			return userName;
		}

		public String geteMailAddress() {
			return eMailAddress;
		}

		public void seteMailAddress(String eMailAddress) {
			this.eMailAddress = eMailAddress;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getOccupation() {
			return occupation;
		}

		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}

		public int getPositionID() {
			return positionID;
		}

		public void setPositionID(int positionID) {
			this.positionID = positionID;
		}

		public double getAmountClaimedThisYear() {
			return amountClaimedThisYear;
		}

		public void setAmountClaimedThisYear(double amountClaimedThisYear) {
			this.amountClaimedThisYear = amountClaimedThisYear;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(amountClaimedThisYear);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((eMailAddress == null) ? 0 : eMailAddress.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + positionID;
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
			Employee other = (Employee) obj;
			if (Double.doubleToLongBits(amountClaimedThisYear) != Double.doubleToLongBits(other.amountClaimedThisYear))
				return false;
			if (eMailAddress == null) {
				if (other.eMailAddress != null)
					return false;
			} else if (!eMailAddress.equals(other.eMailAddress))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (occupation == null) {
				if (other.occupation != null)
					return false;
			} else if (!occupation.equals(other.occupation))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (positionID != other.positionID)
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Employee [userName=" + userName + ", password=" + password + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", eMailAddress=" + eMailAddress + ", occupation=" + occupation
					+ ", positionID=" + positionID + ", amountClaimedThisYear=" + amountClaimedThisYear + "]";
		}
		
		
		
		
}
