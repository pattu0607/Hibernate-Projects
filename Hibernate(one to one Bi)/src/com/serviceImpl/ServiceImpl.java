package com.serviceImpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Aadhar;
import com.entity.Person;
import com.service.PersonService;
import com.util.HibernateUtil;

public class ServiceImpl implements PersonService {

	
	SessionFactory sf = HibernateUtil.getConnection();
	
	@Override
	public void addPersonWithAdhar() {
		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		Person p = new Person();
		System.out.println("Enter the Person Name :- ");
		p.setPname(sc.next());

		System.out.println("Enter the Person Address :- ");
		p.setPaddress(sc.next());

		Aadhar ad = new Aadhar();
		System.out.println("Enter the Adhar Number");
		ad.setAadharNumber(sc.nextLong());

		p.setAadhar(ad);
		ad.setPerson(p);

		s.save(p);
		s.beginTransaction().commit();
		System.out.println("success");
		
	}

	@Override
	public void getPersonOnly() {
		Scanner sc = new Scanner(System.in);
		Session s=sf.openSession();
		
		System.out.println("Enter the person id :");
		int id=sc.nextInt();
		Person p=s.get(Person.class, id);
		
		if(p!=null) {
			
			System.out.println(p.getPid());
			System.out.println(p.getPname());
			System.out.println(p.getPaddress());
		}else {
			System.out.println("Invalid Id....!");
		}
		
	}

	@Override
	public void getAdharOnly() {
		Scanner sc = new Scanner(System.in);
		Session s=sf.openSession();
		
		System.out.println("Enter the person id :");
		int id=sc.nextInt();
		Person p=s.get(Person.class, id);
		
		if(p!=null) {
			
			System.out.println(p.getAadhar().getAid());
			System.out.println(p.getAadhar().getAadharNumber());
			 
		}else {
			System.out.println("Invalid Id....!");
		}
		
	}

	@Override
	public void deletePersonwithAdharUsingPid() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("Enter the Pid :- ");
		int id = sc.nextInt();
		Person p = s.get(Person.class, id);
		if (p != null) {
			s.delete(p);
		} else {
			System.out.println("Invalid");
		}

		s.beginTransaction().commit();
		System.out.println("success");
		
	}

	@Override
	public void deletePersonOnlyUsingPid() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("Enter the Pid :- ");
		Person p = s.get(Person.class, sc.nextInt());
		if (p != null) {
			Aadhar ad = p.getAadhar();
			ad.setPerson(null);
			p.setAadhar(null);
			s.update(p);
			s.delete(p);
			s.beginTransaction().commit();
			System.out.println("Success");
		} else {
			System.out.println("Invalid ID");
		}
		
	}

	@Override
	public void deteleAdharOnlyUsingPid() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("Enter the Pid :- ");
		Person p = s.get(Person.class, sc.nextInt());
		if (p != null) {
			Aadhar ad = p.getAadhar();
			ad.setPerson(null);
			p.setAadhar(null);
			s.update(ad);
			s.delete(ad);
			s.beginTransaction().commit();
			System.out.println("Success");
		} else {
			System.out.println("Invalid ID");
		}
		
	}

	@Override
	public void deletePersonOnlyUsingAid() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("Enter the Aid :- ");
		Aadhar ad = s.get(Aadhar.class, sc.nextInt());

		if (ad != null) {

			Person p = ad.getPerson();
			p.setAadhar(null);
			ad.setPerson(null);
			s.update(ad);
			s.delete(p);
			s.beginTransaction().commit();
			System.out.println("Success");

		} else {
			System.out.println("Invalid ID");
		}
		
	}

	@Override
	public void deleteAdharOnlyUsingAid() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("Enter the Aid :- ");
		Aadhar ad = s.get(Aadhar.class, sc.nextInt());

		if (ad != null) {

			Person p = ad.getPerson();
			p.setAadhar(null);
			ad.setPerson(null);
			s.update(p);
			s.delete(ad);
			s.beginTransaction().commit();
			System.out.println("Success");

		} else {
			System.out.println("Invalid ID");
		}
		
	}

	@Override
	public void addExistingPersonForExistingAadhar() {
		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Person id:");
		Person p = s.get(Person.class, sc.nextInt());

		if (p != null && p.getAadhar() == null) {
			System.out.println("Enter Aadhar id :");
			Aadhar ad = s.get(Aadhar.class, sc.nextInt());
			if (ad != null) {
				p.setAadhar(ad);
				s.update(p);
				s.beginTransaction().commit();
			} else {
				System.out.println(" Invalid aadhar");
			}
		} else {
			System.out.println("Invalid id");
		}
		
	}

	
}
