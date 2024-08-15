package com.taskManaager.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
		public int hashCode() {
			return Objects.hash(firstName, userId, isActive, lastName, timeZone);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(firstName, other.firstName) && Objects.equals(userId, other.userId)
					&& isActive == other.isActive && Objects.equals(lastName, other.lastName)
					&& Objects.equals(timeZone, other.timeZone);
		}
		@Override
		public String toString() {
			return "User [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", timeZone=" + timeZone
					+ ", isActive=" + isActive + "]";
		}
	
}
