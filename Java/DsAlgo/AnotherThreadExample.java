import java.util.concurrent.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Customer{
	String email;
	String loginId;
	String password;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	Customer(){
		email = "";
		loginId ="";
		password = "";
	}
	Customer(String email,String loginId,String password){
		this.email = email;
		this.loginId = loginId;
		this.password = password;
	}
	public String toString() {
		return email+""+loginId;
	}
	@Override
	public int hashCode() {
		int prime= 31;
		int result = this.hashCode()+prime;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj ==null) {
			return false;
		}
		if(getClass()!= obj.getClass()) {
			return false;
		}
		Customer i = (Customer)obj;
		if(this.email!=i.email) {
			return false;
		}
		if(this.loginId!=i.loginId) {
			return false;
		}
		if(this.password!= i.password) {
			return false;
		}
		return true;
	}
}
class ConcurrentImpl {
	ConcurrentHashMap <Integer,Customer> chm;
	ConcurrentLinkedDeque cld;
	ConcurrentLinkedQueue clq;
	ConcurrentNavigableMap <Integer,Customer> cnm;
	ConcurrentSkipListMap cslm;
	ConcurrentSkipListSet csls;
	
	ConcurrentImpl(){
		
	}
	
	public void populateCHM() {
		chm = new ConcurrentHashMap<Integer,Customer>();
		chm.put(1,new Customer("a1k@gmail.com","a1k@gmail.com","a1k@gmail.com"));
		chm.put(2,new Customer("a2k@gmail.com","a2k@gmail.com","a2k@gmail.com"));
		chm.put(3,new Customer("a3k@gmail.com","a3k@gmail.com","a3k@gmail.com"));
		chm.put(4,new Customer("a4k@gmail.com","a4k@gmail.com","a4k@gmail.com"));
		
		System.out.println("Printing Map");
		System.out.println("Way number 1");
		//int i;
		for(int i:chm.keySet()){
			System.out.println(i+" "+chm.get(i));
		} 
		System.out.println("Way number 2");
		Set<Integer> keySet = chm.keySet();
		Iterator<Integer> itr = keySet.iterator();
		while(itr.hasNext()) {
			int i= itr.next();
			System.out.println(i+" "+chm.get(i));
			
		}
		
		System.out.println("Way number 3");
		Set<Map.Entry<Integer, Customer>> s = chm.entrySet();
		for(Entry e:s) {
			System.out.println(e.getKey()+""+e.getValue());
		}
			
	}
	
	public void populateConcurrentLinkedQueue(){
		clq =new ConcurrentLinkedQueue<Customer>();
		
	}
	public void populateConcurrentNavigableMap() {
		cnm = new ConcurrentSkipListMap <Integer,Customer>();
		
		cnm.put(1,new Customer("a1k@gmail.com","a1k@gmail.com","a1k@gmail.com"));
		cnm.put(2,new Customer("a2k@gmail.com","a2k@gmail.com","a2k@gmail.com"));
		cnm.put(3,new Customer("a3k@gmail.com","a3k@gmail.com","a3k@gmail.com"));
		cnm.put(4,new Customer("a4k@gmail.com","a4k@gmail.com","a4k@gmail.com"));
		
		
		System.out.println("Way number 3");
		Set<Map.Entry<Integer,Customer>> s= cnm.entrySet();
		for(Entry e:s) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
	} 
}

class Synch implements Runnable,Serializable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
public class AnotherThreadExample {
	public static void main(String[] args) {
		new ConcurrentImpl().populateCHM();
		new ConcurrentImpl().populateConcurrentNavigableMap();
	}

}
