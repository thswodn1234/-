package 자바자료구조;

public class Fruit implements Comparable<Fruit> {
	    private String name;
	    private int price;
	   
	    public Fruit(String name, int price) {
	        this.name = name;
	        this.price = price;
	    }

	 
	    public String toString() {
	        return "{name: " + name + ", price: " + price + "}";
	    }

	
		public int compareTo(Fruit x) {
			if (this.price < x.price) return -1;
			else if (this.price > x.price) return 1;
			else 
				if (this.name.compareTo(x.name) < 0 ) return -1;
				else return 1;
				
			
		}
	
}
