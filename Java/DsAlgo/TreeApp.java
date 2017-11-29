import java.util.LinkedList;

class Node{
	int data;
	String dat;
	Node left, right;
	Node(){
		data =-1;
		dat = "";
		left = null;
		right =null;
	}
	Node(int newVal,String string){
		data = newVal;
		dat = string;
		left = null;
		right = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public String getDat() {
		return dat;
	}
	public void setDat(String dat) {
		this.dat = dat;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	public String toString() {
		return " "+dat+""+data;
	}
	public Node rightMostCousin(Node root,int target) {
		LinkedList<Node>q = new LinkedList<Node>();
		int count =0;
		q.add(root);
		count++;
		boolean targetLevel =false;
		while(!q.isEmpty()) {
			Node node = q.remove();
			count--;
			if(node.data==target) {
				targetLevel= true;
			}
			if(node.left!=null) {
				q.add(node.left);
			}
			if(node.right!=null) {
				q.add(node.right);
			}
			if(count==0) {
				count = q.size();
				if(targetLevel) {
					if(node.data!=target)
						return node;
					else return null;
				}
			}
		}
		return null;
	}
}
public class TreeApp {
	
}
