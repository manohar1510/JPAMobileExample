package com.mindtree.JPAMobileExample.Client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mindtree.JPAMobileExample.dao.MobileDao;
import com.mindtree.JPAMobileExample.entity.Mobile;

public class MobileManagement {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MobileManagement");
		EntityManager entityManager = factory.createEntityManager();
		MobileDao mobiledao = new MobileDao();
		int choice;
		do {
			choice = getchoice();
			switch (choice) {
			case 1:
				Mobile newMobile = getNewMobile();
				mobiledao.addNewMobile(entityManager,newMobile);
				break;
			case 2:
				int newIdtoget = getId();
				mobiledao.getMobileDetails(entityManager,newIdtoget);
				break;
			case 3:
				int newIdToUpdate = getId();
				String newOS=getOSToUpdate();
				mobiledao.updateMobileDetails(entityManager,newIdToUpdate,newOS);
				break;
			case 4:
				int newIdToDelete = getId();
				mobiledao.deleteMobileDetails(entityManager,newIdToDelete);
				break;
			case 5:
				System.out.println("Successfully Exited!!");
				System.exit(1);
				break;
			default:
				System.out.println("Invalid Choice!");
			}
		} while (choice > 0 && choice <= 5);
	}

	private static String getOSToUpdate() {
		System.out.println("Enter the OS of Mobile");
		scan.nextLine();
		String newOS = scan.nextLine();
		return newOS;
	}

	private static int getId() {
		System.out.println("Enter the Id of Mobile");
		int newId = scan.nextInt();
		return newId;
	}

	private static Mobile getNewMobile() {
		System.out.println("Enter the Mobile ID");
		int mid = scan.nextInt();
		System.out.println("Enter the Brand Name");
		scan.nextLine();
		String mbrand = scan.nextLine();
		System.out.println("Enter the OS Used");
		String OS = scan.nextLine();
		Mobile newMobile = new Mobile(mid,mbrand,OS);
		return newMobile;
	}

	private static int getchoice() {
		System.out.println("Enter 1 to Add Mobile Data");
		System.out.println("Enter 2 to Print/Read Mobile data");
		System.out.println("Enter 3 to Update Mobile data");
		System.out.println("Enter 4 to Delete Mobile data");
		System.out.println("Enter 5 to Exit");
		System.out.println("Enter your desired choice");
		int choice = scan.nextInt();
		return choice;
	}
}
