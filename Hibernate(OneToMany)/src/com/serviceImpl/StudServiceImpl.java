package com.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Student;
import com.entity.Subject;
import com.service.StudService;
import com.util.HibernateUtil;

public class StudServiceImpl implements StudService {

	SessionFactory sf = HibernateUtil.getConnection();

	@Override
	public void addStudentWithSubject() {

		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		Student st = new Student();
		System.out.println("Enter Student name :");
		st.setSname(sc.next());
		System.out.println("How many subject you want to add :");
		int n = sc.nextInt();
		List<Subject> listOfSubject = new ArrayList<Subject>();

		for (int i = 1; i <= n; i++) {
			Subject sub = new Subject();
			System.out.println("Enter the Subject name :");
			sub.setSubName(sc.next());

			listOfSubject.add(sub);
		}
		st.setListofsubject(listOfSubject);
		s.save(st);
		s.beginTransaction().commit();
		System.out.println("Added Successfully...");

	}

	@Override
	public void addSubjectOnly() {
		Session s = sf.openSession();
	    Scanner sc = new Scanner(System.in);
	    Subject sub = new Subject();

	    System.out.println("Enter Subject name: ");
	    sub.setSubName(sc.next());

	    s.beginTransaction();
	    s.save(sub);
	    s.getTransaction().commit();
	    s.close();

	    System.out.println("Added Successfully...");

	}

	@Override
	public void addStudentOnly() {
		Session s = sf.openSession();
	    Scanner sc = new Scanner(System.in);
	    Student st = new Student();

	    System.out.println("Enter Student name: ");
	    st.setSname(sc.next());

	    s.beginTransaction();
	    s.save(st);
	    s.getTransaction().commit();
	    s.close();

	    System.out.println("Added Successfully...");

	}

	@Override
	public void getStudentWithSubject() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("ENter the Student ID :- ");
		int id = sc.nextInt();
		Student stud = s.get(Student.class, id);

		if (stud != null) {
			System.out.println(stud);
		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void updateStudentOnly() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("ENter the Student ID :- ");
		int id = sc.nextInt();
		Student stu = s.get(Student.class, id);

		if (stu != null) {

			System.out.println("Enter new Name For Student :- ");
			stu.setSname(sc.next());
			s.update(stu);
			s.beginTransaction().commit();
			System.out.println("updated!!!!!");

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void updateSubjectOnly() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("ENter the Subject ID :- ");
		int id = sc.nextInt();
		Subject sub = s.get(Subject.class, id);
		if (sub != null) {
			System.out.println("Enter the new subject ");
			sub.setSubName(sc.next());
			s.update(sub);
			s.beginTransaction().commit();
			System.out.println("updated!!!!!");
		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void deleteSubjectOnlyUsingStuID() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("ENter the Student ID :- ");
		int id = sc.nextInt();
		Student stu = s.get(Student.class, id);

		if (stu != null) {

			List<Subject> ls = stu.getListofsubject();

			System.out.println("Enter the subject ID you want to delete :- ");
			int subId = sc.nextInt();
			Subject dummySub = null;
			for (Subject subject : ls) {

				if (subId == subject.getSubId()) {

					dummySub = subject;

				}
			}

			ls.remove(dummySub);
			s.delete(dummySub);
			s.beginTransaction().commit();
			System.out.println("Subject deleted!!!");

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void deleteStudentOnlyUsingStuID() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("ENter the Student ID :- ");
		int id = sc.nextInt();
		Student stu = s.get(Student.class, id);

		if (stu != null) {

			stu.setListofsubject(null);
			s.delete(stu);
			s.beginTransaction().commit();
			System.out.println("DEleted!!");

		} else {
			System.out.println("Invalid ID");
		}

	}

	@Override
	public void addExistingSubjectToStudent() {
		 
	}

	@Override
	public void addExistingStudentToSubject() {
		 
	}

}
