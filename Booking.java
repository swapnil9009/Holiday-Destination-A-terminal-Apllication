
import java.util.InputMismatchException;
import java.util.Scanner;
public class Booking{
	public static void main(String[] args) {
		/*This program has a switch statement with four cases, each of which has a loop that allows the user to 
		 perform actions until they choose to go back to the main menu.*/
		Scanner sc = new Scanner(System.in);
		int userInputForMenu = Integer.MIN_VALUE; //declaring initializing the user input variable for menu to minimum value of integer
		int capacity = 0;
		double latitude = 0;
		double longitude = 0;
		Continent continent = new Continent();
		// handling the input mismatch exception for integer using a boolean value
			while(userInputForMenu!=4) {
				mainMenu();
				boolean valid = false;
				while(!valid) {
					try {
						userInputForMenu = sc.nextInt();
						valid = true;
					}
					catch(InputMismatchException e){
						System.out.println("Invalid Input");
						sc.nextLine();
					}
				}
				switch(userInputForMenu) {
				/* this first case, the user can add information about a country, including its name, spoken language, and 
				 whether it is open to tourists. The user is also prompted to choose a continent to which the country should be added*/
				case 1 : 
					while(userInputForMenu!=2) {
						//getting country data from user in runtime
						System.out.println("Enter the name of the country: ");
						String countryName = sc.next();
						System.out.println("Enter the language that spoken in the country: ");
						String language = sc.next();
						System.out.println("Is it open to tourist or not? (yes/no): ");
						String openToTouristInput = sc.next();
						//displaying all seven continent for user to add countries to their choice of continent using userInputForMenu variable
						System.out.println("In which continent you want to add these details of the country?");
						displayContinent();
						//handling input mismatch exception while selecting the continent
						boolean valid1 = false;
						while(!valid1) {
							try {
								userInputForMenu = sc.nextInt();
								valid1 = true;
							}
							catch(InputMismatchException e){
								System.out.println("Invalid Input");
								sc.nextLine();
							}
						}
						//adding country to the continent
						continent.addCountriesToContinents(userInputForMenu,countryName,language,openToTouristInput);
						System.out.println("Select any of this: ");
						System.out.println("1. add more country");
						System.out.println("2. Go back to main menu");
						userInputForMenu = sc.nextInt();
					}
					break;
				/*In this second case, the user can add information about a destination, including its name, capacity,
				  latitude, and longitude. The user is also prompted to choose a country and a continent in which the destination is located.*/
				case 2 :
					while(userInputForMenu!=0) {
						//getting details of the destination from user to add destination
						System.out.println("Enter the name of the destination: ");
						String destinationName = sc.next();
						System.out.println("Enter the capacity of the destination: ");
						//handling input mismatch exception
						boolean validforCapacity = false;
						while(!validforCapacity) {
							try {
								capacity = sc.nextInt();
								validforCapacity = true;
							}
							catch(InputMismatchException e){
								System.out.println("Invalid Input");
								sc.nextLine();
							}
						}
						System.out.println("Enter the destination latitude: ");
						boolean validforLatitude = false;
						while(!validforLatitude) {
							try {
								latitude = sc.nextDouble();
								validforLatitude = true;
							}
							catch(InputMismatchException e){
								System.out.println("Invalid Input");
								sc.nextLine();
							}
						}
						System.out.println("Enter the longitude: ");
						boolean validforLongitude = false;
						while(!validforLongitude) {
							try {
								longitude = sc.nextDouble();
								validforLongitude = true;
							}
							catch(InputMismatchException e){
								System.out.println("Invalid Input");
								sc.nextLine();
							}
						}
						System.out.println("Select the continent you want to add the destination ");
						displayContinent();
						boolean valid2 = false;
						while(!valid2) {
							try {
								userInputForMenu = sc.nextInt();
								valid2 = true;
							}
							catch(InputMismatchException e){
								System.out.println("Invalid Input");
								sc.nextLine();
							}
						}
						//displaying all the countries in a continent and add destination to a country
						continent.displayCountriesOfSelectedContinentandAddDestination(userInputForMenu,userInputForMenu,destinationName,capacity,latitude,longitude);
						System.out.println("0. Go back to main menu to add new country");
						userInputForMenu = sc.nextInt();
					}
					break;
				/*in this third case user is prompted to choose a number as an option to see a statistics of the entire system*/
				case 3 : 
					while(userInputForMenu!=0) {
						System.out.println("1. Country with highest average destination capacity");
						System.out.println("2. Highest capacity destination in the system");
						System.out.println("3. Destination with capacity above given number");
						System.out.println("0. back to main menu");
						if(continent.CONTINENTS.isEmpty()) {
							System.out.println("Sorry! you cant use the statistics, add country and destination first");
						}
						//handling exception for invalid value
						boolean valid3 = false;
						while(!valid3) {
							try {
								userInputForMenu = sc.nextInt();
								valid3 = true;
							}
							catch(InputMismatchException e){
								System.out.println("Invalid Input");
								sc.nextLine();
							}
						}
						if(userInputForMenu == 1) {
							continent.highestAvgCapacitOfaCountry(); //this method gives the country with the highest average destination capacity
						}
						else if(userInputForMenu == 2) {
							continent.destinationWithTheHighestCapacity();//this method gives the highest capacity destination in the system
						}
						else if(userInputForMenu == 3) {
							System.out.println("Enter your value");
							int givenNo = sc.nextInt();//getting input from user to set the minimum limit of the capacity of a destination
							continent.listOfDestinationsCapacityAboveGivenNo(givenNo); //this method gives the destination with capacity above a number which we get from user
						}
					}
					break;
				case 4 :
					sc.close();
					System.exit(0);//closes the program
				default :
					System.out.println("Invalid Input");
				}
			}
	}
	//the mainMenu() displays main menu for user
	static void mainMenu() {
		System.out.println("Choose any option below ");
		System.out.println("1. Add a new country");
		System.out.println("2. Add new details of destination");
		System.out.println("3. View statistics");
		System.out.println("4. Exit");
	}
	//this displayContinent() method displays all the continent for user
	static void displayContinent() {
		System.out.println("1. Asia");
		System.out.println("2. Africa");
		System.out.println("3. Europe");
		System.out.println("4. Australia");
		System.out.println("5. South America");
		System.out.println("6. North America");
		System.out.println("7. Antarctica");
	}

}
