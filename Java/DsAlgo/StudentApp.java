import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student{
	int rollno;
	String name;
	int age;
	Student(int roll, String nam,int ag){
		rollno = roll;
		name = nam;
		age = ag;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return this.rollno+""+this.name+" "+this.age;
	}
}
class AgeCom implements Comparator<Student>{


	@Override
	public int compare(Student s0, Student s1) {
		if(s0.getAge()==s1.getAge())
		return 0;
		else if(s0.getAge()<s1.getAge())
			return -1;
		else return 1;
	}
	
}
public class StudentApp {
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(3,"amit",8));
		studentList.add(new Student(2,"amit",4));
		studentList.add(new Student(5,"amit",2));
		studentList.add(new Student(8,"amit",1));
		studentList.add(new Student(7,"amit",5));
		Collections.sort(studentList,new AgeCom());
		for(Student s:studentList) {
			System.out.println(s);
		}	
		
	}

}