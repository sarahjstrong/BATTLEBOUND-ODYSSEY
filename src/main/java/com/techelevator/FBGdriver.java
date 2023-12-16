package com.techelevator;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FBGdriver {
    // Create new scanner for user input
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Create new instance of FBGDriver
        Battle battle = new Battle();
        // Call displayWelcomeMessage
        battle.displayWelcomeMessage();
        // Create new character list to store players
        List<Character> playerList = new ArrayList<>();

        // Loop that repeats 2 times (two player game) to prompt player to create a new character by
        // inputting a type and name
        // Create new Character that is null
        Character newCharacter = null;
        boolean validInfo = false;
        // Initialize type
        for (int playerNumber = 1; playerNumber <= 2; playerNumber ++) {
            // List types of character
            try {
                // Call getPlayerType which returns the character type as an int
                int type = battle.getPlayerCharacterType(playerNumber);
                // Call getPlayerName method which returns the character's name as a string
                String name = battle.getPlayerCharacterName(playerNumber);
                // Send valid character type and name into addPlayer method which returns the created Character
                newCharacter = battle.createCharacter(type, name);
                // Add Character to list of players. This list will always contain 2 players.
                playerList = battle.addToPlayerList(playerList, newCharacter);
                // Display new character to the player
                System.out.println("Player " + playerNumber + " is a " + newCharacter.getType() + " named " + newCharacter.getName() + "\n\n");
            } catch (NumberFormatException e) {
                // Catch exception thrown in method if player enters a string that can't be parsed into an int
                System.out.println("Invalid choice for character type. Please try again...\n");
            }
        }

        // setPlayer to load battle object with complete character list
        battle.setPlayers(playerList);
        // Hold each player in their own variable to access for each turn.
        Character player1 = battle.getPlayer1();
        Character player2 = battle.getPlayer2();

        if (battle.arePlayersReady() == true) {
            // Repeat turns until one character is defeated (health reaches 0)
            Character winner = battle.timeToBattle();
            System.out.println("\n\n" + winner.getName() + " WINS!\n\nGAME OVER!");

        } else {
            System.out.println("It's okay if you're not ready... Rest up and come back when you are fit for battle!");
        }


    }


}
