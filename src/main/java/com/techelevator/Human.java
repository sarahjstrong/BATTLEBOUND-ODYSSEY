package com.techelevator;

public class Human extends Character {

    public Human(String type, String name) {
        super(type, name);
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is POLYGLOTISM!");
        System.out.println("Polyglotism is the ability to use many languages for communication.");
        System.out.println("This catches the opponent by surprise. " + getName() + " and " + otherPlayer.getName() + " have banter back and forth, giving them both time to heal.");
        System.out.println(getName() + "'s health increases by 12.");
        if (getHealth() <= 40) {
            setHealth(getHealth() + 10);
        } else {
            setHealth(50);
        }
        System.out.println(otherPlayer.getName() + "'s health increases by 2.");
        if (otherPlayer.getHealth() <= 48) {
            otherPlayer.setHealth(otherPlayer.getHealth() + 2);
        } else {
            otherPlayer.setHealth(50);
        }

    }
}
