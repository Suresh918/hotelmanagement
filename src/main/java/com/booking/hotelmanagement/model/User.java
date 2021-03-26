package com.booking.hotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	String userId;

	String fullName;

	String email;

	String departmentName;

	String abbreviation;

	public User(User user) {
		this.userId = user.getUserId();
		this.fullName = user.getFullName();
		this.abbreviation = user.getAbbreviation();
		this.departmentName = user.getDepartmentName();
		this.email = user.getEmail();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User userElement = (User) o;
		return Objects.equals(getUserId(), userElement.getUserId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUserId());
	}

}
