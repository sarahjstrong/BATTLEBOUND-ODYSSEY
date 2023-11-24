package com.techelevator;

public class Elf extends Character {

    public Elf(String type, String name) {
        super(type, name);
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is MEDITATION!");
        System.out.println(getName() + " takes a very quick meditation break. Health increases by 10!");
        if (getHealth() <= 40) {
            setHealth(getHealth() + 10);
        } else {
            setHealth(50);
        }
    }

}
