package com.booking.hotelmanagement.exception;

import lombok.Getter;

@Getter
public class MandatoryFieldViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final String entity;

	public MandatoryFieldViolationException(String entityName) {
		this.entity = entityName;
	}
}
