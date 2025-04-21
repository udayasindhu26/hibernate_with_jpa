package com.example.hibernate_jpa;

import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Employeee;


public class fetchall_emp {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("myjpa");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		try {
			List<Employeee> li=em.createQuery("from Employeee",Employeee.class).getResultList();
			for(Employeee e:li)
			{
				System.out.println("id: "+e.getId()+"\nname: "+e.getName()+"\nemail: "+e.getEmail()+"\npassword: "+e.getPassword());
			}	
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			emf.close();
			em.close();
		}

	}

}
