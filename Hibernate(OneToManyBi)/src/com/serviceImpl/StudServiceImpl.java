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
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentWithSubject() {
		Session s = sf.openSession();
		Student stu = new Student();
		System.out.println("Enter the Student name :");
		stu.setSname(sc.next());
		System.out.println("How many subject you want to add :");
		int n = sc.nextInt();
		List<Subject> subList = new ArrayList<Subject>();

		for (int i = 1; i <= n; i++) {
			Subject sub = new Subject();
			System.out.println("Enter subject name :");
			sub.setSubName(sc.next());

			sub.setStudent(stu);
			subList.add(sub);

		}
		stu.setListofsubject(subList);
		s.save(stu);
		s.beginTransaction().commit();
		System.out.println("Success");

	}

	@Override
	public void getStudentWithSubject() {
		Session s = sf.openSession();
		System.out.println("Enter student id :");
		int id = sc.nextInt();
		Student stu = s.get(Student.class, id);
		if (stu != null) {
			System.out.println(stu);
		} else {
			System.out.println("Invalid id..!");
		}

	}

	@Override
	public void updateStudentOnly() {
		Session s = sf.openSession();
		System.out.println("Enter student id :");
		int id = sc.nextInt();
		Student stu = s.get(Student.class, id);
		if (stu != null) {
			System.out.println("Enter new name :");
			stu.setSname(sc.next());
			s.update(stu);
			s.beginTransaction().commit();
			System.out.println("Updated Successfully..");
		} else {
			System.out.println("Invalid id..!");
		}

	}

	@Override
	public void updateSubjectOnly() {

		Session s = sf.openSession();
		System.out.println("Enter student id :");
		int id = sc.nextInt();
		Student stu = s.get(Student.class, id);
		if (stu != null) {
			List<Subject> listOfSubject = stu.getListofsubject();
			System.out.println("Enter the subject id :");
			int subid = sc.nextInt();
			Subject dummysubject = null;

			for (Subject subject : listOfSubject) {
				if (subid == subject.getSubId()) {
					dummysubject = subject;
				}

			}
			System.out.println("Enter the new subject name :");
			dummysubject.setSubName(sc.next());
			s.update(dummysubject);
			s.beginTransaction().commit();
			System.out.println("Updated Successfully..");
		} else {
			System.out.println("Invalid id...!");
		}

	}

	@Override
	public void deleteStudentOnly() {
		Session s = sf.openSession();
		System.out.println("Enter student id :");
		int id = sc.nextInt();
		Student stu = s.get(Student.class, id);
		if (stu != null) {
			List<Subject> listOfSubject = stu.getListofsubject();
			for (Subject subject : listOfSubject) {
				subject.setStudent(null);

			}
			stu.setListofsubject(null);
			s.update(stu);
			s.delete(stu);
			s.beginTransaction().commit();
			System.out.println("success");
		} else {
			System.out.println("Invalid id..!");
		}

	}

	@Override
	public void deleteSubjectOnly() {
		Session s = sf.openSession();
		System.out.println("Enter student id :");
		int id = sc.nextInt();
		Student stu = s.get(Student.class, id);
		if (stu != null) {
			List<Subject> listOfSubject = stu.getListofsubject();
			System.out.println("Enter the subject id you want to delete :");
			int subid = sc.nextInt();
			Subject dummysubject = null;

			for (Subject subject : listOfSubject) {
				if (subid == subject.getSubId()) {
					dummysubject = subject;
				}

			}
			dummysubject.setStudent(null);
			listOfSubject.remove(dummysubject);
			s.update(dummysubject);
			s.delete(dummysubject);
			s.beginTransaction().commit();
			System.out.println("subject Deleted!");
		} else {
			System.out.println("Invalid id...!");
		}


	}

	@Override
	public void addExistingStudentToSubject() {
		Session s = sf.openSession();
		System.out.println("Enter the student id :");
		Student stu=s.get(Student.class, sc.nextInt());
		System.out.println("Enter the subject id :");
		Subject sub=s.get(Subject.class, sc.nextInt());
		if(stu!=null) {
			if(sub!=null && sub.getStudent()==null) {
				sub.setStudent(stu);
				s.saveOrUpdate(sub);
				s.beginTransaction().commit();
				System.out.println("success");
			}
			 
			else {
				System.out.println("Subject is already associated..");
				}
			
		}else {
			System.out.println("Invalid student id..");
		}
		
		
		
	}

}
