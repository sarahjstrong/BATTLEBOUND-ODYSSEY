package com.techelevator;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FBGdriver {
    public static void main(String[] args) {
        // Welcome to the game, add new scanner, and create a list of characters to store each player
        System.out.println("\n\n");
        System.out.println("***** WELCOME TO BATTLEBOUND ODYSSEY *****");
        System.out.println("\n\n");
        Scanner scanner = new Scanner(System.in);
        // Create new character list to store players
        List<Character> playerCharacters = new ArrayList<>();


        // Loop that repeats 2 times (two player game) to prompt player to create a new character by
        // inputting a type and name
        for (int i = 1; i <= 2; i++) {
            // List types of character
            System.out.println("DRAGONBORN | DWARF | ELF | GNOME | HALFELF | HALFLING | HALFORC | TIEFLING | HUMAN");
            System.out.print("\nPlayer " + i + ", please pick a character type from the list above (TYPE IN UPPERCASE): ");
            String type = scanner.nextLine().toUpperCase();
            System.out.println("\nChoose a name for your character (this can be anything): ");
            String name = scanner.nextLine().toUpperCase();

            addPlayer(playerCharacters, type, name, i);

            // Display new character to the player
            Character newPlayer = playerCharacters.get(i-1);

            System.out.println("Player " + i + " is a " + newPlayer.getType() + " named " + newPlayer.getName());
        }


        // Prompt user to assure they are ready to start battle
        System.out.println("\n\n\n");
        System.out.println("Are we ready for battle?");
        System.out.print("Type Y to begin: ");
        String ready = scanner.nextLine().toUpperCase();


        // Hold each player in their own variable to access for each turn.
        Character player1 = playerCharacters.get(0);
        Character player2 = playerCharacters.get(1);

        if (ready.equals("Y")) {
            // Repeat turns until one character is defeated (health reaches 0)
            while (player1.getHealth() > 0 && player2.getHealth() > 0) {
                // Player 1 goes
                System.out.println("\n\nPlayer 1, you're up!\n");
                // Show player stats
                player1.printStats();

                player1.rollAgainst(player2);

                // Player 2 goes
                System.out.println("\n\nPlayer 2, you're up!\n");
                // Show player stats
                player2.printStats();

                player2.rollAgainst(player1);

            }




        } else {
            System.out.println("It's okay if you're not ready... Rest up and come back when you are fit for battle!");
        }


    }

    // Methods
    public static void playerTurn(Character currentPlayer, Character opponent) {
        currentPlayer.rollAgainst(opponent);
    }




    // Add player to the list of Characters.
    public static void addPlayer(List<Character> players, String type, String name, int i) {
        if (i == 1) { // Create player 1 character
            if (type.equals("DRAGONBORN")) {
                Dragonborn player1 = new Dragonborn(type, name);
                players.add(player1);
            } else if (type.equals("DWARF")) {
                Dwarf player1 = new Dwarf(type, name);
                players.add(player1);
            } else if (type.equals("ELF")) {
                Elf player1 = new Elf(type, name);
                players.add(player1);
            } else if (type.equals("GNOME")) {
                Gnome player1 = new Gnome(type, name);
                players.add(player1);
            } else if (type.equals("HALFELF")) {
                Halfelf player1 = new Halfelf(type, name);
                players.add(player1);
            } else if (type.equals("HALFLING")) {
                Halfling player1 = new Halfling(type, name);
                players.add(player1);
            } else if (type.equals("HALFORC")) {
                Halforc player1 = new Halforc(type, name);
                players.add(player1);
            } else if (type.equals("TIEFLING")) {
                Tiefling player1 = new Tiefling(type, name);
                players.add(player1);
            } else if (type.equals("HUMAN")) {
                Human player1 = new Human(type, name);
                players.add(player1);
            } else {
                System.out.println("Input not valid. Please check your spelling and be sure to only use letters. NO SYMBOLS!");
            }

        } else { // Create player 2 character
            if (type.equals("DRAGONBORN")) {
                Dragonborn player2 = new Dragonborn(type, name);
                players.add(player2);
            } else if (type.equals("DWARF")) {
                Dwarf player2 = new Dwarf(type, name);
                players.add(player2);
            } else if (type.equals("ELF")) {
                Elf player2 = new Elf(type, name);
                players.add(player2);
            } else if (type.equals("GNOME")) {
                Gnome player2 = new Gnome(type, name);
                players.add(player2);
            } else if (type.equals("HALFELF")) {
                Halfelf player2 = new Halfelf(type, name);
                players.add(player2);
            } else if (type.equals("HALFLING")) {
                Halfling player2 = new Halfling(type, name);
                players.add(player2);
            } else if (type.equals("HALFORC")) {
                Halforc player2 = new Halforc(type, name);
                players.add(player2);
            } else if (type.equals("TIEFLING")) {
                Tiefling player2 = new Tiefling(type, name);
                players.add(player2);
            } else if (type.equals("HUMAN")) {
                Human player2 = new Human(type, name);
                players.add(player2);
            } else {
                System.out.println("Input not valid. Please check your spelling and be sure to only use letters. NO SYMBOLS!");
            }
        }

    }
}
