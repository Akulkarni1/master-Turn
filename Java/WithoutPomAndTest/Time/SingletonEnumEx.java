package Time;

enum SingletonEnum {
	Instance;
	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int val) {
		value = val;
	}
}

public class SingletonEnumEx {
	public static void main(String[] args) {
		SingletonEnum st = SingletonEnum.Instance;
		System.out.println(st.getValue());
		st.setValue(5);
		System.out.println(st.getValue());
	}
}

/*
 * problem with original classical Singleton is they can't handle the
 * serialization and deserialization .
 * 
 * They also can't handle "Reflection" like if any user can change the private
 * access modifier of the constuctor to anything they want to runtime using
 * reflection.It has happens, our only mechanism for non-instantiability breaks.
 * 
 * 
 * Singleton singleton = Singleton.INSTANCE;
 * 
 * Constructor constructor = singleton.getClass().getDeclaredConstructor(new
 * Class[0]);
 * 
 * constructor.setAccessible(true);
 * 
 * Singleton singleton2 = (Singleton) constructor.newInstance();
 * 
 * if (singleton == singleton2) {
 * 
 * System.out.println("Two objects are same");
 * 
 * } else {
 * 
 * System.out.println("Two objects are not same");
 * 
 * }
 * 
 * singleton.setValue(1);
 * 
 * singleton2.setValue(2);
 * 
 * System.out.println(singleton.getValue());
 * 
 * System.out.println(singleton2.getValue());
 * 
 * 
 */
