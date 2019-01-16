package com.hniu.hibernate.bean;

public class Pay {
	private double monthSalary;
	private double yearSalary;
	private double holidaySalary;
	
	private Work work;

	public double getMonthSalary() {
		return monthSalary;
	}

	public void setMonthSalary(double monthSalary) {
		this.monthSalary = monthSalary;
	}

	public double getYearSalary() {
		return yearSalary;
	}

	public void setYearSalary(double yearSalary) {
		this.yearSalary = yearSalary;
	}

	public double getHolidaySalary() {
		return holidaySalary;
	}

	public void setHolidaySalary(double holidaySalary) {
		this.holidaySalary = holidaySalary;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public Pay(double monthSalary, double yearSalary, double holidaySalary,
			Work work) {
		super();
		this.monthSalary = monthSalary;
		this.yearSalary = yearSalary;
		this.holidaySalary = holidaySalary;
		this.work = work;
	}

	public Pay() {
		super();
	}

	@Override
	public String toString() {
		return "Pay [monthSalary=" + monthSalary + ", yearSalary=" + yearSalary
				+ ", holidaySalary=" + holidaySalary + ", work=" + work + "]";
	}
	
}
