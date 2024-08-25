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
	public void addPersonWithAadhar() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		Person p = new Person();

		System.out.println("Enter the person name :");
		p.setPname(sc.next());

		System.out.println("Enter the person address :");
		p.setPaddress(sc.next());

		Aadhar ad = new Aadhar();
		System.out.println("Enter Aadhar number");
		ad.setAadharNumber(sc.nextLong());
		p.setAadhar(ad);

		s.save(p);
		s.beginTransaction().commit();
		System.out.println("Success");

	}

	@Override
	public void getPersonOnly() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the person id :");
		int id = sc.nextInt();
		Person p = s.get(Person.class, id);

		if (p != null) {

			System.out.println(p.getPid());
			System.out.println(p.getPname());
			System.out.println(p.getPaddress());
		} else {
			System.out.println("Invalid Id....!");
		}

	}

	@Override
	public void getAadharOnly() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the person id :");
		int id = sc.nextInt();
		Person p = s.get(Person.class, id);

		if (p != null) {

			System.out.println(p.getAadhar().getAid());
			System.out.println(p.getAadhar().getAadharNumber());

		} else {
			System.out.println("Invalid Id....!");
		}

	}

	@Override
	public void updatePerson() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the person id :");
		int id = sc.nextInt();
		Person p = s.get(Person.class, id);

		if (p != null) {

			System.out.println("Enter the new person name :");
			p.setPname(sc.next());

			System.out.println("Enter new person address:");
			p.setPaddress(sc.next());

			System.out.println("Enter aadhar id :");
			Aadhar ad = s.get(Aadhar.class, sc.hasNextInt());
			if (ad != null) {

				System.out.println("Enter the new Aadhar number :");
				ad.setAadharNumber(sc.nextLong());
				p.setAadhar(ad);
			} else {
				System.out.println("Aadhar details don't exist!");
			}

		} else {
			System.out.println("Invalid Id....!");
		}
		s.update(p);
		s.beginTransaction().commit();
		System.out.println("Update successful!");
	}

	@Override
	public void deletePerson() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the person id :");
		int id = sc.nextInt();
		Person p = s.get(Person.class, id);

		if (p != null) {

			s.delete(p);
			s.beginTransaction().commit();
			System.out.println("Person has been deleted");

		} else {
			System.out.println("Invalid Id....!");
		}

	}

	@Override
	public void deletePersonOnly() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the person id :");
		int id = sc.nextInt();
		Person p = s.get(Person.class, id);

		if (p != null) {

			p.setAadhar(null);
			s.update(p);
			s.delete(p);
			s.beginTransaction().commit();
			System.out.println("Deleted successfully");

		} else {
			System.out.println("Invalid Id....!");
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
