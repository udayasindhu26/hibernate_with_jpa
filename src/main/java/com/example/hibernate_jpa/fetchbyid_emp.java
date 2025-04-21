package com.example.hibernate_jpa;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Employeee;

public class fetchbyid_emp {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("myjpa");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enter id: ");
			int id=sc.nextInt();
			Employeee e2=em.find(Employeee.class, id);
			if(e2!=null)
			{
//			List<Employeee> li=em.createQuery("from Employeee",Employeee.class).getResultList();
//			for(Employeee e:li)
//			{
//				System.out.println("id: "+e.getId()+"\nname: "+e.getName()+"\nemail: "+e.getEmail()+"\npassword: "+e.getPassword());
//			}	
				System.out.println("id: "+e2.getId());
				System.out.println("name: " + e2.getName());
			    System.out.println("email: " + e2.getEmail());
			    System.out.println("password: " + e2.getPassword());
			System.out.println("data feteched successfully...");
			}else {
				System.out.println("no employee is avalibale with given id...");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			emf.close();
			em.close();
		}

	}

}











//int id=2;
//et.begin();
//Employeee e1=em.find(Employeee.class, id);
//if(e1!=null) {

//
////	List<Employeee> li=em.createQuery("from Employeee",Employeee.class).getResultList();
////	for(Employeee e:li)
////	{
////		System.out.println("id: "+e.getId()+"\nname: "+e.getName()+"\nemail: "+e.getEmail()+"\npassword: "+e.getPassword());
////	}
//	
//	System.out.println("data fetced successsfully successfully..");
//}else {
//	System.out.println("failed to fetch");
//}
