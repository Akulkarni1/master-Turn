class BuggyCalImpl{
	int a;
	int b;
	BuggyCalImpl(int newVala,int newValb){
		a = newVala;
		b = newValb;
	}
	public int add() {
		int result =0;
		while(a>9) {
		if(a>9) {
			a= a/10;
			System.out.println(a);
			result+=a;
			}
		}
		System.out.println(result);
		return result;
	}
}
public class CodeChefBuggyCalApp {
	public static void main(String[] args) {
		new BuggyCalImpl(11,12).add();
	}
}
