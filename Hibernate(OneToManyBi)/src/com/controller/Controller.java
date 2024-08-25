package com.controller;

import java.util.Scanner;

import com.service.StudService;
import com.serviceImpl.StudServiceImpl;

public class Controller {

	public static void main(String[] args) {

		StudService ss = new StudServiceImpl();
		Scanner sc = new Scanner(System.in);
		int ch;
		boolean flag = true;

		while (flag) {
			System.out.println("------------------------------");
			System.out.println("------------------------------");
			System.out.println("1. add Student With Subject");
			System.out.println("2. get Student With Subject");
			System.out.println("3. update Student Only");
			System.out.println("4. update Subject Only");
			System.out.println("5. delete Subject Only");
			System.out.println("6. delete Student Only");
			System.out.println("7. add Existing Student To Subject");
			System.out.println("8. Exit");
			System.out.println("------------------------------");
			System.out.println("------------------------------");

			System.out.print("Enter your choice: ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				ss.addStudentWithSubject();
				break;
			case 2:
				ss.getStudentWithSubject();
				break;
			case 3:
				ss.updateStudentOnly();
				break;
			case 4:
				ss.updateSubjectOnly();
				break;
			case 5:
				ss.deleteSubjectOnly();
				break;
			case 6:
				ss.deleteStudentOnly();
				break;
			case 7:
				ss.addExistingStudentToSubject();
			case 8:
				flag = false;
				break;
			default:
				System.out.println("Invalid choice! ");
				break;
			}
		}
	}
}
