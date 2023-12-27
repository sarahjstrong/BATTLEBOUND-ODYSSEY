package com.techelevator;

import java.util.List;
import java.util.Scanner;

public class Battle {
    static Scanner scanner = new Scanner(System.in);

        private Character player1;
        private Character player2;

    // Constructor
    public Battle() {
    }


    // Getters and setters

    public void setPlayers(List<Character> playerList) {
        player1 = playerList.get(0);
        player2 = playerList.get(1);
    }

    public Character getPlayer1() {
        return player1;
    }

    public Character getPlayer2() {
        return player2;
    }


    // Player turn
    public static void playerTurn(Character currentPlayer, Character opponent) {
        currentPlayer.rollAgainst(opponent);
    }


    // Create character
    public Character createCharacter(int type, String name) {
        Character newPlayer = null;
        if (type == 1) {
            newPlayer = new Dragonborn(name);
        } else if (type == 2) {
            newPlayer = new Dwarf(name);
        } else if (type == 3) {
            newPlayer = new Elf(name);
        } else if (type == 4) {
            newPlayer = new Gnome(name);
        } else if (type == 5) {
            newPlayer = new Halfelf(name);
        } else if (type == 6) {
            newPlayer = new Halfling(name);
        } else if (type == 7) {
            newPlayer = new Halforc(name);
        } else if (type == 8) {
            newPlayer = new Tiefling(name);
        } else if (type == 9) {
            newPlayer = new Human(name);
        } else {
            System.out.println("Input not valid. Please check your spelling and be sure to only use letters. NO SYMBOLS!");
        }
        return newPlayer;
    }

    // Display welcome message
    public void displayWelcomeMessage() {
        System.out.println("\n\n");
        System.out.println("******* WELCOME TO BATTLEBOUND ODYSSEY *******\n");
        System.out.println("***   Keep CAPS LOCK ON during the game   ***");
        System.out.println("\n\n\n");
    }

    // Display start message which returns players input to begin the battle
    public boolean arePlayersReady() {
        // Prompt user to assure they are ready to start battle
        String ready = "N";
        while (!ready.equals("Y")) {
            System.out.println("\n\n\n");
            System.out.println("Are we ready for battle?");
            System.out.print("Type Y to begin: ");
            ready = scanner.nextLine().toUpperCase();
        }
        return true;
    }

    // Add player to list of players. The add character only loops through twice so this list will contain two Characters
    public List<Character> addToPlayerList(List<Character> playerList, Character newCharacter) {
        playerList.add(newCharacter);
        return playerList;
    }

    // Prompts player to choose a character type and this method checks to make sure the input can be converted properly into an int. Returns the valid type back to main
    public int getPlayerCharacterType(int playerNumber) {
        // Initialize type as 0 since user has not put in a character type yet
        int type = 0;
        // Initialize validInfo boolean that loops through prompting the player to input a character type
        boolean validInput = false;
        // Loop continues until validInfo = true (when player enters a valid number that can be converted to int)
        while (validInput == false) {
            try {
                System.out.println("(1) DRAGONBORN\n(2) DWARF\n(3) ELF\n(4) GNOME\n(5) HALFELF\n(6) HALFLING\n(7) HALFORC\n(8) TIEFLING\n(9) HUMAN");
                System.out.print("\nPlayer " + playerNumber + ", please pick a character type from the list above (ENTER NUMBER): ");
                String userInput = scanner.nextLine();
                type = Integer.parseInt(userInput);
                if (type > 0 && type < 10) {
                    validInput = true;
                } else {
                    // Invalid input. Loop continues until player chooses a valid choice
                }
            } catch (NumberFormatException e) {
                // This catches if the player does not enter a valid number String that can be converted to an int
                throw new NumberFormatException("You must enter a number when choosing character type");
            }
        }
        return type;
    }

    // Prompts player for name, and return name back to main
    public String getPlayerCharacterName(int playerNumber) {
        // Prompt player for name and stores it in uppercase
        System.out.print("\nPlayer " + playerNumber + ", please choose a name for your character: ");
        String name = scanner.nextLine().toUpperCase();
        return name;
    }

    public Character timeToBattle() {
        // Round counter that keeps track of which round it is and displays to players. Increments 1 after each loop completes
        int roundCounter = 0;

        // Continues to loop through as long as both players have health over 0
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            roundCounter += 1;
            System.out.println("\n\nROUND " + roundCounter + "!");
            // Player 1's turn
            player1Turn();

            // Player 2's turn as long as they have health over 0
            if (player2.getHealth() > 0 && player1.getHealth() > 0) {
            player2Turn();
            }
        }
        // Return the winner to main method
        if (player1.getHealth() <= 0) {
            return player2;
        } else {
            return player1;
        }
    }

    public void player1Turn() {
        if (player1.willSkipNextTurn()) {
            System.out.println(player1.getName() + " is under a spell. Skipping turn...");
            player1.setSkipNextTurn(false);
        } else {
            String userInput = "N";
            while (!userInput.equals("Y")) {
                System.out.print("\n\n" + player1.getName() + ", you're up! To continue, type Y: ");
                userInput = scanner.nextLine().toUpperCase();
                System.out.println("\n");
            }
            // Show player stats
            player1.printStats();
            // Prompt player to use abilities if available
            player1.promptAbilities(player2);
            // Roll against opponent
            if (player1.getHealth() > 0 && player2.getHealth() > 0) {
                player1.rollAgainst(player2);
            }
        }

    }

    public void player2Turn() {
        if (player2.willSkipNextTurn()) {
            System.out.println(player2.getName() + " is under a spell. Skipping turn...");
            player1.setSkipNextTurn(false);
        } else {
            String userInput = "N";
            while (!userInput.equals("Y")) {
                System.out.print("\n\n" + player2.getName() + ", you're up! To continue, type Y: ");
                userInput = scanner.nextLine().toUpperCase();
                System.out.println("\n");
            }
            // Show player stats
            player2.printStats();
            // Prompt player to use abilities if available
            player2.promptAbilities(player1);
            // Roll against opponent
            if (player1.getHealth() > 0 && player2.getHealth() > 0) {
                player2.rollAgainst(player1);
            }
        }

    }
    }
