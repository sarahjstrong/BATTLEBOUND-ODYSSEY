package com.techelevator;

public class Gnome extends Character {

    public Gnome(String name) {
        super("GNOME", name);
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is DARKVISION!");
        System.out.println(getName() + " leads opponent into a dark cave where they can't see you attack!");
        otherPlayer.setHealth(otherPlayer.getHealth() - 10);
        System.out.println(otherPlayer.getName() + "'s health decreases by 10.");
    }
}
