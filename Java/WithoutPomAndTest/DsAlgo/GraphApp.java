import java.util.*;

class QueueX {
	int size = 30;
	int[] qArr;
	int front;
	int rear;

	QueueX() {
		qArr = new int[size];
		front = 0;
		rear = -1;
	}

	public void insert(int newVal) {
		if (rear == size - 1)
			rear = -1;
		qArr[++rear] = newVal;
	}

	public int remove() {
		int temp = qArr[front++];
		if (front == size)
			front = 0;
		return temp;
	}

	public boolean isEmpty() {
		return (rear + 1 == front || front + size - 1 == rear);
	}

}

class StackX {
	int size = 30;
	int[] st;
	int top;

	StackX() {
		st = new int[size];
		top = -1;

	}

	public void push(int i) {
		st[++top] = i;
	}

	public int pop() {
		return st[top--];
	}

	public int peek() {
		return st[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}
}

class Vertex {
	char label;
	boolean wasvisited;

	Vertex(char lab) {
		label = lab;
		wasvisited = false;
	}
}

class Graph {
	int max = 20;
	Vertex vertexList[];
	int adjMat[][];
	int nVerts;
	StackX thestack;
	QueueX thequeue;

	Graph() {
		vertexList = new Vertex[max];
		adjMat = new int[max][max];
		nVerts = 0;
		for (int j = 0; j < max; j++)
			for (int k = 0; k < max; k++)
				adjMat[j][k] = 0;
		thestack = new StackX();
		thequeue = new QueueX();
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}

	public void dfs() {
		vertexList[0].wasvisited = true;
		displayVertex(0);
		thestack.push(0);
		while (!thestack.isEmpty()) {
			int v = getAdjUnvisitedVertex(thestack.peek());
			if (v == -1) {
				thestack.pop();
			} else {
				vertexList[v].wasvisited = true;
				displayVertex(v);
				thestack.push(v);
			}
		}
		for (int j = 0; j < nVerts; j++) // reset flags
			vertexList[j].wasvisited = false;
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++)
			if (adjMat[v][j] == 1 && vertexList[j].wasvisited == false)
				return j;
		return -1;
	}

	public void bfs() {
		vertexList[0].wasvisited = true;
		displayVertex(0);
		thequeue.insert(0);
		int v2;
		while (!thequeue.isEmpty()) {
			int v1 = thequeue.remove();
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].wasvisited = true;
				displayVertex(v2);
				thequeue.insert(v2);
			}
		}
		for (int j = 0; j < nVerts; j++) {
			vertexList[j].wasvisited = false;

		}
	}

	public void mst() {
		vertexList[0].wasvisited = true;
		thestack.push(0);
		while (!thestack.isEmpty()) {
			int currentVertex = thestack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if (v == -1) {
				thestack.pop();

			} else {
				vertexList[v].wasvisited = true;
				thestack.push(v);
				displayVertex(currentVertex);
				displayVertex(v);
				System.out.println(" ");
			}
		}
		for (int j = 0; j < nVerts; j++) {
			vertexList[j].wasvisited = false;
		}
	}

}

public class GraphApp {
}
