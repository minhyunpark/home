public class Car implements Valuable {

	public final String name;
	private double price;
	
	public Car(String name,double price){
		this.name = name;
		this.price = 0.8*price;
		
	}
	
	@Override
	public double estimateValue(int month){
		
		price*= Math.pow(0.99,month);
		return price;
	}
	@Override
	public double estimateValue(){
		
		price*= Math.pow(0.99,1);
		return price;
	}
	public String toString(){
		return String.format("Car name : %s\n inital price : %.2f",name,price);
	}
}//
