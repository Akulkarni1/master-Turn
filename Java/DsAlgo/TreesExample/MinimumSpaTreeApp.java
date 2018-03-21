class Edge {
	int srcVert;
	int destVert;
	int distance;

	Edge(int srvdct, int dv, int d) {
		srcVert = srvdct;
		destVert = dv;
		distance = d;
	}
}

class PriorityQ {
	int SIZE = 20;
	Edge[] queueArr;
	int size;

	PriorityQ() {
		queueArr = new Edge[SIZE];
		size = 0;
	}

	public void insert(Edge item) {
		int j;
		for (j = 0; j < size; j++) {
			if (item.distance >= queueArr[j].distance)
				break;
		}
		for (int k = size - 1; k >= j; k--) {
			queueArr[k + 1] = queueArr[k];
			queueArr[j] = item;
			size++;
		}
	}

	public Edge removeMin() {
		return queueArr[--size];
	}

	public void removeN(int n) {
		for (int j = n; j < size - 1; j++) {
			queueArr[j] = queueArr[j + 1];
			size--;
		}
	}

	public Edge peekMin() {
		return queueArr[size - 1];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Edge peekN(int n) {
		return queueArr[n];
	}

	public int find(int find) {
		for (int j = 0; j < size; j++) {
			if (queueArr[j].destVert == find) {
				return j;
			}
		}
		return -1;
	}
}

class Vertex2 {
	public char label;
	public boolean isInTime;

	public Vertex2(char lab) {
		label = lab;
		isInTime = false;
	}
}

class Graph2 {
	int maxVerts = 20;
	int infinty = 10000;
	Vertex2 vertexList[];
	int adjMat[][];
	int nverts;
	int currentVert;
	PriorityQ thePq;
	int nTree;

	Graph2() {
		vertexList = new Vertex2[maxVerts];
		adjMat = new int[maxVerts][maxVerts];
		nverts = 0;
		for (int j = 0; j < maxVerts; j++)
			for (int k = 0; k < maxVerts; k++)
				adjMat[j][k] = infinty;

		thePq = new PriorityQ();
	}

	public void addVertex(char lab) {
		vertexList[nverts++] = new Vertex2(lab);
	}

	public void addEdge(int start, int end, int weight) {
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}

	public void displayVertex(int x) {
		System.out.println(vertexList[x].label);
	}

	public void mstw() {
		currentVert = 0;
		while (nTree < nverts - 1) {
			vertexList[currentVert].isInTime = true;
			nTree++;
			for (int j = 0; j < nverts; j++) {
				if (j == currentVert)
					continue;
				if (vertexList[j].isInTime)
					continue;
				int distance = adjMat[currentVert][j];
				if (distance == infinty)
					continue;
				putInPq(j, distance);

			}
			if (thePq.size() == 0) {
				System.out.println("Gtrraph not connected");
				return;
			}
			Edge theEdge = thePq.removeMin();
			int sourceVert = theEdge.srcVert;
			currentVert = theEdge.destVert;
			System.out.println(vertexList[sourceVert].label);
			System.out.println(vertexList[currentVert].label);

			for (int j = 0; j < nverts; j++) {
				// System.out.println( )
				vertexList[j].isInTime = false;
			}
		}
	}

	public void putInPq(int newVert, int newDist) {
		int queueIndex = thePq.find(newVert);
		if (queueIndex != -1) {
			Edge tempEdge = thePq.peekN(queueIndex);
			int oldDist = tempEdge.distance;
			if (oldDist > newDist) {
				thePq.removeN(queueIndex);
				Edge theEdge = new Edge(currentVert, newVert, newDist);
				thePq.insert(theEdge);
			}
		} else {
			Edge theEdge = new Edge(currentVert, newVert, newDist);
			thePq.insert(theEdge);

		}
	}
}

public class MinimumSpaTreeApp {

}
