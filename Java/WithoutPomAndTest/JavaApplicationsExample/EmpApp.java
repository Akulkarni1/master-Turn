
//Serilization example.
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Emp implements Serializable {
	int id;
	String name;
	transient String add;

	Emp(int id, String name, String add) {
		this.id = id;
		this.name = name;
		this.add = add;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class EmpApp {
	public static void main(String[] args) throws IOException, Exception {
		String filename = "temp.txt";
		Emp e1 = new Emp(1000, "Amit", "India");
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(file);

		out.writeObject(e1);
		out.flush();
		System.out.println("Success");
		System.out.println(filename);

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		Emp s = (Emp) in.readObject();
		System.out.println(s.id + " " + s.name + " " + s.add);
		System.out.println("Success");
	}
}
