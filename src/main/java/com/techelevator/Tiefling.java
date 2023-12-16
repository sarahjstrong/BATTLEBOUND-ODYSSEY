package com.techelevator;

public class Tiefling extends Character {

    public Tiefling(String name) {
        super("TIEFLING", name);
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is MISDIRECTION!");
        System.out.println("A spell is used against the opponent! They are tricked into missing their next turn...");
        otherPlayer.setSkipNextTurn(true);
        System.out.println(otherPlayer.getName() + " will forget to attack on next turn.");
        System.out.println("Without an attack from the opponent next turn, " + getName() + " is able to heal. Health increases by 4.");
        if (getHealth() <= 46) {
            setHealth(getHealth() + 4);
        } else {
            setHealth(50);
        }
    }
}
