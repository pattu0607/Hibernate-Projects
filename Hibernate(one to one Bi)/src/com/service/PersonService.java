package com.service;

public interface PersonService {

	public void addPersonWithAdhar();

	public void getPersonOnly();

	public void getAdharOnly();

	public void deletePersonwithAdharUsingPid();

	public void deletePersonOnlyUsingPid();

	public void deteleAdharOnlyUsingPid();

	public void deletePersonOnlyUsingAid();

	public void deleteAdharOnlyUsingAid();
	
	public void addExistingPersonForExistingAadhar();
}
