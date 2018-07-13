class Cust {
	private static Cust obj;

	Cust() {
	}

	public static Cust getcust() {
		if (obj == null) {
			synchronized (Cust.class) {
				if (obj == null) {
					obj = new Cust();
				}
			}
		}
		return obj;
	}
}

public class SingletonApp {

}
