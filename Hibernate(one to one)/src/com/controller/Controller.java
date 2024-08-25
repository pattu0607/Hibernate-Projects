package com.controller;

import java.util.Scanner;

import com.service.PersonService;
import com.serviceImpl.ServiceImpl;

public class Controller {

	public static void main(String[] args) {

		PersonService ps = new ServiceImpl();
		Scanner sc = new Scanner(System.in);
		int ch;
		boolean flag = true;

		while (flag) {
			System.out.println("------------------------------");
			System.out.println("------------------------------");
			System.out.println("1. Add Person with Aadhar");
			System.out.println("2. Get Person Only");
			System.out.println("3. Get Aadhar Only");
			System.out.println("4. Update Person");
			System.out.println("5. Delete Person");
			System.out.println("6. Delete Person Only");
			System.out.println("7. Exit");
			System.out.println("------------------------------");
			System.out.println("------------------------------");

			System.out.print("Enter your choice: ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				ps.addPersonWithAadhar();
				break;
			case 2:
				ps.getPersonOnly();
				break;
			case 3:
				ps.getAadharOnly();
				break;
			case 4:
				ps.updatePerson();
				break;
			case 5:
				ps.deletePerson();
				break;
			case 6:
				ps.deletePersonOnly();
				break;
			case 7:
				flag = false;
				break;
			default:
				System.out.println("Invalid choice! ");
				break;
			}
		}
	}
}
