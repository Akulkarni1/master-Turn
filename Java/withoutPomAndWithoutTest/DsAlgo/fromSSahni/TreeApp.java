package Algorithm.fromSSahni;
class Tree{
    int data;
    Tree left, right;
    Tree(int newVal){
        data = newVal;
        left = null;
        right=null;
    }

}
class TreeImpl{
    Tree root;
    TreeImpl(){
        root = null;
    }
    public void addNode(int newVal){
        Tree n = new Tree(newVal);
        if (root==null){
            root=n;
            return;
        }
        else{
            while(root!=null){
                if(root.data<newVal){
                    root = root.left;
                }
                else{
                    root = root.right;
                }
            }
            if(root.data<newVal){
                root .left =n;
            }
            else{
                root.right=n;
            }
        }
    }

}
public class TreeApp {
}
