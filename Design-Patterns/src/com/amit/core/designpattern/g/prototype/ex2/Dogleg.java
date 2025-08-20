package com.amit.core.designpattern.g.prototype.ex2;

public class Dogleg {
	public int noOfLeg;
	
	public void setNoOfLeg(int noOfLeg) {
		this.noOfLeg = noOfLeg;
	}
	public int getNoOfLeg() {
		return noOfLeg;
	}
	@Override
	public String toString() {
		return "Dogleg [noOfLeg=" + noOfLeg + "]";
	}
}
