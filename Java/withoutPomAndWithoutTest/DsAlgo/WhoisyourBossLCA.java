//Who is our boss ?
//Classic example to find the LCA in a Tree.
class Employee{
	int id;
	String name;
	List<Employee> reports;
	
	Employee(int id,String name){
		this.id = id;
		this.name = name;
		this.reports = new ArrayList<Employee>();
		
	}
	public int getId(){
	return id;}
	public String getString(){
	return name;}
	public List<Employee> getReports(){
		return reports;
		
	}
	public void addReport(Employee emp){
		reports.add(emp);
	}
	
}
public static Employee closestCommonManager(Employee ceo,Employee firstEmp, Employee secEmp){
	Stack<Employee> firstPath = new Stack<Employee>();
	Stack<Employee> secoundPath = new Stack<Employee>();
	
	Employee root = ceo;
	Dfs(root,firstEmp,firstPath);
	Dfs(root,secEmp,secoundPath);
	
	if(firstPath.peek().getId()==firstEmp.getId() &&secondPath.peek().getId() == secondEmployee.getId()){
		int size1 = firstPath.size();
		int size2 = secondPath.size();
		int diff = Math.abs(size2-size1);
		if(size1> size2){
			moveUp(firstPath,diff);
		}
		else{
			moveUp(secondPath,diff);
		}
		while(firstPath.peek().getId()!=secondPath.peek().getId()){
			firstPath.pop();
			secondPath.pop();
			
		}
		if(firstPath.size()>0){
			return firstPath.pop();
		}
	}
	return null;
}
private static boolean Dfs(Employee root,Employee target, Stack<Employee> path){
	path.push(root);
	if(root.getId()==target.getId()){
		return true;
	}
	for(Employee e: root.getReports()){
		boolean res = Dfs(r,target,path);
		if(res){
			return true;
		}
	}
	path.pop();	
	return false;
}
private static void moveUp(Stack<Employee> path, int diff){
	while(diff > 0 && !path.isEmpty()){
		path.pop();
		diff--;
	}
}