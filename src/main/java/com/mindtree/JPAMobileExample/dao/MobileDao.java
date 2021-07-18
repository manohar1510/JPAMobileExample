package com.mindtree.JPAMobileExample.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.mindtree.JPAMobileExample.entity.Mobile;

public class MobileDao {

	public void addNewMobile(EntityManager entityManager, Mobile newMobile) {
		// To Insert data into Database
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(newMobile);
		// Commit and Close
		entityTransaction.commit();
//		entityManager.close();
	}

	public void getMobileDetails(EntityManager entityManager, int newIdtoget) {
		// To Retrieve or Find data from database
		Mobile foundData = entityManager.find(Mobile.class, newIdtoget);
		System.out.println("Mobile id: " + foundData.getMid());
		System.out.println("Mobile brand: " + foundData.getMbrand());
		System.out.println("Mobile OS: " + foundData.getOS());
		// Close
//		entityManager.close();
	}

	public void updateMobileDetails(EntityManager entityManager, int newIdToUpdate, String newOS) {
		// To Update data in database
		EntityTransaction entityTransaction1 = entityManager.getTransaction();
		entityTransaction1.begin();
		Mobile mobileUpdate = entityManager.find(Mobile.class, newIdToUpdate);
		mobileUpdate.setOS(newOS);
		// Commit and Close
		entityTransaction1.commit();
//		entityManager.close();

	}

	public void deleteMobileDetails(EntityManager entityManager, int newIdToDelete) {
		// To delete data from database
		EntityTransaction entityTransaction2 = entityManager.getTransaction();
		entityTransaction2.begin();
		Mobile mobileDelete = entityManager.find(Mobile.class, newIdToDelete);
		entityManager.remove(mobileDelete);
		// Commit and Close
		entityTransaction2.commit();
//		entityManager.close();
	}

}
