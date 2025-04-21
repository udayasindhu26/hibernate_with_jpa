package com.example.hibernate_jpa;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Employeee;

public class login_example_emp {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("myjpa");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enter email: ");
			String email1=sc.nextLine();
			System.out.println("enter password: ");
			String password1=sc.nextLine();
			et.begin();
			List<Employeee> li=em.createQuery("from Employeee",Employeee.class).getResultList();
			boolean login=false;
			for(Employeee e1:li)
			{
			if(e1.getEmail().equals(email1) && e1.getPassword().equals(password1))
			{
				System.out.println("login successful");
				System.out.println("Welcome "+e1.getName());
				login=true;
				break;
			}
			}
			if(!login)
			{
				System.out.println("failed in login..");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
