package com.techelevator;

public class Dwarf extends  Character {

    public Dwarf(String type, String name) {
        super(type, name);
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is the BATTLEAXE!");
        System.out.println("Opponent takes the mighty hit of the battleaxe!");
        otherPlayer.setHealth(otherPlayer.getHealth() - 12);
        System.out.println(otherPlayer.getName() + "'s health decreases by 12.");
        setHealth(getHealth() - 2);
        System.out.println("Unfortunately, the battleaxe is extremely heavy and " + getName() + "'s health also decreases by 2.");

    }
}
