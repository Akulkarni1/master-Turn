package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*create Table employee{
 * eid bigint primary key not Null,
 * name    text not null,
 * salary real not null,
 * deg text
 * }; 
 *This demo is for the displaying the change between the tables .
 */
@Entity
@Table(name = "employee")
public class Employee {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="eid")
   private long eid;
   @Column(name="name")
   private String name;
   @Column(name="salary")
   private double salary;
   @Column(name="deg")
   private String deg;
   
   public Employee(Long eid, String ename, double salary, String deg) {
      //super( );
      this.eid = eid;
      this.name = ename;
      this.salary = salary;
      this.deg = deg;
   }
   public Employee( String ename, double salary, String deg) {
	      super( );
	      //this.eid = eid;
	      this.name = ename;
	      this.salary = salary;
	      this.deg = deg;
	   }

   public Employee( ) {
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
   
   @Override
   public String toString() {
      return "Employee [eid=" + eid + ", ename=" + name + ", salary=" + salary + ", deg=" + deg + "]";
   }
}