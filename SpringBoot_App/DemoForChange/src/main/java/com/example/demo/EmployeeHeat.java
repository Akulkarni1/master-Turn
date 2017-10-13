package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeheat")
public class EmployeeHeat {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="eid")
   private long eid;
   @Column(name="name")
   private String name;
   @Column(name="salary")
   private double salary;
   @Column(name ="newentry")
   private boolean newentry;
	
	@Column(name="deg")
	   private String deg;
	
public void setNewEntry(boolean newEntry) {
	this.newentry = newEntry;
}

   
   public EmployeeHeat(Long eid, String ename, double salary, String deg,boolean entry) {
      //super( );
      this.eid = eid;
      this.name = ename;
      this.salary = salary;
      this.deg = deg;
      this.newentry = entry;
   }
   public EmployeeHeat( String ename, double salary, String deg,boolean entry) {
	      //super( );
	      //this.eid = eid;
	      this.name = ename;
	      this.salary = salary;
	      this.deg = deg;
	      this.newentry = entry;
	   }

   public EmployeeHeat(boolean entry ) {
      super();
      this.newentry = entry;
      
   }
   public EmployeeHeat( ) {
	      super();
	   }

   public long getEid( ) {
      return eid;
   }
   
   public void setEid(long eid) {
      this.eid = eid;
   }
   
   public String getEname( ) {
      return name;
   }
   
   public void setEname(String ename) {
      this.name = ename;
   }

   public double getSalary( ) {
      return salary;
   }
   
   public void setSalary(double salary) {
      this.salary = salary;
   }

   public String getDeg( ) {
      return deg;
   }
   
   public void setDeg(String deg) {
      this.deg = deg;
   }
   public boolean getEntry() {
	   return this.newentry;
   }
   @Override
   public String toString() {
      return "Employee [eid=" + eid + ", ename=" + name + ", salary=" + salary + ", deg=" + deg + "new Entry= "+newentry+"]";
   }
}