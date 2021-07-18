package com.mindtree.JPAMobileExample.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mobile {
	@Id
	private int mid;
	private String mbrand;
	private String OS;
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(int mid, String mbrand, String oS) {
		super();
		this.mid = mid;
		this.mbrand = mbrand;
		OS = oS;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMbrand() {
		return mbrand;
	}
	public void setMbrand(String mbrand) {
		this.mbrand = mbrand;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	
	@Override
	public String toString() {
		return "Mobile [mid=" + mid + ", mbrand=" + mbrand + ", OS=" + OS + "]";
	}
	
}
