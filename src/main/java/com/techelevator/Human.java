package com.techelevator;

public class Human extends Character {

    public Human(String name) {
        super("HUMAN", name);
        setHealth(45);
    }

    @Override
    public void powerAttack() {
        if (isHasPowerAttack() == true) {
            setCurrentRoll(8);
            System.out.println(getName() + " used power attack! 8 will be added to next roll.");
            setHasPowerAttack(false);
        } else {
            System.out.println(getName() + " already used their power attack.");
        }
    }

    @Override
    public void fullHeal() {
        if (isHasFullHeal() == true) {
            setHealth(45);
            System.out.println(getName() + " has used their full heal!");
            setHasFullHeal(false);
        } else {
            System.out.println(getName() + " has already used their full heal.");
        }
        System.out.println(getName() + "'S health: " + getHealth());
    }
    @Override
    public void partialHeal() {
        if (isHasPartialHeal() == true) {
            if (getHealth() <= 33) {
                setHealth(getHealth() + 12);
            } else {
                setHealth(45);
            }
            setHasPartialHeal(false);
            System.out.println(getName() + " used their partial heal!");
        } else {
            System.out.println(getName() + " already used their partial health.");
        }
        System.out.println(getName() + "'S health: " + getHealth());
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is POLYGLOTISM!");
        System.out.println("Polyglotism is the ability to use many languages for communication.");
        System.out.println("This catches the opponent by surprise. " + getName() + " and " + otherPlayer.getName() + " banter back and forth, giving them both time to heal.");
        System.out.println(getName() + "'s health increases by 12.");
        if (getHealth() <= 38) {
            setHealth(getHealth() + 12);
        } else {
            setHealth(45);
        }
        System.out.println(otherPlayer.getName() + "'s health increases by 2.");
        if (otherPlayer.getType().equals("HUMAN")) {
            if (otherPlayer.getHealth() <= 43) {
                otherPlayer.setHealth(otherPlayer.getHealth() + 2);
            } else {
                otherPlayer.setHealth(45);
            }
        } else if (otherPlayer.getType().equals("DRAGONBORN") || otherPlayer.getType().equals("HALFORC") || otherPlayer.getType().equals("TIEFLING")) {
            if (otherPlayer.getHealth() <= 58) {
                otherPlayer.setHealth(otherPlayer.getHealth() + 2);
            } else {
                otherPlayer.setHealth(60);
            }
        } else {
            if (otherPlayer.getHealth() <= 48) {
                otherPlayer.setHealth(otherPlayer.getHealth() + 2);
            } else {
                otherPlayer.setHealth(50);
            }
        }

    }
}
