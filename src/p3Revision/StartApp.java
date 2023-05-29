package p3Revision;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import java.util.Comparator;
import java.util.HashSet;

/**
 * @author Conall Murphy
 * Student Number: 40236370
 */
public class StartApp {
	
	public static List<TopTrumpCard> listFromFile = new ArrayList<TopTrumpCard>();
	private static final String FINAL_HERO = "Hero";
	private static final String FINAL_VILLAN = "Villain";
	
	/**
	 * Entry point of program - no need to modify this method
	 * @param args
	 */
	
	public static void main(String[] args) {
		showMenu();	
	}
	
	/**
	 * Launches menu system which in turn calls appropriate methods based on user choices
	 * Partially implemented already
	 * requires updating to add calls to other methods written to achieve the tasks described in tasks 3-10
	 */
	
	public static void showMenu() {
		List<TopTrumpCard> mainDeck = readData();

		System.out.println();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Hero Card Processing");
		do {
			System.out.println("1. (Re)read Data From File (use to restore removed card for example)");
			System.out.println("2. Play Demo Game with Current Deck");
			System.out.println("3. Display the number of Cards in the Current Deck");
			System.out.println("4. Display full details for all cards in the current Deck");
			System.out.println("5. Display summary details of the top 5 strongest Heroes in the Deck");
			System.out.println(
					"6. Display summary details of Villains in the Deck with an agility rating of 75 or more, sorted alphatically by name");
			System.out.println("7. Display the card name and bio of the card/cards with the longest bio in the Deck");
			System.out.println(
					"8. Find Swapsies: Identify and display summary details of any duplicate cards in the Deck");
			System.out.println("9. Remove any duplicate cards from the Deck.");
			System.out.println(
					"10. Sort the deck from highest to lowest determined by average of the 4 main stats. \n\tDisplay summary details of all cards and include the average as part of the summary.");
			System.out.println("11. Quit");
			System.out.println("Enter option ...");
			option = scanner.nextInt();
			System.out.println();
			switch (option) {

			case 1:
				mainDeck = readData();
				break;
			case 2:
				System.out.println("Beginning the game!");
				System.out.println("");
				CardGame.playDemo(mainDeck);
				System.out.println("");
				break;
			case 3:
				System.out.println("");
				System.out.println("There are "+mainDeck.size()+" cards in the deck");
				System.out.println("");
				break;
			case 4:
				System.out.println("Showing all cards in the deck");
				showCardsInDeck();	
				break;
			case 5:
				System.out.println("Working on 5 Strongest Heros");
				displayStrongestCards(mainDeck, FINAL_HERO, 5);
				break;
			case 6:
				System.out.println("Villains in the Deck with an agility rating of 75 or more, sorted alphatically by name");
				displayVillansAgilityAlphabet(mainDeck, FINAL_VILLAN);
				break;
			case 7:
				System.out.println("Display the card name and bio of the card/cards with the longest bio in the Deck");
				longBioDisplay(mainDeck);
				break;
			case 8:
				System.out.println("Find Swapsies: Identify and display summary details of any duplicate cards in the Deck");
				System.out.println(displayDuplicates(mainDeck));
				break;
			case 9:
				System.out.println("Remove any duplicate cards from the Deck.");
				removeDuplicates(mainDeck);
				break;
			case 10:
				System.out.println("Sort the deck from highest to lowest determined by average of the 4 main stats. \\n\\tDisplay summary details of all cards and include the average as part of the summary.");
				Collections.sort(mainDeck, new CompareByAverage().reversed());
				highestToLowestAverage(mainDeck);
				break;
			case 11:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Try options again...");
			}
		} while (option != 11);
		scanner.close();
	}
	
