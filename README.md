# Top-Trumps-Revision-Exercise
A revision exercise provided by QUB lecturer Matthew Collins for the final assessment in the CSC7081: Programming module.
 
The exercise is an interactive game using a deck of "Top Trump" cards, which are represented by TopTrumpCard objects. Each card represents a Hero or a Villain character, and contains various attributes such as Name, RealName, ImageFilename, Category, Speed, Strength, Agility, Intelligence, and Bio.

# Program Overview
At the start of the program, the user is presented with a menu, which allows them to interact with the deck of cards in a variety of ways. The options include:

Reread Data From File: Reloads the card data from a CSV file.
Play Demo Game with Current Deck: Play with the current deck of cards.
Display the number of Cards in the Current Deck: Shows how many cards are in the deck.
Display full details for all cards in the current Deck: Presents all the details of every card in the deck.
Display summary details of the top 5 strongest Heroes in the Deck: Shows the five strongest hero cards in the deck.
Display summary details of Villains in the Deck with an agility rating of 75 or more, sorted alphabetically by name: Shows the details of villain cards with an agility rating of 75 or more, sorted by name.
Display the card name and bio of the card/cards with the longest bio in the Deck: Presents the name and bio of the card(s) with the longest bio.
Identify and display summary details of any duplicate cards in the Deck: Identifies and shows details of duplicate cards in the deck.
Remove any duplicate cards from the Deck: Removes all duplicate cards from the deck.
Sort the deck from highest to lowest determined by average of the 4 main stats: Sorts the deck based on the average of the four main stats (Speed, Strength, Agility, Intelligence) from highest to lowest.

# Technical Approach
The application uses a list data structure (List<TopTrumpCard>) to hold the card objects. It uses various Java features such as exception handling, file I/O operations, and Java collections for processing the card data. The application reads data from a CSV file and stores it in memory. Different methods are used to implement the various functionalities according to the menu options. For example, it uses Comparator to sort cards, and HashSet to remove duplicates.

This program showcases an array of programming concepts including object-oriented programming, data structures, file I/O, and error handling. 
