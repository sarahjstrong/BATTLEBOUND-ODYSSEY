package com.techelevator;

public class Tiefling extends Character {

    public Tiefling(String name) {
        super("TIEFLING", name);
        setHealth(60);
    }

    @Override
    public void powerAttack() {
        if (isHasPowerAttack() == true) {
            setCurrentRoll(5);
            System.out.println(getName() + " used power attack! 5 will be added to next roll.");
            setHasPowerAttack(false);
        } else {
            System.out.println(getName() + " already used their power attack.");
        }
    }

    @Override
    public void fullHeal() {
        if (isHasFullHeal() == true) {
            setHealth(60);
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
            if (getHealth() <= 50) {
                setHealth(getHealth() + 10);
            } else {
                setHealth(60);
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
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is MISDIRECTION!");
        System.out.println("A spell is used against the opponent! They will miss their next turn...");
        otherPlayer.setSkipNextTurn(true);
        System.out.println(otherPlayer.getName() + " will forget to attack during their next turn.");
        System.out.println("Without an attack from the opponent next turn, " + getName() + " is able to heal. Health increases by 4.");
        if (getHealth() <= 56) {
            setHealth(getHealth() + 4);
        } else {
            setHealth(60);
        }
    }
}
