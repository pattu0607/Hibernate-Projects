package com.controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.service.StudService;
import com.serviceImpl.StudServiceImpl;
import com.util.HibernateUtil;

public class Controller {

	public static void main(String[] args) {

//		-------------------(n+1) problem--------------------------------------
//		SessionFactory sf=HibernateUtil.getConnection();
//		Session s=sf.openSession();
//		Query query=s.createQuery("From Student s join fetch s.listofsubject");
//		Query query=s.createQuery("From Student ");
//
//		System.out.println(query.getResultList());
//		--------------------------------------------------------------------------
		
		StudService ss = new StudServiceImpl();
		Scanner sc = new Scanner(System.in);
		int ch;
		boolean flag = true;

		while (flag) {
			System.out.println("------------------------------");
			System.out.println("------------------------------");
			System.out.println("1. add Student With Subject");
			System.out.println("2. add Subject Only");
			System.out.println("3. add Student Only");
			System.out.println("4. get Student With Subject");
			System.out.println("5. update Student Only");
			System.out.println("6. update Subject Only");
			System.out.println("7. delete Subject Only Using StuID");
			System.out.println("8. delete Student Only Using StuID");
			System.out.println("9. add Existing Subject To Student");
			System.out.println("10. add Existing Student To Subject");
			System.out.println("11. Exit");
			System.out.println("------------------------------");
			System.out.println("------------------------------");

			System.out.print("Enter your choice: ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				ss.addStudentWithSubject();
				break;
			case 2:
				ss.addSubjectOnly();
				break;
			case 3:
				ss.addStudentOnly();
				break;
			case 4:
				ss.getStudentWithSubject();
				break;
			case 5:
				ss.updateStudentOnly();
				break;
			case 6:
				ss.updateSubjectOnly();
				break;
			case 7:
				ss.deleteSubjectOnlyUsingStuID();
				break;
			case 8:
				ss.deleteStudentOnlyUsingStuID();
				break;
			case 9:
				ss.addExistingSubjectToStudent();
				break;
			case 10:
				ss.addExistingStudentToSubject();
				break;
			case 11:
				flag = false;
				break;
			default:
				System.out.println("Invalid choice! ");
				break;
			}
		}
	}
}
