package com.techelevator;

import java.util.List;
import java.util.Random;

public abstract class Character {
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
        System.out.println(getName() + "'s health: " + getHealth());
        System.out.println(otherPlayer.getName() + "'s health: " + otherPlayer.getHealth());
    }

    public abstract void performSpecialPower(Character otherPlayer);
    // This varies for each character subclass

    public void fullHeal() {
        if (hasFullHeal == true) {
            health = 50;
            System.out.println(name + " has used their full heal!");
            hasFullHeal = false;
        } else {
            System.out.println(name + " has already used their full heal.");
        }
        System.out.println(getName() + "'s health: " + getHealth());
    }

    public void powerAttack() {
        if (hasPowerAttack == true) {
            currentRoll += 5;
            System.out.println(name + " used power attack! 5 will be added to next roll.");
            hasPowerAttack = false;
        } else {
            System.out.println(name + " already used their power attack.");
        }
    }

    public void partialHeal() {
        if (hasPartialHeal == true) {
            if (health <= 40) {
                health += 10;
            } else {
                health = 50;
            }
            hasPartialHeal = false;
            System.out.println(name + " used their partial heal!");
        } else {
            System.out.println(name + " already used their partial health.");
        }
        System.out.println(getName() + "'s health: " + getHealth());
    }

    public void rollAgainst(Character otherPlayer) {
        Random random = new Random();
        int rollNumber = random.nextInt(7);
        if (currentRoll == 0) {
            currentRoll += rollNumber;
            System.out.println("You rolled a " + rollNumber);
            otherPlayer.setHealth(otherPlayer.getHealth() - currentRoll);
            System.out.println("Oof!");
        } else {
            currentRoll += rollNumber;
            System.out.println("You rolled a " + rollNumber + " and after roll additions/subtractions your current roll is " + currentRoll);
            otherPlayer.setHealth(otherPlayer.getHealth() - currentRoll);
            System.out.println("Ouch!");
        }
        currentRoll = 0;
        System.out.println(getName() + "'s health: " + getHealth());
        System.out.println(otherPlayer.getName() + "'s health: " + otherPlayer.getHealth());
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

    public boolean isHasPowerAttack() {
        return hasPowerAttack;
    }

    public boolean isHasPartialHeal() {
        return hasPartialHeal;
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
        System.out.println(getName() + "'s health is at " + getHealth() + ".");
        if (hasFullHeal == true) {
            System.out.println("You have 1 FULL HEAL left!");
        } else {
            // Nothing prints to console
        }
        if (hasPartialHeal == true) {
            System.out.println("You have 1 PARTIAL HEAL left! Use it to increase health by 10");
        } else {
            // Nothing prints to console
        }
        if (hasPowerAttack == true) {
            System.out.println("You have 1 POWER ATTACK left! Use it to add 5 to your roll.");
        } else {
            // Nothing prints to the console
        }
        if (hasSpecialPower == true) {
            System.out.println("You can still use character type's unique SPECIAL POWER! Use this once per game.");
        } else {
            // Nothing prints to the console
        }
        if (hasFullHeal == false && hasPartialHeal == false && hasPowerAttack == false && hasSpecialPower == false) {
            System.out.println("You have used all of your abilities.");
        } else {
            // Nothing prints to the console
        }

    }

}


