package Algorithm;

public class StringRotationApp {
	public static void main(String[] args) {
		System.out.println(areRotation("ABCD","CDAB"));
		System.out.println(areRotation("ABCD","ACDB"));
	}
	public static boolean areRotation(String str1,String str2) {
		return (str1.length() == str2.length()) && 
	               ((str1 + str1).indexOf(str2) != -1); 
		}
}
