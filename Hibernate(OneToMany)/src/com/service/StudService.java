package com.service;

public interface StudService {

	public void addStudentWithSubject();
	
	public void addSubjectOnly();
	
	public void addStudentOnly();
	
	public void getStudentWithSubject();
	
	public void updateStudentOnly();
	
	public void updateSubjectOnly();
	
	public void deleteSubjectOnlyUsingStuID();

	public void deleteStudentOnlyUsingStuID();
	
	public void addExistingSubjectToStudent();
	
	public void addExistingStudentToSubject();

	
	
}
