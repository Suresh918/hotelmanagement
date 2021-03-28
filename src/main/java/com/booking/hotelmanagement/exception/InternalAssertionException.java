package com.booking.hotelmanagement.exception;

import lombok.Getter;

@Getter
public class InternalAssertionException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final String message;

	public InternalAssertionException(String message) {
		this.message = message;
	}
}
