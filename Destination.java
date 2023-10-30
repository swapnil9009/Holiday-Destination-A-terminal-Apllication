
import java.util.Scanner;
public class Destination {
	Scanner sc = new Scanner(System.in);
	private String destinationName;
	private int destinationCapacity;
	private double latitude;
	private double longitude;
	//this is the default constructor
	public Destination() {
	}
	//all the getter and setter method for the Destination's field
	public String getName() {
		return this.destinationName;
	}
	public int getCapacity() {
		return this.destinationCapacity;
	}
	public double getLatitude() {
		return this.latitude;
	}
	public double getLongitude() {
		return this.longitude;
	}
	public void setName(String destinationname) {
	    this.destinationName = destinationname;
	}

	public void setCapacity(int destinationCapacity) {
	   this.destinationCapacity = destinationCapacity;
	}

	public void setLatitude(double latitude) {
	   this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
	   this.longitude = longitude;
	}
	//this constructor takes four arguments as name,capacity,latitude and longitude of a destination
	public Destination(String destinationname,int destinationCapacity,double latitude,double longitude) {
		this.destinationName = destinationname;
		this.destinationCapacity = destinationCapacity;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/*The toString() method returns a string representation of the Destination object, 
	 containing the name, capacity,latitude and longitude of a destination*/
	public String toString() {
		return "Destination name: " + this.destinationName + "\n" + "Total capacity: " + this.destinationCapacity + "\n" + "Map: Latitude: " + this.latitude + " longitude:" + this.longitude + "\n";
	}	

}
