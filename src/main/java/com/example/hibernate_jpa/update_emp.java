package com.example.hibernate_jpa;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Employeee;

public class update_emp {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("myjpa");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enter id to update_emp: ");
			int id=sc.nextInt();
			sc.nextLine();
			et.begin();
			Employeee e2=em.find(Employeee.class,id);
			if(e2!=null)
			{
				System.out.println("enter column name to update_emp(name/email/password): ");
				String column=sc.nextLine().toLowerCase();
				System.out.println("enter value: ");
				String val=sc.nextLine();
				
//				em.merge(e2);
				
				
				if(column.equals("name"))
				{
					e2.setName(val);
				}else if(column.equals("email"))
				{
					e2.setEmail(val);
				}else if(column.equals("password"))
				{
					e2.setPassword(val);
				}else{
					System.out.println("invalid column name..");
					return;
				}
				et.commit();
				System.out.println("column updated successfully...");
			}else {
				System.out.println("failed to update_emp column");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			emf.close();
			em.close();
		}

	}

}
