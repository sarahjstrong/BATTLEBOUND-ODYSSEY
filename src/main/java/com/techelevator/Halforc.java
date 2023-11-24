package com.techelevator;

public class Halforc extends Character {

    public Halforc(String type, String name) {
        super(type, name);
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is INTIMIDATION!");
        System.out.println(getName() + " scares the opponent making it easier to do more damage in an attack!");
        otherPlayer.setHealth(otherPlayer.getHealth() - 10);
        System.out.println(otherPlayer.getName() + "'s health decreases by 10.");
    }
}
