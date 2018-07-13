

public class ExceptionHandlerApp {

	public static void main(String[]args) throws Exception {
		
		try {
			System.out.println("I am in try");
			throw new Exception();
		}
		catch(Exception e) {
			System.out.println("I am in catch");
			throw new NullPointerException();
		}
		finally{
			System.out.println("I am in finally");
			throw new ArithmeticException();
			
		}
	}
}
