import java.util.ArrayList;
import java.util.List;

class Node1 {
	class Student {
		int id;
		String name;
		String classname;

		Student(int id, String name, String classname) {
			this.id = id;
			this.name = name;
			this.classname = classname;
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

		public String getClassname() {
			return classname;
		}

		public void setClassname(String classname) {
			this.classname = classname;
		}

		public String toString() {
			return id + "" + name + "" + classname;
		}
	}

	Student data;
	boolean visited;
	List<Node1> neighbours;

	Node1(int id, String name, String classname) {
		data = new Student(id, name, classname);
		neighbours = new ArrayList<>();
	}

	public void addneighbours(Node1 neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public List<Node1> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node1> neighbours) {
		this.neighbours = neighbours;
	}

	public void dfs(Node1 node) {
		System.out.println(node.data);
		List<Node1> neighbours = node.getNeighbours();
		for (int i = 0; i < neighbours.size(); i++) {
			Node1 n = neighbours.get(i);
			if (n != null && !n.visited) {
				dfs(n);
				n.visited = true;
			}
		}
	}
}

public class MatrixApp {

}