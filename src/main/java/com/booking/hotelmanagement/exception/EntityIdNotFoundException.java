package com.booking.hotelmanagement.exception;

import lombok.Getter;

@Getter
public class EntityIdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final String entity;

	public EntityIdNotFoundException(String entityName) {
		this.entity = entityName;
	}

	public EntityIdNotFoundException() {
		entity = null;
	}
}
