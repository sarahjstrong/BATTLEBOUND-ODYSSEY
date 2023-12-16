package com.techelevator;

public class Dragonborn extends Character {

    public Dragonborn(String name) {
        super("DRAGONBORN", name);
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is FIRE!");
        System.out.println("Fire engulfs opponent. That looks like it hurts!");
        otherPlayer.setHealth(otherPlayer.getHealth() - 10);
        System.out.println(otherPlayer.getName() + "'s health decreases by 10.");
    }
}
