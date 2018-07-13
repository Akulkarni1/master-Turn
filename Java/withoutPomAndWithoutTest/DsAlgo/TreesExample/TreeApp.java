import java.util.LinkedList;

class TreeNode{
	int data;
	String dat;
	TreeNode left, right;
	TreeNode(){
		data =-1;
		dat = "";
		left = null;
		right =null;
	}
	TreeNode(int newVal,String string){
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
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public String toString() {
		return " "+dat+""+data;
	}
}
class TreeImpl{
	TreeNode root;
	TreeImpl(){
		root =null;
	}
	public void addNode() {
		
	}
	public TreeNode rightMostCousin(TreeNode root,int target) {
		LinkedList<TreeNode>q = new LinkedList<TreeNode>();
		int count =0;
		q.add(root);
		count++;
		boolean targetLevel =false;
		while(!q.isEmpty()) {
			TreeNode node = q.remove();
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
