package com.cg.oas.exception;

public class CourseNotFoundException extends RuntimeException{
	public CourseNotFoundException(String msg)
	{
		super(msg);
	}

}
