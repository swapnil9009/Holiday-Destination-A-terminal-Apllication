
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
public class Country{
	ArrayList<Destination> destinations = new ArrayList<Destination>();
	String countryName;
	String language;
	String openToTouristOrNot;
	Scanner sc = new Scanner(System.in);
	//the default constructor
	public Country() {
	}
	public Country(String countryName,String language,String openToTouristOrNot) {
		this.countryName = countryName;
		this.language = language;
		this.openToTouristOrNot = openToTouristOrNot;
	}
	/*this averageCapacityOfCountry() method returns a double value which gives the
	 average capacity of all destinations for a specified country*/
	double averageCapacityOfCountry() {
		int sum = 0;
		for(Destination item : destinations) {
			sum = sum+item.getCapacity();
		}
		double average = sum/destinations.size();
		return average;
	}
	/*the listOfDestinationAboveGivenNoCapacity() method prints all the destination which has
	 capacity larger than a given number*/
	void listOfDestinationAboveGivenNoCapacity(int givenNo) {
		for(Destination item : destinations) {
			if(item.getCapacity() > givenNo) {
				System.out.println(item.toString());
			}
		}	
	}
	//the highestCapacityDestination() method returns a destination object which has the highest capacity for a given country
	Destination highestCapacityDestination() {
		 Destination destinationWithMaxcapacity = destinations.stream()
                 .max(Comparator.comparingInt(Destination::getCapacity))
                 .get();
		return destinationWithMaxcapacity;
	}
	/*the addDestination() method adds destination object to a ArrayList of destination called destinations
	 for a specified country taking name , capacity, latitude, longitude as arguments */
	void addDestination(String name,int capacity,double latitude,double longitude) {
		destinations.add(new Destination(name,capacity,latitude,longitude));
	}
	/*The toString() method returns a string representation of the Country object, 
	 containing the name, language and a flag that tells is it open to tourist or not of a country*/
	public String toString() {
		return "name: "+countryName+" | language: "+language+" | is it open to tourist: "+openToTouristOrNot;
	}
}
