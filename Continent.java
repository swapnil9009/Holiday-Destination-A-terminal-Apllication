
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Continent extends Country{
	Scanner sc = new Scanner(System.in);
	final ArrayList<ArrayList<Country>> CONTINENTS = continents();
	Country country = new Country();
	/*this highestAvgCapacitOfaCountry() prints the country which has the highest
	 average destinations capacity in the entire system */
	void highestAvgCapacitOfaCountry() {
			Country countryWithHighestAveragecapacity = new Country();
			double highestAverageCapacity = Double.MIN_VALUE;
			double avg = 0;
			for(ArrayList<Country> countryList : CONTINENTS) {
				for(Country country: countryList) {
					avg = country.averageCapacityOfCountry();
					if(avg>highestAverageCapacity) {
						highestAverageCapacity = avg;
						countryWithHighestAveragecapacity = country;
					}
				}
			}
			System.out.println(countryWithHighestAveragecapacity.countryName+" has the highest average capacity");
			System.out.println(countryWithHighestAveragecapacity.toString());
			System.out.println("");
			for(Destination item : countryWithHighestAveragecapacity.destinations) {
				System.out.println(item.toString());
			}
	}
	/*the listOfCountriesCapacityAboveGivenNo() method prints all the country which has
	 capacity larger than a given number in the entire system irrespective of any continent*/
	void listOfCountriesCapacityAboveGivenNo(int givenNo) {
		int sum = 0;
		for(ArrayList<Country> countryList : CONTINENTS) {
			for(Country country : countryList) {
				for(Destination destination : country.destinations) {
					sum = sum + destination.getCapacity();
				}
				if(sum > givenNo) {
					System.out.println(country.toString());
				}
			}
		}
	}
	/*the listOfDestinationsCapacityAboveGivenNo() method prints all the destination which has
	 capacity larger than a given number in the entire system irrespective of any continent any country*/
	void listOfDestinationsCapacityAboveGivenNo(int givenNo) {
		for(ArrayList<Country> countryList : CONTINENTS) {
			for(Country country : countryList) {
				country.listOfDestinationAboveGivenNoCapacity(givenNo);
			}
		}
	}
	/*this destinationWithTheHighestCapacity() method prints the destination which has
	the maximum capacity recorded in the entire system*/
	void destinationWithTheHighestCapacity() {
			Destination destinationWithHighestCapacity = new Destination(null,0,0,0);
			for(ArrayList<Country> countryList : CONTINENTS) {
				for(Country country : countryList) {
					Destination destination = country.highestCapacityDestination();
					if(destinationWithHighestCapacity.getCapacity()<destination.getCapacity()) {
						destinationWithHighestCapacity = destination;
					}
				}
			}
			System.out.println(destinationWithHighestCapacity.getName()+" has the highest capacity in the system\n");
			System.out.println(destinationWithHighestCapacity.toString());
	}
	/*this addCountriesToContinents() is simply use for adding countries to the continent
	 taking arguments name of the country , language of the country , flag for showing is it open to tourist
	 or not and also userInputForContinent which gives the index of a particular continent that you want to add country in*/
	void addCountriesToContinents(int userChoiceForContinent,String name,String language,String openOrNot) {		
		if(userChoiceForContinent>=0 && userChoiceForContinent<=CONTINENTS.size()) {
			CONTINENTS.get(userChoiceForContinent-1).add(new Country(name,language,openOrNot));
		}
		else {
			System.out.println("Invalid Input");
		}	
	}
	/*the displayCountriesOfSelectedContinentandAddDestination() method checks if a desired continent is empty or not,
	 if not then first display all the  existing countries in a specified continent using 7 switch cases for seven continents and add destination according to the user selected
	 continent and country using their index, taking arguments inputChoice and userInputForContinent and all the properties of destination */
	void displayCountriesOfSelectedContinentandAddDestination(int inputChoice,int userInputForContinent,String name,int capacity,double latitude,double longitude) {
		int userInputForCountry = 0;
		switch(inputChoice) {
		case 1 :
			if(CONTINENTS.get(0).isEmpty()) {
				System.out.println("you have no countries in the continent");
			}
			else {
				System.out.println("Select country in which you want to add destination");
				printCountries(CONTINENTS.get(0));
				//handling exception for invalid value
				boolean valid = false;
				while(!valid) {
					try {
						userInputForCountry = sc.nextInt();
						valid = true;
					}
					catch(InputMismatchException e){
						System.out.println("Invalid Input");
						sc.nextLine();
					}
				}
				addDestinationToDesiredCountry(userInputForContinent,userInputForCountry,name,capacity,latitude,longitude);
				System.out.println("1. Add more destinations");
			}
			break;
		case 2 :
			if(CONTINENTS.get(1).isEmpty()) {
				System.out.println("you have no countries in the continent");
			}
			else {
				System.out.println("Select country in which you want to add destination");
				printCountries(CONTINENTS.get(1));
				//handling exception for invalid value
				boolean valid1 = false;
				while(!valid1) {
					try {
						userInputForCountry = sc.nextInt();
						valid1 = true;
					}
					catch(InputMismatchException e){
						System.out.println("Invalid Input");
						sc.nextLine();
					}
				}
				addDestinationToDesiredCountry(userInputForContinent,userInputForCountry,name,capacity,latitude,longitude);
				System.out.println("1. Add more destinations");
			}
			break;
		case 3 :
			if(CONTINENTS.get(2).isEmpty()) {
				System.out.println("you have no countries in the continent");
			}
			else {
				System.out.println("Select country in which you want to add destination");
				printCountries(CONTINENTS.get(2));
				//handling exception for invalid value
				boolean valid2 = false;
				while(!valid2) {
					try {
						userInputForCountry = sc.nextInt();
						valid2 = true;
					}
					catch(InputMismatchException e){
						System.out.println("Invalid Input");
						sc.nextLine();
					}
				}
				addDestinationToDesiredCountry(userInputForContinent,userInputForCountry,name,capacity,latitude,longitude);
				System.out.println("1. Add more destinations");
			}
			break;
		case 4 :
			if(CONTINENTS.get(3).isEmpty()) {
				System.out.println("you have no countries in the continent");
			}
			else {
				System.out.println("Select country in which you want to add destination");
				printCountries(CONTINENTS.get(3));
				//handling exception for invalid value
				boolean valid3 = false;
				while(!valid3) {
					try {
						userInputForCountry = sc.nextInt();
						valid3 = true;
					}
					catch(InputMismatchException e){
						System.out.println("Invalid Input");
						sc.nextLine();
					}
				}
				addDestinationToDesiredCountry(userInputForContinent,userInputForCountry,name,capacity,latitude,longitude);
				System.out.println("1. Add more destinations");
			}
			break;
		case 5 :
			if(CONTINENTS.get(4).isEmpty()) {
				System.out.println("you have no countries in the continent");
			}
			else {
				System.out.println("Select country in which you want to add destination");
				printCountries(CONTINENTS.get(4));
				//handling exception for invalid value
				boolean valid4 = false;
				while(!valid4) {
					try {
						userInputForCountry = sc.nextInt();
						valid4 = true;
					}
					catch(InputMismatchException e){
						System.out.println("Invalid Input");
						sc.nextLine();
					}
				}
				addDestinationToDesiredCountry(userInputForContinent,userInputForCountry,name,capacity,latitude,longitude);
				System.out.println("1. Add more destinations");
			}
			break;
		case 6 :
			if(CONTINENTS.get(5).isEmpty()) {
				System.out.println("you have no countries in the continent");
			}
			else {
				System.out.println("Select country in which you want to add destination");
				printCountries(CONTINENTS.get(5));
				//handling exception for invalid value
				boolean valid5 = false;
				while(!valid5) {
					try {
						userInputForCountry = sc.nextInt();
						valid5 = true;
					}
					catch(InputMismatchException e){
						System.out.println("Invalid Input");
						sc.nextLine();
					}
				}
				addDestinationToDesiredCountry(userInputForContinent,userInputForCountry,name,capacity,latitude,longitude);
				System.out.println("1. Add more destinations");
			}
			break;
		case 7 :
			if(CONTINENTS.get(6).isEmpty()) {
				System.out.println("you have no countries in the continent");
			}
			else {
				System.out.println("Select country in which you want to add destination");
				printCountries(CONTINENTS.get(6));
				//handling exception for invalid value
				boolean valid6 = false;
				while(!valid6) {
					try {
						userInputForCountry = sc.nextInt();
						valid6 = true;
					}
					catch(InputMismatchException e){
						System.out.println("Invalid Input");
						sc.nextLine();
					}
				}
				addDestinationToDesiredCountry(userInputForContinent,userInputForCountry,name,capacity,latitude,longitude);
				System.out.println("1. Add more destinations");
			}
			break;
		}
	}
	/*this printCountries() method will print all the countries
	 inside a continent*/
	void printCountries(ArrayList<Country> country) {
		int counter = 1;
		for(Country item : country) {
			System.out.println(counter+". "+item.countryName);
			counter++;
		}
		System.out.println("0. add new country if your desired country is not in the list");
	}
	/*this addDestinationToDesiredCountry() adds destinations to a desired country by taking 
	 all destination properties and including index of a specified continent and also index of a 
	 specified country from user as an argument userInputForContinent, userInputForCountry respectively*/
	void addDestinationToDesiredCountry(int userInputForContinent,int userInputForCountry,String name,int capacity,double latitude,double longitude){
		if(userInputForCountry == 0) {
			System.out.println("");
		}
		/*checking if size of a country is null or not and also making sure that
		 user input to select a country falls under country's size*/
		else if(CONTINENTS.get(userInputForContinent-1).size()!=0 && userInputForCountry > 0 && userInputForCountry <= CONTINENTS.get(userInputForContinent-1).size()) {
			CONTINENTS.get(userInputForContinent-1).get(userInputForCountry-1).addDestination(name,capacity,latitude,longitude);
		}
		else {
			System.out.println("Invalid Input");
		}	
	}
	/*this continents() method returns an constant ArrayList of Country type ArrayList which
	 holds the ArrayList of all seven continent*/
	ArrayList<ArrayList<Country>> continents(){
		final ArrayList<ArrayList<Country>> ALL_CONTINENT = new ArrayList<>();
		ArrayList<Country> asia = new ArrayList<>();
		ArrayList<Country> africa = new ArrayList<>();
		ArrayList<Country> europe = new ArrayList<>();
		ArrayList<Country> australia = new ArrayList<>();
		ArrayList<Country> southAmerica = new ArrayList<>();
		ArrayList<Country> northAmerica = new ArrayList<>();
		ArrayList<Country> antarctica = new ArrayList<>();
		ALL_CONTINENT.add(asia);
		ALL_CONTINENT.add(africa);
		ALL_CONTINENT.add(europe);
		ALL_CONTINENT.add(australia);
		ALL_CONTINENT.add(southAmerica);
		ALL_CONTINENT.add(northAmerica);
		ALL_CONTINENT.add(antarctica);
		return 	ALL_CONTINENT;
	}

}