	/**
	 * Reads in the data from the provided csv and returns a list of TopTrumpCard
	 * objects for further processing - requires updating for full functionality
	 */
	public static List<TopTrumpCard> readData() {

		//List<TopTrumpCard> listFromFile = new ArrayList<TopTrumpCard>();
		
		// hard coded to specific file
		File file = new File("toptrumpscards.csv"); 
		// try with resources - auto closes reader resources when finished/exception
		// occurs
		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {
			String line = reader.readLine(); // discard header
			line = reader.readLine(); // read first line
			while (line != null) {
				// TODO Code to process current line
				String [] arrayVal = line.split(",");
				// TODO instantiate TopTrumpCard object
				TopTrumpCard card = new TopTrumpCard();
				card.setName(arrayVal[0]);  
				card.setRealName(arrayVal[1]);
				card.setImageFilename(arrayVal[2]);
				card.setCategory(arrayVal[3]);
				card.setSpeed(Integer.parseInt(arrayVal[4]));
				card.setStrength(Integer.parseInt(arrayVal[5]));
				card.setAgility(Integer.parseInt(arrayVal[6]));
				card.setIntelligence(Integer.parseInt(arrayVal[7]));
				card.setBio(arrayVal[8]);
				// TODO and add to list
				listFromFile.add(card);
				// attempt to read next line and loop again
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found error");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("Exception occured");
			System.out.println(listFromFile.size() + " lines read successfully");
			System.out.println(e.getMessage());
		}
		System.out.println(listFromFile.size() + " lines read successfully");
		return listFromFile;
	}

	/**
	 * Case 4: This method loops through the Card Deck generated from CSV and displays each card using toString
	 */
	public static void showCardsInDeck() {
		for(TopTrumpCard cards : listFromFile) {
			System.out.println(cards);
		}
	}
	
	/**
	 * Case 5: This method takes 3 parameters and displays a list of the strongest cards, depending on hero or villan and the number of cards required 
	 * @param maindeck
	 * @param hero
	 * @param numOfCards
	 */
	public static void displayStrongestCards(List<TopTrumpCard> maindeck, String hero, int numOfCards ) {
		
		ArrayList<TopTrumpCard> heroDeck = new ArrayList<>();
		for(TopTrumpCard cards : maindeck) {
			if(cards.getCategory().equals(hero)) {
				heroDeck.add(cards);
			}
		}
		
		Comparator<TopTrumpCard> comparator = new CompareStrongestCard().reversed();
		
		Collections.sort(heroDeck, comparator);
		
		if(maindeck.size() < numOfCards) {
			numOfCards = maindeck.size();
		}
		for (int i = 0; i < numOfCards; i++) {
			System.out.printf("%d)%n", i + 1);
			heroDeck.get(i).displayStatsFiveStrongest();
			System.out.println();
		}
	}
	
	/**
	 * Case 6: This Method displays all Villains in the Deck with an agility rating of 75 or more, sorted alphabetically by name.
	 * @param maindeck
	 * @param villan
	 */
	public static void displayVillansAgilityAlphabet(List<TopTrumpCard> maindeck, String villan) {
		
		ArrayList<TopTrumpCard> villandeck = new ArrayList<>();
		for(TopTrumpCard cards : maindeck) {
			if((cards.getCategory().equals(villan) && (cards.getAgility() >= 75))) {
				villandeck.add(cards);
			}
		}
		
		Collections.sort(villandeck, new CompareByAlaphabet());
		
		Collections.sort(villandeck, new CompareByAgility());
		
		for (int i = 0; i < villandeck.size(); i++) {
			System.out.printf("%d)%n", i + 1);
			villandeck.get(i).displayStatsFiveStrongest();
			System.out.println();
		}
		
	}
	
	/**
	 * Case 7: This Method identifies and displays any cards that have over 200 Characters in their bio
	 * @param maindeck
	 */
	public static void longBioDisplay(List<TopTrumpCard> maindeck) {
		ArrayList<TopTrumpCard> bioLength = new ArrayList<>();
		for(TopTrumpCard cards : maindeck) {
			if(cards.getBio().length() > 200) {
				bioLength.add(cards);
			}
		}
		for (int i = 0; i < bioLength.size(); i++) {
			System.out.printf("%d)%n", i + 1);
			bioLength.get(i).displayNameAndBio();
			System.out.println();
		}
	}
	
	/**
	 * Case 8: This Method Identifies any duplicate cards in the Deck
	 * @param mainDeck
	 * @return
	 */
	public static ArrayList<TopTrumpCard>displayDuplicates(List<TopTrumpCard> mainDeck) {
		HashSet<TopTrumpCard> duplicateSet = new HashSet<>();
		
		ArrayList<TopTrumpCard> duplicateList = new ArrayList<>();
		
		for(TopTrumpCard cards : mainDeck) {
			if(duplicateSet.add(cards)==false) {
				duplicateList.add(cards);
			}
		}
		return duplicateList;
	}
	
	/**
	 * Case 9: This Method removes duplicates in deck 
	 * @param 
	 * @return
	 */
	public static void removeDuplicates(List<TopTrumpCard> heroList) {
		Set<TopTrumpCard> setTrump = new HashSet<TopTrumpCard>();
		
		for(TopTrumpCard cards : heroList) {
			setTrump.add(cards);
		}	
		
		heroList.clear();
		heroList.addAll(setTrump);
		
		System.out.println("Duplicates Removed");
		
	}
	
	/**
	 * Case 10: This Method Sort the deck from highest to lowest determined by average of the 4 main stats.
	 * @param mainDeck
	 */
	public static void highestToLowestAverage(List<TopTrumpCard> mainDeck) {
		
		for(TopTrumpCard cards : mainDeck) {
			cards.displayAverage();
		}
		
	}

}
