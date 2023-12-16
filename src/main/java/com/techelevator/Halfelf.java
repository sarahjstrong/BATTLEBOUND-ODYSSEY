package com.techelevator;

public class Halfelf extends Character {

    public Halfelf(String name) {
        super("HALFELF", name);
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is SPEED!");
        System.out.println(getName() + " bolts to hide and then plants a sneak attack upon the opponent!");
        otherPlayer.setHealth(otherPlayer.getHealth() - 11);
        System.out.println(otherPlayer.getName() + "'s health decreases by 11.");
        setHealth(getHealth() - 1);
        System.out.println("Unfortunately, the running quickly takes a toll on " + getName() + "'s energy level. Health decreases by 1.");
    }
}
