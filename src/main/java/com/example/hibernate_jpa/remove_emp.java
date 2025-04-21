package com.example.hibernate_jpa;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Employeee;

public class remove_emp {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("myjpa");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enter id to remove_emp: ");
			int id=sc.nextInt();
			et.begin();
			Employeee e2=em.find(Employeee.class, id);
			if(e2!=null) {
				em.remove(e2);
				System.out.println("data deleted successfully...");
				et.commit();
			}else {
				System.out.println("employee not found with given id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			emf.close();
			em.close();
			
		}
	}

}
