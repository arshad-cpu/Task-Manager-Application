package com.taskManaager.dto;

public class UserDTO {

	    private Long userId;
	    private String firstName;
	    private String lastName;
	    private String timeZone;
	    private boolean isActive;
		
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
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
		public String getTimeZone() {
			return timeZone;
		}
		public void setTimeZone(String timeZone) {
			this.timeZone = timeZone;
		}
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
		@Override
		public String toString() {
			return "UserDTO [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", timeZone="
					+ timeZone + ", isActive=" + isActive + "]";
		}

	    // getters and setters
	
}
