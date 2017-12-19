import java.util.*;

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

	Graph() {
		vertexList = new Vertex[max];
		adjMat = new int[max][max];
		nVerts = 0;
		for (int j = 0; j < max; j++) {
			for (int k = 0; k < max; k++) {
				adjMat[j][k] = 0;
				thestack = new StackX();
			}
		}
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

}

public class GraphApp {
}
