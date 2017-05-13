public class Human implements Valuable {
	private int age;
	private final String name;
	
	public Human(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public double estimateValue(int month){
		return Double.POSITIVE_INFINITY;
		
	}
	@Override
	public double estimateValue(){
		return Double.POSITIVE_INFINITY;
		
	}
	
	public String toString(){
		return String.format("Human name : %s\nregistered age : %d",name,age);
	}
}