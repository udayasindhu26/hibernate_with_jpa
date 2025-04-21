package com.example.hibernate_jpa;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Department;
import model.Employeee;

public class App_insert_emp 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("myjpa");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        Scanner sc=new Scanner(System.in);
        
        Employeee e1=new Employeee();
//        Department d=new Department();
//        d.setLocation("tvr");
//        d.setDept_name("cse");
//        e1.setDept(d);
        try {
        	et.begin();
        	while(true)
        	{
        		System.out.println("Enter employee name: ");
        		String name=sc.nextLine();
        		System.out.println("enter email: ");
        		String email=sc.nextLine();
        		System.out.println("Enter password: ");
        		String password=sc.nextLine();
        		Employeee e4=new Employeee();
        		e4.setName(name);
        		e4.setEmail(email);
        		e4.setPassword(password);
        		em.persist(e4);
        		System.out.println("Do you want to add another employee details?(y/n): ");
        		String cho=sc.nextLine().trim().toLowerCase();
        		if(!cho.equals("y"))
        		{
        			break;
        		}
        	}
        	et.commit();
        	System.out.println("inserted successfully...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			emf.close();
	        em.close();
		}
        
        
        
        
    }
}
