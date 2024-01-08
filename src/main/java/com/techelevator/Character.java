package com.techelevator;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Character {
    static Scanner scanner = new Scanner(System.in);
    private String type;
    private String name;
    private int health = 50;
    private int currentRoll;
    private boolean hasFullHeal = true;
    private boolean hasPowerAttack = true;
    private boolean hasPartialHeal = true;
    private boolean hasSpecialPower = true;
    private boolean skipNextTurn = false;



    // Constructors
    public Character(String type, String name) {
        this.type = type;
        this.name = name;
    }


    // Methods
    public void specialPower(Character otherPlayer) {
        if (hasSpecialPower == true) {
            System.out.println(name + " is using their special power!");
            performSpecialPower(otherPlayer);
            hasSpecialPower = false;
        } else {
            System.out.println(name + " has already used their special power...");
        }
        System.out.println(getName() + "'S health: " + getHealth());
        System.out.println(otherPlayer.getName() + "'S health: " + otherPlayer.getHealth());
    }

    // The following abstract methods differ between each character subclass
    public abstract void performSpecialPower(Character otherPlayer);

    public abstract void powerAttack();

    public abstract void partialHeal();

    public abstract void fullHeal();


    public void rollAgainst(Character otherPlayer) {
        String userInput = "N";
        while (!userInput.equals("Y")) {
            System.out.print("\n" + getName() + ", are you ready to roll? Type Y: ");
            userInput = scanner.nextLine().toUpperCase();
            System.out.println("\n");
        }

            int rollNumber = (int)(Math.floor(Math.random() * 15 + 1));
            if (currentRoll == 0) {
                currentRoll += rollNumber;
                System.out.println("You rolled a " + rollNumber);
                otherPlayer.setHealth(otherPlayer.getHealth() - currentRoll);
                System.out.println("Oof! " + getName() + " attacks " + otherPlayer.getName());
            } else {
                currentRoll += rollNumber;
                System.out.println("You rolled a " + rollNumber + ". After adding your power attack, your current roll is " + currentRoll + ".");
                otherPlayer.setHealth(otherPlayer.getHealth() - currentRoll);
                System.out.println("Ouch! " + getName() + " attacks " + otherPlayer.getName());
            }
            currentRoll = 0;
            System.out.println("\n\n\n");

            // If either characters health is a negative number, it will reset to 0.
            if (health < 0) {
                health = 0;
            }
            System.out.println(getName() + "'S health: " + getHealth());

            if (otherPlayer.getHealth() < 0) {
                otherPlayer.setHealth(0);
            }
            System.out.println(otherPlayer.getName() + "'S health: " + otherPlayer.getHealth());

    }

    public void promptAbilities(Character otherPlayer) {
        if (hasFullHeal || hasPartialHeal || hasPowerAttack || hasSpecialPower){
            String userInput = "";

            while (!userInput.equals("FH") && !userInput.equals("PH") && !userInput.equals("PA") && !userInput.equals("SP") && !userInput.equals("N")
                    || (userInput.equals("FH") && hasFullHeal == false) || (userInput.equals("PH") && hasPartialHeal == false) || (userInput.equals("PA") && hasPowerAttack == false)
            || (userInput.equals("SP") && hasSpecialPower == false)) {
                System.out.println("To not use any abilities this turn, type N");

                System.out.print("What would " + getName() + " like to do?: ");
                userInput = scanner.nextLine().toUpperCase();
                System.out.println("\n");
            }

            if (userInput.equals("FH") && hasFullHeal == true) {
                fullHeal();
            } else if (userInput.equals("PH") && hasPartialHeal == true) {
                partialHeal();
            } else if (userInput.equals("PA") && hasPowerAttack) {
                powerAttack();
            } else if (userInput.equals("SP") && hasSpecialPower == true) {
                specialPower(otherPlayer);
            } else if (userInput.equals("N")){
                System.out.println(getName() + " decided not to use special abilities.");
            } else {
                System.out.println(getName() + " used all their special abilities");
            }


        } else {
            System.out.println("You have used all your special abilities...");
        }

    }



    // Getters / Setters


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public void setCurrentRoll(int currentRoll) {
        this.currentRoll = currentRoll;
    }

    public boolean isHasFullHeal() {
        return hasFullHeal;
    }

    public void setHasFullHeal(boolean hasFullHeal) {
        this.hasFullHeal = hasFullHeal;
    }

    public boolean isHasPowerAttack() {
        return hasPowerAttack;
    }

    public void setHasPowerAttack(boolean hasPowerAttack) {
        this.hasPowerAttack = hasPowerAttack;
    }

    public boolean isHasPartialHeal() {
        return hasPartialHeal;
    }

    public void setHasPartialHeal(boolean hasPartialHeal) {
        this.hasPartialHeal = hasPartialHeal;
    }

    public boolean isHasSpecialPower() {
        return hasSpecialPower;
    }

    public void setHasSpecialPower(boolean hasSpecialPower) {
        this.hasSpecialPower = hasSpecialPower;
    }

    public boolean willSkipNextTurn() {
        return skipNextTurn;
    }

    public void setSkipNextTurn(boolean skipNextTurn) {
        this.skipNextTurn = skipNextTurn;
    }


    public void printStats() {
        System.out.println(getName() + "'S health = " + getHealth() + ".");
        System.out.println("\nAvailable abilities: ");
        System.out.println("*These are added to current turn. You roll after performing an ability*");
        if (hasFullHeal == true) {
            if (type.equals("HUMAN")) {
                System.out.println("FULL HEAL (45) - type FH");
            } else if (type.equals("DRAGONBORN") || type.equals("HALFORC") || type.equals("TIEFLING")) {
                System.out.println("FULL HEAL (60) - type FH");
            } else {
                System.out.println("FULL HEAL (50) - type FH");
            }
        } else {
            // Nothing prints to console
        }
        if (hasPartialHeal == true) {
            if (type.equals("HUMAN")) {
                System.out.println("PARTIAL HEAL (+12 health) - type PH");
            } else if (type.equals("HALFLING") || type.equals("ELF") || type.equals("HALFELF")) {
                System.out.println("PARTIAL HEAL (+15 health) - type PH");
            } else {
                System.out.println("PARTIAL HEAL (+10 health) - type PH");
            }
        } else {
            // Nothing prints to console
        }
        if (hasPowerAttack == true) {
            if (type.equals("HUMAN")) {
                System.out.println("POWER ATTACK (+8 roll) - type PA");
            } else if (type.equals("DWARF") || type.equals("GNOME")) {
                System.out.println("POWER ATTACK (+10 roll) - type PA");
            } else {
                System.out.println("POWER ATTACK (+5 roll) - type PA");
            }
        } else {
            // Nothing prints to the console
        }
        if (hasSpecialPower == true) {
            System.out.println("SPECIAL POWER - type SP ");
        } else {
            // Nothing prints to the console
        }
        if (hasFullHeal == false && hasPartialHeal == false && hasPowerAttack == false && hasSpecialPower == false) {
            System.out.println("NONE");
        } else {
            // Nothing prints to the console
        }

    }

}


