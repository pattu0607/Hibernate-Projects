package com.controller;

import java.util.Scanner;

import com.serviceImpl.ServiceImpl;

public class Controller {

	public static void main(String[] args) {
		
	ServiceImpl si=new ServiceImpl();
	Scanner sc = new Scanner(System.in);
	int ch;
	boolean flag = true;

	while (flag) {
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("1. Add Person with Aadhar");
		System.out.println("2. Get Person only");
		System.out.println("3. Get Aadhar Only");
		System.out.println("4. delete Person with Adhar Using Pid");
		System.out.println("5. delete Person Only Using Pid");
		System.out.println("6. detele Adhar Only Using Pid");
		System.out.println("7. delete Person Only Using Aid");
		System.out.println("8. delete Adhar Only Using Aid");
		System.out.println("9. add Existing Person For Existing Aadhar");
		System.out.println("10. Exit");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		
		System.out.print("Enter your choice: ");
		ch = sc.nextInt();

		switch (ch) {
		case 1:
			si.addPersonWithAdhar();
			break;
		case 2:
			si.getPersonOnly();
			break;
		case 3:
			si.getAdharOnly();
			break;
		case 4:
			si.deletePersonwithAdharUsingPid();
			break;
		case 5:
			si.deletePersonOnlyUsingPid();
			break;
		case 6:
			si.deteleAdharOnlyUsingPid();
			break;
		case 7:
			si.deletePersonOnlyUsingAid();
			break;
		case 8:
			si.deleteAdharOnlyUsingAid();
			break;
		case 9:
			si.addExistingPersonForExistingAadhar();
		    break;
		case 10:
			flag = false;
			break;
		default:
			System.out.println("Invalid choice! ");
			break;
		}
	}
}
}
