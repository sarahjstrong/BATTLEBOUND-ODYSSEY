package com.techelevator;

public class Halfling extends Character {

    public Halfling(String name) {
        super("HALFLING", name);
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is LUCK!");
        System.out.println("Opponent takes a hit but somehow misses and tumbles off a mountain of boulders!");
        otherPlayer.setHealth(otherPlayer.getHealth() - 10);
        System.out.println(otherPlayer.getName() + "'s health decreases by 10.");
    }
}
