package com.netcracker.scp.lab.constants;

public final class Constants {

	public static final String START = "START";
	public static final String END = "END";
	
	private Constants() {
		// this prevents even the native class from
		// calling this ctor as well :
		throw new AssertionError();
	}
}
